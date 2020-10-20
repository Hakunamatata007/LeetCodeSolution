package october.week2;

public class SolutionBinarySearch {
	public int search(int[] nums, int target) {
		int high = nums.length - 1;
		int low = 0;
		int mid = 0;
		while (low <= high) {
			mid = (high + low) >>> 1;
			int midValue = nums[mid];
			if (target == midValue)
				return mid;
			else if (target > midValue) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		SolutionBinarySearch sol = new SolutionBinarySearch();
		System.out.println(sol.search(new int[] { 5 }, 5));
	}

}
