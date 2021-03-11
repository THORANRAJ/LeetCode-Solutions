package thorproj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.mysql.cj.xdevapi.Statement;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.components.JSpinField;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JCalendar;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class maint extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField;
	private JComboBox comboBox;
	private JTextField textField_1;
	private JTextField textField_2;
	public JComboBox comboBox_2;
	private JComboBox SelectColor;
	private JComboBox Selectword; 
	private JComboBox comboBox_3;
	private String ftype;
	int num1,num2,pr=35000,pr1=25000,ans,ans1,tot;
	public String ac,nonac,total;
	int ac1=10000;
	int nonac1=5000;
	//public veg=10000;
	double temp,temp1;
	Connection con=null;
	PreparedStatement pst=null;
	private JTextField textField_3;
	

	/**
	 * Launch the application.
	 */
	private String dates[] ={
		"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"
		,"21","22","23","24","25","26","27","28","29","30","31"
		
		
	};
	private String mon[]= {
			"jan","feb","march","april","may","june","july","august","sept","oct","november","december"
			
	};
	private String year[]= {
           "2020","2021","2022"			
	};
	private JTextField textField_4;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					maint frame = new maint();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
   
	
	public void rannumb()
	{
		Random ran =new Random();
		int n=ran.nextInt(1000)+1;
	    String val=String.valueOf(n);
	    textField.setText(val);
	}
	public void rannumb1()
	{
		Random ran =new Random();
		int n=ran.nextInt(10000)+1;
	    String val=String.valueOf(n);
	    textField_3.setText(val);
	}
	
	
	public maint() {
		//initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1143, 882);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO CRUISE BOOKING");
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setBackground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("YouYuan", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel.setBounds(305, 10, 488, 54);
		contentPane.add(lblNewLabel);
	//	Image img =new ImageIcon(this.getClass().getResource("/sky2.png")).getImage();
		
		JLabel lblNewLabel_2 = new JLabel("BOOK YOUR TICKET");
		lblNewLabel_2.setForeground(Color.white);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_2.setBounds(50, 67, 248, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("from:");
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(129, 202, 150, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("to:");
		lblNewLabel_3.setForeground(Color.white);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(383, 205, 144, 25);
		contentPane.add(lblNewLabel_3);
		
		JList list = new JList();
		list.setBounds(148, 223, 68, -15);
		contentPane.add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("select");
		comboBox.addItem("india");
		comboBox.addItem("uk");
		comboBox.addItem("singapore");
		comboBox.addItem("china");
		//comboBox.addActionListener(new ActionListener() {
			
		comboBox.setBounds(191, 269, 107, 30);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("select");
		comboBox_1.addItem("usa");
		comboBox_1.addItem("spain");
		comboBox_1.addItem("france");
		comboBox_1.addItem("netherlands");
		comboBox_1.setBounds(382, 269, 107, 30);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_4 = new JLabel("date:");
		lblNewLabel_4.setForeground(Color.white);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(129, 343, 107, 38);
		contentPane.add(lblNewLabel_4);
		
		/*JCalendar calendar = new JCalendar();
		calendar.setBounds(305, 273, 184, 138);
		contentPane.add(calendar);
		*/
		JLabel lblNewLabel_5 = new JLabel("Adults:");
		lblNewLabel_5.setForeground(Color.white);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(129, 458, 87, 38);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("kids:");
		lblNewLabel_6.setForeground(Color.white);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(323, 463, 107, 28);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("BOOK YOUR ROOM");
		lblNewLabel_7.setForeground(Color.white);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_7.setBounds(594, 59, 272, 54);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Room type:");
		lblNewLabel_8.setForeground(Color.white);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(697, 174, 107, 38);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("food item:");
		lblNewLabel_9.setForeground(Color.white);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9.setBounds(697, 311, 87, 30);
		contentPane.add(lblNewLabel_9);
		JComboBox comboBox_2 = new JComboBox();
		//comboBox_2.addItem("select");
		comboBox_2 .addItem("AC");
		comboBox_2 .addItem("NON AC");
		//comboBox_2.setBounds(854, 210, 107, 21);
		comboBox_2.setBounds(803, 185, 108, 21);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_4 = new JComboBox(dates);
		comboBox_4.setBounds(191, 354, 46, 21);
		contentPane.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox(mon);
		comboBox_5.setBounds(250, 354, 68, 21);
		contentPane.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox(year);
		comboBox_6.setBounds(338, 354, 77, 21);
		contentPane.add(comboBox_6);
		
		JLabel lblNewLabel_10 = new JLabel("Room no:");
		lblNewLabel_10.setForeground(Color.white);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_10.setBounds(697, 240, 96, 30);
		contentPane.add(lblNewLabel_10);
		
		textField = new JTextField();
		textField.setBounds(803, 246, 112, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField_1.setBounds(191, 470, 107, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(382, 470, 107, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("VEG");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ftype="veg";
			}
		});
		rdbtnNewRadioButton_2.setBounds(803, 318, 77, 21);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("NON VEG");
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ftype="non veg";
				
			}
		});
		rdbtnNewRadioButton_3.setBounds(888, 318, 85, 21);
		contentPane.add(rdbtnNewRadioButton_3);
		
		
		JLabel lblNewLabel_11 = new JLabel("ref no:");
		lblNewLabel_11.setForeground(Color.white);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_11.setBounds(129, 133, 87, 30);
		contentPane.add(lblNewLabel_11);
		
		textField_3 = new JTextField();
		textField_3.setBounds(191, 141, 107, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Continue!!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//thor();
			try {	
				
				if(Integer.parseInt(textField_1.getText())>5)
				{
					JOptionPane.showMessageDialog(null, "sorry invalid input!");
					// frame.dispose();
					System.exit(0);
				}
				if(Integer.parseInt(textField_2.getText())>5)
				{
					JOptionPane.showMessageDialog(null, "sorry you reached maximum!!");
					System.exit(0);
				}
			}
			catch(Exception el)
			{
				JOptionPane.showMessageDialog(null, el);
			}
				
			
			
			   if(comboBox_4.getSelectedItem().toString()=="30"||comboBox_4.getSelectedItem().toString()=="31"&&comboBox_5.getSelectedItem().toString()=="feb")
				{
					JOptionPane.showMessageDialog(null, "sorry invalid date format");
					System.exit(0);
				}
				if(comboBox_4.getSelectedItem().toString()=="31"&&comboBox_5.getSelectedItem().toString()=="april"||comboBox_5.getSelectedItem().toString()=="june"||comboBox_5.getSelectedItem().toString()=="sept"||comboBox_5.getSelectedItem().toString()=="november")
				{
					JOptionPane.showMessageDialog(null, "sorry invalid date format");
					System.exit(0);
				}
							
							
						
				
				
				try
				{
					String query="INSERT INTO `book`(`refno`,`form`,`tot`,`day`,`mon`,`yer`,`adults`,`kids`,`rtype`,`roomno`,`food`) values (?,?,?,?,?,?,?,?,?,?,?)";
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","thorisagood");
					 pst=con.prepareStatement(query);
					 pst.setString(1, textField_3.getText());
					 pst.setString(2,comboBox.getSelectedItem().toString());
					 pst.setString(3,comboBox_1.getSelectedItem().toString());
					 pst.setString(4,comboBox_4.getSelectedItem().toString());
					 pst.setString(5,comboBox_5.getSelectedItem().toString());
					 pst.setString(6,comboBox_6.getSelectedItem().toString());
					 pst.setString(7, textField_1.getText());
					 pst.setString(8, textField_2.getText());
					 pst.setString(9, comboBox_2.getSelectedItem().toString());
					 pst.setString(10, textField.getText());
					 pst.setString(11,ftype);
					 pst.executeUpdate();
					 
					 JOptionPane.showMessageDialog(null, "proceed to pay!");
				}
				catch(Exception ey)
				{
					JOptionPane.showMessageDialog(null, ey);
				}
				String msg=textField_3.getText();
			    // new price(msg).setVisible(true);
				try 
				{
				    num1=Integer.parseInt(textField_1.getText());
				    num2=Integer.parseInt(textField_2.getText());
				    ans=num1*pr;
				    ans1=num2*pr1;
				    tot=ans+ans1;
				
				    ac=String.valueOf(tot+ac1);
				    nonac=String.valueOf(tot+nonac1);
				  
				    if(comboBox_2.getSelectedItem().equals("AC"))
			     	{
				    	total=ac;
				    	temp=tot+ac1;
					  //textField_4.setText(total);
					  price obj1=new price(total,"20000","5",temp,msg);
					  obj1.setVisible(true);
			
				     }
			        if(comboBox_2.getSelectedItem().equals("NON AC"))
			        {
			        	total=nonac;
			        	temp=tot+nonac1;
			        	//textField_4.setText(total);
			        	 price obj1=new price(total,"20000","5",temp,msg);
						 obj1.setVisible(true);
			        	
			        }
			        price obj2=new price(total,"20000","5",temp,msg);
					 obj2.setVisible(true);
		        	
					 double dis;
			        temp=temp+20000;
			        temp1=temp;
			        dis=temp1*0.05;
			        temp=temp-dis;
			        price obj3=new price(total,"20000","5",temp,msg);
					 obj3.setVisible(true);

				}
				catch(Exception et)
				{
					 JOptionPane.showMessageDialog(null, et);
					 et.printStackTrace();
				}
			  // price frame = new price();
				//frame.setVisible(true);
			
				maint.this.dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(435, 608, 286, 44);
		contentPane.add(btnNewButton);
		

		

		JButton btnNewButton_1 = new JButton("Ticket Status");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maint.this.dispose();	
				display frame = new display();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(945, 41, 150, 26);
		contentPane.add(btnNewButton_1);
		
		
		JLabel lblNewLabel_12 = new JLabel("");
		Image img =new ImageIcon(this.getClass().getResource("/luxury.jpg")).getImage();
		lblNewLabel_12.setIcon(new ImageIcon(img));
		lblNewLabel_12.setBounds(0, 0, 1129, 767);
		contentPane.add(lblNewLabel_12);
		
		
			
		rannumb();
		rannumb1();
		
		//thor();
	}
}




/*	splash obj=new splash();
obj.setVisible(true);
try {
	for(int i=0;i<=100;i++)
	{
		Thread.sleep(40);
		
		
	}
	price frame = new price();
	frame.setVisible(true);
	obj.dispose();
	maint.this.dispose();
}
catch(Exception et)
{
	
}*/
