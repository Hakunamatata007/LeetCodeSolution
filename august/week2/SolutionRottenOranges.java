package august.week2;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3418/

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class SolutionRottenOranges {

	// 2- rotten, 1- fresh, 0- empty
	public int orangesRotting(int[][] grid) {

		int total = 0, rotten = 0;
		int[] count = new int[] { 0 };
		Queue<Pair> queue = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2 || grid[i][j] == 1)
					total++;
				if (grid[i][j] == 2) {
					queue.add(new Pair(i, j));
				}
			}
		}

		if (total == 0)
			return 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			rotten += size;
			if (rotten == total)
				return count[0];
			count[0]++;
			for (int i = 0; i < size; i++) {
				Pair pair = queue.poll();
				adjacentMarking(pair.x, pair.y, grid, queue);
			}
		}
		return -1;
	}

	boolean helper(int i, int j, int[][] grid) {
		return !(i >= grid.length || j >= grid[0].length || i < 0 || j < 0);
	}

	void adjacentMarking(int i, int j, int[][] grid, Queue<Pair> queue) {
		if (helper(i + 1, j, grid) && grid[i + 1][j] == 1) {
			grid[i + 1][j] = 2;
			queue.add(new Pair(i + 1, j));
		}
		if (helper(i, j + 1, grid) && grid[i][j + 1] == 1) {
			grid[i][j + 1] = 2;
			queue.add(new Pair(i, j + 1));
		}
		if (helper(i - 1, j, grid) && grid[i - 1][j] == 1) {
			grid[i - 1][j] = 2;
			queue.add(new Pair(i - 1, j));
		}
		if (helper(i, j - 1, grid) && grid[i][j - 1] == 1) {
			grid[i][j - 1] = 2;
			queue.add(new Pair(i, j - 1));
		}
	}

	public static void main(String[] args) {
		SolutionRottenOranges sol = new SolutionRottenOranges();
		int c = sol.orangesRotting(new int[][] { { 2, 1, 2 }, { 1, 2, 0 }, { 0, 2, 2 } });
		System.out.println("c : " + c);
	}

}
