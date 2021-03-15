package tab2mxl;

<<<<<<< HEAD
public class Drum extends StringInstrument{

	private Drum()
	{
		super();
	}
	// 4 string drum tab
	private Drum (String st1, String st2, String st3, String st4) {
		super (st1, st2, st3, st4);
	}
	
	// 5 string drum tab
		private Drum (String st1, String st2, String st3, String st4, String st5) {
			super (st1, st2, st3, st4, st5);
		}
	
		// 6 string drum tab
		
	private Drum (String st1, String st2, String st3, String st4, String st5, String st6) {
		super (st1, st2, st3, st4, st5, st6);
		}
	// 7 strings drum tab
	private Drum (String st1, String st2, String st3, String st4, String st5, String st6, String st7) {
		super (st1, st2, st3, st4, st5, st6, st7);
		}
	// 8 strings drum tab
	
	private Drum (String st1, String st2, String st3, String st4, String st5, String st6, String st7, String st8) {
		super (st1, st2, st3, st4, st5, st6, st7, st8);
	}
	//getters
	
	public static Drum getInstance(String st1, String st2, String st3, String st4)
	{
		return new Drum(st1, st2, st3, st4);	
	}
	public static Drum getInstance(String st1, String st2, String st3, String st4, String st5)
	{
		return new Drum(st1, st2, st3, st4, st5);	
	}
	
	public static Drum getInstance(String st1, String st2, String st3, String st4, String st5, String st6)
	{
		return new Drum(st1, st2, st3, st4, st5, st6);	
	}
	public static Drum getInstance(String st1, String st2, String st3, String st4, String st5, String st6, String st7)
	{
		return new Drum(st1, st2, st3, st4, st5, st6, st7);	
	}
	public static Drum getInstance(String st1, String st2, String st3, String st4, String st5, String st6, String st7, String st8)
	{
		return new Drum(st1, st2, st3, st4, st5, st6, st7, st8);	
	}
	
	public void printTab()
	{		         

		for (int i = 2 ; this.getStr1().charAt(i) != '|' ; i++)
		{
			if (Character.isDigit(this.getStr1().charAt(i))) {
				System.out.println("String = 1 Fret = " + this.getStr1().charAt(i) + " Note: " + Notes.drumNotes("note1",Character.getNumericValue(this.getStr1().charAt(i))));
			
			}if (Character.isDigit(this.getStr2().charAt(i))) {
				System.out.println("String = 2 Fret = " + this.getStr2().charAt(i) + " Note: " + Notes.drumNotes("note2",Character.getNumericValue(this.getStr2().charAt(i))));
			
			}if (Character.isDigit(this.getStr3().charAt(i))) {
				System.out.println("String = 3 Fret = " + this.getStr3().charAt(i) + " Note: " + Notes.drumNotes("note3",Character.getNumericValue(this.getStr3().charAt(i))));
			
			}if (Character.isDigit(this.getStr4().charAt(i))) {
				System.out.println("String = 4 Fret = " + this.getStr4().charAt(i) + " Note: " + Notes.drumNotes("note4",Character.getNumericValue(this.getStr4().charAt(i))));
			
			}if (this.getStr5() != null && Character.isDigit(this.getStr5().charAt(i))) {
				System.out.println("String = 5 Fret = " + this.getStr5().charAt(i) + " Note: " + Notes.drumNotes("note5",Character.getNumericValue(this.getStr5().charAt(i))));
			}
			if (this.getStr6() != null && Character.isDigit(this.getStr6().charAt(i))) {
				System.out.println("String = 6 Fret = " + this.getStr6().charAt(i) + " Note: " + Notes.drumNotes("note6",Character.getNumericValue(this.getStr6().charAt(i))));
			}
			if (this.getStr7() != null && Character.isDigit(this.getStr7().charAt(i))) {
				System.out.println("String = 7 Fret = " + this.getStr7().charAt(i) + " Note: " + Notes.drumNotes("note7",Character.getNumericValue(this.getStr7().charAt(i))));
			}
			if (this.getStr8() != null && Character.isDigit(this.getStr8().charAt(i))) {
				System.out.println("String = 8 Fret = " + this.getStr8().charAt(i) + " Note: " + Notes.drumNotes("note8",Character.getNumericValue(this.getStr8().charAt(i))));
			}
		}
	}
	
	
	
=======
public class Drum {
>>>>>>> refs/remotes/origin/Maisha_Branch
	
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
	public static int mCount = 0;
	
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
	public static Drum getInstance(String s1, String s2, String s3, String s4, String s5, String s6) {
		
		return new Drum(s1, s2, s3, s4, s5, s6);
	}
	public static Drum getInstance(String s1, String s2, String s3, String s4, String s5) {
		
		return new Drum(s1, s2, s3, s4, s5);
	}
	
