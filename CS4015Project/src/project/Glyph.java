package project;

/**
 * @author jstanley
 * Defines the parent class of all other elements of the data structure.
 */
public abstract class Glyph {
	
	/**
	 * Returns the value of the glyph.
	 * @return The value of the glyph.
	 */
	public abstract String getValue();
	
	/**
	 * Adds the given child to the end of the children list.
	 * @param child The Glyph to be added as a child.
	 */
	public void addChild(Glyph child) {
		// Do nothing.
	}
	
	/**
	 * Removes the given child from the chilren list.
	 * @param child The Glyph to be removed from the children list.
	 */
	public void removeChild(Glyph child) {
		// Do nothing.
	}
	
	/**
	 * Returns the child from the children list at the given index.
	 * @param index The index of the requested child.
	 * @return The child at the given index.
	 */
	public Glyph getChild(int index) {
		return null;
	}
	
	/**
	 * Returns the length of the children list.
	 * @return Length of the children list.
	 */
	public int numberOfChildren() {
		return 0;
	}
	
	/**
	 * Creates the appropriate type of iterator, depending on the type of Glyph.
	 * @return A ListIterator object.
	 */
	public abstract GlyphIterator createIterator();
}
