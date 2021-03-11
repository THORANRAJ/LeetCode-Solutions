package thorproj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class passenger extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	Connection con=null;
	PreparedStatement pst=null;
	String gtype;
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
	           "1980","1981","1983"	,"1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000"		
		};
		private JTextField textField_5;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					passenger frame = new passenger("0","0");
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
	public passenger(String p1,String p2) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1251, 708);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Passenger Details");
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(459, 25, 378, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ref no:");
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(160, 115, 86, 36);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(256, 115, 112, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setForeground(Color.white);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(160, 209, 86, 30);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(256, 212, 112, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("DOB:");
		lblNewLabel_3.setForeground(Color.white);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(160, 296, 86, 36);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox(dates);
		comboBox.setBounds(256, 306, 38, 21);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(mon);
		comboBox_1.setBounds(304, 306, 64, 21);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox(year);
		comboBox_2.setBounds(378, 306, 75, 21);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_4 = new JLabel("Gender:");
		lblNewLabel_4.setForeground(Color.white);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(160, 378, 86, 36);
		contentPane.add(lblNewLabel_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBounds(256, 388, 64, 21);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gtype="male";
			}
		});
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setBounds(327, 388, 75, 21);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gtype="female";
			}
		});
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("Phone no:");
		lblNewLabel_5.setForeground(Color.white);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(607, 115, 86, 30);
		contentPane.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(703, 115, 112, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Id no:");
		lblNewLabel_6.setForeground(Color.white);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(607, 203, 86, 36);
		contentPane.add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setBounds(703, 209, 112, 30);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Nationality:");
		lblNewLabel_7.setForeground(Color.white);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(607, 304, 100, 30);
		contentPane.add(lblNewLabel_7);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(703, 306, 112, 21);
		comboBox_3.addItem("select");
		comboBox_3.addItem("india");
		comboBox_3.addItem("uk");
		comboBox_3.addItem("singapore");
		comboBox_3.addItem("china");
		comboBox_3.addItem("usa");
		comboBox_3.addItem("spain");
		comboBox_3.addItem("france");
		comboBox_3.addItem("netherlands");
		contentPane.add(comboBox_3);
		
		JLabel lblNewLabel_8 = new JLabel("Address:");
		lblNewLabel_8.setForeground(Color.white);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(607, 380, 86, 36);
		contentPane.add(lblNewLabel_8);
		
		textField_4 = new JTextField();
		textField_4.setBounds(703, 387, 112, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("BIll:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_10.setForeground(Color.white);
		lblNewLabel_10.setBounds(160, 446, 75, 20);
		contentPane.add(lblNewLabel_10);
		textField_5 = new JTextField();
		textField_5.setBounds(256, 446, 112, 27);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					textField.setText(p1);
					String query="INSERT INTO `passenger`(`name`,`day`,`mon`,`yar`,`gen`,`phno`,`adno`,`nation`,`address`,`refno`,`price`)values(?,?,?,?,?,?,?,?,?,?,?)";
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","thorisagood");
					 pst=con.prepareStatement(query);
					 pst.setString(1, textField_1.getText());
					 pst.setString(2,comboBox.getSelectedItem().toString());
					 pst.setString(3,comboBox_1.getSelectedItem().toString());
					 pst.setString(4,comboBox_2.getSelectedItem().toString());
					 pst.setString(5,gtype);
					 pst.setString(6, textField_2.getText());
					 pst.setString(7, textField_3.getText());
					 pst.setString(8,comboBox_3.getSelectedItem().toString());
					 pst.setString(9, textField_4.getText());
					 pst.setString(10, textField.getText());
					 pst.setString(11, textField_5.getText());
					 pst.executeUpdate();
				}
				catch(Exception et) {
					JOptionPane.showMessageDialog(null, et);
				}
				String th,th1;
				th=textField.getText();
				th1=textField_5.getText();
				//passenger.this.dispose();
				paymode frame = new paymode(th,th1);
				frame.setVisible(true);
				passenger.this.dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(476, 561, 127, 30);
		contentPane.add(btnNewButton);
		
		
		
		JButton btnNewButton_1 = new JButton("Bill generator");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(p1);
				textField_5.setText(p2);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(304, 561, 149, 29);
		contentPane.add(btnNewButton_1);
		
		
		
		
		JLabel lblNewLabel_9= new JLabel("");
		Image img =new ImageIcon(this.getClass().getResource("/1773565.jpg")).getImage();
		lblNewLabel_9.setIcon(new ImageIcon(img));
		lblNewLabel_9.setBounds(0, 10, 1237, 661);
		contentPane.add(lblNewLabel_9);
		
		
	}
}