	public static String xmlDrumHeader(int c) {
		String instrument = "";
		StringBuilder head = new StringBuilder();
		if (c == 6 || c == 7) {
			instrument = "Drumset";
		}
		head.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        head.append("<!DOCTYPE score-partwise PUBLIC \"-//Recordare//DTD MusicXML 3.1 Partwise//EN\" \"http://www.musicxml.org/dtds/partwise.dtd\">\n");
        head.append("<score-partwise version=\"3.1\">\n");
       
        head.append(" <part-list>\n");
        head.append("  <score-part id=\"P1\">\n");
        head.append("   <part-name>" + instrument + "</part-name>\n");
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
        head.append("   <score-instrument id=\"P1-I555\">\n");
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
	public String printDrumXML(String str1, String str2, String str3, String str4, String str5, String str6) {
		StringBuilder body = new StringBuilder();
		String note = "";
		String instrument = "";
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
			for (int i = str1.indexOf('|') + 1 ; i < str1.lastIndexOf('|') ; i++)
			{
//	        	counter++;
	        	for (String j: allStrings) {
		        	stringNum++;
		        	
		        	//&& Character.isDigit(j.charAt(i))
					// && (j.charAt(i) == 'x' || j.charAt(i) == 'X' || j.charAt(i) == 'o')
					if (j != null) {
						if(j.charAt(i) == 'x' || j.charAt(i) == 'X' || j.charAt(i) == 'o') {
							fret = j.charAt(i);
						}
						//Nabaa needs to implement drumNotes and drumOctave methods in Notes class
						note = Notes.drumNotes("String" + String.valueOf(stringNum) ,Character.getNumericValue(fret));
						octave = Notes.drumOctave("String" + String.valueOf(stringNum) ,Character.getNumericValue(fret));
						
						instrument = Notes.drumInstrument("String" + String.valueOf(stringNum), fret);
						
						body.append("<note>\n");
						body.append(" <unpitched>\n");
						if (note.length() == 1) { 
							body.append("  <display-step>" +  note + "</display-step>\n");
						}
//						else
//						{
//							body.append("  <display-step>" +  note.charAt(0) + "</display-step>\n");
//	
//						}
						body.append("  <display-octave>" +  octave + "</display-octave>\n"); //octave needs to be implemented
						body.append("  </unpitched>\n");
						body.append(" <duration>2</duration>\n"); //will need to implement duration later
						body.append("  <instrument id=\"" + instrument + "\"/>\n"); //states what type of drum it is. Needs to be implemented properly later
						body.append(" <voice>1</voice>\n");
						body.append(" <type>eighth</type>\n"); //will need to implement type later
						body.append(" <stem>up</stem>\n");
						if (j.contains("C") || j.contains("H") || j.contains("R")) {
							body.append(" <notehead>x</notehead>\n"); //only cymbal lines have x
						}
						body.append(" <beam number=\"1\">continue</beam>\n");
						body.append(" </note>\n");            	
		        }	
			}
	        stringNum = 0;
	        
			}
		}
		mCount++;
		//return "BYE\n";
		//String ret = body.toString();
		//body.append("BYE\n");
		return body.toString();	

	}	
	
	public static String endDrumHeading() {
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
}
