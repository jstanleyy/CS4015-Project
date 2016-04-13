package project;

/**
 * @author jstanley
 * Creates and returns Glyph objects. Character objects are created using a flyweight pool.
 */
public class GlyphFactory {

	/**
	 * Holds all the Character objects. 
	 */
	private Character[] charPool = new Character[128]; // Got the value 128 from the Flyweight notes.
	
	/**
	 * Returns a Character object with the given character value.
	 * @param c The character of the object desired.
	 * @return The Character object associated with that character.
	 */
	public Character createCharacter(char c) {
		if(charPool[c] == null) {
			charPool[c] = new Character(c);
		}
		return charPool[c];
	}
	
	/**
	 * Creates and returns a new Row object.
	 * @return A new Row object.
	 */
	public Row createRow() {
		return new Row();
	}
}
