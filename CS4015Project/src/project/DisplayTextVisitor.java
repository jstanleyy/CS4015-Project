package project;

/**
 * @author jstanley
 * Gets the original text to be displayed.
 */
public class DisplayTextVisitor implements GlyphVisitor {

	/**
	 * The result of visiting each glyph.
	 */
	String text = "";
	
	/* (non-Javadoc)
	 * @see project.GlyphVisitor#visitCharacter(project.Character)
	 */
	@Override
	public void visitCharacter(Character character) {
		// TODO Auto-generated method stub
		this.text += character.getValue();
	}

	/* (non-Javadoc)
	 * @see project.GlyphVisitor#visitRow(project.Row)
	 */
	@Override
	public void visitRow(Row row) {
		this.text += "\n";
	}

	/* (non-Javadoc)
	 * @see project.GlyphVisitor#visitColumn(project.Column)
	 */
	@Override
	public void visitColumn(Column column) {
		// Do nothing.
	}

	/* (non-Javadoc)
	 * @see project.GlyphVisitor#getResult()
	 */
	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return this.text;
	}

}
