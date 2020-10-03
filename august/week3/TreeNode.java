package august.week3;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	Object val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(Object val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Tree {
	TreeNode root;

	TreeNode insertLevelOrder(Object[] arr, TreeNode root, int i) {
		if (i < arr.length) {

			TreeNode temp = new TreeNode(arr[i]);
			root = temp;
			root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
			root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
		}
		return root;
	}

	public void inOrder(TreeNode root) {

		if (root != null) {
			inOrder(root.left);
			System.out.print(root.val + " ");
			inOrder(root.right);
		} else {
			System.out.print(root + " ");
		}

	}

	void printLevelOrder() {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode tempNode = queue.poll();
			System.out.print(tempNode.val + " ");
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}

}