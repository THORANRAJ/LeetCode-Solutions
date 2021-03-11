package thorproj;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class display extends JFrame {
    
	private JPanel contentPane;
	Connection con=null;
	PreparedStatement pst=null;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	//con=jdbc1.dbConnector();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					display frame = new display();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ArrayList<user> userlist()
	{
		ArrayList<user> userlist=new ArrayList<>();	
		try
		{
			//textField.setText(p1);
			String query="select t2.name,t1.form,t1.tot,t1.kids,t1.adults,t1.day,t1.mon,t1.yer,t2.price from book t1,passenger t2 where t1.refno=t2.refno and adno=? ";
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","thorisagood");
			pst=con.prepareStatement(query);
			pst.setString(1, textField.getText());
			ResultSet rs=pst.executeQuery();
			
			user u;
			while(rs.next())
			{
				u=new user(rs.getString("name"),rs.getString("form"),rs.getString("tot"),rs.getString("kids"),rs.getString("adults"),rs.getString("day"),rs.getString("mon"),rs.getString("yer"),rs.getString("price"));
				userlist.add(u);
			}
		}catch(Exception t)
		{
			JOptionPane.showMessageDialog(null, t);
		}
		return userlist;
	 }
	public void show_user()
	{
		ArrayList<user>list=userlist();
		DefaultTableModel model=(DefaultTableModel)table.getModel();		
		Object[] row=new Object[9];
		for(int i=0;i<list.size();i++)
		{
			row[0]=list.get(i).getname();
			row[1]=list.get(i).getform();
			row[2]=list.get(i).gettot();
			row[3]=list.get(i).getkids();
			row[4]=list.get(i).getadults();
			row[5]=list.get(i).getday();
			row[6]=list.get(i).getmon();
			row[7]=list.get(i).getyer();
			row[8]=list.get(i).getprice();
			model.addRow(row);
			
			
		}
	}

	/**
	 * Create the frame.
	 */
	public display() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 199, 910, 62);
		contentPane.add(scrollPane);
	
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "From", "To", "Kids", "Adults", "Day", "Month", "Year", "Price"
			}
		));
		scrollPane.setViewportView(table);
		
		
		JButton btnNewButton = new JButton("show details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*try {
					//String query="select t2.name,t1.form,t1.tot,t1.day,t1.mon,t1.yer,t2.price from book t1,passenger t2 where t1.refno=t2.refno and adno=?";
					String query="select * from passenger";
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","thorisagood");
					 pst=con.prepareStatement(query);
					 ResultSet rs=pst.executeQuery();
					 //table.setModel(DbUtils.resultSetToTableModel(rs));
					 pst.executeUpdate();
				}
				catch(Exception eb)
				{
					//eb.printStackTrace();
					JOptionPane.showMessageDialog(null, eb);
					user
				}*/
				userlist();
				show_user();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(390, 454, 210, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Ticket status");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(335, 29, 276, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("id no:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(20, 105, 88, 29);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(89, 109, 110, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		Image img =new ImageIcon(this.getClass().getResource("/alaska.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(10, 10, 933, 512);
		contentPane.add(lblNewLabel_1);
		
	
	}
}
