package tab2mxl;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Showtheerror {
	 public static void outputMessage(String problem) {
	        final JFrame parent = new JFrame();
	        
	        parent.pack();
	        parent.setVisible(true);
	    	if (problem.equals("input error")) {
	    		JOptionPane.showMessageDialog(parent,"Sorry the program couldn't read the Tablature, please try again.");
	    		parent.setVisible(false);
	    	}
	    	if (problem.equals("wrong Instrument")) {
	    		JOptionPane.showMessageDialog(parent,"Sorry the program couldn't read the tablature, please fix the tablature and be mindful that it only accepts bass, guitar and drum tablatures");
	    		parent.setVisible(false);
	    	}
	    	if (problem.equals("Empty text area")) {
	    		JOptionPane.showMessageDialog(parent,"Sorry the text area is empty, please enter content then try again");
	    		parent.setVisible(false);
	    	}
	    	if (problem.equals("Already")) {
	    		JOptionPane.showMessageDialog(parent,"Sorry, It already is a xml");
	    		parent.setVisible(false);
	    	}
	    	
	    	if (problem.equals("num error")) {
	    		JOptionPane.showMessageDialog(parent,"Sorry, the time signature is not a number, please try again");
	    		parent.setVisible(false);
	    	}
	    }
}
