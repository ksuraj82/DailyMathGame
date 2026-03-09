package arithmetic;


import java.sql.*;
import javax.swing.*;

public class LoginWindow{
	
	private boolean userLogin;

    private void checkLogin(JTextField uservalue,JPasswordField passvalue) {
        String username = uservalue.getText();
        String password = new String(passvalue.getPassword());

        try {
            // 1. Establish Connection
            Connection conn = DriverManager.getConnection("jdbc:postgresql://192.168.1.60:5432/webuser", "postgres", "postgres");

            // 2. Prepare SQL Query
            String sql = "SELECT * FROM user_details WHERE username=? AND password=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);

            // 3. Execute and Check Result
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login Successful!");
                this.userLogin=true;
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }

    }
    
    public boolean getLogin(JTextField uservalue,JPasswordField passvalue) {
    	checkLogin(uservalue,passvalue);
    	return userLogin;
    }
	

}
