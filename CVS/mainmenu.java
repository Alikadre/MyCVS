import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 class mainmenu extends JFrame implements ActionListener
{
  JLabel l1;
  JButton b1,b2,b3,b4,b5;
  Container c=getContentPane();
  public mainmenu()
  {
    setSize(350,400);
	Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
    setVisible(true);
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    c.setBackground(new Color(143,188,122));

    l1=new JLabel("Main Menu");
    l1.setFont(new Font("Serif",2,30));
    l1.setBounds(120,10,200,50);
    l1.setForeground(Color.red);

    b1=new JButton("Voters",new ImageIcon("voters.PNG"));
    b1.setBackground(Color.pink);
    b1.setBounds(100,80,180,40);

    b2=new JButton("Candidate",new ImageIcon("candidate.PNG"));
    b2.setBackground(Color.orange);
    b2.setBounds(100,130,180,40);

    b3=new JButton("Start Voting",new ImageIcon("voting.gif"));
	b3.setBackground(Color.green);
    b3.setBounds(100,180,180,40);

	b4=new JButton("Settings",new ImageIcon("settings.gif"));
    b4.setBackground(Color.yellow);
    b4.setBounds(100,230,180,40);

    b5=new JButton("Exit",new ImageIcon("exits.PNG"));
    b5.setBackground(Color.magenta);
    b5.setBounds(100,280,180,40);

   add(l1);
   add(b1);
   add(b2);
   add(b3);
   add(b4);
   add(b5);

   b1.addActionListener(this);
   b2.addActionListener(this);
   b3.addActionListener(this);
   b4.addActionListener(this);
   b5.addActionListener(this);
  }
   public void actionPerformed(ActionEvent ae)
   {
     Object ob=ae.getSource();

    if(ob==b1)
    {
		dispose();
        votermenu vm=new votermenu();
     }
	 
	  
	  if(ob==b2)
    {
		dispose();
       new candidatemenu();
     }
		
		 if(ob==b3)
    {
		dispose();
        new startvoting();
     }

	if(ob==b4)
    {
		dispose();
		//new setting();
     }

    if(ob==b5)
    System.exit(0);

   } 

   public static void main(String arg[])
   {
     mainmenu m=new mainmenu();
      m.setTitle("Main Menu");
    }
 }
