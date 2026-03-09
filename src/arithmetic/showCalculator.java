package arithmetic;

import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class showCalculator {

	public void calculatortable() {
	JFrame inputScreen = new JFrame("Enter the value to sum:");
    // ... Put all your table and calculator logic here ...
	inputScreen.setVisible(true);
	
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    // Define column headers
    model.addColumn("store_id");
    model.addColumn("manager_staff_id");
    model.addColumn("address_id");
    model.addColumn("last_update");

    try {
        // 1. Connect to Database (Replace with your credentials)
        Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.1.60:5432/webuser", "postgres", "postgres");
        Statement st = con.createStatement();
        
        // 2. Extract Data
        ResultSet rs = st.executeQuery("select * from user_details");

        // 3. Add rows to the table model
        while (rs.next()) {
            model.addRow(new Object[]{rs.getInt("userid"), rs.getString("username"), rs.getString("first_name"), rs.getString("last_name")});
        }
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    inputScreen.add(new JScrollPane(table));
    inputScreen.setSize(500, 300);
    
    inputScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
