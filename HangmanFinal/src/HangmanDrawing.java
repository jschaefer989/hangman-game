import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;

//This class contains all of the instructions for drawing the elements of the hangman
public class HangmanDrawing extends JComponent{
	
	private Color selectedColor;
	
	//A method for generating random colors to be used in the drawWin method
	public Color generateColor()
	{
		try{
			//Create an array list for all of the random colors
			ArrayList<Color> randomColors = new ArrayList<Color>();
			//Add a whole bunch of colors to the randomColors array list			
			randomColors.add(Color.BLACK);
			randomColors.add(Color.BLUE);
			randomColors.add(Color.CYAN);
			randomColors.add(Color.GREEN);
			randomColors.add(Color.MAGENTA);
			randomColors.add(Color.ORANGE);
			randomColors.add(Color.PINK);
			randomColors.add(Color.RED);
			randomColors.add(Color.YELLOW);
			//Code for selecting a random color from the array list			
			Random rand = new Random();		
			int color = rand.nextInt(9);
			this.selectedColor = randomColors.get(color);			
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		return selectedColor;
	}
	//g2.setStroke increases the thickness of the shapes being drawn
	//Code for drawing the lines that make up the hangman structure
	public Component drawStructure(Graphics2D g2)
	{		
		g2.setStroke(new BasicStroke(5));
		g2.draw(new Line2D.Double(0, 300, 150, 300));
		g2.draw(new Line2D.Double(75, 300, 75, 0));
		g2.draw(new Line2D.Double(75, 0, 150, 0));
		g2.draw(new Line2D.Double(150, 0, 150, 20));
		return null;		
	}
	//Code for drawing the ellipse that makes up the head
	public void drawHead(Graphics2D g2)
	{
		g2.setStroke(new BasicStroke(5));
		Ellipse2D head = new Ellipse2D.Double(100, 20, 100, 100);
		g2.draw(head);		
	}
	//Code for drawing the line that makes up the body
	public void drawBody(Graphics2D g2)
	{
		g2.setStroke(new BasicStroke(5));
		g2.draw(new Line2D.Double(150, 120, 150, 210));
	}
	//Code for drawing the line that makes up the left arm
	public void drawLeftArm(Graphics2D g2)
	{
		g2.setStroke(new BasicStroke(5));
		g2.draw(new Line2D.Double(150, 150, 100, 200));
	}
	//Code for drawing the line that makes up the right arm
	public void drawRightArm(Graphics2D g2)
	{
		g2.setStroke(new BasicStroke(5));
		g2.draw(new Line2D.Double(150, 150, 200, 200));
	}
	//Code for drawing the line that makes up the left leg
	public void drawLeftLeg(Graphics2D g2)
	{
		g2.setStroke(new BasicStroke(5));
		g2.draw(new Line2D.Double(150, 210, 100, 260));
	}
	//Code for drawing the line that makes up the right leg
	public void drawRightLeg(Graphics2D g2)
	{
		g2.setStroke(new BasicStroke(5));
		g2.draw(new Line2D.Double(150, 210, 200, 260));
	}
	//Code for drawing the string that says Winner!
	public void drawWin(Graphics2D g2)
	{		
		g2.setStroke(new BasicStroke(5));
		//Set the color of the text to the randomly selected colors from the generateColor method
		g2.setColor(generateColor());
		//Set the font
		g2.setFont(new Font("CenturyGothic", Font.BOLD, 90));
		//Draw the string
		g2.drawString("WINNER!", 10, 200);				
	}
	//Code for drawing the string that says Loser
	public void drawLose(Graphics2D g2)
	{
		g2.setStroke(new BasicStroke(5));
		//Set the font
		g2.setFont(new Font("CenturyGothc", Font.BOLD, 90));
		//Draw the string
		g2.drawString("LOSER", 10, 200);
	}
}
