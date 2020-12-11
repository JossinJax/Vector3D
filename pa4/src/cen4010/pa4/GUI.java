package cen4010.pa4;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Button;

class GUI extends JFrame {

	public JPanel contentPane;
	public JTextField textField;
	public JLabel label;
	public Button button;
	public JLabel playerNum;
	public JLabel playerMon;
	/**
	 * 
	 * public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public GUI() {
		setEnabled(false);
		setTitle("Monopoly");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(label, BorderLayout.CENTER);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
		button = new Button("Submit");
		
		contentPane.add(button, BorderLayout.NORTH);
		
		playerNum = new JLabel("");
		contentPane.add(playerNum, BorderLayout.WEST);
		
		playerMon = new JLabel("");
		contentPane.add(playerMon, BorderLayout.EAST);
	}
	
	
	public boolean isInt(String s){
	    try{
	        Integer.parseInt(s);
	        return true;
	    }catch (NumberFormatException ex){
	        return false;
	    }
	}
	
	public String getText(String text) {
		return text;
	}

}
