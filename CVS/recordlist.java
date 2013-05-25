import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class recordlist extends JFrame
{
	 public recordlist() 
	{

		 setLayout(new GridLayout());
		 setSize(800,500);
		setVisible(true);
		setTitle("Record_List");
		Vector columnNames=new Vector();
		Vector data=new Vector();
		getContentPane().setBackground(new Color(104,150,100));
		try
		{
	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       Connection c=DriverManager.getConnection("jdbc:odbc:college","","");
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("Select name ,post, vote from candidates");
		ResultSetMetaData md=rs.getMetaData();
		int columns=md.getColumnCount();
		for(int i=1;i<=columns;i++)
			{
			   columnNames.addElement(md.getColumnName(i));
			}
			while(rs.next())
			{

				Vector row=new Vector(columns);
				for(int i=1;i<=columns;i++)
				{
			      row.addElement(rs.getObject(i));
				}
				data.addElement(row);
			}
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
		JTable table=new JTable(data,columnNames);
		TableColumn col;
		for(int i=0;i<table.getColumnCount();i++)
		{
			col=table.getColumnModel().getColumn(i);
			col.setPreferredWidth(100);
		}

		JScrollPane scrollpane=new JScrollPane(table);
		//the table uses the entire height of the container
		//table.setFillsViewportHeight(true);
		add(scrollpane);
		
	}
		public static void main(String[] args) 
		{
		
		 recordlist rl=new  recordlist();
		 rl.setSize(800,500);
		 rl.setVisible(true);
		 rl.setTitle("Record_List");
	}
}

