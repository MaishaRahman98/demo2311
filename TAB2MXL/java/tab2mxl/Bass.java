package tab2mxl;

public class Bass 
{
	private char type; //number of strings
	private String s1, s2, s3, s4, s5;
	final String[] note1 = {"G", "Ab", "A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G"};
	final String[] note2 = {"D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B", "C", "Db", "D"};
	final String[] note3 = {"A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A"};
	final String[] note4 = {"E", "F", "Gb", "G", "Ab", "A", "Bb", "B", "C", "Db", "D", "Eb", "E"};
	final String[] note5 = {"B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B"};
	
	//stuff to be used to print in xml format
	String[] n1, n2, n3, n4, n5;
	char f1, f2, f3, f4, f5;
	
	private Bass()
	{
		this.type = ' ';
		this.s1 = "";
		this.s2 = "";
		this.s3 = "";
		this.s4 = "";
	}
	
	private Bass(String s1, String s2, String s3, String s4)
	{
		this.type = '4';
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.s4 = s4;
	}
	
	private Bass(String s1, String s2, String s3, String s4, String s5)
	{
		this(s1, s2, s3, s4);
		this.s5 = s5;
		this.type = '5';
	}
	
	public static Bass getInstance(String s1, String s2, String s3, String s4)
	{
		return new Bass(s1, s2, s3, s4);	
	}
	
	public static Bass getInstance(String s1, String s2, String s3, String s4, String s5)
	{
		return new Bass(s1, s2, s3, s4, s5);	
	}
	
