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
	    		JOptionPane.showMessageDialog(parent,"Sorry the program couldn't read the Tablature, it only accepts bass and guitar tabs");
	    		parent.setVisible(false);
	    	}
	    	if (problem.equals("Empty text area")) {
	    		JOptionPane.showMessageDialog(parent,"Sorry the textarea is empty, please enter content then try again");
	    		parent.setVisible(false);
	    	}
	    	if (problem.equals("Already")) {
	    		JOptionPane.showMessageDialog(parent,"Sorry, It already is a xml");
	    		parent.setVisible(false);
	    	}
	    }
}
