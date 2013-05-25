import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class cvs extends JFrame implements ActionListener
{
     JLabel l1,l2,l3,l4,l5;
     JButton log,can,abt;
     Container c;
     JOptionPane jp=new JOptionPane();

     public cvs()
     {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      c=getContentPane();
	  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
      setLayout(null);
      c.setBackground(new Color(128,190,150));
      jp=new JOptionPane();

          setSize(600,600);
          setVisible(true);
		  setTitle("CoLlEgE VoTiNg SyStEm");


      l1=new JLabel("CoLlEgE");
      l1.setFont(new Font("Monospaced",Font.ITALIC+Font.BOLD,60));
	  l1.setBounds(10,10,400,150);

      l2=new JLabel("VoTiNg");
      l2.setFont(new Font("Monospaced",Font.ITALIC+Font.BOLD,60));
	  l2.setBounds(200,150,400,150);

      l3=new JLabel("SyStEm");
      l3.setFont(new Font("Monospaced",Font.ITALIC+Font.BOLD,60));
	  l3.setBounds(350,250,400,150);

      l4=new JLabel("CrEaTed By :-");
	  l4.setForeground(Color.blue);
      l4.setFont(new Font("SansSerif",Font.BOLD,20));
	  l4.setBounds(400,400,200,75);

      l5=new JLabel("Mukesh & Rajat");
	  l5.setForeground(Color.green);
      l5.setFont(new Font("Serif",Font.BOLD,20)); 
	  l5.setBounds(400,430,200,75);


	  abt=new JButton("About Us",new ImageIcon("info.PNG"));
	  abt.setForeground(Color.white);
	  abt.setBackground(Color.pink);
      abt.setToolTipText("Infomation about EVS");
	  abt.setBounds(20,430,130,30);


      log=new JButton("Login",new ImageIcon("author.PNG"));  
	  log.setForeground(Color.white);
	  log.setBackground(Color.pink);
	  log.setToolTipText("Login Here");
	  log.setBounds(150,430,120,30);
    
	  can=new JButton("Cancel",new ImageIcon("EXIT.PNG"));
	  can.setForeground(Color.white);
	  can.setBackground(Color.pink);
      can.setToolTipText("Exit from the window");
	  can.setBounds(270,430,110,30);


      
      add(l1);
      add(l2);
      add(l3);
      add(l4);
      add(l5);
	  add(abt);
      add(log);
      add(can);
      log.addActionListener(this);
      can.addActionListener(this);  
	  abt.addActionListener(this); 
      
   }
   public void actionPerformed(ActionEvent ae)
   {
     Object ob=ae.getSource();
      if(ob==abt)
      {
        
      new aboutus();

      }//if

	  if(ob==log)
      {
        dispose();
       new loading();

      }//if

      if(ob==can)
      {
        System.exit(0);
       }
  }
    public static void main(String args[])
    {
          cvs c=new cvs();
          c.setTitle("CoLlEgE VoTiNg SyStEm");
          c.setResizable(false);
        }
}
                                   
