package tab2mxl;
import java.awt.*;

import javax.swing.*;
 
public class loadingScreen {
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
        message.setBounds(200,320,200,40);//Setting the size and location of the label
        message.setForeground(Color.black);//Setting foreground Color
        message.setFont(new Font("arial",Font.BOLD,15));//Setting font properties
        frame.add(message);//adding label to the frame
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
        int i=0;//Creating an integer variable and intializing it to 0
 
        while( i<=100)
        {
            try{
                Thread.sleep(50);//Pausing execution for 50 milliseconds
                progressBar.setValue(i);//Setting value of Progress Bar
                message.setText("The Application is loading... "+Integer.toString(i)+"%");//Setting text of the message JLabel
                i++;
                if(i==100)
                    frame.dispose();
                	
            }catch(Exception e){
                e.printStackTrace();
            }
 
 
 
        }
    }
}