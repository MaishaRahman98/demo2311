package tab2mxl;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PrintStream;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Toolkit;

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
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class window implements ActionListener{

	public JFrame frame;
	private JFileChooser openfile;
	private BufferedImage ori;
	private JScrollPane scrollPane;
	private JMenuItem iNew, iOpen,iSave, iSaveAs, iExit;
	public JTextArea textArea;
	boolean wrap_on = false;
	public JMenuItem mntmNewMenuItemwarp;
	Functioncallfile file = new Functioncallfile(this);
	Functioncallfile format = new Functioncallfile(this);
	
	private PipedInputStream pipein = new PipedInputStream();
	private PipedInputStream pipein2 = new PipedInputStream();
	private Thread reader;
	private Thread reader2;
	boolean quit;
	
	
	//==========================================================
	StringInstrument stringin = new StringInstrument();
//	Bass bassin = new Bass();
	//==========================================================
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
//		beforeinitialize();
//		format.fontname = "Arial";
//		format.font(16);
		file.changecolor("Black");
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
//	private void beforeinitialize() {
//		
//		frame = new JFrame();
//		frame.setBackground(Color.BLACK);
//		frame.setBounds(100, 100, 590, 428);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		JPanel panel = new JPanel();
//		frame.getContentPane().add(panel, BorderLayout.CENTER);
//		panel.setLayout(null);
//		
//		JButton btnNewButton_2 = new JButton("New button");
//		btnNewButton_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//				initialize();
//				close();
//				
//			}
//		});
//		btnNewButton_2.setBounds(229, 172, 93, 23);
//		panel.add(btnNewButton_2);
//		
//	}
	/////////////////////////////////////////////////////////
//	public void close() {
//		WindowEvent closeWindow = new WindowEvent(this.frame, WindowEvent.WINDOW_CLOSING);
//		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
//	}
	/////////////////////////////////////////////////////////
	private void initialize() {
		format.fontname = "Monospaced";
		format.font(16);
//		JFrame frame = new JFrame();
		frame = new JFrame();
		frame.setBackground(SystemColor.activeCaption);

		frame.setBounds(100, 100, 1136, 662);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
//===================================================================================================cannot use window builder		
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		}catch(Exception e){
			
		}
//===================================================================================================cannot use window builder			
		JButton btnNewButton = new JButton("Open");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.PINK);
		btnNewButton.setFont(new Font("ËÎÌו", Font.BOLD, 14));
      frame.setBounds(100, 100, 590, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.BLACK);
		
		JButton btnNewButton = new JButton("Choose");

//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
				btnNewButton.addActionListener(this);
				btnNewButton.setActionCommand("Open");


//			}
//		}); TRAILING
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);

		btnNewButton.setAutoscrolls(true);
		btnNewButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);


		
		JButton btnNewButton_1 = new JButton("Translate");
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.ORANGE);
		btnNewButton_1.setFont(new Font("ËÎÌו", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				file.translate();
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/background.jpeg")).getImage();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		scrollPane_1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		scrollPane_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrollPane_1.setBorder(null);
		scrollPane_1.getVerticalScrollBar().setBorder(null);
		scrollPane_1.getVerticalScrollBar().setBackground(Color.gray);
		scrollPane_1.getHorizontalScrollBar().setBackground(Color.gray);
//===================================================================================================cannot use window builder	
		scrollPane_1.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
		    @Override
		    protected void configureScrollBarColors() {
//		        this.thumbColor = Color.DARK_GRAY;
		        this.thumbColor = Color.black;
		    }
		});
		scrollPane_1.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
		    @Override
		    protected void configureScrollBarColors() {
//		        this.thumbColor = Color.DARK_GRAY;
		    	this.thumbColor = Color.black;
		    }
		});
//===================================================================================================cannot use window builder	
		textArea = new JTextArea();
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(new Color(0, 0, 0));
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
		System.setOut(printStream);
		System.setErr(printStream);
		
