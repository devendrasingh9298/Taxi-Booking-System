import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class Booking extends JFrame implements ActionListener
{
JFrame f;
String str,scb1,scb2;
JComboBox cb1,cb2;
CheckboxGroup cbg;
Checkbox c1,c2,c3;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19;
PreparedStatement pstmt=null;
Connection conn=null;
Statement stmt=null;
ResultSet rs;
JButton b1,b2,b3,b4;


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

	Booking()
           {
             f=new JFrame("Manage Booking Records");
                      
		
		Icon i = new ImageIcon("D:\\Taxi Booking System\\images\\all.jpg");	
		l=new JLabel(" ");
		l.setBounds(0,0,1360,720);
		f.add(l);
		l.setIcon(i);
		Font ft=new Font("Normal",Font.BOLD,40);
		Font ft1 = new Font("Normal ",Font.BOLD,20);

		Color cc1=new Color(31,134,220);
			
	
//Labels.....

                   l1=new JLabel("Manage    Booking    Records");
		   l2=new JLabel("CLIENT NAME :");
		   l3=new JLabel(" SOURCE :");
		   l4=new JLabel("DESTINATION :");
		   l5=new JLabel("BOOKING DATE :");                   
		   l6=new JLabel("BOOKING TYPE:");
                   l7=new JLabel("DAY/KM :");
                   l8=new JLabel("TAXI ID :");              
		   l9=new JLabel("TAXI NUMBER :");                   
		   l10=new JLabel("MODEL :");
                   l11=new JLabel("PRICE TYPE :");
                   l12=new JLabel("PRICE :");
                   l13=new JLabel("CAPACITY :");
                   l14=new JLabel("DRIVER ID :");
                   l15=new JLabel("DRIVER NAME :");
                   l16=new JLabel("DRIVER PHONE NO :");              
		   l17=new JLabel("TOTAL PRICE :");
		   l18=new JLabel("CLIENT MOBILE NO :");
                   l19=new JLabel("I agree to submit details .");              
			

                   

	           l1.setBounds(400,10,600,50);
		   l2.setBounds(200,100,100,30);
		   l3.setBounds(580,100,100,30);
		   l4.setBounds(940,100,100,30);
		   l5.setBounds(200,180,100,30);
		   l6.setBounds(580,180,100,30);
		   l7.setBounds(940,180,100,30);		   
                   l8.setBounds(200,260,100,30);              
		   l9.setBounds(580,260,100,30);		
		   l10.setBounds(940,260,100,30);		
		   l11.setBounds(200,340,100,30);
		   l12.setBounds(580,340,100,30);
		   l13.setBounds(940,340,100,30);
		   l14.setBounds(200,420,100,30);
		   l15.setBounds(580,420,100,30);
		   l16.setBounds(940,420,150,30);
		   l17.setBounds(580,500,100,30);
		   l18.setBounds(200,500,200,30);
		   l19.setBounds(220,570,200,30);


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
		   l11.setForeground(Color.WHITE);	
		   l12.setForeground(Color.WHITE);	
		   l13.setForeground(Color.WHITE);	
		   l14.setForeground(Color.WHITE);	
		   l15.setForeground(Color.WHITE);                                
		   l16.setForeground(Color.WHITE);						
		   l17.setForeground(Color.WHITE);			
		   l18.setForeground(Color.WHITE);			
		   l19.setForeground(Color.WHITE);


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
		   l.add(l11);
		   l.add(l12);
		   l.add(l13);
		   l.add(l14);
		   l.add(l15);
		   l.add(l16);	
		   l.add(l17);
		   l.add(l18);
		   l.add(l19);
                       
	  	   l1.setFont(ft);
		   

                       
                       		
//TextFields......				
				
                    t1=new JTextField( );
		    t2=new JTextField( );
		    t3=new JTextField( );
		    t4=new JTextField( );
		    t5=new JTextField( );
		    t6=new JTextField( );
                    t7=new JTextField( );
                    t8=new JTextField( );                   
		    t9=new JTextField( );
		    t10=new JTextField( );
		    t11=new JTextField( );
	            t12=new JTextField( );
    		    t13=new JTextField( );
		    t14=new JTextField( );

			
			t6.setEditable(false);
			t7.setEditable(false);
			t8.setEditable(false);
			t9.setEditable(false);
			t10.setEditable(false);
			t11.setEditable(false);
			t12.setEditable(false);
			t13.setEditable(false);
					
                    t1.setBounds(200,130,200,30);
		    t2.setBounds(580,130,200,30);
		    t3.setBounds(940,130,200,30);   
		    t4.setBounds(200,210,200,30);
		    t5.setBounds(940,210,200,30);
		    t6.setBounds(580,290,200,30);
		    t7.setBounds(940,290,200,30);
		    t8.setBounds(200,370,200,30);
		    t9.setBounds(580,370,200,30);
		    t10.setBounds(940,370,200,30);
		    t11.setBounds(580,450,200,30);
		    t12.setBounds(940,450,200,30);
		    t13.setBounds(580,530,200,30);
		    t14.setBounds(200,530,200,30);


		    l.add(t1);
		    l.add(t2);		                 
		    l.add(t3); 
                    l.add(t4);	
                    l.add(t5);             
		    l.add(t6);	
		    l.add(t7);   
	   	    l.add(t8);
		    l.add(t9);	
		    l.add(t10);	
		    l.add(t11);
		    l.add(t12);			
		    l.add(t13);	
		    l.add(t14);	

//CheckBox......

		 
                 
			 cbg = new CheckboxGroup(); 
 
        		 c1 = new Checkbox("Day", cbg, false); 
			 c2 = new Checkbox("KM", cbg, false);  
			 c3 = new Checkbox();  

  

			c1.addItemListener(new ItemListener()
			{  
				public void itemStateChanged(ItemEvent ie)
				{
				str="Day";
				}
			}
			);
  
			
			 c2.addItemListener(new ItemListener()
			 {  
           		 public void itemStateChanged(ItemEvent e)
				 {  
				 str="KM"; 			        
              			 }  
       			  });  
  
			 c3.addItemListener(new ItemListener()
			 {  
           		 public void itemStateChanged(ItemEvent e)
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
								{JOptionPane.showMessageDialog(null,"Taxi not Available");
									b1.setEnabled(false);
									}
																
								
								}
								else{JOptionPane.showMessageDialog(null,"Taxi Available");
								b1.setEnabled(true);
								}
								
								
						
								
					 
						}
						catch(Exception ex1)
						{
						//JOptionPane.showMessageDialog(this,"Data Searching Faild");
						ex1.printStackTrace();
						 
						}
				 			        
              			 }  
       			  });  

   
        		 c1.setBounds(580,210,90,30);
			 c2.setBounds(690,210,90,30);  
			 c3.setBounds(200,580,10,10);  
           		   
        		l.add(c1);    
        		l.add(c2);   
			l.add(c3);



