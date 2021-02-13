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
            				//bass.printTab();
            				bass.printToXML();
            				break;
            			}
            			else
            			{
            				bass = Bass.getInstance(s1, s2, s3, s4);
            				//bass.printTab();
            				bass.printToXML();
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
    System.out.println("Bass tab scan complete");
    
    //guitar scanner
    
    try 
    {
      File guitarReader= new File("guitarTablature.txt");
      Scanner myReader1 = new Scanner(guitarReader);
      String s1, s2, s3, s4, s5, s6, s7;
      while (myReader1.hasNextLine()) 
      {
        String line = myReader1.nextLine();
        while (line.startsWith("E|"))
        {
        	s1 = line;
        	line = myReader1.nextLine();
        	while (line.startsWith("B|"))
        	{
        		s2 = line;
        		line = myReader1.nextLine();
            	while (line.startsWith("G|"))
            	{
            		s3 = line;
            		line = myReader1.nextLine();
            		while (line.startsWith("D|"))
            		{
            			
            		    s4 = line;
            			line = myReader1.nextLine();
                		while (line.startsWith("A|"))
                		{
            			s5 = line;
            			line = myReader1.nextLine();
            		    while(line.startsWith("|D")) {
            						s6 = line;
            			
            			if (myReader1.hasNextLine())
            			line = myReader1.nextLine();
            			
            			if (line.startsWith("B|"))
            			{
            				s7 = line;
            				StringInstrument.getGuitar(s1, s2, s3, s4, s5, s6, s7);
            				break;
            			}
            			else
            			{
            				StringInstrument.getGuitar(s1, s2, s3, s4, s5, s6);
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
    
     catch (FileNotFoundException e) 
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

