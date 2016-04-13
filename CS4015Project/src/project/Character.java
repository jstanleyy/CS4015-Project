package project;

/**
 * @author jstanley
 * A simple Glyph that holds one character value.
 */
public class Character extends Glyph {

	/**
	 * The value of this Character object.
	 */
	private char c;
	
	/**
	 * Sets the character to the given input.
	 * @param in The character to be set.
	 */
	public Character(char in) {
		this.c = in;
	}
	
	/* (non-Javadoc)
	 * @see project.Glyph#printValue()
	 */
	@Override
	public void printValue() {
		System.out.print(c);
	}

}
