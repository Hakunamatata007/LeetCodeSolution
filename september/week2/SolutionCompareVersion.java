package september.week2;

import java.util.Arrays;

public class SolutionCompareVersion {

	public int compareVersion(String version1, String version2) {

		String[] str1 = version1.split("\\.");
		String[] str2 = version2.split("\\.");

		int maxlength = str1.length < str2.length ? str2.length : str1.length;
		int i;
		for (i = 0; i < maxlength; i++) {
			Integer val1 = str1.length > i ? Integer.parseInt(str1[i]) : 0;
			Integer val2 = str2.length > i ? Integer.parseInt(str2[i]) : 0;
			int compare = val1.compareTo(val2);
			if (compare != 0)
				return compare;
		}
		return 0;
	}

	public int numberOfMoves(int i1, int i2, int i3, int i4, int i5) {

		int[] arr = new int[] { i1, i2, i3, i4, i5 };
		int moves = 0;
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		if (sum % 5 != 0)
			return -1;
		int bucketSize = sum / 5;
		for (int i : arr) {
			moves += i < bucketSize ? bucketSize - i : 0;
		}
		return moves;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionCompareVersion sol = new SolutionCompareVersion();
		// System.out.println(sol.compareVersion("7", "7.1"));
		System.out.println(sol.numberOfMoves(1, 6, 1, 1, 1));
	}

}
