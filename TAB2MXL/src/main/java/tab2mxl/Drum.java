package tab2mxl;

import java.util.ArrayList;

public class Drum {
	
	private static String str1;
	private static String str2;
	private static String str3;
	private static String str4;
	private static String str5;
	private static String str6;
	private static String str7;
	private char strNum; //number of strings
	int measureCount = 0;
	static int temp = 0;
	public int c = 0;
	//edit 3:
	//public static int mCount = 0; //this caused the bug where the measure numbers were incorrect and would not reset after translation of each drum tab
	public static int mCount = 0;
	static boolean repEnd = false;
	
	private Drum() {
		this.strNum = ' ';
		this.str1 = "";
		this.str2 = "";
		this.str3 = "";
		this.str4 = "";
		this.str5 = "";
		this.str6 = "";
		this.str7 = "";
	}
	private Drum(String s1, String s2, String s3, String s4, String s5) {
		this.str1 = s1;
		this.str2 = s2;
		this.str3 = s3;
		this.str4 = s4;	
		this.str5 = s5;	
		this.strNum = '5';
	}
	private Drum(String s1, String s2, String s3, String s4, String s5, String s6) {
		this(s1, s2, s3, s4, s5);
		this.str6 = s6;	
		this.strNum = '6';
	}
	private Drum(String s1, String s2, String s3, String s4, String s5, String s6, String s7) {
		this(s1, s2, s3, s4, s5, s6);
		this.str7 = s7;	
		this.strNum = '7';
	}
	public static Drum getInstance(String s1, String s2, String s3, String s4, String s5, String s6, String s7) {
		
		return new Drum(s1, s2, s3, s4, s5, s6, s7);
	}
	public static Drum getInstance(String s1, String s2, String s3, String s4, String s5, String s6) {
		
		return new Drum(s1, s2, s3, s4, s5, s6);
	}
	public static Drum getInstance(String s1, String s2, String s3, String s4, String s5) {
		
		return new Drum(s1, s2, s3, s4, s5);
	}
	
	public static String xmlDrumHeader(int c) {
		//System.out.println("Hello");
		String instrument = "";
		StringBuilder head = new StringBuilder();
		//head.append("Hello");
		if (c == 6 || c == 5 || c == 7) {
			instrument = "Drumset";
		}
		head.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        head.append("<!DOCTYPE score-partwise PUBLIC \"-//Recordare//DTD MusicXML 3.1 Partwise//EN\" \"http://www.musicxml.org/dtds/partwise.dtd\">\n");
        head.append("<score-partwise version=\"3.1\">\n");
       
        head.append(" <part-list>\n");
        head.append("  <score-part id=\"P1\">\n");
        head.append("   <part-name>" + "Drumset" + "</part-name>\n");
        head.append("   <score-instrument id=\"P1-I36\">\n");
        head.append("    <instrument-name>Bass Drum 1</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I37\">\n");
        head.append("    <instrument-name>Bass Drum 2</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I38\">\n");
        head.append("    <instrument-name>Side Stick</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I39\">\n");
        head.append("    <instrument-name>Snare</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I42\">\n");
        head.append("    <instrument-name>Low Floor Tom</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I43\">\n");
        head.append("    <instrument-name>Closed Hi-Hat</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I44\">\n");
        head.append("    <instrument-name>High Floor Tom</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I45\">\n");
        head.append("    <instrument-name>Pedal Hi-Hat</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I46\">\n");
        head.append("    <instrument-name>Low Tom</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I47\">\n");
        head.append("    <instrument-name>Open Hi-Hat</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I48\">\n");
        head.append("    <instrument-name>Low-Mid Tom</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I49\">\n");
        head.append("    <instrument-name>High-Mid Tom</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I50\">\n");
        head.append("    <instrument-name>Crash Cymbal 1</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I51\">\n");
        head.append("    <instrument-name>High Tom</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I52\">\n");
        head.append("    <instrument-name>Ride Cymbal 1</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I53\">\n");
        head.append("    <instrument-name>Chinese Cymbal</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I54\">\n");
        head.append("    <instrument-name>Ride Bell</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I55\">\n");
        head.append("    <instrument-name>Tambourine</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I56\">\n");
        head.append("    <instrument-name>Splash Cymbal</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I57\">\n");
        head.append("    <instrument-name>Cowbell</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I58\">\n");
        head.append("    <instrument-name>Crash Cymbal 2</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I60\">\n");
        head.append("    <instrument-name>Ride Cymbal 2</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I64\">\n");
        head.append("    <instrument-name>Open Hi Conga</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   <score-instrument id=\"P1-I65\">\n");
        head.append("    <instrument-name>Low Conga</instrument-name>\n");
        head.append("    </score-instrument>\n");
        head.append("   </score-part>\n");
        head.append("  </part-list>\n");
        head.append("   <part id=\"P1\">\n");
        head.append("    <measure number=\"1\">\n");
        head.append("     <attributes>\n");
        head.append("      <divisions>4</divisions>\n");
        head.append("       <key>\n");
        head.append("        <fifths>0</fifths>\n");
        head.append("        </key>\n");
        head.append("       <time>\n");
        head.append("        <beats>4</beats>\n");
        head.append("        <beat-type>4</beat-type>\n");
        head.append("        </time>\n");
        head.append("       <clef>\n");
        head.append("        <sign>percussion</sign>\n");
        head.append("        <line>2</line>\n");
        head.append("        </clef>\n");
        head.append("       </attributes>\n");
        return head.toString();
	}	
	
