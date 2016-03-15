package org.jsubercaze.bitmanip;

interface BitStorageI {

	public long setLong(int index, long value, long storage);

	public long setInt(int index, int value, long storage);

	public long setQuickLong(int index, long value, long storage);

	public long setQuickInt(int index, long value, long storage);

	public void setLong(long[] array, int arrayIndex, int index, long value);

	public void setInt(long[] array, int arrayIndex, int index, long value);

	public void setQuickLong(long[] array, int arrayIndex, int index, long value);

	public void setQuickInt(long[] array, int arrayIndex, int index, long value);

	public long getLong(int index, long storage);

	public int getInt(int index, long storage);

	public long getQuickLong(int index, long storage);

	public int getQuickInt(int index, long storage);

	public long getLong(long[] array, int arrayIndex, int index);

	public int getInt(long[] array, int arrayIndex, int index);

	public long getQuickLong(long[] array, int arrayIndex, int index);

	public int getQuickInt(long[] array, int arrayIndex, int index);
}
