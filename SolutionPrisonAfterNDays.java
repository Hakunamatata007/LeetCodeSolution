import java.util.Arrays;

public class SolutionPrisonAfterNDays {

	static int[] prisonAfterNDays(int[] cells, int N) {
		int count = N % 14;
		if (count == 0)
			count = 14;
//		count = 15;
		System.out.println(count);
		while (count != 0) {
			int[] tempCells = cells.clone();
			cells[0] = cells[cells.length - 1] = 0;
			for (int i = 1; i < cells.length - 1; i++) {
				if (tempCells[i - 1] == tempCells[i + 1]) {
					cells[i] = 1;
				} else {
					cells[i] = 0;
				}
			}
			count--;
			System.out.println(Arrays.toString(cells));
		}
		return cells;
	}

	public static void main(String[] args) {

		int[] cells = new int[] { 1, 0, 0, 1, 0, 0, 0, 1 };
		SolutionPrisonAfterNDays.prisonAfterNDays(cells, 826);
	}
	// [1,0,0,1,0,0,0,1] output
	// [0,1,1,0,1,1,1,0] expected

}
