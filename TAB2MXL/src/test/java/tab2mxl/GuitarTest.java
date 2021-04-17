package tab2mxl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GuitarTest {
String s1 = "E|-----------0-----|-0---------------|";
String s2 = "B|---------0---0---|-0---------------|";
String s3 = "G|-------1-------1-|-1---------------|";
String s4 = "D|-----2-----------|-2---------------|";
String s5 = "A|---2-------------|-2---------------|";
String s6 = "A|-0---------------|-0---------------|";
String s7 = "B|-----2-----------|-2---------------|";

Guitar guitar1 = Guitar.getInstance(s1, s2, s3, s4, s5, s6);
Guitar guitar2 = Guitar.getInstance(s1, s2, s3, s4, s5, s6, s7);

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
void Guitar() {
	String actualHead = guitar1.getStr1();
	String expected = "";
	if( actualHead.contains("E|-----------0-----|-0---------------|")) {
		  expected = "Yes";
	}
	assertEquals(expected, "Yes", "Test has passed");
}



}
