package tab2mxl;

public class Bass extends Strings
{
	private char type; //number of strings
	private String s1, s2, s3, s4, s5;
	final String[] note1 = {"G", "Ab", "A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G"};
	final String[] note2 = {"D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B", "C", "Db", "D"};
	final String[] note3 = {"A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A"};
	final String[] note4 = {"E", "F", "Gb", "G", "Ab", "A", "Bb", "B", "C", "Db", "D", "Eb", "E"};
	final String[] note5 = {"B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B"};
	
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
		for (int i = 2 ; s1.charAt(i) != '|' ; i++)
		{
			if (Character.isDigit(s1.charAt(i)))
				System.out.println("String = 1 Fret = " + s1.charAt(i) + " Note: " + note1[Character.getNumericValue(s1.charAt(i))]);
			
			if (Character.isDigit(s2.charAt(i)))
				System.out.println("String = 2 Fret = " + s2.charAt(i) + " Note: " + note2[Character.getNumericValue(s2.charAt(i))]);
			
			if (Character.isDigit(s3.charAt(i)))
				System.out.println("String = 3 Fret = " + s3.charAt(i) + " Note: " + note3[Character.getNumericValue(s3.charAt(i))]);
			
			if (Character.isDigit(s4.charAt(i)))
				System.out.println("String = 4 Fret = " + s4.charAt(i) + " Note: " + note4[Character.getNumericValue(s4.charAt(i))]);
			
			if (s5 != null && Character.isDigit(s5.charAt(i)))
				System.out.println("String = 4 Fret = " + s5.charAt(i) + " Note: " + note5[Character.getNumericValue(s5.charAt(i))]);
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
