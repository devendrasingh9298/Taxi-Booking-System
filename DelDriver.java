import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class DelDriver extends JFrame implements ActionListener
{
JFrame f;
Container cn;
JPanel p1;


JTextField t1;
JLabel l,l1,l2;
PreparedStatement pstmt=null;
Connection conn=null;
Statement stmt=null;
ResultSet rs;
JButton b1,b2,b3;



	DelDriver()
           {
             f=new JFrame("Manage Driver  Records");
                        
		
		Icon i = new ImageIcon("D:\\Taxi Booking System\\images\\all.jpg");	
		l=new JLabel(" ");
		l.setBounds(0,0,1360,720);
		f.add(l);
		l.setIcon(i);
	


                       l1=new JLabel("REMOVE       DRIVER      RECORDS");
                                  l1.setBounds(370,10,800,50);
				   l1.setForeground(Color.YELLOW);
				  l.add(l1);
                        Font ft=new Font("Elephant",Font.BOLD,30);
			l1.setFont(ft);
			

                       l2=new JLabel(" DRIVER ID :");
                       		l2.setBounds(530,200,100,30);
				l2.setForeground(Color.WHITE);
				l.add(l2);
                        t1=new JTextField( );
                        	t1.setBounds(530,230,240,30);
				l.add(t1);                
              	
			

                 Color cc1=new Color(31,134,220);
		Font ft1 = new Font("Normal ",Font.BOLD,20);
		          b1=new JButton("Delete");
			   b1.setMnemonic((int)'D');	
                                  b1.setBounds(410,520,120,30);
                      b1.setForeground(Color.YELLOW);
			b1.setBackground(cc1);	
			b1.setFont(ft1);
			                 
			                      
			JButton b2=new JButton("CLEAR");
			 b2.setMnemonic((int)'C');	
                                  b2.setBounds(790,520,120,30);
				b2.setBackground(cc1);
				b2.setForeground(Color.YELLOW);	
				b2.setFont(ft1);
				b2.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent ae)
					{
					
					t1.setText(" ");							
										
												
					}
				});

                       JButton b3=new JButton("Back to Main");
			 b3.setMnemonic((int)'B');	
                                  b3.setBounds(570,520,180,30);
				b3.setBackground(cc1);
				b3.setForeground(Color.YELLOW);	
				b3.setFont(ft1);
				b3.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent ae)
					{
					f.setVisible(false);
					new Home().setup();
					}
				});

			

                      
		    	
                   	l.add(b1);
                    	l.add(b2);
                    	l.add(b3);
	
		b1.addActionListener(this);
		
		f.setBounds(5,5,1360,720);
                        f.setVisible(true);
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

 
//Methods for update1
	public void update1()
		{
		 try
			{
			 stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			 String q;
			 q="select * from Driver ";
			 rs=stmt.executeQuery(q);
			 rs.last();
			 }
		 catch(Exception es)
			{
			 JOptionPane.showMessageDialog(this,"Unable to update no. of rows");
			 
			}
		}
		
//Methods for Actionperformed
		public void actionPerformed(ActionEvent e)
			{
				if(e.getSource().equals(b1))
					{
					 	try
						{
						 connect();
						 
						String id =t1.getText();
						pstmt=conn.prepareStatement(" Delete from Driver where DriverID = ? " );
						pstmt.setString(1,id);
						pstmt.executeUpdate();	
						JOptionPane.showMessageDialog(null,"Data Deleted Successfully");
						t1.setText(" ");
						update1();						 						 						 
						}
						catch(Exception ex)
						{
						JOptionPane.showMessageDialog(this,"Data Deletion Faild");
						ex.printStackTrace();
						 
						}
				
					}
			
				
					
				
			}
			


}     	 
                      


      
  