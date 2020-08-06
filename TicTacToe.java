public class TicTacToe {
	// declare array
	static String[] board = new String[9];

	// function to reset the board and set square position 1 to 9
	static void resetBoard() {
		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a + 1);
		}
		System.out.println("Welcome to Tic Tac Toe Game!!!");
		System.out.println("your board is reseted!!!");

	}

	public static void main(String[] args) {
		resetBoard();
	}

}
