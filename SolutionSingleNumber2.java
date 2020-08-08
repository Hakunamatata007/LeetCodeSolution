import java.util.Arrays;

// to extract k bit from an integer do bitwise & from K set bits (1001 & 11) -> 01 

public class SolutionSingleNumber2 {

	public int singleNumber(int[] nums) {

//		System.out.println(1 << 3);
//		System.out.println(8 >> 3);
		
		int[] bits = new int[32];
		for (int i = 0; i < 32; i++) {
			int n = 0;
			for (int num : nums) {
				n += (num >> i) & 1;
				bits[i] = n % 3;
			}
		}
		System.out.println(Arrays.toString(bits));

		int result = 0;
		for (int i = 0; i < 4; i++) {
//			System.out.println("bits[i]" + i + " " + bits[i]);
			System.out.print("bits[i] << i ");
			System.out.println(bits[i] << i);
			System.out.println("result " + result + " binary: " + Integer.toBinaryString(result));
			result = result | (bits[i] << i);
			System.out.println("result after "  + result + " binary: " + Integer.toBinaryString(result));
		}
		System.out.println(result);
		return result;

	}

	public static void main(String[] args) {
		SolutionSingleNumber2 sol = new SolutionSingleNumber2();
		sol.singleNumber(new int[] { 10, 10, 10, 13 });
	}

}
// [0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
// 0, 0, 0, 0, 0, 0, 0]
// [1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
// 0, 0, 0, 0, 0, 0, 0]
