import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class Home extends JFrame 
{
JFrame f;
JPanel p1;
JLabel l1,l2,l3;


JButton b1,b2,b3;
JMenuBar m;
JMenu m1,m2,m3,m4;
JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10,mi11,mi12;


	public void setup()
	{     
	
	f = new JFrame("Taxi Booking System");
	
	
	Color cc1=new Color(31,134,181);

	l1=new JLabel("TAXI BOOKING SYSTEM");
	l1.setBounds(380,10,1360,50);
	Font ft = new Font("Elephant",Font.BOLD,40);
	l1.setFont(ft);
	l1.setForeground(Color.WHITE);
	f.add(l1);
	
	l2=new JLabel(" ");		
                l2.setBounds(0,0,1360,720);
                f.add(l2);
		Icon i = new ImageIcon("D:\\Taxi Booking System\\images\\all.jpg");
			l2.setIcon(i);

	l3=new JLabel(" ");
		l3.setLayout(null);		
                l3.setBounds(300,145,800,500);
                l2.add(l3);
		Icon i1 = new ImageIcon("D:\\Taxi Booking System\\images\\pg1.gif");
			l3.setIcon(i1);

	
	Font ft1 = new Font("Arial",Font.BOLD,15);
	m=new JMenuBar();
	m.setLayout(null);
	m.setBackground(cc1);
	m.setBounds(300,100,800,50);
	l2.add(m);
	m1=new JMenu("TAXI");
	m1.setMnemonic((int)'T');
	m1.setBounds(0,5,160,40);	
	m1.setForeground(Color.WHITE);	
	m1.setFont(ft1);
	m.add(m1);
	
	mi1=new JMenuItem("Add New Taxi Records");
	m1.add(mi1);
	mi1.addActionListener(new ActionListener()
	{public void actionPerformed(ActionEvent ae)
		{
		 new AddTaxi();
		f.setVisible(false);
		}
	});	
	

	mi2=new JMenuItem("Update Old Taxi Records");
	m1.add(mi2);
	mi2.addActionListener(new ActionListener()
	{public void actionPerformed(ActionEvent ae)
		{
		 new UpdateTaxi();
		f.setVisible(false);
		}
	});	
	

	m3=new JMenu("Search Taxi Records");
	m1.add(m3);

	mi9=new JMenuItem("Search By ID");
	m3.add(mi9);
	mi9.addActionListener(new ActionListener()
	{public void actionPerformed(ActionEvent ae)
		{
		 new SearchTaxibyId().setup();
		f.setVisible(false);
		}
	});	
	
	mi10=new JMenuItem("Search By Taxi Registration No");
	m3.add(mi10);
	mi10.addActionListener(new ActionListener()
	{public void actionPerformed(ActionEvent ae)
		{
		 new SearchTaxibyRegistrationNo().setup();
		f.setVisible(false);
		}
	});	
	

	mi4=new JMenuItem("Delete Old Taxi Records");
	m1.add(mi4);
	
	mi4.addActionListener(new ActionListener()
	{public void actionPerformed(ActionEvent ae)
		{
		 new DelTaxi().setup();
		f.setVisible(false);
		}
	});	
	

	
	
	m2=new JMenu("DRIVER");	
	m2.setMnemonic((int)'D');
	m2.setBounds(160,5,160,40);		
	m.add(m2);	
	m2.setForeground(Color.WHITE);	
	m2.setFont(ft1);	
	mi5=new JMenuItem("Add New Driver Records");
	m2.add(mi5);
	mi5.addActionListener(new ActionListener()
	{public void actionPerformed(ActionEvent ae)
		{
		 new AddDriver();
		f.setVisible(false);
		}
	});	
	

	mi6=new JMenuItem("Update Old Driver Records");
	m2.add(mi6);
	mi6.addActionListener(new ActionListener()
	{public void actionPerformed(ActionEvent ae)
		{
		 new UpdateDriver();
		f.setVisible(false);
		}
	});	
	

	m4=new JMenu("Search Driver Records");
	m2.add(m4);
	mi11=new JMenuItem("Search By ID");
	m4.add(mi11);
	mi11.addActionListener(new ActionListener()
	{public void actionPerformed(ActionEvent ae)
		{
		 new SearchDriverbyId();
		f.setVisible(false);
		}
	});	
	
	mi12=new JMenuItem("Search By Driver Name" );
	m4.add(mi12);
	mi12.addActionListener(new ActionListener()
	{public void actionPerformed(ActionEvent ae)
		{
		 new SearchDriverbyName();
		f.setVisible(false);
		}
	});	
	

	mi8=new JMenuItem("Delete Old Driver Records");
	m2.add(mi8);
	mi8.addActionListener(new ActionListener()
	{public void actionPerformed(ActionEvent ae)
		{
		 new DelDriver();
		f.setVisible(false);
		}
	});	
	
		
// Adding for Button in MenuBar.	


	b1=new JButton("CHECK AVAILITY");
	b1.setMnemonic((int)'A');	
	b1.setBounds(320,5,160,40);	
	b1.setForeground(Color.WHITE);
	b1.setBorder (BorderFactory.createEmptyBorder (1, 1, 1, 1));
	b1.setContentAreaFilled (false);
    	b1.setFocusPainted (false);	
	m.add(b1);	
	b1.setFont(ft1);
	b1.addActionListener(new ActionListener()
	{public void actionPerformed(ActionEvent ae)
		{
		 new Availity();
		f.setVisible(false);
		}
	});	
	
	
	b2=new JButton("BOOKING");
	b2.setMnemonic((int)'B');
	b2.setBounds(480,5,160,40);	
	b2.setForeground(Color.WHITE);
	b2.setBorder (BorderFactory.createEmptyBorder (1, 1, 1, 1));
	b2.setContentAreaFilled (false);
    	b2.setFocusPainted (false);	
	m.add(b2);
	b2.setFont(ft1);
	b2.addActionListener(new ActionListener()
	{public void actionPerformed(ActionEvent ae)
		{
		 new Booking();
		f.setVisible(false);
		}
	});	
	
	
	b3=new JButton("LOGOUT");
	b3.setMnemonic((int)'L');	
	b3.setBounds(640,5,160,40);	
	b3.setForeground(Color.WHITE);
	b3.setBorder (BorderFactory.createEmptyBorder (1, 1, 1, 1));
	b3.setContentAreaFilled (false);
    	b3.setFocusPainted (false);	
	m.add(b3);
	b3.setFont(ft1);
	b3.addActionListener(new ActionListener()
	{public void actionPerformed(ActionEvent ae)
		{
		 new Login().setup();
		f.setVisible(false);
		}
	});

	f.setBounds(5,5,1360,720);
	f.setVisible(true);
	f.setLayout(null);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	
	}
	
	
	
public static void main(String args[])
	{
	Home h=new Home();
	h.setup();
	}
}