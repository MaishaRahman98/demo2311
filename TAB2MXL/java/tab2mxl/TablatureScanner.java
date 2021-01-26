package tab2mxl;
import java.io.File;  
import java.io.FileNotFoundException; 
import java.util.Scanner; 
public class TablatureScanner {

  public static void main(String[] args) {
    try {
      File myObj = new File("drumTablature.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        if (data.startsWith("E|"))
        {
        	System.out.println("Guitar");
        	break;
        }
        else if (data.startsWith("G|"))
        {
        	System.out.println("Bass");
        	break;
        }
        else if (data.startsWith("C |"))
        {
        	System.out.println("Drums");
        	break;
        }
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
