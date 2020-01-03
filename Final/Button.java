/* Got help from the down below
 * Reference: https://examples.javacodegeeks.com/desktop-java/swing/java-swing-button-example/
 */

/*
 * importing libraries such as swing, awt etc.
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*; 

/*
 * Importing JPanel and Action Listener to create the Java Buttons
 */
public class Button extends JPanel implements ActionListener{  
	
	
	protected JButton Button1, Button2, Button3; // Creating three protected Java Buttons
	boolean started = false;
	
	
	
	/*
	 * This method helps us set up the background for Chess Menu GUI
	 * Using a Picture, Chess.jpg, imported from google as background
	 */
	public void paintComponent(Graphics style) {
		if(!started) {
			
		style.drawImage(new ImageIcon(Button.class.getResource("Chess.jpg")).getImage(), 0, 0, 1500, 800, this);
		
		}
		else {
			setBackground(Color.BLUE);
		}
	}
	
	/*
	 * This method helps us set up the location and type for the 3 Buttons: Button1, Button2, and Button3
	 * 
	 */
	public Button() {//Setting up the button and the location of the button
		Button1 = new JButton(" 1 vs 1");
		Button1.setVerticalTextPosition(AbstractButton.TOP);
		Button1.setPreferredSize(new Dimension((int) (50.0 * 3.5), (20 * 2)));
		Button1.setBounds(50,50,70,30);
		Button1.setHorizontalTextPosition(SwingConstants.CENTER);
		Button1.setMnemonic(KeyEvent.VK_D);
		Button1.setActionCommand("1 vs 1");
		
		Button2 = new JButton("Play Against AI!");
		Button2.setVerticalTextPosition(AbstractButton.BOTTOM);
		Button2.setPreferredSize(new Dimension((int) (50.0 * 3.5), (20 * 2)));
		Button2.setHorizontalTextPosition(SwingConstants.CENTER);
		Button2.setMnemonic(KeyEvent.VK_M);
		Button2.setActionCommand("Against AI!");
		
		Button3 = new JButton("AI vs AI");
		Button3.setVerticalTextPosition(AbstractButton.TOP);
		Button3.setPreferredSize(new Dimension((int) (50.0 * 3.5), (20 * 2)));
		Button3.setHorizontalTextPosition(SwingConstants.CENTER);
		Button3.setMnemonic(KeyEvent.VK_E);
		Button3.setActionCommand("AI vs AI");
		
		//Using Action Listener to handle all the action events of the buttons from the JPanel
		
		Button1.addActionListener(this);
		Button2.addActionListener(this);
		Button3.addActionListener(this);
		 
		//Using it to add the buttons through JPanel
		add(Button1);
		add(Button2);
		add(Button3);
			
		}
	
	/*
	 * ThIs method helps us to attach the MENU GUI to the chess game 
	 * By importing the chess game and making it a parent class
	 */
	public void actionPerformed(ActionEvent Actions) {
		if ("1 vs 1".equals(Actions.getActionCommand())) {
			Button1.setEnabled(true);
			Button2.setEnabled(true);
			Button3.setEnabled(true);
		}
		else if("Against AI!".equals(Actions.getActionCommand())) {//commands for the chess logic of
			JOptionPane.showMessageDialog(this.getComponent(0), "Middle button is clicked");
		}
		else {
			Button1.setEnabled(true);
			Button2.setEnabled(true);
			Button3.setEnabled(true);
		}
		
		
	}
	
	/*
	 * This method helps us show the GUI and setting the frame of the menu 
	 */
	private static void ShowGUI() { //Shows the buttons
		  
        //Using JFrame to set up the Chess menu
        JFrame frame = new JFrame("Chess");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        //Create and set up the content pane
        Button newContentPane = new Button();
        newContentPane.setOpaque(true); //Content panes must be opaque
        frame.setContentPane(newContentPane);
  
        //Helps to display the window
        frame.pack();
        frame.setVisible(true);
        frame.setFocusable(true);
		frame.setSize(1500,800);
    }
	
	/*
	 * This method helps compile all the methods together and run the game 
	 */
	 public static void main(String[] args) {
	        javax.swing.SwingUtilities.invokeLater(new Runnable() { //Creating and showing the application GUI
	            public void run() {
	                ShowGUI(); 
	            }
	        });
	    }
	}

	
