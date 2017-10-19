import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//This class creates the JFrame for all of the user input in the hangman game
public class GuessFrame extends JFrame {

	private JPanel contentPane;
	private JTextField playerNameField;
	private String selectedWord;
	private JTextArea incorrectTextArea;
	private JTextArea correctTextArea;
	private int counter;
	private ArrayList<Character> lettersArray;
	private JTextField wordGuessField;
	private JButton letterGuessButton;
	private HangmanComponent draw;
	private String invWord;
	private AudioClip correctSound;
	private AudioClip incorrectSound;
	private AudioClip winnerSound;
	private AudioClip loserSound;
	private File correct;
	private File incorrect;
	private File winner;
	private File loser;
	private URI uri;
	private URL url;

	//This method generates a random word for the user to try and guess
	public String generateWord()
	{
		try{
			//Make an array list of words 
			ArrayList<String> randomWords = new ArrayList<String>();
						
			//Add a whole bunch of random words to the array list
			randomWords.add("JEANS");
			randomWords.add("CHAIR");
			randomWords.add("TABLE");
			randomWords.add("HOUSE");
			randomWords.add("MOVIE");
			randomWords.add("PLANT");
			randomWords.add("DRINK");
			randomWords.add("CANDY");
			randomWords.add("MOUSE");
			randomWords.add("GAMES");
			randomWords.add("BOARD");
			randomWords.add("FRAME");
			randomWords.add("GLADE");
			randomWords.add("GRAND");
			randomWords.add("SPITE");
			randomWords.add("EBOLA");
			randomWords.add("FIGHT");
			randomWords.add("WATER");
			randomWords.add("CLOTH");
			randomWords.add("FLASH");
			randomWords.add("BLINK");
			randomWords.add("TOWER");
			randomWords.add("FINAL");
			randomWords.add("PHONE");
			randomWords.add("BLACK");
			randomWords.add("SHIRT");
			randomWords.add("MAGIC");
			randomWords.add("TIGER");
			randomWords.add("FLAME");			
			randomWords.add("FLUTE");
			
			//Using a random generator, pick one of the words
			Random rand = new Random();		
			int gameWord = rand.nextInt(30);
			//Set the random word as selectedWord
			this.selectedWord = randomWords.get(gameWord);			
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		return selectedWord;
	}
	
	//This method returns an array list of each individual letter in the selectedWord
	public ArrayList<Character> words()
	{
		try{
			//Create the array list to add the letters to
			this.lettersArray = new ArrayList<Character>();
			
			//If the selectedWord equals the given string, add each letter of that string to the array list
			//Repeat for all words in the randomWords array list
			if(this.selectedWord.equals("JEANS"))
			{
				this.lettersArray.add('J');
				this.lettersArray.add('E');
				this.lettersArray.add('A');
				this.lettersArray.add('N');
				this.lettersArray.add('S');										
			}
			else if(this.selectedWord.equals("CHAIR"))
			{
				this.lettersArray.add('C');
				this.lettersArray.add('H');
				this.lettersArray.add('A');
				this.lettersArray.add('I');
				this.lettersArray.add('R');				
			}
			else if(this.selectedWord.equals("TABLE"))
			{
				this.lettersArray.add('T');
				this.lettersArray.add('A');
				this.lettersArray.add('B');
				this.lettersArray.add('L');
				this.lettersArray.add('E');
			}
			else if(this.selectedWord.equals("HOUSE"))
			{
				this.lettersArray.add('H');
				this.lettersArray.add('O');
				this.lettersArray.add('U');
				this.lettersArray.add('S');
				this.lettersArray.add('E');
			}
			else if(this.selectedWord.equals("MOVIE"))
			{
				this.lettersArray.add('M');
				this.lettersArray.add('O');
				this.lettersArray.add('V');
				this.lettersArray.add('I');
				this.lettersArray.add('E');
			}
			else if(this.selectedWord.equals("PLANT"))
			{
				this.lettersArray.add('P');
				this.lettersArray.add('L');
				this.lettersArray.add('A');
				this.lettersArray.add('N');
				this.lettersArray.add('T');
			}
			else if(this.selectedWord.equals("DRINK"))
			{
				this.lettersArray.add('D');
				this.lettersArray.add('R');
				this.lettersArray.add('I');
				this.lettersArray.add('N');
				this.lettersArray.add('K');
			}
			else if(this.selectedWord.equals("CANDY"))
			{
				this.lettersArray.add('C');
				this.lettersArray.add('A');
				this.lettersArray.add('N');
				this.lettersArray.add('D');
				this.lettersArray.add('Y');
			}
			else if(this.selectedWord.equals("MOUSE"))
			{
				this.lettersArray.add('M');
				this.lettersArray.add('O');
				this.lettersArray.add('U');
				this.lettersArray.add('S');
				this.lettersArray.add('E');
			}
			else if(this.selectedWord.equals("GAMES"))
			{
				this.lettersArray.add('G');
				this.lettersArray.add('A');
				this.lettersArray.add('M');
				this.lettersArray.add('E');
				this.lettersArray.add('S');
			}
			else if(this.selectedWord.equals("BOARD"))
			{
				this.lettersArray.add('B');
				this.lettersArray.add('O');
				this.lettersArray.add('A');
				this.lettersArray.add('R');
				this.lettersArray.add('D');
			}
			else if(this.selectedWord.equals("FRAME"))
			{
				this.lettersArray.add('F');
				this.lettersArray.add('R');
				this.lettersArray.add('A');
				this.lettersArray.add('M');
				this.lettersArray.add('E');
			}
			else if(this.selectedWord.equals("GLADE"))
			{
				this.lettersArray.add('G');
				this.lettersArray.add('L');
				this.lettersArray.add('A');
				this.lettersArray.add('D');
				this.lettersArray.add('E');
			}
			else if(this.selectedWord.equals("GRAND"))
			{
				this.lettersArray.add('G');
				this.lettersArray.add('R');
				this.lettersArray.add('A');
				this.lettersArray.add('N');
				this.lettersArray.add('D');
			}
			else if(this.selectedWord.equals("SPITE"))
			{
				this.lettersArray.add('S');
				this.lettersArray.add('P');
				this.lettersArray.add('I');
				this.lettersArray.add('T');
				this.lettersArray.add('E');
			}
			else if(this.selectedWord.equals("EBOLA"))
			{
				this.lettersArray.add('E');
				this.lettersArray.add('B');
				this.lettersArray.add('O');
				this.lettersArray.add('L');
				this.lettersArray.add('A');
			}
			else if(this.selectedWord.equals("FIGHT"))
			{
				this.lettersArray.add('F');
				this.lettersArray.add('I');
				this.lettersArray.add('G');
				this.lettersArray.add('H');
				this.lettersArray.add('T');
			}
			else if(this.selectedWord.equals("WATER"))
			{
				this.lettersArray.add('W');
				this.lettersArray.add('A');
				this.lettersArray.add('T');
				this.lettersArray.add('E');
				this.lettersArray.add('R');
			}
			else if(this.selectedWord.equals("CLOTH"))
			{
				this.lettersArray.add('C');
				this.lettersArray.add('L');
				this.lettersArray.add('O');
				this.lettersArray.add('T');
				this.lettersArray.add('H');
			}
			else if(this.selectedWord.equals("FLASH"))
			{
				this.lettersArray.add('F');
				this.lettersArray.add('L');
				this.lettersArray.add('A');
				this.lettersArray.add('S');
				this.lettersArray.add('H');
			}
			else if(this.selectedWord.equals("BLINK"))
			{
				this.lettersArray.add('B');
				this.lettersArray.add('L');
				this.lettersArray.add('I');
				this.lettersArray.add('N');
				this.lettersArray.add('K');
			}
			else if(this.selectedWord.equals("TOWER"))
			{
				this.lettersArray.add('T');
				this.lettersArray.add('O');
				this.lettersArray.add('W');
				this.lettersArray.add('E');
				this.lettersArray.add('R');
			}
			else if(this.selectedWord.equals("FINAL"))
			{
				this.lettersArray.add('F');
				this.lettersArray.add('I');
				this.lettersArray.add('N');
				this.lettersArray.add('A');
				this.lettersArray.add('L');
			}
			else if(this.selectedWord.equals("PHONE"))
			{
				this.lettersArray.add('P');
				this.lettersArray.add('H');
				this.lettersArray.add('O');
				this.lettersArray.add('N');
				this.lettersArray.add('E');
			}
			else if(this.selectedWord.equals("BLACK"))
			{
				this.lettersArray.add('B');
				this.lettersArray.add('L');
				this.lettersArray.add('A');
				this.lettersArray.add('C');
				this.lettersArray.add('K');
			}
			else if(this.selectedWord.equals("SHIRT"))
			{
				this.lettersArray.add('S');
				this.lettersArray.add('H');
				this.lettersArray.add('I');
				this.lettersArray.add('R');
				this.lettersArray.add('T');
			}
			else if(this.selectedWord.equals("BLINK"))
			{
				this.lettersArray.add('B');
				this.lettersArray.add('L');
				this.lettersArray.add('I');
				this.lettersArray.add('N');
				this.lettersArray.add('K');
			}
			else if(this.selectedWord.equals("MAGIC"))
			{
				this.lettersArray.add('M');
				this.lettersArray.add('A');
				this.lettersArray.add('G');
				this.lettersArray.add('I');
				this.lettersArray.add('C');
			}
			else if(this.selectedWord.equals("TIGER"))
			{
				this.lettersArray.add('T');
				this.lettersArray.add('I');
				this.lettersArray.add('G');
				this.lettersArray.add('E');
				this.lettersArray.add('R');
			}
			else if(this.selectedWord.equals("FLAME"))
			{
				this.lettersArray.add('F');
				this.lettersArray.add('L');
				this.lettersArray.add('A');
				this.lettersArray.add('M');
				this.lettersArray.add('E');
			}
			else if(this.selectedWord.equals("FLUTE"))
			{
				this.lettersArray.add('F');
				this.lettersArray.add('L');
				this.lettersArray.add('U');
				this.lettersArray.add('T');
				this.lettersArray.add('E');
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return lettersArray;
	}
	
	//This is the constructor that creates all of the GUI elements and button listeners of the GuessFrame
	public GuessFrame(HangmanComponent draw) throws MalformedURLException{
		//Initialize variables from other methods
		this.selectedWord = generateWord();		
		this.lettersArray = words(); 
		//The constructor also takes in a HangmanComponent class called draw so this frame can talk to the HangmanFrame
		this.draw = draw;
		//Code for creating the content pane to contain all of the GUI elements
		setType(Type.UTILITY);
		setTitle("HANGMAN");		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{60, 68, 76, 69, 73, 62, 71, 56, 57, 64, 65, 58, 0};
		gbl_contentPane.rowHeights = new int[]{0, 51, 41, 39, 0, 73, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		Color customColor = new Color(0, 180, 255);
		getContentPane().setBackground(customColor);
		
		//This code creates the audio clips that will be used later in the button listeners
		correct = new File("correctSound.wav");
		incorrect = new File("incorrectSound.wav");
		winner = new File("winningSound.wav");
		loser = new File("loserSound.wav");
		uri = correct.toURI();
		url = uri.toURL();
		correctSound = Applet.newAudioClip(url);
		uri = incorrect.toURI();
		url = uri.toURL();
		incorrectSound = Applet.newAudioClip(url);
		uri = winner.toURI();
		url = uri.toURL();
		winnerSound = Applet.newAudioClip(url);
		uri = loser.toURI();
		url = uri.toURL();
		loserSound = Applet.newAudioClip(url);		
		
		//Code for creating a new JLabel to hold Player Name:
		JLabel playerNameLabel = new JLabel("Player Name:");
		playerNameLabel.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		playerNameLabel.setForeground(new Color(240, 255, 240));
		GridBagConstraints gbc_playerNameLabel = new GridBagConstraints();
		gbc_playerNameLabel.gridwidth = 2;
		gbc_playerNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_playerNameLabel.anchor = GridBagConstraints.EAST;
		gbc_playerNameLabel.gridx = 0;
		gbc_playerNameLabel.gridy = 0;
		contentPane.add(playerNameLabel, gbc_playerNameLabel);
		
		//Code for creating the JTextField to enter the player's name
		playerNameField = new JTextField();
		playerNameField.setForeground(new Color(0, 180, 255));
		playerNameField.setFont(new Font("Aharoni", Font.PLAIN, 13));
		GridBagConstraints gbc_playerNameField = new GridBagConstraints();
		gbc_playerNameField.gridwidth = 2;
		gbc_playerNameField.insets = new Insets(0, 0, 5, 5);
		gbc_playerNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_playerNameField.gridx = 2;
		gbc_playerNameField.gridy = 0;
		contentPane.add(playerNameField, gbc_playerNameField);
		playerNameField.setColumns(10);
		
		//Code for creating a new JLabel that holds Do you know the word?
		JLabel wordGuessLabel = new JLabel("Do you know the word?");
		wordGuessLabel.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		wordGuessLabel.setForeground(new Color(240, 255, 240));
		GridBagConstraints gbc_wordGuessLabel = new GridBagConstraints();
		gbc_wordGuessLabel.gridwidth = 4;
		gbc_wordGuessLabel.anchor = GridBagConstraints.EAST;
		gbc_wordGuessLabel.insets = new Insets(0, 0, 5, 5);
		gbc_wordGuessLabel.gridx = 4;
		gbc_wordGuessLabel.gridy = 0;
		contentPane.add(wordGuessLabel, gbc_wordGuessLabel);
		
		//Code for creating a JTextField for the user to guess the entire word
		wordGuessField = new JTextField();
		wordGuessField.setForeground(new Color(0, 180, 255));
		wordGuessField.setFont(new Font("Aharoni", Font.PLAIN, 13));
		GridBagConstraints gbc_wordGuessField = new GridBagConstraints();
		gbc_wordGuessField.gridwidth = 2;
		gbc_wordGuessField.insets = new Insets(0, 0, 5, 5);
		gbc_wordGuessField.fill = GridBagConstraints.HORIZONTAL;
		gbc_wordGuessField.gridx = 8;
		gbc_wordGuessField.gridy = 0;
		contentPane.add(wordGuessField, gbc_wordGuessField);
		wordGuessField.setColumns(10);
		
		//Code for creating a new JButton for guessing the word typed into wordGuessField 
		JButton wordGuessButton = new JButton("GUESS WORD");
		wordGuessButton.setBackground(new Color(255, 255, 255));
		wordGuessButton.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		wordGuessButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				//Take the text in the wordGuessField, make it all uppercase and set it to a string
				String wordGuess = wordGuessField.getText().toUpperCase();
				//If the user got the word right
				if(wordGuess.equals(selectedWord))
				{
					//Draw Winner! onto the HangmanFrame
					draw.setCounter(10);
					draw.repaint();
					//If the playerNameField is empty, print out the following to the console
					if(playerNameField.getText().equals(""))
					{
						System.out.println("Congrats, you win! Your word was: " + selectedWord);
					}
					//If the playerNameField contains something, print out the following to the console
					else
					{
						System.out.println("Congrats, " + playerNameField.getText() + ", you win! Your word was: " + selectedWord);
					}
					//Disable all JButtons and player the winning sound
					letterGuessButton.setEnabled(false);
					wordGuessButton.setEnabled(false);
					winnerSound.play();
				}
				//If the user got the word wrong
				else
				{	
					//Draw Loser in the HangmanFrame
					draw.setCounter(7);
					draw.repaint();
					//If the playerNameField contains something, print out the following to the console
					if(playerNameField.getText().equals(""))
					{
						System.out.println("You were hanged! Game Over. Your word was: " + selectedWord);
					}
					//If the playerNameField contains something, print out the following to the console
					else
					{
						System.out.println(playerNameField.getText() + " was hanged! Game Over. Your word was: " + selectedWord);
					}
					//Disable all JButtons and player the losing sound
					letterGuessButton.setEnabled(false);
					wordGuessButton.setEnabled(false);
					loserSound.play();
				}
			}
		});
		GridBagConstraints gbc_wordGuessButton = new GridBagConstraints();
		gbc_wordGuessButton.gridwidth = 2;
		gbc_wordGuessButton.insets = new Insets(0, 0, 5, 0);
		gbc_wordGuessButton.gridx = 10;
		gbc_wordGuessButton.gridy = 0;
		contentPane.add(wordGuessButton, gbc_wordGuessButton);
		
		//Code for creating the radio button for selecting the letter A
		//Repeat for all letters of the alphabet
		JRadioButton rdbtnA = new JRadioButton("A");
		rdbtnA.setFont(new Font("Aharoni", Font.PLAIN, 15));
		rdbtnA.setForeground(new Color(240, 255, 240));
		rdbtnA.setBackground(new Color(240, 240, 240));
		GridBagConstraints gbc_rdbtnA = new GridBagConstraints();
		gbc_rdbtnA.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnA.gridx = 0;
		gbc_rdbtnA.gridy = 1;
		contentPane.add(rdbtnA, gbc_rdbtnA);
		rdbtnA.setOpaque(false);
		
		JRadioButton rdbtnB = new JRadioButton("B");
		rdbtnB.setFont(new Font("Aharoni", Font.PLAIN, 15));
		rdbtnB.setForeground(new Color(240, 255, 240));
		GridBagConstraints gbc_rdbtnB = new GridBagConstraints();
		gbc_rdbtnB.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnB.gridx = 1;
		gbc_rdbtnB.gridy = 1;
		contentPane.add(rdbtnB, gbc_rdbtnB);
		rdbtnB.setOpaque(false);
		
		JRadioButton rdbtnC = new JRadioButton("C");
		rdbtnC.setForeground(new Color(240, 255, 240));
		rdbtnC.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnC = new GridBagConstraints();
		gbc_rdbtnC.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnC.gridx = 2;
		gbc_rdbtnC.gridy = 1;
		contentPane.add(rdbtnC, gbc_rdbtnC);
		rdbtnC.setOpaque(false);
		
		JRadioButton rdbtnD = new JRadioButton("D");
		rdbtnD.setForeground(new Color(240, 255, 240));
		rdbtnD.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnD = new GridBagConstraints();
		gbc_rdbtnD.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnD.gridx = 3;
		gbc_rdbtnD.gridy = 1;
		contentPane.add(rdbtnD, gbc_rdbtnD);
		rdbtnD.setOpaque(false);
		
		JRadioButton rdbtnE = new JRadioButton("E");
		rdbtnE.setForeground(new Color(240, 255, 240));
		rdbtnE.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnE = new GridBagConstraints();
		gbc_rdbtnE.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnE.gridx = 4;
		gbc_rdbtnE.gridy = 1;
		contentPane.add(rdbtnE, gbc_rdbtnE);
		rdbtnE.setOpaque(false);
		
		JRadioButton rdbtnF = new JRadioButton("F");
		rdbtnF.setForeground(new Color(240, 255, 240));
		rdbtnF.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnF = new GridBagConstraints();
		gbc_rdbtnF.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnF.gridx = 5;
		gbc_rdbtnF.gridy = 1;
		contentPane.add(rdbtnF, gbc_rdbtnF);
		rdbtnF.setOpaque(false);
		
		JRadioButton rdbtnG = new JRadioButton("G");
		rdbtnG.setForeground(new Color(240, 255, 240));
		rdbtnG.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnG = new GridBagConstraints();
		gbc_rdbtnG.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnG.gridx = 6;
		gbc_rdbtnG.gridy = 1;
		contentPane.add(rdbtnG, gbc_rdbtnG);
		rdbtnG.setOpaque(false);
		
		JRadioButton rdbtnH = new JRadioButton("H");
		rdbtnH.setForeground(new Color(240, 255, 240));
		rdbtnH.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnH = new GridBagConstraints();
		gbc_rdbtnH.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnH.gridx = 7;
		gbc_rdbtnH.gridy = 1;
		contentPane.add(rdbtnH, gbc_rdbtnH);
		rdbtnH.setOpaque(false);
		
		JRadioButton rdbtnI = new JRadioButton("I");
		rdbtnI.setForeground(new Color(240, 255, 240));
		rdbtnI.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnI = new GridBagConstraints();
		gbc_rdbtnI.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnI.gridx = 8;
		gbc_rdbtnI.gridy = 1;
		contentPane.add(rdbtnI, gbc_rdbtnI);
		rdbtnI.setOpaque(false);
		
		JRadioButton rdbtnJ = new JRadioButton("J");
		rdbtnJ.setForeground(new Color(240, 255, 240));
		rdbtnJ.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnJ = new GridBagConstraints();
		gbc_rdbtnJ.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnJ.gridx = 9;
		gbc_rdbtnJ.gridy = 1;
		contentPane.add(rdbtnJ, gbc_rdbtnJ);
		rdbtnJ.setOpaque(false);
		
		JRadioButton rdbtnK = new JRadioButton("K");
		rdbtnK.setForeground(new Color(240, 255, 240));
		rdbtnK.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnK = new GridBagConstraints();
		gbc_rdbtnK.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnK.gridx = 0;
		gbc_rdbtnK.gridy = 2;
		contentPane.add(rdbtnK, gbc_rdbtnK);
		rdbtnK.setOpaque(false);
		
		JRadioButton rdbtnL = new JRadioButton("L");
		rdbtnL.setForeground(new Color(240, 255, 240));
		rdbtnL.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnL = new GridBagConstraints();
		gbc_rdbtnL.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnL.gridx = 1;
		gbc_rdbtnL.gridy = 2;
		contentPane.add(rdbtnL, gbc_rdbtnL);
		rdbtnL.setOpaque(false);
		
		JRadioButton rdbtnM = new JRadioButton("M");
		rdbtnM.setForeground(new Color(240, 255, 240));
		rdbtnM.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnM = new GridBagConstraints();
		gbc_rdbtnM.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnM.gridx = 2;
		gbc_rdbtnM.gridy = 2;
		contentPane.add(rdbtnM, gbc_rdbtnM);
		rdbtnM.setOpaque(false);
		
		JRadioButton rdbtnN = new JRadioButton("N");
		rdbtnN.setForeground(new Color(240, 255, 240));
		rdbtnN.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnN = new GridBagConstraints();
		gbc_rdbtnN.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnN.gridx = 3;
		gbc_rdbtnN.gridy = 2;
		contentPane.add(rdbtnN, gbc_rdbtnN);
		rdbtnN.setOpaque(false);
		
		JRadioButton rdbtnO = new JRadioButton("O");
		rdbtnO.setForeground(new Color(240, 255, 240));
		rdbtnO.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnO = new GridBagConstraints();
		gbc_rdbtnO.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnO.gridx = 4;
		gbc_rdbtnO.gridy = 2;
		contentPane.add(rdbtnO, gbc_rdbtnO);
		rdbtnO.setOpaque(false);
		
		JRadioButton rdbtnP = new JRadioButton("P");
		rdbtnP.setForeground(new Color(240, 255, 240));
		rdbtnP.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnP = new GridBagConstraints();
		gbc_rdbtnP.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnP.gridx = 5;
		gbc_rdbtnP.gridy = 2;
		contentPane.add(rdbtnP, gbc_rdbtnP);
		rdbtnP.setOpaque(false);
		
		JRadioButton rdbtnQ = new JRadioButton("Q");
		rdbtnQ.setForeground(new Color(240, 255, 240));
		rdbtnQ.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnQ = new GridBagConstraints();
		gbc_rdbtnQ.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnQ.gridx = 6;
		gbc_rdbtnQ.gridy = 2;
		contentPane.add(rdbtnQ, gbc_rdbtnQ);
		rdbtnQ.setOpaque(false);
		
		JRadioButton rdbtnR = new JRadioButton("R");
		rdbtnR.setForeground(new Color(240, 255, 240));
		rdbtnR.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnR = new GridBagConstraints();
		gbc_rdbtnR.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnR.gridx = 7;
		gbc_rdbtnR.gridy = 2;
		contentPane.add(rdbtnR, gbc_rdbtnR);
		rdbtnR.setOpaque(false);
		
		JRadioButton rdbtnS = new JRadioButton("S");
		rdbtnS.setForeground(new Color(240, 255, 240));
		rdbtnS.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnS = new GridBagConstraints();
		gbc_rdbtnS.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnS.gridx = 8;
		gbc_rdbtnS.gridy = 2;
		contentPane.add(rdbtnS, gbc_rdbtnS);
		rdbtnS.setOpaque(false);
		
		JRadioButton rdbtnT = new JRadioButton("T");
		rdbtnT.setForeground(new Color(240, 255, 240));
		rdbtnT.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnT = new GridBagConstraints();
		gbc_rdbtnT.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnT.gridx = 9;
		gbc_rdbtnT.gridy = 2;
		contentPane.add(rdbtnT, gbc_rdbtnT);	
		rdbtnT.setOpaque(false);
		
		JRadioButton rdbtnU = new JRadioButton("U");
		rdbtnU.setForeground(new Color(240, 255, 240));
		rdbtnU.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnU = new GridBagConstraints();
		gbc_rdbtnU.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnU.gridx = 0;
		gbc_rdbtnU.gridy = 3;
		contentPane.add(rdbtnU, gbc_rdbtnU);
		rdbtnU.setOpaque(false);
		
		JRadioButton rdbtnV = new JRadioButton("V");
		rdbtnV.setForeground(new Color(240, 255, 240));
		rdbtnV.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnV = new GridBagConstraints();
		gbc_rdbtnV.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnV.gridx = 1;
		gbc_rdbtnV.gridy = 3;
		contentPane.add(rdbtnV, gbc_rdbtnV);
		rdbtnV.setOpaque(false);
		
		JRadioButton rdbtnW = new JRadioButton("W");
		rdbtnW.setForeground(new Color(240, 255, 240));
		rdbtnW.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnW = new GridBagConstraints();
		gbc_rdbtnW.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnW.gridx = 2;
		gbc_rdbtnW.gridy = 3;
		contentPane.add(rdbtnW, gbc_rdbtnW);
		rdbtnW.setOpaque(false);
		
		JRadioButton rdbtnX = new JRadioButton("X");
		rdbtnX.setForeground(new Color(240, 255, 240));
		rdbtnX.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnX = new GridBagConstraints();
		gbc_rdbtnX.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnX.gridx = 3;
		gbc_rdbtnX.gridy = 3;
		contentPane.add(rdbtnX, gbc_rdbtnX);
		rdbtnX.setOpaque(false);
		
		JRadioButton rdbtnY = new JRadioButton("Y");
		rdbtnY.setForeground(new Color(240, 255, 240));
		rdbtnY.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnY = new GridBagConstraints();
		gbc_rdbtnY.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnY.gridx = 4;
		gbc_rdbtnY.gridy = 3;
		contentPane.add(rdbtnY, gbc_rdbtnY);
		rdbtnY.setOpaque(false);
		
		JRadioButton rdbtnZ = new JRadioButton("Z");
		rdbtnZ.setForeground(new Color(240, 255, 240));
		rdbtnZ.setFont(new Font("Aharoni", Font.PLAIN, 15));
		GridBagConstraints gbc_rdbtnZ = new GridBagConstraints();
		gbc_rdbtnZ.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnZ.gridx = 5;
		gbc_rdbtnZ.gridy = 3;
		contentPane.add(rdbtnZ, gbc_rdbtnZ);
		rdbtnZ.setOpaque(false);
		
		//Code for creating a radio button for the selection to return to after each time that a letter was picked
		JRadioButton rdbtnDefault = new JRadioButton("");
		rdbtnDefault.setSelected(true);
		GridBagConstraints gbc_rdbtnDefault = new GridBagConstraints();
		gbc_rdbtnDefault.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnDefault.gridx = 6;
		gbc_rdbtnDefault.gridy = 3;
		contentPane.add(rdbtnDefault, gbc_rdbtnDefault);
		rdbtnDefault.setOpaque(false);
		
		//Add each of the radio buttons to a button group
		ButtonGroup letters = new ButtonGroup();
		letters.add(rdbtnA);
		letters.add(rdbtnB);
		letters.add(rdbtnC);
		letters.add(rdbtnD);
		letters.add(rdbtnE);
		letters.add(rdbtnF);
		letters.add(rdbtnG);
		letters.add(rdbtnH);
		letters.add(rdbtnI);
		letters.add(rdbtnJ);
		letters.add(rdbtnK);
		letters.add(rdbtnL);
		letters.add(rdbtnM);
		letters.add(rdbtnN);
		letters.add(rdbtnO);
		letters.add(rdbtnP);
		letters.add(rdbtnQ);
		letters.add(rdbtnR);
		letters.add(rdbtnS);
		letters.add(rdbtnT);
		letters.add(rdbtnU);
		letters.add(rdbtnV);
		letters.add(rdbtnW);
		letters.add(rdbtnX);
		letters.add(rdbtnY);
		letters.add(rdbtnZ);		
		letters.add(rdbtnDefault);
		
		//Code for creating a JLabel that holds Correct Letters: 
		JLabel correctLettersLabel = new JLabel("Correct Letters:");
		correctLettersLabel.setForeground(new Color(240, 255, 240));
		correctLettersLabel.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		GridBagConstraints gbc_correctLettersLabel = new GridBagConstraints();
		gbc_correctLettersLabel.gridwidth = 3;
		gbc_correctLettersLabel.insets = new Insets(0, 0, 5, 5);
		gbc_correctLettersLabel.gridx = 3;
		gbc_correctLettersLabel.gridy = 4;		
		contentPane.add(correctLettersLabel, gbc_correctLettersLabel);
		
		//Code for creating a JLabel that holds Incorrect Letters:
		JLabel incorrectLettersLabel = new JLabel("Incorrect Letters:");
		incorrectLettersLabel.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		incorrectLettersLabel.setForeground(new Color(240, 255, 240));
		GridBagConstraints gbc_incorrectLettersLabel = new GridBagConstraints();
		gbc_incorrectLettersLabel.gridwidth = 3;
		gbc_incorrectLettersLabel.insets = new Insets(0, 0, 5, 5);
		gbc_incorrectLettersLabel.gridx = 7;
		gbc_incorrectLettersLabel.gridy = 4;
		contentPane.add(incorrectLettersLabel, gbc_incorrectLettersLabel);						
		
		//Code for creating the JButton for guessing an individual letter in the word and its button listener
		letterGuessButton = new JButton("GUESS LETTER");
		letterGuessButton.setBackground(new Color(255, 255, 255));
		letterGuessButton.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		letterGuessButton.addActionListener(new ActionListener() {
			
			private String newWord;

			@Override
			public void actionPerformed(ActionEvent event) {
										
					try{					
						
						//Create a StringBuilder version of invWord, initialized on line 1506
						StringBuilder invWordBuilder = new StringBuilder(invWord);
						
						//If the A radio button is selected, do the following
						if(rdbtnA.isSelected())
						{
							//If the letter A is in the word, do the following
							if(lettersArray.contains('A'))
							{													
								//Get the index of the letter A in the lettersArray
								int removed = lettersArray.indexOf('A');	
								//Get the index of the letter A in the selectedWord String
								int place = selectedWord.indexOf('A');
								//In the StringBuilder, set the character at the same index of A in the selected word to 'A' instead of '*'
								invWordBuilder.setCharAt(place, 'A');	
								//Convert the StringBuilder back to a string called newWord
								this.newWord = invWordBuilder.toString();
								//Set the text of the correctTextArea to continue to display the previous text, then on the new line, display newWord 
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								//Remove letter A from the lettersArray
								lettersArray.remove(removed);
								//Play the "correct" sound effect
								correctSound.play();
							}
							//If the letter A is not in the word, do the following
							else
							{
								//Add letter A to the incorrectTextArea
								incorrectTextArea.append("A");
								//Play the "incorrect" sound effect
								incorrectSound.play();
																
							}
							//Make A disabled so it can't be selected again, and reselect the default radio button
							rdbtnA.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						//Repeat the above code for each letter of the alphabet
						if(rdbtnB.isSelected())
						{
							if(lettersArray.contains('B'))
							{
								int removed = lettersArray.indexOf('B');
								int place = selectedWord.indexOf('B');
								invWordBuilder.setCharAt(place, 'B');	
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("B");
								incorrectSound.play();
								
							}
							rdbtnB.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnC.isSelected())
						{
							if(lettersArray.contains('C'))
							{
								int removed = lettersArray.indexOf('C');
								int place = selectedWord.indexOf('C');
								invWordBuilder.setCharAt(place, 'C');	
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("C");
								incorrectSound.play();
								
							}
							rdbtnC.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnD.isSelected())
						{
							if(lettersArray.contains('D'))
							{
								int removed = lettersArray.indexOf('D');
								int place = selectedWord.indexOf('D');
								invWordBuilder.setCharAt(place, 'D');	
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);				
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("D");
								incorrectSound.play();
								
							}
							rdbtnD.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnE.isSelected())
						{
							if(lettersArray.contains('E'))
							{
								int removed = lettersArray.indexOf('E');
								int place = selectedWord.indexOf('E');
								invWordBuilder.setCharAt(place, 'E');	
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("E");
								incorrectSound.play();
								
							}
							rdbtnE.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnF.isSelected())
						{
							if(lettersArray.contains('F'))
							{
								int removed = lettersArray.indexOf('F');
								int place = selectedWord.indexOf('F');
								invWordBuilder.setCharAt(place, 'F');		
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);			
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("F");
								incorrectSound.play();
								
							}
							rdbtnF.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnG.isSelected())
						{
							if(lettersArray.contains('G'))
							{
								int removed = lettersArray.indexOf('G');
								int place = selectedWord.indexOf('G');
								invWordBuilder.setCharAt(place, 'G');		
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("G");
								incorrectSound.play();
								
							}
							rdbtnG.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnH.isSelected())
						{
							if(lettersArray.contains('H'))
							{
								int removed = lettersArray.indexOf('H');
								int place = selectedWord.indexOf('H');
								invWordBuilder.setCharAt(place, 'H');		
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("H");
								incorrectSound.play();
								
							}
							rdbtnH.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnI.isSelected())
						{
							if(lettersArray.contains('I'))
							{
								int removed = lettersArray.indexOf('I');
								int place = selectedWord.indexOf('I');
								invWordBuilder.setCharAt(place, 'I');	
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("I");
								incorrectSound.play();
								
							}
							rdbtnI.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnJ.isSelected())
						{
							if(lettersArray.contains('J'))
							{
								int removed = lettersArray.indexOf('J');
								int place = selectedWord.indexOf('J');
								invWordBuilder.setCharAt(place, 'J');	
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("J");
								incorrectSound.play();
								
							}
							rdbtnJ.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnK.isSelected())
						{
							if(lettersArray.contains('K'))
							{
								int removed = lettersArray.indexOf('K');
								int place = selectedWord.indexOf('K');
								invWordBuilder.setCharAt(place, 'K');
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("K");
								incorrectSound.play();
								
							}
							rdbtnK.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnL.isSelected())
						{
							if(lettersArray.contains('L'))
							{
								int removed = lettersArray.indexOf('L');
								int place = selectedWord.indexOf('L');
								invWordBuilder.setCharAt(place, 'L');		
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);		
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("L");
								incorrectSound.play();
								
							}
							rdbtnL.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnM.isSelected())
						{
							if(lettersArray.contains('M'))
							{
								int removed = lettersArray.indexOf('M');
								int place = selectedWord.indexOf('M');
								invWordBuilder.setCharAt(place, 'M');	
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("M");
								incorrectSound.play();
								
							}
							rdbtnM.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnN.isSelected())
						{
							if(lettersArray.contains('N'))
							{
								int removed = lettersArray.indexOf('N');
								int place = selectedWord.indexOf('N');
								invWordBuilder.setCharAt(place, 'N');	
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("N");
								incorrectSound.play();
								
							}
							rdbtnN.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnO.isSelected())
						{
							if(lettersArray.contains('O'))
							{
								int removed = lettersArray.indexOf('O');
								int place = selectedWord.indexOf('O');
								invWordBuilder.setCharAt(place, 'O');		
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("O");
								incorrectSound.play();
								
							}
							rdbtnO.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnP.isSelected())
						{
							if(lettersArray.contains('P'))
							{
								int removed = lettersArray.indexOf('P');
								int place = selectedWord.indexOf('P');
								invWordBuilder.setCharAt(place, 'P');	
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("P");
								incorrectSound.play();
								
							}
							rdbtnP.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnQ.isSelected())
						{
							if(lettersArray.contains('Q'))
							{
								int removed = lettersArray.indexOf('Q');
								int place = selectedWord.indexOf('Q');
								invWordBuilder.setCharAt(place, 'Q');		
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("Q");
								incorrectSound.play();
								
							}
							rdbtnQ.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnR.isSelected())
						{
							if(lettersArray.contains('R'))
							{
								int removed = lettersArray.indexOf('R');
								int place = selectedWord.indexOf('R');
								invWordBuilder.setCharAt(place, 'R');	
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("R");
								incorrectSound.play();
								
							}
							rdbtnR.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnS.isSelected())
						{
							if(lettersArray.contains('S'))
							{
								int removed = lettersArray.indexOf('S');
								int place = selectedWord.indexOf('S');
								invWordBuilder.setCharAt(place, 'S');	
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("S");
								incorrectSound.play();
								
							}
							rdbtnS.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnT.isSelected())
						{
							if(lettersArray.contains('T'))
							{
								int removed = lettersArray.indexOf('T');
								int place = selectedWord.indexOf('T');
								invWordBuilder.setCharAt(place, 'T');	
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("T");
								incorrectSound.play();
								
							}
							rdbtnT.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnU.isSelected())
						{
							if(lettersArray.contains('U'))
							{
								int removed = lettersArray.indexOf('U');
								int place = selectedWord.indexOf('U');
								invWordBuilder.setCharAt(place, 'U');		
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("U");
								incorrectSound.play();
								
							}
							rdbtnU.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnV.isSelected())
						{
							if(lettersArray.contains('V'))
							{
								int removed = lettersArray.indexOf('V');
								int place = selectedWord.indexOf('V');
								invWordBuilder.setCharAt(place, 'V');		
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("V");
								incorrectSound.play();
								
							}
							rdbtnV.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnW.isSelected())
						{
							if(lettersArray.contains('W'))
							{
								int removed = lettersArray.indexOf('W');
								int place = selectedWord.indexOf('W');
								invWordBuilder.setCharAt(place, 'W');
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("W");
								incorrectSound.play();
								
							}
							rdbtnW.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnX.isSelected())
						{
							if(lettersArray.contains('X'))
							{
								int removed = lettersArray.indexOf('X');
								int place = selectedWord.indexOf('X');
								invWordBuilder.setCharAt(place, 'X');		
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("X");
								incorrectSound.play();
																
							}
							rdbtnX.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnY.isSelected())
						{
							if(lettersArray.contains('Y'))
							{
								int removed = lettersArray.indexOf('Y');
								int place = selectedWord.indexOf('Y');
								invWordBuilder.setCharAt(place, 'Y');	
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("Y");
								incorrectSound.play();
								
							}
							rdbtnY.setEnabled(false);
							rdbtnDefault.setSelected(true);
						}
						if(rdbtnZ.isSelected())
						{
							if(lettersArray.contains('Z'))
							{
								int removed = lettersArray.indexOf('Z');
								int place = selectedWord.indexOf('Z');
								invWordBuilder.setCharAt(place, 'Z');		
								this.newWord = invWordBuilder.toString();
								correctTextArea.setText(correctTextArea.getText() + "\n" + newWord);
								lettersArray.remove(removed);
								correctSound.play();
							}
							else
							{
								incorrectTextArea.append("Z");
								incorrectSound.play();
								
							}
							rdbtnZ.setEnabled(false);
							rdbtnDefault.setSelected(true);							
						}						
						
						//Set an integer variable equal to the length of the incorrect text area
						int textLength = incorrectTextArea.getText().length();
						
						//If all letters have been removed from the lettersArray, do the following
						if(lettersArray.isEmpty())
						{			
							//Draw Winner! in the HangmanFrame
							draw.setCounter(10);
							draw.repaint();
							//If the playerNameField is empty, print out the following to the console
							if(playerNameField.getText().equals(""))
							{
								System.out.println("Congrats, you win! Your word was: " + selectedWord);
							}
							//If the playerNameField is contains something, print out the following to the console
							else
							{
								System.out.println("Congrats, " + playerNameField.getText() + ", you win! Your word was: " + selectedWord);
							}
							//Disable both JButtons and play the winning sound
							letterGuessButton.setEnabled(false);
							wordGuessButton.setEnabled(false);
							winnerSound.play();
						}
						//If there are still letters in the lettersArray
						else
						{
							//Set the counter in the HangmanComponent equal to the incorrectTextArea text length
							draw.setCounter(textLength);
							//Draw any limbs on the hangman if necessary
							draw.repaint();
						}											
						
						//If the length of the incorrectTextArea equals 7, do the following
						if(textLength == 7)
						{				
							//If the playerNameField is empty, print out the following to the console
							if(playerNameField.getText().equals(""))
							{
								System.out.println("You were hanged! Game Over. Your word was: " +  selectedWord);
							}
							//If the playerNameField contains something, print out the following to the console
							else
							{
								System.out.println(playerNameField.getText() + " was hanged! Game Over. Your word was: " + selectedWord);
							}
							//Disable both JButtons and play the losing sound
							letterGuessButton.setEnabled(false);
							wordGuessButton.setEnabled(false);
							loserSound.play();
						}												
											
					}
				catch(Exception e){
					e.printStackTrace();
				}

			}			
		});
		GridBagConstraints gbc_letterGuessButton = new GridBagConstraints();
		gbc_letterGuessButton.gridwidth = 2;
		gbc_letterGuessButton.insets = new Insets(0, 0, 0, 5);
		gbc_letterGuessButton.gridx = 1;
		gbc_letterGuessButton.gridy = 5;
		contentPane.add(letterGuessButton, gbc_letterGuessButton);		
		
