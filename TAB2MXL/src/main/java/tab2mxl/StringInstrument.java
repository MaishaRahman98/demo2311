package tab2mxl;

import org.xembly.Directives;
import org.xembly.Xembler;

public class StringInstrument {
	private String str1;
	private String str2;
	private String str3;
	private String str4;
	private String str5;
	private String str6;
	private String str7;
	private char type; //number of strings
	
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
	//Prints bass or guitar tab in xml format:
	public static String printToXML(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
		String note = "";
		String string = "";
		String output = "";
		char fret = 0;
		int cc = 0;
		String[] allStrings = {str1, str2, str3, str4, str5, str6, str7};
		String name;
		int octave = 0;
		String xml = "";
		int mCount = 0;
		
		if (str6 == null && str7 == null) {
			name = "Bass";
		}else {
			name = "Guitar";
		}
		
		//Creating the xml with Xembly:
		Directives xmlOutput = new Directives();
		if (mCount==0) {
		//XML header declarations:
		xmlOutput
                .add("score-partwise")
                .attr("version", "3.0")
                .add("part-list")
                .add("score-part")
                .attr("id", "P1")
                .add("part-name")
                .set(name) //Part name is either Bass or Guitar (for now), depends on the number of strings
                .up()
                .up()
                .up()
                .add("part")
                .attr("id", "P1")
		//attributes and staff details:
		        .add("attributes")
		        .add("divisions") //still no idea what divisions does?
		        .set("4") //the denominator in notes in terms of quarter notes. A duration of 4 will be one quarter note? A duration of 1 will be an 16th?
		        .up()
		        .add("time")
		        .add("beats").set(4) 
		        .up()
		        .add("beat-type").set(4)
		        .up()
		        .up()
		        .add("clef")
		        .add("sign").set("TAB") //to indicate it is a tab
		        .up()
		        .add("line").set(5) //sets tab to line 5
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
        //mCount++;
		//Notes section:
		for (int i = 2 ; str1.charAt(i) != '|' ; i++)
		{
			
			for (String j: allStrings) {
				cc++;
			if (j != null && Character.isDigit(j.charAt(i))) {

				fret = j.charAt(i);
				if (str6 == null && str7 == null) {
					note = Notes.bassNotes("String" + String.valueOf(cc) ,Character.getNumericValue(fret));
					octave = Notes.bassOctave("String" + String.valueOf(cc) ,Character.getNumericValue(fret));
				} else {
					note = Notes.guitarNotes("String" + String.valueOf(cc) ,Character.getNumericValue(fret));
					octave = Notes.guitarOctave("String" + String.valueOf(cc) ,Character.getNumericValue(fret));
				}
				
				xmlOutput
						.add("measure")
						.attr("number", mCount);
				xmlOutput
                		.add("note")
						.add("pitch")
		                .add("step").set(note)
		                .up()
                        .add("octave").set(octave)
                        .up()
                        .up()
                        .add("notations")
                        .add("technical")
						.add("string").set(cc)
		                .up()
		                .add("fret").set(fret)
		                .up()
		                .up()
		                .up()
		                .up();

			}
			
			}
			cc = 0;
			mCount++;
		}
		//System.out.println("</score-partwise>");
		xmlOutput.up();
        try {
            xml = new Xembler(
            		xmlOutput
            ).xml();
        } catch (Exception e) {
            System.out.println("There is an error with creating the xml output.");
        }
        return xml;
        //System.out.println(xml);

	}		
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
	
	

