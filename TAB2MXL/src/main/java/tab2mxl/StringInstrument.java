package tab2mxl;

import java.util.ArrayList;

/**
 * This class creates the MusicXML output for string instruments, bass and guitar.
 * @author Group 16, EECS2311
 *
 */
public class StringInstrument {
	private static String str1;
	private static String str2;
	private static String str3;
	private static String str4;
	private static String str5;
	private static String str6;
	private static String str7;
	int measureCount = 0;
	static int temp = 0;
	int hammerCount = 0;
	int pullOffCount = 0;
	private char type; // number of strings
	public static int mCount = 0;
	public int c = 0;
	public static int d;
	static boolean repEnd = false;

	/**
	 * Default constructor for the StringInstrument object.
	 */
	public StringInstrument() {
		this.type = ' ';
		this.str1 = "";
		this.str2 = "";
		this.str3 = "";
		this.str4 = "";
		this.str5 = "";
		this.str6 = "";
		this.str7 = "";
	}

	/**
	 * The parameterized constructor for the StringInstrument object.
	 * @param str1
	 * @param str2
	 * @param str3
	 * @param str4
	 */
	public StringInstrument(String str1, String str2, String str3, String str4) {
		this.str1 = str1;
		this.str2 = str2;
		this.str3 = str3;
		this.str4 = str4;
		this.type = '4';
	}

	public StringInstrument(String str1, String str2, String str3, String str4, String str5) {
		this(str1, str2, str3, str4);
		this.str5 = str5;
		this.type = '5';
	}

	public StringInstrument(String str1, String str2, String str3, String str4, String str5, String str6) {
		this(str1, str2, str3, str4, str5);
		this.str6 = str6;
		this.type = '6';
	}

	public StringInstrument(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
		this(str1, str2, str3, str4, str5, str6);
		this.str7 = str7;
		this.type = '7';
	}

	/**
	 * Returns the Bass object.
	 * @param str1
	 * @param str2
	 * @param str3
	 * @param str4
	 * @return
	 */
	public static Bass getBass(String str1, String str2, String str3, String str4) {
		Bass bassFour;
		bassFour = Bass.getInstance(str1, str2, str3, str4);
		return bassFour;

	}

	public static Bass getBass(String str1, String str2, String str3, String str4, String str5) {
		Bass bassFive;
		bassFive = Bass.getInstance(str1, str2, str3, str4, str5);
		return bassFive;

	}

	/**
	 * Returns the Guitar object.
	 * @param str1
	 * @param str2
	 * @param str3
	 * @param str4
	 * @param str5
	 * @param str6
	 * @return
	 */
	public static Guitar getGuitar(String str1, String str2, String str3, String str4, String str5, String str6) {
		Guitar guitarSix;
		guitarSix = Guitar.getInstance(str1, str2, str3, str4, str5, str6);
		return guitarSix;

	}

	public static Guitar getGuitar(String str1, String str2, String str3, String str4, String str5, String str6,
			String str7) {
		Guitar guitarSeven;
		guitarSeven = Guitar.getInstance(str1, str2, str3, str4, str5, str6, str7);
		return guitarSeven;

	}

