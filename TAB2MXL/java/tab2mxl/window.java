package tab2mxl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class window {

	private JFrame frame;
	private JLabel lblWelcomeMessage;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window window = new window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Welcome!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "Welcome to the zero version of this project!");
				lblWelcomeMessage.setText("Welcome to the zero version of this project!");
			}
		});
		btnNewButton.setForeground(new Color(0, 255, 255));
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(175, 127, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblWelcomeMessage = new JLabel("New project!");
		lblWelcomeMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeMessage.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblWelcomeMessage.setBounds(76, 62, 286, 15);
		frame.getContentPane().add(lblWelcomeMessage);
	}
}



