import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

class Availity extends JFrame implements ActionListener {


JFrame f;
Container cn;
JComboBox cb1,cb2;
String scb1,scb2,scb3;
JTextField t1,t2,t3,t4,t5;
JLabel l,l1,l2,l3,l4,l5,l6,l7;
JButton b1,b2,b3;
PreparedStatement pstmt=null;
Connection conn=null;
Statement stmt=null;
ResultSet rs;

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



		Availity() {


            		 f=new JFrame("Manage Taxi Records");
                        
		
			 Icon i = new ImageIcon("D:\\Taxi Booking System\\images\\all.jpg");


			 Font ft=new Font("Elephant",Font.BOLD,30);			
			 Font ft1 = new Font("Normal ",Font.BOLD,20);

			 Color cc1=new Color(31,134,220);
			
		
		
	
//Labels..... 

			 l=new JLabel(" ");
                         l1=new JLabel("CHECK       TAXI      AVAILITY");
			 l2=new JLabel("SELECT TAXI ID :");
			 l3=new JLabel("MODEL/TYPE :");
			 l4=new JLabel("CAPACITY :");
			 l5=new JLabel("DRIVER ID :");
			 l6=new JLabel("DRIVER NAME :");
			 l7=new JLabel("ENTER BOOKING DATE :");
			

			 l.setBounds(0,0,1360,720);
			 l1.setBounds(370,10,800,50);
			 l2.setBounds(200,200,100,30);
			 l3.setBounds(580,200,100,30);
			 l4.setBounds(940,200,100,30);
			 l5.setBounds(200,400,100,30);
			 l6.setBounds(580,400,150,30);
			 l7.setBounds(940,400,150,30);
			 
			
			 l1.setForeground(Color.YELLOW);
			 l2.setForeground(Color.WHITE);
			 l3.setForeground(Color.WHITE);
			 l4.setForeground(Color.WHITE); 
			 l5.setForeground(Color.WHITE);
			 l6.setForeground(Color.WHITE); 
			 l7.setForeground(Color.WHITE);
			
				
			 l.setIcon(i); 			
			 l1.setFont(ft);



                           
			
			 l.add(l1);
                         l.add(l2);
			 l.add(l3);
			 l.add(l4);
			 l.add(l5); 
			 l.add(l6);
			 l.add(l7); 
			
			
			 f.add(l);

                      
//Text Fields........                      		
				
				
                        t1=new JTextField( );
			t2=new JTextField( );
			t3=new JTextField( );
			t4=new JTextField( );
			
			
	
                        t1.setBounds(580,230,240,30);
			t2.setBounds(940,230,240,30);
			t3.setBounds(580,430,240,30);
			t4.setBounds(940,430,240,30);
			

				l.add(t1);
				l.add(t2);
				l.add(t3);                 
               	                l.add(t4); 

			t1.setEditable(false);
			t2.setEditable(false);
			t3.setEditable(false);	
				
                                 
//ComboBox.......				
			 
                 	
			 cb1 = new JComboBox();
        		 cb2 = new JComboBox();
  
       			 cb1.setBounds(200,230,240,30);
			 cb2.setBounds(200,430,240,30);

    
        		l.add(cb1);
			l.add(cb2);

			try
			{
			conn=DriverManager.getConnection("jdbc:odbc:taxi");
	
			stmt=conn.createStatement();
	
			String s= "Select TaxiID From Taxi";

			rs=stmt.executeQuery(s);
	
			while(rs.next())
				{
								
				cb1.addItem(rs.getString(1));
									
				}


			}catch(Exception e){
	
			System.out.println(e);
	
			}


			cb1.addItemListener(new ItemListener()
			{  
				public void itemStateChanged(ItemEvent ie)
				{
					try{
			connect();
			scb1 = String.valueOf(cb1.getSelectedItem());

			stmt=conn.createStatement();
	
			String s= "Select Model,Capacity From Taxi where TaxiID="+scb1;

			rs=stmt.executeQuery(s);
	
			while(rs.next())
				{
								
				t1.setText(rs.getString(1));
				t2.setText(rs.getString(2));
					
				}
			}catch(Exception ee){
				System.out.println(ee);}
			
				}
			
			});	
			
       			try
			{
			conn=DriverManager.getConnection("jdbc:odbc:taxi");
	
			stmt=conn.createStatement();
	
			String s= "Select DriverID From Driver";

			rs=stmt.executeQuery(s);
	
			while(rs.next())
				{
								
				cb2.addItem(rs.getString(1));
									
				}


			}catch(Exception e){
	
			System.out.println(e);
	
			}	

        		cb2.addItemListener(new ItemListener()
			{  
				public void itemStateChanged(ItemEvent ie)
				{
					try{
			connect();
			scb2 = String.valueOf(cb2.getSelectedItem());

			stmt=conn.createStatement();
	
			String s= "Select Name From Driver where DriverID="+scb2;

			rs=stmt.executeQuery(s);
	
			while(rs.next())
				{
								
				t3.setText(rs.getString(1));
				
					
				}
			}catch(Exception ee){
				System.out.println(ee);}
			
				}
			
			});	    


			
//Buttons.........
			
       			
	
                 
		          b1=new JButton("CHECK");
			  b1.setMnemonic((int)'K');
			  b2=new JButton("CLEAR");
			  b2.setMnemonic((int)'C');
			  b3=new JButton("Back to Main");
			  b3.setMnemonic((int)'B');

                          b1.setBounds(200,600,330,30);
			  b2.setBounds(860,600,330,30);
			  b3.setBounds(530,600,330,30);



                      	  b1.setForeground(Color.YELLOW);
			  b2.setForeground(Color.YELLOW);	
			  b3.setForeground(Color.YELLOW);	


			  b1.setBackground(cc1);
			  b2.setBackground(cc1);
			  b3.setBackground(cc1);
		
			  b1.setFont(ft1);
			  b2.setFont(ft1);
			  b3.setFont(ft1);               
			                      
			 
				
			  b2.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent ae)
					{							

					t1.setText(" ");
					t2.setText(" ");
					t3.setText(" ");					
					t4.setText(" ");									
							
					}
				});

                       
                                  
				
				
				
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



 

		
//Methods for Actionperformed
		public void actionPerformed(ActionEvent e)
			{
				
				if(e.getSource().equals(b1))
					{
					 	
						try
						{
						 connect();
						
						 pstmt=conn.prepareStatement("select TID,DID,BDATE from Booking where BDATE=?");

						pstmt.setString(1,t4.getText());

			
						rs=pstmt.executeQuery();

					
						String var1=null,var2=null,var3=null;

								if(rs.next())						
								{
									var1 = rs.getString(1);
									var2 = rs.getString(2);
									var3 = rs.getString(3);

								if(var1.equals(scb1)&&var2.equals(scb2)&&var3.equals(t4.getText()))
								{JOptionPane.showMessageDialog(this,"Taxi not Available");}
																
								
								}
								else{JOptionPane.showMessageDialog(this,"Taxi Available");}
								
								
						
								
					 
						}
						catch(Exception ex1)
						{
						//JOptionPane.showMessageDialog(this,"Data Searching Faild");
						ex1.printStackTrace();
						 
						}
				
					}
			
				else
					{}
					
				
			}
public static void main(String args[])
	{
	new Availity();
	}
			

}      
                      


      
  