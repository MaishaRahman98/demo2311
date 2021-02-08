package tab2mxl;

public class StringInstrument {
	private String str1;
	private String str2;
	private String str3;
	private String str4;
	private String str5;
	private char type; //number of strings
	
	public StringInstrument() {
		this.type = ' ';
		this.str1 = "";
		this.str2 = "";
		this.str3 = "";
		this.str4 = "";
		this.str5 = "";
	}
	public StringInstrument(String str1, String str2, String str3, String str4) {
		this.str1 = str1;
		this.str2 = str2;
		this.str3 = str3;
		this.str4 = str4;	
	}

	public static void getBassFourString(String str1, String str2, String str3, String str4) {
		Bass bassFour;
		bassFour = Bass.getInstance(str1,str2,str3,str4);
		bassFour.printTab();
	}
	public static void getBassFiveString(String str1, String str2, String str3, String str4, String str5) {
		Bass bassFive;
		bassFive = Bass.getInstance(str1,str2,str3,str4,str5);
		bassFive.printTab();
		
	}
	
	
//	public static StringInstrument bassFourString(String s1, String s2, String s3, String s4) {
//		return bassInstrument.getInstance(s1,s2,s3,s4);
//		
//	}
//	public static StringInstrument bassFiveString(String s1, String s2, String s3, String s4, String s5) {
//		return bassInstrument.getInstance(s1,s2,s3,s4,s5);
//	}
}
