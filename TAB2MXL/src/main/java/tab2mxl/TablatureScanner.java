package tab2mxl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TablatureScanner {
	String texta;
	window win;

	public TablatureScanner(window win) {
		this.win = win;

	}

	public void detect(String text) {
		int count = 0;
		Scanner myReader = new Scanner(text);
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
			else if (s.charAt(1) == '|' && s.endsWith("|")) {
				count += 1;
			}
		}
		System.out.println(count);
		if (count == 4 || count == 5) {
			TablatureScanner.callBassClass(text);
		}
		if (count == 6 || count == 7) {
			TablatureScanner.callGuitarClass(text);
		}

		myReader.close();
	}

	public static void callBassClass(String text) {
		Scanner myReader = new Scanner(text);
		String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "";
		Bass bass;
		ArrayList<String> listOfStrings = new ArrayList<String>();
		while (myReader.hasNextLine()) {
			String line = myReader.nextLine();
			
			if (line.charAt(0) == ' ') {
				if (listOfStrings.isEmpty()) {
					listOfStrings.clear();
				}
				else if (listOfStrings.size() == 4 || listOfStrings.size() == 5) {
					s1 = (listOfStrings).get(0);
					s2 = (listOfStrings).get(1);
					s3 = (listOfStrings).get(2);
					s4 = (listOfStrings).get(3);
					
					if(listOfStrings.size() == 4) {
						bass = StringInstrument.getBass(s1,s2,s3,s4);
						bass.printToXML(s1, s2, s3, s4, null, null, null);
					}
					else if(listOfStrings.size() == 5) {
						s5 = (listOfStrings).get(4);
						bass = StringInstrument.getBass(s1,s2,s3,s4,s5);
						bass.printToXML(s1, s2, s3, s4, s5, null, null);
					}
					listOfStrings.clear();
				}
				else {
					System.out.println("pass");
				}
			}
			else if ((line.charAt(1) == '|')) {
				listOfStrings.add(line);
			}
		}

		myReader.close();

	}

	// guitar scanner
	public static void callGuitarClass(String text) {
		Scanner myReader1 = new Scanner(text);
		String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "", s6 = "", s7 = "";
		ArrayList<String> listOfStrings = new ArrayList<String>();
		Guitar guitar;
		while (myReader1.hasNextLine()) {
			String line = myReader1.nextLine();
			
			if (line.charAt(0) == ' ') {
				if (listOfStrings.isEmpty()) {
					listOfStrings.clear();
				}
				else if (listOfStrings.size() == 6 || listOfStrings.size() == 7) {
					s1 = (listOfStrings).get(0);
					s2 = (listOfStrings).get(1);
					s3 = (listOfStrings).get(2);
					s4 = (listOfStrings).get(3);
					s5 = (listOfStrings).get(4);
					s6 = (listOfStrings).get(5);
					
					if(listOfStrings.size() == 6) {
						guitar = StringInstrument.getGuitar(s1,s2,s3,s4,s5,s6);
						guitar.printToXML(s1, s2, s3, s4, s5, s6, null);
					}
					else if(listOfStrings.size() == 7) {
						s7 = (listOfStrings).get(6);
						guitar = StringInstrument.getGuitar(s1,s2,s3,s4,s5,s6,s7);
						guitar.printToXML(s1, s2, s3, s4, s5, s6, s7);
					}
					listOfStrings.clear();
				}
				else {
					System.out.println("pass");
				}
			}
			else if ((line.charAt(1) == '|' && line.endsWith("|"))) {
				listOfStrings.add(line);
			}
		}
		myReader1.close();

	}

}
