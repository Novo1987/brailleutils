package org.daisy.braille.pef;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.daisy.braille.tools.FileCompare;
import org.junit.Test;


public class PEFFileSplitterTest {

	@Test
	public void testSplitter() throws IOException, TransformerException {
		File f = File.createTempFile("SplitterTest", "");
		assertTrue("Verify that test is correctly set up", f.delete());
		File dir = new File(f.getParentFile(), f.getName());
		assertTrue("Verify that test is correctly set up", dir.mkdir());
		PEFFileSplitter splitter = new PEFFileSplitter();
		assertTrue("Verify that splitter returns true", splitter.split(
				this.getClass().getResourceAsStream("resource-files/PEFFileSplitterTestInput.pef"),
				dir));
		assertEquals("Assert that the number of generated files is correct", 3, dir.listFiles().length);
		int i = 1;
		System.out.println(dir);
		FileCompare fc = new FileCompare();
		for (File v : dir.listFiles()) {
			assertTrue("Assert that file " + i + " begins with the string 'volume-'", v.getName().startsWith("volume-"));
			assertTrue("Assert that file " + i + " ends with the string '.pef'", v.getName().endsWith(".pef"));
			assertTrue("Assert that contents of file " + i + " is as expected", fc.compareXML(new FileInputStream(v), this.getClass().getResourceAsStream("resource-files/PEFFileSplitterTestExpected-" + i + ".pef")));
			i++;
			// clean up
			if (!v.delete()) {
				v.deleteOnExit();
			}
		}
		// clean up
		if (!dir.delete()) {
			dir.deleteOnExit();
		}
		
	}

}