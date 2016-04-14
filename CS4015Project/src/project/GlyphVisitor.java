package project;

/**
 * @author jstanley
 * Defines an interface for Glyph visitors.
 */
public interface GlyphVisitor {
	
	/**
	 * Visits a Character Glyph.
	 * @param character The Character to be visited.
	 */
	public void visitCharacter(Character character);
	
	/**
	 * Visits a Row Glyph.
	 * @param row The Row to be visited.
	 */
	public void visitRow(Row row);
	
	/**
	 * Visits a Column Glyph.
	 * @param column The column to be visited.
	 */
	public void visitColumn(Column column);
	
	/**
	 * Returns the value of the visitor
	 * @return The value of the visitor.
	 */
	public String getResult();

}
