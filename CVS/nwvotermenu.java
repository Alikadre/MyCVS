import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
public class nwvotermenu extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,v_id,v_name,v_phno,v_done;
	JTextField v_idtf,v_nametf,v_phnotf;
	JButton search,save,reset,back,exit;
	Choice done;
	Cursor cur;
    JOptionPane jp = new JOptionPane();
	public nwvotermenu()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		getContentPane().setBackground(new Color(124,111,200));
		setLayout(null); 

		setSize(700,550);
		setVisible(true);
		setResizable(false);
		setTitle("New_Voter_Menu");

		cur=new Cursor(Cursor.CROSSHAIR_CURSOR);
		setCursor(cur);


	 l1=new JLabel("CoLlEgE");  l1.setForeground(Color.red);
      l1.setFont(new Font("Monospaced",Font.ITALIC+Font.BOLD,40));   l1.setBounds(10,10,300,50);

      l2=new JLabel("VoTiNg");      l2.setForeground(Color.green);
      l2.setFont(new Font("Monospaced",Font.ITALIC+Font.BOLD,42));   l2.setBounds(320,15,200,50);

      l3=new JLabel("SyStEm");     l3.setForeground(Color.blue);
      l3.setFont(new Font("Monospaced",Font.ITALIC+Font.BOLD,45));   l3.setBounds(520,20,200,50);

				
		v_id=new JLabel("Voter's id no :");    
		v_id.setForeground(Color.white);
		v_id.setBounds(40,150,150,20);   
		
		
		v_name=new JLabel("Voter's Name :"); 
		v_name.setForeground(Color.white);
		v_name.setBounds(40,200,150,20);
		
			
		v_phno=new JLabel("Contact Number :");
		v_phno.setForeground(Color.white);
	    v_phno.setBounds(40,300,150,20);
	    
		
		v_done=new JLabel("Vote done :"); 
	    v_done.setForeground(Color.white);
	    v_done.setBounds(40,350,150,20);  
	   
		
			
		v_idtf=new JTextField(10);      
		v_idtf.setForeground(Color.black);        
		v_idtf.setBackground(Color.white);
		v_idtf.setBounds(150,150,150,26);
		
		v_nametf=new JTextField();
		v_nametf.setForeground(Color.black); 
		v_nametf.setBackground(Color.white);
		v_nametf.setBounds(150,200,150,26);
		
		v_phnotf=new JTextField(10);
		v_phnotf.setForeground(Color.black); 
		v_phnotf.setBackground(Color.white);
		v_phnotf.setBounds(150,300,150,26);

	    done=new Choice();
		done.add(" ");
		done.add("yes");
		done.add("no");
		done.setBounds(150,350,50,10);
		


		search=new JButton("Search",new ImageIcon("search.PNG"));
		search.setForeground(Color.white); 
		search.setBackground(Color.pink);
        search.setToolTipText("Search the record");	
        search.setBounds(100,425,110,30);
		
		save=new JButton("Save", new ImageIcon("Save.gif"));
		save.setForeground(Color.white);
		save.setBackground(Color.pink);
		save.setToolTipText("Save the record");
        save.setBounds(210,425,90,30);

		reset=new JButton("Reset", new ImageIcon("remove.gif"));
		reset.setForeground(Color.white);
		reset.setBackground(Color.pink);
       	reset.setToolTipText("Reset the record");
        reset.setBounds(300,425,100,30);
		 
		exit=new JButton("Exit", new ImageIcon("EXIT.PNG")); 
		exit.setForeground(Color.white);
		exit.setBackground(Color.pink);
        exit.setToolTipText("Exit from the window");
		exit.setBounds(400,425,100,30);

		back=new JButton("Back", new ImageIcon("Home.gif"));
		back.setForeground(Color.white);
		back.setBackground(Color.pink);
		back.setToolTipText("Cancel the record");	
		back.setBounds(500,425,110,30);
			
				add(l1);
				add(l2);
				add(l3);
				
				
				add(v_id);
				add(v_idtf);

				add(v_name);
				add(v_nametf);

                add(v_phno);
			    add(v_phnotf);
			   
			      add(v_done);
				  add(done);
				
				 add(search);
				 add(save);
				 add(reset);
				 add(exit);
				 add(back);

            save.addActionListener(this);
			search.addActionListener(this);
        	reset.addActionListener(this);
			back.addActionListener(this);
			exit.addActionListener(this);

		
	}
	 public void actionPerformed(ActionEvent ae)
   {

     Object ob=ae.getSource();
		if(ob==save)
	   {
  		 
					try
					{

				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          Connection cn=DriverManager.getConnection("jdbc:odbc:college","","");
           PreparedStatement ps=cn.prepareStatement("Insert into voters values(?,?,?,?)");
			
					ps.setString(1,v_idtf.getText());
					ps.setString(2,v_nametf.getText().trim());
					ps.setString(3,v_phnotf.getText().trim());
					ps.setString(4,done.getSelectedItem());
				    ps.executeUpdate();
		jp.showMessageDialog(this,"Record Inserted Successfully","SUCCESS",jp.INFORMATION_MESSAGE);

				cn.close();
			 }
			catch(ClassNotFoundException cnf)
			{
				System.out.println("Cnf Exception");
			}
			catch(SQLException sql)
			{
				jp.showMessageDialog(this,"Record Already Exists","EXCEPTION",jp.ERROR_MESSAGE);
			}
	   
		}
	   
   
	 
	 if(ob==search)
     {
	    
		try
		    {
			int f=0;
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection cn=DriverManager.getConnection("jdbc:odbc:college","","");
		       Statement st = cn.createStatement();
		       ResultSet rs = st.executeQuery("Select * from voters where rollno= '"+ v_idtf.getText()+"' ");

		       while(rs.next())
		       {		
						v_idtf.setText(rs.getString(1));	
			    		v_nametf.setText(rs.getString(2));
						
						v_phnotf.setText(rs.getString(3).substring(0,10));
						done.select(rs.getString(4));
						f=1;
		      }
			  if(f==1)
				{
		        	v_nametf.setEditable(false);
					
					v_phnotf.setEditable(false);
					
				}
				
				if(f==0)
				{	
				v_nametf.setText("");
			v_phnotf.setText("");
			done.select(" ");
			
				jp.showMessageDialog(this,"Record Not Found","EXCEPTION",jp.ERROR_MESSAGE);
				}
					
					cn.close();
		        	st.close();
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
  		 
			v_idtf.setText("");	
			v_nametf.setText("");
			v_phnotf.setText("");
			done.select(" ");
			

	  }
	  if (ob==exit)
     {
	    System.exit(0);
	 }
	 if (ob==back)
     {
		dispose();
	    votermenu vm=new votermenu();
	 }

   }
	public static void main(String args[])
 	{
 		nwvotermenu nvm= new nwvotermenu();
		nvm.setResizable(false);
		nvm.setTitle("New_Voter_Menu");
		

	 }

}

