import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;


class AddDriver extends JFrame implements ActionListener {

//define variables

JFrame f;
Container cn;
JPanel p1;
String str,str1;
JComboBox comb1;
CheckboxGroup cbg;
Checkbox cb1,cb2;
JTextArea t4;
JTextField t1,t2,t3,t5,t6,t7,t8,t9;
JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
PreparedStatement pstmt=null;
Connection conn=null;
Statement stmt=null;
ResultSet rs;
JButton b1,b2,b3,b4,b5,b6;


 AddDriver() {
		//DatePicker();

             	f=new JFrame("Manage Driver Records");
		Font ft=new Font("Normal",Font.BOLD,40);
		Icon i = new ImageIcon("D:\\Taxi Booking System\\images\\all.jpg");	
		Icon i1 = new ImageIcon("D:\\Taxi Booking System\\images\\im.jpg");	
//Labels........
		

		l=new JLabel(" ");
		l1=new JLabel("Manage    Driver    Records");		
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
        l13=new JLabel("PHOTOS :");  
		l14=new JLabel();    
		l15=new JLabel(i1);                 
									
			

		l.setBounds(0,0,1360,720);
		l1.setBounds(480,10,600,50);		
		l3.setBounds(200,140,100,20);
		l4.setBounds(580,140,100,20);
		l5.setBounds(200,240,130,20);
		l6.setBounds(580,240,100,20);
		l7.setBounds(940,440,100,20);
		l8.setBounds(200,340,100,20);		
		l9.setBounds(580,340,100,20);
		l10.setBounds(940,340,120,20);
		l11.setBounds(200,440,100,20);
		l12.setBounds(580,440,100,20);
		l13.setBounds(960,140,100,20);
		l14.setBounds(960,300,100,20);
		l15.setBounds(960,160,200,100);


		l1.setForeground(Color.YELLOW);		
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

		f.add(l);
		l.setIcon(i);
	

       
                       		
//Text Fields........				
				
                 t1=new JTextField( );		
		 t2=new JTextField( );
		 t3=new JTextField( );
		 t4=new JTextArea( );
                 t5=new JTextField( );
                 t6=new JTextField( );
                 t7=new JTextField( );
                 t8=new JTextField( );
                 t9=new JTextField( );                                    
		 
		

                 t1.setBounds(200,160,240,30);		
		 t2.setBounds(200,260,240,30);
		 t3.setBounds(580,260,240,30);
		 t4.setBounds(200,360,240,40);
		 t5.setBounds(580,360,240,30);
		 t6.setBounds(940,360,220,30);
		 t7.setBounds(200,460,240,30);
		 t8.setBounds(580,460,240,30);
		 t9.setBounds(940,460,240,30);
		 


		 l.add(t1);		
		 l.add(t2);		                 
		 l.add(t3);  
		 l.add(t4);
		 l.add(t5);
                 l.add(t6);    	
                 l.add(t7);                 
		 l.add(t8);   		  
		 l.add(t9); 
		
  		 
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
        		   
       		 comb1.setBounds(580,160,240,30);    


        	
 	       	 l.add(comb1);    		 
                      
                   
		   	
//Buttons.........		        
		
		Font ft1 = new Font("Normal ",Font.BOLD,20);

		Color cc=new Color(31,134,220);		
			
		
                 
		b1=new JButton("SAVE");
		b2=new JButton("CLEAR");
		b3=new JButton("Back to Main");
		b4=new JButton("Choose");
		b5=new JButton("select dob date");
		b6=new JButton("select doj date");



                b1.setBounds(200,600,330,30);
		b2.setBounds(860,600,330,30);
		b3.setBounds(530,600,330,30);
		b4.setBounds(960,260,200,30);
		b5.setBounds(440,460,30,30);
		b6.setBounds(1160,360,30,30);


		b1.setForeground(Color.YELLOW);
		b2.setForeground(Color.YELLOW);	
		b3.setForeground(Color.YELLOW);	
		b4.setForeground(Color.YELLOW);	
		b5.setForeground(Color.YELLOW);	
		b6.setForeground(Color.YELLOW);	
		
		b1.setMnemonic((int)'S');
		b2.setMnemonic((int)'C');
		b3.setMnemonic((int)'B');
		b4.setMnemonic((int)'h');

                
  		b1.setBackground(cc);
		b2.setBackground(cc);	                 
		b3.setBackground(cc);
		b4.setBackground(cc);
		b5.setBackground(cc);
		b6.setBackground(cc);


		b1.setFont(ft1);
		b2.setFont(ft1);
		b3.setFont(ft1); 
		b4.setFont(ft1); 
		b5.setFont(ft1);
		b6.setFont(ft1);	                      
			 
                                  
				
		b2.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent ae)
					{
					
					t1.setText(" ");									
					t3.setText(" ");
					t4.setText(" ");
					t5.setText(" ");
					t6.setText(" ");
					t7.setText(" ");
					t8.setText(" ");
					t9.setText(" ");					
					l14.setText(" ");
					l15.setIcon(ResizeImage(""));		
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
		 b4.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
        
          JFileChooser file = new JFileChooser();
          file.setCurrentDirectory(new File(System.getProperty("user.home")));
          //filter the files
          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
          file.addChoosableFileFilter(filter);
          int result = file.showSaveDialog(null);
           //if the user click on save in Jfilechooser
          if(result == JFileChooser.APPROVE_OPTION){
              File selectedFile = file.getSelectedFile();
              String path = selectedFile.getAbsolutePath();
              l15.setIcon(ResizeImage(path));
		l14.setText(selectedFile.getAbsolutePath());
          }
           //if the user click on save in Jfilechooser


          else if(result == JFileChooser.CANCEL_OPTION){
              System.out.println("No File Select");
          }
        }
    });


	b5.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent ae)
					{
					//new DatePicker();

					t7.setText(new DatePicker(f).setPickedDate());
					}
				});
			
	
	b6.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent ae)
					{
					t6.setText(new DatePicker(f).setPickedDate());
					}
				});
		    	
                l.add(b1);
                l.add(b2);
                l.add(b3);
		l.add(b4);
		l.add(b5);
		l.add(b6);
			
		b1.addActionListener(this);
		
		 f.setBounds(5,5,1360,720);
                 f.setVisible(true);
                 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 }