	//Will edit this part
	public String printDrumXML(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
		StringBuilder body = new StringBuilder();
		String note = "";
		String instrument = "";
//		String string = "";
//		String output = "";
//		int spaceCount = 0;
		ArrayList<String> legatoOutput = new ArrayList<>();
		boolean legatoCheck = false;
		boolean legatoStop = false;
		int legatoFret = 0;
		String legatoType = "";
		String legatoFullName = "";
		String text = "";
		char fret = 0;
		int stringNum = 0;
		String[] allStrings = {str1, str2, str3, str4, str5, str6, str7};
//		String name;
		int octave = 0;

	//	int numMeasureCount = 1;
		int counter = 0;
		ArrayList<ArrayList<Character> > listOfColumns =  new ArrayList<ArrayList<Character>>();
		String noteType = "";
		int digit = 0;
		int beat = 4, beatType = 4;
		int total = 0;
		boolean rep = false;
		boolean graceToken = false;
		int beatCount8 = 0;
		int beatCount16 = 0;
		
		for (int i = 1 ; i <str1.length() ; i++)
		{
			if((i+1)!= str1.length()  && str1.charAt(i)=='|' && str1.charAt(i+1) == '-') {
				measureCount++;
			}
		}
		
		for (int i = str1.indexOf('|') + 1 ; i < str1.lastIndexOf('|'); i++) {
			ArrayList<Character> column = new ArrayList<Character>();
			column.add(str1.charAt(i));
			column.add(str2.charAt(i));
			column.add(str3.charAt(i));
			column.add(str4.charAt(i));
			if (str5 != null && str6 == null && str7 == null) {
				column.add(str5.charAt(i));
			} else if (str5 != null && str6 != null && str7 == null) {
				column.add(str5.charAt(i));
				column.add(str6.charAt(i));
			} else if (str5 != null && str6 != null && str7 != null) {
				column.add(str5.charAt(i));
				column.add(str6.charAt(i));
				column.add(str7.charAt(i));
			}
			listOfColumns.add(column);
		}
		
		for (ArrayList<Character> s : listOfColumns) {
			int c = 0;
			if (s == null) break;
			while (c < s.size() && s.get(c) != '|') {
				if (s.get(c) != '|')
				{
					total++;
					break;
				}
				c++;
			}
			if (c == s.size()) c--;
			if (s.get(c) == '|')
				break;
		}
		total--;




		if (mCount != 0) {
			body.append("  </measure>\n");
			body.append("  <measure number=\"" + (mCount + 1) + "\">\n");
		}		
			
			if (listOfColumns.get(listOfColumns.size() - 1).contains('|') && listOfColumns.get(listOfColumns.size() - 1).toString().matches(".*\\d.*")) {
				rep = true;

			}
			//for (int i = 0; i < listOfColumns.size(); i++) {
				//Measure measure = new Measure("");
				
			//	if (listOfColumns.get(i).contains('|')) {
				//	mCount++; //mCount must start at being zero when we translate each drum tab
					//fixed the spacing:
					//body.append(" </measure>\n");
					//body.append("<measure number=\"" + (mCount + 1) + "\">\n");
				//}


			

			for (int i = 0; i < listOfColumns.size(); i++) {
				Measure measure = new Measure("");

//				String sss = listOfColumns.get(i).toString();
//				boolean b = listOfColumns.get(i).toString().matches(".*\\d.*");

//				if (listOfColumns.get(i).contains('|')) {
//					mCount++; //mCount must start at being zero when we translate each drum tab
//					//fixed the spacing:
//					body.append(" </measure>\n");
//					body.append("<measure number=\"" + (mCount + 1) + "\">\n");
//				}

				if (listOfColumns.get(i).contains('|') && !listOfColumns.get(i).toString().matches(".*\\d.*")) {
					if (i != listOfColumns.size() - 1 && !listOfColumns.get(i+1).contains('|')) {
					mCount++;
					body.append("  </measure>\n");
					body.append(" <measure number=\"" + (mCount + 1) + "\">\n");
					}
					
				}
				if (rep && i != listOfColumns.size() - 1 && listOfColumns.get(i+1).contains('*')) {
					body.append("<barline location=\"left\">\n");
					body.append("<bar-style>heavy-light</bar-style>\n");
					body.append("<repeat direction=\"forward\"/>\n");
					body.append("</barline>\n");
					body.append("<direction placement=\"above\">\n");
					body.append("<direction-type>\n");
					body.append("<words relative-x=\"256.17\" relative-y=\"16.01\">Repeat " + listOfColumns.get(listOfColumns.size() - 1).get(0) + " times</words>\n");
					body.append("</direction-type>\n");
					body.append("</direction>\n");
					rep = false;
					repEnd = true;
				}
	
				for (int a = 0; a < listOfColumns.get(i).size(); a++) {
					if (listOfColumns.get(i).get(a) == 'x' || listOfColumns.get(i).get(a) == 'X' || listOfColumns.get(i).get(a) == 'o' || listOfColumns.get(i).get(a) == 'f') {
						digit++;
					}
				}
				
				if (digit >= 1 && !listOfColumns.get(i).contains('|')) {
					for (int j = 0; j < listOfColumns.get(i).size(); j++) {
					
						stringNum++;
						
						if (listOfColumns.get(i).get(j) == 'x' || listOfColumns.get(i).get(j) == 'X' || listOfColumns.get(i).get(j) == 'o' || listOfColumns.get(i).get(j) == 'f') {
							int origini = i;
							fret = listOfColumns.get(i).get(j);
							
							//flams are grace notes:
							if(listOfColumns.get(i).get(j) == 'f') {
								graceToken = true;
								
							}
						
							
							
							note = Notes.drumNotes("String" + String.valueOf(stringNum) ,Character.getNumericValue(fret));
							octave = Notes.drumOctave("String" + String.valueOf(stringNum) ,Character.getNumericValue(fret));
							
							instrument = Notes.drumInstrument("String" + String.valueOf(stringNum), fret);
							
//							body.append(" <note>\n");
							//if flams exist, then it is a grace note:
							if (graceToken == true) {
								body.append(" <note>\n");
								body.append("  <grace/> \n");
								graceToken = false;
								body.append("  <unpitched>\n");
								if (note.length() == 1) { 
									body.append("   <display-step>" +  note + "</display-step>\n");
								}
								else
								{
									body.append("   <display-step>" +  note.charAt(0) + "</display-step>\n");
			
								}
								body.append("   <display-octave>" +  octave + "</display-octave>\n"); //octave needs to be implemented
								body.append("   </unpitched>\n");
							
								i = origini;
								counter = -1;
								boolean bool = true;
								while (bool){
									i++;
									if (i == listOfColumns.size())
										break;
									for (int a = 0; a < listOfColumns.get(i).size(); a++) {
										if (listOfColumns.get(i).get(a) == 'x' || listOfColumns.get(i).get(a) == 'X' || listOfColumns.get(i).get(a) == 'o' || listOfColumns.get(i).get(j) == 'f')
										{
												bool = false;
												break;
										}
									}		
									counter++;
								}
								//counter++;
								i = origini;
								
								//body.append("  <duration>" + (counter + 1) + "</duration>\n"); //will need to edit duration later
								if (counter != -1)
									body.append(" <duration>" + (counter + 1) + "</duration>\n");
								else
									body.append(" <duration>" +  "1" + "</duration>\n");
								body.append("  <instrument id=\"" + instrument + "\"/>\n"); //states what type of drum it is. Needs to be implemented properly later
								body.append("  <voice>1</voice>\n");
								body.append("  <type>" + measure.getDuration(counter + 1 ,total ,beat , beatType) + "</type>\n"); //will need to edit type later
								body.append("  <stem>up</stem>\n");
								if (listOfColumns.get(i).get(j) == 'x' || listOfColumns.get(i).get(j) == 'X') {
									body.append("  <notehead>x</notehead>\n"); //only cymbal lines (C, H, R) have x
								}
								
								if(measure.getDuration(counter + 1 ,total ,beat , beatType).equals("eighth")) {
									beatCount8++;
									if (beatCount8 == 1) {
										body.append("  <beam number=\"1\">begin</beam>\n");
									}
									if (beatCount8 >= 2 && beatCount8 < 4) {
										body.append("  <beam number=\"1\">continue</beam>\n"); //need to implement this later
									}else if (beatCount8 == 4) {
										body.append("  <beam number=\"1\">end</beam>\n");
										beatCount8 = 0;
									}
								}
								if(measure.getDuration(counter + 1 ,total ,beat , beatType).equals("16th")) {
									beatCount16++;
									if (beatCount16 == 1) {
										body.append("  <beam number=\"1\">begin</beam>\n");
										body.append("  <beam number=\"2\">begin</beam>\n");
									}
									if (beatCount16 >= 2 && beatCount16 < 8) {
										body.append("  <beam number=\"1\">continue</beam>\n"); //need to implement this later
										body.append("  <beam number=\"2\">continue</beam>\n");
									}else if (beatCount16 == 8) {
										body.append("  <beam number=\"1\">end</beam>\n");
										body.append("  <beam number=\"2\">end</beam>\n");
										beatCount16 = 0;
									}
								}
								body.append("  </note>\n");
							}
							body.append(" <note>\n");
							body.append("  <unpitched>\n");
							if (note.length() == 1) { 
								body.append("   <display-step>" +  note + "</display-step>\n");
							}
							else
							{
								body.append("   <display-step>" +  note.charAt(0) + "</display-step>\n");
		
							}
							body.append("   <display-octave>" +  octave + "</display-octave>\n"); //octave needs to be implemented
							body.append("   </unpitched>\n");
						
							i = origini;
							counter = -1;
							boolean bool = true;
							while (bool){
								i++;
								if (i == listOfColumns.size())
									break;
								for (int a = 0; a < listOfColumns.get(i).size(); a++) {
									if (listOfColumns.get(i).get(a) == 'x' || listOfColumns.get(i).get(a) == 'X' || listOfColumns.get(i).get(a) == 'o' || listOfColumns.get(i).get(j) == 'f')
									{
											bool = false;
											break;
									}
								}		
								counter++;
							}
							//counter++;
							i = origini;
							
							//body.append("  <duration>" + (counter + 1) + "</duration>\n"); //will need to edit duration later
							if (counter != -1)
								body.append(" <duration>" + (counter + 1) + "</duration>\n");
							else
								body.append(" <duration>" +  1 + "</duration>\n");
							body.append("  <instrument id=\"" + instrument + "\"/>\n"); //states what type of drum it is. Needs to be implemented properly later
							body.append("  <voice>1</voice>\n");
							body.append("  <type>" + measure.getDuration(counter + 1 ,total ,beat , beatType) + "</type>\n"); //will need to edit type later
							body.append("  <stem>up</stem>\n");
							if (listOfColumns.get(i).get(j) == 'x' || listOfColumns.get(i).get(j) == 'X') {
								body.append("  <notehead>x</notehead>\n"); //only cymbal lines (C, H, R) have x
							}
							
							if(measure.getDuration(counter + 1 ,total ,beat , beatType).equals("eighth")) {
								beatCount8++;
								if (beatCount8 == 1) {
									body.append("  <beam number=\"1\">begin</beam>\n");
								}
								if (beatCount8 >= 2 && beatCount8 < 4) {
									body.append("  <beam number=\"1\">continue</beam>\n"); //need to implement this later
								}else if (beatCount8 == 4) {
									body.append("  <beam number=\"1\">end</beam>\n");
									beatCount8 = 0;
								}
							}
							if(measure.getDuration(counter + 1 ,total ,beat , beatType).equals("16th")) {
								beatCount16++;
								if (beatCount16 == 1) {
									body.append("  <beam number=\"1\">begin</beam>\n");
									body.append("  <beam number=\"2\">begin</beam>\n");
								}
								if (beatCount16 >= 2 && beatCount16 < 8) {
									body.append("  <beam number=\"1\">continue</beam>\n"); //need to implement this later
									body.append("  <beam number=\"2\">continue</beam>\n");
								}else if (beatCount16 == 8) {
									body.append("  <beam number=\"1\">end</beam>\n");
									body.append("  <beam number=\"2\">end</beam>\n");
									beatCount16 = 0;
								}
								//body.append("  <beam number=\"1\">continue</beam>\n"); //need to implement this later
								//body.append("  <beam number=\"2\">continue</beam>\n");
							}
							body.append("  </note>\n");            	
						}	
					}
					digit = 0;
					stringNum = 0;
			} else {
				digit = 0;
				stringNum = 0;
			}
		}
		//} for (int k = 0; k < measureCount; k++) {
		
		//edit 2:
		//mCount++; //this caused the bug where the measure numbers were incorrect and would not reset after translation of each drum tab
		mCount++; //resets mCount to 0
		
		//return "BYE\n";
		//String ret = body.toString();
		//body.append("BYE\n");
		return body.toString();	
		//}
	
	}	
	
