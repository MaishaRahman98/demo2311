package tab2mxl;

public class Notes {
	
	final static String[] mainNotes = {"E", "F", "Gb", "G", "Ab", "A", "Bb", "B", "C", "Db", "D", "Eb", "E"};
	
	public static String bassNotes(String stringNum, int fret) {
		if(stringNum.equals("String1")) {
			fret+= 3;
			if(fret < 12) {
			return mainNotes[fret]; 
			}
			else {
			return mainNotes[fret-12];
			
			}
		}
		else if(stringNum.equals("String2")) {
			fret+=10;
			if(fret < 12) {
			return mainNotes[fret]; 
			}
			else {
			return mainNotes[fret-12];
			}
		}
		else if(stringNum.equals("String3")) {
			fret+=5;
			if(fret < 12) {
			return mainNotes[fret]; 
			}
			else {
			return mainNotes[fret-12];
			}
		}
		else if(stringNum.equals("String4")) {
			return mainNotes[fret]; 
		}
		else {
			fret+=7;
			if(fret < 12) {
			return mainNotes[fret]; 
			}
			else {
			return mainNotes[fret-12];
			}
		}
	}
	public static String guitarNotes(String stringNum, int fret) {
		return "";
	}

}