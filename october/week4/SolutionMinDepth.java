package october.week4;

public class SolutionMinDepth {

	public int minDepth(TreeNode root) {
		return dfs(root);
	}

	private int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		int leftHeight = root.left != null ? 1 + dfs(root.left) : Integer.MAX_VALUE;
		int rightHeight = root.right != null ? 1 + dfs(root.right) : Integer.MAX_VALUE;
		return Math.min(leftHeight, rightHeight);
	}

	public static void main(String[] args) {
		Tree tree1 = new Tree();
		Object[] root1 = new Object[] { 3, 9, 20, 5 };
		tree1.root = tree1.insertLevelOrder(root1, tree1.root, 0);
		SolutionMinDepth sol = new SolutionMinDepth();
		System.out.println(sol.minDepth(tree1.root));

	}

}
