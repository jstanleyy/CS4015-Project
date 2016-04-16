package project;

/**
 * @author jstanley
 * Used to build the structure of HTML document.
 */
public class GlyphBuilder {
	
	/**
	 * Holds the single instance of GlyphBuilder.
	 */
	private static GlyphBuilder instance;
	
	/**
	 * Used for creating Glyphs.
	 */
	private GlyphFactory glyphFactory;
	
	/**
	 * The root of the tree.
	 */
	private Glyph root;
	
	/**
	 * The most recently created row, which children will be added to.
	 */
	private Glyph curRow;
	
	/**
	 * Constructor is private so that only once instance of GlyphBuilder can exist.
	 */
	private GlyphBuilder() {
		this.glyphFactory = new GlyphFactory();
		this.root = this.glyphFactory.createColumn();
	}
	
	/**
	 * Creates a new GlyphBuilder if there isn't one already, and then returns it.
	 * @return The instance of GlyphBuilder.
	 */
	public static GlyphBuilder getInstance() {
		if(instance == null) {
			instance = new GlyphBuilder();
		}
		
		return instance;
	}
	
	/**
	 * Builds a new Row, adds it as a child of Root, and sets it to be the current working Row.
	 */
	public void buildRow() {
		Row node = this.glyphFactory.createRow();
		this.root.addChild(node);
		this.curRow = node;
	}
	
	/**
	 * Builds a Character object with the given character, using the glyph factory, and adds it to the current row.
	 * @param in The desired value of the Character object.
	 */
	public void buildCharacter(char in) {
		Character node = this.glyphFactory.createCharacter(in);
		this.curRow.addChild(node);
	}
	
	/**
	 * Returns the root the tree.
	 * @return The root of the tree.
	 */
	public Glyph getRoot() {
		return root;
	}
	
	/**
	 * Clears the tree by creating a new root.
	 */
	public void clear() {
		this.root = this.glyphFactory.createColumn();
	}

	/**
	 * Sets the state of the tree to the given state.
	 * @param mem The memento that holds the state to set.
	 */
	public void setMemento(GlyphMemento mem) {
		this.root = mem.getState();
	}

	/**
	 * Creates a snapshot of the current state of the tree.
	 * @return A memento containing the current state of the tree.
	 */
	public GlyphMemento createMemento() {
		GlyphMemento mem = new GlyphMemento();
		mem.setState(root);
		return mem;
	}
}
