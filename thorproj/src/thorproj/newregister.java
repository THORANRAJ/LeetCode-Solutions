package thorproj;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.mysql.cj.xdevapi.Statement;

//import com.sun.jdi.connect.spi.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
public class newregister extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	Connection con=null;
	PreparedStatement pst=null;
	private JTextField textField_4;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newregister frame = new newregister();
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
		int n=ran.nextInt(100000)+1;
	    String val=String.valueOf(n);
	    textField_4.setText(val);
	}

	/**
	 * Create the frame.
	 */
	public newregister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 775);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(121, 177, 107, 34);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(263, 182, 152, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("phone number:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(121, 240, 124, 29);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(263, 242, 152, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("username:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(121, 359, 124, 29);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(263, 359, 152, 34);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("password:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(121, 424, 107, 34);
		contentPane.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(263, 429, 152, 29);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
		//	Connection con=null;
			//Statement st=null;
			public void actionPerformed(ActionEvent e) {
              /* try {
				if(Integer.parseInt(textField_1.getText())>='A'||Integer.parseInt(textField_1.getText())<='Z'||Integer.parseInt(textField_1.getText())<='a'||Integer.parseInt(textField_1.getText())<='z')
				{
					JOptionPane.showMessageDialog(null, "sorry invalid input!");
					// frame.dispose();
					System.exit(0);
				}
               }
               catch(Exception eu)
               {
            	   JOptionPane.showMessageDialog(null,eu);
               }
				*/
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","thorisagood");
			  String query="insert into login1(name,phno,uname,password,email,regno) values(?,?,?,?,?,?) ";	
			  
			 PreparedStatement pst=con.prepareStatement(query);
			  pst.setString(1, textField.getText());
			  pst.setString(2, textField_1.getText());
			  pst.setString(3, textField_2.getText());
			  pst.setString(4, passwordField.getText());
			  pst.setString(5, textField_3.getText());
			  pst.setString(6, textField_4.getText());
			  
			  pst.executeUpdate();
				
				/*con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","thorisagood");
				 String query="insert into login(name,phno,uname,password,email) values(textField.getName(),textField_1.getName(),textField_2.getName(),passwordField.getName(), textField_3.getName()");
				st=con.createStatement();
				st.execute(query);*/
				
			  JOptionPane.showMessageDialog(null, "added sucessfully!!");
			  rannumb();
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, ex);
			}
			
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(415, 485, 124, 34);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("NEW ACCOUNT");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_4.setBounds(449, 0, 408, 65);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("email address:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(121, 300, 124, 29);
		contentPane.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(263, 300, 152, 34);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 =new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//frame.dispose();
				//frame.dispose();
         	   //gui obj1=new gui();
         	   //obj1.setVisible(true);
			System.exit(0);
	}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(595, 487, 107, 30);
		contentPane.add(btnNewButton_1);
	//	Image img =new ImageIcon(this.getClass().getResource("/sky2.png")).getImage();
		
		JLabel lblNewLabel_7 = new JLabel("Reg no:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(121, 118, 107, 34);
		contentPane.add(lblNewLabel_7);
		
		textField_4 = new JTextField();
		textField_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Random ran =new Random();
				//int n=random.nextInt(100000)+1;
				//String val=String.valueOf(n);
				//textField_4.setText(val);
				//contentPane.add(n);
				//rannumb();
				
			}
		});
		
		textField_4.setBounds(263, 123, 152, 29);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("<--");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//gui obj=new gui();
			   // obj.setVisible(true);
				newregister.this.dispose();
				gui window = new gui();
				window.frame.setVisible(true);
				//frame.dispose();
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 27));
		btnNewButton_2.setBounds(10, 14, 100, 34);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		Image img =new ImageIcon(this.getClass().getResource("/sky2.png")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img));
		lblNewLabel_6.setBounds(0, 0, 878, 738);
		contentPane.add(lblNewLabel_6);
		
		
		rannumb();
		//Image img =new ImageIcon(this.getClass().getResource("/ne.jpg")).getImage();
	}
}
