package october.week3;

import java.util.Arrays;

public class SolutionSearchMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {

		int[] arr = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			arr[i] = matrix[i][0];
		}
		int index1 = binarySearch(arr, target);
		arr = new int[matrix[0].length];
		for (int i = 0; i < matrix[0].length; i++) {
			arr[i] = matrix[index1][i];
		}
		int index2 = binarySearch(arr, target);
		return matrix[index1][index2] == target;

	}

	public int binarySearch(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int start = 0;
		int end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] <= target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		int left = Math.abs(A[start] - target);
		int right = Math.abs(A[end] - target);
		if (left <= right) {
			return start;
		}
		return end;
	}

	public static void main(String[] args) {
		SolutionSearchMatrix sol = new SolutionSearchMatrix();
		System.out.println(sol.searchMatrix(new int[][] { 
			{ 1, 3, 5, 7 },
			{ 10, 11, 16, 20 },
			{ 23, 30, 34, 50 } 
			}, 7));
	}

}
