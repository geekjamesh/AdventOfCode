package me.jamesharvey.advent.twentyeighteen;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

public class FileUtilTest{
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testReadFile_NoFilePath_Null() throws Exception {
		exception.expect(CustomException.class);
		exception.expectMessage("Empty file path provided");
		FileUtil.readFile(null);
	}

	@Test
	public void testReadFile_NoFilePath_Empty() throws Exception {
		exception.expect(CustomException.class);
		exception.expectMessage("Empty file path provided");
		FileUtil.readFile("");
	}

	@Test
	public void testReadFile_MissingFile() throws Exception {
		exception.expect(CustomException.class);
		exception.expectMessage("File not found at path provide");
		FileUtil.readFile("src/test/resources/random-missing-file.txt");
	}

	@Test
	public void testReadFile_Happy() throws Exception {
		List<String> result = FileUtil.readFile("src/test/resources/test-input.txt");
		assertThat(result, notNullValue());
		assertThat(result.size(), equalTo(3));
	}

}
