package tab2mxl;

public class Notes {
	
	final static String[] mainNotes = {"E", "F", "Gb", "G", "Ab", "A", "Bb", "B", "C", "Db", "D", "Eb", "E"};
	
	public static String bassNotes(String stringNum, int pos) {
		if(stringNum == "String1") {
			pos+= 3;
			if(pos < 12) {
			return mainNotes[pos]; 
			}
			else {
			return mainNotes[pos-12];
			}
		}
		else if(stringNum == "String2") {
			pos+=10;
			if(pos < 12) {
			return mainNotes[pos]; 
			}
			else {
			return mainNotes[pos-12];
			}
		}
		else if(stringNum == "String3") {
			pos+=5;
			if(pos < 12) {
			return mainNotes[pos]; 
			}
			else {
			return mainNotes[pos-12];
			}
		}
		else if(stringNum == "String4") {
			return mainNotes[pos]; 
		}
		else {
			pos+=7;
			if(pos < 12) {
			return mainNotes[pos]; 
			}
			else {
			return mainNotes[pos-12];
			}
		}
	}
}
