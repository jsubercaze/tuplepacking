package org.jsubercaze.bitmanip;

/**
 * Stores several unsigned ints into a long using bitwise operators.
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
		// Precompute the masks
		int pos = 0;
		for (int i = 0; i < params.length; i++) {
			long tmp = 0;
			// Compute the mask
			for (int j = pos; j < pos + params[i]; j++) {
				tmp = tmp | (1L << j);
			}
			pos += params[i];
			masks[i] = tmp;
			System.out.println(masks[i]);
			// Compute the bound
			bounds[i] = (1L << (params[i]));
			System.out.println(bounds[i]);
			System.out.println("----");
		}

	}

	public void set(int index, int value) {

	}

	@Override
	public void setLong(int index, long value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInt(int index, long value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setQuickLong(int index, long value) {
		//

	}

	@Override
	public void setQuickInt(int index, long value) {
		// TODO Auto-generated method stub

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
	public long getLong(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInt(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getQuickLong(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getQuickInt(int index) {
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
