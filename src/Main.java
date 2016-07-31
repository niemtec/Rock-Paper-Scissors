import java.util.Random;

public class Main {

	public static String userChoice;
	private static String computerChoice;
	private static String turnResult;

	public static void main(String args[]) {
		new GameWindow();
	}

	public static void computerMove() {
		Random rand = new Random();

		int random = rand.nextInt(3)+1;
		switch (random) {
			case 1:
				computerChoice = "rock";
				break;

			case 2:
				computerChoice = "paper";
				break;

			case 3:
				computerChoice = "scissors";
				break;

			default:
				computerChoice = null;
				break;
		}
		GameWindow.setComputerIcon(computerChoice);
	}

	public static String checkForWinner() {

		switch (userChoice) {
			case "rock":
				if (computerChoice.equals("rock")) {
					turnResult = "It's a draw!";
				} else if (computerChoice.equals("paper")) {
					turnResult = "Paper beats Rock! \nComputer wins.";
				} else {
					turnResult = "Rock beats Scissors! \nYou win.";
				}
				break;

			case "paper":
				if (computerChoice.equals("paper")) {
					turnResult = "It's a draw!";
				} else if (computerChoice.equals("rock")) {
					turnResult = "Paper beats Rock! \nYou win.";
				} else {
					turnResult = "Scissors beat Paper! \nComputer wins!";
				}
				break;

			case "scissors":
				if (computerChoice.equals("scissors")) {
					turnResult = "It's a draw";
				} else if (computerChoice.equals("rock")) {
					turnResult = "Rock beats Scissors. \nComputer wins!";
				} else {
					turnResult = "Scissors beat Paper! \nYou win.";
				}
				break;
		}
		return (turnResult);
	}
}
