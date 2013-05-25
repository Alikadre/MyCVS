import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

class voting extends JFrame implements ActionListener 
{
	
	JLabel l1,l2,l3,v_id;
	JTextField v_idtf;
	JButton vote,reset,back,exit;
	Cursor cur;
    JOptionPane jp = new JOptionPane();
	
	public voting()
	{
		 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		getContentPane().setBackground(new Color(14,120,120));
		setLayout(null);
		setTitle("Voting");
		setSize(700,600);
		setVisible(true);
		setResizable(false);



	 l1=new JLabel("CoLlEgE");  l1.setForeground(Color.red);
      l1.setFont(new Font("Monospaced",Font.ITALIC+Font.BOLD,40));   l1.setBounds(10,10,300,50);

      l2=new JLabel("VoTiNg");      l2.setForeground(Color.green);
      l2.setFont(new Font("Monospaced",Font.ITALIC+Font.BOLD,42));   l2.setBounds(320,15,200,50);

      l3=new JLabel("SyStEm");     l3.setForeground(Color.blue);
      l3.setFont(new Font("Monospaced",Font.ITALIC+Font.BOLD,45));   l3.setBounds(520,20,200,50);

				
		v_id=new JLabel("Voter's id no :");    
		v_id.setForeground(Color.white);
		v_id.setBounds(40,150,150,20);   

		v_idtf=new JTextField(10);      
		v_idtf.setForeground(Color.black);        
		v_idtf.setBackground(Color.white);
		v_idtf.setBounds(150,150,150,26);

		vote=new JButton("Vote", new ImageIcon("vote.gif"));
		vote.setForeground(Color.white); 
		vote.setBackground(Color.pink);
        vote.setToolTipText("Start Voting");	
        vote.setBounds(100,425,110,30);

		reset=new JButton("Reset", new ImageIcon("remove.gif"));
		reset.setForeground(Color.white);
		reset.setBackground(Color.pink);
       	reset.setToolTipText("Reset the record");
        reset.setBounds(320,425,100,30);
		 
		exit=new JButton("Exit", new ImageIcon("EXIT.PNG")); 
		exit.setForeground(Color.white);
		exit.setBackground(Color.pink);
        exit.setToolTipText("Exit from the window");
		exit.setBounds(420,425,100,30);

		back=new JButton("Back", new ImageIcon("Home.gif"));
		back.setForeground(Color.white);
		back.setBackground(Color.pink);
		back.setToolTipText("Cancel the record");	
		back.setBounds(210,425,110,30);
			
				add(l1);
				add(l2);
				add(l3);
				
				
				add(v_id);
				add(v_idtf);

				 add(vote);
				 add(reset);
				 add(exit);
				 add(back);

			vote.addActionListener(this);
        	reset.addActionListener(this);
			back.addActionListener(this);
			exit.addActionListener(this);



	}

	 public void actionPerformed(ActionEvent ae)
   {

     Object ob=ae.getSource();
	
	 if (ob==exit)
     {
		 System.exit(0);
	 }

	  if (ob==back)
     {
		  dispose();
		 new startvoting();
	 }

	  if (ob==reset)
     {
		 v_idtf.setText(" ");
	 }

	 if (ob==vote)
     {
			try
		    {
			int f=0;
			String votedone=new String();
				
	           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection cn=DriverManager.getConnection("jdbc:odbc:college","","");
		       Statement st = cn.createStatement();
		       ResultSet rs = st.executeQuery("Select vote from voters where rollno= '"+ v_idtf.getText()+"'");
	
		       while(rs.next())
		       {		
						votedone=rs.getString(1);
						f=1;
		       }
				
				 if(f==0)
				{
				   jp.showMessageDialog(this,"Voter doesn't Exist ","Error",jp.ERROR_MESSAGE);

				}
			  
				if(votedone.equals("yes"))
				{
					jp.showMessageDialog(this,"Already Voted ","Error",jp.ERROR_MESSAGE);
				
				}

				if(votedone.equals("no"))
				{
					
					votedone=new String("yes");
					 PreparedStatement ps=cn.prepareStatement("Update voters set vote=? where rollno = '"+ v_idtf.getText()+"' ");
					ps.setString(1,votedone);
					ps.executeUpdate();
						
					dispose();
					new resultlist();
				}

				
		}//try

		catch(ClassNotFoundException cnf)
		  {
		    	jp.showMessageDialog(this,cnf,"EXCEPTION",jp.ERROR_MESSAGE);
		    	//System.out.println("Cnf Exception"+cnf);
		  }
		  catch(SQLException sql)
		  {
		    	jp.showMessageDialog(this,sql,"EXCEPTION",jp.ERROR_MESSAGE);
				//System.out.println("Sql Exception"+sql);
		  }
   }
   }

	public static void main(String[] args) 
	{
		new voting();
	}
}
