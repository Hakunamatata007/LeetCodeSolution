import java.util.Arrays;

public class SolutionCalculateMinimumHP {

	static int[][] memo;// memorization

	public static int calculateMinimumHP(int[][] dungeon) {
		int rows = dungeon.length;
		int cols = dungeon[0].length;
		memo = new int[rows][cols];

		return dfs(dungeon, rows, cols, 0, 0, 0);
	}

	static int recur(int[][] dungeon, int rows, int cols, int i, int j, int sum) {

		if (i == 0 && j == 0) {

		}
		if (memo[i][j] > 0)
			return memo[i][j];

		if (i == rows - 1) {
			int cost;
			sum = sum + dungeon[i][j];
			if (sum >= 0)
				cost = dungeon[i][j] >= 0 ? 0 : 1 - dungeon[i][j];
			else
				cost = 1 - sum;
			memo[i][j] = cost;
			recur(dungeon, rows, cols, i, j - 1, sum);
			return cost;
		}

		if (i == cols - 1) {
			int cost;
			if (sum >= 0)
				cost = dungeon[i][j] >= 0 ? 0 : 1 - dungeon[i][j];
			else
				cost = 1 - sum;
			memo[i][j] = cost;
			recur(dungeon, rows, cols, i - 1, j, sum + dungeon[i][j]);
			return cost;
		}
Math.pow(2, 2);
		int cost;
		if (sum >= 0)
			cost = dungeon[i][j] >= 0 ? 0 : 1 - dungeon[i][j];
		else
			cost = 1 - sum;
		memo[i][j] = cost;
		int right = recur(dungeon, rows, cols, i - 1, j, sum + dungeon[i][j]);
		int bottom = recur(dungeon, rows, cols, i, j - 1, sum + dungeon[i][j]);

		return 0;
	}

	private static int dfs(int[][] dungeon, int rows, int cols, int i, int j) {
		// get the destination, return
		if (i == rows - 1 && j == cols - 1) {
			return Math.max(1 - dungeon[i][j], 1);
		}

		if (memo[i][j] > 0)
			return memo[i][j];

		// last row
		if (i == rows - 1) {
			memo[i][j] = Math.max(dfs(dungeon, rows, cols, i, j + 1) - dungeon[i][j], 1);
			return memo[i][j];
		}

		// last col
		if (j == cols - 1) {
			memo[i][j] = Math.max(dfs(dungeon, rows, cols, i + 1, j) - dungeon[i][j], 1);
			return memo[i][j];
		}

		memo[i][j] = Math.max(
				Math.min(dfs(dungeon, rows, cols, i + 1, j), dfs(dungeon, rows, cols, i, j + 1)) - dungeon[i][j], 1);
		return memo[i][j];
	}

	public static void main(String[] args) {
		SolutionCalculateMinimumHP.calculateMinimumHP(new int[][] { { -2, -3, 3 }, { -5, -10, 1 }
				// { 10, 30, -5 }
		});
		// { { -2, -3 }, { -5, 10 } });
	}
	// { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } }

}
