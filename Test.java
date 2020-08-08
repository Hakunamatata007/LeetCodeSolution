import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

class Solution {

	public int[][] reconstructQueue(int[][] people) {
		int row = people.length;
		if (row == 0) {
			int arr[][] = {};
			return arr;
		}
		int column = people[0].length;

		Arrays.sort(people, (a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			} else
				return a[0] - b[0];
		});
		int[][] result = new int[row][column];
		System.out.println(Arrays.deepToString(people));
		for (int i = 0; i < people.length; i++) {

			int counter = people[i][1];
			int index = counter;
			int height = people[i][0];

			for (int j = 0; j < result.length; j++) {
				if (result[j][0] == 0) {
					if (counter == 0) {
						result[j] = people[i];
						j = result.length;
					} else {
						counter--;
					}
				} else {
					if (result[j][0] == people[i][0])
						counter--;
				}
			}
		}
		System.out.println(Arrays.deepToString(result));
		return result;

	}

	/**
	 * @param people
	 * @return
	 */
	public int[][] reconstructQueue1(int[][] people) {
		if (people == null || people.length == 0) {
			return new int[0][0];
		}

		Arrays.sort(people, (a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			} else {
				return b[0] - a[0];
			}
		});
		System.out.println(Arrays.deepToString(people));
		LinkedList<int[]> list = new LinkedList<>();
		for (int[] p : people) {
			list.add(p[1], p);
			for (int k = 0; k < list.size(); k++) {
				System.out.println("Element at index " + k + ": " + list.get(k));
			}

		}

		return list.toArray(new int[people.length][2]);
	}

}

public class Test {

	public static void main(String[] args) {

		int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };

 	}

}
