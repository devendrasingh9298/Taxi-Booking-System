import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.Timer;
class Login extends JFrame implements ActionListener
{
JFrame f;
Container cn;
JLabel l1,l3,l4,l6,l7;
JTextField t1;
JPasswordField t2;
JButton b1,b2,b3;
private Timer t;
Connection conn;
Statement stmt;
ResultSet rs;

	/**
	 * 
	 */
	public void setup()
	{
	final Icon i = new ImageIcon("D:\\Taxi Booking System\\images\\wp.jpg");	
	
	f = new JFrame("Welcome To My Project");
	
	
	 	
	cn=getContentPane();
	cn.setLayout(null);	
	f.add(cn);
	
	l1=new JLabel(" ");
	l1.setBounds(0,0,1360,720);
	cn.add(l1);
	l1.setIcon(i);
	
	Font ft = new Font("Elephant",Font.BOLD,40);
	

	
	Font ft3 = new Font("Elephant",Font.BOLD,40);
	l7=new JLabel("                                  							        Taxi             Booking            System");
	l7.setForeground(Color.YELLOW);		
	l7.setBounds(0,20,1360,80);
	l1.add(l7);
	l7.setFont(ft3);
	 t = new Timer(400, this); 
     	 t.start();	

	Font ft1 = new Font(" ",Font.BOLD,15);
	
	l3=new JLabel("Login Id :");
	l3.setForeground(Color.WHITE);	
	l3.setBounds(550,190,120,30);
	l1.add(l3);
	l3.setFont(ft1);	


	l4=new JLabel("Password :");
	l4.setForeground(Color.WHITE);	
	l4.setBounds(550,270,120,30);
	l1.add(l4);
	l4.setFont(ft1);
	
	
	t1=new JTextField();	
	t1.setBounds(550,220,300,30);		
	l1.add(t1);
		
	
	t2=new JPasswordField();	
	t2.setBounds(550,300,300,30);		
	l1.add(t2);	

	Color cc1=new Color(31,134,220);
	
	b1=new JButton("SIGN IN");
	b1.setMnemonic((int)'I');
	b1.setForeground(Color.WHITE);
	b1.setBackground(cc1);
	b1.setBorder (BorderFactory.createEmptyBorder (1, 1, 1, 1));	
    	b1.setFocusPainted (false);
	b1.setBounds(550,380,300,30);
	b1.setFont(ft1);
	l1.add(b1);
	
	b2=new JButton("CANCEL");
	b2.setMnemonic((int)'C');
	b2.setForeground(Color.WHITE);
	b2.setBorder (BorderFactory.createEmptyBorder (1, 1, 1, 1));	
    	b2.setFocusPainted (false);
	b2.setBackground(cc1);
	b2.setBounds(550,440,300,30);
	b2.setFont(ft1);
	l1.add(b2);
	
	b3=new JButton("Forgotten Password ?");
	b3.setMnemonic((int)'U');
	b3.setForeground(Color.BLUE);
	b3.setBackground(cc1);
	b3.setBorder (BorderFactory.createEmptyBorder (1, 1, 1, 1));
	b3.setContentAreaFilled (false);
    	b3.setFocusPainted (false);
	b3.setBounds(670,505,200,30);
	b3.setFont(ft1);
	b1.setBorder (BorderFactory.createEmptyBorder (1, 1, 1, 1));
	l1.add(b3);
	

	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);	
	
	f.setBounds(5,5,1360,720);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	

	
	}

public void actionPerformed(ActionEvent ae)
	
	   
	{

	if(ae.getSource()==b1)
		{
		try
			{
		
		conn=DriverManager.getConnection("jdbc:odbc:taxi"," "," ");
		stmt=conn.createStatement();
		
		String dk="where UserName='" +t1.getText()+"'";
		String di="and Password='"+t2.getText()+"'";
		
		String sql="select * from Login "+dk + di;
		// System.out.print("Exception of query Failed");
		rs=stmt.executeQuery(sql);
		System.out.println("Execution of query Successfully");

		if(rs.next())
			{
			JOptionPane.showMessageDialog(this,"Login Success");
			conn.close();
			stmt.close();
			this.dispose();
			
			 new Home().setup();
			f.setVisible(false);

			}
		else
			{
			JOptionPane.showMessageDialog(this,"Invalid UserName and Password");
			t1.setText(" ");
			t2.setText(" ");

				}
			
		}catch(Exception e)
			{
			System.out.println(e);
			}
	
		}
		

	 	if(ae.getSource()==b2)
	  	 {
	   	System.exit(0);		
	   	}

		if(ae.getSource()==b3)
	  	 {
	   	new ForgetPassword().setup();
		 f.setVisible(false);
	   	}
	
 
	
 	{
      String oldText = l7.getText();
      String newText= oldText.substring(1)+ oldText.substring(0,1);
      l7.setText(newText);
	}	
	
}
public static void main(String args[])
	{
	Login l=new Login();
	l.setup();
	
	}

}
