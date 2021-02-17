package tab2mxl;
import java.awt.*;

import javax.swing.*;
 
public class loadingScreen {
	// push
    JFrame frame;
    JLabel background=new JLabel(new ImageIcon("music.png"));
    JLabel title=new JLabel("MUSIC XML CONVERTER");
    JProgressBar progressBar=new JProgressBar();
    JLabel message=new JLabel();
    loadingScreen()
    {
        createScreen();
        showTitle();
        addProgressBar();
        showLoading();
        runningPBar();
    }
    public void createScreen(){
        frame=new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(background);
        frame.setVisible(true);
 
    }
    public void showTitle()
    {
        title.setFont(new Font("arial",Font.BOLD,30));
        title.setBounds(115,220,600,40);
        title.setForeground(Color.BLACK);
        frame.add(title);
    }
    public void showLoading()
    {
        message.setBounds(200,320,400,40);
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
                if (i<25)
                	message.setText("The Application is loading... ");
                else if (i>25 && i <50)
                	message.setText("Music files loading... ");
                else if (i>50 && i <75)
                	message.setText("Basss, Guitars, Drums loading up... ");
                else if (i>75 && i <100)
                	message.setText("Opening application soon... ");
                i++;
                if(i==100)
                    frame.dispose();
                	
            }catch(Exception e){
                e.printStackTrace();
            }
 
 
 
        }
    }
}