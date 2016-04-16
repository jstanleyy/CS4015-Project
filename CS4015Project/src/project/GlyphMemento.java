package project;

/**
 * @author jstanley
 * Used for creating a snapshot of the tree at a certain time.
 */
public class GlyphMemento {

	/**
	 * The root of the tree.
	 */
	private Glyph root;
	
	/**
	 * Returns the tree as it was when this memento was created.
	 * @return The root of the tree.
	 */
	public Glyph getState() {
		return this.root;
	}
	
	/**
	 * Sets the tree to the given one.
	 * @param in The root that needs to be saved.
	 */
	public void setState(Glyph in) {
		this.root = in;
	}
}
