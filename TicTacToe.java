import java.util.Random;

public class TicTacToe {

	// declare array
	static String[] board = new String[9];
	static String turn;
	
	// function to reset the board and set square position 1 to 9
	static void resetBoard() {
		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a + 1);
		}
		System.out.println("Welcome to Tic Tac Toe Game!!!");
		System.out.println("your board is reseted!!!");

	}

	// function to decide get toss number
	public static int getTossNumber() {
		Random random = new Random();
		return random.nextInt(2) + 1;
	}

	static int toss = getTossNumber();

	// function to decide who plays first
	public static void getPlayerFirst() {
		if (toss == 1) {
			turn="X";
			System.out.println("player 1 won the toss!!!"+"choose letter: "+turn);

		} else {
			System.out.println("player 2  won the toss!!!");

		}
	}
	public static void main(String[] args) {
		resetBoard();
		getPlayerFirst();
	}



}
