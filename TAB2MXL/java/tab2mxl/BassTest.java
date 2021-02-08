package tab2mxl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BassTest {

	String s1 = "G|------------------|";
	String s2 = "D|------5-----------|";
	String s3 = "A|-7--7---7--5------|";
	String s4 = "E|-------------8--7-|";
	
	Bass b4 = Bass.getInstance(s1, s2, s3, s4);
	Bass b5 = Bass.getInstance(s1, s2, s3, s4, "String 5");
	
	
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
		String actualS1 = b5.getS1();
		String expectedS1 = s1;
		assertEquals(expectedS1, actualS1, "The string should be s1 because that is the first argument being passed to getInstance.");
	}

}
