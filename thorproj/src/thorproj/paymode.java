package thorproj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class paymode extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	Connection con=null;
	PreparedStatement pst=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					paymode frame = new paymode("0","0");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private String mon[]= {
			"jan","feb","march","april","may","june","july","august","sept","oct","november","december"
			
	};
	private String year[]= {
	           "2020","2021","2022","2023","2024","2025","2026"		
		};
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public paymode(String p1,String p2) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1041, 585);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Pay by Debit card/Credit Card");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(25, 38, 453, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Card Number: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(25, 126, 127, 35);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(161, 131, 406, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Expires on:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(25, 202, 127, 29);
		contentPane.add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Rember my card  for future purchases");
		chckbxNewCheckBox.setBounds(179, 408, 283, 21);
		contentPane.add(chckbxNewCheckBox);
		
		JComboBox comboBox = new JComboBox(mon);
		comboBox.setBounds(161, 208, 104, 21);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(year);
		comboBox_1.setBounds(275, 208, 104, 21);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_3 = new JLabel("cvv:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(385, 202, 59, 29);
		contentPane.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(431, 204, 136, 30);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel("Name on card:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(25, 268, 127, 29);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(161, 272, 406, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Email Address:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(25, 330, 127, 29);
		contentPane.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(161, 334, 406, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	
		textField_1 = new JTextField();
		textField_1.setBounds(873, 52, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Pay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedItem().toString()=="jan"||comboBox.getSelectedItem().toString()=="feb"||comboBox.getSelectedItem().toString()=="march"&&comboBox_1.getSelectedItem().toString()=="2020")
				{
						JOptionPane.showMessageDialog(null, "sorry your card has expired :(");					
						
				}
				textField_1.setText(p1);
				try {
					
					String query="INSERT INTO `pay`(`cardno`,`month`,`year`,`cvv`,`name`,`email`,`refno`)values(?,?,?,?,?,?,?)";
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","thorisagood");
					pst=con.prepareStatement(query);
					 pst.setString(1, textField.getText());
					 pst.setString(2,comboBox.getSelectedItem().toString());
					 pst.setString(3,comboBox_1.getSelectedItem().toString());
					 pst.setString(4, passwordField.getText());
					 pst.setString(5, textField_2.getText());
					 pst.setString(6, textField_3.getText());
					 pst.setString(7, textField_1.getText());
					 pst.executeUpdate();
					 JOptionPane.showMessageDialog(null,p2+" RS got debited!! Thanks you!!");
				}catch(Exception ep)
				{
					JOptionPane.showMessageDialog(null, ep);
				}
				  
		}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(445, 480, 204, 35);
		contentPane.add(btnNewButton);
		JLabel lblNewLabel_7 = new JLabel("Ref no:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(809, 52, 74, 21);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("");
		Image img =new ImageIcon(this.getClass().getResource("/Us.jpeg")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img));
		lblNewLabel_6.setBounds(0, 0, 1017, 548);
		contentPane.add(lblNewLabel_6);
		
		
		
		
	
	}
}
