import java.util.*;
import java.io.*;


public class WordGen {
	private static final String DEFAULT_FILE = "as_you_like_it.txt";
	private static final int DEFAULT_SEED_LENGTH = 3; 
	private static final int DEFAULT_CHAR_LIMIT = 100; 
	
	private static String readFile(String name) throws FileNotFoundException {
		File file = new File(name); //create scanner and file
		Scanner sc = new Scanner(file); 
		StringBuilder line = new StringBuilder();
		//read and return every line in the file
		while (sc.hasNextLine()) {
			line.append(sc.nextLine());
			if (sc.hasNextLine()) 
				line.append("\n");
		}
		
		return line.toString();
	}
		
	public static void main(String[] args) throws FileNotFoundException {
		String fileName; 
		String start;
		int charLimit;
		
		//get file name 
		if (args.length > 0) 
			fileName = args[0]; 
		else 
			fileName = DEFAULT_FILE; 
		
		//get content of file 
		String lines = readFile(fileName); 

		//create table and update frequency list 
		Table t = new Table(lines, DEFAULT_SEED_LENGTH);

		//get starting characters
		if (args.length > 1) start = args[1];
		else start = t.randomKey();
		
		//get character limit
		if (args.length == 3) 
			charLimit = Integer.parseInt(args[2]);
		else charLimit = DEFAULT_CHAR_LIMIT; 
		
		//generate and print text
		String text = t.generate(start, charLimit - start.length()); 
		System.out.println(text + "\nCharacter Count: " + 
										text.length() + "/" + charLimit); 
	}              
}