import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

//This class just creates an empty JFrame to add the Hangman drawings too
public class HangmanFrame extends JFrame {

	private JLabel contentPane;	

	/**
	 * @throws IOException 
	 */
	//A constructor for making an empty contentPane
	public HangmanFrame() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(920, 100, 450, 400);
		setType(Type.UTILITY);
		contentPane = new JLabel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setContentPane(contentPane);
		contentPane.setOpaque(true);
	}
	
}
