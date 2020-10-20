package october.week1;

public class SolutionInsertIntoBST {

	public TreeNode insertIntoBST(TreeNode root, int val) {

		TreeNode temp = root;
		TreeNode newNode = new TreeNode(val);
		if (root == null)
			return newNode;
		while (temp != null) {
			if (temp.right == null && val > (int) temp.val) {
				temp.right = newNode;
				break;
			} else if (temp.left == null && val < (int) temp.val) {
				temp.left = newNode;
				break;
			}
			if (val > (int) temp.val) {
				temp = temp.right;
			} else {
				temp = temp.left;
			}
		}
		return root;

	}

	public static void main(String[] args) {
		SolutionInsertIntoBST sol = new SolutionInsertIntoBST();
		Tree tree = new Tree();
		Object[] arr = new Object[] { 4, 2, 7, 1, 3 };
		tree.root = tree.insertLevelOrder(arr, tree.root, 0);
		sol.insertIntoBST(tree.root, 5);

	}

}
