package application;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class textCounterTest {

	@Test
	public void test() throws Exception {
		String fname = new String("test.txt");
		Map<String, Integer> words = new TreeMap<String, Integer>();
		Map<String, Integer> test = new TreeMap<String, Integer>();
		test.put("a", 2);
		test.put("chuck", 2);
		test.put("could", 2);
		test.put("how", 1);
		test.put("if", 1);
		test.put("much", 1);
		test.put("wood", 2);
		test.put("woodchuck", 2);
		
		try {
			textAnalyzer.textCounter(fname, words);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(test, words);
	}

}
