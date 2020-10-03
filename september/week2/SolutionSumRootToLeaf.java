package september.week2;

public class SolutionSumRootToLeaf {

	public int sumRootToLeaf(TreeNode root) {
		return sum(new StringBuilder(), root);
	}

	private int sum(StringBuilder sb, TreeNode root) {

		if (root == null || root.val == null) {
			return 0;
		}

		sb.append((int) root.val);

		if (root.left == null && root.right == null)
			return Integer.parseInt(sb.toString(), 2);

		int left = sum(sb, root.left);
		if(left != 0) sb.deleteCharAt(sb.length() - 1);
		int right = sum(sb, root.right);
		if(right != 0) sb.deleteCharAt(sb.length() - 1);
		return left + right;
	}

	public static void main(String[] args) {
		SolutionSumRootToLeaf sol = new SolutionSumRootToLeaf();
		Tree tree1 = new Tree();
		Object[] root1 = new Object[] { 1, null, 0 };
		tree1.root = tree1.insertLevelOrder(root1, tree1.root, 0);
		System.out.println(sol.sumRootToLeaf(tree1.root));
	}

}
