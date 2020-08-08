
public class SolutionHIndex {

	public static int hIndex(int[] citations) {
		int index = 0;
		int low = 0;
		int high = citations.length;
		int mid = 0;
		// while (low < high) {
		// mid = (low + high) / 2;
		// if(citations[mid] >= )
		// }

		if (high == 0 || high == 1) {
			return high == 1 ? citations[0] : 0;
		}
		int i = 0;
		while (i <= high - 1) {
			if (citations[i] <= high - i + 1) {
				i++;
			} else {
				return citations[--i];
			}

		}

		return citations[i];
	}

	public static void main(String[] args) {

		int[] arr = new int[] { 0, 1, 3, 5, 6 };

		System.out.println(SolutionHIndex.hIndex(arr));
	}

}
