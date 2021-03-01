package tab2mxl;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class newwindow {

	private JFrame frame123;

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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				window n = new window();
				n.file.open();
				n.frame.setVisible(true);
				close();
//				n.file.open();
			}
		});
		
		btnNewButton.setBounds(171, 86, 93, 23);
		frame123.getContentPane().add(btnNewButton);
	}

}