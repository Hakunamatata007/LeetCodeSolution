package october.week1;

import java.util.Arrays;
import java.util.Comparator;

public class SolutionRemoveCoveredInterval {

	public int removeCoveredIntervals(int[][] intervals) {

		Comparator<int[]> intComparator = (o1, o2) -> {
			return Integer.compare(o1[0], o2[0]);
		};
		int count = 0;
		int[] curr = new int[] { -1, -1 };
		Arrays.sort(intervals, intComparator);
		for (int[] in : intervals) {
			if (in[0] > curr[0] && in[1] > curr[1]) {
				count++;
				curr[0] = in[0];
			}
			curr[1] = Math.max(curr[1], in[1]);
		}
		return count;
	}

	public static void main(String[] args) {
		SolutionRemoveCoveredInterval sol = new SolutionRemoveCoveredInterval();
		System.out.println(~ 5);
		System.out.println(sol.removeCoveredIntervals(new int[][] { { 1, 4 }, { 2, 3 } }));
	}

}
