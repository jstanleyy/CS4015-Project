package project;

/**
 * @author jstanley
 * Defines a Column, which will have Rows as children.
 */
public class Column extends Glyph {

	/**
	 *  A GoFList containing the children of this Column.
	 */
	private GoFList children = new GoFListAdapter();
	
	/* (non-Javadoc)
	 * @see project.Glyph#getValue()
	 */
	@Override
	public String getValue() {
		String val = "";
		for(int i = 0; i < this.children.count(); i++) {
			val += this.children.getAt(i).getValue();
		}
		
		return val;
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

	/* (non-Javadoc)
	 * @see project.Glyph#createIterator()
	 */
	@Override
	public GlyphIterator createIterator() {
		return new ListIterator(this.children);
	}

	/* (non-Javadoc)
	 * @see project.Glyph#accept(project.GlyphVisitor)
	 */
	@Override
	public void accept(GlyphVisitor visitor) {
		visitor.visitColumn(this);
	}

}
