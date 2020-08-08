
public class SolutioSsumNumbers {

	static int sum = 0;

	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		sum = 0;
		return sumNumbers(root, "");
	}

	static int sumNumbers(TreeNode root, String str) {

		if (root == null)
			return 0;
		str += root.val;
		if (root.left == null && root.right == null) {
			// System.out.println(str);
			sum += Integer.parseInt(str);
			return sum;
		}
		// str += root.val;
		sumNumbers(root.left, str);
		sumNumbers(root.right, str);

		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
