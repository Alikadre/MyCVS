import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class resultlist extends JFrame implements ActionListener
{
		Choice pres,vice,secr,joint,tre;
		JLabel l1,l2,l3,p,v,s,j,t;
		JButton vote;
		int count;
JOptionPane jp = new JOptionPane();
	 public resultlist() 
	{
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		 l1=new JLabel("CoLlEgE");  l1.setForeground(Color.red);
      l1.setFont(new Font("Monospaced",Font.ITALIC+Font.BOLD,40));   l1.setBounds(10,10,300,50);

      l2=new JLabel("VoTiNg");      l2.setForeground(Color.green);
      l2.setFont(new Font("Monospaced",Font.ITALIC+Font.BOLD,42));   l2.setBounds(320,15,200,50);

      l3=new JLabel("SyStEm");     l3.setForeground(Color.blue);
      l3.setFont(new Font("Monospaced",Font.ITALIC+Font.BOLD,45));   l3.setBounds(520,20,200,50);
		
		p=new JLabel("President Post :");    
		p.setForeground(Color.white);
		p.setBounds(40,100,150,20);   
		
		
		v=new JLabel("Vice-President Post:"); 
		v.setForeground(Color.white);
		v.setBounds(40,200,150,20);
		
	
		
		s=new JLabel("Secretary Post :");
		s.setForeground(Color.white);
	    s.setBounds(40,300,150,20);
	    
		
		j=new JLabel("Joint-Secretary Post :"); 
	   j.setForeground(Color.white);
	    j.setBounds(40,400,150,20);  
	   
		t=new JLabel("Treasurer Post"); 
	    t.setForeground(Color.white);
	   t.setBounds(40,500,150,20);  
	   
	    vote=new JButton("Vote", new ImageIcon("vote.gif"));
			vote.setForeground(Color.white);
			vote.setBackground(Color.pink);
       		vote.setToolTipText("Click to vote ");
			vote.setBounds(350,300,100,30);

		add(l1); add(l2); add(l3);
		add(p); add(v); add(s); add(j); add(t);
		add(vote);
		vote.addActionListener(this);
		
		setLayout(null); 
		 setSize(800,800);
		setVisible(true);
		setResizable(false);
		getContentPane().setBackground(new Color(104,150,100));
		
		try
		{
	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection c=DriverManager.getConnection("jdbc:odbc:college","","");
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("Select * from candidates where post='president'");
		
			pres=new Choice();
			while(rs.next())
			{
			
				pres.add(rs.getString(2));
			}
			pres.setBounds(200,100,150,26);
			add(pres);
			rs.close();
			st.close();

		}//try
		
		catch(ClassNotFoundException cnf)
		  {
		    	//jp.showMessageDialog(this,cnf,"EXCEPTION",jp.ERROR_MESSAGE);
		    	System.out.println("Cnf Exception"+cnf);
		  }
		  catch(SQLException sql)
		  {
		    	//jp.showMessageDialog(this,sql,"EXCEPTION",jp.ERROR_MESSAGE);
				System.out.println("Sql Exception"+sql);
		  }
		
		
		try
		{
	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection c=DriverManager.getConnection("jdbc:odbc:college","","");
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("Select * from candidates where post='vice-president'");
		
			vice=new Choice();
			while(rs.next())
			{
			
				vice.add(rs.getString(2));
			}
			vice.setBounds(200,200,150,26);
			add(vice);
			rs.close();
			st.close();

		}//try
		catch(ClassNotFoundException cnf)
		  {
		    	//jp.showMessageDialog(this,cnf,"EXCEPTION",jp.ERROR_MESSAGE);
		    	System.out.println("Cnf Exception"+cnf);
		  }
		  catch(SQLException sql)
		  {
		    	//jp.showMessageDialog(this,sql,"EXCEPTION",jp.ERROR_MESSAGE);
				System.out.println("Sql Exception"+sql);
		  }
		
		
		try
		{
	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection c=DriverManager.getConnection("jdbc:odbc:college","","");
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("Select * from candidates where post='secretary'");
		
			secr=new Choice();
			while(rs.next())
			{
			
				secr.add(rs.getString(2));
			}
			secr.setBounds(200,300,150,26);
			add(secr);
			rs.close();
			st.close();

		}//try
		catch(ClassNotFoundException cnf)
		  {
		    	//jp.showMessageDialog(this,cnf,"EXCEPTION",jp.ERROR_MESSAGE);
		    	System.out.println("Cnf Exception"+cnf);
		  }
		  catch(SQLException sql)
		  {
		    	//jp.showMessageDialog(this,sql,"EXCEPTION",jp.ERROR_MESSAGE);
				System.out.println("Sql Exception"+sql);
		  }
		
		try
		{
	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection c=DriverManager.getConnection("jdbc:odbc:college","","");
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("Select * from candidates where post='joint-secretary'");
		
			joint=new Choice();
			while(rs.next())
			{
			
				joint.add(rs.getString(2));
			}
			joint.setBounds(200,400,150,26);
			add(joint);
			rs.close();
			st.close();

		}//try
		catch(ClassNotFoundException cnf)
		  {
		    	//jp.showMessageDialog(this,cnf,"EXCEPTION",jp.ERROR_MESSAGE);
		    	System.out.println("Cnf Exception"+cnf);
		  }
		  catch(SQLException sql)
		  {
		    	//jp.showMessageDialog(this,sql,"EXCEPTION",jp.ERROR_MESSAGE);
				System.out.println("Sql Exception"+sql);
		  }
		
		
		try
		{
	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection c=DriverManager.getConnection("jdbc:odbc:college","","");
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("Select * from candidates where post='treasurer'");
		
			tre=new Choice();
			while(rs.next())
			{
			
				tre.add(rs.getString(2));
			}
			tre.setBounds(200,500,150,26);
			add(tre);
			rs.close();
			st.close();

		}//try
		
		
		 catch(ClassNotFoundException cnf)
		  {
		    	//jp.showMessageDialog(this,cnf,"EXCEPTION",jp.ERROR_MESSAGE);
		    	System.out.println("Cnf Exception"+cnf);
		  }
		  catch(SQLException sql)
		  {
		    	//jp.showMessageDialog(this,sql,"EXCEPTION",jp.ERROR_MESSAGE);
				System.out.println("Sql Exception"+sql);
		  }
		
		
		
		
		

		
		
		
	}
	
		
    public void actionPerformed(ActionEvent ae)
	{
				 Object ob=ae.getSource();
	
	
	 if (ob==vote)
     {
	  		
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection c=DriverManager.getConnection("jdbc:odbc:college");
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("Select vote from candidates where name= '"+ pres.getSelectedItem()+"' ");

		while(rs.next())
			{
				count=Integer.parseInt(rs.getString(1));
				
			}
			
			count+=1;

          PreparedStatement ps=c.prepareStatement("Update candidates set vote=? where name= '"+ pres.getSelectedItem()+"' ");
		  ps.setString(1,String.valueOf(count));
		 ps.executeUpdate();
			
			


			rs.close();
			st.close();
			

		}//try
		
		 catch(ClassNotFoundException cnf)
		  {
		    	jp.showMessageDialog(vote,cnf,"EXCEPTION",jp.ERROR_MESSAGE);
		    	//System.out.println("Cnf Exception"+cnf);
		  }
		  catch(SQLException sql)
		  {
		    	jp.showMessageDialog(vote,sql,"EXCEPTION",jp.ERROR_MESSAGE);
				//System.out.println("Sql Exception"+sql);
		  }
		   
		   
		   
		   try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection c=DriverManager.getConnection("jdbc:odbc:college");
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("Select vote from candidates where name= '"+ vice.getSelectedItem()+"' ");

		while(rs.next())
			{
				count=Integer.parseInt(rs.getString(1));
				
			}
			
			count+=1;

          PreparedStatement ps=c.prepareStatement("Update candidates set vote=? where name= '"+ vice.getSelectedItem()+"' ");
		  ps.setString(1,String.valueOf(count));
		 ps.executeUpdate();
			
			


			rs.close();
			st.close();
			

		}//try
		
		 catch(ClassNotFoundException cnf)
		  {
		    	jp.showMessageDialog(vote,cnf,"EXCEPTION",jp.ERROR_MESSAGE);
		    	//System.out.println("Cnf Exception"+cnf);
		  }
		  catch(SQLException sql)
		  {
		    	jp.showMessageDialog(vote,sql,"EXCEPTION",jp.ERROR_MESSAGE);
				//System.out.println("Sql Exception"+sql);
		  }
		   
		   
		   
		   try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection c=DriverManager.getConnection("jdbc:odbc:college");
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("Select vote from candidates where name= '"+ secr.getSelectedItem()+"' ");

		while(rs.next())
			{
				count=Integer.parseInt(rs.getString(1));
				
			}
			
			count+=1;

          PreparedStatement ps=c.prepareStatement("Update candidates set vote=? where name= '"+ secr.getSelectedItem()+"' ");
		  ps.setString(1,String.valueOf(count));
		 ps.executeUpdate();
			
			


			rs.close();
			st.close();
			

		}//try
		
		 catch(ClassNotFoundException cnf)
		  {
		    	jp.showMessageDialog(vote,cnf,"EXCEPTION",jp.ERROR_MESSAGE);
		    	//System.out.println("Cnf Exception"+cnf);
		  }
		  catch(SQLException sql)
		  {
		    	jp.showMessageDialog(vote,sql,"EXCEPTION",jp.ERROR_MESSAGE);
				//System.out.println("Sql Exception"+sql);
		  }
		   
		   
		   
		   
		  try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection c=DriverManager.getConnection("jdbc:odbc:college");
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("Select vote from candidates where name= '"+ joint.getSelectedItem()+"' ");

		while(rs.next())
			{
				count=Integer.parseInt(rs.getString(1));
				
			}
			
			count+=1;

          PreparedStatement ps=c.prepareStatement("Update candidates set vote=? where name= '"+ joint.getSelectedItem()+"' ");
		  ps.setString(1,String.valueOf(count));
		 ps.executeUpdate();
			
			


			rs.close();
			st.close();
			

		}//try
		
		 catch(ClassNotFoundException cnf)
		  {
		    	jp.showMessageDialog(vote,cnf,"EXCEPTION",jp.ERROR_MESSAGE);
		    	//System.out.println("Cnf Exception"+cnf);
		  }
		  catch(SQLException sql)
		  {
		    	jp.showMessageDialog(vote,sql,"EXCEPTION",jp.ERROR_MESSAGE);
				//System.out.println("Sql Exception"+sql);
		  } 
		   
		   
		   
		   try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection c=DriverManager.getConnection("jdbc:odbc:college");
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("Select vote from candidates where name= '"+ tre.getSelectedItem()+"' ");

		while(rs.next())
			{
				count=Integer.parseInt(rs.getString(1));
				
			}
			
			count+=1;

          PreparedStatement ps=c.prepareStatement("Update candidates set vote=? where name= '"+ tre.getSelectedItem()+"' ");
		  ps.setString(1,String.valueOf(count));
		 ps.executeUpdate();
			
			


			rs.close();
			st.close();
			

		}//try
		
		 catch(ClassNotFoundException cnf)
		  {
		    	jp.showMessageDialog(vote,cnf,"EXCEPTION",jp.ERROR_MESSAGE);
		    	//System.out.println("Cnf Exception"+cnf);
		  }
		  catch(SQLException sql)
		  {
		    	jp.showMessageDialog(vote,sql,"EXCEPTION",jp.ERROR_MESSAGE);
				//System.out.println("Sql Exception"+sql);
		  }
		   
		   
		   
		  jp.showMessageDialog(vote,"Voted Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
		 new audiosample();
			dispose();
			//new voting();
			
			
			
			
			
			
	}
	
	}
	
	
		public static void main(String[] args) 
		{
		
		 resultlist rl=new  resultlist();
		 rl.setSize(800,800);
		 rl.setVisible(true);
	}
}