//JComboBox.....



		cb1=new JComboBox();
		cb2=new JComboBox();


		cb1.setBounds(200,290,200,30);
		cb2.setBounds(200,450,200,30);



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
		    
		cb1.addItemListener(new ItemListener()
			{  
				public void itemStateChanged(ItemEvent ie)
				{
				
				
				
			
		try{
			connect();
			scb1 = String.valueOf(cb1.getSelectedItem());
			stmt=conn.createStatement();
	
			String s= "Select TaxiNo,Model,Price,PTYPE,Capacity From Taxi where TaxiID="+scb1;

			rs=stmt.executeQuery(s);
	
			while(rs.next())
				{
								
				t6.setText(rs.getString(1));
				t7.setText(rs.getString(2));
				String pt=rs.getString(4);				
				t9.setText(rs.getString(3));
				t10.setText(rs.getString(5));
				
				if(pt.equals("1")){

								t8.setText("Day");
																
								}
				else if(pt.equals("0")){
											
								t8.setText("KM");
								

								}
							else{}
					
				}
			}catch(Exception ee){
				System.out.println(ee);}
			
			
				}
			});
	
		
	
		cb2.addItemListener(new ItemListener()
			{  
				public void itemStateChanged(ItemEvent ie)
				{
					try{
			connect();
			scb2 = String.valueOf(cb2.getSelectedItem());
			stmt=conn.createStatement();
	
			String s= "Select Name,PhoneNo From Driver where DriverID="+scb2;

			rs=stmt.executeQuery(s);
	
			while(rs.next())
				{
								
				t11.setText(rs.getString(1));
				t12.setText(rs.getString(2));
					
				}
			}catch(Exception ee){
				System.out.println(ee);}
			
				}
			
			});

		        
