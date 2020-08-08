
public class SolutionIslandPerimeter {

	static int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					perimeter += 4 - surroundedSides(grid, i, j);
				}
			}
		}
		System.out.println(perimeter);
		return perimeter;
	}

	static int surroundedSides(int[][] grid, int i, int j) {
		int count = 0;
		if (i > 0 && grid[i - 1][j] == 1) {
			count++;
		}
		if (i < grid.length - 1 && grid[i + 1][j] == 1) {
			count++;
		}
		if (j > 0 && grid[i][j - 1] == 1) {
			count++;
		}
		if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		SolutionIslandPerimeter.islandPerimeter(new int[][] { { 1, 1, 1 }, { 1, 0, 1 } });
		// { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } });
	}

}
