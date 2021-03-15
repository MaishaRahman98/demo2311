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
		if(stringNum.equals("String1") || stringNum.equals("String6") ) {
			return mainNotes[fret];
			}
		else if(stringNum.equals("String2") || stringNum.equals("String7")) {
			fret+=7;
			if(fret < 12) {
			return mainNotes[fret]; 
			}
			else {
			return mainNotes[fret-12];
			}
		}
		else if(stringNum.equals("String3")) {
			fret+=2;
			if(fret < 12) {
			return mainNotes[fret]; 
			}
			else {
			return mainNotes[fret-12];
			}
		}
		else if(stringNum.equals("String4")) {
			fret+=10;
			if(fret < 12) {
			return mainNotes[fret]; 
			}
			else {
			return mainNotes[fret-12];
			}
		}
		else if(stringNum.equals("String5")) {
			fret+=5;
			if(fret < 12) {
			return mainNotes[fret]; 
			}
			else {
			return mainNotes[fret-12];
			}
		}
		else { 
			return mainNotes[fret];
		}	
	}
	public static int bassOctave(String stringNum, int fret) {
		if(stringNum.equals("String1")) {
			if(fret < 5)
				return 2; 
			else if (fret < 17)
				return 3;
			else 
				return 4;
		}
		else if(stringNum.equals("String2")) {
			if(fret < 10)
				return 2; 
			else 
				return 3;
		}
		else if(stringNum.equals("String3")) {
			if(fret < 3)
				return 1; 
			else if (fret < 15)
				return 2;
			else 
				return 3;
		}
		else if(stringNum.equals("String4")) {
			if(fret < 8)
				return 1; 
			else if (fret < 20)
				return 2;
			else 
				return 3;
		}
		else {
			if (fret == 0)
				return 0;
			else if(fret < 13)
				return 1;
			else 
				return 2;
		}
	}
	public static int guitarOctave(String stringNum, int fret) {
		if(stringNum.equals("String1")){
			if(fret < 8)
				return 4; 
			else if (fret < 20)
				return 5;
			else 
				return 6;
			}
		else if(stringNum.equals("String2")) {
			if (fret == 0)
				return 3;
			else if(fret < 13)
				return 4;
			else 
				return 5;
		}
		else if(stringNum.equals("String3")) {
			if(fret < 5)
				return 3; 
			else if (fret < 17)
				return 4;
			else 
				return 5;
		}
		else if(stringNum.equals("String4")) {
			if(fret < 10)
				return 3; 
			else 
				return 4;
		}
		else if(stringNum.equals("String5")) {
			if(fret < 3)
				return 2; 
			else if (fret < 15)
				return 3;
			else 
				return 4;
		}
		else if(stringNum.equals("String6")) {
			if(fret < 8)
				return 2; 
			else if (fret < 20)
				return 3;
			else 
				return 4;
		}
		else {//if(stringNum.equals("String5")) {
			if (fret == 0)
				return 1;
			else if(fret < 13)
				return 2;
			else 
				return 3;
		}
	
	}
	//from Lars Branch:
	public static String bassOctaves(String stringNum, int fret) {
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
	public static String drumNotes(String stringNum, int fret) {
		if(stringNum.equals("String1")) {
			
		}
		return "";
	}
	public static int drumOctave(String stringNum, int fret) {
		return 0;
	}
	public static String drumInstrument(String stringNum, char fret) {
		if(stringNum.equals("String1") && fret == 'C') {
			return "P1-150";
		}
		return "";
		
	}
}