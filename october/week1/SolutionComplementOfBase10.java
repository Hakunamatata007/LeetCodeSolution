package october.week1;

public class SolutionComplementOfBase10 {

	public int bitwiseComplement(int N) {
		int mask = (Integer.highestOneBit(N) << 1) - 1;
		return mask ^ N;

		// sol 2
		// ~num & (Integer.highestOneBit(num) - 1);
	}

	public static void main(String[] args) {
		SolutionComplementOfBase10 sol = new SolutionComplementOfBase10();
		System.out.println(sol.bitwiseComplement(10));
	}

}
