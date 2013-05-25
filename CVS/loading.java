import java.awt.*;       
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.applet.*;
public class loading extends JFrame
{
      Random r=new Random();
      JLabel l1;
      Timer tym;
      int tr=10;
      mydraw d;
      public loading()
      {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
	  Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
      setSize(300,300);
      setResizable(false);
	  setTitle("Please Wait while Loading....");
	  

       l1=new JLabel(String.valueOf(tr),JLabel.CENTER);
       l1.setFont(new Font("Monospaced",2,60));
       getContentPane().add(l1);
     

      tym=new Timer(500,new CountDownTimerListener());
      setVisible(true);
      setResizable(false);
      tym.start();
      
	  }
      
	  class mydraw extends JPanel
      {
       
	   public mydraw()
       {
          repaint();
        }
       
	   public void paint(Graphics g)
	  {
        int per=(10-tr)*10;
        int dr=per*2;
        g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256))); 
		g.setFont(new Font("Monospaced",Font.BOLD,30));
        g.drawString("Loading...."+String.valueOf(per)+"%",30,40);
        g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
        g.drawRect(30,80,200,12);
        g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
        g.fillRect(30,80,dr,12);

     }//paint
    }//class       
      class CountDownTimerListener implements ActionListener
      {
        public void actionPerformed(ActionEvent ae)
        {
          if(--tr>0)
          {
           getContentPane().add(new JLabel("Loading......"));
           getContentPane().setBackground(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
           l1.setText(String.valueOf(tr));
           d=new mydraw();
           getContentPane().add(d);
           
          }
          else
          {
            tym.stop();
            dispose();
            login lg=new login();
          }
       }
     }
       public static void main(String arg[])
       {
       
	   loading ld=new loading();
   
	   }
 }
