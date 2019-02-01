import java.util.*;

public class FrequencyList {

	private static Random rand = new Random(); 
	private ArrayList<Pair<String, Integer>> rows; 
	private int totalCount;
	
	//constructor
	public FrequencyList() {
		this(null);
	}
	
	//constructor
	public FrequencyList(String nextChar) {
		rows = new ArrayList<Pair<String, Integer>> ();
		if (nextChar != null) 
			update(nextChar);
	}
	
	//update the rows of next characters and count of each character
	public void update(String nextChar) {
		if (nextChar == null) return;
		
		Pair<String, Integer> p = new Pair<String, Integer> (nextChar, 1);
		
		int idx = rows.indexOf(p); 
		if (idx == -1) //add the new character to the list
			addNewChar(p);
		else //update the count
			addCount(idx); 
		
		totalCount++; 
	}
	
	//add a new pair 
	private void addNewChar(Pair<String, Integer> pair) {
		rows.add(pair);
	}
	
	//update count of the next char 
	private void addCount(int idx) {
		int count = rows.get(idx).getValue();
		rows.get(idx).setValue(count + 1);
	}
	
	//randomly choose a next character 
	public String chooseNext() {
		//check the possibility to randomly choose a next character
		double chance = rand.nextDouble() * totalCount;
		int increment = 0; 
		
		for (Pair r : rows) { 
			increment += (int) r.getValue(); 
		//pick the next character based on the possibility range it fits                    
			if (chance <= increment) 
				return r.getKey().toString();
		}
		return null;
	}
	
	public String toString() {
		
		if (rows.size() == 0) 
			return "No next character for this sequence";
			
		StringBuilder list = new StringBuilder("(");
		for (Pair<String, Integer> pair : rows) {
			list.append("'" + pair.getKey() + "':" + pair.getValue() + ", "); 
		}
		
		return list.replace(list.length() - 2, list.length(), ")").toString();
	}
}
	
	
	
	