		//Code for creating the JTextArea that will have the correct guesses printed in it
		correctTextArea = new JTextArea();
		correctTextArea.setForeground(new Color(240, 255, 240));
		correctTextArea.setBackground(new Color(0, 180, 255));
		correctTextArea.setFont(new Font("Aharoni", Font.PLAIN, 15));
		correctTextArea.setEditable(false);
		correctTextArea.setLineWrap(true);
		GridBagConstraints gbc_correctTextArea = new GridBagConstraints();
		gbc_correctTextArea.gridwidth = 2;
		gbc_correctTextArea.insets = new Insets(0, 0, 0, 5);
		gbc_correctTextArea.fill = GridBagConstraints.BOTH;
		gbc_correctTextArea.gridx = 4;
		gbc_correctTextArea.gridy = 5;
		contentPane.add(correctTextArea, gbc_correctTextArea);
		//For each letter in the selected word, add a star to the correctTextArea
		for(int i=0; i<lettersArray.size(); i++)
		{
			correctTextArea.append("*");
		}
		//Initialize invWord as the stars originally appended to the correctTextArea
		this.invWord = correctTextArea.getText();
		
		//Code for creating the JTextArea that will hold the incorrect guesses
		incorrectTextArea = new JTextArea();
		incorrectTextArea.setBackground(new Color(0, 180, 255));
		incorrectTextArea.setForeground(new Color(240, 255, 240));
		incorrectTextArea.setFont(new Font("Aharoni", Font.PLAIN, 15));
		incorrectTextArea.setEditable(false);
		incorrectTextArea.setLineWrap(true);
		GridBagConstraints gbc_incorrectTextArea = new GridBagConstraints();
		gbc_incorrectTextArea.insets = new Insets(0, 0, 0, 5);
		gbc_incorrectTextArea.gridwidth = 3;
		gbc_incorrectTextArea.fill = GridBagConstraints.BOTH;
		gbc_incorrectTextArea.gridx = 7;
		gbc_incorrectTextArea.gridy = 5;
		contentPane.add(incorrectTextArea, gbc_incorrectTextArea);		
	}			
	
}
