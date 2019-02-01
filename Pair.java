// A class for binding key/value pairs.
import java.util.Map;

/**
* A class implementing a key-value pair.  This class pairs an 
* immutable key with a mutable value.  Can be used in many collection structures.
*
* @author Linh Nguyen 
**/

public class Pair<K, V> implements Map.Entry<K, V> {
	/**
	* The immutable key.  An arbitrary object.
	*/
	private K key;                   // the key of the key-value pair
	/**
	* The mutable value.  An arbitrary object.
	*/
	private V value;                   // the value of the key-value pair
		
	/*
	for example:
	Pair<String,Integer> personAttribute =
	new Pair<String,Integer>("Age",34);
	*/
	
	/**
	* Constructs a pair from a key and value.
	*
	* @pre key is non-null
	* @post constructs a key-value pair
	* @param key A non-null object.
	* @param value A (possibly null) object.
	*/
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	* Constructs a pair from a key; value is null.
	*
	* @pre key is non-null
	* @post constructs a key-value pair; value is null
	* @param key A non-null key value.
	*/
	public Pair(K key) {
		this(key, null);
	}
	
	/**
	* Standard comparison function.  Comparison based on keys only.
	*
	* @pre other is non-null Pair
	* @post returns true if the keys are equal
	* @param other Another pair.
	* @return true if the keys are equal.
	*/
	public boolean equals(Object other) {
		//to complete as well 
		if (other instanceof Pair) 
			return (key.equals(( (Pair<K, V>) other).getKey()));
		return false;
	}
	
	/**
	* Standard hashcode function.
	*
	* @post return hash code pair with this pair
	* @return A hash code for pair.
	* @see Hashtable
	*/
	public int hashCode() {
		return getKey().hashCode();
	}
	
	// two accessor methods
	/**
	* Fetch value from pair.  May return null.
	*
	* @post returns value from pair
	* @return The value field of the pair.
	*/
	public V getValue() {
		return value;
	}
	
	/**
	* Fetch key from pair.  Should not return null.
	*
	* @post returns key from pair
	* @return Key of the key-value pair.
	*/
	public K getKey() {
		return key;
	}
	
	// only one setter!
	/**
	* Sets the value of the key-value pair.
	*
	* @post sets pair's value to value
	* @param value The new value.
	*/
	public V setValue(V newValue) {
		value = newValue;
		return value;
	}
	
	/**
	* Standard string representation of an pair.
	*
	* @post returns string representation
	* @return String representing key-value pair.
	*/
	public String toString() {
		//to complete
		return key + ": " + value;
	}
	
	public static void main(String[] args) {
		
		//buggy tester... the generic types are to complete
	  Pair[] classesTaken = new Pair[5];
      classesTaken[0] = new Pair<String, Integer>("Vijay", new Integer(5));
      classesTaken[1] = new Pair<String, Integer>("Matt", new Integer(1));
      classesTaken[2] = new Pair<String, Integer>("Elodie", new Integer(3));
      classesTaken[3] = new Pair<String, Integer>("Joel", new Integer(2));
      classesTaken[4] = new Pair<String, Integer>("Madeline", new Integer(1));
      
      //print out each item in the array
      for (int i = 0; i< classesTaken.length; i++){
      	System.out.println("This Student has taken " + classesTaken[i].getValue() 
      		+ " classes from " + classesTaken[i].getKey() + ".");
      		
      }

   }
   
}
