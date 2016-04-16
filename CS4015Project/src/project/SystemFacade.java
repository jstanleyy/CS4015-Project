package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

/**
 * @author jstanley
 * Acts as an intermediary between the UI and the underlying subsystem.
 */
public class SystemFacade {
	
	/**
	 * Used to build the tree structure.
	 */
	private GlyphBuilder builder;
	
	/**
	 * Used to read input from a file.
	 */
	private BufferedReader reader;
	
	/**
	 * Used to write output to a file.
	 */
	private BufferedWriter writer;
	
	/**
	 * The file the system uses.
	 */
	File file = new File("text.txt");
	
	/**
	 * Keeps track of the order of commands.
	 */
	Stack<GlyphCommand> commandStack;
	
	/**
	 * Keeps track of the commands to redo.
	 */
	Stack<GlyphCommand> redoStack;
	
	/**
	 * Initializes a GlyphBuilder, a BufferedReader, and creates a new file if it does not already exist.
	 */
	public SystemFacade() {
		builder = GlyphBuilder.getInstance();
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			reader = new BufferedReader(new FileReader(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		commandStack = new Stack<GlyphCommand>();
		redoStack = new Stack<GlyphCommand>();
	}
	
	/**
	 * Reads in a file, and builds a tree structure using the contents of the file.
	 * @return True if the read was successful.
	 */
	public boolean loadFile() {
		String line;
		boolean status = false;
		try {
			while((line = reader.readLine()) != null) {
				builder.buildRow();
				for(int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
					builder.buildCharacter(c);
				}
			}
			status = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	/**
	 * Writes the contents of the tree out to a file.
	 * @return True if the write was successful.
	 */
	public boolean saveFile() {
		boolean status = false;
		String toWrite = this.getText();
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(toWrite);
			writer.close();
			status = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	/**
	 * Clears the current tree, and rebuilds using the given text.
	 * @param input The updated text to be stored in the tree.
	 * @return True if the update was successful.
	 */
	public boolean update(String input) {
		UpdateCommand up = new UpdateCommand(input);
		commandStack.push(up);
		up.execute();
		return true;
	}
	
	/**
	 * Undoes the last command.
	 * @return True if the undo was successful.
	 */
	public boolean undo() {
		boolean status = false;
		if(!commandStack.isEmpty()) {
			GlyphCommand gc = commandStack.pop();
			redoStack.push(gc);
			gc.unexecute();
			status = true;
		}
		return status;
	}
	
	/**
	 * Redoes the last command.
	 * @return True if the redo was successful.
	 */
	public boolean redo() {
		boolean status = false;
		if(!redoStack.isEmpty()) {
			GlyphCommand gc = redoStack.pop();
			commandStack.push(gc);
			gc.execute();
			status = true;
		}
		return status;
	}
	
	/**
	 * Uses the Iterator and Visitor patterns get the text from the tree, and return it.
	 * @return The text that was stored in the tree.
	 */
	public String getText() {
		Glyph root = builder.getRoot();
		GlyphIterator i = new PreorderIterator(root);
		GlyphVisitor originalVisitor = new DisplayTextVisitor();
		for(i.first();!i.isDone();i.next()) {
			Glyph cur = i.currentItem();
			cur.accept(originalVisitor);
		}
		
		return originalVisitor.getResult();
	}
}
