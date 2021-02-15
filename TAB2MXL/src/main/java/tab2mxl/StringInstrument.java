package tab2mxl;

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
	public void printToXML(String str1, String str2, String str3, String str4, String str5, String str6, String str7) {
		String note = "";
		String string = "";
		char fret = 0;
		int cc = 1;
		String[] allStrings = {str1, str2, str3, str4, str5, str6, str7};
		
		//XML declarations:
		System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		System.out.println("<!DOCTYPE score-partwise PUBLIC \"-//Recordare//DTD MusicXML 3.1 Partwise//EN\" \"http://www.musicxml.org/dtds/partwise.dtd\">");
		for (int i = 2 ; str1.charAt(i) != '|' ; i++)
		{
			
			for (String j: allStrings) {
				
			if (j != null && Character.isDigit(j.charAt(i))) {
				//System.out.println("String = 1 Fret = " + this.getStr1().charAt(i) + " Note: " + Notes.guitarNotes("note1",Character.getNumericValue(this.getStr1().charAt(i))));
				fret = j.charAt(i);
				note = Notes.bassNotes("String" + String.valueOf(cc) ,Character.getNumericValue(j.charAt(i)));
				//string = cc;
				
				//helpxml(note, string, fret);
				
				//Coding to print out the note in string 1 in xml format:
				System.out.println("<note>");
				System.out.println("\t<pitch>");
				System.out.println("\t\t<step>" +  note + "</step>");
				System.out.println("\t\t</pitch>");
				System.out.println("\t<notations>");
				System.out.println("\t\t<technical>");
				System.out.println("\t\t\t<string>" + cc + "</string>");
				System.out.println("\t\t\t<fret>" + fret + "</fret>");
				System.out.println("\t\t\t</technical>");
				System.out.println("\t\t</notations>");
				System.out.println("\t</note>");
				cc++;
			}
			
			}
			cc = 1;
			
		}
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
	
	