	public static String endDrumHeading() {
		//Ender:
		StringBuilder end = new StringBuilder();
		if (repEnd) {
			end.append("  <barline location=\"right\">\n");
			end.append("   <bar-style>light-heavy</bar-style>\n");
			end.append("   <repeat direction=\"backward\"/>\n");
			end.append("   </barline>\n");
			end.append("  </measure>\n");
			end.append(" </part>\n");
			end.append("</score-partwise>\n");
			return end.toString();
		} else {
			end.append("  <barline location=\"right\">\n");
			end.append("   <bar-style>light-heavy</bar-style>\n");
			end.append("   </barline>\n");
			end.append("  </measure>\n");
			end.append(" </part>\n");
			end.append("</score-partwise>\n");
			return end.toString();
		}
	}
	
	public static Drum getDrum(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
		Drum drumSeven;
		drumSeven = Drum.getInstance(str1,str2,str3,str4,str5, str6, str7);
		return drumSeven;
	}
	public static Drum getDrum(String str1, String str2, String str3, String str4, String str5, String str6) {
		Drum drumSix;
		drumSix = Drum.getInstance(str1,str2,str3,str4,str5, str6);
		return drumSix;
	}
	public static Drum getDrum(String str1, String str2, String str3, String str4, String str5) {
		Drum drumFive;
		drumFive = Drum.getInstance(str1,str2,str3,str4,str5);
		return drumFive;
	}
	
	public void resetGlobal() {
		this.measureCount = 0;
		this.mCount = 0;
		this.c = 0;
		
		
	}

}