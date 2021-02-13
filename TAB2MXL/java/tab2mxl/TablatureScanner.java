package tab2mxl;
import java.io.File;  
import java.io.FileNotFoundException; 
import java.util.Scanner; 
public class TablatureScanner 
{

  public static void main(String[] args) 
  {
    try 
    {
      File myObj = new File("bassTablature.txt");
      Scanner myReader = new Scanner(myObj);
      String s1, s2, s3, s4, s5;
      Bass bass;
      while (myReader.hasNextLine()) 
      {
        String data = myReader.nextLine();
        while (data.startsWith("G|"))
        {
        	s1 = data;
        	data = myReader.nextLine();
        	while (data.startsWith("D|"))
        	{
        		s2 = data;
        		data = myReader.nextLine();
            	while (data.startsWith("A|"))
            	{
            		s3 = data;
            		data = myReader.nextLine();
            		while (data.startsWith("E|"))
            		{
            			s4 = data;
            			if (myReader.hasNextLine())
            			data = myReader.nextLine();
            			
            			if (data.startsWith("B|"))
            			{
            				s5 = data;
            				bass = Bass.getInstance(s1, s2, s3, s4, s5);
            				bass.printTab();
            				break;
            			}
            			else
            			{
            				bass = Bass.getInstance(s1, s2, s3, s4);
            				bass.printTab();
            				break;
            			}
            		}
            		
            	}
        		
        	}
        }
    
      }
        
      myReader.close();
    } catch (FileNotFoundException e) 
    {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    System.out.println("return 0");
}
}
