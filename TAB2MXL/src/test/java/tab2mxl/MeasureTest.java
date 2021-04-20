package tab2mxl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class MeasureTest {
	
	Measure testMeasure = new Measure("");
	
	@Test
	void testLegato1() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("hammer-on");
		expected.add("H");
		expected.add("11");
		ArrayList<String> actual = testMeasure.legatos("4h11");
		System.out.println(actual);
		assertEquals(expected, actual, "The note array should be hammer-on,H,11");
	}
	@Test
	void testLegato2() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("pull-off");
		expected.add("P");
		expected.add("6");
		ArrayList<String> actual = testMeasure.legatos("8p6");
		System.out.println(actual);
		assertEquals(expected, actual, "The note array should be pull-off,P,6");
	}
	
	@Test
	void testGuitarNote1() {
		String expected = "Ab" ;
		String actual = testMeasure.getNoteMeasure("String1",4,"guitar");
		assertEquals(expected, actual, "The note should be Ab");
	}
	@Test
	void testGuitarNote2() {
		String expected = "C" ;
		String actual = testMeasure.getNoteMeasure("String2",1,"guitar");
		assertEquals(expected, actual, "The note should be C");
	}
//	@Test
//	void testGuitarNote3() {
//		String expected = "Ab" ;
//		String actual = testMeasure.getNoteMeasure("String3",2,"guitar");
//		assertEquals(expected, actual, "The note should be Ab");
//		}
	@Test
	void testGuitarNote4() {
		String expected = "F" ;
		String actual = testMeasure.getNoteMeasure("String4",3,"guitar");
		assertEquals(expected, actual, "The note should be F");
		}
	@Test
	void testGuitarNote5() {
		String expected = "E" ;
		String actual = testMeasure.getNoteMeasure("String5",7,"guitar");
		assertEquals(expected, actual, "The note should be E");
		}
	@Test
	void testGuitarNote6() {
		String expected = "F" ;
		String actual = testMeasure.getNoteMeasure("String6",1,"guitar");
		assertEquals(expected, actual, "The note should be F");
		}
	@Test
	void testGuitarNote7() {
		String expected = "Eb" ;
		String actual = testMeasure.getNoteMeasure("String7",4,"guitar");
		assertEquals(expected, actual, "The note should be Eb");
		}
	
	@Test
	void testBassNote1() {
		String expected = "Eb" ;
		String actual = testMeasure.getNoteMeasure("String1",8,"bass");
		assertEquals(expected, actual, "The note should be Eb");
	}
	@Test
	void testBassNote2() {
		String expected = "Ab" ;
		String actual = testMeasure.getNoteMeasure("String2",6,"bass");
		assertEquals(expected, actual, "The note should be Ab");
	}
	@Test
	void testBassNote3() {
		String expected = "B" ;
		String actual = testMeasure.getNoteMeasure("String3",2,"bass");
		assertEquals(expected, actual, "The note should be B");
		}
	@Test
	void testBassNote4() {
		String expected = "Eb" ;
		String actual = testMeasure.getNoteMeasure("String4",11,"bass");
		assertEquals(expected, actual, "The note should be Eb");
		}
	@Test
	void testBassNote5() {
		String expected = "Ab" ;
		String actual = testMeasure.getNoteMeasure("String5",9,"bass");
		assertEquals(expected, actual, "The note should be Ab");
		}
