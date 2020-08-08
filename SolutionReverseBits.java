
public class SolutionReverseBits {

	static int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result = result * 2;
			result = result + n % 2;
			n = n / 2;
		}
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {

		SolutionReverseBits.reverseBits(15);
	}

}
// 1879048192