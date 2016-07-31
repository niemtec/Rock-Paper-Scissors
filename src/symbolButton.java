import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class symbolButton extends JButton implements ActionListener {
	static ImageIcon rock, paper, scissors;

	public symbolButton() {
		this.setBackground(Color.black);

		try {
			rock = new ImageIcon(ImageIO.read(GameWindow.class.getResource("resources/rock.png")));
			paper = new ImageIcon(ImageIO.read(GameWindow.class.getResource("resources/paper.png")));
			scissors = new ImageIcon(ImageIO.read(GameWindow.class.getResource("resources/scissors.png")));
		} catch (IOException e) {
			System.out.println("One one or more of the icon images is missing from the resources folder");
		}

		//Add action listener to the button
		this.addActionListener(this);
	}

	//Check whether the grid button has been pressed
	public void actionPerformed(ActionEvent e) {
		//Get source of the click
		Object click = e.getSource();

		for (int i = 0; i < GameWindow.leftButton.length; i++) {
			if (click == GameWindow.leftButton[i]) {
				switch (i) {
					case 0:
						Main.userChoice = "rock";
						break;

					case 1:
						Main.userChoice = "paper";
						break;

					case 2:
						Main.userChoice = "scissors";
						break;

					default:
						Main.userChoice = null;
						break;
				}


				//Disable current button
				GameWindow.leftButton[i].setEnabled(false);
				break;
			}
		}
	}
}
