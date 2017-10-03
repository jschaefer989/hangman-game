import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

//This class communicates with the GuessFrame to tell HangmanDrawing when to draw on the HangmanFrame
public class HangmanComponent extends JComponent
{
	private HangmanDrawing test;	
	private int counter;
	private HangmanFrame frame;		
	
	//A constructor that creates a new HangmanDrawing and takes in a HangmanFrame
	public HangmanComponent(HangmanFrame frame)
	{
		this.test = new HangmanDrawing();	
		this.frame = frame;
	}	
	
	//This method is used by GuessFrame to tell the HangmanComponent if the user got a wrong letter, or won or lost
	public void setCounter(int counter)
	{
		this.counter = counter;
	}
	
	//A paintComponent for drawing on the HangmanFrame
	public void paintComponent(Graphics g)
	{			
		Graphics2D g2 = (Graphics2D)g;			
		
		//If there are no wrong letters (counter is equal to zero), do the following 
		if(counter == 0)
		{
			//Set the background color
			Color customColor = new Color(100, 255, 100);
			frame.getContentPane().setBackground(customColor);
			//Draw the structure
			test.drawStructure(g2);							
		}
		
		//If there is one wrong letter (counter is equal to one), do the following
		else if(counter == 1)
		{		
			//Set the background color
			Color customColor = new Color(100, 255, 100);
			frame.getContentPane().setBackground(customColor);
			//Draw the head and the structure
			test.drawHead(g2);
			test.drawStructure(g2);			
			repaint();								
		}
		
		//If there are two wrong letters (counter is equal to two), do the following
		else if(counter == 2)
		{
			//Set the background color
			Color customColor = new Color(100, 255, 100);
			frame.getContentPane().setBackground(customColor);
			//Draw the head, body, and structure
			test.drawBody(g2);
			test.drawStructure(g2);
			test.drawHead(g2);
			repaint();			
		}
		
		//If there are three wrong letters (counter is equal to three), do the following
		else if(counter == 3)
		{
			//Set the background color
			Color customColor = new Color(100, 255, 100);
			frame.getContentPane().setBackground(customColor);
			//Draw the left arm, head, body, and structure
			test.drawLeftArm(g2);
			test.drawStructure(g2);
			test.drawHead(g2);
			test.drawBody(g2);
			repaint();			
		}
		
		//If there are four wrong letters (counter is equal to four), do the following
		else if(counter == 4)
		{
			//Set the background color
			Color customColor = new Color(100, 255, 100);
			frame.getContentPane().setBackground(customColor);
			//Draw the left leg and arm, head, body, and structure
			test.drawLeftLeg(g2);
			test.drawStructure(g2);
			test.drawHead(g2);
			test.drawBody(g2);
			test.drawLeftArm(g2);
			repaint();			
		}
		
		//If there are five wrong letters (counter is equal to five), do the following
		else if(counter == 5)
		{
			//Set the background color
			Color customColor = new Color(100, 255, 100);
			frame.getContentPane().setBackground(customColor);
			//Draw the right arm, left leg and arm, head, body, and structure
			test.drawRightArm(g2);
			test.drawStructure(g2);
			test.drawHead(g2);
			test.drawBody(g2);
			test.drawLeftArm(g2);
			test.drawLeftLeg(g2);
			repaint();			
		}
		
		//If there are six wrong letters (counter is equal to six), do the following
		else if(counter == 6)
		{
			//Set the background color
			Color customColor = new Color(100, 255, 100);
			frame.getContentPane().setBackground(customColor);
			//Draw the right leg and arm, left leg and arm, head, body, and structure
			test.drawRightLeg(g2);
			test.drawStructure(g2);
			test.drawHead(g2);
			test.drawBody(g2);
			test.drawLeftArm(g2);
			test.drawLeftLeg(g2);
			test.drawRightArm(g2);
			repaint();						
		}
		
		//If the counter is equal to seven, do the following
		else if(counter == 7)
		{
			//Set the background color
			Color customColor = new Color(100, 255, 100);
			frame.getContentPane().setBackground(customColor);
			//Draw the lose text
			test.drawLose(g2);
			repaint();
		}
		
		//If the counter is equal to ten, do the following
		else if(counter == 10)
		{
			//Set the background color
			Color customColor = new Color(100, 255, 100);
			frame.getContentPane().setBackground(customColor);
			//Draw the win text
			test.drawWin(g2);
			repaint();
		}
	}

}
