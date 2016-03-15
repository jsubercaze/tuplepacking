package org.jsubercaze.bitmanip;

/**
 * Stores multiple unsigned ints into a long using bitwise operators.
 * 
 * 
 * 
 * 
 * 
 * 
 * @author Julien
 *
 */
public class UIntIntoLong extends AbstractBitStorage implements BitStorageI {
	/**
	 * Precomputed masks to access the fields
	 */
	final long[] masks;
	/**
	 * Shifts in number of bits per field
	 */
	final int[] shifts;
	/**
	 * Bounds for checking
	 */
	final long[] bounds;

	public UIntIntoLong(int... params) {
		int sum = 0;
		for (int i = 0; i < params.length; i++) {
			sum += params[i];
		}
		if (sum != 64) {
			throw new IllegalArgumentException("Total of the bits per int must match 64, actually: " + sum);
		}
		masks = new long[params.length];
		bounds = new long[params.length];
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
			// Store shift
			shifts[i] = shift;
			shift += params[i];
			// Compute the bound
			bounds[i] = (1L << (params[i]));
		}

	}

	private void checkbounds(int index, long value) {
		checkgetbounds(index);
		if (value >= bounds[index]) {
			throw new IllegalArgumentException("Value is out of bound " + value + " ; bound:" + bounds[index]);
		}

	}

	private void checkgetbounds(int index) {
		if (index >= masks.length) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}

	@Override
	public long setLong(int index, long value, long storage) {
		checkbounds(index, value);
		return setQuickLong(index, value, storage);
	}

	@Override
	public long setInt(int index, int value, long storage) {
		return setLong(index, (long) value, storage);
	}

	@Override
	public long setQuickLong(int index, long value, long storage) {
		long mask = ~masks[index];
		// Keep the other fields but reset this one
		storage = storage & (mask);
		// Shift the current value to enter the storage
		int shift = shifts[index];
		long newval = value << shift;
		storage = storage | newval;
		return storage;
	}

	@Override
	public long setQuickInt(int index, long value, long storage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLong(long[] array, int arrayIndex, int index, long value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInt(long[] array, int arrayIndex, int index, long value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setQuickLong(long[] array, int arrayIndex, int index, long value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setQuickInt(long[] array, int arrayIndex, int index, long value) {
		// TODO Auto-generated method stub

	}

	@Override
	public long getLong(int index, long storage) {
		checkgetbounds(index);
		return 0;
	}

	@Override
	public int getInt(int index, long storage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getQuickLong(int index, long storage) {
		long val = storage & masks[index];
		val = val >> shifts[index];
		return val;
	}

	@Override
	public int getQuickInt(int index, long storage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getLong(long[] array, int arrayIndex, int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInt(long[] array, int arrayIndex, int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getQuickLong(long[] array, int arrayIndex, int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getQuickInt(long[] array, int arrayIndex, int index) {
		// TODO Auto-generated method stub
		return 0;
	}

}
