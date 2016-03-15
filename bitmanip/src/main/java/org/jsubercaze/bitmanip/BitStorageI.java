package org.jsubercaze.bitmanip;

interface BitStorageI {

	public void setLong(int index, long value);

	public void setInt(int index, long value);

	public void setQuickLong(int index, long value);

	public void setQuickInt(int index, long value);

	public void setLong(long[] array, int arrayIndex, int index, long value);

	public void setInt(long[] array, int arrayIndex, int index, long value);

	public void setQuickLong(long[] array, int arrayIndex, int index, long value);

	public void setQuickInt(long[] array, int arrayIndex, int index, long value);

	public long getLong(int index);

	public int getInt(int index);

	public long getQuickLong(int index);

	public int getQuickInt(int index);

	public long getLong(long[] array, int arrayIndex, int index);

	public int getInt(long[] array, int arrayIndex, int index);

	public long getQuickLong(long[] array, int arrayIndex, int index);

	public int getQuickInt(long[] array, int arrayIndex, int index);
}
