package tab2mxl;

import org.xembly.Directives;
import org.xembly.Xembler;
import java.util.ArrayList;

public class StringInstrument {
	private String str1;
	private String str2;
	private String str3;
	private String str4;
	private String str5;
	private String str6;
	private String str7;
	int measureCount = 0;
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
	public String xmlHeader(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
		String h = "";
		String name;
		if (str6 == null && str7 == null) {
			name = "Bass Guitar";
		}else {
			name = "Guitar";
		}
		
		//Creating the xml with Xembly:
		Directives xmlHeader = new Directives();
		//XML header declarations:
		xmlHeader
                //.add("!DOCTYPE score-partwise PUBLIC \"-//Recordare//DTD MusicXML 3.1 Partwise//EN\" \"http://www.musicxml.org/dtds/partwise.dtd\"")
                .add("score-partwise")
                .attr("version", "3.1")
                .add("part-list")
                .add("score-part")
                .attr("id", "P1")
                .add("part-name").set(name) //Part name is either Bass or Guitar (for now), depends on the number of strings
                .up()
                .up()
                .up()
                .add("part")
                .attr("id", "P1");
		try {
            h = new Xembler(
            		xmlHeader
            ).xml();
        } catch (Exception e) {
            h = "There is an error with creating the xml output." + e.toString();
        }
	
        return h;
	}
	//Prints bass or guitar tab in xml format:
	public String printToXML(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
		String note = "";
		String string = "";
		String output = "";
		int spaceCount = 0;
		ArrayList<String> legatoOutput = new ArrayList<>();
		boolean legatoCheck = false;
		char fret = 0;
		int stringNum = 0;
		String[] allStrings = {str1, str2, str3, str4, str5, str6, str7};
		String name;
		int octave = 0;
		String xml = "";
		int counter = 0;

		if (str6 == null && str7 == null) {
			name = "Bass Guitar";
		}else {
			name = "Guitar";
		}
		
		//Creating the xml with Xembly:
		Directives xmlOutput = new Directives();
		//XML header declarations:
		xmlOutput
                //.add("!DOCTYPE score-partwise PUBLIC \"-//Recordare//DTD MusicXML 3.1 Partwise//EN\" \"http://www.musicxml.org/dtds/partwise.dtd\"")
                .add("score-partwise")
                .attr("version", "3.1")
                .add("part-list")
                .add("score-part")
                .attr("id", "P1")
                .add("part-name").set(name) //Part name is either Bass or Guitar (for now), depends on the number of strings
                .up()
                .up()
                .up()
                .add("part")
                .attr("id", "P1");
		
		//Get number of measures:
		for (int i = 1 ; i <str1.length() ; i++)
		{
			if((i+1)!= str1.length()  && str1.charAt(i)=='|' && str1.charAt(i+1) == '-') {
				measureCount++;
			}
		}
		
		for (int k = 0; k < measureCount; k++) {
			//measure number:
	        xmlOutput
					.add("measure")
					.attr("number", k + 1);
	        if (k == 0) {
	        	//attributes and staff details:
	   		 	xmlOutput
	   		        .add("attributes")
	   		        .add("divisions") .set("4") 
	   		        .up()
	   		        .add("time")
	   		        .add("beats").set(4) 
	   		        .up()
	   		        .add("beat-type").set(4)
	   		        .up()
	   		        .up()
	   		        .add("clef")
	   		        .add("sign").set("TAB") //this is a tablature
	   		        .up()
	   		        .add("line").set(5) 
	   		        .up()
	   		        .up()
	   		        .add("staff-details")
	   		        .add("staff-lines").set(6)
	   		        .up()
	   		        .add("staff-tuning")
	   		        .attr("line", "1")
	   		        .add("tuning-step").set("E")
	   		        .up()
	   		        .add("tuning-octave").set(2)
	   		        .up()
	   		        .up()
	   		        .add("staff-tuning")
	   		        .attr("line", "2")
	   		        .add("tuning-step").set("A")
	   		        .up()
	   		        .add("tuning-octave").set(2)
	   		        .up()
	   		        .up()
	   		        .add("staff-tuning")
	   		        .attr("line", "3")
	   		        .add("tuning-step").set("D")
	   		        .up()
	   		        .add("tuning-octave").set(3)
	   		        .up()
	   		        .up()
	   		        .add("staff-tuning")
	   		        .attr("line", "4")
	   		        .add("tuning-step").set("G")
	   		        .up()
	   		        .add("tuning-octave").set(3)
	   		        .up()
	   		        .up()
	   		        .add("staff-tuning")
	   		        .attr("line", "5")
	   		        .add("tuning-step").set("B")
	   		        .up()
	   		        .add("tuning-octave").set(3)
	   		        .up()
	   		        .up()
	   		        .add("staff-tuning")
	   		        .attr("line", "6")
	   		        .add("tuning-step").set("E")
	   		        .up()
	   		        .add("tuning-octave").set(4)
	   		        .up()
	   		        .up()
	   		        .up()
	   		        .up();
	        }
        
		    //Must put code for displaying notes here:
//			for (int i = 1 ; i <str1.length() ; i++)
	        for (int i = 2 ; str1.charAt(i) != '|' ; i++)
			{
	        	counter++;
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
						xmlOutput
                		.add("note")
						.add("pitch")
		                .add("step").set(note)
		                .up()
                        .add("octave").set(octave)
                        .up()
                        .up()
                        .add("duration").set(2) //default is 2, will change later
                        .up()
                        .add("type").set("quarter") // default is quarter, will change later
                        .up()
                        .add("notations")
                        .add("technical")
						.add("string").set(stringNum)
		                .up()
		                .add("fret").set(fret)
		                .up()
		                .up()
		                .up()
		                .up();
					}
//					else if (j != null && Character.toLowerCase(j.charAt(i))=='p' || j != null && Character.toLowerCase(j.charAt(i))=='h') {
//						legatoCheck = true;
//						legatoOutput = Measure.legatos(j.substring(i-2,i+2));
//		
//					}
					
		        }
				stringNum = 0;
				
			}

		if(counter != 0) {
			xmlOutput
				.add("barline")
				.attr("location", "right")
				.add("bar-style").set("light-heavy")
				.up()
				.up()
				.up()
				.up();
		}
        try {
            xml = new Xembler(
            		xmlOutput
            ).xml();
        } catch (Exception e) {
            xml = "There is an error with creating the xml output." + e.toString();
        }
		}
        return xml;

	}	
	//End of printToXML method
	
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
	
	
}
	
	

