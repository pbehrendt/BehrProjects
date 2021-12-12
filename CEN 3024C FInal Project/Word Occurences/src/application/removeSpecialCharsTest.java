package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class removeSpecialCharsTest {

	@Test
	public void test() {
		String output = textAnalyzer.removeSpecialChars("Fre@ED)o...m");
		assertEquals("freedom", output);
	}

}
