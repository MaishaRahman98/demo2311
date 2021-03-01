package tab2mxl;

import java.util.ArrayList;

public class Measure {
	public String input;
	public Measure(String input) {
		this.input = input;
	}
	
	public static String durationCheck(int spaceCount) {
		if (spaceCount == 8) {
			return "";
		}
		return null;
	}
	
	public static ArrayList<String> legatos(String text) {
		String info = "";
		String hammerOrPull = "";
		ArrayList<String> output = new ArrayList<>();
		for(int i = 0; i < text.length();i++) {
			if (text.charAt(i) == '-') {
				info = text.replace("-","");
			}
			else if (Character.toString(Character.toLowerCase(text.charAt(i))).equals("p")) {
				hammerOrPull = "P";
			}
			else if (Character.toString(Character.toLowerCase(text.charAt(i))).equals("h")) {
				hammerOrPull = "H";
			}
		}
		if(hammerOrPull.equals("H")) {
			output.add("hammer-on");
			output.add(hammerOrPull);
			return output;
		}
		else if(hammerOrPull.equals("P")) {
			output.add("pull-off");
			output.add(hammerOrPull);
			return output;
		}
		System.out.println(info);
		return null;
	}
}