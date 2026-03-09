package arithmetic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MainAppGUI {
	
	private static boolean userLogin = false; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("user.timezone", "Asia/Kolkata");
		
		
		JFrame loginwindow = new JFrame("Login");
		loginwindow.setSize(300, 200);

		

        // UI Components
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 20, 80, 25);
        loginwindow.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(100, 20, 160, 25);
        loginwindow.add(userField);

//        JLabel passLabel = new JLabel("Password:");
//        passLabel.setBounds(20, 50, 80, 25);
//        loginwindow.add(passLabel);
//
//        JPasswordField passField = new JPasswordField();
//        passField.setBounds(100, 50, 160, 25);
//        loginwindow.add(passField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 90, 80, 25);
        loginwindow.add(loginButton);
 
        
        
        
        LoginWindow checkuser = new LoginWindow();

        // Action Listener for Login Button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//            	userLogin=checkuser.getLogin(userField,passField);
            	userLogin=checkuser.getLogin(userField);
            	System.out.println(userLogin);
            	if(userLogin==true) {
                	System.out.print(userLogin);
                	loginwindow.dispose();
            		loginwindow.setVisible(false);
            		new GameWindow().gameWindow(userField.getText());
//                	new showCalculator().calculatortable();
                }           	
            }
        });
        
        
        userField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//            	userLogin=checkuser.getLogin(userField,passField);
            	userLogin=checkuser.getLogin(userField);
            	System.out.println(userLogin);
            	if(userLogin==true) {
                	System.out.print(userLogin);
                	loginwindow.dispose();
            		loginwindow.setVisible(false);
            		new GameWindow().gameWindow(userField.getText());
//                	new showCalculator().calculatortable();
                }           	
            }
        });
		
        loginwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginwindow.setLayout(null);
        loginwindow.setVisible(true);


	}

}
