package thorproj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class jdbc1 {
	
	/*public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","thorisagood");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from th.raj");
        rs.next();
        int name=rs.getInt("name");
        String city=rs.getString("city");
        System.out.println(name+" "+city);
         st.close();
         con.close();
	    }*/

	
	
	public static Connection dbConnector()
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","thorisagood");
		//JOptionPane.showMessageDialog(null, "connection sucessfull!!");
       // Statement st=con.createStatement();
		return con;
		}catch(Exception e)
		{
			return null;
			
		}
	}

}
