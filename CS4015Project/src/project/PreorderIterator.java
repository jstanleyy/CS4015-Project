package project;

import java.util.Stack;

/**
 * @author jstanley
 * A pre-order iterator implementation of GlyphIterator.
 */
public class PreorderIterator implements GlyphIterator {

	/**
	 * The root of the tree.
	 */
	private Glyph root;
	
	/**
	 * A stack containing the various iterators that have been created.
	 */
	private Stack<GlyphIterator> iteratorStack;
	
	/**
	 * The current Glyph in the tree.
	 */
	private Glyph currentItem;
	
	/**
	 * Creates a PreorderIterator with the given root.
	 * @param rootIn The root of the tree to be iterated over.
	 */
	public PreorderIterator(Glyph rootIn) {
		this.root = rootIn;
		this.iteratorStack = new Stack<GlyphIterator>();
		this.currentItem = this.root;
	}
	
	/* (non-Javadoc)
	 * @see project.GlyphIterator#first()
	 */
	@Override
	public void first() {
		GlyphIterator i = this.root.createIterator();
		if(i != null) {
			i.first();
			this.iteratorStack.clear();
			this.iteratorStack.push(i);
		}
	}

	/* (non-Javadoc)
	 * @see project.GlyphIterator#next()
	 */
	@Override
	public void next() {
	    Glyph g = this.iteratorStack.peek().currentItem();
	    if(g != null) {
	    	GlyphIterator i = g.createIterator();
			i.first();
			this.iteratorStack.push(i);
			
			while(this.iteratorStack.size() > 0 && this.iteratorStack.peek().isDone()) {
				this.iteratorStack.pop();
				if(!this.iteratorStack.isEmpty()) {
					this.iteratorStack.peek().next();
				}
			}
			
			if(!this.iteratorStack.isEmpty()) {
				this.currentItem = this.iteratorStack.peek().currentItem();
			}
	    } else {
	    	this.iteratorStack.pop();
	    }
	    
	}

	/* (non-Javadoc)
	 * @see project.GlyphIterator#isDone()
	 */
	@Override
	public boolean isDone() {
		return this.iteratorStack.isEmpty();
	}

	/* (non-Javadoc)
	 * @see project.GlyphIterator#currentItem()
	 */
	@Override
	public Glyph currentItem() {
		return this.currentItem;
	}

}
