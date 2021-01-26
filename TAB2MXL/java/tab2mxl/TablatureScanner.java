package tab2mxl;
import java.io.File;  
import java.io.FileNotFoundException; 
import java.util.Scanner; 
public class TablatureScanner {

  public static void main(String[] args) {
    try {
      File myObj = new File("drumTablature.txt");
      Scanner myReader = new Scanner(myObj);
      boolean bool=true;
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        if (bool && data.startsWith("E|"))
        {
        	System.out.println("Guitar");
        	bool=false;
        }
        else if (bool && data.startsWith("G|"))
        {
        	System.out.println("Bass");
        	bool=false;
        }
        else if (bool && data.startsWith("C |"))
        {
        	System.out.println("Drums");
        	bool=false;
        }
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
