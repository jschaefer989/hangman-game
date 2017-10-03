import java.awt.EventQueue;

//This class is a standard driver
public class HangmanDriver {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					//Create new instance of the HangmanFrame
					HangmanFrame frame = new HangmanFrame();	
					//Create new instance of the HangmanComponent, and take in the frame
					HangmanComponent view = new HangmanComponent(frame);
					//Add the component to the HangmanFrame and set it visible
					frame.add(view);
					frame.setVisible(true);
					
					//Create new instance of the GuessFrame
					GuessFrame frame2 = new GuessFrame(view);
					//Set the GuessFrame visible
					frame2.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}

