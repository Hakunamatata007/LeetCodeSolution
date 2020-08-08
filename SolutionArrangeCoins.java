
public class SolutionArrangeCoins {

	// quadratic equation n(n+1)/2
	static int arrangeCoins(int n) {
		return (int) ((-1) + Math.sqrt(1 + (8L * n))) / 2;
	}

	public static void main(String[] args) {
		SolutionArrangeCoins.arrangeCoins(1804289383);
	}

}
