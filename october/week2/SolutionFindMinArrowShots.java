package october.week2;

import java.util.Arrays;

public class SolutionFindMinArrowShots {

	public int findMinArrowShots(int[][] points) {

		Arrays.sort(points, (a, b) -> a[0] - b[0]);
		int count = points.length > 1 ? 1 : 0;
		int[] curr = points[0];
		for (int i = 1; i < points.length; i++) {
			int[] point = points[i];
			if (point[0] >= curr[0] && point[0] <= curr[1]) {
				curr[0] = point[0];
				curr[1] = Math.min(curr[1], point[1]);
			} else {
				count++;
				curr = point;
			}
			// curr[1] = point[1]; // curr[1] = 2
		}
		return count;
	}

	public static void main(String[] args) {
		SolutionFindMinArrowShots sol = new SolutionFindMinArrowShots();
		System.out.println(sol.findMinArrowShots(new int[][] { { 3, 9 }, { 7, 12 }, { 3, 8 }, { 6, 8 }, { 9, 10 },
				{ 2, 9 }, { 0, 9 }, { 3, 9 }, { 0, 6 }, { 2, 8 } }
		// { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } }
		));
	}

}
