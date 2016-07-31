import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static javax.swing.JFrame.*;

/**
 * Contains all the graphical elements of the game.
 */

public class GameWindow implements ActionListener {
	public static JButton leftButton[] = new symbolButton[3];
	public static JButton rock, paper, scissors, computerChoice;
	public static JLabel resultLabel;
	public int paddingSize = 5;
	static ImageIcon rockIcon, paperIcon, scissorsIcon, defaultIcon;

	//JFrame Constructor
	public GameWindow() {
		//Define button icons
		try {
			rockIcon = new ImageIcon(ImageIO.read(GameWindow.class.getResource("resources/rock.png")));
			paperIcon = new ImageIcon(ImageIO.read(GameWindow.class.getResource("resources/paper.png")));
			scissorsIcon = new ImageIcon(ImageIO.read(GameWindow.class.getResource("resources/scissors.png")));
			defaultIcon = new ImageIcon(ImageIO.read(GameWindow.class.getResource("resources/default.png")));
		} catch (IOException e) {
			System.out.println("One one or more of the icon images is missing from the resources folder");
		}

		//GameWindow Properties
		//This is the main window containing all the properties
		int windowHeight = 500;
		int windowWidth = 380;
		JFrame gameWindowFrame = new JFrame();
		gameWindowFrame.setSize(windowWidth, windowHeight);
		gameWindowFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gameWindowFrame.setResizable(false);
		gameWindowFrame.setTitle("Rock Paper Scissors");
		gameWindowFrame.setLocationRelativeTo(null);   //centers the window

		//Rock button properties
		rock = new JButton();
		rock.setIcon(rockIcon);
		rock.setBackground(Color.decode("#105D92"));
		rock.setFocusPainted(false);
		rock.addActionListener(this);

		//Paper button properties
		paper = new JButton();
		paper.setIcon(paperIcon);
		paper.setBackground(Color.decode("#FEC658"));
		paper.setFocusPainted(false);
		paper.addActionListener(this);

		//Scissors button properties
		scissors = new JButton();
		scissors.setIcon(scissorsIcon);
		scissors.setBackground(Color.decode("#EF3B6E"));
		scissors.setFocusPainted(false);
		scissors.addActionListener(this);

		//Computer Choice indicator button properties
		computerChoice = new JButton();
		computerChoice.setEnabled(false);
		computerChoice.setIcon(defaultIcon);
		computerChoice.setDisabledIcon(defaultIcon);
		computerChoice.setBackground(Color.decode("#B5E61D"));


		//Result label properties
		resultLabel = new JLabel("Make your move");
		resultLabel.setSize(windowWidth/3, windowHeight/2);
		resultLabel.setBackground(null);


		//NORTH panel properties
		JPanel northPanel = new JPanel();
		northPanel.add(resultLabel, SwingConstants.CENTER);

		//CENTER panel properties
		JLabel computerPanelTitle = new JLabel("Computer's Choice:", SwingConstants.CENTER);
		JPanel centerPanel = new JPanel();
		centerPanel.setSize(390, 390);
		centerPanel.setLayout(new BorderLayout(paddingSize, paddingSize));
		centerPanel.setBorder(new EmptyBorder(paddingSize, paddingSize*2, paddingSize*2, paddingSize*2));
		centerPanel.add(computerPanelTitle, BorderLayout.NORTH);
		centerPanel.add(computerChoice, BorderLayout.CENTER);

		//SOUTH panel properties
		JLabel userPanelTitle = new JLabel("State your choice:", SwingConstants.CENTER);
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout(paddingSize, paddingSize));
		southPanel.setBorder(new EmptyBorder(paddingSize, paddingSize*2, paddingSize*2, paddingSize*2));
		southPanel.add(userPanelTitle, BorderLayout.NORTH);
		southPanel.add(rock, BorderLayout.WEST);
		southPanel.add(paper, BorderLayout.CENTER);
		southPanel.add(scissors, BorderLayout.EAST);

		//Add all components to the frame (border layout)
		gameWindowFrame.setLayout(new BorderLayout(paddingSize, paddingSize));
		gameWindowFrame.add(southPanel, BorderLayout.SOUTH);
		gameWindowFrame.add(northPanel, BorderLayout.NORTH);
		gameWindowFrame.add(centerPanel, BorderLayout.CENTER);

		northPanel.setVisible(true);
		centerPanel.setVisible(true);
		southPanel.setVisible(true);
		rock.setVisible(true);
		paper.setVisible(true);
		scissors.setVisible(true);
		computerChoice.setVisible(true);
		resultLabel.setVisible(true);
		userPanelTitle.setVisible(true);
		gameWindowFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rock) {
			Main.userChoice = "rock";
		} else if (e.getSource() == paper) {
			Main.userChoice = "paper";
		} else {
			Main.userChoice = "scissors";
		}

		Main.computerMove();
		//For now, print out the winner
		resultLabel.setText(Main.checkForWinner());
		System.out.println(Main.checkForWinner());
	}

	public static void setComputerIcon(String icon) {
		switch (icon) {
			case "rock":
				computerChoice.setDisabledIcon(rockIcon);
				computerChoice.setBackground(Color.decode("#105D92"));
				break;

			case "paper":
				computerChoice.setDisabledIcon(paperIcon);
				computerChoice.setBackground(Color.decode("#FEC658"));
				break;

			case "scissors":
				computerChoice.setDisabledIcon(scissorsIcon);
				computerChoice.setBackground(Color.decode("#EF3B6E"));
				break;

			default:
				computerChoice.setDisabledIcon(defaultIcon);
				computerChoice.setBackground(Color.decode("#B5E61D"));
				break;
		}
	}
}