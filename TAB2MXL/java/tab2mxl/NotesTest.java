package tab2mxl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class NotesTest {
	
@BeforeAll
static void setUp() throws Exception {
	System.out.println("JUnit tester is starting.");
	}
@AfterAll
static void cleanUp() {
	System.out.println("JUnit testing is finished.");
}
@Test
void testString1() {
	String noteExpected = "A";
	String actualNote = Notes.bassNotes("String3",0);
	assertEquals(noteExpected, actualNote, "The note should be the same to the note that was requested from that line");
}
@Test
void testString2() {
	String noteExpected = "Bb";
	String actualNote = Notes.bassNotes("String3",1);
	assertEquals(noteExpected, actualNote, "The note should be the same to the note that was requested from that line");
}
@Test
void testString3() {
	String noteExpected = "B";
	String actualNote = Notes.bassNotes("String3",2);
	assertEquals(noteExpected, actualNote, "The note should be the same to the note that was requested from that line");
	}
@Test
void testString4() {
	String noteExpected = "C";
	String actualNote = Notes.bassNotes("String3",3);
	assertEquals(noteExpected, actualNote, "The note should be the same to the note that was requested from that line");
	}
@Test
void testString5() {
	String noteExpected = "Db";
	String actualNote = Notes.bassNotes("String3",4);
	assertEquals(noteExpected, actualNote, "The note should be the same to the note that was requested from that line");
}
@Test
void testString6() {
	String noteExpected = "D";
	String actualNote = Notes.bassNotes("String3",5);
	assertEquals(noteExpected, actualNote, "The note should be the same to the note that was requested from that line");
}
@Test
void testString7() {
	String noteExpected = "Eb";
	String actualNote = Notes.bassNotes("String3",6);
	assertEquals(noteExpected, actualNote, "The note should be the same to the note that was requested from that line");
}
@Test
void testString8() {
	String noteExpected = "E";
	String actualNote = Notes.bassNotes("String3",7);
	assertEquals(noteExpected, actualNote, "The note should be the same to the note that was requested from that line");
	}
@Test
void testString9() {
	String noteExpected = "F";
	String actualNote = Notes.bassNotes("String3",8);
	assertEquals(noteExpected, actualNote, "The note should be the same to the note that was requested from that line");
	}
@Test
void testString10() {
	String noteExpected = "Gb";
	String actualNote = Notes.bassNotes("String3",9);
	assertEquals(noteExpected, actualNote, "The note should be the same to the note that was requested from that line");
}
@Test
void testString11() {
	String noteExpected = "G";
	String actualNote = Notes.bassNotes("String3",10);
	assertEquals(noteExpected, actualNote, "The note should be the same to the note that was requested from that line");
	}
@Test
void testString12() {
	String noteExpected = "Ab";
	String actualNote = Notes.bassNotes("String3",11);
	assertEquals(noteExpected, actualNote, "The note should be the same to the note that was requested from that line");
}
}