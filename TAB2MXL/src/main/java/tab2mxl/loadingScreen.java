package tab2mxl;
import java.awt.*;

import javax.swing.*;
// updated
public class loadingScreen {
	// push
    JFrame frame;
    JLabel background=new JLabel(new ImageIcon("MusicXML_logo.gif"));
    JProgressBar progressBar=new JProgressBar();
    JLabel message=new JLabel();
    loadingScreen()
    {
        createScreen();
        addProgressBar();
        showLoading();
        runningPBar();
    }
    public void createScreen(){
        frame=new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(background);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);
 
    }
    public void showLoading()
    {
        message.setBounds(100,350,300,40);
        message.setForeground(Color.WHITE);
        message.setFont(new Font("arial",Font.BOLD,15));
        frame.add(message);
    }
    public void addProgressBar(){
        progressBar.setBounds(50,300,300,30);
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
                	message.setText("Instruments loading... ");
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