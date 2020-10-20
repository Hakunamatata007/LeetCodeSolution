public class SolutionHammingDistance {

	static int hammingDistance(int x, int y) {

		int count = 0;
		String first = Integer.toBinaryString(x);
		String second = Integer.toBinaryString(y);
		int diff = first.length() - second.length();
		String append = "";
		if (diff != 0) {
			for (int i = 0; i < Math.abs(diff); i++) {
				append = append + "0";
			}
		}
		if (diff > 0) {
			second = append + second;
		} else {
			first = append + first;
		}
		System.out.println(first);
		System.out.println(second);
		for (int i = first.length() - 1; i >= 0; i--) {
			if (first.charAt(i) != second.charAt(i)) {
				count++;
			}
		}
		System.out.println(count);
		return count;
	}

	static int hammingDist(int x, int y) {
		// int result = x^y;
		System.out.println(Integer.bitCount(x ^ y));
		return Integer.bitCount(x ^ y);
	}

	public static void main(String[] args) {
		SolutionHammingDistance.hammingDist(1, 4);
	}

}
