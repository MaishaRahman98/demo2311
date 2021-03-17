//package tab2mxl;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//
//public class errorMessage {
//
//    public static void outputMessage(String problem) {
//        final JFrame parent = new JFrame();
//        
//        parent.pack();
//        parent.setVisible(true);
//    	if (problem.equals("input error")) {
//    		JOptionPane.showMessageDialog(parent,"Sorry the program couldn't read the Tablature, please try again.");
//    		parent.setVisible(false);
//    	}
//
//    }
//}

package tab2mxl;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class errorMessage {

    public static void outputMessage(String problem) {
        final JFrame parent = new JFrame();
        
        parent.pack();
        parent.setVisible(true);
    	if (problem.equals("input error")) {
    		JOptionPane.showMessageDialog(parent,"Sorry the program couldn't read the tablature, please try again.");
    		parent.setVisible(false);
    	}
    	if (problem.equals("wrong Instrument")) {
    		JOptionPane.showMessageDialog(parent,"Sorry the program couldn't read the tablature, it only accepts properly formatted bass, guitar, and drum tabs");
    		parent.setVisible(false);
    	}

    }
}
