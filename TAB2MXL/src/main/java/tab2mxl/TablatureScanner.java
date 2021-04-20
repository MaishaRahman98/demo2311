package tab2mxl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//<<<<<<< HEAD
/**
 * This class scans the tablature to determine which instrument it is from, and then creates the MusicXML output.
 * 
 * @author Group 16, EECS2311
 * 
 */

//=======
//>>>>>>> refs/remotes/origin/Lars_Branch
public class TablatureScanner extends StringInstrument {
	String text;
	window win;
	static String header;
	public static int n = 1;
	int co = 0;
//<<<<<<< HEAD

	/**
     * A default constructor for TablatureScanner
     * 
     * @param text, contains the entire text tablature
     * 
     */
//=======
// 
//>>>>>>> refs/remotes/origin/Lars_Branch
	public TablatureScanner(String text) {
		this.text = text;
		this.win = win;
		this.header = header;

	}
//<<<<<<< HEAD
	/**
	 * This method detects if the tablature (stored in �text�) is from a bass, guitar, or drum instrument.
	 * Depending on this, it calls callBassClass, callGuitarClass, or callDrumClass to get the MusicXML output. 
	 * It then returns the MusicXML output
	 * @param text
	 * @return output
	 */
//	public String detect(String text){
//=======
	public String detect(String text, int num1, int num2, String songName, String composerName){
//>>>>>>> refs/remotes/origin/Lars_Branch
		int count = 0;
		String output = "";
		String o = "";
		Scanner myReader = new Scanner(text);
		boolean check = false;
		boolean checkD = false;
		int drumCount = 0;
		
		while (myReader.hasNextLine()) {
			String s = myReader.nextLine();
			while (s.isEmpty() && myReader.hasNextLine()) {
				s = myReader.nextLine();
				//break;
			}
//			if (s.isEmpty()) {
//				break;
//			}
			if (s.contains("|") && s.contains("-")) {
				count += 1;
				//Checks if the text contains 'x' or 'X', if so, then text is a drum tab
				if (s.contains("x") || s.contains("X")) {
					// || s.contains("o") || s.contains("f")
					check = true;
					//drumCount += 1;
				}

			}
			else if (s.charAt(0) == ' ') {
				// || s.contains("")
				if (count < 4) {
					count = 0;
					//drumCount = 0;
				}
//				else if(myReader.hasNextLine() == true && check == true && count >= 4) {
//					//s = myReader.nextLine();
//					//System.out.println("HI");
//					checkD = true;
//					break;
//				}
				else{
					//System.out.println("BYE");
					break;
				}
			} 
//<<<<<<< HEAD
//			else if (s.contains("|") && s.contains("-")) {
//				count += 1;
//				//Checks if the text contains 'x' or 'X', if so, then text is a drum tab
//				if (s.contains("x") || s.contains("X")) {
//					check = true;
//				}
//
//			}
//			else if (s.equals("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n")) {
//				//add stuff here later
//			}

//=======
			else if (s.contains("|") && s.contains("-")) {
				count += 1;
			}
			else if (!s.contains("|") && !s.contains("-") && s.contains(" ")) {
				count = 0;
			}
			else if (s.contains("BEAT TYPE")) {
				//
			}
//>>>>>>> refs/remotes/origin/Lars_Branch
		}
//<<<<<<< HEAD
		if (check == false && (count == 4 || count == 5) ) {
			//output = TablatureScanner.callBassClass(text,count);
//=======
//		if (count == 4 || count == 5) {
			output = TablatureScanner.callBassClass(text,count,num1,num2,songName, composerName);
//>>>>>>> refs/remotes/origin/Lars_Branch
			//header = TablatureScanner.xmlHeader(count);
			}
//<<<<<<< HEAD
		if (check == false && (count == 6 || count == 7)) {
//			output = TablatureScanner.callGuitarClass(text,count);
//=======
//		if (count == 6 || count == 7) {
			output = TablatureScanner.callGuitarClass(text,count,num1,num2,songName, composerName);
//>>>>>>> refs/remotes/origin/Lars_Branch
			
		}
//<<<<<<< HEAD
		//detects if it is drum
		if (check == true) {
			//drumHelper(text);
			output = TablatureScanner.callDrumClass(text, count);
			
		}

//		else if (count < 3 || count > 7) {
//            errorMessage.outputMessage("wrong Instrument");
//        }
//=======
		else if (count < 4 || count > 7 && count!= 0) {
            Showtheerror.outputMessage("wrong Instrument");
        }
		else if (count == 0) {
			Showtheerror.outputMessage("Bad input");
		}
//>>>>>>> refs/remotes/origin/Lars_Branch
//		else {
//			errorMessage.outputMessage("input error");
//		}

		myReader.close();
		return output;
	}

//<<<<<<< HEAD
	public void drumHelper(String text) {
		int count = 0;
		boolean check = false;
		Scanner myReader = new Scanner(text);
		while (myReader.hasNextLine()) {
			String s = myReader.nextLine();
			if (s.contains("|") && s.contains("-")) {
				count += 1;
				//Checks if the text contains 'x' or 'X', if so, then text is a drum tab
				if (s.contains("x") || s.contains("X")) {
					// || s.contains("o") || s.contains("f")
					check = true;
					//drumCount += 1;
				}
			}
		}

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
	
	/**
	 * Assembles the MusicXML output for a bass tablature.
	 * @param text
	 * @param count
	 * @return out
	 */
//	public static String callBassClass(String text,int count){
//=======
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
	
	public static String callBassClass(String text,int count, int num1, int num2, String songName, String composerName){
//>>>>>>> refs/remotes/origin/Lars_Branch
		Scanner myReader = new Scanner(text);
		String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "";
		StringBuilder out = new StringBuilder();
		Bass bass;
		ArrayList<String> listOfStrings = new ArrayList<String>();
		int counter = 0;
//<<<<<<< HEAD
//		out.append(xmlHeader(count));
//		
//=======
		out.append(xmlHeader(num1, num2, count,songName, composerName));
		ArrayList<Integer> measureForChange = new ArrayList<Integer>();
		ArrayList<Integer> timeSigTops = new ArrayList<Integer>();
		ArrayList<Integer> timeSigBottoms = new ArrayList<Integer>();
//>>>>>>> refs/remotes/origin/Lars_Branch
//		while (myReader.hasNextLine()) {
//			  counter++;
//			  myReader.nextLine();
//			}
		while (myReader.hasNextLine()) {
			String line = myReader.nextLine();
//<<<<<<< HEAD
//=======
			String tmp = "";
			String tmp1 = "";
			String tmp2 = "";
			int x = 1;
			if (line.contains("Time signature for measure")) {
				for(int i = 0; i < line.length();i++) {
					if (line.charAt(i) == '*' && Character.isDigit(line.charAt(i+1))) {
						while(line.charAt(i+1)!='*') {
							tmp+=line.charAt(i+1);
							i++;
						}
					}
					if (line.charAt(i) == '/') {
						while(line.charAt(i-x) != ' ' && line.charAt(i) =='/') {
							tmp1 = line.charAt(i-x) + tmp1;
							x++;
						}

						while(line.charAt(i+1) != ' ') {
							tmp2+= line.charAt(i+1);
//							System.out.println(tmp2);
							i++;
						}
	
					}
				}
				measureForChange.add(Integer.parseInt(tmp));
				timeSigTops.add(Integer.parseInt(tmp1));
				timeSigBottoms.add(Integer.parseInt(tmp2));
//				System.out.println(measureForChange);
//				System.out.println(timeSigTops);
//				System.out.println(timeSigBottoms);
				x = 0;
				tmp="";
				tmp1="";
				tmp2="";
				
			}
//>>>>>>> refs/remotes/origin/Lars_Branch
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
////<<<<<<< HEAD
//						bass = StringInstrument.getBass(s1,s2,s3,s4);
//						//out.append(bass.xmlHeader(count));
//						out.append((bass.printToXML(s1, s2, s3, s4, null, null, null)));
////=======
							bass = StringInstrument.getBass(s1,s2,s3,s4);
							//out.append(bass.xmlHeader(count));
							out.append((bass.printToXML(measureForChange, timeSigTops,timeSigBottoms, num1, num2, s1, s2, s3, s4, null, null, null)));
//>>>>>>> refs/remotes/origin/Lars_Branch
					}
					else if(listOfStrings.size() == count) {
						s5 = (listOfStrings).get(4);
						if (s5.charAt(5)=='|') {
							s5 = "B"+s5;
						}
						bass = StringInstrument.getBass(s1,s2,s3,s4,s5);
						out.append(bass.printToXML(measureForChange, timeSigTops,timeSigBottoms, num1, num2, s1, s2, s3, s4, s5, null, null));
						
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
//<<<<<<< HEAD
	/**
	 * Assembles the MusicXML output for a guitar tablature
	 * @param text
	 * @param count
	 * @return out
	 */
//	public static String callGuitarClass(String text,int count){
//=======
	public static String callGuitarClass(String text,int count, int num1, int num2, String songName, String composerName){
//>>>>>>> refs/remotes/origin/Lars_Branch
		Scanner myReader1 = new Scanner(text);
		StringBuilder out = new StringBuilder();
		String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "", s6 = "", s7 = "";
		ArrayList<String> listOfStrings = new ArrayList<String>();
//<<<<<<< HEAD
//		out.append(xmlHeader(count));
//=======
		out.append(xmlHeader(num1, num2, count,songName,composerName));
		int timeSigTop = 0;
		int timeSigBottom = 0;
//>>>>>>> refs/remotes/origin/Lars_Branch
		Guitar guitar;
		ArrayList<Integer> measureForChange = new ArrayList<Integer>();
		ArrayList<Integer> timeSigTops = new ArrayList<Integer>();
		ArrayList<Integer> timeSigBottoms = new ArrayList<Integer>();
		while (myReader1.hasNextLine()) {
			String line = myReader1.nextLine();
			String tmp = "";
			String tmp1 = "";
			String tmp2 = "";
			int x = 1;
			if (line.contains("Time signature for measure")) {
				for(int i = 0; i < line.length();i++) {
					if (line.charAt(i) == '*' && Character.isDigit(line.charAt(i+1))) {
						while(line.charAt(i+1)!='*') {
							tmp+=line.charAt(i+1);
							i++;
						}
					}
					if (line.charAt(i) == '/') {
						while(line.charAt(i-x) != ' ' && line.charAt(i) =='/') {
							tmp1 = line.charAt(i-x) + tmp1;
							x++;
						}

						while(line.charAt(i+1) != ' ') {
							tmp2+= line.charAt(i+1);
//							System.out.println(tmp2);
							i++;
						}
	
					}
				}
				measureForChange.add(Integer.parseInt(tmp));
				timeSigTops.add(Integer.parseInt(tmp1));
				timeSigBottoms.add(Integer.parseInt(tmp2));
//				System.out.println(measureForChange);
//				System.out.println(timeSigTops);
//				System.out.println(timeSigBottoms);
				x = 0;
				tmp="";
				tmp1="";
				tmp2="";
			}
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
//<<<<<<< HEAD
					//}
//					if(listOfStrings.size() == count) {
//						guitar = StringInstrument.getGuitar(s1,s2,s3,s4,s5,s6);
//						out.append(guitar.printToXML(s1, s2, s3, s4, s5, s6, null));
//=======
//>>>>>>> refs/remotes/origin/Lars_Branch
					}
					if(listOfStrings.size() == 6) {
						guitar = StringInstrument.getGuitar(s1,s2,s3,s4,s5,s6);
						out.append(guitar.printToXML(measureForChange, timeSigTops, timeSigBottoms, num1, num2, s1, s2, s3, s4, s5, s6, null));
					}
					else if(listOfStrings.size() == 7) {
						s7 = (listOfStrings).get(6);
						if (s7.charAt(5)=='|') {
							s7 = "B"+s7;
						}
						guitar = StringInstrument.getGuitar(s1,s2,s3,s4,s5,s6,s7);
						out.append(guitar.printToXML(measureForChange, timeSigTops, timeSigBottoms,num1, num2, s1, s2, s3, s4, s5, s6, s7));
						
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
	/**
	 * Assembles the MusicXML output for a drum tablature
	 * @param text
	 * @param count
	 * @return out
	 */
	public static String callDrumClass(String text,int count){
		Scanner myReader1 = new Scanner(text);
		StringBuilder out = new StringBuilder();
		String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "", s6 = "", s7 = "", s8 = "";
		ArrayList<String> listOfStrings = new ArrayList<String>();
		Drum drum;
		int newCount = 0;
		int r1 = 0,r2 = 0, rX = 0;
		boolean end1 = false, end2 =false;
		out.append(Drum.xmlDrumHeader(count));
		//out.append(count + "\n");
		while (myReader1.hasNextLine()) {
			//out.append("HELLO\n");
			String line = myReader1.nextLine();
			if (line.contains("|") && line.contains("-") && !line.contains("REPEAT")) {
				listOfStrings.add(line);
				newCount++;
				end1 = true;
				end2 = false;
				if (listOfStrings.isEmpty()) {
					listOfStrings.clear();
				}
			}
			else if (!line.contains("|") || !line.contains("-") && end1)
				end2 = true;
			
			else if (line.contains("REPEAT"))
			{
				r1 = line.indexOf('|') - 2;
				r2 = line.lastIndexOf('|') - 2;
				rX = Character.getNumericValue(line.charAt(line.indexOf('X') -1));
			}
				
				
				 if (end1 && end2) {
			
//				else if (listOfStrings.size() == count) {
					// || listOfStrings.size() == 6 || listOfStrings.size() == 7
					
					if (listOfStrings.size() == 3) {
						s1 = (listOfStrings).get(0);
						s2 = (listOfStrings).get(1);
						s3 = (listOfStrings).get(2);
						drum = Drum.getDrum(s1,s2,s3);
						out.append(drum.printDrumXML(r1, r2, rX,  s1, s2, s3, null, null, null, null, null));
					}
					if (listOfStrings.size() == 4) {
						s1 = (listOfStrings).get(0);
						s2 = (listOfStrings).get(1);
						s3 = (listOfStrings).get(2);
						s4 = (listOfStrings).get(3);
						drum = Drum.getDrum(s1,s2,s3, s4);
						out.append(drum.printDrumXML(r1, r2, rX,  s1, s2, s3, s4, null, null, null, null));
					}
					if(listOfStrings.size() == 5) {
						s1 = (listOfStrings).get(0);
						s2 = (listOfStrings).get(1);
						s3 = (listOfStrings).get(2);
						s4 = (listOfStrings).get(3);
						s5 = (listOfStrings).get(4);
						
						if (s1.charAt(0)=='|' && s2.charAt(0)=='|' && s3.charAt(0)=='|' && s4.charAt(0)=='|' && s5.charAt(0)=='|') {
							s1 = "CC"+s1;
							s2 = "HH"+s2;
							s3 = "SD"+s3;
							s4 = "HT"+s4;
							s5 = "MT"+s5;	
						}
						
						drum = Drum.getDrum(s1,s2,s3,s4,s5);
						//out.append("Five\n");
						out.append(drum.printDrumXML(r1, r2, rX,  s1, s2, s3, s4, s5, null, null, null));
					}
					else if(listOfStrings.size() == 6) {
						s1 = (listOfStrings).get(0);
						s2 = (listOfStrings).get(1);
						s3 = (listOfStrings).get(2);
						s4 = (listOfStrings).get(3);
						s5 = (listOfStrings).get(4);
						s6 = (listOfStrings).get(5);
						if (s1.charAt(0)=='|' && s2.charAt(0)=='|' && s3.charAt(0)=='|' && s4.charAt(0)=='|' && s5.charAt(0)=='|' && s6.charAt(0)=='|') {
							s1 = "CC"+s1;
							s2 = "HH"+s2;
							s3 = "SD"+s3;
							s4 = "HT"+s4;
							s5 = "MT"+s5;
							s6 = "BD"+s6;
						}
						drum = Drum.getDrum(s1,s2,s3,s4,s5,s6);
						//out.append("Six\n");
						out.append(drum.printDrumXML(r1, r2, rX,  s1, s2, s3, s4, s5, s6, null, null));
					}
					else if(listOfStrings.size() == 7) {
						s1 = (listOfStrings).get(0);
						s2 = (listOfStrings).get(1);
						s3 = (listOfStrings).get(2);
						s4 = (listOfStrings).get(3);
						s5 = (listOfStrings).get(4);
						s6 = (listOfStrings).get(5);
						s7 = (listOfStrings).get(6);
						
						if (s1.charAt(0)=='|' && s2.charAt(0)=='|' && s3.charAt(0)=='|' && s4.charAt(0)=='|' && s5.charAt(0)=='|' && s6.charAt(0)=='|' && s7.charAt(0)=='|') {
							s1 = "CC"+s1;
							s2 = "HH"+s2;
							s3 = "SD"+s3;
							s4 = "HT"+s4;
							s5 = "MT"+s5;
							s6 = "BD"+s6;
							s7 = "FT"+s7;
						}
						drum = Drum.getDrum(s1,s2,s3,s4,s5,s6,s7);
						out.append(drum.printDrumXML(r1, r2, rX,  s1, s2, s3, s4, s5, s6, s7, null));
					}
					else if(listOfStrings.size() == 8) {
						s1 = (listOfStrings).get(0);
						s2 = (listOfStrings).get(1);
						s3 = (listOfStrings).get(2);
						s4 = (listOfStrings).get(3);
						s5 = (listOfStrings).get(4);
						s6 = (listOfStrings).get(5);
						s7 = (listOfStrings).get(6);
						s8 = (listOfStrings).get(7);
						if (s1.charAt(0)=='|' && s2.charAt(0)=='|' && s3.charAt(0)=='|' && s4.charAt(0)=='|' && s5.charAt(0)=='|' && s6.charAt(0)=='|' && s7.charAt(0)=='|' && s8.charAt(0)=='|') {
							s8 = "T3"+s8;
						}
						drum = Drum.getDrum(s1,s2,s3,s4,s5,s6,s7, s8);
						out.append(drum.printDrumXML(r1, r2, rX,  s1, s2, s3, s4, s5, s6, s7, null));
					}
					listOfStrings.clear();
					end1 = end2 = false;
					r1 = r2 = rX = 0;
				}

//<<<<<<< HEAD
		}
		//setTemp(mCount);
		//mCount = 0; //resets mCount
		out.append(Drum.endDrumHeading());
		if (mCount > 0) {
			mCount = 0;
		}
		myReader1.close();
		return out.toString();
	}
//=======
//>>>>>>> refs/remotes/origin/Lars_Branch
}