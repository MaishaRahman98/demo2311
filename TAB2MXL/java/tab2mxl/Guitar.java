package tab2mxl;

public class Guitar extends StringInstrument {
	private Guitar() {
		super();
	}
	
	private Guitar(String s1, String s2, String s3, String s4, String s5, String s6) {
		super (s1, s2, s3, s4, s5, s6);
		//six string guitar
	}
	private Guitar (String s1, String s2, String s3, String s4, String s5, String s6, String s7) {
		super (s1, s2, s3, s4, s5, s6, s7);
		//seven string guitar
	}
	
	public static Guitar getInstance(String s1, String s2, String s3, String s4, String s5, String s6)
	{
		return new Guitar(s1, s2, s3, s4, s5, s6);
	}
	
	public static Guitar getInstance(String s1, String s2, String s3, String s4, String s5, String s6, String s7)
	{
		return new Guitar(s1, s2, s3, s4, s5, s6, s7);	
	}
	public void printTab()
	{		         
		for (int i = 2 ; this.getStr1().charAt(i) != '|' ; i++)
		{
			if (Character.isDigit(this.getStr1().charAt(i)))
				System.out.println("String = 1 Fret = " + this.getStr1().charAt(i) + " Note: " + Notes.guitarNotes("String1",Character.getNumericValue(this.getStr1().charAt(i))));
			
			if (Character.isDigit(this.getStr2().charAt(i)))
				System.out.println("String = 2 Fret = " + this.getStr2().charAt(i) + " Note: " + Notes.guitarNotes("String2",Character.getNumericValue(this.getStr2().charAt(i))));
			
			if (Character.isDigit(this.getStr3().charAt(i)))
				System.out.println("String = 3 Fret = " + this.getStr3().charAt(i) + " Note: " + Notes.guitarNotes("String3",Character.getNumericValue(this.getStr3().charAt(i))));
			
			if (Character.isDigit(this.getStr4().charAt(i)))
				System.out.println("String = 4 Fret = " + this.getStr4().charAt(i) + " Note: " + Notes.guitarNotes("String4",Character.getNumericValue(this.getStr4().charAt(i))));
			
			if (Character.isDigit(this.getStr5().charAt(i)))
				System.out.println("String = 5 Fret = " + this.getStr5().charAt(i) + " Note: " + Notes.guitarNotes("String5",Character.getNumericValue(this.getStr5().charAt(i))));
			
			if (Character.isDigit(this.getStr6().charAt(i)))
				System.out.println("String = 6 Fret = " + this.getStr6().charAt(i) + " Note: " + Notes.guitarNotes("String6",Character.getNumericValue(this.getStr6().charAt(i))));
			
			if (this.getStr7() != null && Character.isDigit(this.getStr7().charAt(i)))
				System.out.println("String = 7 Fret = " + this.getStr7().charAt(i) + " Note: " + Notes.guitarNotes("String7",Character.getNumericValue(this.getStr7().charAt(i))));
		}
	}
	

}
