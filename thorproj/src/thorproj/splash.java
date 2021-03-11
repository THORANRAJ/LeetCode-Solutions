package thorproj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class splash extends JFrame {

	private JPanel contentPane;
	public Object lblNewLabel_2;
	public Object lblNewLabel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtAdditionOperation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					splash frame = new splash();
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
	public void end()
	{
		try {
			
		
		  Thread.sleep(5000);
		  System.exit(0);
		}
		catch(Exception eh)
		{
			
		}
	}
	public splash() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(Color.BLUE);
		panel.setBounds(10, 10, 769, 446);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(84, 141, 107, 31);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(84, 209, 107, 31);
		panel.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(201, 143, 71, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(201, 205, 71, 31);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(318, 286, 95, 21);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("result:");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(353, 146, 95, 24);
		panel.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(439, 145, 96, 27);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		txtAdditionOperation = new JTextField();
		txtAdditionOperation.setText("addition operation");
		txtAdditionOperation.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtAdditionOperation.setBounds(227, 41, 186, 31);
		panel.add(txtAdditionOperation);
		txtAdditionOperation.setColumns(10);
		
		try
		{
			splash.this.dispose();
			//paymode frame = new paymode();
		//	frame.setVisible(true);
		}catch(Exception j)
		
		{
			System.out.println(j);
		}
		
		/*JLabel lblNewLabel_1 = new JLabel("");
		Image img =new ImageIcon(this.getClass().getResource("/loading.gif")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(366, 184, 72, 107);
		panel.add(lblNewLabel_1);*/
		
	     
		
		
		/*JLabel lblNewLabel_3 = new JLabel("");
		Image img1 =new ImageIcon(this.getClass().getResource("/ship.jpg")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img1));
		lblNewLabel_3.setBounds(0, 0, 769, 436);
		panel.add(lblNewLabel_3);*/
		
		
	}
}
