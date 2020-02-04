import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalcTest {

	@Test
	void testEmptyString() {
		String numbersAsString = "";
		assertEquals(0, StringCalculator.add(numbersAsString));
	}
	
	@Test
	void testSpaceString() {
		String numbersAsString = " ";
		assertEquals(0, StringCalculator.add(numbersAsString));
	}
	
	@Test
	void testFirstFormat() {
		String numbersAsString = "1,2,3";
		assertEquals(6, StringCalculator.add(numbersAsString));
	}
	
	@Test
	void testOneElementString() {
		String numbersAsString = "//[,]\n2";
		assertEquals(2, StringCalculator.add(numbersAsString));
	}
	
	@Test
	void testMultipleElementString() {
		String numbersAsString = "//[,]\n1,5,10,6";
		assertEquals(22, StringCalculator.add(numbersAsString));
	}
	
	@Test
	void testNewLineAsDelimiter() {
		String numbersAsString = "//[,]\n1\n2,3";
		assertEquals(6, StringCalculator.add(numbersAsString));
	}
	
	@Test
	void testOnlyNewLine() {
		String numbersAsString = "//[,]\n\n";
		assertEquals(0, StringCalculator.add(numbersAsString));
	}
	
	@Test
	void testNotEndingWithNumber() {
		String numbersAsString = "//[,]\n1,";
		assertEquals(0, StringCalculator.add(numbersAsString));
	}
	
	@Test
	void testNewDelimiter() {
		String numbersAsString = "//[;]\n1;2";
		assertEquals(3, StringCalculator.add(numbersAsString));
	}
	
	@Test
	void testNegativeNumbers() {
		String numbersAsString = "//[;]\n-1;2";
		assertEquals(2, StringCalculator.add(numbersAsString));
	}
	
	
	@Test
	void testNumberBigger1000() {
		String numbersAsString = "//[;]\n1001;2";
		assertEquals(2, StringCalculator.add(numbersAsString));
	}
	
	@Test
	void testDelimiterAnyLength() {
		String numbersAsString = "//[***]\n1***2***3";
		assertEquals(6, StringCalculator.add(numbersAsString));
	}
	
	@Test
	void testMultipleDelimiters() {
		String numbersAsString = "//[*][%]\n1*2%3";
		assertEquals(6, StringCalculator.add(numbersAsString));
	}
	
	
	

}
