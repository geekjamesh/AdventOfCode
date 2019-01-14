package me.jamesharvey.advent.Day2CorruptionChecksum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

public class ChecksumCalculator {
	private List<String> document;
	private Integer checksum;
	
	public ChecksumCalculator() {
		
	}
	
	public ChecksumCalculator(List<String> document) {
		this.document = document;
	}
	
	public Integer calculateDifferenceBasedChecksum() throws CustomException {
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
	
	public Integer calculateDivisionBasedChecksum() throws CustomException {
		try {
			checksum = 0;
			if (document != null && document.size() > 0) {
	        	for (String row:document) {
	        		checksum += extractRowDivision(row);
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

	int extractRowDifference(String row) throws NumberFormatException {
		if (StringUtils.isBlank(row)) {
			return 0;
		}
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

	int extractRowDivision(String row) throws NumberFormatException {
		if (StringUtils.isBlank(row)) {
			return 0;
		}
		List<String> columnList = Arrays.asList(row.split("\t"));
		
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for(String columnValue:columnList) {
			if (StringUtils.isNoneEmpty(columnValue)) {
				numberList.add(Integer.valueOf(columnValue));
			}
		}
		Collections.sort(numberList, Collections.reverseOrder());
		Integer total = 0;
		for(int index = 0; index<numberList.size(); index++) {
			Integer sumResult = 0;
			Integer value1 = numberList.get(index);
			for(int index2 = index+1; index2<numberList.size(); index2++) {
				Integer value2 = numberList.get(index2);
				if(value1 > 0 && value2 > 0 && value1%value2 == 0) {
					sumResult = value1/value2;
				}
			}
			total += sumResult;
		}
		
		return total;
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
