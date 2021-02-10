package tab2mxl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TESTCLASS {

	
	Bass b4 = Bass.getInstance("String 1", "String 2", "String 3", "String 4");
	Bass b5 = Bass.getInstance("String 1", "String 2", "String 3", "String 4", "String 5");
	
	
    @BeforeAll
    static void setUp() throws Exception {
    	System.out.println("JUnit testing has started.");
    }
	
	@AfterAll
	static void cleanUp() {
		System.out.println("JUnit testing completed.");
	}
	
	@Test
	void testType4() {
		char expected4 = '4';
		char actual4 = b4.getType();
		assertEquals(expected4, actual4, "The type should be 4 because there are 4 arguments being passed to getInstance.");
	}
	@Test
	void testType5() {
		char expected5 = '5';
		char actual5 = b5.getType();
		assertEquals(expected5, actual5, "The type should be 5 because there are 5 arguments being passed to getInstance.");
	}
	@Test
	void testString1() {
		String actualS1 = b5.getStr1();
		String expectedS1 = "String 1";
		assertEquals(expectedS1, actualS1, "The string should be String 1 because that is the first argument being passed to getInstance.");
	}
	@Test
	void testString2() {
		String actualS2 = b5.getStr2();
		String expectedS2 = "String 2";
		assertEquals(expectedS2, actualS2, "The string should be String 2 because that is the first argument being passed to getInstance.");
	}
	@Test
	void testString3() {
		String actualS3 = b4.getStr3();
		String expectedS3 = "String 3";
		assertEquals(expectedS3, actualS3, "The string should be String 3 because that is the first argument being passed to getInstance.");
	}@Test
	void testString4() {
		String actualS4 = b4.getStr4();
		String expectedS4 = "String 4";
		assertEquals(expectedS4, actualS4, "The string should be String 4 because that is the first argument being passed to getInstance.");
	}



}
