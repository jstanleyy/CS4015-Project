package project;

/**
 * @author jstanley
 * Defines a Row, which will have children of different types of Glyphs.
 */
public class Row extends Glyph {
	
	/**
	 * A GoFList containing the children of this Row.
	 */
	private GoFList children = new GoFListAdapter();
	
	/* (non-Javadoc)
	 * @see project.Glyph#printValue()
	 */
	@Override
	public void printValue() {
		for(int i = 0; i < this.children.count(); i++) {
			this.children.getAt(i).printValue();
		}
		System.out.println(); // End of row
	}
	
	/* (non-Javadoc)
	 * @see project.Glyph#addChild(project.Glyph)
	 */
	public void addChild(Glyph child) {
		this.children.append(child);
	}
	
	/* (non-Javadoc)
	 * @see project.Glyph#removeChild(project.Glyph)
	 */
	public void removeChild(Glyph child) {
		this.children.delete(child);
	}

	/* (non-Javadoc)
	 * @see project.Glyph#getChild(int)
	 */
	public Glyph getChild(int index) {
		return this.children.getAt(index);
	}
	
	/* (non-Javadoc)
	 * @see project.Glyph#numberOfChildren()
	 */
	public int numberOfChildren() {
		return this.children.count();
	}
}
