import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

class UpdateDriver extends JFrame implements ActionListener {

JFrame f;
Container cn;
JPanel p1;
String str,str1;
JComboBox comb1;
CheckboxGroup cbg;
Checkbox cb1,cb2;
JTextArea t10;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t11;
JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
PreparedStatement pstmt=null;
Connection conn=null;
Statement stmt=null;
ResultSet rs;
JButton b1,b2,b3,b4;


	UpdateDriver() {

             	f=new JFrame("Manage Driver Records");                     
                       
		Font ft=new Font("Normal",Font.BOLD,40);
		Icon i = new ImageIcon("D:\\Taxi Booking System\\images\\all.jpg");	
//Labels........
		

		l=new JLabel(" ");
		l1=new JLabel("Manage    Driver    Records");
		l2=new JLabel(" Driver ID :");
		l3=new JLabel(" NAME :");
		l4=new JLabel("GENDER :");
		l5=new JLabel("PHONE NO :");
		l6=new JLabel("LICENCE NO :");
		l7=new JLabel("ADHAR NO :");
		l8=new JLabel("ADDRESS :");
                l9=new JLabel("EXPERIENCE :");
                l10=new JLabel("DATE OF JOINING :");
                l11=new JLabel("Date of Birth :");
                l12=new JLabel("BLOOD GROUP :");
                l13=new JLabel("City :"); 
		l14=new JLabel();                  
									
			

		l.setBounds(0,0,1360,720);
		l1.setBounds(480,10,600,50);
		l2.setBounds(200,140,120,20);
		l3.setBounds(580,140,100,20);
		l4.setBounds(940,140,100,20);
		l5.setBounds(200,240,130,20);
		l6.setBounds(580,240,100,20);
		l7.setBounds(940,240,100,20);
		l8.setBounds(200,340,100,20);		
		l9.setBounds(580,340,100,20);
		l10.setBounds(940,340,120,20);
		l11.setBounds(200,440,100,20);
		l12.setBounds(580,440,100,20);
		l13.setBounds(940,440,100,20);
		l14.setBounds(1040,140,100,20);


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
		l.add(l11);
		l.add(l12);  
		l.add(l13);
		l.add(l14);


		f.add(l);
		l.setIcon(i);
	

       
                       		
//Text Fields........				
				
                 t1=new JTextField( );
		 t2=new JTextField( );
		 t3=new JTextField( );
		 t4=new JTextField( );
		 t5=new JTextField( );
                 t6=new JTextField( );
                 t7=new JTextField( );
                 t8=new JTextField( );
                 t9=new JTextField( );
                 t10=new JTextArea( );                                    
		 t11=new JTextField( );	
		

                 t1.setBounds(200,160,140,30);
		 t2.setBounds(580,160,240,30);
		 t3.setBounds(200,260,240,30);
		 t4.setBounds(580,260,240,30);
		 t5.setBounds(940,260,240,30);
		 t6.setBounds(200,360,240,40);
		 t7.setBounds(580,360,240,30);
		 t8.setBounds(940,360,240,30);
		 t9.setBounds(200,460,240,30);
		 t10.setBounds(580,460,240,30);
		 t11.setBounds(940,460,240,30);


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
  		 
//Combobox.......


		 String type[]={"select","Male","Female"};


		 comb1 = new JComboBox(type);


		 comb1.addItemListener(new ItemListener()
			{  
				public void itemStateChanged(ItemEvent ie)
				{
					str1 = String.valueOf(comb1.getSelectedItem());
				}
			}
			);
        		   
       		 comb1.setBounds(940,160,240,30);    


        	
 	       	 l.add(comb1);    		 
                      
                   
		   	
//Buttons.........		        
		
		Font ft1 = new Font("Normal ",Font.BOLD,15);
		Font ft2 = new Font("Normal ",Font.BOLD,20);

		Color cc=new Color(31,134,220);		
			
		
                 
		b1=new JButton("SHOW");
		b2=new JButton("CLEAR");
		b3=new JButton("Back to Main");
		b4=new JButton("UPDATE");


                b1.setBounds(360,160,80,30);
		b2.setBounds(860,600,330,30);
		b3.setBounds(530,600,330,30);
		b4.setBounds(200,600,330,30);

		b1.setForeground(Color.YELLOW);
		b2.setForeground(Color.YELLOW);	
		b3.setForeground(Color.YELLOW);	
		b4.setForeground(Color.YELLOW);	

		b1.setMnemonic((int)'S');
		b2.setMnemonic((int)'C');
		b3.setMnemonic((int)'B');
		b4.setMnemonic((int)'U');
                
  		b1.setBackground(cc);
		b2.setBackground(cc);	                 
		b3.setBackground(cc);
		b4.setBackground(cc);

		b1.setFont(ft1);
		b2.setFont(ft2);
		b3.setFont(ft2);  	                      
		b4.setFont(ft2);	 
                                  
				
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
		l.add(b4);

			
		b1.addActionListener(this);
		b4.addActionListener(this);
		
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
				 stmt=conn.createStatement();
						 String q;
						 String jk ="where DriverID ="+t1.getText();
						 q="select DriverID,Name,Gender,PhoneNo,LicenceNo,AdharNo,Address,Experience,DateOfJoin,DateOfBirth,BloodGroup,City from Driver " + jk;
						 rs=stmt.executeQuery(q);
						 if(rs.next())
							{
							
							
						 	 String id=rs.getString(1);
							 String name=rs.getString(2);
							 String gender=rs.getString(3);
							 String pno=rs.getString(4);														 String licno=rs.getString(5);	
							 String adno=rs.getString(6);
							 String add=rs.getString(7);
							 String exp=rs.getString(8);
							 String doj=rs.getString(9);
							 String dob=rs.getString(10);
							 String bg=rs.getString(11);
							 String city=rs.getString(12);
							 
							 
							
							t1.setText(id);
						 	t2.setText(name);
							l14.setText(gender);	 	
							t3.setText(pno);
						 	t4.setText(licno);
						 	t5.setText(adno); 
							t6.setText(add);
							t7.setText(exp);
						 	t8.setText(doj);
							t9.setText(dob);	 	
							t10.setText(bg);
						 	t11.setText(city);
						 	
							
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
						catch(Exception ex)
						{
						 	JOptionPane.showMessageDialog(this,"Data Searching Faild");
						ex.printStackTrace();
						 
						}
				
					}
			if(e.getSource().equals(b4))
					{

						try
						{
						 connect();						 
   					
						
pstmt=conn.prepareStatement("UPDATE Driver SET Name=?,Gender=?,PhoneNo=?,LicenceNo=?,AdharNo=?,Address=?,Experience=?,DateofJoin=?,DateofBirth=?,BloodGroup=?,City=? WHERE DriverId=?");
						 	
			
												pstmt.setString(12,t1.getText());
						 						pstmt.setString(1,t2.getText());
												pstmt.setString(2,str1); 
												pstmt.setString(3,t3.getText());														pstmt.setString(4,t4.getText());
						 						pstmt.setString(5,t5.getText());
												pstmt.setString(6,t6.getText());
						 						pstmt.setString(7,t7.getText());
							 					pstmt.setString(8,t8.getText());													pstmt.setString(9,t9.getText());													pstmt.setString(10,t10.getText());												pstmt.setString(11,t11.getText());
						 						
						 						
						 						pstmt.executeUpdate();
						 	JOptionPane.showMessageDialog(this,"Data Updated Successfully");
						 						update1();
						
							
						 						t1.setText(" ");
						 						t2.setText(" ");		 													t3.setText(" "); 
						 						t4.setText(" ");
						 						t5.setText(" ");
						 						t6.setText(" ");
												t7.setText(" ");			 												t8.setText(" "); 
												t9.setText(" ");
												t10.setText(" "); 
												t11.setText(" "); 
 
						 						 
						}
						catch(Exception ex)
						{
						 		JOptionPane.showMessageDialog(this,"Data Updated Faild");
						ex.printStackTrace();
						 
						}
				
					}
				
						
			
				
					
				
			}
			

}     	 
                      


      
  