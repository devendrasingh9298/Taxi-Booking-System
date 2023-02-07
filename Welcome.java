import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
class Welcome extends JFrame implements ActionListener 
{
JFrame f;
Container cn;
JLabel l1,l2,l3,l4,l5;
private Timer t;
JButton b1;
 
    
	public void setup()
	{
	 
	
	Icon i = new ImageIcon("D:\\Taxi Booking System\\images\\wel.jpg");	
	
	 f = new JFrame("Welcome");
	f.setBounds(5,5,1360,720);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	
	 	
	
	
	l1=new JLabel(" ");
	l1.setBounds(0,0,1360,720);
	f.add(l1);
	l1.setIcon(i);

	
	
	Color c = new Color(3,134,181);
	
	Font ft = new Font("Elephant",Font.BOLD,40);
	l2=new JLabel("                                  							        Taxi             Booking            System");
	l2.setForeground(Color.YELLOW);		
	l2.setBounds(0,600,1360,80);
	l1.add(l2);
	l2.setFont(ft);	

	
	Icon i1 = new ImageIcon("D:\\Taxi Booking System\\images\\pg.gif");
	l3=new JLabel(" ");
	l3.setBounds(320,120,800,400);
	l1.add(l3);
	l3.setIcon(i1);

	Font ft2 = new Font("Elephant",Font.BOLD,50);

	l5=new JLabel("Welcome");
	l5.setForeground(Color.YELLOW);		
	l5.setBounds(600,10,800,60);
	l1.add(l5);
	l5.setFont(ft2);
	 t = new Timer(400, this); 
     	 t.start();
  

	
	
	Font ft1 = new Font("Elephant",Font.BOLD,20);
	
	
	b1 = new JButton("   Next>>");
	b1.setMnemonic((int)'N');
	b1.setBounds(320,520,800,35);
	b1.setForeground(Color.YELLOW);
	l1.add(b1);
	b1.setFont(ft1);
	b1.setBackground(c);
	b1.setBorder (BorderFactory.createEmptyBorder (1, 1, 1, 1));
	b1.addActionListener(new ActionListener()
		{public void actionPerformed(ActionEvent ae)
			{ 
			
			 new Login().setup();
			 f.setVisible(false);
			}
		});
       } 
	
	
      public void actionPerformed(ActionEvent e) {
      String oldText = l2.getText();
      String newText= oldText.substring(1)+ oldText.substring(0,1);
      l2.setText(newText);
   }
	
	
public static void main(String args[])
	{
	Welcome e=new Welcome();
	e.setup();
	}
}
