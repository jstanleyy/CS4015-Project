package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SystemFacade {
	
	private GlyphBuilder builder;
	private BufferedReader reader;
	private BufferedWriter writer;
	File file = new File("text.txt");
	
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
	}
	
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
	
	public boolean update(String input) {
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
		return true;
	}
	
	public String getText() {
		Glyph list = builder.getList();
		GlyphIterator i = new PreorderIterator(list);
		GlyphVisitor originalVisitor = new DisplayTextVisitor();
		for(i.first();!i.isDone();i.next()) {
			Glyph cur = i.currentItem();
			cur.accept(originalVisitor);
		}
		
		return originalVisitor.getResult();
	}
}
