package sdlcAssignment;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;


public class textAnalyzer {
	public static String removeSpecialChars(String str){ //Method to remove any special characters to isolate words
		str = str.toLowerCase();
		str = str.replaceAll("[^a-zA-Z0-9\\s]", "");
		str.split(" ");
	return str;  
	}
	public static TreeMap<String, Integer> sortMapKey(Map<String, Integer> words) { //Method to sort the map
		TreeMap<String, Integer> sortedMap = new TreeMap<>();
		sortedMap.putAll(words);
		return sortedMap;
    }
	static <K,V extends Comparable<? super V>>SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
	    SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(new Comparator<Map.Entry<K,V>>() {
	            @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
	                int res = e2.getValue().compareTo(e1.getValue());
	                return res != 0 ? res : 1;
	            }
	        }
	    );
	    sortedEntries.addAll(map.entrySet());
	    return sortedEntries;
	}
		static void textCounter(String fName, Map< String, Integer> words) throws FileNotFoundException{ //Method to count the words
			int wordCounter = 0;
			FileReader fr = new FileReader(fName);
			BufferedReader br = new BufferedReader(fr);
			Scanner poem=new Scanner (br);
			while(poem.hasNext()){
				String word = poem.next();
				word = removeSpecialChars(word);
				Integer counter = words.get(word);
				if(counter != null) {
					counter++;
				}
				else {
					counter = 1;
				}
				words.put(word,counter);
				
				wordCounter++;
			}
			sortMapKey(words);
			poem.close();
			System.out.println("Total words: " + wordCounter + ".");
		}
		
		public static void main(String[] args) throws FileNotFoundException {
			Map<String,Integer> words = new TreeMap<String, Integer>();
			textCounter("AssignmentPoem.txt",words);
			SortedSet<Entry<String, Integer>> sortedWords = entriesSortedByValues(words);
			System.out.println(sortedWords);
			
		}
		
}