//				PrintStream printStream1 = new PrintStream(new CustomOutputStream(textArea));
				
				
				textArea.setBorder(null);
				textArea.setAlignmentY(Component.BOTTOM_ALIGNMENT);
				textArea.setAlignmentX(Component.RIGHT_ALIGNMENT);
				scrollPane_1.setViewportView(textArea);
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(img));
				
				JButton btnNewButton_2 = new JButton("SaveAs");
				btnNewButton_2.addActionListener(this);
				btnNewButton_2.setActionCommand("SaveAs");
//				btnNewButton_2.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//					}
//				});
				btnNewButton_2.setBackground(Color.BLACK);
				btnNewButton_2.setFont(new Font("ËÎÌו", Font.BOLD, 14));
				btnNewButton_2.setForeground(new Color(0, 191, 255));
				GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
				groupLayout.setHorizontalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(198)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
							.addGap(70))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 885, Short.MAX_VALUE)
				);
				groupLayout.setVerticalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(349)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(441)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
							.addGap(64))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 602, Short.MAX_VALUE)
				);
				frame.getContentPane().setLayout(groupLayout);
		

		UIManager.put("PopupMenu.border", new LineBorder(Color.darkGray));

		textArea.setBorder(null);
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
		
		JButton btnNewButton_1 = new JButton("Translate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				file.translate();
				//
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_1, 0, 0, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 90, Short.MAX_VALUE))
					.addGap(9)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addContainerGap(298, Short.MAX_VALUE))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
		);
		

		frame.getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(null);
		menuBar.setBorderPainted(false);
		menuBar.setForeground(Color.DARK_GRAY);
		menuBar.setBackground(Color.DARK_GRAY);
		frame.setJMenuBar(menuBar);
		
		JMenu menu1 = new JMenu("File");
		menu1.setForeground(Color.RED);
		menu1.setBorder(null);
		menu1.setBackground(Color.DARK_GRAY);
		menu1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		menuBar.add(menu1);
		
		iNew = new JMenuItem("New");
		iNew.setForeground(Color.WHITE);
		iNew.setBorder(null);
		iNew.setBackground(Color.DARK_GRAY);
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		
		iOpen = new JMenuItem("Open");
		iOpen.setForeground(Color.WHITE);
		iOpen.setBorder(null);
		iOpen.setBackground(Color.DARK_GRAY);
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		
		
		iSave = new JMenuItem("Save");
		iSave.setForeground(Color.WHITE);
		iSave.setBorder(null);
		iSave.setBackground(Color.DARK_GRAY);
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		
		iSaveAs = new JMenuItem("SaveAs");
		iSaveAs.setForeground(Color.WHITE);
		iSaveAs.setBorder(null);
		iSaveAs.setBackground(Color.DARK_GRAY);
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		
		iExit = new JMenuItem("Exit");
		iExit.setForeground(Color.WHITE);
		iExit.setBorder(null);
		iExit.setBackground(Color.DARK_GRAY);
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		
//		iNew, iOpen,iSave, iSaveAs, iExit
		menu1.add(iNew);
		menu1.add(iOpen);
		menu1.add(iSave);
		menu1.add(iSaveAs);
		menu1.add(iExit);
		
		JMenu mnNewMenu = new JMenu("Edit");
		mnNewMenu.setForeground(new Color(255, 140, 0));
		mnNewMenu.setBackground(Color.DARK_GRAY);
		mnNewMenu.setBorder(null);
		mnNewMenu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_Format = new JMenu("Format");

		mnNewMenu_Format.setBackground(Color.DARK_GRAY);
		mnNewMenu_Format.setForeground(new Color(153, 50, 204));
		mnNewMenu_Format.setBorder(null);
		mnNewMenu_Format.setFont(new Font("Times New Roman", Font.BOLD, 15));

		mnNewMenu_Format.setFont(new Font("Times New Roman", Font.BOLD, 12));

		menuBar.add(mnNewMenu_Format);
//===========================================================================

		mntmNewMenuItemwarp = new JMenuItem("Word Warp: Off");
		mntmNewMenuItemwarp.setForeground(Color.WHITE);
		mntmNewMenuItemwarp.setBackground(Color.DARK_GRAY);
		mntmNewMenuItemwarp.setBorder(null);

		mntmNewMenuItemwarp = new JMenuItem("Word Wrap: Off");

		mnNewMenu_Format.add(mntmNewMenuItemwarp);
