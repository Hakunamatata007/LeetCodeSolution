import java.util.LinkedList;
import java.util.Queue;

public class SolutionDeleteNode {

	public TreeNode deleteNode(TreeNode root, int key) {

		TreeNode temp = root;
		temp = findNode(temp, key);
		if (temp == null)
			return root;

		TreeNode temp2 = key > (int) root.val ? temp.right : temp.left;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(temp2);
		TreeNode node = q.poll();
		if (node.left != null)
			q.add(node.left);
		if (node.right != null)
			q.add(node.right);
		if (key > (int) root.val)
			temp.right = null;
		else
			temp.left = null;
		while (!q.isEmpty()) {
			int size = q.size();
			node = q.poll();
			addNode(temp, (int) node.val);
			for (int i = 0; i < size; i++) {
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
		}

		return root;

	}

	public TreeNode addNode(TreeNode root, int key) {

		if (root == null) {
			root = new TreeNode(key);
			return root;
		}

		if (key < (int) root.val)
			root.left = addNode(root.left, key);
		else if (key > (int) root.val)
			root.right = addNode(root.right, key);

		return root;
	}

	public TreeNode findNode(TreeNode root, int key) {

		if (root == null)
			return null;

		if ((root.left != null && root.left.val != null && key == (int) root.left.val)
				|| (root.right != null && root.right.val != null && key == (int) root.right.val)
				|| key == (int) root.val)
			return root;

		if (key > (int) root.val)
			root = findNode(root.right, key);

		else
			// (key < (int) root.val)
			root = findNode(root.left, key);
		return root;
	}

	public static void main(String[] args) {

		SolutionDeleteNode sol = new SolutionDeleteNode();
		Tree tree = new Tree();
		Object[] arr = new Object[] { 5, 3, 6, 2, 4, null, 7 };
		tree.root = tree.insertLevelOrder(arr, tree.root, 0);
		sol.deleteNode(tree.root, 13);
	}

}
