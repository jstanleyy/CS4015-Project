package project;

import java.util.Scanner;

/**
 * @author jstanley
 * Used to update the tree with the input text, and saves the state of the builder from before.
 */
public class UpdateCommand extends GlyphCommand {

	/**
	 * Holds a reference to the builder.
	 */
	private GlyphBuilder builder;
	
	/**
	 * The string that the tree will be updated with.
	 */
	private String input;
	
	/**
	 * The state of the builder before updating.
	 */
	private GlyphMemento mem;
	
	/* (non-Javadoc)
	 * @see project.GlyphCommand#execute()
	 */
	@Override
	public void execute() {
		this.mem = builder.createMemento();
		builder.clear();
		Scanner parser = new Scanner(input);
		while(parser.hasNextLine()) {
			String line = parser.nextLine();
			builder.buildRow();
			for(int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				builder.buildCharacter(c);
			}
		}
		parser.close();
	}

	/* (non-Javadoc)
	 * @see project.GlyphCommand#unexecute()
	 */
	@Override
	public void unexecute() {
		builder.setMemento(mem);
	}
	
	/**
	 * Creates a command object with the given input string.
	 * @param in The text that the tree will be updated with.
	 */
	public UpdateCommand(String in) {
		this.input = in;
		builder = GlyphBuilder.getInstance();
	}

}
