package project;

/**
 * @author jstanley
 * A null iterator implementation of GlyphIterator.
 */
public class NullIterator implements GlyphIterator {

	/* (non-Javadoc)
	 * @see project.GlyphIterator#first()
	 */
	@Override
	public void first() {
		// Does nothing.
	}

	/* (non-Javadoc)
	 * @see project.GlyphIterator#next()
	 */
	@Override
	public void next() {
		// Does nothing.
	}

	/* (non-Javadoc)
	 * @see project.GlyphIterator#isDone()
	 */
	@Override
	public boolean isDone() {
		return true;
	}

	/* (non-Javadoc)
	 * @see project.GlyphIterator#currentItem()
	 */
	@Override
	public Glyph currentItem() {
		return null;
	}

}