// Methode to resize imageIcon with the same size of a Jlabel
    public ImageIcon ResizeImage(String ImagePath)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(l15.getWidth(), l15.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
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
						 String name=t1.getText();
						 String pno=t2.getText();		 
				 		 String lno=t3.getText();				
						 String add=t4.getText();
						 String exp=t5.getText();
						 String doj=t6.getText();
				 		 String dob=t7.getText();
						 String bg=t8.getText();
						 String ano=t9.getText();
						
						
pstmt=conn.prepareStatement("insert into Driver (Name,Gender,PhoneNo,LicenceNo,Address,Experience,DateOfJoin,DateOfBirth,BloodGroup,AdharNo,PHOTOS) values(?,?,?,?,?,?,?,?,?,?,?)");
						 						pstmt.setString(1,name);
						 						pstmt.setString(2,str1);
						 						pstmt.setString(3,pno);
						 						pstmt.setString(4,lno);
						 						pstmt.setString(5,add);
							 					pstmt.setString(6,exp);	
												pstmt.setString(7,doj);
						 						pstmt.setString(8,dob);
						 						pstmt.setString(9,bg);
							 					pstmt.setString(10,ano);
												pstmt.setString(11,l14.getText());
												
						 						pstmt.executeUpdate();
						 		JOptionPane.showMessageDialog(this,"Data Inserted Successfully");
						 						update1();
						
							
						 						t1.setText(" ");
						 						t2.setText(" ");			
						 						t3.setText(" ");
						 						t4.setText(" ");
						 						t5.setText(" ");
												t6.setText(" ");
						 						t7.setText(" ");
						 						t8.setText(" ");
						 						t9.setText(" ");						
												l14.setText(" ");
												l15.setIcon(ResizeImage(""));	
						}
						catch(Exception ex)
						{
						 						JOptionPane.showMessageDialog(this,"Data Inserted Faild");
						ex.printStackTrace();
						 
						}
				
					}
			
				
					
				
			}

	


