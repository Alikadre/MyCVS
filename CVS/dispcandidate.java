import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
public class dispcandidate extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,c_id,c_name,c_phno,c_get,c_post;
	JTextField c_idtf,c_nametf,c_phnotf,c_gettf;
	JButton search,save,reset,back,exit;
	Choice sex,post;
	Cursor cur;
    JOptionPane jp = new JOptionPane();
	public dispcandidate()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		getContentPane().setBackground(new Color(240,136,190));
		setLayout(null); 

		setSize(700,550);
		setVisible(true);
		setResizable(false);
		setTitle("Disp_Candidate");

		cur=new Cursor(Cursor.CROSSHAIR_CURSOR);
		setCursor(cur);


	 l1=new JLabel("CoLlEgE");  l1.setForeground(Color.red);
      l1.setFont(new Font("Monospaced",Font.ITALIC+Font.BOLD,40));   l1.setBounds(10,10,300,50);

      l2=new JLabel("VoTiNg");      l2.setForeground(Color.green);
      l2.setFont(new Font("Monospaced",Font.ITALIC+Font.BOLD,42));   l2.setBounds(320,15,200,50);

      l3=new JLabel("SyStEm");     l3.setForeground(Color.blue);
      l3.setFont(new Font("Monospaced",Font.ITALIC+Font.BOLD,45));   l3.setBounds(520,20,200,50);

				
		c_id=new JLabel("Candidate's id no :");    
		c_id.setForeground(Color.white);
		c_id.setBounds(40,150,150,20);   
		
		
		c_name=new JLabel("Candidate's Name :"); 
		c_name.setForeground(Color.white);
		c_name.setBounds(40,200,150,20);
		
	

		
		c_phno=new JLabel("Contact Number :");
		c_phno.setForeground(Color.white);
	    c_phno.setBounds(40,300,150,20);
	    
		
		c_get=new JLabel("Vote get :"); 
	    c_get.setForeground(Color.white);
	    c_get.setBounds(40,350,70,20);  
	   
		c_post=new JLabel("post :"); 
	    c_post.setForeground(Color.white);
	   c_post.setBounds(200,350,50,20);  


		
			
		c_idtf=new JTextField(10);      
		c_idtf.setForeground(Color.black);        
		c_idtf.setBackground(Color.white);
		c_idtf.setBounds(150,150,150,26);
		
		c_nametf=new JTextField();
		c_nametf.setForeground(Color.black); 
		c_nametf.setBackground(Color.white);
		c_nametf.setBounds(150,200,150,26);
		
		
		c_phnotf=new JTextField(10);
		c_phnotf.setForeground(Color.black); 
		c_phnotf.setBackground(Color.white);
		c_phnotf.setBounds(150,300,150,26);

		
		c_gettf =new JTextField(2);
		c_gettf.setForeground(Color.black); 
		c_gettf.setBackground(Color.white);
		c_gettf.setBounds(130,350,50,20);
		
	  
		
       post=new Choice();
		post.add("President");
		post.add("Vice-President");
		post.add("Secretary");
		post.add("Joint-Secretary");
		post.add("Treasurer");
       post.setBounds(250,350,70,10);


		search=new JButton("Search",new ImageIcon("search.PNG"));
		search.setForeground(Color.white); 
		search.setBackground(Color.pink);
        search.setToolTipText("Search the record");	
        search.setBounds(100,425,110,30);

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
				
				
				add(c_id);
				add(c_idtf);

				 add(search);
				 add(reset);
				 add(exit);
				 add(back);

			search.addActionListener(this);
        	reset.addActionListener(this);
			back.addActionListener(this);
			exit.addActionListener(this);

		
	}
	 public void actionPerformed(ActionEvent ae)
   {

     Object ob=ae.getSource();
	
	
	 if (ob==search)
     {
	    
		try
		    {
				int f=0;
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection cn=DriverManager.getConnection("jdbc:odbc:college","","");
		       Statement st = cn.createStatement();
		       ResultSet rs = st.executeQuery("select * from candidates where c_id = '" + c_idtf.getText()+ "' ");
			   while(rs.next())
		       {		
						c_idtf.setText(rs.getString(1));	
			    		c_nametf.setText(rs.getString(2));
						c_phnotf.setText(rs.getString(3).substring(0,10));
						post.select(rs.getString(4));
						c_gettf.setText(rs.getString(5));
						f=1;
		      }
			if(f==0)
				{	
				c_nametf.setText("");
				c_phnotf.setText("");
				c_gettf.setText("0");
				post.select("none");
				jp.showMessageDialog(this,"Record Not Found","EXCEPTION",jp.ERROR_MESSAGE);
				}
		        if(f==1)
				{		
					cn.close();
		        	st.close();
				
					    add(c_name);
						add(c_nametf);

                		add(c_phno);
			    		add(c_phnotf);
			   
			      	     add(c_get);
						add(c_gettf);
				 
				 
				 
				 add(c_post);
				 add(post);
				}
		
		  }
		  catch(ClassNotFoundException cnf)
		  {
		    	jp.showMessageDialog(this,cnf,"EXCEPTION",jp.ERROR_MESSAGE);
		    	System.out.println("Cnf Exception");
		  }
		  catch(SQLException sql)
		  {
		    	jp.showMessageDialog(this,sql,"EXCEPTION",jp.ERROR_MESSAGE);
		  }

						

	 }
	 if(ob==reset)
	   {
  		
		 c_idtf.setText("");	
			c_nametf.setText("");
			c_phnotf.setText("");
			c_gettf.setText("0");
			post.select("none");

	  }
	  if (ob==exit)
     {
	    System.exit(0);
	 }
	 if (ob==back)
     {
		dispose();
	    candidatemenu cm=new candidatemenu();
	 }

   }
	public static void main(String args[])
 	{
 		dispcandidate dc= new dispcandidate();
		dc.setResizable(false);
		dc.setTitle("Disp_Candidate");
		

	 }

}

