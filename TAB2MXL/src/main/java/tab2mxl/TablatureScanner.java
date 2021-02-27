package tab2mxl;

import java.io.File;

import java.io.FileNotFoundException;
<<<<<<< HEAD
=======
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
>>>>>>> refs/remotes/origin/Maisha_Branch
import java.util.Scanner;


public class TablatureScanner {
	String text;
	window win;
	public static int n = 1;

	public TablatureScanner(String text) {
		this.text = text;

	}
	public String detect(String text){
		int count = 0;
		String output = "";
		Scanner myReader = new Scanner(text);
		
		while (myReader.hasNextLine() ) {
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
			}
		}
		if (count == 4 || count == 5) {
			output = TablatureScanner.callBassClass(text,count);
			}
		if (count == 6 || count == 7) {
			output = TablatureScanner.callGuitarClass(text,count);
		}

		myReader.close();
		return output;
	}

	public static String callBassClass(String text,int count){
		Scanner myReader = new Scanner(text);
<<<<<<< HEAD
		String s1, s2, s3, s4, s5;
=======
		String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "";
		StringBuilder out = new StringBuilder();
>>>>>>> refs/remotes/origin/Maisha_Branch
		Bass bass;
		while (myReader.hasNextLine()) {
<<<<<<< HEAD
			String data = myReader.nextLine();
			while (data.startsWith("G|")) {
				s1 = data;
				data = myReader.nextLine();
				while (data.startsWith("D|")) {
					s2 = data;
					data = myReader.nextLine();
					while (data.startsWith("A|")) {
						s3 = data;
						data = myReader.nextLine();
						while (data.startsWith("E|")) {
							s4 = data;
							if (myReader.hasNextLine())
								data = myReader.nextLine();

							if (data.startsWith("B|")) {
								s5 = data;
								bass = StringInstrument.getBass(s1, s2, s3, s4, s5);
								bass.printToXML(s1, s2, s3, s4, s5, null, null);
								break;
							} else {
								bass = StringInstrument.getBass(s1, s2, s3, s4);
								bass.printToXML(s1, s2, s3, s4, null, null, null);
								break;
							}
						}

=======
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
					if(listOfStrings.size() == count) {
						bass = StringInstrument.getBass(s1,s2,s3,s4);
						out.append((bass.printToXML(s1, s2, s3, s4, null, null, null)));
>>>>>>> refs/remotes/origin/Maisha_Branch
					}
<<<<<<< HEAD

				}
			}

=======
					else if(listOfStrings.size() == count) {
						s5 = (listOfStrings).get(4);
						bass = StringInstrument.getBass(s1,s2,s3,s4,s5);
						out.append(bass.printToXML(s1, s2, s3, s4, s5, null, null));
					}
					listOfStrings.clear();
				}
			}
>>>>>>> refs/remotes/origin/Maisha_Branch
		}
		myReader.close();
		return out.toString();
	}

	// guitar scanner
<<<<<<< HEAD
	public static void callGuitarClass(String text) {
		
=======
	public static String callGuitarClass(String text,int count){
>>>>>>> refs/remotes/origin/Maisha_Branch
		Scanner myReader1 = new Scanner(text);
<<<<<<< HEAD
		String s1, s2, s3, s4, s5, s6, s7;
=======
		StringBuilder out = new StringBuilder();
		String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "", s6 = "", s7 = "";
		ArrayList<String> listOfStrings = new ArrayList<String>();
>>>>>>> refs/remotes/origin/Maisha_Branch
		Guitar guitar;
		while (myReader1.hasNextLine()) {
			String line = myReader1.nextLine();
<<<<<<< HEAD
			while (line.startsWith("E|")) {
				s1 = line;
				line = myReader1.nextLine();
				while (line.startsWith("B|")) {
					s2 = line;
					line = myReader1.nextLine();
					while (line.startsWith("G|")) {
						s3 = line;
						line = myReader1.nextLine();
						while (line.startsWith("D|")) {

							s4 = line;
							line = myReader1.nextLine();
							while (line.startsWith("A|")) {
								s5 = line;
								line = myReader1.nextLine();
								while (line.startsWith("E|")) {
									s6 = line;

									if (myReader1.hasNextLine())
										line = myReader1.nextLine();

									if (line.startsWith("B|")) {
										s7 = line;
										guitar = StringInstrument.getGuitar(s1, s2, s3, s4, s5, s6, s7);
										guitar.printTab();
//										guitar.printToXML(s1, s2, s3, s4, s5, s6, s7);
										break;
									} 
									else {
										System.out.println("test");
										guitar = StringInstrument.getGuitar(s1, s2, s3, s4, s5, s6);
										guitar.printTab();
										
//										guitar.printToXML(s1, s2, s3, s4, s5, s6, null);
										break;
									}
								}
							}

						}

=======
			if (line.contains("|") && line.contains("-")) {
				listOfStrings.add(line);
				if (listOfStrings.isEmpty()) {
					listOfStrings.clear();
				}
				else if (listOfStrings.size() == count || listOfStrings.size() == 7) {
					s1 = (listOfStrings).get(0);
					s2 = (listOfStrings).get(1);
					s3 = (listOfStrings).get(2);
					s4 = (listOfStrings).get(3);
					s5 = (listOfStrings).get(4);
					s6 = (listOfStrings).get(5);
					if(listOfStrings.size() == count) {
						guitar = StringInstrument.getGuitar(s1,s2,s3,s4,s5,s6);
						out.append(guitar.printToXML(s1, s2, s3, s4, s5, s6, null));
>>>>>>> refs/remotes/origin/Maisha_Branch
					}
<<<<<<< HEAD
=======
					else if(listOfStrings.size() == count) {
						s7 = (listOfStrings).get(6);
						guitar = StringInstrument.getGuitar(s1,s2,s3,s4,s5,s6,s7);
						out.append(guitar.printToXML(s1, s2, s3, s4, s5, s6, s7));
					}
					listOfStrings.clear();
>>>>>>> refs/remotes/origin/Maisha_Branch
				}
<<<<<<< HEAD

=======
>>>>>>> refs/remotes/origin/Maisha_Branch
			}
		}
<<<<<<< HEAD

=======
		
>>>>>>> refs/remotes/origin/Maisha_Branch
		myReader1.close();
		return out.toString();

	}

}