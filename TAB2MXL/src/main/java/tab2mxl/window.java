package tab2mxl;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.AbstractAction;
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
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.Document;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
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
import javax.swing.JComboBox;

public class window implements ActionListener{

	public JFrame frame;
	private JFileChooser openfile;
	private BufferedImage ori;
	private JScrollPane scrollPane;
	private JMenuItem iNew, iOpen,iSave, iSaveAs, iExit;
	public JMenuItem mntmNewMenuItem_Undo,mntmNewMenuItem_Redo;
	public JTextArea textArea;
	boolean wrap_on = false;
	public JMenuItem mntmNewMenuItemwarp;
	Functioncallfile file = new Functioncallfile(this);
	Functioncallfile format = new Functioncallfile(this);
//	Edit ed = new Edit(this);
	Shortcut sc = new Shortcut(this);
	private PipedInputStream pipein = new PipedInputStream();
	private PipedInputStream pipein2 = new PipedInputStream();
	private Thread reader;
	private Thread reader2;
	public JButton btnNewButton_1;
	boolean quit;
	static String mean = "";
	UndoManager um = new UndoManager();
	Editmeansure un = new Editmeansure();
	//=========undo and redo
//	private Document editorPaneDocument;
//	protected UndoHandler undoHandler = new UndoHandler();
//	protected UndoManager undoManager = new UndoManager();
//	private UndoAction undoAction = null;
//	private RedoAction redoAction = null;
	//=========
	
	
	//==========================================================
	StringInstrument stringin = new StringInstrument();
	public JOptionPane ooo;
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
	public void close() {
		WindowEvent closeWindow = new WindowEvent(this.frame, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
	}
	/////////////////////////////////////////////////////////
	private void initialize() {
		format.fontname = "Monospaced";
		format.font(16);
//		JFrame frame = new JFrame();
		frame = new JFrame();
//		JFrame f = new JFrame();
		
//		try {
//			frame.getContentPane().add(new overridepiant("sample.jpeg"));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		frame.getContentPane().setForeground(new Color(75, 0, 130));
		frame.setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 1055, 662);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
//		UIManager.put("TextField.caretForeground", new ColorUIResource(Color.PINK));
//===================================================================================================cannot use window builder		
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		}catch(Exception e){
			
		}
//===================================================================================================cannot use window builder			
		JButton btnNewButton = new JButton("Open");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.PINK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
				btnNewButton.addActionListener(this);
				btnNewButton.setActionCommand("Open");
		btnNewButton.setAutoscrolls(true);
		btnNewButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);


		
		btnNewButton_1 = new JButton("Translate");
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.ORANGE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				file.translate();
			}
		});
				

//				JLabel lblNewLabel = new JLabel("");
//				lblNewLabel.setForeground(Color.ORANGE);
//				lblNewLabel.setBackground(Color.ORANGE);
				
				JButton btnNewButton_2 = new JButton("SaveAs");
				btnNewButton_2.addActionListener(this);
				btnNewButton_2.setActionCommand("SaveAs");
//				btnNewButton_2.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//					}
//				});
				btnNewButton_2.setBackground(Color.BLACK);
				btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
				btnNewButton_2.setForeground(new Color(0, 191, 255));
				
						
						JScrollPane scrollPane_1 = new JScrollPane();
						scrollPane_1.setBorder(null);
						scrollPane_1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
						scrollPane_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
						scrollPane_1.setBorder(null);
						scrollPane_1.getVerticalScrollBar().setBorder(null);
						scrollPane_1.getVerticalScrollBar().setBackground(Color.gray);
						scrollPane_1.getHorizontalScrollBar().setBackground(Color.gray);
						//===================================================================================================cannot use window builder	
						//		scrollPane_1.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
						//		    @Override
						//		    protected void configureScrollBarColors() {
						////		        this.thumbColor = Color.DARK_GRAY;
						//		        this.thumbColor = Color.black;
						//		    }
						//		});
						//		scrollPane_1.getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
						//		    @Override
						//		    protected void configureScrollBarColors() {
						////		        this.thumbColor = Color.DARK_GRAY;
						//		    	this.thumbColor = Color.black;
						//		    }
						//		});
						//===================================================================================================cannot use window builder	
								textArea = new JTextArea();
								textArea.getDocument().addUndoableEditListener(
										new UndoableEditListener() {
											public void undoableEditHappened(UndoableEditEvent e) {
												um.addEdit(e.getEdit());
											}
										});
								
