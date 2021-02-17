package tab2mxl;
import java.awt.*;

import javax.swing.*;
 
public class loadingScreen {
	// push
    JFrame frame;
    JLabel image=new JLabel(new ImageIcon("music.png"));
    JLabel text=new JLabel("MUSIC XML CONVERTER");
    JProgressBar progressBar=new JProgressBar();
    JLabel message=new JLabel();
    loadingScreen()
    {
        createScreen();
        addText();
        addProgressBar();
        addMessage();
        runningPBar();
    }
    public void createScreen(){
        frame=new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(image);
        frame.setVisible(true);
 
    }
    public void addText()
    {
        text.setFont(new Font("arial",Font.BOLD,30));
        text.setBounds(115,220,600,40);
        text.setForeground(Color.BLACK);
        frame.add(text);
    }
    public void addMessage()
    {
        message.setBounds(200,320,200,40);
        message.setForeground(Color.black);
        message.setFont(new Font("arial",Font.BOLD,15));
        frame.add(message);
    }
    public void addProgressBar(){
        progressBar.setBounds(100,280,400,30);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(Color.BLACK);
        progressBar.setValue(0);
        frame.add(progressBar);
    }
    public void runningPBar(){
        int i=0;
 
        while( i<=100)
        {
            try{
                Thread.sleep(50);
                progressBar.setValue(i);
                message.setText("The Application is loading... "+Integer.toString(i)+"%");
                i++;
                if(i==100)
                    frame.dispose();
                	
            }catch(Exception e){
                e.printStackTrace();
            }
 
 
 
        }
    }
}