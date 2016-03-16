package org.jsubercaze.bitmanip;

/**
 * Stores multiple signed ints into a long using bitwise operators.
 * 
 * @author Julien Subercaze
 *
 */
public class IntStorage64 extends AbstractBitStorage implements BitStorageI {
	/**
	 * Precomputed masks to access the fields
	 */
	final long[] masks;
	final long[] masksSign;
	final int[] masksSignInt;

	/**
	 * Shifts in number of bits per field
	 */
	final int[] shifts;
	/**
	 * Bounds for checking
	 */
	final long[] boundsHigh;
	final long[] boundsLow;

	/**
	 * The total number of bits per field must be 64, otherwise an
	 * {@link IllegalArgumentException} is raised
	 * 
	 * @param params
	 *            the number of bits for each field.
	 */
	public IntStorage64(int... params) {
		int sum = 0;
		for (int i = 0; i < params.length; i++) {
			sum += params[i];
		}
		if (sum != 64) {
			throw new IllegalArgumentException("Total of the bits per int must match 64, actually: " + sum);
		}
		masks = new long[params.length];
		masksSign = new long[params.length];
		masksSignInt = new int[params.length];
		boundsHigh = new long[params.length];
		boundsLow = new long[params.length];
		shifts = new int[params.length];
		int pos = 0;
		int shift = 0;
		for (int i = 0; i < params.length; i++) {
			long tmp = 0;
			// Compute the mask
			for (int j = pos; j < pos + params[i]; j++) {
				tmp = tmp | (1L << j);
			}
			pos += params[i];
			masks[i] = tmp;
			// Compute the mask see
			// https://graphics.stanford.edu/~seander/bithacks.html#VariableSignExtend
			masksSign[i] = 1L << (params[i] - 1);
			masksSignInt[i] = 1 << (params[i] - 1);
			// Store shift
			shifts[i] = shift;
			shift += params[i];
			// Compute the bound
			boundsHigh[i] = (1L << (params[i]));
			boundsLow[i] = ~boundsHigh[i];
		}

	}

	private void checkbounds(int index, long value) {
		checkgetbounds(index);
		if (value >= boundsHigh[index] || value < boundsLow[index]) {
			throw new IllegalArgumentException("Value is out of bound " + value + " ; interval: [" + boundsLow[index]
					+ "," + (boundsHigh[index] - 1) + "]");
		}

	}

	private void checkgetbounds(int index) {
		if (index >= masksSign.length) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}

	@Override
	public long set(int index, long value, long storage) {
		checkbounds(index, value);
		return setQuick(index, value, storage);
	}

	@Override
	public long setQuick(int index, long value, long storage) {
		long mask = ~masks[index];
		// Keep the other fields but reset this one
		storage = storage & (mask);
		// Value shall not overwrite other bits
		long newval = (value << shifts[index]) & masks[index];
		// Store
		storage = storage | newval;
		return storage;
	}

	@Override
	public void set(long[] array, int arrayIndex, int index, long value) {
		array[arrayIndex] = set(index, value, array[arrayIndex]);
	}

	@Override
	public void setQuick(long[] array, int arrayIndex, int index, long value) {
		array[arrayIndex] = setQuick(index, value, array[arrayIndex]);

	}

	@Override
	public long get(int index, long storage) {
		checkgetbounds(index);
		return 0;
	}

	@Override
	public int getInt(int index, long storage) {
		// TODO
		return -1;
	}

	@Override
	public long getQuick(int index, long storage) {
		long val = storage & masks[index];
		val = val >>> shifts[index];
		val = (val ^ masksSign[index]) - masksSign[index];
		return val;
	}

	@Override
	public int getQuickInt(int index, long storage) {
		return (int) getQuick(index, storage);
	}

	@Override
	public long getLong(long[] array, int arrayIndex, int index) {
		return get(index, array[arrayIndex]);
	}

	@Override
	public int getInt(long[] array, int arrayIndex, int index) {
		return getInt(index, array[arrayIndex]);
	}

	@Override
	public long getQuickLong(long[] array, int arrayIndex, int index) {
		return getQuick(index, array[arrayIndex]);

	}

	@Override
	public int getQuickInt(long[] array, int arrayIndex, int index) {
		return getQuickInt(index, array[arrayIndex]);
	}

}
