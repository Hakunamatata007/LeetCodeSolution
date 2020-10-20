package october.week3;

public class SolutionMinDominoRotations {

	public int minDominoRotations(int[] A, int[] B) {
		int n = A.length;
		for (int i = 1, a = 0, b = 0; i < n; i++) {
			if (A[i] != A[0] && B[i] != A[0])
				break;
			if (A[i] != A[0])
				a++;
			if (B[i] != A[0])
				b++;
			if (i == n - 1)
				return Math.min(a, b);
		}
		for (int i = 1, a = 0, b = 0; i < n; i++) {
			if (A[i] != B[0] && B[i] != B[0])
				break;
			if (A[i] != B[0])
				a++;
			if (B[i] != B[0])
				b++;
			if (i == n - 1)
				return Math.min(a, b);
		}
		return -1;
	}

	public static void main(String[] args) {
		SolutionMinDominoRotations sol = new SolutionMinDominoRotations();
		System.out.println(sol.minDominoRotations(new int[] { 2, 1, 2, 4, 2, 2 }, new int[] { 5, 2, 6, 2, 3, 2 }));
	}

}
