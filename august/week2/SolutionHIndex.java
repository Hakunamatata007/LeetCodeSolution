package august.week2;

import java.util.Arrays;

//https://leetcode.com/problems/h-index/
public class SolutionHIndex {

	public int hIndexWithSort(int[] citations) { // O(nLogn)
		Arrays.sort(citations);

		int result = 0;
		for (int i = citations.length - 1; i >= 0; i--) {
			int cnt = citations.length - i;
			if (citations[i] >= cnt) {
				result = cnt;
			} else {
				break;
			}
		}

		return result;
	}

	public int hIndexWithoutSort(int[] citations) {// O(n)

		int[] cntArray = new int[citations.length + 1];
		for (int i : citations) {
			if (i > citations.length)
				cntArray[citations.length]++;
			else
				cntArray[i]++;
		}
		int cnt = 0;
		for (int i = cntArray.length - 1; i >= 0; i--) {
			cnt += cntArray[i];
			if (cnt >= i) {
				return i;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		SolutionHIndex sol = new SolutionHIndex();
		System.out.println(sol.hIndexWithoutSort(new int[] { 11, 15 }));

	}

}
