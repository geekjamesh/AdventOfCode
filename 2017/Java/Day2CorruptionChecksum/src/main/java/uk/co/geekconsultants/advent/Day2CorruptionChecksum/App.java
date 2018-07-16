package uk.co.geekconsultants.advent.Day2CorruptionChecksum;

import java.io.IOException;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
    	List<String> document = null;
        try {
        	document = FileUtil.readFile("src/main/resources/input.txt");
        	ChecksumCalculator calculator = new ChecksumCalculator(document);
        	Integer checksum = calculator.calculate();
        	System.out.println("Checksum = " + checksum);
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