class DatePicker 
{
	//define variables
        int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
        int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        //create object of JLabel with alignment
        JLabel l = new JLabel("", JLabel.CENTER);
        //define variable
        String day = "";
        //declaration
        JDialog d;
        //create object of JButton
        JButton[] button = new JButton[49];
 
        public DatePicker(JFrame parent)//create constructor 
        {
        	//create object
                d = new JDialog();
                //set modal true
                d.setModal(true);
                //define string
                String[] header = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
                //create JPanel object and set layout
                JPanel p1 = new JPanel(new GridLayout(7, 7));
                //set size
                p1.setPreferredSize(new Dimension(430, 120));
                //for loop condition
                for (int x = 0; x < button.length; x++) 
                {		
                	//define variable
                        final int selection = x;
                        //create object of JButton
                        button[x] = new JButton();
                        //set focus painted false
                        button[x].setFocusPainted(false);
                        //set background colour
                        button[x].setBackground(Color.white);
                        //if loop condition
                        if (x > 6)
                        //add action listener
                        button[x].addActionListener(new ActionListener() 
                        {
                                 public void actionPerformed(ActionEvent ae) 
                                 {
                                       day = button[selection].getActionCommand();
                                       //call dispose() method
                                       d.dispose();
                                 }
                        });
                        if (x < 7)//if loop condition 
                        {
                                button[x].setText(header[x]);
                                //set fore ground colour
                                button[x].setForeground(Color.red);
                        }
                        p1.add(button[x]);//add button
                }
                //create JPanel object with grid layout
                JPanel p2 = new JPanel(new GridLayout(1, 3));
                
                //create object of button for previous month
                JButton previous = new JButton("<< Previous");
                //add action command
                previous.addActionListener(new ActionListener() 
                {
                        public void actionPerformed(ActionEvent ae) 
                        {
                            //decrement month by 1
                            month--;
                            //call method
                            displayDate();
                        }
                });
                p2.add(previous);//add button
                p2.add(l);//add label
                //create object of button for next month
                JButton next = new JButton("Next >>");
                //add action command
                next.addActionListener(new ActionListener()
                {
                        public void actionPerformed(ActionEvent ae) 
                        {
                             //increment month by 1
                             month++;
                             //call method
                            displayDate();
                        }
                });
                p2.add(next);// add next button
                //set border alignment
                d.add(p1, BorderLayout.CENTER);
                d.add(p2, BorderLayout.SOUTH);
                d.pack();
                //set location
                d.setLocationRelativeTo(parent);
                //call method
                displayDate();
                //set visible true
                d.setVisible(true);
        }
 
        public void displayDate() 
        {
        	for (int x = 7; x < button.length; x++)//for loop
        	button[x].setText("");//set text
      	        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");	
                //create object of SimpleDateFormat 
                java.util.Calendar cal = java.util.Calendar.getInstance();			
                //create object of java.util.Calendar 
        	cal.set(year, month, 1); //set year, month and date
         	//define variables
        	int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
        	int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
        	//condition
        	for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++)
        	//set text
        	button[x].setText("" + day);
        	l.setText(sdf.format(cal.getTime()));
        	//set title
        	d.setTitle("Date Picker");
        }
 
        public String setPickedDate() 
        {
        	//if condition
        	if (day.equals(""))
        		return day;
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.set(year, month, Integer.parseInt(day));
            return sdf.format(cal.getTime());
        }}

public static void main(String args[]){

	new AddDriver();
		
}

}     	 
                      


      
  