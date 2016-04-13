package project;

/**
 * @author jstanley
 * Used for adding HTML tags.
 */
public class HTMLTag extends GlyphDecorator {

	/**
	 * Creates a HTMLTag decorator.
	 * @param decoratee The Glyph to be decorated.
	 */
	public HTMLTag(Glyph decoratee) {
		super(decoratee);
	}
	
	/* (non-Javadoc)
	 * @see project.GlyphDecorator#printValue()
	 */
	public void printValue() {
		System.out.println("<HTML>");
		super.printValue();
		System.out.println("</HTML>");
	}
}
