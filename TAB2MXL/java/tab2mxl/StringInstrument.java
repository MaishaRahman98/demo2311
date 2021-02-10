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

	public static void getBass(String str1, String str2, String str3, String str4, String str5) {
		Bass bass;
		if (str5 == "") {
			bass = Bass.getInstance(str1,str2,str3,str4);
			bass.printTab();
		}
		else {
			bass = Bass.getInstance(str1,str2,str3,str4,str5);
			bass.printTab();
		}
	}
	
	
}
