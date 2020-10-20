package september.week3;

public class SolutionCarPooling {

	public boolean carPooling(int[][] trips, int capacity) {

		int[] time = new int[1001];
		for (int[] trip : trips) {
			time[trip[1]] += trip[0];
			time[trip[2]] -= trip[0];
		}

		for (int i : time) {
			capacity -= i;
			if (capacity < 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		SolutionCarPooling sol = new SolutionCarPooling();
		System.out.println(sol.carPooling(new int[][] { { 7, 5, 6 }, { 6, 7, 8 }, { 10, 1, 6 } }, 16));
	}
}
