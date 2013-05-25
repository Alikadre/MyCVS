import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;

public class candidatemenu extends JFrame implements ActionListener
{
   JMenuBar jm;
   JMenu m1,m2,m3,m4,m5;
   JMenuItem mt1,mt2,mt3,mt4,mt5,mt6;
   JLabel cvs;
   Container c=getContentPane();
 public  candidatemenu()
  {
  setDefaultCloseOperation(HIDE_ON_CLOSE);
  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
  setLayout(null);
  setTitle("Candidate_Menu");
  cvs=new JLabel(new ImageIcon("candidatesmenu.jpg"));
  cvs.setBounds(0,0,620,388);
  setSize(620,388);
  setVisible(true);
  setResizable(false);

   jm=new JMenuBar();
   m1=new JMenu("File");				  m1.setMnemonic('F');
   m2=new JMenu("Help");              m2.setMnemonic('H');
   m3=new JMenu("Exit");               m3.setMnemonic('x');

   
   mt1=new JMenuItem("NewCandidate",new ImageIcon("NEW.PNG"));       mt1.setMnemonic('N');
   mt2=new JMenuItem("DisplayInfo",new ImageIcon("Info.PNG"));			 mt2.setMnemonic('I');
   mt3=new JMenuItem("Help",new ImageIcon("help.gif"));						mt3.setMnemonic('H');
   mt4=new JMenuItem("ToMain",new ImageIcon("home.gif"));					mt4.setMnemonic('M');
   mt5=new JMenuItem("Quit",new ImageIcon("exits.PNG"));					mt5.setMnemonic('Q');
   mt6=new JMenuItem("Return",new ImageIcon("author.PNG"));				mt6.setMnemonic('R');

   m1.add(mt1);  m1.add(mt2);  
   m2.add(mt3);  
   m3.add(mt4);   m3.add(mt5);  m3.add(mt6);

   jm.add(m1);  jm.add(m2);   jm.add(m3);  
   add(cvs);
   setJMenuBar(jm);


	mt1.addActionListener(this);
	mt2.addActionListener(this);
	mt3.addActionListener(this);
	mt4.addActionListener(this);
	mt5.addActionListener(this);
	mt6.addActionListener(this);

	
  }
  public void actionPerformed(ActionEvent ae)
 {
	  Object ob=ae.getSource();
	  String str=(String)ae.getActionCommand();
	    
	  if(ob==mt1)
	 {
		   dispose();
         nwcandidatemenu ncm=new nwcandidatemenu();
	 }
	  if(ob==mt2)
	 {
		   dispose();
          dispcandidate dc=new dispcandidate();
	 }

	
	if(ob==mt3)
	 {
		
       //candidatehelp ch=new candidatehelp();
	 }

	  if(ob==mt4)
	 {
		   dispose();
            mainmenu m=new mainmenu();
	 }
	 
	  if(ob==mt5)
	 {
		  System.exit(0);
	 }
	
	if(str.equals("Return"))
	 {
			dispose();
			new login();
	 }


 }
  public static void main(String args[])
  {
    candidatemenu cm=new candidatemenu();
    cm.setResizable(false);
    
    }
}
