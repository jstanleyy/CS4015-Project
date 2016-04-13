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
	 * Constructor is private so that only once instance of GlyphBuilder can exist.
	 */
	private GlyphBuilder() {
		// Do nothing.
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
}
