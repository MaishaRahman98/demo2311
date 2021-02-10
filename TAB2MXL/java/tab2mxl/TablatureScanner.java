package tab2mxl;
import java.io.File;  
import java.io.FileNotFoundException; 
import java.util.Scanner; 
public class TablatureScanner 
{
	String texta;
	window win;
  public TablatureScanner(window win) {
		this.win =win;
		// TODO Auto-generated constructor stub
	}

public void detect(String text)
  {
    try 
    {
//      File myObj = new File(filename);
      Scanner myReader = new Scanner(text);
      String s1, s2, s3, s4, s5;
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
            				StringInstrument.getBass(s1, s2, s3, s4, s5);
            				break;
            			}
            			else
            			{
            				StringInstrument.getBass(s1, s2, s3, s4);
            				break;
            			}
            		}
            		
            	}
        		
        	}
        }
    
      }
        
      myReader.close();
    } catch (Exception e) 
    {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    System.out.println("return 0");
}
}



/*
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
*/