//		mntmNewMenuItemwarp = new JMenuItem("Word Warp: Off");
		mntmNewMenuItemwarp.addActionListener(this);
		mntmNewMenuItemwarp.setActionCommand("Word Wrap");
//===========================================================================
		JMenu mnNewMenufont = new JMenu("Font");
		mnNewMenufont.setBackground(Color.DARK_GRAY);
		mnNewMenufont.setForeground(Color.WHITE);
		mnNewMenufont.setBorder(null);
		mnNewMenu_Format.add(mnNewMenufont);
		
		JMenuItem mntmNewMenuItem_Arial = new JMenuItem("Arial");
		mntmNewMenuItem_Arial.setForeground(Color.WHITE);
		mntmNewMenuItem_Arial.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_Arial.setBorder(null);
		mnNewMenufont.add(mntmNewMenuItem_Arial);
		mntmNewMenuItem_Arial.addActionListener(this);
		mntmNewMenuItem_Arial.setActionCommand("Arial");
		
		JMenuItem mntmNewMenuItem_Comic_Sans_Ms = new JMenuItem("Comic Sans MS");
		mntmNewMenuItem_Comic_Sans_Ms.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_Comic_Sans_Ms.setForeground(Color.WHITE);
		mntmNewMenuItem_Comic_Sans_Ms.setBorder(null);
		mnNewMenufont.add(mntmNewMenuItem_Comic_Sans_Ms);
		mntmNewMenuItem_Comic_Sans_Ms.addActionListener(this);
		mntmNewMenuItem_Comic_Sans_Ms.setActionCommand("Comic Sans MS");
		
		JMenuItem mntmNewMenuItem_Time_New_Roman = new JMenuItem("Times New Roman");
		mntmNewMenuItem_Time_New_Roman.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_Time_New_Roman.setForeground(Color.WHITE);
		mntmNewMenuItem_Time_New_Roman.setBorder(null);
		mnNewMenufont.add(mntmNewMenuItem_Time_New_Roman);
		mntmNewMenuItem_Time_New_Roman.addActionListener(this);
		mntmNewMenuItem_Time_New_Roman.setActionCommand("Times New Roman");
		
		JMenuItem mntmNewMenuItem_MONOSPACED = new JMenuItem("MONOSPACED");
		mntmNewMenuItem_MONOSPACED.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_MONOSPACED.setForeground(Color.WHITE);
		mntmNewMenuItem_MONOSPACED.setBorder(null);
		mnNewMenufont.add(mntmNewMenuItem_MONOSPACED);
		mntmNewMenuItem_MONOSPACED.addActionListener(this);
		mntmNewMenuItem_MONOSPACED.setActionCommand("MONOSPACED");
		
		JMenu mnNewMenufontsize = new JMenu("Font Size");
		mnNewMenufontsize.setBorder(null);
		mnNewMenufontsize.setForeground(Color.WHITE);
		mnNewMenufontsize.setBackground(Color.DARK_GRAY);
		mnNewMenu_Format.add(mnNewMenufontsize);
		
		JMenuItem mntmNewMenuItem_size4 = new JMenuItem("4");
		mntmNewMenuItem_size4.setForeground(Color.WHITE);
		mntmNewMenuItem_size4.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_size4.setBorder(null);
		mnNewMenufontsize.add(mntmNewMenuItem_size4);
		mntmNewMenuItem_size4.addActionListener(this);
		mntmNewMenuItem_size4.setActionCommand("size4");
		
		JMenuItem mntmNewMenuItem_size8 = new JMenuItem("8");
		mntmNewMenuItem_size8.setForeground(Color.WHITE);
		mntmNewMenuItem_size8.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_size8.setBorder(null);
		mnNewMenufontsize.add(mntmNewMenuItem_size8);
		mntmNewMenuItem_size8.addActionListener(this);
		mntmNewMenuItem_size8.setActionCommand("size8");
		
		JMenuItem mntmNewMenuItem_size12 = new JMenuItem("12");
		mntmNewMenuItem_size12.setForeground(Color.WHITE);
		mntmNewMenuItem_size12.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_size12.setBorder(null);
		mnNewMenufontsize.add(mntmNewMenuItem_size12);
		mntmNewMenuItem_size12.addActionListener(this);
		mntmNewMenuItem_size12.setActionCommand("size12");
		
		JMenuItem mntmNewMenuItem_size16 = new JMenuItem("16");
		mntmNewMenuItem_size16.setForeground(Color.WHITE);
		mntmNewMenuItem_size16.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_size16.setBorder(null);
		mnNewMenufontsize.add(mntmNewMenuItem_size16);
		mntmNewMenuItem_size16.addActionListener(this);
		mntmNewMenuItem_size16.setActionCommand("size16");
		
		JMenuItem mntmNewMenuItem_size20 = new JMenuItem("20");
		mntmNewMenuItem_size20.setForeground(Color.WHITE);
		mntmNewMenuItem_size20.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_size20.setBorder(null);
		mnNewMenufontsize.add(mntmNewMenuItem_size20);
		mntmNewMenuItem_size20.addActionListener(this);
		mntmNewMenuItem_size20.setActionCommand("size20");
		
		JMenuItem mntmNewMenuItem_size24 = new JMenuItem("24");
		mntmNewMenuItem_size24.setForeground(Color.WHITE);
		mntmNewMenuItem_size24.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_size24.setBorder(null);
		mnNewMenufontsize.add(mntmNewMenuItem_size24);
		mntmNewMenuItem_size24.addActionListener(this);
		mntmNewMenuItem_size24.setActionCommand("size24");
		
		JMenuItem mntmNewMenuItem_size28 = new JMenuItem("28");
		mntmNewMenuItem_size28.setForeground(Color.WHITE);
		mntmNewMenuItem_size28.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_size28.setBorder(null);
		mnNewMenufontsize.add(mntmNewMenuItem_size28);
		mntmNewMenuItem_size28.addActionListener(this);
		mntmNewMenuItem_size28.setActionCommand("size28");
		
		JMenu mnNewMenu_2 = new JMenu("Color");
		mnNewMenu_2.setForeground(Color.BLUE);
		mnNewMenu_2.setBackground(Color.DARK_GRAY);
		mnNewMenu_2.setBorder(null);
		mnNewMenu_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem icolor = new JMenuItem("White");
		icolor.setForeground(Color.WHITE);
		icolor.setBackground(Color.DARK_GRAY);
		icolor.setBorder(null);
		mnNewMenu_2.add(icolor);
		icolor.addActionListener(this);
		icolor.setActionCommand("White");
		
		JMenuItem icolor2 = new JMenuItem("Black");
		icolor2.setForeground(Color.WHITE);
		icolor2.setBackground(Color.DARK_GRAY);
		icolor2.setBorder(null);
		mnNewMenu_2.add(icolor2);
		icolor2.addActionListener(this);
		icolor2.setActionCommand("Black");
		
		JMenuItem icolor3 = new JMenuItem("Pink");
		icolor3.setForeground(Color.WHITE);
		icolor3.setBackground(Color.DARK_GRAY);
		icolor3.setBorder(null);
		mnNewMenu_2.add(icolor3);
		icolor3.addActionListener(this);
		icolor3.setActionCommand("Pink");
		
		JMenuItem icolor4 = new JMenuItem("Blue");
		icolor4.setForeground(Color.WHITE);
		icolor4.setBackground(Color.DARK_GRAY);
		icolor4.setBorder(null);
		mnNewMenu_2.add(icolor4);
		icolor4.addActionListener(this);
		icolor4.setActionCommand("Blue");

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
			case "size4": file.font(4);break;
			case "size8": file.font(8);break;
			case "size12": file.font(12);break;
			case "size16": file.font(16);break;
			case "size20": file.font(20);break;
			case "size24": file.font(24);break;
			case "size28": file.font(28);break;
			case "Arial": format.setfont(command);break;
			case "Comic Sans MS": format.setfont(command);break;
			case "Times New Roman": format.setfont(command);break;
			case "Word Wrap": file.wrap();break;
			case "White": file.changecolor(command);break;
			case "Black": file.changecolor(command);break;
			case "Pink": file.changecolor(command);break;
			case "Blue": file.changecolor(command);break;
			case "MONOSPACED": format.setfont(command);break;
		}
	}
}
