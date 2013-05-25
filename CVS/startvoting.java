import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class startvoting extends JFrame implements ActionListener
{
	
	JMenuBar jm;
    JMenu m1,m2,m3;
    JMenuItem mt1,mt2,mt3,mt4,mt5,mt6,mt7;
    JLabel cvs;
    Container c=getContentPane();
 
 public startvoting()
  {
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
  setLayout(null);
  setTitle("Voting_Menu");
  cvs=new JLabel(new ImageIcon("cvs.PNG"));
  cvs.setBounds(0,0,684,513);
  setSize(684,513);
    setVisible(true);
  setResizable(false);


   jm=new JMenuBar();
   
   m1=new JMenu("Vote");						m1.setMnemonic('V');
   m2=new JMenu("Print");							m2.setMnemonic('P');
  
   m3=new JMenu("Exit");								m3.setMnemonic('x');

   
   mt1=new JMenuItem("VoteHere",new ImageIcon("voting.gif"));			mt1.setMnemonic('V');
   mt2=new JMenuItem("Winner",new ImageIcon("winner.PNG"));		      mt1.setMnemonic('W');
   
   
   mt3=new JMenuItem("Results",new ImageIcon("Info.PNG"));				mt3.setMnemonic('R');
   mt4=new JMenuItem("Records",new ImageIcon("Info.PNG"));				mt4.setMnemonic('c');

   
   mt5=new JMenuItem("ToMain",new ImageIcon("home.gif"));				  mt5.setMnemonic('M');
   mt6=new JMenuItem("Quit",new ImageIcon("exits.PNG"));				  mt6.setMnemonic('Q');
   mt7=new JMenuItem("Return",new ImageIcon("author.PNG"));			  mt7.setMnemonic('R');

   m1.add(mt1);  m1.add(mt2);   
   
   m2.add(mt3);  m2.add(mt4);   
  
	m3.add(mt5);  m3.add(mt6);    m3.add(mt7); 
	
   jm.add(m1);  jm.add(m2);   jm.add(m3);   
   add(cvs);
   setJMenuBar(jm);


	mt1.addActionListener(this);
	mt2.addActionListener(this);
	mt3.addActionListener(this);
	mt4.addActionListener(this);
	mt5.addActionListener(this);
	mt6.addActionListener(this);
	mt7.addActionListener(this);
	
	
	
	}

	public void actionPerformed(ActionEvent ae)
 {
	  Object ob=ae.getSource();
	  String str=(String)ae.getActionCommand();
	  
	  
	  
	if(ob==mt1)
	 {
		   dispose();
		   new voting();
	 }

	 if(ob==mt2)
	 {
		 dispose();
		//   new winner();
	 }

	 if(ob==mt3)
	 {
		//   new resultlist();
	 }

	 if(ob==mt4)
	 {
		   new recordlist();
	 }
		
	
	 
	
	
	 if(ob==mt5) 
	 {
		   dispose();
           mainmenu m=new mainmenu();
	 }
	 

	if(ob==mt6)
	 {
		  System.exit(0);
	 }

	
	if(str.equals("Return"))
	 {
			dispose();
			new login();
	 }

 }



	public static void main(String[] args) 
	{
		
		startvoting sv=new startvoting();
	}
}
