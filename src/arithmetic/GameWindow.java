package arithmetic;

import javax.swing.*;

public class GameWindow {
	
	public void gameWindow() {
    JFrame gameFrame = new JFrame("Math Game Wizard");
    gameFrame.setSize(500,400);
    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JTabbedPane tabs = new JTabbedPane();

    // Add a tab for each math operation
    tabs.addTab("Addition", new MathGamePanel("+"));
    tabs.addTab("Subtraction", new MathGamePanel("-"));
    tabs.addTab("Multiplication", new MathGamePanel("x"));
    tabs.addTab("Division", new MathGamePanel("/"));

    gameFrame.add(tabs);
    gameFrame.setLocationRelativeTo(null); // Center on screen
    gameFrame.setVisible(true);
    
	}

}