//		editorPaneDocument=textArea.getDocument();
//		editorPaneDocument.addUndoableEditListener(undoHandler);
								
								textArea.addKeyListener(sc);
								textArea.setForeground(Color.WHITE);
								textArea.setBackground(new Color(0, 0, 0));
								textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
								textArea.setCaretColor(Color.pink);
								//		PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
								//		System.setOut(printStream);
								//		System.setErr(printStream);
										
								//				PrintStream printStream1 = new PrintStream(new CustomOutputStream(textArea));
												
												
												textArea.setBorder(null);
												textArea.setAlignmentY(Component.BOTTOM_ALIGNMENT);
												textArea.setAlignmentX(Component.RIGHT_ALIGNMENT);
												scrollPane_1.setViewportView(textArea);
				
				JComboBox comboBox = new JComboBox();
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String feeback = (String)comboBox.getSelectedItem();
						textArea.setText(feeback);
						window.mean(feeback);
					}
				});
				comboBox.setForeground(Color.PINK);
				comboBox.addItem("1/4");
				comboBox.addItem("2/4");
				comboBox.addItem("3/4");
				comboBox.addItem("4/4");
				comboBox.setSelectedItem(null);
//				String feeback = (String)comboBox.getSelectedItem();
//				textArea.setText(feeback);
				
				JButton btnNewButton_3 = new JButton("Edit");
				btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
				btnNewButton_3.setBackground(Color.BLACK);
				btnNewButton_3.setForeground(new Color(186, 85, 211));
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Editmeansure em = new Editmeansure();
						em.frame.setVisible(true);

					}
				});
				
				Image img = new ImageIcon(this.getClass().getResource("/Wallpaper Music Equalizer Wallpaper 1080p HD Upload at January 29.jpg")).getImage();
				JLabel lblNewLabel = new JLabel(new ImageIcon(img));
				GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
				groupLayout.setHorizontalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(119)
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(119)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(255)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
							.addGap(110))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 1038, Short.MAX_VALUE)
							.addGap(1))
				);
				groupLayout.setVerticalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(297)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
							.addGap(41))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 602, Short.MAX_VALUE)
				);
				frame.getContentPane().setLayout(groupLayout);
		
		UIManager.put("PopupMenu.border", new LineBorder(Color.darkGray));
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
		iNew.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		iNew.setForeground(Color.RED);
		iNew.setBorder(null);
		iNew.setBackground(Color.BLACK);
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		
		iOpen = new JMenuItem("Open");
		iOpen.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		iOpen.setForeground(Color.RED);
		iOpen.setBorder(null);
		iOpen.setBackground(Color.BLACK);
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		
		
		iSave = new JMenuItem("Save");
		iSave.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		iSave.setForeground(Color.RED);
		iSave.setBorder(null);
		iSave.setBackground(Color.BLACK);
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		
		iSaveAs = new JMenuItem("SaveAs");
		iSaveAs.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		iSaveAs.setForeground(Color.RED);
		iSaveAs.setBorder(null);
		iSaveAs.setBackground(Color.BLACK);
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		
		iExit = new JMenuItem("Exit");
		iExit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		iExit.setForeground(Color.RED);
		iExit.setBorder(null);
		iExit.setBackground(Color.BLACK);
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
//-------------------------------------------------------------------------		
		Document doc= textArea.getDocument();
		doc.addUndoableEditListener(new UndoableEditListener() {
		    public void undoableEditHappened(UndoableEditEvent evt) {
		        um.addEdit(evt.getEdit());
		    }
		});
//		textArea.getActionMap().put("Undo",
//			    new AbstractAction("Undo") {
//			        public void actionPerformed(ActionEvent evt) {
//			            try {
//			                if (um.canUndo()) {
//			                    um.undo();
//			                }
//			            } catch (CannotUndoException e) {
//			            }
//			        }
//			   });
//		textArea.getInputMap().put(KeyStroke.getKeyStroke("control Z"), "Undo");
//-------------------------------------------------------------------------		
		mntmNewMenuItem_Undo = new JMenuItem("Undo");
		mntmNewMenuItem_Undo.setBorder(null);
		mntmNewMenuItem_Undo.setForeground(Color.ORANGE);
		mntmNewMenuItem_Undo.setBackground(Color.BLACK);
		mntmNewMenuItem_Undo.addActionListener(this);
		mntmNewMenuItem_Undo.setActionCommand("Undo");
		mntmNewMenuItem_Undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					um.undo();
				} catch (Exception ex) {
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_Undo);
		
		mntmNewMenuItem_Redo = new JMenuItem("Redo");
		mntmNewMenuItem_Redo.setBorder(null);
		mntmNewMenuItem_Redo.setForeground(Color.ORANGE);
		mntmNewMenuItem_Redo.setBackground(Color.BLACK);
		mntmNewMenuItem_Undo.addActionListener(this);
		mntmNewMenuItem_Undo.setActionCommand("Redo");
		mntmNewMenuItem_Redo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					um.redo();
				} catch (Exception ex) {
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_Redo);
		
		JMenu mnNewMenu_Format = new JMenu("Format");
		mnNewMenu_Format.setBackground(Color.DARK_GRAY);
		mnNewMenu_Format.setForeground(new Color(153, 50, 204));
		mnNewMenu_Format.setBorder(null);
		mnNewMenu_Format.setFont(new Font("Times New Roman", Font.BOLD, 15));
		menuBar.add(mnNewMenu_Format);
