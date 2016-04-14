package project;

/**
 * @author jstanley
 * A list iterator implementation of GlyphIterator.
 */
public class ListIterator implements GlyphIterator {

	/**
	 * The list to be iterated over.
	 */
	private GoFList list;
	
	/**
	 * The position of the current element in the list.
	 */
	private int index;
	
	/**
	 * Creates a ListIterator and sets the list to the given input.
	 * @param in The list to be iterated over.
	 */
	public ListIterator(GoFList in) {
		this.list = in;
	}
	
	/* (non-Javadoc)
	 * @see project.GlyphIterator#first()
	 */
	@Override
	public void first() {
		this.index = 0;
	}

	/* (non-Javadoc)
	 * @see project.GlyphIterator#next()
	 */
	@Override
	public void next() {
		this.index++;
	}

	/* (non-Javadoc)
	 * @see project.GlyphIterator#isDone()
	 */
	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return this.index >= this.list.count();
	}

	/* (non-Javadoc)
	 * @see project.GlyphIterator#currentItem()
	 */
	@Override
	public Glyph currentItem() {
		// TODO Auto-generated method stub
		return this.list.getAt(this.index);
	}

}