	public void printTab()
	{		         
		//XML declarations:
		System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		System.out.println("<!DOCTYPE score-partwise PUBLIC \"-//Recordare//DTD MusicXML 3.1 Partwise//EN\" \"http://www.musicxml.org/dtds/partwise.dtd\">");
		
		for (int i = 2 ; s1.charAt(i) != '|' ; i++)
		{
			if (Character.isDigit(s1.charAt(i))) {
				//Prints out info about the note in string 1:
				System.out.println("String = 1 Fret = " + s1.charAt(i) + " Note: " + note1[Character.getNumericValue(s1.charAt(i))]);
				//Coding to print out the note in string 1 in xml format:
				System.out.println("<note>");
				System.out.println("\t<pitch>");
				System.out.println("\t\t<step>" + note1[Character.getNumericValue(s1.charAt(i))] + "</step>");
				System.out.println("\t\t</pitch>");
				System.out.println("\t<notations>");
				System.out.println("\t\t<technical>");
				System.out.println("\t\t\t<string>1</string>");
				System.out.println("\t\t\t<fret>" + s1.charAt(i) + "</fret>");
				System.out.println("\t\t\t</technical>");
				System.out.println("\t\t</notations>");
				System.out.println("\t</note>");
			}	
			if (Character.isDigit(s2.charAt(i))) {
				//Prints out info about the note in string 2:
				System.out.println("String = 2 Fret = " + s2.charAt(i) + " Note: " + note2[Character.getNumericValue(s2.charAt(i))]);
				//Coding to print out the note in string 2 in xml format:
				System.out.println("<note>");
				System.out.println("\t<pitch>");
				System.out.println("\t\t<step>" + note2[Character.getNumericValue(s2.charAt(i))] + "</step>");
				System.out.println("\t\t</pitch>");
				System.out.println("\t<notations>");
				System.out.println("\t\t<technical>");
				System.out.println("\t\t\t<string>2</string>");
				System.out.println("\t\t\t<fret>" + s2.charAt(i) + "</fret>");
				System.out.println("\t\t\t</technical>");
				System.out.println("\t\t</notations>");
				System.out.println("\t</note>");
			}
			if (Character.isDigit(s3.charAt(i))) {
				//Prints out info about the note in string 3:
				System.out.println("String = 3 Fret = " + s3.charAt(i) + " Note: " + note3[Character.getNumericValue(s3.charAt(i))]);
				//Coding to print out the note in string 3 in xml format:
				System.out.println("<note>");
				System.out.println("\t<pitch>");
				System.out.println("\t\t<step>" + note3[Character.getNumericValue(s3.charAt(i))] + "</step>");
				System.out.println("\t\t</pitch>");
				System.out.println("\t<notations>");
				System.out.println("\t\t<technical>");
				System.out.println("\t\t\t<string>3</string>");
				System.out.println("\t\t\t<fret>" + s3.charAt(i) + "</fret>");
				System.out.println("\t\t\t</technical>");
				System.out.println("\t\t</notations>");
				System.out.println("\t</note>");
			}
			if (Character.isDigit(s4.charAt(i))) {
				//Prints out info about the note in string 4:
				System.out.println("String = 4 Fret = " + s4.charAt(i) + " Note: " + note4[Character.getNumericValue(s4.charAt(i))]);
				//Coding to print out the note in string 4 in xml format:
				System.out.println("<note>");
				System.out.println("\t<pitch>");
				System.out.println("\t\t<step>" + note4[Character.getNumericValue(s4.charAt(i))] + "</step>");
				System.out.println("\t\t</pitch>");
				System.out.println("\t<notations>");
				System.out.println("\t\t<technical>");
				System.out.println("\t\t\t<string>4</string>");
				System.out.println("\t\t\t<fret>" + s4.charAt(i) + "</fret>");
				System.out.println("\t\t\t</technical>");
				System.out.println("\t\t</notations>");
				System.out.println("\t</note>");
			}
			if (s5 != null && Character.isDigit(s5.charAt(i))) {
				//Prints out info about the note in string 5:
				System.out.println("String = 4 Fret = " + s5.charAt(i) + " Note: " + note5[Character.getNumericValue(s5.charAt(i))]);
				//Coding to print out the note in string 5 in xml format:
				System.out.println("<note>");
				System.out.println("\t<pitch>");
				System.out.println("\t\t<step>" + note5[Character.getNumericValue(s5.charAt(i))] + "</step>");
				System.out.println("\t\t</pitch>");
				System.out.println("\t<notations>");
				System.out.println("\t\t<technical>");
				System.out.println("\t\t\t<string>5</string>");
				System.out.println("\t\t\t<fret>" + s5.charAt(i) + "</fret>");
				System.out.println("\t\t\t</technical>");
				System.out.println("\t\t</notations>");
				System.out.println("\t</note>");
			}
			//Coding to print out the tab in xml format:
			//System.out.println("<?xml version=\"1.0\"?>");
			/*
			System.out.println("<note>");
			System.out.println("\t<pitch>");
			System.out.println("\t\t<step>" + note1[Character.getNumericValue(s1.charAt(i))] + "</step>");
			System.out.println("\t\t</pitch>");
			System.out.println("\t<notations>");
			System.out.println("\t\t<technical>");
			System.out.println("\t\t\t<string>1</string>");
			System.out.println("\t\t\t<fret>" + s1.charAt(i) + "</fret>");
			System.out.println("\t\t\t</technical>");
			System.out.println("\t\t</notations>");
			System.out.println("\t</note>");
			*/
		}
	}
		

	public char getType() 
	{
		return type;
	}

	public void setType(char type) 
	{
		this.type = type;
	}

	public String getS1() {
		return s1;
	}

	public void setS1(String s1) 
	{
		this.s1 = s1;
	}

	public String getS2() 
	{
		return s2;
	}

	public void setS2(String s2) 
	{
		this.s2 = s2;
	}

	public String getS3() 
	{
		return s3;
	}

	public void setS3(String s3) 
	{
		this.s3 = s3;
	}

	public String getS4() 
	{
		return s4;
	}

	public void setS4(String s4) 
	{
		this.s4 = s4;
	}

	public String getS5() 
	{
		return s5;
	}

	public void setS5(String s5) 
	{
		this.s5 = s5;
	}
	
}
