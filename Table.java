import java.util.*;

public class Table { 
	private ArrayList<Pair<String, FrequencyList>> rows; 
	private int seedLength; //number of character in the sequence
	private static Random rand = new Random(); //for random number generator
	
	private static final int DEFAULT_SEED_LENGTH = 3;
	
	//constructor 
	public Table() {
		this("", DEFAULT_SEED_LENGTH);
	}
	
	//constructor
	public Table(String text) {
		this(text, DEFAULT_SEED_LENGTH);
	}
	
	//constructor 
	public Table(String text, int seedLength) {
		this.seedLength = seedLength; 
		rows = new ArrayList<Pair<String, FrequencyList>> (); //create the table
		
		//if the content of the file is too short
		if (text.length() <= seedLength) 
			rows.add(new Pair<String, FrequencyList> (text, new FrequencyList()));
		
		else //else update the table with info from file
			updateTable(text);
	}
	
	//get index from table of a given sequence
	private int getRowIndex(String sequence) { 
		Pair<String, FrequencyList> pair = new Pair<String, FrequencyList> 
												(sequence, new FrequencyList());
		return rows.indexOf(pair); 
	}
	
	private void updateTable(String text) {
		//go through every character to creat the table
		for (int j = 0; j <= text.length() - seedLength; j ++) {
			//get a new sequence and index of the row with that sequence
			String sequence = new String(text.substring(j, j + seedLength));
			int idx = getRowIndex(sequence);
			
			//add a new row if the sequence is not in the table
			if (idx == -1) idx = addRow(sequence);

			//update the frequency of the next character
			String next = null;
			if (j + seedLength < text.length())
				next = Character.toString(text.charAt(j + seedLength));
			updateFrequency(idx, next);
		}
	}
	
	//add new row and return index of that sequence in the table
	private int addRow(String sequence) {
		rows.add(new Pair<String, FrequencyList> (sequence, new FrequencyList()));
		return rows.size() - 1;
	} 
	
	//update frequency with the next character 
	private void updateFrequency(int index, String nextChar) {
		rows.get(index).getValue().update(nextChar);
	}
	
	//choose a random sequence in the table
	public String randomKey() { 
		return rows.get(rand.nextInt(rows.size())).getKey().toString();
	}
	
	//get the next character from frequency list
	public String nextChar(String start) {
		int idx = getRowIndex(start); 
		if (idx >= 0)
			return rows.get(idx).getValue().chooseNext();
		return null; //otherwise, just stop and generating text
	}
	
	public String generate(String start, int genLimit) {
		StringBuilder s = new StringBuilder(start); 
		
		//check limit of characters generated
		while (genLimit > 0) { //find the next character 
			String add = nextChar(start);
			if (add == null) //stop generating if there is nothing to add
				genLimit = 0; 
			
			//add next character to the string 
			//and update the number of characters the program can add
			else { 
				s.append(add); 
				start = s.substring(s.length() - seedLength); 
				genLimit --; 
			}
		}
		
		return s.toString();
	}
	
	public String toString() {
		StringBuilder table = new StringBuilder();
		for (Pair pair : rows) {
			table.append("'" + pair.getKey() + "': " + pair.getValue());
			table.append("\n");
		}
		return table.toString();
	}
}