
public class SolutionOWithX {

	static void solve(char[][] board) {
		// replace O with X
		// O should not be in border
		// connected with border O (horizontally and vertically)
		if (board.length == 0) {
			return;
		}

		for (int i = 0; i < board[0].length; i++) {
			recur(board, 0, i);
			recur(board, board.length - 1, i);
		}

		for (int i = 0; i < board.length; i++) {
			recur(board, i, 0);
			recur(board, i, board[0].length - 1);
		}

		System.out.println(board);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '1' || board[i][j] == 'O')
					board[i][j] = 'X';
				if (board[i][j] == '2')
					board[i][j] = 'O';

			}
		}
		System.out.println(board);
	}

	static void recur(char[][] board, int i, int j) {
		int m = board.length;
		int n = board[0].length;

		if (i > m - 1 || j > n - 1 || i < 0 || j < 0 || board[i][j] == '1' || board[i][j] == '2') {
			return;
		}

		if (board[i][j] == 'O') {
			board[i][j] = '2';
			recur(board, i + 1, j);
			recur(board, i, j + 1);
			recur(board, i - 1, j);
			recur(board, i, j - 1);
		} else {
			board[i][j] = '1';
		}

	}

	public static void main(String[] args) {
		char[][] board = { { 'X', 'O', 'X', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'X', 'O', 'X' } };

		// [
		// [1, 2, 1, 2, 1, 2],
		// [2, 1, O, 1, O, 1],
		// [1, O, 1, O, 1, 2],
		// [2, 1, 2, 1, O, 1]
		// ]

		// { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
		// { 'X', 'O', 'X', 'X' } };

		// { { 'O' } };

		// { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
		// { 'X', 'O', 'X', 'X' } };
		SolutionOWithX.solve(board);
	}

}
