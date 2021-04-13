package tab2mxl;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
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
		Font Monospaced;
		Monospaced = new Font("Monospaced",Font.PLAIN, 12);
		JTextField userNum;
		JLabel askUser;
		int x = 100;
		int y = 100;
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(x, y, 500, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		askUser = new JLabel();
		askUser.setText("Please enter a measure number to edit: ");
		askUser.setBounds(x-30, y-50, 250, 30);
		userNum = new JTextField("");
		userNum.setBounds(x + 200, y-50, 80, 30);
		frame.getContentPane().add(askUser);
		frame.getContentPane().add(userNum);
		
		JScrollPane scrollPane = new JScrollPane();
		JTextArea userMeasure = new JTextArea();
		scrollPane.setBounds(50, 100, 400, 250);
		scrollPane.setBorder(null);
		scrollPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		scrollPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrollPane.setBorder(null);
		scrollPane.getVerticalScrollBar().setBorder(null);
		scrollPane.getVerticalScrollBar().setBackground(Color.gray);
		scrollPane.getHorizontalScrollBar().setBackground(Color.gray);
		scrollPane.setViewportView(userMeasure);
		frame.getContentPane().add(scrollPane);
		userMeasure.setFont(Monospaced);
		
		
		JTextField userBeatSignature = new JTextField("");
		JLabel askBeatSig = new JLabel();
		JTextField userBeatTypeSignature = new JTextField("");
		JLabel askBeatTypeSig = new JLabel();
		askBeatSig.setText("Please enter the amount of beats:");
		askBeatTypeSig.setText("Please enter the beat type:");
		askBeatSig.setBounds(x-50,y+260,200,30);
		userBeatSignature.setBounds(x+140,y+265,30,20);
		askBeatTypeSig.setBounds(x-50,y+290,200,30);
		userBeatTypeSignature.setBounds(x+110,y+295,30,20);
		frame.getContentPane().add(askBeatSig);
		frame.getContentPane().add(askBeatTypeSig);
		frame.getContentPane().add(userBeatTypeSignature);
		frame.getContentPane().add(userBeatSignature);
		
		
//		JComboBox comboBox = new JComboBox();
//		comboBox.setBounds(84, 36, 159, 23);
//		frame.getContentPane().add(comboBox);
//		comboBox.addItem("Select one");
//		comboBox.addItem("1/4");
//		comboBox.addItem("2/4");
//		comboBox.addItem("3/4");
//		comboBox.addItem("4/4");
//		
		
		JButton btnNewButton2 = new JButton("Confirm");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Edit output = new Edit(name);
				String value = userNum.getText();
				userMeasure.setLineWrap(true);
				userMeasure.setWrapStyleWord(true);
				userMeasure.setText(output.outputMeasure(Integer.parseInt(value)));
			}
		});
		btnNewButton2.setBounds(x+285, y-45, 93, 23);
		frame.getContentPane().add(btnNewButton2);
		
		JButton btnNewButton3 = new JButton("Convert Again");
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = userMeasure.getText();
			}
		});
		btnNewButton3.setBounds(x+90, y+330, 103, 33);
		frame.getContentPane().add(btnNewButton3);
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