//Buttons......


                 
		   b1=new JButton("BOOKING");
		   b2=new JButton("CLEAR");
		   b3=new JButton("Back to Main");
		   b4=new JButton("Total");


		   b1.setMnemonic((int)'S');
		   b2.setMnemonic((int)'C');
		   b3.setMnemonic((int)'B');
		   b4.setMnemonic((int)'T');


                   b1.setBounds(200,630,330,30);
		   b2.setBounds(840,630,300,30);
		   b3.setBounds(530,630,310,30);
		   b4.setBounds(800,530,100,30);

	                 
			                      
		   
                   b1.setForeground(Color.YELLOW);
		   b2.setForeground(Color.YELLOW);	
		   b3.setForeground(Color.YELLOW);
		   b4.setForeground(Color.YELLOW);

		   b1.setBackground(cc1);
		   b2.setBackground(cc1);
		   b3.setBackground(cc1);
		   b4.setBackground(cc1);
		
		   b1.setFont(ft1);
		   b2.setFont(ft1);
		   b3.setFont(ft1);               
		   b4.setFont(ft1); 	                  

		   l.add(b1);
                   l.add(b2);
                   l.add(b3);
		   l.add(b4);

		b1.setEnabled(false);
				
                                  
		 b2.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent ae)
					{
					
					t1.setText(" ");
					t2.setText(" ");
					t3.setText(" ");
					t4.setText(" ");
					t5.setText(" ");
					t6.setText(" ");
					t7.setText(" ");
					t8.setText(" ");
					t9.setText(" ");
					t10.setText(" ");
					t11.setText(" ");
					t12.setText(" ");
					t13.setText(" ");
					t14.setText(" ");
					c1.setState(false);
					c2.setState(false);
					c3.setState(false);
					b1.setEnabled(false);		
					}
				});

                      
                        	
			          
			
		 b3.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent ae1)
					{
					
					new Home().setup();
					f.setVisible(false);
					}
				});

		
		
			
                      
		    	
                   	
		  b1.addActionListener(this);
		 b4.addActionListener(this);

		  f.setBounds(5,5,1360,720);
                  f.setVisible(true);
                  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                       
		
		 }



 
//Methods for update1
	public void update1()
		{
		 try
			{
			 stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			 String q;
			 q="select * from Booking ";
			 rs=stmt.executeQuery(q);
			 rs.last();
			 }
		 catch(Exception es)
			{
			 JOptionPane.showMessageDialog(this,"Unable to update no. of rows");
			 
			}
		}
		
//Methods for Actionperformed
		public void actionPerformed(ActionEvent e){		

		
			
				if(e.getSource().equals(b1))
					{
					 	try
						{
						 connect();
						 String bid=t1.getText();
						 String source=t2.getText();
						 String destination=t3.getText();
						 String date=t4.getText();
						 String type=t5.getText();
						 String tno=t6.getText();
						 String model=t7.getText();
						 String ptype=t8.getText();
						 String price=t9.getText();
						 String capacity=t10.getText();
						 String dname=t11.getText();
						 String pno=t12.getText();
						 String total=t13.getText();
						 String cmno=t14.getText();


pstmt=conn.prepareStatement("insert into Booking(BNAME,SOURCE,DESTINATION,BDATE,BTYPE,TYPE,TID,TNO,MODEL,PTYPE,PRICE,CAPACITY,DID,DNAME,PNO,TOTAL,CMNO) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
							
						pstmt.setString(1,bid);
						pstmt.setString(2,source);
						pstmt.setString(3,destination);
						pstmt.setString(4,date);
						pstmt.setString(5,str);
						pstmt.setString(6,type);
						pstmt.setString(7,scb1);														pstmt.setString(8,tno);
						pstmt.setString(9,model);
						pstmt.setString(10,ptype);
						pstmt.setString(11,price);
						pstmt.setString(12,capacity);
						pstmt.setString(13,scb2);
						pstmt.setString(14,dname);														pstmt.setString(15,pno);
						pstmt.setString(16,total); 	
						pstmt.setString(17,cmno);

						pstmt.executeUpdate();

						JOptionPane.showMessageDialog(this,"Data Inserted Successfully");

						update1();

					
													
						t1.setText(" ");
						t2.setText(" ");									t3.setText(" ");
						t4.setText(" ");
						t5.setText(" "); 
						t6.setText(" ");
						t7.setText(" ");
						t8.setText(" ");									t9.setText(" ");
						t10.setText(" ");
						t11.setText(" "); 
						t12.setText(" ");
						t13.setText(" ");								 							t14.setText(" ");								
						 						 
						}
						catch(Exception ex)
						{
						JOptionPane.showMessageDialog(null,"Data Inserted Faild");
						//ex.printStackTrace();
						 
						}
				
					}
				String s1=t5.getText();
				String s2=t9.getText();

			
				final float x=Float.parseFloat(s1); 
				final float y=Float.parseFloat(s2); 
		
		if(e.getSource().equals(b4))
					{
					float z=x*y;
			    		t13.setText(""+z);
					}
				  


	}		
		

public static void main(String args[])
	{
	new Booking();
	}
}     	 
                      


      
  