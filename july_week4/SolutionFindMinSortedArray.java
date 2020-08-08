package july_week4;

public class SolutionFindMinSortedArray {

	public int findMin(int[] arr) {

		int l = 0;
		int h = arr.length - 1;
		while (l < h) {
			int mid = (h + l) / 2;
			if (arr[mid] == arr[h]) {
				h--;
			} else if (arr[mid] > arr[h]) {
				l = mid + 1;
			} else {
				h = mid;
			}
		}
		System.out.println(arr[h]);
		return arr[l];
	}

	public static void main(String[] args) {
		SolutionFindMinSortedArray sol = new SolutionFindMinSortedArray();
		sol.findMin(new int[] { 2, 2, 2, 0, 2, 2 });
	}

}
