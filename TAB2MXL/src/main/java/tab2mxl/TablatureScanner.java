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

		}

	  public void detect(String text)
	  {
    try 
    {
      File myObj = new File("text");
      Scanner myReader = new Scanner(myObj);
      String s1, s2, s3, s4, s5, s6, s7;
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
            				bass = StringInstrument.getBass(s1, s2, s3, s4, s5);
            				bass.printToXML(s1, s2, s3, s4, s5, null, null);
            				break;
            			}
            			else
            			{
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
   
    } catch (FileNotFoundException e) 
    {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    System.out.println("Bass tab scan complete");
    
    //guitar scanner
    
    try 
    {
      File guitarReader= new File("text");
      Scanner myReader1 = new Scanner(guitarReader);
      String s1, s2, s3, s4, s5, s6, s7;
      Guitar guitar;
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
            				guitar = StringInstrument.getGuitar(s1, s2, s3, s4, s5, s6, s7);
            				//guitar.printTab();
            				guitar.printToXML(s1, s2, s3, s4, s5, s6, s7);
            				break;
            			}
            			else
            			{
            				guitar = StringInstrument.getGuitar(s1, s2, s3, s4, s5, s6);
            				//guitar.printTab();
            				guitar.printToXML(s1, s2, s3, s4, s5, s6, null);
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




