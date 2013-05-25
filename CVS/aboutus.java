import java.awt.*;
import javax.swing.*;

class aboutus extends JFrame 
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;

public aboutus()
	{
		  setDefaultCloseOperation(HIDE_ON_CLOSE);
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		getContentPane().setBackground(new Color(14,150,230));
		setLayout(null);
		setTitle("CoLlEgE_Voting_System");

		
	
		l1=new JLabel("CoLlEgE Voting_System");
		l1.setForeground(Color.white);
		l1.setFont(new Font("Verdana",Font.BOLD,20)); 
		l1.setBounds(270,10,450,50);
		
		l2=new JLabel("  The CoLlEgE Voting System (CVS) is a package which manages the voters,");
		l2.setForeground(Color.black);
		l2.setFont(new Font("Monospaced",Font.BOLD,15)); 
		l2.setBounds(10,60,800,30);

		l3=new JLabel("candidates and voting electronically. This system keeps the record of the list ");
		l3.setForeground(Color.black);
		l3.setFont(new Font("Monospaced",Font.BOLD,15)); 
		l3.setBounds(10,90,800,30);

		l4=new JLabel("of candidates and voters information for voting purpose. The maintenance of ");        
		l4.setForeground(Color.black);
		l4.setFont(new Font("Monospaced",Font.BOLD,15)); 
		l4.setBounds(10,120,850,30);

		l5=new JLabel("the system is considered by a mainMenu of 5 options as:  ");
		l5.setForeground(Color.black);
		l5.setFont(new Font("Monospaced",Font.BOLD,15)); 
		l5.setBounds(10,150,600,30);

		l6=new JLabel("1.  VotersMenu ----- Programs related to voters ");
		l6.setForeground(Color.black);
		l6.setFont(new Font("Monospaced",Font.BOLD,15)); 
		l6.setBounds(10,180,500,30);

		l7=new JLabel("2. CandidatesMenu ----- Programs related to candidates ");
		l7.setForeground(Color.black);
		l7.setFont(new Font("Monospaced",Font.BOLD,15)); 
		l7.setBounds(10,210,500,30);

		l8=new JLabel("3. Start Voting ----- About voting ");
		l8.setForeground(Color.black);
		l8.setFont(new Font("Monospaced",Font.BOLD,15)); 
		l8.setBounds(10,240,600,30);

		l9=new JLabel("4. Setting ----- Settings related to program");
		l9.setForeground(Color.black);
		l9.setFont(new Font("Monospaced",Font.BOLD,15)); 
		l9.setBounds(10,270,500,30);

		l10=new JLabel("5. Exit ---- Quit from the System ");
		l10.setForeground(Color.black);
		l10.setFont(new Font("Monospaced",Font.BOLD,15)); 
		l10.setBounds(10,300,650,30);

		l11=new JLabel("CVS uses different files to manage the complete system. ");
		l11.setForeground(Color.black);
		l11.setFont(new Font("Monospaced",Font.BOLD,15)); 
		l11.setBounds(10,340,600,30);

		l12=new JLabel("All the files are included in this program");
		l12.setForeground(Color.black);
		l12.setFont(new Font("Monospaced",Font.BOLD,15)); 
		l12.setBounds(10,370,500,30);

		l13=new JLabel("and calls automatically  when it required.");
		l13.setForeground(Color.black);
		l13.setFont(new Font("Monospaced",Font.BOLD,15)); 
		l13.setBounds(10,400,600,30);


		l14=new JLabel(new ImageIcon("doeacclogo.jpg"));
        l14.setBounds(550,150,250,270);

		l15=new JLabel("CrEaTed By :-");
		l15.setForeground(Color.blue);
		l15.setFont(new Font("Verdana",Font.BOLD,18));
		l15.setBounds(580,430,200,30);

		l16=new JLabel("Mukesh & Rajat");
		l16.setForeground(Color.green);
		l16.setFont(new Font("Serif",Font.BOLD,18)); 
		l16.setBounds(590,460,200,30);




		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		add(l11);
		add(l12);
		add(l13);
		add(l14);
		add(l15);
		add(l16);
		
		setSize(850,520);
		setVisible(true);
		setResizable(false);

	}


	public static void main(String[] args) 
	{
		aboutus au=new aboutus();
	
		au.setVisible(true);
	}
}
