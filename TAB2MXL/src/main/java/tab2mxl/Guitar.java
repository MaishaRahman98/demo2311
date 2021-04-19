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
	
	

}
