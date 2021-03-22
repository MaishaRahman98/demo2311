package tab2mxl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class TablatureScanner extends StringInstrument {
	String text;
	window win;
	static String header;
	public static int n = 1;
	int co = 0;

	public TablatureScanner(String text) {
		this.text = text;
		this.win = win;
		this.header = header;

	}
	public String detect(String text){
		int count = 0;
		String output = "";
		String o = "";
		Scanner myReader = new Scanner(text);
		boolean check = false;
		while (myReader.hasNextLine()) {
			String s = myReader.nextLine();
			if (s.charAt(0) == ' ') {
				if (count < 4) {
					count = 0;
				}
				else {
					break;
				}
			} 
			else if (s.contains("|") && s.contains("-")) {
				count += 1;
				//Checks if the text contains 'x' or 'X', if so, then text is a drum tab
				if (s.contains("x") || s.contains("X")) {
					check = true;
				}

			}
//			else if (s.equals("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n")) {
//				//add stuff here later
//			}

		}
		if (check == false && (count == 4 || count == 5)) {
			output = TablatureScanner.callBassClass(text,count);
			//header = TablatureScanner.xmlHeader(count);
			}
		else if (check == false && (count == 6 || count == 7)) {
			output = TablatureScanner.callGuitarClass(text,count);
			
		}
		//detects if it is drum
		else if (check == true && (count == 5 || count == 6)) {
			output = TablatureScanner.callDrumClass(text, count);
		}

		else if (count < 4 || count > 7 ) {
            errorMessage.outputMessage("wrong Instrument");
        }
//		else {
//			errorMessage.outputMessage("input error");
//		}

		myReader.close();
		return output;
	}

//	public static String xmlHeader(int c) {
//		String h = "";
//		StringBuilder head = new StringBuilder();
//		if (c == 4 || c == 5) {
//			head.append("Bass Guitar");
//		}else {
//			head.append("Guitar");
//		}
//		
//        return head.toString();
//	}
	
	public static String callBassClass(String text,int count){
		Scanner myReader = new Scanner(text);
		String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "";
		StringBuilder out = new StringBuilder();
		Bass bass;
		ArrayList<String> listOfStrings = new ArrayList<String>();

		out.append(xmlHeader(count));

		int counter = 0;
		out.append(xmlHeader(count));
		
//		while (myReader.hasNextLine()) {
//			  counter++;
//			  myReader.nextLine();
//			}

		while (myReader.hasNextLine()) {
			String line = myReader.nextLine();
			if ((line.contains("|") && line.contains("-"))) {
				listOfStrings.add(line);
				if (listOfStrings.isEmpty()) {
					listOfStrings.clear();
				}
				else if (listOfStrings.size() == count || listOfStrings.size() == count) {
					s1 = (listOfStrings).get(0);
					s2 = (listOfStrings).get(1);
					s3 = (listOfStrings).get(2);
					s4 = (listOfStrings).get(3);
					// fixes no letters in front
					if (s1.charAt(0)=='|' && s2.charAt(0)=='|' && s3.charAt(0)=='|' && s4.charAt(0)=='|') {
						s1 = "G"+s1;
						s2 = "D"+s2;
						s3 = "A"+s3;
						s4 = "E"+s4;
					}
					if(listOfStrings.size() == count) {
						bass = StringInstrument.getBass(s1,s2,s3,s4);
						//out.append(bass.xmlHeader(count));
						out.append((bass.printToXML(s1, s2, s3, s4, null, null, null)));
					}
					else if(listOfStrings.size() == count) {
						s5 = (listOfStrings).get(4);
						if (s5.charAt(5)=='|') {
							s5 = "B"+s5;
						}
						bass = StringInstrument.getBass(s1,s2,s3,s4,s5);
						out.append(bass.printToXML(s1, s2, s3, s4, s5, null, null));
					}
					listOfStrings.clear();
				}
			}
		}
		out.append(endHeading());
		myReader.close();
		return out.toString();
	}

	// guitar scanner
	public static String callGuitarClass(String text,int count){
		Scanner myReader1 = new Scanner(text);
		StringBuilder out = new StringBuilder();
		String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "", s6 = "", s7 = "";
		ArrayList<String> listOfStrings = new ArrayList<String>();
		out.append(xmlHeader(count));
		Guitar guitar;
		while (myReader1.hasNextLine()) {
			String line = myReader1.nextLine();
			if (line.contains("|") && line.contains("-")) {
				listOfStrings.add(line);
				if (listOfStrings.isEmpty()) {
					listOfStrings.clear();
				}
				// test
				else if (listOfStrings.size() == count || listOfStrings.size() == 7) {
					s1 = (listOfStrings).get(0);
					s2 = (listOfStrings).get(1);
					s3 = (listOfStrings).get(2);
					s4 = (listOfStrings).get(3);
					s5 = (listOfStrings).get(4);
					s6 = (listOfStrings).get(5);
					if (s1.charAt(0)=='|' && s2.charAt(0)=='|' && s3.charAt(0)=='|' && s4.charAt(0)=='|' && s5.charAt(0)=='|' && s6.charAt(0)=='|') {
						s1 = "E"+s1;
						s2 = "B"+s2;
						s3 = "G"+s3;
						s4 = "D"+s4;
						s5 = "A"+s5;
						s6 = "D"+s6;
					}
					if(listOfStrings.size() == count) {
						guitar = StringInstrument.getGuitar(s1,s2,s3,s4,s5,s6);
						out.append(guitar.printToXML(s1, s2, s3, s4, s5, s6, null));
					}
					else if(listOfStrings.size() == count) {
						s7 = (listOfStrings).get(6);
						if (s7.charAt(5)=='|') {
							s7 = "B"+s7;
						}
						guitar = StringInstrument.getGuitar(s1,s2,s3,s4,s5,s6,s7);
						out.append(guitar.printToXML(s1, s2, s3, s4, s5, s6, s7));
					}
					listOfStrings.clear();
				}
			}
		}
		out.append(endHeading());
		myReader1.close();
		return out.toString();

	}
	//drum scanner
	public static String callDrumClass(String text,int count){
		Scanner myReader1 = new Scanner(text);
		StringBuilder out = new StringBuilder();
		String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "", s6 = "";
		ArrayList<String> listOfStrings = new ArrayList<String>();
		Drum drum;
		out.append(Drum.xmlDrumHeader(count));
		//out.append(count + "\n");
		while (myReader1.hasNextLine()) {
			//out.append("HELLO\n");
			String line = myReader1.nextLine();
			if (line.contains("|") && line.contains("-")) {
				listOfStrings.add(line);
				if (listOfStrings.isEmpty()) {
					listOfStrings.clear();
				}
			
				else if (listOfStrings.size() == count) {
					s1 = (listOfStrings).get(0);
					s2 = (listOfStrings).get(1);
					s3 = (listOfStrings).get(2);
					s4 = (listOfStrings).get(3);
					s5 = (listOfStrings).get(4);
					s6 = (listOfStrings).get(5);
				
					if(listOfStrings.size() == 5) {
						drum = Drum.getDrum(s1,s2,s3,s4,s5);
						out.append(drum.printDrumXML(s1, s2, s3, s4, s5,null));
					}
				
					else if(listOfStrings.size() == 6) {
						s6 = (listOfStrings).get(5);
						drum = Drum.getDrum(s1,s2,s3,s4,s5,s6);
						//out.append("HI\n");
						out.append(drum.printDrumXML(s1, s2, s3, s4, s5, s6));
					}
//					else if(listOfStrings.size() == count) {
//						s7 = (listOfStrings).get(6);
//						drum = Drum.getDrum(s1,s2,s3,s4,s5,s6,s7);
//						out.append(drum.printToXML(s1, s2, s3, s4, s5, s6, s7));
//					}
					listOfStrings.clear();
				}
			}
		}
		setTemp(mCount);
		out.append(Drum.endDrumHeading());
		myReader1.close();
		return out.toString();
	}

}