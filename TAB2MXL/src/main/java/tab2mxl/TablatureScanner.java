package tab2mxl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TablatureScanner {
	String texta;
	window win;

	public TablatureScanner(window win) {
		this.win = win;

	}

	public void detect(String text) {
		int count = 0;
		Scanner myReader = new Scanner(text);
		while (myReader.hasNextLine()) {
			String s = myReader.nextLine();
			if (s.charAt(0) == ' ') {
				if (count < 4) {
					count = 0;
				}
				else {
					break;
				}
			} 
			else if (s.charAt(1) == '|' && s.endsWith("|")) {
				count += 1;
			}
		}
		System.out.println(count);
		if (count == 4 || count == 5) {
			TablatureScanner.callBassClass(text);
		}
		if (count == 6 || count == 7) {
			TablatureScanner.callGuitarClass(text);
		}

		myReader.close();
	}

	public static void callBassClass(String text) {
		Scanner myReader = new Scanner(text);
		String s1, s2, s3, s4, s5;
		Bass bass;
		while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			while (data.startsWith("G|")) {
				s1 = data;
				data = myReader.nextLine();
				while (data.startsWith("D|")) {
					s2 = data;
					data = myReader.nextLine();
					while (data.startsWith("A|")) {
						s3 = data;
						data = myReader.nextLine();
						while (data.startsWith("E|")) {
							s4 = data;
							if (myReader.hasNextLine())
								data = myReader.nextLine();

							if (data.startsWith("B|")) {
								s5 = data;
								bass = StringInstrument.getBass(s1, s2, s3, s4, s5);
								bass.printToXML(s1, s2, s3, s4, s5, null, null);
								break;
							} else {
								bass = StringInstrument.getBass(s1, s2, s3, s4);
								bass.printToXML(s1, s2, s3, s4, null, null, null);
								break;
							}
						}

					}

				}
			}

		}

		myReader.close();

	}

	// guitar scanner
	public static void callGuitarClass(String text1) {
		
		Scanner myReader1 = new Scanner(text1);
		String s1, s2, s3, s4, s5, s6, s7;
		Guitar guitar;
		while (myReader1.hasNextLine()) {
			String line = myReader1.nextLine();
			while (line.startsWith("E|")) {
				s1 = line;
				line = myReader1.nextLine();
				while (line.startsWith("B|")) {
					s2 = line;
					line = myReader1.nextLine();
					while (line.startsWith("G|")) {
						s3 = line;
						line = myReader1.nextLine();
						while (line.startsWith("D|")) {

							s4 = line;
							line = myReader1.nextLine();
							while (line.startsWith("A|")) {
								s5 = line;
								line = myReader1.nextLine();
								while (line.startsWith("|D")) {
									s6 = line;

									if (myReader1.hasNextLine())
										line = myReader1.nextLine();

									if (line.startsWith("B|")) {
										s7 = line;
										guitar = StringInstrument.getGuitar(s1, s2, s3, s4, s5, s6, s7);
										guitar.printTab();
//										guitar.printToXML(s1, s2, s3, s4, s5, s6, s7);
										break;
									} 
									else {
										System.out.println("test");
										guitar = StringInstrument.getGuitar(s1, s2, s3, s4, s5, s6);
										guitar.printTab();
										
//										guitar.printToXML(s1, s2, s3, s4, s5, s6, null);
										break;
									}
								}
							}

						}

					}
				}

			}
		}

		myReader1.close();

	}

}