	/**
	 * Builds the header part for the MusicXML output and returns it.
	 * @param c
	 * @return head
	 */
	public static String xmlHeader(int c) {
		String instrument = "";
		StringBuilder head = new StringBuilder();
		if (c == 4 || c == 5) {
			instrument = "Bass Guitar";
		} else {
			instrument = "Guitar";
		}

		head.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		head.append(
				"<!DOCTYPE score-partwise PUBLIC \"-//Recordare//DTD MusicXML 3.1 Partwise//EN\" \"http://www.musicxml.org/dtds/partwise.dtd\">\n");
		head.append("<score-partwise version=\"3.1\">\n");

		head.append(" <part-list>\n");
		head.append("  <score-part id=\"P1\">\n");
		head.append("   <part-name>" + instrument + "</part-name>\n");
		head.append("  </score-part>\n");
		head.append(" </part-list>\n");
		head.append(" <part id=\"P1\">\n");
		head.append(" <measure number=\"1\">\n");
		head.append("       <attributes>\n");
		head.append("            <divisions>4</divisions>\n");
		head.append("            <key>\n");
		head.append("                <fifths>0</fifths>\n");
		head.append("                </key>\n");
		head.append("            <time>\n");
		head.append("                <beats>4</beats>\n");
		head.append("                <beat-type>4</beat-type>\n");
		head.append("            </time>\n");
		head.append("            <clef>\n");
		head.append("               <sign>TAB</sign>\n");
		head.append("               <line>5</line>\n");
		head.append("            </clef>\n");
		head.append("            <staff-details>\n");

		if (c == 4) {
			head.append("                <staff-lines>" + c + "</staff-lines>\n");
			head.append("                <staff-tuning line=\"1\">\n");
			head.append("                    <tuning-step>" + "E" + "</tuning-step>\n");
			head.append("                    <tuning-octave>1</tuning-octave>\n");
			head.append("                </staff-tuning>\n");
			head.append("                <staff-tuning line=\"2\">\n");
			head.append("                   <tuning-step>" + "A" + "</tuning-step>\n");
			head.append("                    <tuning-octave>1</tuning-octave>\n");
			head.append("                </staff-tuning>\n");
			head.append("                <staff-tuning line=\"3\">\n");
			head.append("                   <tuning-step>" + "D" + "</tuning-step>\n");
			head.append("                    <tuning-octave>2</tuning-octave>\n");
			head.append("                </staff-tuning>\n");
			head.append("                <staff-tuning line=\"4\">\n");
			head.append("                   <tuning-step>" + "G" + "</tuning-step>\n");
			head.append("                    <tuning-octave>2</tuning-octave>\n");

		}

		if (c == 5) {
			head.append("                <staff-lines>" + c + "</staff-lines>\n");
			head.append("                <staff-tuning line=\"1\">\n");
			head.append("                    <tuning-step>" + "B" + "</tuning-step>\n");
			head.append("                    <tuning-octave>0</tuning-octave>\n");
			head.append("                </staff-tuning>\n");
			head.append("                <staff-tuning line=\"2\">\n");
			head.append("                   <tuning-step>" + "E" + "</tuning-step>\n");
			head.append("                    <tuning-octave>1</tuning-octave>\n");
			head.append("                </staff-tuning>\n");
			head.append("                <staff-tuning line=\"3\">\n");
			head.append("                   <tuning-step>" + "A" + "</tuning-step>\n");
			head.append("                    <tuning-octave>1</tuning-octave>\n");
			head.append("                </staff-tuning>\n");
			head.append("                <staff-tuning line=\"4\">\n");
			head.append("                   <tuning-step>" + "D" + "</tuning-step>\n");
			head.append("                    <tuning-octave>2</tuning-octave>\n");
			head.append("                </staff-tuning>\n");
			head.append("                <staff-tuning line=\"5\">\n");
			head.append("                   <tuning-step>" + "G" + "</tuning-step>\n");
			head.append("                    <tuning-octave>2</tuning-octave>\n");

		}
		if (c == 6) {
			head.append("                <staff-lines>" + c + "</staff-lines>\n");
			head.append("                <staff-tuning line=\"1\">\n");
			head.append("                    <tuning-step>" + "E" + "</tuning-step>\n");
			head.append("                    <tuning-octave>2</tuning-octave>\n");
			head.append("                </staff-tuning>\n");
			head.append("                <staff-tuning line=\"2\">\n");
			head.append("                   <tuning-step>" + "A" + "</tuning-step>\n");
			head.append("                    <tuning-octave>2</tuning-octave>\n");
			head.append("                </staff-tuning>\n");
			head.append("                <staff-tuning line=\"3\">\n");
			head.append("                   <tuning-step>" + "D" + "</tuning-step>\n");
			head.append("                    <tuning-octave>3</tuning-octave>\n");
			head.append("                </staff-tuning>\n");
			head.append("                <staff-tuning line=\"4\">\n");
			head.append("                   <tuning-step>" + "G" + "</tuning-step>\n");
			head.append("                    <tuning-octave>3</tuning-octave>\n");
			head.append("                </staff-tuning>\n");
			head.append("                <staff-tuning line=\"5\">\n");
			head.append("                   <tuning-step>" + "B" + "</tuning-step>\n");
			head.append("                    <tuning-octave>3</tuning-octave>\n");
			head.append("                </staff-tuning>\n");
			head.append("                <staff-tuning line=\"6\">\n");
			head.append("                   <tuning-step>" + "E" + "</tuning-step>\n");
			head.append("                    <tuning-octave>4</tuning-octave>\n");
		}
		if (c == 7) {
			head.append("                <staff-lines>" + c + "</staff-lines>\n");
			head.append("                </staff-tuning>\n");
			head.append("                <staff-tuning line=\"7\">\n");
			head.append("                   <tuning-step>" + "B" + "</tuning-step>\n");
			head.append("                    <tuning-octave> 1 </tuning-octave>\n");
			head.append("                <staff-tuning line=\"1\">\n");
			head.append("                    <tuning-step>" + "E" + "</tuning-step>\n");
			head.append("                    <tuning-octave>2</tuning-octave>\n");
			head.append("                </staff-tuning>\n");
			head.append("                <staff-tuning line=\"2\">\n");
			head.append("                   <tuning-step>" + "A" + "</tuning-step>\n");
			head.append("                    <tuning-octave>2</tuning-octave>\n");
			head.append("                </staff-tuning>\n");
			head.append("                <staff-tuning line=\"3\">\n");
			head.append("                   <tuning-step>" + "D" + "</tuning-step>\n");
			head.append("                    <tuning-octave>3</tuning-octave>\n");
			head.append("                </staff-tuning>\n");
			head.append("                <staff-tuning line=\"4\">\n");
			head.append("                   <tuning-step>" + "G" + "</tuning-step>\n");
			head.append("                    <tuning-octave>3</tuning-octave>\n");
			head.append("                </staff-tuning>\n");
			head.append("                <staff-tuning line=\"5\">\n");
			head.append("                   <tuning-step>" + "B" + "</tuning-step>\n");
			head.append("                    <tuning-octave>3</tuning-octave>\n");
			head.append("                </staff-tuning>\n");
			head.append("                <staff-tuning line=\"6\">\n");
			head.append("                   <tuning-step>" + "E" + "</tuning-step>\n");
			head.append("                    <tuning-octave>4</tuning-octave>\n");
		}

		head.append("                </staff-tuning>\n");
		head.append("            </staff-details>\n");
		head.append("         </attributes>\n");

		return head.toString();
	}

