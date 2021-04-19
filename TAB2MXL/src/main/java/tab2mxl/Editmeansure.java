package tab2mxl;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Editmeansure {
	public static String name;
	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editmeansure window = new Editmeansure(name);
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
	
	public Editmeansure(String name) {
		this.name = name;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JTextField userNum;
		JTextArea userMeasure = new JTextArea();
		JLabel askUser;
		int x = 100;
		int y = 100;
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(x, y, 500, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		askUser = new JLabel();
		askUser.setText("Please enter a measure number to edit: ");
		askUser.setBounds(x-30, y-50, 250, 30);
		userNum = new JTextField("");
		userNum.setBounds(x + 200, y-50, 80, 30);
		userMeasure.setBounds(x-50, y, 400, 250);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(x-50, y, 400, 250);
		scrollPane_1.setViewportView(userMeasure);
		frame.add(askUser);
		frame.add(userNum);
		frame.add(userMeasure);
		frame.add(scrollPane_1);
		
//		JComboBox comboBox = new JComboBox();
//		comboBox.setBounds(84, 36, 159, 23);
//		frame.getContentPane().add(comboBox);
//		comboBox.addItem("Select one");
//		comboBox.addItem("1/4");
//		comboBox.addItem("2/4");
//		comboBox.addItem("3/4");
//		comboBox.addItem("4/4");
//		
//		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputOrgTablature output = new outputOrgTablature(name);
				String value = userNum.getText();
				userMeasure.setLineWrap(true);
				userMeasure.setWrapStyleWord(true);
				userMeasure.setText(output.outputMeasure(Integer.parseInt(value)));
			}
		});
		btnNewButton.setBounds(x+285, y-45, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
//		JButton btnNewButton_1 = new JButton("Cancel");
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				close();
//			}
//		});
//		btnNewButton_1.setBounds(x+187, y+126, 93, 23);
//		frame.getContentPane().add(btnNewButton_1);
		
//		Image img = new ImageIcon(this.getClass().getResource("/acastro_181016_1777_music_0001.jpg")).getImage();
//		JLabel lblNewLabel = new JLabel(new ImageIcon(img));
//		lblNewLabel.setBounds(0, 0, 332, 190);
//		frame.getContentPane().add(lblNewLabel);
		
	}
}
