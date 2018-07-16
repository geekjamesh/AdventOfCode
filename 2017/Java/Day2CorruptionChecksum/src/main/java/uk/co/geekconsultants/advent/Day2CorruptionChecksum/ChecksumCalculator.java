package uk.co.geekconsultants.advent.Day2CorruptionChecksum;

import java.util.List;
import java.util.StringTokenizer;

public class ChecksumCalculator {
	private List<String> document;
	private Integer checksum;
	
	public ChecksumCalculator() {
		
	}
	
	public ChecksumCalculator(List<String> document) {
		this.document = document;
	}
	
	public Integer calculate() throws CustomException {
		try {
			checksum = 0;
			if (document != null && document.size() > 0) {
	        	for (String row:document) {
	        		checksum += extractRowDifference(row);
	        	}	
	        } else {
	        	throw new CustomException("Empty File!");
	        }
		} catch (NumberFormatException e) {
			throw new CustomException("Invalid values in file.", e);
		} catch (CustomException e) {
			throw e;
		} catch (Exception e) {
			throw new CustomException("Unknown Error", e);
		}
		return checksum;
	}

	private int extractRowDifference(String row) throws NumberFormatException {
		Integer min = null;
		Integer max = null;
		StringTokenizer columns = new StringTokenizer(row, "\t");
		while (columns.hasMoreTokens()) {
			String columnValue = columns.nextToken();
			if (min == null || max == null) {
				min = Integer.valueOf(columnValue);
				max = Integer.valueOf(columnValue);
			} else {
				min = Integer.min(min, Integer.valueOf(columnValue));
				max = Integer.max(max, Integer.valueOf(columnValue));
			}
		}
		int difference = max - min;
		return difference;
	}

	public List<String> getDocument() {
		return document;
	}

	public void setDocument(List<String> document) {
		this.document = document;
	}

	public Integer getChecksum() {
		return checksum;
	}

}
