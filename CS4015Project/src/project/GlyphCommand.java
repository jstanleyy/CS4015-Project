package project;

/**
 * @author jstanley
 * Defines an interface for commands to extend.
 */
public abstract class GlyphCommand {
	
	/**
	 * Perform the commands action.
	 */
	public abstract void execute();
	
	/**
	 * Undo the commands last action.
	 */
	public abstract void unexecute();
	
}
