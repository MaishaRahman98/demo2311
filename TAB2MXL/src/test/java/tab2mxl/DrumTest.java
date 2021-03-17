package tab2mxl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DrumTest {
	String s1 = "CC|x---------------|";
	String s2 = "HH|--x-x-x-x-x-x-x-|";
	String s3 = "SD|----o-------o---|";
	String s4 = "HT|----------------|";
	String s5 = "MT|----------------|";
	String s6 = "BD|o-------o-------|";
	
	Drum d5 = Drum.getInstance(s1, s2, s3, s4, s5);
	Drum d6 = Drum.getInstance(s1, s2, s3, s4, s5, s6);

	@BeforeAll
    static void setUp() throws Exception {
    	System.out.println("JUnit testing has started.");
    }
	
    @AfterEach
	void update() {
		System.out.println("JUnit test case completed.");
	}
    
	@AfterAll
	static void cleanUp() {
		System.out.println("JUnit testing completed.");
	}
	
	@Test
	void testDrumXMLHeading5() {
		String actualHead = d5.xmlDrumHeader(5);
		String expected = "";
		if( actualHead.contains("<instrument-name>Bass Drum 1</instrument-name>")) {
			  expected = "Yes";
		}
		assertEquals(expected, "Yes", "The printed xml drum header string is correct.");
	}
	@Test
	void testDrumXMLHeading6() {
		String actualHead = d5.xmlDrumHeader(6);
		String expected = "";
		if( actualHead.contains("<instrument-name>Bass Drum 1</instrument-name>")) {
			  expected = "Yes";
		}
		assertEquals(expected, "Yes", "The printed xml drum header string is correct.");
	}
//	@Test
//	void testPrintDrumXML() {
//		String actualXML = d6.printDrumXML(s1, s2, s3, s3, s5, s6);
//		//boolean b = actualXML.endsWith("</note>");
//		String expected = "";
//		if( actualXML.contains(" </note>\n") ) {
//			  expected = "Yes";
//		}
//		assertEquals(expected, "", "The printed xml string is correct.");
//	}
	@Test
	void testEndDrumHeading() {
		StringBuilder endexpected = new StringBuilder();
		endexpected.append("  <barline location=\"right\">\n");
		endexpected.append("   <bar-style>light-heavy</bar-style>\n");
		endexpected.append("   </barline>\n");
		endexpected.append("  </measure>\n");
		endexpected.append(" </part>\n");
		endexpected.append("</score-partwise>\n");
		String actualend = d5.endDrumHeading();
		assertEquals(endexpected.toString(), actualend, "The drum end heading is correct");
	}

}
