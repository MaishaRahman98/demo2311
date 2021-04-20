package tab2mxl;

public class Notes {
	
	final static String[] mainNotes = {"E", "F", "Gb", "G", "Ab", "A", "Bb", "B", "C", "Db", "D", "Eb", "E"};
	
	public static String bassNotes(String stringNum, int fret) {
		if(stringNum.equals("String1")) {
			fret+= 3;
				while (fret > 12)
					fret = fret - 12;
			return mainNotes[fret];
			
		}
		else if(stringNum.equals("String2")) {
			fret+=10;
			while (fret > 12)
				fret = fret - 12;
		return mainNotes[fret];
		}
		else if(stringNum.equals("String3")) {
			fret+=5;
			while (fret > 12)
				fret = fret - 12;
		return mainNotes[fret];
		}
		else if(stringNum.equals("String4")) {
			while (fret > 12)
				fret = fret - 12;
			return mainNotes[fret]; 
		}
		else {
			fret+=7;
			while (fret > 12)
				fret = fret - 12;
		return mainNotes[fret];
		}
	}
	public static String guitarNotes(String stringNum, int fret) {
		if(stringNum.equals("String1") || stringNum.equals("String6") ) {
			while (fret > 12)
				fret = fret - 12;
		return mainNotes[fret];
			}
		else if(stringNum.equals("String2") || stringNum.equals("String7")) {
			fret+=7;
			while (fret > 12)
				fret = fret - 12;
		return mainNotes[fret];
		}
		else if(stringNum.equals("String3")) {
			fret+=2;
			while (fret > 12)
				fret = fret - 12;
		return mainNotes[fret];
		}
		else if(stringNum.equals("String4")) {
			fret+=10;
			while (fret > 12)
				fret = fret - 12;
		return mainNotes[fret];
		}
		else if(stringNum.equals("String5")) {
			fret+=5;
			while (fret > 12)
				fret = fret - 12;
		return mainNotes[fret];
		}
		else { 
			while (fret > 12)
				fret = fret - 12;
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
	//"E", "F", "Gb", "G", "Ab", "A", "Bb", "B", "C", "Db", "D", "Eb", "E"}
	public static String drumNotes(String stringNum) {
		if(stringNum.equals("String1")) { //crash cymbal
			
		return mainNotes[5];

			}
		else if(stringNum.equals("String2")) { //Hi Hat
			
			return mainNotes[3];
		}
		else if(stringNum.equals("String3")) { // Snare Drum 
			
			return mainNotes[8];
		}
		else if(stringNum.equals("String4")) { //High Tom
			
		return mainNotes[0];
		}
		else if(stringNum.equals("String5")) { //Mid Tom
			return mainNotes[10];
		}
		else // if(stringNum.equals("String6")) { //Snare Drum
			return mainNotes[1];
		
	}
	//	else if(stringNum.equals("String7")) { //Floor Tom
//			return mainNotes[10];
	//	}
		//else  { //Bass Drum
	//		return mainNotes[10];
		//}
		
	//}
	//"E", "F", "Gb", "G", "Ab", "A", "Bb", "B", "C", "Db", "D", "Eb", "E"}
	public static int drumOctave(String stringNum) {
		if(stringNum.equals("String1")){
			return 5;
		}
			
		else if(stringNum.equals("String2")) {
			return 5;
	
		}
		else if(stringNum.equals("String3")) {
			
				return 5;
		}
		else if(stringNum.equals("String4")) {
		
				return 5;
		}
		else if(stringNum.equals("String5")) {
			
				return 5;
		}
		else //if(stringNum.equals("String6")) {
			
				return 4;
		//}
		//else {
			//return 4;
		//}
	
	//public static String drumInstrument(String stringNum, char fret, String name) {
		//if(name.equals("CC") && fret == 'x') {
		//	return "P1-I50";//Crash Cymbal 1
		//}
		//if (name.equals("HH") && fret == 'o') {
			//return "P1-I47"; //Open Hi-Hat
		//}
		//if (name.equals("HH") && fret == 'x') {
			//return "P1-I43"; //closed Hi-Hat
		//}
		//if (name.equals("HH") && fret == 'O'){
			//return "P1-I45"; // Pedal Hi-Hat
		//}
		//if (name.equals("SD") && fret == 'o') {
			//return "P1-I39"; //snare
		//}
		//if (name.equals("HT") && fret == 'o') {
		//	return "P1-I51"; //High Tom
		//}
		//if (name.equals("MT") && fret == 'o') {
			//return "P1-I49"; // mid-tom
		//}
		//if (name.equals("FT") && fret == 'o') {
			//return "P1-I42"; //floor tom
		//}
		//else if (name.equals("BD") && fret == 'o') {
			//return "P1-I36";
		//}
		
	   
	   
	// return "";
		
		
		
		
	}
}