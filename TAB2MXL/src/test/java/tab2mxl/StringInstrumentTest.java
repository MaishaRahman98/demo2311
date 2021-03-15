package tab2mxl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringInstrumentTest {
	
//	Bass b4 = Bass.getInstance("String 1", "String 2", "String 3", "String 4");
//	Bass b5 = Bass.getInstance("String 1", "String 2", "String 3", "String 4", "String 5");
	String s1 = "G|------------------|";
	String s2 = "D|------5-----------|";
	String s3 = "A|-7--7---7--5------|";
	String s4 = "E|-------------8--7-|";
	String s5 = "B|-------------8--7-|";
	String s6 = "G|------------------|";
	String s7 = "D|------5-----------|";
	
	Bass b4 = Bass.getInstance(s1, s2, s3, s4);
	Bass b5 = Bass.getInstance(s1, s2, s3, s4, s5);
	
	Guitar g6 = Guitar.getInstance(s1, s2, s3, s4, s5, s6);
	Guitar g7 = Guitar.getInstance(s1, s2, s3, s4, s5, s6, s7);
	
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
	void testXMLHeading4() {
		//Tests 4 string bass:
		String actualHead = b4.xmlHeader(4);
		String expected = "";
		if( actualHead.contains("<staff-lines>4</staff-lines>")) {
			  expected = "Yes";
		}
		assertEquals(expected, "Yes", "The printed xml header string is correct.");
	}
	
	@Test
	void testXMLHeading5() {
		//Tests 5 string bass:
		String actualHead = b5.xmlHeader(5);
		String expected = "";
		if( actualHead.contains("<staff-lines>5</staff-lines>")) {
			  expected = "Yes";
		}
		assertEquals(expected, "Yes", "The printed xml header string is correct.");
	}
	
	@Test
	void testXMLHeading6() {
		String actualHead = g6.xmlHeader(6);
		String expected = "";
		if( actualHead.contains("<staff-lines>6</staff-lines>")) {
			  expected = "Yes";
		}
		assertEquals(expected, "Yes", "The printed xml header string is correct.");
	}
	@Test
	void testXMLHeading7() {
		String actualHead = g6.xmlHeader(7);
		String expected = "";
		if( actualHead.contains("<staff-lines>7</staff-lines>")) {
			  expected = "Yes";
		}
		assertEquals(expected, "Yes", "The printed xml header string is correct.");
	}
	
	@Test
	void testPrintToXML() {
		String actualXML = b4.printToXML(s1, s2, s3, s3, s5, null, null);
		//boolean b = actualXML.endsWith("</note>");
		String expected = "";
		if( actualXML.contains("</note>")) {
			  expected = "Yes";
			}
		assertEquals(expected, "Yes", "The printed xml string is correct.");
	}
	
	@Test
	void testEndHeading() {
		StringBuilder endexpected = new StringBuilder();
		endexpected.append("  <barline location=\"right\">\n");
		endexpected.append("   <bar-style>light-heavy</bar-style>\n");
		endexpected.append("   </barline>\n");
		endexpected.append("  </measure>\n");
		endexpected.append(" </part>\n");
		endexpected.append("</score-partwise>\n");
		String actualend = b4.endHeading();
		assertEquals(endexpected.toString(), actualend, "The end heading is correct");
	}
	
	@Test
	void testStringInstrument() {
		StringInstrument stringInst = new StringInstrument();
		int actType = stringInst.getType();
		assertEquals(' ', actType, "The type is null.");
	}
	
	@Test
	void testType4() {
		char expected4 = '4';
		char actual4 = b4.getType();
		assertEquals(expected4, actual4, "The type should be 4.");
	}
	@Test
	void testType5() {
		char expected5 = '5';
		char actual5 = b5.getType();
		assertEquals(expected5, actual5, "The type should be 5 .");
	}
	@Test
	void testString1() {
		String actualS1 = b5.getStr1();
		String expectedS1 = s1;
		assertEquals(expectedS1, actualS1, "The string should be String 1 because that is the first argument being passed to getInstance.");
	}
	@Test
	void testString2() {
		String actualS2 = b5.getStr2();
		String expectedS2 = s2;
		assertEquals(expectedS2, actualS2, "The string should be String 2 because that is the second argument being passed to getInstance.");
	}
	@Test
	void testString3() {
		String actualS3 = b5.getStr3();
		String expectedS3 = s3;
		assertEquals(expectedS3, actualS3, "The string should be String 3 because that is the third argument being passed to getInstance.");
	}@Test
	void testString4() {
		String actualS4 = b5.getStr4();
		String expectedS4 = s4;
		assertEquals(expectedS4, actualS4, "The string should be String 4 because that is the fourth argument being passed to getInstance.");
	}
	@Test
	void testString5() {
		String actualS5 = b5.getStr5();
		String expectedS5 = s5;
		assertEquals(expectedS5, actualS5, "The string should be String 5 because that is the fifth argument being passed to getInstance.");
	}

}