//===========================================================================
		mntmNewMenuItemwarp = new JMenuItem("Word Warp: Off");
		mntmNewMenuItemwarp.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmNewMenuItemwarp.setForeground(new Color(153, 50, 204));
		mntmNewMenuItemwarp.setBackground(Color.BLACK);
		mntmNewMenuItemwarp.setBorder(null);
		mnNewMenu_Format.add(mntmNewMenuItemwarp);
//		mntmNewMenuItemwarp = new JMenuItem("Word Warp: Off");
		mntmNewMenuItemwarp.addActionListener(this);
		mntmNewMenuItemwarp.setActionCommand("Word Wrap");
//===========================================================================
		JMenu mnNewMenufont = new JMenu("Font");
		mnNewMenufont.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnNewMenufont.setBackground(Color.BLACK);
		mnNewMenufont.setForeground(new Color(153, 50, 204));
		mnNewMenufont.setBorder(null);
		mnNewMenu_Format.add(mnNewMenufont);
		
		JMenuItem mntmNewMenuItem_Arial = new JMenuItem("Arial");
		mntmNewMenuItem_Arial.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmNewMenuItem_Arial.setForeground(Color.WHITE);
		mntmNewMenuItem_Arial.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_Arial.setBorder(null);
		mnNewMenufont.add(mntmNewMenuItem_Arial);
		mntmNewMenuItem_Arial.addActionListener(this);
		mntmNewMenuItem_Arial.setActionCommand("Arial");
		
		JMenuItem mntmNewMenuItem_Comic_Sans_Ms = new JMenuItem("Comic Sans MS");
		mntmNewMenuItem_Comic_Sans_Ms.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmNewMenuItem_Comic_Sans_Ms.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_Comic_Sans_Ms.setForeground(Color.WHITE);
		mntmNewMenuItem_Comic_Sans_Ms.setBorder(null);
		mnNewMenufont.add(mntmNewMenuItem_Comic_Sans_Ms);
		mntmNewMenuItem_Comic_Sans_Ms.addActionListener(this);
		mntmNewMenuItem_Comic_Sans_Ms.setActionCommand("Comic Sans MS");
		
		JMenuItem mntmNewMenuItem_Time_New_Roman = new JMenuItem("Times New Roman");
		mntmNewMenuItem_Time_New_Roman.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmNewMenuItem_Time_New_Roman.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_Time_New_Roman.setForeground(Color.WHITE);
		mntmNewMenuItem_Time_New_Roman.setBorder(null);
		mnNewMenufont.add(mntmNewMenuItem_Time_New_Roman);
		mntmNewMenuItem_Time_New_Roman.addActionListener(this);
		mntmNewMenuItem_Time_New_Roman.setActionCommand("Times New Roman");
		
		JMenuItem mntmNewMenuItem_MONOSPACED = new JMenuItem("MONOSPACED");
		mntmNewMenuItem_MONOSPACED.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmNewMenuItem_MONOSPACED.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_MONOSPACED.setForeground(Color.WHITE);
		mntmNewMenuItem_MONOSPACED.setBorder(null);
		mnNewMenufont.add(mntmNewMenuItem_MONOSPACED);
		mntmNewMenuItem_MONOSPACED.addActionListener(this);
		mntmNewMenuItem_MONOSPACED.setActionCommand("MONOSPACED");
		
		JMenu mnNewMenufontsize = new JMenu("Font Size");
		mnNewMenufontsize.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnNewMenufontsize.setBorder(null);
		mnNewMenufontsize.setForeground(new Color(153, 50, 204));
		mnNewMenufontsize.setBackground(Color.BLACK);
		mnNewMenu_Format.add(mnNewMenufontsize);
		
		JMenuItem mntmNewMenuItem_size4 = new JMenuItem("4");
		mntmNewMenuItem_size4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmNewMenuItem_size4.setForeground(Color.WHITE);
		mntmNewMenuItem_size4.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_size4.setBorder(null);
		mnNewMenufontsize.add(mntmNewMenuItem_size4);
		mntmNewMenuItem_size4.addActionListener(this);
		mntmNewMenuItem_size4.setActionCommand("size4");
		
		JMenuItem mntmNewMenuItem_size8 = new JMenuItem("8");
		mntmNewMenuItem_size8.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmNewMenuItem_size8.setForeground(Color.WHITE);
		mntmNewMenuItem_size8.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_size8.setBorder(null);
		mnNewMenufontsize.add(mntmNewMenuItem_size8);
		mntmNewMenuItem_size8.addActionListener(this);
		mntmNewMenuItem_size8.setActionCommand("size8");
		
		JMenuItem mntmNewMenuItem_size12 = new JMenuItem("12");
		mntmNewMenuItem_size12.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmNewMenuItem_size12.setForeground(Color.WHITE);
		mntmNewMenuItem_size12.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_size12.setBorder(null);
		mnNewMenufontsize.add(mntmNewMenuItem_size12);
		mntmNewMenuItem_size12.addActionListener(this);
		mntmNewMenuItem_size12.setActionCommand("size12");
		
		JMenuItem mntmNewMenuItem_size16 = new JMenuItem("16");
		mntmNewMenuItem_size16.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmNewMenuItem_size16.setForeground(Color.WHITE);
		mntmNewMenuItem_size16.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_size16.setBorder(null);
		mnNewMenufontsize.add(mntmNewMenuItem_size16);
		mntmNewMenuItem_size16.addActionListener(this);
		mntmNewMenuItem_size16.setActionCommand("size16");
		
		JMenuItem mntmNewMenuItem_size20 = new JMenuItem("20");
		mntmNewMenuItem_size20.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmNewMenuItem_size20.setForeground(Color.WHITE);
		mntmNewMenuItem_size20.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_size20.setBorder(null);
		mnNewMenufontsize.add(mntmNewMenuItem_size20);
		mntmNewMenuItem_size20.addActionListener(this);
		mntmNewMenuItem_size20.setActionCommand("size20");
		
		JMenuItem mntmNewMenuItem_size24 = new JMenuItem("24");
		mntmNewMenuItem_size24.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmNewMenuItem_size24.setForeground(Color.WHITE);
		mntmNewMenuItem_size24.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_size24.setBorder(null);
		mnNewMenufontsize.add(mntmNewMenuItem_size24);
		mntmNewMenuItem_size24.addActionListener(this);
		mntmNewMenuItem_size24.setActionCommand("size24");
		
		JMenuItem mntmNewMenuItem_size28 = new JMenuItem("28");
		mntmNewMenuItem_size28.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmNewMenuItem_size28.setForeground(Color.WHITE);
		mntmNewMenuItem_size28.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_size28.setBorder(null);
		mnNewMenufontsize.add(mntmNewMenuItem_size28);
		mntmNewMenuItem_size28.addActionListener(this);
		mntmNewMenuItem_size28.setActionCommand("size28");
		
		JMenu mnNewMenu_2 = new JMenu("Color");
		mnNewMenu_2.setForeground(new Color(0, 191, 255));
		mnNewMenu_2.setBackground(Color.DARK_GRAY);
		mnNewMenu_2.setBorder(null);
		mnNewMenu_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem icolor = new JMenuItem("White");
		icolor.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		icolor.setForeground(new Color(0, 191, 255));
		icolor.setBackground(Color.BLACK);
		icolor.setBorder(null);
		mnNewMenu_2.add(icolor);
		icolor.addActionListener(this);
		icolor.setActionCommand("White");
		
		JMenuItem icolor2 = new JMenuItem("Black");
		icolor2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		icolor2.setForeground(new Color(0, 191, 255));
		icolor2.setBackground(Color.BLACK);
		icolor2.setBorder(null);
		mnNewMenu_2.add(icolor2);
		icolor2.addActionListener(this);
		icolor2.setActionCommand("Black");
		
		JMenuItem icolor3 = new JMenuItem("Pink");
		icolor3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		icolor3.setForeground(new Color(0, 191, 255));
		icolor3.setBackground(Color.BLACK);
		icolor3.setBorder(null);
		mnNewMenu_2.add(icolor3);
		icolor3.addActionListener(this);
		icolor3.setActionCommand("Pink");
		
		JMenuItem icolor4 = new JMenuItem("Blue");
		icolor4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		icolor4.setForeground(new Color(0, 191, 255));
		icolor4.setBackground(Color.BLACK);
		icolor4.setBorder(null);
		mnNewMenu_2.add(icolor4);
		icolor4.addActionListener(this);
		icolor4.setActionCommand("Blue");
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
//			case "Undo": ed.undo();break;
//			case "Redo": ed.redo();break;
		}
	}
	public static void mean(String ni) {
		mean = ni;
	}
}



