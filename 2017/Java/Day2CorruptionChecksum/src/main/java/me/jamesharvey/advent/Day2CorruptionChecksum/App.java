package me.jamesharvey.advent.Day2CorruptionChecksum;

import java.io.IOException;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
    	List<String> document = null;
        try {
        	document = FileUtil.readFile("src/main/resources/input.txt");
        	ChecksumCalculator calculatorDifference = new ChecksumCalculator(document);
        	Integer checksum1 = calculatorDifference.calculateDifferenceBasedChecksum();
        	System.out.println("Checksum 1 = " + checksum1);
        	ChecksumCalculator calculatorDivision = new ChecksumCalculator(document);
        	Integer checksum2 = calculatorDivision.calculateDivisionBasedChecksum();
        	System.out.println("Checksum 2 = " + checksum2);
		} catch (IOException e) {
			System.out.println("Error reading file.");
			e.printStackTrace();
		} catch (CustomException e) {
			System.out.println("Error - " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
    }
}
