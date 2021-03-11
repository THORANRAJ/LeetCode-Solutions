package thorproj;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class gui {

	JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    Connection connection =null;
    
	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
		connection=jdbc1.dbConnector();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1030, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("user name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(209, 178, 124, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(211, 221, 98, 45);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(304, 180, 124, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(304, 229, 124, 34);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				
				try {
					String query="select * from sample.login1 where uname=? and password=?";
					PreparedStatement pst=connection.prepareStatement(query);
					
					pst.setString(1, textField.getText());
					pst.setString(2, passwordField.getText());
                   ResultSet rs=pst.executeQuery();
                   int count=0;
                   while(rs.next())
                   {
                	   count=count+1;
                   }
                   if(count==1)
                   {
                	   JOptionPane.showMessageDialog(null, "login sucessfull!!");
                	   frame.dispose();
                	   maint obj=new maint();
                	   obj.setVisible(true);
                	   
                   }
                   else if(count>1)
                   {
                	   JOptionPane.showMessageDialog(null, "duplicate username and password!!");
                   }
                   else
                   {
                	   JOptionPane.showMessageDialog(null, "try again!!");
                   }
                   
				//JOptionPane.showMessageDialog(null, "login sucessfull!");
				rs.close();
				pst.close();
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
				}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(258, 355, 130, 33);
		frame.getContentPane().add(btnNewButton);
		
		/*JButton btnNewButton_1 = new JButton("exit");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(240, 240, 240));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(604, 355, 111, 33);
		frame.getContentPane().add(btnNewButton_1);
		*/
		JLabel lblNewLabel_2 = new JLabel("LOGIN PAGE");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_2.setBounds(382, 57, 431, 71);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("new register");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				newregister reg=new newregister();
				reg.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(426, 355, 146, 33);
		frame.getContentPane().add(btnNewButton_2);
		
		/*JButton btnNewButton_1 = new JButton("Ticket status");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();	
				display frame = new display();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(615, 355, 169, 29);
		frame.getContentPane().add(btnNewButton_1);*/
		
		JButton btnNewButton_1 = new JButton("Forgot password?");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				forgotpass frame = new forgotpass();
				
				frame.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(602, 357, 188, 33);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		Image img =new ImageIcon(this.getClass().getResource("/1773565.jpg")).getImage();
	    lblNewLabel_3.setIcon(new ImageIcon(img));
		lblNewLabel_3.setBounds(10, 0, 1063, 770);
		frame.getContentPane().add(lblNewLabel_3);
		
		
	}
}
