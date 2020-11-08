
public class Inorder {

	public static void sortColors(int[] nums) {

		int start = 0;
		int pos_0 = 0;
		int pos_2 = nums.length - 1; 
		while (start <= pos_2) {
			if (nums[start] == 2) {
				swap(nums, start, pos_2);
				pos_2--;
			} else if (nums[start] == 0) {
				if (start != pos_0)
					swap(nums, start, pos_0);
				else
					start++;
				pos_0++;
			} else {
				start++;
			}
		}
	}

	public static void swap(int[] arr, int a, int b) {

		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;

	}

	public static void main(String[] args) {

		int[] arr = { 2, 0, 2, 1, 1, 0 };
		Inorder.sortColors(arr);
	}
}
