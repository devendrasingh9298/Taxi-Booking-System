import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

class SearchTaxibyId extends JFrame implements ActionListener {


JFrame f;
Container cn;
JComboBox cb1,cb2;
CheckboxGroup cbg;
Checkbox c1,c2;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
JButton b1,b2,b3;
String scb1,scb2,scb3;
PreparedStatement pstmt=null;
Connection conn=null;
Statement stmt=null;
ResultSet rs;



	public void setup() {


            		 f=new JFrame("Manage Taxi Records");
                        
		
			 Icon i = new ImageIcon("D:\\Taxi Booking System\\images\\all.jpg");


			 Font ft=new Font("Elephant",Font.BOLD,30);			
			 Font ft1 = new Font("Normal ",Font.BOLD,20);

			 Color cc1=new Color(31,134,220);
			
		
		
	
//Labels..... 

			 l=new JLabel(" ");
                         l1=new JLabel("SEARCH       TAXI      RECORDS");
			 l2=new JLabel("ENTER TAXI ID :");
			 l3=new JLabel(" TAXI NO :");
			 l4=new JLabel("MODEL/TYPE :");
			 l5=new JLabel("PRICE :");
			 l6=new JLabel("REGISTRATION NO :");
			 l7=new JLabel("INSURANCE NO :");
			 l8=new JLabel("CAPACITY :");
			 l9=new JLabel("COLOR :");
			 l10=new JLabel("PRICE TYPE :");


			 l.setBounds(0,0,1360,720);
			 l1.setBounds(370,10,800,50);
			 l2.setBounds(200,150,100,30);
			 l3.setBounds(580,150,100,30);
			 l4.setBounds(940,150,100,30);
			 l5.setBounds(580,300,100,30);
			 l6.setBounds(940,450,150,30);
			 l7.setBounds(940,300,100,30);
			 l8.setBounds(200,450,100,30);
			 l9.setBounds(580,450,100,30);
			 l10.setBounds(200,300,100,30);

			
			 l1.setForeground(Color.YELLOW);
			 l2.setForeground(Color.WHITE);
			 l3.setForeground(Color.WHITE);
			 l4.setForeground(Color.WHITE); 
			 l5.setForeground(Color.WHITE);
			 l6.setForeground(Color.WHITE); 
			 l7.setForeground(Color.WHITE);
			 l8.setForeground(Color.WHITE);
			 l9.setForeground(Color.WHITE);
			 l10.setForeground(Color.WHITE); 

				
			 l.setIcon(i); 			
			 l1.setFont(ft);



                           
			
			 l.add(l1);
                         l.add(l2);
			 l.add(l3);
			 l.add(l4);
			 l.add(l5); 
			 l.add(l6);
			 l.add(l7); 
			 l.add(l8);
			 l.add(l9); 
			 l.add(l10);
			
			 f.add(l);

                      
//Text Fields........                      		
				
				
                        t1=new JTextField( );
			t2=new JTextField( );
			t3=new JTextField( );
			t4=new JTextField( );
			t5=new JTextField( );
			t6=new JTextField( );
			t7=new JTextField( );
			t8=new JTextField( );
	
                        t1.setBounds(200,180,240,30);
			t2.setBounds(580,180,240,30);
			t4.setBounds(580,330,240,30);
			t5.setBounds(940,480,240,30);
			t6.setBounds(940,330,240,30);
			t7.setBounds(200,480,240,30);
			t8.setBounds(200,330,240,30);
			
			t2.setEditable(false);
			t3.setEditable(false);
			t4.setEditable(false);
			t5.setEditable(false);
			t6.setEditable(false);
			t7.setEditable(false);
			t8.setEditable(false);

				l.add(t1);
				l.add(t2);                 
               	                l.add(t4); 
				l.add(t5);
				l.add(t6);
				l.add(t7);
				l.add(t8);
				
                                 
//ComboBox.......				
			 
                 	
			 cb1 = new JComboBox();
			 cb2 = new JComboBox();		

			

        		   
       			 cb1.setBounds(940,180,240,30);
			 cb2.setBounds(580,480,240,30);


    
        		l.add(cb1);	
			l.add(cb2);
       			
        		    

			
//Buttons.........
			
       			
	
                 
		          b1=new JButton("SEARCH");
			  b1.setMnemonic((int)'S');
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
					t4.setText(" ");
					t5.setText(" ");
					t6.setText(" ");
					t7.setText(" ");
					t8.setText(" ");					
					cb1.removeAllItems();
					cb2.removeAllItems();
								
												
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
			 q="select * from Taxi ";
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
						  stmt=conn.createStatement();
						 String q;
						 String jk ="where TaxiID ="+t1.getText();
						 q="select TaxiID,TaxiNo,Model,Price,PTYPE,RegistrationNo,InsuranceNo,Capacity,Color from Taxi " + jk;
						 rs=stmt.executeQuery(q);
						 if(rs.next())
							{
							
							
						 	 String tid=rs.getString(1);
							 String tno=rs.getString(2);
							 String model=rs.getString(3);
							 String price=rs.getString(4);														 String pt=rs.getString(5);

							
							
							 String regno=rs.getString(6);
							 String insno=rs.getString(7);
							 String cpt=rs.getString(8);
							 String color=rs.getString(9);
							 
							
							t1.setText(tid);
						 	t2.setText(tno);
							cb1.addItem(model);	 	
							t4.setText(price);
						 	t5.setText(regno);
						 	t6.setText(insno); 
							t7.setText(cpt);
						 	cb2.addItem(color);
							if(pt.equals("1")){

								t8.setText("1 KM");
								
								}
							else if(pt.equals("0")){
											
								t8.setText("1 Day");

								}
							else{}



							}
						 else
							{
							 JOptionPane.showMessageDialog(this,"Sorry Record not found");
							 t1.setText(" ");
						 	
							
							 try
								{
								 conn.close();
								}
							 catch(Exception j)
								{
								 System.out.println(j);
								}
						 	}		 
						}
						catch(Exception ex1)
						{
						//JOptionPane.showMessageDialog(this,"Data Searching Faild");
						ex1.printStackTrace();
						 
						}
				
					}
			
				
					
				
			}
			


public static void main(String args[])
	{
	SearchTaxibyId t=new  SearchTaxibyId();
	t.setup();
	}
}     	 
                      


      
  