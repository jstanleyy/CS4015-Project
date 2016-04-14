package project;

/**
 * @author jstanley
 * A decorator class that will be used for adding HTML tags to characters.
 */
public abstract class GlyphDecorator extends Glyph {

	/**
	 * The Glyph to be decorated.
	 */
	private Glyph glyph;
	
	/**
	 * Sets the object to be decorated.
	 * @param decoratee The Glyph to be decorated
	 */
	public GlyphDecorator(Glyph decoratee) {
		this.glyph = decoratee;
	}
	
	/* (non-Javadoc)
	 * @see project.Glyph#getValue()
	 */
	@Override
	public String getValue() {
		return this.glyph.getValue();
	}
	
	/* (non-Javadoc)
	 * @see project.Glyph#addChild(project.Glyph)
	 */
	public void addChild(Glyph child) {
		this.glyph.addChild(child);
	}
	
	/* (non-Javadoc)
	 * @see project.Glyph#removeChild(project.Glyph)
	 */
	public void removeChild(Glyph child) {
		this.glyph.removeChild(child);
	}
	
	/* (non-Javadoc)
	 * @see project.Glyph#getChild(int)
	 */
	public Glyph getChild(int index) {
		return this.glyph.getChild(index);
	}
	
	/* (non-Javadoc)
	 * @see project.Glyph#numberOfChildren()
	 */
	public int numberOfChildren() {
		return this.glyph.numberOfChildren();
	}

}
