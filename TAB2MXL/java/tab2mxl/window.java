package tab2mxl;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class window implements ActionListener{

	public JFrame frame;
	private JFileChooser openfile;
	private BufferedImage ori;
	private JScrollPane scrollPane;
	private JMenuItem iNew, iOpen,iSave, iSaveAs, iExit;
	public JTextArea textArea;
	Functioncallfile file = new Functioncallfile(this);
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
		frame.setBounds(100, 100, 590, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Choose a file");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
				btnNewButton.addActionListener(this);
				btnNewButton.setActionCommand("Open");
//			}
//		});
		btnNewButton.setHorizontalAlignment(SwingConstants.TRAILING);
		btnNewButton.setAutoscrolls(true);
		btnNewButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBorder(BorderFactory.createEmptyBorder());
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		scrollPane_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		textArea = new JTextArea();
		textArea.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		textArea.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrollPane_1.setViewportView(textArea);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
					.addGap(0))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
					.addGap(0))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
		);
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu1 = new JMenu("File");
		menu1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuBar.add(menu1);
		iNew = new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		
		iOpen = new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		
		
		iSave = new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		
		iSaveAs = new JMenuItem("SaveAs");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		
		iExit = new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		
//		iNew, iOpen,iSave, iSaveAs, iExit
		menu1.add(iNew);
		menu1.add(iOpen);
		menu1.add(iSave);
		menu1.add(iSaveAs);
		menu1.add(iExit);
		
		JMenu mnNewMenu = new JMenu("Edit");
		mnNewMenu.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_Format = new JMenu("Fromat");
		mnNewMenu_Format.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuBar.add(mnNewMenu_Format);
//===========================================================================
		JMenuItem mntmNewMenuItemwarp = new JMenuItem("Word Warp: Off");
		mnNewMenu_Format.add(mntmNewMenuItemwarp);
//		mntmNewMenuItemwarp = new JMenuItem("Word Warp: Off");
		mntmNewMenuItemwarp.addActionListener(this);
		mntmNewMenuItemwarp.setActionCommand("Word Wrap");
//===========================================================================
		JMenu mnNewMenufont = new JMenu("Font");
		mnNewMenu_Format.add(mnNewMenufont);
		
		JMenu mnNewMenufontsize = new JMenu("Font Size");
		mnNewMenu_Format.add(mnNewMenufontsize);
		
		JMenu mnNewMenu_2 = new JMenu("Color");
		mnNewMenu_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuBar.add(mnNewMenu_2);
//		scrollPane = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		frame.getContentPane().add(scrollPane);
//		textAreanum1 = new JTextArea();
//		textAreanum1.setBounds(1, 1, 110, 24);
//		frame.getContentPane().add(textAreanum1);
//		scrollPane = new JScrollPane(textAreanum1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		frame.getContentPane().add(scrollPane);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		switch(command){
			case "New": file.newfile(); break;
			case "Open": file.open(); break;
			case "SaveAs":file.saveas();break;
			case "Save": file.save();break;
			case "Exit": file.exit();break;
		}
	}
}



