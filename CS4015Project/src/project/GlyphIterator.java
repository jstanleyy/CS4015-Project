package project;

/**
 * @author jstanley
 * Defines an interface for Glyph iterators.
 */
public interface GlyphIterator {
	
	/**
	 * Resets the iterator to the first element in the tree.
	 */
	public void first();
	
	/**
	 * Sets the current item to be the next element in the tree.
	 */
	public void next();
	
	/**
	 * Returns whether or not all the elements of the tree have been travered.
	 * @return True if all the elements of the tree has been traversed.
	 */
	public boolean isDone();
	
	/**
	 * Returns the current item in the tree.
	 * @return The current item in the tree.
	 */
	public Glyph currentItem();

}
