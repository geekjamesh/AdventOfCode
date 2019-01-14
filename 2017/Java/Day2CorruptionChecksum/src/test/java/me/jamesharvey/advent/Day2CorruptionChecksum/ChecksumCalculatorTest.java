package me.jamesharvey.advent.Day2CorruptionChecksum;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ChecksumCalculatorTest {
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testExtractRowDifference_1_Column() {
		String testValues = "1";
		ChecksumCalculator testCalculator = new ChecksumCalculator();
		assertThat(testCalculator.extractRowDifference(testValues), equalTo(0));
	}

	@Test
	public void testExtractRowDifference_2_Column() {
		String testValues = "1	2";
		ChecksumCalculator testCalculator = new ChecksumCalculator();
		assertThat(testCalculator.extractRowDifference(testValues), equalTo(1));
	}

	@Test
	public void testExtractRowDifference_3_Column() {
		String testValues = "3	1	2";
		ChecksumCalculator testCalculator = new ChecksumCalculator();
		assertThat(testCalculator.extractRowDifference(testValues), equalTo(2));
	}

	@Test
	public void testExtractRowDifference_Trailing_Tab() {
		String testValues = "3	1	2	";
		ChecksumCalculator testCalculator = new ChecksumCalculator();
		assertThat(testCalculator.extractRowDifference(testValues), equalTo(2));
	}

	@Test
	public void testExtractRowDifference_Leading_Tab() {
		String testValues = "	3	1	2";
		ChecksumCalculator testCalculator = new ChecksumCalculator();
		assertThat(testCalculator.extractRowDifference(testValues), equalTo(2));
	}

	@Test
	public void testExtractRowDifference_Empty() {
		String testValues = "";
		ChecksumCalculator testCalculator = new ChecksumCalculator();
		assertThat(testCalculator.extractRowDifference(testValues), equalTo(0));
	}

	@Test
	public void testExtractRowDifference_Non_Numeric() {
		String testValues = "1	2	Foo";
		ChecksumCalculator testCalculator = new ChecksumCalculator();
		exception.expect(NumberFormatException.class);
		testCalculator.extractRowDifference(testValues);
	}
	
	@Test
	public void testCaluclateDifferenceBasedChecksum_EmptyFileNull() throws Exception {
		List<String> fileInput = null;
		ChecksumCalculator testCalculator = new ChecksumCalculator(fileInput);
		exception.expect(CustomException.class);
		exception.expectMessage("Empty File!");
	
		testCalculator.calculateDifferenceBasedChecksum();
		//Test should not get here...
		fail("Method did not throw expected Exception");
	}
	
	@Test
	public void testCaluclateDifferenceBasedChecksum_EmptyFileEmpty() throws Exception {
		List<String> fileInput = new ArrayList<String>();
		ChecksumCalculator testCalculator = new ChecksumCalculator(fileInput);
		exception.expect(CustomException.class);
		exception.expectMessage("Empty File!");
	
		testCalculator.calculateDifferenceBasedChecksum();
		//Test should not get here...
		fail("Method did not throw expected Exception");
	}
	
	@Test
	public void testCaluclateDifferenceBasedChecksum_Non_NumericRow() throws Exception {
		List<String> fileInput = new ArrayList<String>();
		fileInput.add("1	2	Foo");
		ChecksumCalculator testCalculator = new ChecksumCalculator(fileInput);
		exception.expect(CustomException.class);
		exception.expectMessage("Invalid values in file.");
		testCalculator.calculateDifferenceBasedChecksum();
		//Test should not get here...
		fail("Method did not throw expected Exception");
	}
	
	@Test
	public void testCaluclateDifferenceBasedChecksum_1_Row() {
		List<String> fileInput = new ArrayList<String>();
		fileInput.add("1	2	3");
		ChecksumCalculator testCalculator = new ChecksumCalculator(fileInput);
		try {
			testCalculator.calculateDifferenceBasedChecksum();
		} catch (CustomException e) {
			e.printStackTrace();
			fail("Unexpected Error in test: " + e.getMessage());
		}
		assertThat(testCalculator.getChecksum(), equalTo(2));
	}
	
	@Test
	public void testCaluclateDifferenceBasedChecksum_Multi_Row() {
		List<String> fileInput = new ArrayList<String>();
		fileInput.add("5	1	9	5");
		fileInput.add("7	5	3");
		fileInput.add("2	4	6	8");
		ChecksumCalculator testCalculator = new ChecksumCalculator(fileInput);
		try {
			testCalculator.calculateDifferenceBasedChecksum();
		} catch (CustomException e) {
			e.printStackTrace();
			fail("Unexpected Error in test: " + e.getMessage());
		}
		assertThat(testCalculator.getChecksum(), equalTo(18));
	}
	
	@Test
	public void testCaluclateDifferenceBasedChecksum_Default_Constructor() {
		List<String> fileInput = new ArrayList<String>();
		fileInput.add("5	1	9	5");
		fileInput.add("7	5	3");
		fileInput.add("2	4	6	8");
		ChecksumCalculator testCalculator = new ChecksumCalculator();
		testCalculator.setDocument(fileInput);
		try {
			testCalculator.calculateDifferenceBasedChecksum();
		} catch (CustomException e) {
			e.printStackTrace();
			fail("Unexpected Error in test: " + e.getMessage());
		}
		assertThat(testCalculator.getChecksum(), equalTo(18));
	}
	
	@Test
	public void testExtractRowDivision_DivisionExamples() {
		ChecksumCalculator testCalculator = new ChecksumCalculator();
		assertThat(testCalculator.extractRowDivision("5	9	2	8"), equalTo(4));
		assertThat(testCalculator.extractRowDivision("9	4	7	3"), equalTo(3));
		assertThat(testCalculator.extractRowDivision("3	8	6	5"), equalTo(2));
		
	}

	@Test
	public void testExtractRowDivision_1_Column() {
		String testValues = "1";
		ChecksumCalculator testCalculator = new ChecksumCalculator();
		assertThat(testCalculator.extractRowDivision(testValues), equalTo(0));
	}

	@Test
	public void testExtractRowDivision_2_Column() {
		String testValues = "1	2";
		ChecksumCalculator testCalculator = new ChecksumCalculator();
		assertThat(testCalculator.extractRowDivision(testValues), equalTo(2));
	}

	@Test
	public void testExtractRowDivision_3_Column() {
		String testValues = "3	1	2";
		ChecksumCalculator testCalculator = new ChecksumCalculator();
		assertThat(testCalculator.extractRowDivision(testValues), equalTo(5));
	}

	@Test
	public void testExtractRowDivision_Trailing_Tab() {
		String testValues = "3	1	2	";
		ChecksumCalculator testCalculator = new ChecksumCalculator();
		assertThat(testCalculator.extractRowDivision(testValues), equalTo(5));
	}

	@Test
	public void testExtractRowDivision_Leading_Tab() {
		String testValues = "	3	1	2";
		ChecksumCalculator testCalculator = new ChecksumCalculator();
		assertThat(testCalculator.extractRowDivision(testValues), equalTo(5));
	}

	@Test
	public void testExtractRowDivision_Empty() {
		String testValues = "";
		ChecksumCalculator testCalculator = new ChecksumCalculator();
		assertThat(testCalculator.extractRowDivision(testValues), equalTo(0));
	}

	@Test
	public void testExtractRowDivision_Non_Numeric() {
		String testValues = "1	2	Foo";
		ChecksumCalculator testCalculator = new ChecksumCalculator();
		exception.expect(NumberFormatException.class);
		testCalculator.extractRowDifference(testValues);
	}

	@Test
	public void testExtractRowDivision_Divide_By_Zero() {
		String testValues = "3	1	0";
		ChecksumCalculator testCalculator = new ChecksumCalculator();
		assertThat(testCalculator.extractRowDivision(testValues), equalTo(3));
	}

	@Test
	public void testExtractRowDivision_Divide_By_Zero_Double() {
		String testValues = "0	1	0";
		ChecksumCalculator testCalculator = new ChecksumCalculator();
		assertThat(testCalculator.extractRowDivision(testValues), equalTo(0));
	}

}
