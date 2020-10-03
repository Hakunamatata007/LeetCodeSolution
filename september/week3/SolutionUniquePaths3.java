package september.week3;

public class SolutionUniquePaths3 {

	public int uniquePathsIII(int[][] grid) {

		int sX = 0, sY = 0, eX = 0, eY = 0, zeroes = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					sX = i;
					sY = j;
				} else if (grid[i][j] == 0) {
					zeroes++;
				}
			}
		}
		return pathCombination(grid, zeroes, sX, sY);
	}

	private boolean isValid(int[][] grid, int i, int j) {
		return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
	}

	private int pathCombination(int[][] grid, int zeroes, int i, int j) {

		if (!isValid(grid, i, j) || grid[i][j] == -1)
			return 0;

		if (grid[i][j] == 2) {
			return zeroes == -1 ? 1 : 0;
		}

		int temp = grid[i][j];
		grid[i][j] = -1;
		zeroes--;
		int right = pathCombination(grid, zeroes, i, j + 1);
		int down = pathCombination(grid, zeroes, i + 1, j);
		int left = pathCombination(grid, zeroes, i, j - 1);
		int up = pathCombination(grid, zeroes, i - 1, j);
		grid[i][j] = temp;
		return right + down + left + up;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
