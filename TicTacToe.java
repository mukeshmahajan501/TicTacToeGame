import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	// variable declaration

	static String[] board;
	static String turn;
	static String playerTurn;

	// function playing decide Game won or draw 

	public void playing() {
		Scanner in = new Scanner(System.in);
		board = new String[9];
		String winner = null;
		populateEmptyBoard();

		System.out.println("Welcome to 2 Player Tic Tac Toe.");
		System.out.println("--------------------------------");
		printBoard();

		if (getPlayerFirst() == "X") {
			turn = "X";
			playerTurn = "player1";
		} else {
			turn = "O";
			playerTurn = "player2";
		}

		System.out.println(playerTurn + "'s turn; enter a slot number to place " + turn + " in:");

		while (winner == null) {

			int numInput;
			try {
				numInput = in.nextInt();
				if (!(numInput > 0 && numInput <= 9)) {
					System.out.println("Invalid input; re-enter slot number:");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input; re-enter slot number:");
				continue;
			}
			if (board[numInput - 1].equals(String.valueOf(numInput))) {
				board[numInput - 1] = turn;
				if (turn.equals("X")) {
					turn = "O";
					playerTurn = "player2";

				} else {
					turn = "X";
					playerTurn = "player1";

				}
				printBoard();
				winner = checkWinner();
			} else {
				System.out.println("Slot already taken; re-enter slot number:");
				continue;
			}
		}
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println("It's a draw! Thanks for playing.");
		} else {
			System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
		}

		while (winner.equals("draw") || winner.equals("player 1") || winner.equals("player 2")) {
		//	Scanner sc = new Scanner(System.in);
			System.out.println("you want to Restart the game!!:Enter 1");
			System.out.println("you want to exit !!:Enter 2");
			System.out.println("enter your choice: ");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				playing();
				break;

			case 2:
				System.exit(0);
			default:
				System.out.println("wrong input!!!");
				break;
			}
		}
		in.close();
	}

	// function to check player 1 won or player 2 or draw a game
	public String checkWinner() {
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			if (line.equals("XXX")) {
				return "player 1";
			} else if (line.equals("OOO")) {
				return "player 2";
			}
		}

		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(String.valueOf(a + 1))) {
				break;
			} else if (a == 8)
				return "draw";
		}

		System.out.println(playerTurn + "'s turn; enter a slot number to place " + turn + " in:");
		return null;
	}

	// print a board
	public void printBoard() {
		System.out.println("/---|---|---\\");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("/---|---|---\\");
	}

	// print empty board
	void populateEmptyBoard() {
		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a + 1);
		}
	}

	// function to decide get toss number
	public int getTossNumber() {
		Random random = new Random();
		return random.nextInt(2) + 1;
	}

	int toss = getTossNumber();

	// function to decide who plays first
	public String getPlayerFirst() {
		if (toss == 1) {
			turn = "X";
			System.out.println("player 1 won the toss!!!" + "choose letter: " + turn);

			return turn;

		} else {
			turn = "O";
			System.out.println("player 2  won the toss!!!" + "choose letter : " + turn);
			return turn;

		}
	}

	public static void main(String[] args) {

		TicTacToe object = new TicTacToe();
		object.playing();
	}

}