//	@Test
//	void durationCheck1() {
//		String expected = "Eighth" ;
//		String actual = testMeasure.getDuration(1);
//		assertEquals(expected, actual, "The duration should be eighth");
//	}
//	@Test
//	void durationCheck2() {
//		String expected = "Whole" ;
//		String actual = testMeasure.getDuration(8);
//		assertEquals(expected, actual, "The duration should be whole");
//	}
//	@Test
//	void durationCheck3() {
//		String expected = "Quarter" ;
//		String actual = testMeasure.getDuration(2);
//		assertEquals(expected, actual, "The duration should be Quarter");
//	}
//	@Test
//	void durationCheck4() {
//		String expected = "Half" ;
//		String actual = testMeasure.getDuration(4);
//		assertEquals(expected, actual, "The duration should be Half");
//	}
	@Test
	void octaveCheck1() {
		int expected = 2;
		int actual = testMeasure.getOctaveMeasure("String4",11,"bass");
		assertEquals(expected, actual, "The octave should be 2");
		}
	@Test
	void octaveCheck2() {
		int expected = 4;
		int actual = testMeasure.getOctaveMeasure("String2",9,"guitar");
		assertEquals(expected, actual, "The octave should be 4");
		}
	@Test
	void octaveCheck3() {
		int expected = 4;
		int actual = testMeasure.getOctaveMeasure("String2",9,"drum");
		assertEquals(expected, actual, "The octave should be 4");
		}
	
	@Test
	void testDrumNote1() {
		String expected = "Ab" ;
		String actual = testMeasure.getNoteMeasure("String1",4,"drum");
		assertEquals(expected, actual, "The note should be Ab");
	}
	@Test
	void testDrumNote2() {
		String expected = "C" ;
		String actual = testMeasure.getNoteMeasure("String2",1,"drum");
		assertEquals(expected, actual, "The note should be C");
	}
//	@Test
//	void testDrumNote3() {
//		String expected = "Ab" ;
//		String actual = testMeasure.getNoteMeasure("String3",2,"drum");
//		assertEquals(expected, actual, "The note should be Ab");
//		}
	@Test
	void testDrumNote4() {
		String expected = "F" ;
		String actual = testMeasure.getNoteMeasure("String4",3,"drum");
		assertEquals(expected, actual, "The note should be F");
		}
	@Test
	void testDrumNote5() {
		String expected = "E" ;
		String actual = testMeasure.getNoteMeasure("String5",7,"drum");
		assertEquals(expected, actual, "The note should be E");
		}
	@Test
	void testDrumNote6() {
		String expected = "F" ;
		String actual = testMeasure.getNoteMeasure("String6",1,"drum");
		assertEquals(expected, actual, "The note should be F");
		}
	@Test
	void testDrumNote7() {
		String expected = "Eb" ;
		String actual = testMeasure.getNoteMeasure("String7",4,"drum");
		assertEquals(expected, actual, "The note should be Eb");
		}
//	@Test
//	void testDrumInstrument1() {
//		String expected = "P1-150";
//		String actual = Notes.drumInstrument("String1", 'x');
//		assertEquals(expected, actual, "The instrument should be P1-150");
//		}
//	@Test
//	void testDrumInstrument2() {
//		String expected = "P1-160";
//		String actual = Notes.drumInstrument("String1", 'X');
//		assertEquals(expected, actual, "The instrument should be P1-160");
//		}
//	
//	@Test
//	void testDrumInstrument3() {
//		String expected = "P1-I43";
//		String actual = Notes.drumInstrument("String2", 'x');
//		assertEquals(expected, actual, "The instrument should be P1-I43");
//		}
//	
//	@Test
//	void testDrumInstrument4() {
//		String expected = "P1-I47";
//		String actual = Notes.drumInstrument("String2", 'X');
//		assertEquals(expected, actual, "The instrument should be P1-I47");
//		}
//	@Test
//	void testDrumInstrument5() {
//		String expected = "P1-I39";
//		String actual = Notes.drumInstrument("String3", 'o');
//		assertEquals(expected, actual, "The instrument should be P1-I39");
//		}
//	@Test
//	void testDrumInstrument6() {
//		String expected = "P1-I49";
//		String actual = Notes.drumInstrument("String4", 'o');
//		assertEquals(expected, actual, "The instrument should be P1-I49");
//		}
//
//	@Test
//	void testDrumInstrument7() {
//		String expected = "P1-I48";
//		String actual = Notes.drumInstrument("String5", 'o');
//		assertEquals(expected, actual, "The instrument should be P1-I48");
//		}
//	@Test
//	void testDrumInstrument8() {
//		String expected = "P1-I36";
//		String actual = Notes.drumInstrument("String6", 'o');
//		assertEquals(expected, actual, "The instrument should be P1-I36");
//		}
	
}
