package uk.co.geekconsultants.advent.Day2CorruptionChecksum;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class FileUtil {

	public static List<String> readFile(String filePath) throws IOException, CustomException {
		if (StringUtils.isAllBlank(filePath)) {
			throw new CustomException("Empty file path provided : " + filePath);
		}
		return Files.readAllLines(Paths.get(filePath));
	}
}
