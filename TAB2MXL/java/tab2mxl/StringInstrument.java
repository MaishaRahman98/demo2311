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
	public void printToXML() {
		String note = "";
		char fret = 0;
		//XML declarations:
		System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		System.out.println("<!DOCTYPE score-partwise PUBLIC \"-//Recordare//DTD MusicXML 3.1 Partwise//EN\" \"http://www.musicxml.org/dtds/partwise.dtd\">");
		for (int i = 2 ; this.getStr1().charAt(i) != '|' ; i++)
		{
			if (Character.isDigit(this.getStr1().charAt(i))) {
				System.out.println("String = 1 Fret = " + this.getStr1().charAt(i) + " Note: " + Notes.guitarNotes("note1",Character.getNumericValue(this.getStr1().charAt(i))));
				fret = this.getStr1().charAt(i);
				note = Notes.guitarNotes("note1",Character.getNumericValue(this.getStr1().charAt(i)));
			}else if (Character.isDigit(this.getStr2().charAt(i))) {
				System.out.println("String = 2 Fret = " + this.getStr2().charAt(i) + " Note: " + Notes.guitarNotes("note2",Character.getNumericValue(this.getStr2().charAt(i))));
				fret = this.getStr2().charAt(i);
				note = Notes.guitarNotes("note2",Character.getNumericValue(this.getStr2().charAt(i)));
			}else if (Character.isDigit(this.getStr3().charAt(i))) {
				System.out.println("String = 3 Fret = " + this.getStr3().charAt(i) + " Note: " + Notes.guitarNotes("note3",Character.getNumericValue(this.getStr3().charAt(i))));
				fret = this.getStr3().charAt(i);
				note = Notes.guitarNotes("note3",Character.getNumericValue(this.getStr3().charAt(i)));
			}else if (Character.isDigit(this.getStr4().charAt(i))) {
				System.out.println("String = 4 Fret = " + this.getStr4().charAt(i) + " Note: " + Notes.guitarNotes("note4",Character.getNumericValue(this.getStr4().charAt(i))));
				fret = this.getStr4().charAt(i);
				note = Notes.guitarNotes("note4",Character.getNumericValue(this.getStr4().charAt(i)));
			}else if (this.getStr5() != null && Character.isDigit(this.getStr5().charAt(i))) {
				System.out.println("String = 5 Fret = " + this.getStr5().charAt(i) + " Note: " + Notes.guitarNotes("note5",Character.getNumericValue(this.getStr5().charAt(i))));
				fret = this.getStr5().charAt(i);
				note = Notes.guitarNotes("note5",Character.getNumericValue(this.getStr5().charAt(i)));
			}else if (this.getStr6() != null && Character.isDigit(this.getStr6().charAt(i))) {
				System.out.println("String = 6 Fret = " + this.getStr6().charAt(i) + " Note: " + Notes.guitarNotes("String6",Character.getNumericValue(this.getStr6().charAt(i))));
				fret = this.getStr6().charAt(i);
				note = Notes.guitarNotes("String6",Character.getNumericValue(this.getStr6().charAt(i)));
			}else if (this.getStr7() != null && Character.isDigit(this.getStr7().charAt(i))) {
				System.out.println("String = 7 Fret = " + this.getStr7().charAt(i) + " Note: " + Notes.guitarNotes("String7",Character.getNumericValue(this.getStr7().charAt(i))));
				fret = this.getStr7().charAt(i);
				note = Notes.guitarNotes("String7",Character.getNumericValue(this.getStr7().charAt(i)));
			}
			//Coding to print out the note in string 1 in xml format:
			System.out.println("<note>");
			System.out.println("\t<pitch>");
			System.out.println("\t\t<step>" +  note + "</step>");
			System.out.println("\t\t</pitch>");
			System.out.println("\t<notations>");
			System.out.println("\t\t<technical>");
			System.out.println("\t\t\t<string>1</string>");
			System.out.println("\t\t\t<fret>" + fret + "</fret>");
			System.out.println("\t\t\t</technical>");
			System.out.println("\t\t</notations>");
			System.out.println("\t</note>");
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
	
	

