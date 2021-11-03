package application;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Test;

public class entiresSortedByValuesTest {

	@Test
	public void test() {
		Map<String, Integer> output = new HashMap<>();
		Map<String, Integer> pretest = new HashMap<>();
		SortedSet<Entry<String, Integer>> test = new TreeSet<>();
		SortedSet<Entry<String, Integer>> output2 = new TreeSet<>();
		output.put("house", 2);
		output.put("book", 1);
		output.put("tree", 4);
		output.put("paper", 3);
		output2 =  textAnalyzer.entriesSortedByValues(output);
		System.out.println(output2);
		pretest.put("tree",  4);
		pretest.put("paper", 3);
		pretest.put("house", 2);
		pretest.put("book", 1);
		test.addAll(pretest.entrySet());
		System.out.println(test);
		assertEquals(test, output2);
	}

}
