import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class login extends JFrame implements ActionListener
{
     JButton sub,can;
     Container c;
     JOptionPane jp;
     JLabel l1,l2,l3;
    JTextField u_id;
    JPasswordField pwd;
     public login()
     {
      c=getContentPane();
	  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
      setLayout(null);
      c.setBackground(new Color(114,153,119));
      jp=new JOptionPane();

          setSize(300,300);
          setVisible(true);
		  setTitle("Login Window");


      l1=new JLabel("enter userid :");
      l1.setFont(new Font("Monospaced",Font.BOLD,15));
      l1.setBounds(50,50,150,50);
      l1.setToolTipText("enter your login name");

      l2=new JLabel("enter password :");
      l2.setFont(new Font("Monospaced",Font.BOLD,12));
      l2.setBounds(50,100,150,50);
      l2.setToolTipText("enter your password ");

      l3=new JLabel("login here...");
      l3.setFont(new Font("Verdana",2,15));
      l3.setBounds(10,10,100,50);

      u_id=new JTextField(10);
	  u_id.setForeground(Color.black);        
	  u_id.setBackground(Color.white);
      u_id.setBounds(180,60,100,30);

      pwd=new JPasswordField(10);
	  pwd.setForeground(Color.black);        
	  pwd.setBackground(Color.white);
      pwd.setBounds(180,110,100,30);
      pwd.setEchoChar('*');

      sub=new JButton("Submit",new ImageIcon("Key.gif"));
	  sub.setForeground(Color.white); 
	  sub.setBackground(Color.pink);
	  sub.setToolTipText("Click to Login");
      sub.setBounds(30,200,120,35);

      can=new JButton("Cancel",new ImageIcon("EXIT.PNG")); 
	  can.setForeground(Color.white);
	  can.setBackground(Color.pink);
      can.setToolTipText("Exit from the window");
      can.setBounds(150,200,110,35);
      
      add(l1);
      add(u_id);
      add(l2);
      add(pwd);
      add(l3);
      add(sub);
      add(can);
      sub.addActionListener(this);
      can.addActionListener(this);  
      
   }
   public void actionPerformed(ActionEvent ae)
   {

     Object ob=ae.getSource();

      if(ob==sub)
      {
        ResultSet r;
		int f=0;

       try
       {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       Connection cn=DriverManager.getConnection("jdbc:odbc:college","","");
        Statement st=cn.createStatement();
        r=st.executeQuery("Select * from login");
         while(r.next())
          {
				if(r.getString(2).equals(u_id.getText()) && r.getString(3).equals(pwd.getText()))
				{
				 jp.showMessageDialog(this,"Login Sucessful","Success",jp.INFORMATION_MESSAGE);
					f=1;
					dispose();
				mainmenu m=new mainmenu();
				}//if
		}
		 if(f==0)
           {
            jp.showMessageDialog(this,"Login Failed","Error",jp.ERROR_MESSAGE);
            
           }//else
        
		}//try

        catch(SQLException e){
		        System.out.println(e);
		}
        catch(Exception e){
		System.out.println(e);
		}
      }//if
      if(ob==can)
      {
        System.exit(0);
       }
  }
    public static void main(String args[])
    {
          login lg=new login();
          lg.setTitle("Login Window");
          lg.setResizable(false);
        }
}
                                   
