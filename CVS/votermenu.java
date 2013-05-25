import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;

public class votermenu extends JFrame implements ActionListener
{
   JMenuBar jm;
   JMenu m1,m2,m3;
   JMenuItem mt1,mt2,mt3,mt4,mt5,mt6,mt7;
   JLabel cvs;
   Container c=getContentPane();
 public  votermenu()
  {
  setDefaultCloseOperation(HIDE_ON_CLOSE);
  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
  setLayout(null);
  setTitle("Voter_Menu");
 cvs=new JLabel(new ImageIcon("votersmenu.jpg"));
  cvs.setBounds(0,0,722,539);
  setSize(722,539);
    setVisible(true);
  setResizable(false);


   jm=new JMenuBar();
   m1=new JMenu("File");               m1.setMnemonic('F');
   m2=new JMenu("Help");               m2.setMnemonic('H');
   m3=new JMenu("Exit");               m3.setMnemonic('x');

   mt1=new JMenuItem("NewVoter",new ImageIcon("NEW.PNG"));			mt1.setMnemonic('N');
   mt2=new JMenuItem("DisplayInfo",new ImageIcon("Info.PNG"));		mt2.setMnemonic('I');
   mt4=new JMenuItem("Help",new ImageIcon("help.gif"));  mt4.setMnemonic('H');
   mt5=new JMenuItem("ToMain",new ImageIcon("home.gif"));			mt5.setMnemonic('M');
   mt6=new JMenuItem("Quit",new ImageIcon("exits.PNG"));				mt6.setMnemonic('Q');
   mt7=new JMenuItem("Return",new ImageIcon("author.PNG"));			mt7.setMnemonic('R');

   m1.add(mt1);  m1.add(mt2);  
   m2.add(mt4);
   m3.add(mt5);  m3.add(mt6);   m3.add(mt7);
  

   jm.add(m1);  jm.add(m2);   jm.add(m3);   
   add(cvs);
   setJMenuBar(jm);


	mt1.addActionListener(this);
	mt2.addActionListener(this);
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
           nwvotermenu nvm=new nwvotermenu();
	 }
	  if(ob==mt2)
	 {
		   dispose();
          dispvoter dv=new dispvoter();
	 }



	if(ob==mt4)
	 {  
		//voterhelp vh=new voterhelp();
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

  public static void main(String args[])
  {
    votermenu vm=new votermenu();
    vm.setResizable(false);
    }
}
