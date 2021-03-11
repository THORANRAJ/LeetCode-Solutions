package thorproj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class price extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	Connection con=null;
	PreparedStatement pst=null;
	private JTextField textField_4;
	String msg1,msg2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					price frame = new price("0","0","5",0,"0");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public  price(String p1,String p2,String p3,double p4,String p6) {
		//textField.setText(p1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1007, 553);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tickets and Room Bill");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(407, 47, 310, 69);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ticket amount:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(112, 195, 124, 33);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            /*  maint frame1 = new maint();
              textField.setText(frame1.total);*/
			}
		});
		textField.setBounds(238, 202, 124, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Room amount:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(112, 265, 124, 33);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(238, 272, 124, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Discount%:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(113, 353, 123, 33);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(238, 353, 124, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Total amount:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(513, 229, 116, 40);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(634, 231, 135, 33);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		JLabel lblNewLabel_5 = new JLabel("Refno:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(112, 134, 124, 33);
		contentPane.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(239, 139, 123, 28);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		

		JButton btnNewButton_2 = new JButton("Total");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 //maint frame1 = new maint();
	              //textField.setText(frame1.total);
	              //System.out.println(frame1.ac1);
			//	price();
				textField.setText(p1);
				textField_1.setText(p2);
				textField_2.setText(p3);
				String p5=Double.toString(p4);
				textField_3.setText(p5);
				textField_4.setText(p6);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(584, 449, 116, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				
					String query="INSERT INTO `pric2`  (`price`,`refno`)values(?,?)";
					
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","thorisagood");
					 pst=con.prepareStatement(query);
					 pst.setString(1, textField_3.getText());
					 pst.setString(2, textField_4.getText());
					 pst.executeUpdate();

						
				}catch(Exception ey)
				{
					ey.printStackTrace();
				}
				msg1=textField_4.getText();
				msg2=textField_3 .getText();
				passenger frame = new passenger(msg1,msg2);
				frame.setVisible(true);
				//String msg3=
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(393, 449, 135, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				price.this.dispose();
				maint frame = new maint();
				frame.setVisible(true);
			}
			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(228, 451, 116, 33);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		Image img =new ImageIcon(this.getClass().getResource("/price.jpg")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img));
		lblNewLabel_6.setBounds(0, 0, 993, 516);
		contentPane.add(lblNewLabel_6);
		
	
	
	}
}
