package tab2mxl;

import java.util.ArrayList;

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
	private char type; //number of strings
	public static int mCount = 0;
	public int c = 0;
	public static int d;
	
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

	public static Bass getBass(String str1, String str2, String str3, String str4) {
		Bass bassFour;
		bassFour = Bass.getInstance(str1,str2,str3,str4);
		return bassFour;

	}


	public static Bass getBass(String str1, String str2, String str3, String str4, String str5) {
		Bass bassFive;
		bassFive = Bass.getInstance(str1,str2,str3,str4,str5);
		return bassFive;

		
	}

	public static Guitar getGuitar(String str1, String str2, String str3, String str4, String str5, String str6) {
		Guitar guitarSix;
		guitarSix = Guitar.getInstance(str1,str2,str3,str4,str5, str6);
		return guitarSix;

		
	}
	public static Guitar getGuitar(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
		Guitar guitarSeven;
		guitarSeven = Guitar.getInstance(str1,str2,str3,str4,str5, str6, str7);
		return guitarSeven;

		
	}
	public static String xmlHeader(int c) {
		String instrument = "";
		StringBuilder head = new StringBuilder();
		if (c == 4 || c == 5) {
			instrument = "Bass Guitar";
		}else {
			instrument = "Guitar";
		}
		
				head.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
                head.append("<!DOCTYPE score-partwise PUBLIC \"-//Recordare//DTD MusicXML 3.1 Partwise//EN\" \"http://www.musicxml.org/dtds/partwise.dtd\">\n");
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
                head.append("            <time>\n");
                head.append("                <beats>4</beats>\n");
                head.append("                <beat-type>4</beat-type>\n");
                head.append("            </time>\n");
                head.append("            <clef>\n");
                head.append("               <sign>TAB</sign>\n");
                head.append("               <line>1</line>\n");
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
	//Prints bass or guitar tab in xml format:
	public String printToXML(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
		StringBuilder body = new StringBuilder();
		String note = "";
//		String string = "";
//		String output = "";
//		int spaceCount = 0;
//		ArrayList<String> legatoOutput = new ArrayList<>();
//		boolean legatoCheck = false;
		char fret = 0;
		int stringNum = 0;
		String[] allStrings = {str1, str2, str3, str4, str5, str6, str7};
//		String name;
		int octave = 0;
//		String xml = "";
//		int counter = 0;

		for (int i = 1 ; i <str1.length() ; i++)
		{
			if((i+1)!= str1.length()  && str1.charAt(i)=='|' && str1.charAt(i+1) == '-') {
				measureCount++;
			}
		}
		
		for (int k = 0; k < measureCount; k++) {

			if (mCount != temp && mCount != 1) {
				body.append("  </measure>\n");
				body.append("  <measure number=\"" + (mCount - temp + 1) + "\">\n");
			}
			//|| str1.charAt(i + 1) != '-'
			for (int i = 2 ; i < str1.lastIndexOf('|') ; i++)
			{
//	        	counter++;
	        	for (String j: allStrings) {
		        	stringNum++;
					
					if (j != null && Character.isDigit(j.charAt(i))) {

						fret = j.charAt(i);
						if (str6 == null && str7 == null) {
							note = Notes.bassNotes("String" + String.valueOf(stringNum) ,Character.getNumericValue(fret));
							octave = Notes.bassOctave("String" + String.valueOf(stringNum) ,Character.getNumericValue(fret));
						}else {
							note = Notes.guitarNotes("String" + String.valueOf(stringNum) ,Character.getNumericValue(fret));
							octave = Notes.guitarOctave("String" + String.valueOf(stringNum) ,Character.getNumericValue(fret));
						}
						body.append("<note>\n");
						body.append(" <pitch>\n");
						if (note.length() == 1) 
							body.append("  <step>" +  note + "</step>\n");
						else
						{
							body.append("  <step>" +  note.charAt(0) + "</step>\n");
							body.append("  <alter>-1</alter>\n");
						}
						body.append("  <octave>" +  octave + "</octave>\n");
						body.append("  </pitch>\n");
						body.append(" <duration>2</duration>\n");
						body.append(" <voice>1</voice>\n");
						body.append(" <type>quarter</type>\n");
						body.append(" <notations>\n");
						body.append("  <technical>\n");
						body.append("   <string>" + stringNum + "</string>\n");
						body.append("   <fret>" + fret + "</fret>\n");
						body.append("   </technical>\n");
						body.append("  </notations>\n");
						body.append(" </note>\n");            	
		        }	
			}
	        stringNum = 0;
	        
			}
		}
		mCount++;
		return body.toString();	

	}	
	//End of printToXML method
	
	
	public static String endHeading() {
		//Ender:
		StringBuilder end = new StringBuilder();
		end.append("  <barline location=\"right\">\n");
		end.append("   <bar-style>light-heavy</bar-style>\n");
		end.append("   </barline>\n");
		end.append("  </measure>\n");
		end.append(" </part>\n");
		end.append("</score-partwise>\n");
		return end.toString();
	}
	
	//Getters and Setters:
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
	
}
	
	

