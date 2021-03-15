package tab2mxl;

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
	
	
	
	
}
