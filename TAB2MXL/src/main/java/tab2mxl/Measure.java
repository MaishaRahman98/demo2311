package tab2mxl;

import java.util.ArrayList;

public class Measure {
	
	public String input;
	public int duration = 0;
	public String noteMeasure;
	public int octaveMeasure;

	public Measure(String input) {
		this.input = input;
		this.duration = duration;
		this.noteMeasure = noteMeasure;
		this.octaveMeasure = octaveMeasure;
	}

	public static String durationCheck(int spaceCount) {
		if (spaceCount == 1 || spaceCount == 0) {
			return "eighth";
		} else if (spaceCount == 2) {
			return "quarter";
		} else if (spaceCount == 4) {
			return "half";
		} else if (spaceCount == 8) {
			return "whole";
		}
		return "quarter";
	}

	public ArrayList<String> legatos(String text) {
		String info = "";
		String hammerOrPull = "";
		String fret = "";
		ArrayList<String> output = new ArrayList<>();
		for (int i = 0; i < text.length(); i++) {
			if (Character.toString(Character.toLowerCase(text.charAt(i))).equals("p")) {
				hammerOrPull = "P";
				if (i + 1 != text.length()) {
					fret += text.charAt(i + 1);
					if (i + 2 != text.length() && text.charAt(i + 2) != '-') {
						fret += text.charAt(i + 2);
					}
				}
			} else if (Character.toString(Character.toLowerCase(text.charAt(i))).equals("h")) {
				hammerOrPull = "H";
				if (i + 1 != text.length()) {
					fret += text.charAt(i + 1);
					if (i + 2 != text.length() && text.charAt(i + 2) != '-') {
						fret += text.charAt(i + 2);
					}
				}
			}
		}
		if (hammerOrPull.equals("H")) {
			output.add("hammer-on");
			output.add(hammerOrPull);
			output.add(fret);
			return output;
		} else if (hammerOrPull.equals("P")) {
			output.add("pull-off");
			output.add(hammerOrPull);
			output.add(fret);
			return output;
		}
		return null;
	}

	public String getDuration(int amount) {
		return Measure.durationCheck(amount);
	}

	public String getNoteMeasure(String strNum, int fret, String instrumentType) {
		if (instrumentType.equals("bass")) {
			noteMeasure = Notes.bassNotes(strNum, fret);
			return noteMeasure;
		}

		else if (instrumentType.equals("guitar")) {
			noteMeasure = Notes.guitarNotes(strNum, fret);
			return noteMeasure;
		} else {
			return noteMeasure;
		}
	}

	public int getOctaveMeasure(String strNum, int fret, String instrumentType) {
		if (instrumentType.equals("bass")) {
			octaveMeasure = Notes.bassOctave(strNum, fret);
			return octaveMeasure;
		}

		else if (instrumentType.equals("guitar")) {
			octaveMeasure = Notes.guitarOctave(strNum, fret);
			return octaveMeasure;
		} else {
			return octaveMeasure;
		}
	}
	
//	public String input;
//	public Measure(String input) {
//		this.input = input;
//	}
//	
//	public static String durationCheck(int spaceCount) {
//		if (spaceCount == 8) {
//			return "";
//		}
//		return null;
//	}
//	
//	public static ArrayList<String> legatos(String text) {
//		String info = "";
//		String hammerOrPull = "";
//		ArrayList<String> output = new ArrayList<>();
//		for(int i = 0; i < text.length();i++) {
//			if (text.charAt(i) == '-') {
//				info = text.replace("-","");
//			}
//			else if (Character.toString(Character.toLowerCase(text.charAt(i))).equals("p")) {
//				hammerOrPull = "P";
//			}
//			else if (Character.toString(Character.toLowerCase(text.charAt(i))).equals("h")) {
//				hammerOrPull = "H";
//			}
//		}
//		if(hammerOrPull.equals("H")) {
//			output.add("hammer-on");
//			output.add(hammerOrPull);
//			return output;
//		}
//		else if(hammerOrPull.equals("P")) {
//			output.add("pull-off");
//			output.add(hammerOrPull);
//			return output;
//		}
//		System.out.println(info);
//		return null;
//	}
}