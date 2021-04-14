package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {

	static MorseCodeTree morse = new MorseCodeTree();
	
	public MorseCodeConverter() {
		
	}
	
	public static String convertToEnglish(String code) {
	String morseCode = "", temp2;
		Scanner space;
		Scanner slash = new Scanner(code);
		slash.useDelimiter("/");
		
		while(slash.hasNext()) {
			space = new Scanner(slash.next());
			space.useDelimiter(" ");
			while(space.hasNext()) {
			String temp = space.next();
			temp2 = morse.fetch(temp);
			morseCode+=temp2;
			}
			morseCode += " ";
		}
		return morseCode.trim();
	}
	
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		Scanner data = new Scanner(codeFile);
		Scanner space;
		Scanner slash;
		String morseCode = "", temp2, temp;
		if(!codeFile.canExecute()) {
			throw new FileNotFoundException();
		}
		while(data.hasNextLine()) {
			slash = new Scanner(data.nextLine());
			slash.useDelimiter("/");
			while(slash.hasNext()) {
				space = new Scanner(slash.next());
				space.useDelimiter(" ");
				while(space.hasNext()) {
				temp = space.next();
				temp2 = morse.fetch(temp);
				morseCode+=temp2;
				}
				morseCode += " ";
			}
		}
		data.close();
			return morseCode.trim();

	}
	
	public static String printTree() {
		MorseCodeTree morse = new MorseCodeTree();
		ArrayList<String> morseList = new ArrayList<>();
		morseList = morse.toArrayList();
		String list = "";
		for(int i=0; i < morseList.size(); i++) {
			list += morseList.get(i) + " ";
		}
		return list;
	}
}
