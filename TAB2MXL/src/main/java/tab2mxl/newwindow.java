package tab2mxl;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class newwindow {

	public JFrame frame123;
	public int dec = 10;
	Functioncallfile file = new Functioncallfile(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newwindow window = new newwindow();
					window.frame123.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public newwindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void close() {
		WindowEvent closeWindow = new WindowEvent(frame123, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	private void initialize() {
		frame123 = new JFrame();
		frame123.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame123.setBounds(100, 100, 450, 300);
		frame123.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("YES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				close();
//				window n = new window();
//				n.file.open();
//				n.frame.setVisible(true);
				file.save();
				close();
//				file.de = true;

			}
		});
		
		btnNewButton.setBounds(89, 149, 93, 23);
		frame123.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("NO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				file.de = false;
//				window n = new window();
//				n.textArea.setText("");
//				n.file.newfile();

			}
		});
		btnNewButton_1.setBounds(251, 149, 93, 23);
		frame123.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Do you want to save the file?");
		lblNewLabel.setBounds(111, 59, 233, 48);
		frame123.getContentPane().add(lblNewLabel);
	}
	
}