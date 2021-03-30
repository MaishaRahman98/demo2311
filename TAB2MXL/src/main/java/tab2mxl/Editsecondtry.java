package tab2mxl;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Editsecondtry {

	public JFrame frame;
	private JTextField textField;
	public String feeback;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editsecondtry window = new Editsecondtry();
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
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this.frame, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	public Editsecondtry() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feeback = textField.getText();
				textField_1.setText(feeback);
			}
		});
		btnNewButton.setBounds(63, 144, 100, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnNewButton_1.setBounds(262, 144, 100, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(160, 47, 123, 37);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		String feeback = textField.getText();

		
		JLabel lblNewLabel = new JLabel("Please enter measure numberto edit : ");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(63, 10, 299, 31);
		frame.getContentPane().add(lblNewLabel);
		
		Image img = new ImageIcon(this.getClass().getResource("/acastro_181016_1777_music_0001.jpg")).getImage();
		
		textField_1 = new JTextField();
		textField_1.setBounds(160, 90, 123, 37);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		JLabel lblNewLabel_image = new JLabel(new ImageIcon(img));
		lblNewLabel_image.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel_image);
	}
}