	// Prints bass or guitar tab in xml format:
	/**
	 * Builds the body part for the MusicXML output and returns it.
	 * @param str1
	 * @param str2
	 * @param str3
	 * @param str4
	 * @param str5
	 * @param str6
	 * @param str7
	 * @return body
	 */
	public String printToXML(String str1, String str2, String str3, String str4, String str5, String str6,
			String str7) {
		StringBuilder body = new StringBuilder();
		String note = "";
		boolean chord = false;
		boolean DD = false; //double digit
//		String string = "";
//		String output = "";
//		int spaceCount = 0;
		ArrayList<String> legatoValue = new ArrayList<String>();
		boolean legatoCheck = false;
		boolean legatoStop = false;
		int legatoFret = 0;
		String legatoType = "";
		String legatoFullName = "";
		String text = "";
		int fret = 0;
		int stringNum = 0;
		String[] allStrings = { str1, str2, str3, str4, str5, str6, str7 };
//		String name;
		int octave = 0;
		int numMeasureCount = 1;
		int counter = 0;
		int digit = 0;
		ArrayList<ArrayList<Character>> listOfColumns =  new ArrayList<ArrayList<Character>>();
		String noteType = "";
		int x = 0,y = 0;
		boolean graceToken = false;
		int beat = 4, beatType = 4;
		//double durMes = beat * (1 / beatType);
		int total = 0;
		boolean rep = false;

		for (int i = 1; i < str1.length(); i++) {
			if ((i + 1) != str1.length() && str1.charAt(i) == '|' && str1.charAt(i + 1) == '-') {
				measureCount++;
			}
		}
	
		for (int i = 2; i < str1.lastIndexOf('|'); i++) {
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
		//for (int k = 0; k < measureCount; k++) {

			if (mCount != 0) {
				body.append("  </measure>\n");
				body.append("  <measure number=\"" + (mCount + 1) + "\">\n");
			}
			
		if (listOfColumns.get(listOfColumns.size() - 1).contains('|') && listOfColumns.get(listOfColumns.size() - 1).toString().matches(".*\\d.*"))	
			rep = true;
		
		for (int i = 0; i < listOfColumns.size(); i++) {
			Measure measure = new Measure("");
//			String sss = listOfColumns.get(i).toString();
//			boolean b = listOfColumns.get(i).toString().matches(".*\\d.*");
			if (listOfColumns.get(i).contains('|') && !listOfColumns.get(i).toString().matches(".*\\d.*")) {
				if (i != listOfColumns.size() - 1 && !listOfColumns.get(i+1).contains('|')) {
				mCount++;
				body.append("  </measure>\n");
				body.append(" <measure number=\"" + (mCount + 1) + "\">\n");
				}
				
			}
//			if (repEnd) {
//				body.append("<barline location=\"right\">\n");
//				body.append("<bar-style>light-heavy</bar-style>\n");
//				body.append("<repeat direction=\"backward\"/>\n");
//				body.append(" </barline>\n");
//				body.append("</measure>\n");
//				body.append(" <measure number=\"" + (mCount + 1) + "\">\n");
//				repEnd = false;
//			}
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
				if (Character.isDigit(listOfColumns.get(i).get(a))) {
					digit++;
				}
			}
			
			if (digit >= 1 && !listOfColumns.get(i).contains('|')) {
				for (int j = 0; j < listOfColumns.get(i).size(); j++) {
					stringNum++;
					
					if (i-1 > 0) {
						if (listOfColumns.get(i-1).get(j)=='g') {
						graceToken = true;
						}
					}
					if (Character.isDigit(listOfColumns.get(i).get(j))) {
						int origini = i;
						
						if (i != listOfColumns.size() - 1) 
							if (Character.isDigit(listOfColumns.get(i + 1).get(j))) {
								 x = (Character.getNumericValue(listOfColumns.get(i).get(j)));
								 y = (Character.getNumericValue(listOfColumns.get(i+1).get(j)));
								fret = x * 10 + y;
							}
							else if(Character.isDigit(listOfColumns.get(i - 1).get(j)))
								break;
							else 
								fret = Character.getNumericValue(listOfColumns.get(i).get(j));
						
						if (str6 == null && str7 == null) {
							note = measure.getNoteMeasure("String" + String.valueOf(stringNum),fret,"bass");
							octave = measure.getOctaveMeasure("String" + String.valueOf(stringNum), fret,"bass");
						} else {
							note = measure.getNoteMeasure("String" + String.valueOf(stringNum), fret, "guitar");
							octave = measure.getOctaveMeasure("String" + String.valueOf(stringNum), fret,"guitar");
						}
						
						body.append("<note>\n");
						if (graceToken == true) {
							body.append(" <grace/> \n");
							graceToken = false;
						}
						if (digit > 1 && chord) {
							body.append("  <chord/>\n");
						}
						if (digit > 1) {
							chord = true;
						}
						body.append(" <pitch>\n");
						if (note.length() == 1)
							body.append("  <step>" + note + "</step>\n");
						else {
							body.append("  <step>" + note.charAt(0) + "</step>\n");
							body.append("  <alter>-1</alter>\n");
						}
						body.append("  <octave>" + octave + "</octave>\n");
						body.append("  </pitch>\n");

//						boolean chord = false;
//						while (true) {
//							i++;
//							if (i == listOfColumns.size())
//								break;
//							for (int a = 0; a < listOfColumns.get(i).size(); a++) {
//								if (Character.isDigit(listOfColumns.get(i).get(a)))
//								{
//										bool = false;
//										break;
//								}
//							}		
//							counter++;
//						}
						
						i = origini;
						counter = -1;
						boolean bool = true;
						while (bool){
							i++;
							if (i == listOfColumns.size())
								break;
							for (int a = 0; a < listOfColumns.get(i).size(); a++) {
								if (Character.isDigit(listOfColumns.get(i).get(a)) || listOfColumns.get(i).get(a) == '|')
								{
										bool = false;
										break;
								}
							}		
							counter++;
						}
//						counter++;
						i = origini;
						if (i+2 < listOfColumns.size()) {
							if (Character.toLowerCase(listOfColumns.get(i+2).get(j)) == 'p' || Character.toLowerCase(listOfColumns.get(i+2).get(j)) == 'h' || Character.toLowerCase(listOfColumns.get(i+1).get(j)) == 'p' || Character.toLowerCase(listOfColumns.get(i+1).get(j)) == 'h') {
								if (Character.isDigit(listOfColumns.get(i+1).get(j)) &&  Character.isDigit(listOfColumns.get(i+3).get(j)) && Character.isDigit(listOfColumns.get(i+4).get(j))) {
								 text = Character.toString(listOfColumns.get(i).get(j))+Character.toString(listOfColumns.get(i+1).get(j))+Character.toString(listOfColumns.get(i+2).get(j)) + Character.toString(listOfColumns.get(i+3).get(j))+Character.toString(listOfColumns.get(i+4).get(j));
								} else if (Character.isDigit(listOfColumns.get(i).get(j)) &&  Character.isDigit(listOfColumns.get(i+2).get(j)) && Character.isDigit(listOfColumns.get(i+3).get(j))) {
									 text = Character.toString(listOfColumns.get(i).get(j))+Character.toString(listOfColumns.get(i+1).get(j))+Character.toString(listOfColumns.get(i+2).get(j)) + Character.toString(listOfColumns.get(i+3).get(j));
								} else if (Character.isDigit(listOfColumns.get(i+1).get(j)) && Character.isDigit(listOfColumns.get(i+3).get(j))) {
									 text = Character.toString(listOfColumns.get(i).get(j))+Character.toString(listOfColumns.get(i+1).get(j))+Character.toString(listOfColumns.get(i+2).get(j)) + Character.toString(listOfColumns.get(i+3).get(j));
								} else {
									 text = Character.toString(listOfColumns.get(i).get(j))+Character.toString(listOfColumns.get(i+1).get(j))+Character.toString(listOfColumns.get(i+2).get(j)) + Character.toString(listOfColumns.get(i+3).get(j));
							}
								legatoCheck = true;
								legatoValue = measure.legatos(text);
							}
						}
						if (counter != -1)
							body.append(" <duration>" + (counter + 1) + "</duration>\n");
						else
							body.append(" <duration>" +  1 + "</duration>\n");
						body.append(" <voice>1</voice>\n");
						body.append(" <type>" + measure.getDuration(counter + 1 ,total ,beat , beatType)+ "</type>\n");
						body.append(" <notations>\n");
						body.append("  <technical>\n");
						body.append("   <string>" + stringNum + "</string>\n");
						body.append("   <fret>" + fret + "</fret>\n");
						
						if(legatoStop = true || legatoFret == fret && graceToken == false) {
							if (legatoType == "H") {
								body.append("      <"+legatoFullName+" number=\""+hammerCount+"\" type=\"stop\"/>\n");
								hammerCount = 0;
							}
							if (legatoType == "P") {
								body.append("      <"+legatoFullName+" number=\""+pullOffCount+"\" type=\"stop\"/>\n");
								pullOffCount = 0;
							}
							legatoType = "";
							legatoFullName = "";
							legatoFret = 0;	
							legatoStop = false;
						}
						
						if (legatoCheck == true && graceToken == false) {
							legatoType = legatoValue.get(1);
							legatoFullName = legatoValue.get(0);
							legatoFret = Integer.parseInt(legatoValue.get(2));
							if (legatoValue.get(1) == "H") {
								hammerCount++;
								body.append("      <"+legatoFullName+" number=\""+hammerCount+"\" type=\"start\">"+legatoType+"</"+legatoFullName+">\n");
							}
							if (legatoValue.get(1) == "P") {
								pullOffCount++;
								body.append("      <"+legatoFullName+" number=\""+pullOffCount+"\" type=\"start\">"+legatoType+"</"+legatoFullName+">\n");
							}
							legatoCheck = false;
							legatoStop = true;
						}
						
						body.append("   </technical>\n");
						body.append("  </notations>\n");
						body.append(" </note>\n");
					}
				}
				digit = 0;
				stringNum = 0;
			} else {
				digit = 0;
				stringNum = 0;
				chord = false;
			}
		}
		mCount++;
		return body.toString();
	}
	// End of printToXML method

	/**
	 * Builds the ending part for the MusicXML output and returns it.
	 * @return end
	 */
	public static String endHeading() {
		// Ender:
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

	// Getters and Setters:
	public String getStr1() {
		return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
	}

	public String getStr2() {
		return str2;
	}

	public void setStr2(String str2) {
		this.str2 = str2;
	}

	public String getStr3() {
		return str3;
	}

	public void setStr3(String str3) {
		this.str3 = str3;
	}

	public String getStr4() {
		return str4;
	}

	public void setStr4(String str4) {
		this.str4 = str4;
	}

	public String getStr5() {
		return str5;
	}

	public void setStr5(String str5) {
		this.str5 = str5;
	}

	public String getStr6() {
		return str6;
	}

	public void setStr6(String str6) {
		this.str6 = str6;
	}

	public String getStr7() {
		return str7;
	}

	public void setStr7(String str7) {
		this.str7 = str7;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}
	
	public static void setTemp(int i) {
		temp = i;
	}
	// 
	public void resetGlobal() {
		this.measureCount = 0;
		this.hammerCount = 0;
		this.pullOffCount = 0;
		this.type = ' ';
		this.mCount = 0;
		this.c = 0;
		this.d = 0;
	}

}