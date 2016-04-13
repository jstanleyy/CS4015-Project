package project;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jstanley
 * Provides an adapter between GoFList and an ArrayList.
 */
public class GoFListAdapter implements GoFList {

	/**
	 * Holds a reference to the Adaptee.
	 */
	private List<Glyph> list;
	
	/**
	 * Initializes list to be a new ArrayList.
	 */
	public GoFListAdapter() {
		this.list = new ArrayList<Glyph>();
	}
	
	/* (non-Javadoc)
	 * @see project.GoFList#count()
	 */
	@Override
	public int count() {
		return this.list.size();
	}

	/* (non-Javadoc)
	 * @see project.GoFList#getAt(int)
	 */
	@Override
	public Object getAt(int index) {
		return this.list.get(index);
	}

	/* (non-Javadoc)
	 * @see project.GoFList#first()
	 */
	@Override
	public Object first() {
		return this.list.get(0);
	}

	/* (non-Javadoc)
	 * @see project.GoFList#last()
	 */
	@Override
	public Object last() {
		return this.list.get(this.list.size() - 1);
	}

	/* (non-Javadoc)
	 * @see project.GoFList#include(project.Glyph)
	 */
	@Override
	public boolean include(Glyph x) {
		return this.list.contains(x);
	}

	/* (non-Javadoc)
	 * @see project.GoFList#append(project.Glyph)
	 */
	@Override
	public void append(Glyph x) {
		this.list.add(x);
	}
	
	/* (non-Javadoc)
	 * @see project.GoFList#prepend(project.Glyph)
	 */
	@Override
	public void prepend(Glyph x) {
		this.list.add(0, x);
	}

	/* (non-Javadoc)
	 * @see project.GoFList#delete(project.Glyph)
	 */
	@Override
	public void delete(Glyph x) {
		this.list.remove(x);
	}

	/* (non-Javadoc)
	 * @see project.GoFList#deleteFirst()
	 */
	@Override
	public void deleteFirst() {
		this.list.remove(0);
	}

	/* (non-Javadoc)
	 * @see project.GoFList#deleteAll()
	 */
	@Override
	public void deleteAll() {
		this.list.clear();
	}

	/* (non-Javadoc)
	 * @see project.GoFList#replace(int, project.Glyph)
	 */
	@Override
	public void replace(int index, Glyph x) {
		this.list.remove(index);
		this.list.add(index, x);
	}

}
