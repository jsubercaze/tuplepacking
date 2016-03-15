package org.jsubercaze.bitmanip;

/**
 * Common bit storage interface for both signed and unsigned integers.
 * 
 * @author Julien Subercaze
 *
 */
interface BitStorageI {
	/**
	 * 
	 * @param index
	 *            the number of the field to store the <code>value</code>
	 * @param value
	 *            the value to be stored
	 * @param storage
	 *            the long used to store the value
	 * @return <code>storage</code> with the <code>index</code>-th field set to
	 *         <code>value</code>
	 */
	public long set(int index, long value, long storage);

	/**
	 * Same as {@link #set(int, long, long)} without checks; higher performance
	 * at the cost of safety. Use this method at your own risk.
	 * 
	 * @param index
	 *            the number of the field to store the <code>value</code>
	 * @param value
	 *            the value to be stored
	 * @param storage
	 *            the long used to store the value
	 * @return <code>storage</code> with the <code>index</code>-th field set to
	 *         <code>value</code>
	 */
	public long setQuick(int index, long value, long storage);

	/**
	 * 
	 * @param array
	 *            array containing the long to be modified
	 * @param arrayIndex
	 *            index of the long to be modified
	 * @param index
	 *            the number of the field to store the <code>value</code>
	 * @param value
	 *            the value to be stored
	 */
	public void set(long[] array, int arrayIndex, int index, long value);

	/**
	 * Same as {@link #set(long[], int, int, long)} without checks; higher
	 * performance at the cost of safety. Use this method at your own risk.
	 * 
	 * @param array
	 *            array containing the long to be modified
	 * @param arrayIndex
	 *            index of the long to be modified
	 * @param index
	 *            the number of the field to store the <code>value</code>
	 * @param value
	 *            the value to be stored
	 */
	public void setQuick(long[] array, int arrayIndex, int index, long value);

	/**
	 * 
	 * @param index
	 *            index of the fields in the long
	 * 
	 * @param storage
	 *            long used for storage
	 * 
	 * @return the long value stored in the field <code>index</code> in
	 *         <code>storage</code>
	 */
	public long get(int index, long storage);

	/**
	 * 
	 * @param index
	 *            index of the fields in the long
	 * 
	 * @param storage
	 *            long used for storage
	 * 
	 * @return the int value stored in the field <code>index</code> in
	 *         <code>storage</code>
	 */
	public int getInt(int index, long storage);

	/**
	 * Similar to {@link #get(int, long)} without checks; higher performance at
	 * the cost of safety. Use this method at your own risk.
	 * 
	 * @param index
	 *            index of the fields in the long
	 * 
	 * @param storage
	 *            long used for storage
	 * 
	 * @return the long value stored in the field <code>index</code> in
	 *         <code>storage</code>
	 */
	public long getQuickLong(int index, long storage);

	/**
	 * Similar to {@link #getInt(int, long)} without checks; higher performance
	 * at the cost of safety. Use this method at your own risk.
	 * <p>
	 * Using this method on field with more than 32 bits will result in silent
	 * data truncation
	 * </p>
	 * 
	 * @param index
	 *            index of the fields in the long
	 * @param storage
	 *            long used for storage
	 * @return the int value stored in the field <code>index</code> in
	 *         <code>storage</code>
	 */
	public int getQuickInt(int index, long storage);

	public long getLong(long[] array, int arrayIndex, int index);

	public int getInt(long[] array, int arrayIndex, int index);

	public long getQuickLong(long[] array, int arrayIndex, int index);

	public int getQuickInt(long[] array, int arrayIndex, int index);
}
