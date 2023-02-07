import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class ForgetPassword extends JFrame implements ActionListener
{
JFrame f;
JLabel l1,l2,l3,l4,l5,l6;
JTextField t1,t2,t3,t4;
JButton b1,b2,b3;
PreparedStatement pstmt=null;
Connection conn=null;
Statement stmt=null;
ResultSet rs;



	public void setup()
	{
	f = new JFrame("Taxi Booking System");
	
	
	Color cc=new Color(83,125,219);
	
	Color c = new Color(131,161,229);
	
	
	Icon i = new ImageIcon("D:\\Taxi Booking System\\images\\all.jpg");	
	l1=new JLabel(" ");
	l1.setBounds(0,0,1360,720);
	f.add(l1);
	l1.setIcon(i);
	
	
	
	l2=new JLabel("Taxi   Booking   System");
	l2.setBounds(490,10,1360,50);
	Font ft = new Font("Elephant",Font.BOLD,40);
	l2.setFont(ft);
	l2.setForeground(Color.WHITE);
	l1.add(l2);
	
		l3=new JLabel("User Name :");
		l3.setForeground(Color.WHITE);
		l3.setBounds(500,200,120,30);

		t1=new JTextField();
		t1.setBounds(700,200,250,30);

				
		l4=new JLabel("Date of Birth :");
		l4.setForeground(Color.WHITE);
		l4.setBounds(500,280,120,30);

		t2=new JTextField();
		t2.setBounds(700,280,250,30);
		

		l5=new JLabel("Mobile No :");
		l5.setForeground(Color.WHITE);
		l5.setBounds(500,360,120,30);

		t3=new JTextField();
		t3.setBounds(700,360,250,30);

		l6=new JLabel("New Password :");
		l6.setForeground(Color.WHITE);
		l6.setBounds(500,440,120,30);
		
		t4=new JTextField();
		t4.setBounds(700,440,250,30);
	

       
		



	l1.add(l3);
	l1.add(l4);
	l1.add(l5);
	l1.add(l6);
	
	l1.add(t1);	
	l1.add(t2);	
	l1.add(t3);	
	l1.add(t4);	
	

	Color cc1=new Color(37,80,167);
	Font ft1 = new Font("Normal",Font.BOLD,15);
	b1=new JButton("Countinue");
	b1.setMnemonic((int)'S');
	b1.setForeground(Color.WHITE);
	b1.setBackground(cc1);
	b1.setBounds(500,580,200,40);
	b1.setFont(ft1);
	l1.add(b1);
	
	b2=new JButton("Go To Login");
	b2.setMnemonic((int)'L');
	b2.setForeground(Color.WHITE);
	b2.setBackground(cc1);
	b2.setBounds(750,580,200,40);
	b2.setFont(ft1);
	l1.add(b2);
	
	

	b1.addActionListener(this);
	b2.addActionListener(this);


	f.setBounds(5,5,1360,720);
	f.setVisible(true);
	f.setLayout(null);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }

// Methods for creating connection
	public void connect()
		{
		 try
			{
			 conn=DriverManager.getConnection("jdbc:odbc:taxi"," "," ");
			 
			}
		catch(Exception e1)
			{
			JOptionPane.showMessageDialog(this,"Error:"+e1.getMessage());
			}
		}
//Methods for update
	public void update()
		{
		 try
			{
			 stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			 String q;
			 q="select * from Login";
			 rs=stmt.executeQuery(q);
			 rs.last();
			 }
		 catch(Exception es)
			{
			 JOptionPane.showMessageDialog(this,"Unable to Update");
			 JOptionPane.showMessageDialog(this," "+es);
			}
		}
//Methods for Actionperformed

public void actionPerformed(ActionEvent ae)
	{

	
		if(ae.getSource()==b1)
		{
			try
			{
			connect();
			String uname=t1.getText();
			String dob=t2.getText();
			String mno=t3.getText();
			String npass=t4.getText();
			
			pstmt=conn.prepareStatement("select UserName,Dob,Ph from Login where Dob=?");

						pstmt.setString(1,t2.getText());
						
			
						rs=pstmt.executeQuery();
			
					
						String var1=null,var2=null,var3=null;

								if(rs.next())						
								{
									var1 = rs.getString(1);
									var2 = rs.getString(2);
									var3 = rs.getString(3);



								if(var1.equals(uname)&&var2.equals(dob)&&var3.equals(mno))
								{
								pstmt=conn.prepareStatement("Update Login Set Password=?,UserName=?,Ph=? Where Dob=?");			


								pstmt.setString(4,dob);			
								pstmt.setString(1,npass);
								  pstmt.setString(2,uname);
								pstmt.setString(3,mno);
								  										
							pstmt.executeUpdate();
						 	
								

								JOptionPane.showMessageDialog(this,"Password Forget Successfully");
							JOptionPane.showMessageDialog(this,"Your New Password :"+t4.getText());
							t1.setText("");
							t2.setText("");
							t3.setText("");
							t4.setText("");								
								}
								}
								else{JOptionPane.showMessageDialog(this,"Please Enter Correct Details");}
								
								
			
			 
			}
			catch(SQLException se)
			{
				JOptionPane.showMessageDialog (this, "Error in saving the file",
						"Forget Password - SQL Error", JOptionPane.PLAIN_MESSAGE);
							

			}
		
			
						
							

		}
		

	 	if(ae.getSource()==b2)
	  	 {
	   	new Login().setup();
		f.setVisible(false);

	   	}
		
		
}

	
	
public static void main(String args[])
	{
	ForgetPassword s=new ForgetPassword();
	s.setup();
	}
}