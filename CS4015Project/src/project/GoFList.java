package project;

/**
 * @author jstanley
 * Defines a interface for a list data structure. 
 */
public interface GoFList {
	
	/**
	 * Returns the number of elements in the list.
	 * @return Number of elements in the list.
	 */
	public int count();
	
	/**
	 * Returns the element at the given index.
	 * @param index The index of the element to be returned.
	 * @return The element at the given index.
	 */
	public Object getAt(int index);
	
	/**
	 * Returns the first element of the list.
	 * @return The first element of the list.
	 */
	public Object first();
	
	/**
	 * Returns the last element of the list
	 * @return The last element of the list.
	 */
	public Object last();
	
	/**
	 * Returns whether or not x is in the list.
	 * @param x The element to be checked for.
	 * @return Whether or not x is in the list.
	 */
	public boolean include(Glyph x);
	
	/**
	 * Adds x to the end of the list.
	 * @param x The element to be added.
	 */
	public void append(Glyph x);
	
	/**
	 * Adds x to the beginning of the list.
	 * @param x The element to be added.
	 */
	public void prepend(Glyph x);
	
	/**
	 * Removes the first appearance of x from the list.
	 * @param x The element to be removed.
	 */
	public void delete(Glyph x);
	
	/**
	 * Removes the first element from the list.
	 */
	public void deleteFirst();
	
	/**
	 * Removes all the elements from the list.
	 */
	public void deleteAll();
	
	/**
	 * Replaces the element at the given index by x.
	 * @param index The index of the element to be replaced.
	 * @param x The element that will be added to the list.
	 */
	public void replace(int index, Glyph x);
}
