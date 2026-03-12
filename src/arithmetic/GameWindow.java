package arithmetic;

import javax.swing.*;

public class GameWindow {
	
	public void gameWindow(String gamerName) {
    JFrame gameFrame = new JFrame("Math Game Wizard");
    gameFrame.setSize(500,400);
    gameFrame.setResizable(false); 
    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    JTabbedPane tabs = new JTabbedPane();

    // Add a tab for each math operation
    tabs.addTab("Addition", new MathGamePanel("+",gamerName));
    tabs.addTab("Subtraction", new MathGamePanel("-",gamerName));
    tabs.addTab("Multiplication", new MathGamePanel("x",gamerName));
    tabs.addTab("Division", new MathGamePanel("/",gamerName));
    
   
    
    gameFrame.add(tabs);
    gameFrame.setLocationRelativeTo(null); // Center on screen
    gameFrame.setVisible(true);
    
    
    
	}

}
