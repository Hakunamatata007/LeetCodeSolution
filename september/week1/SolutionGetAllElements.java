package september.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SolutionGetAllElements {

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		List<Integer> list = new ArrayList<>();
		while (root1 != null || root2 != null || !s1.isEmpty() || !s2.isEmpty()) {
			while (root1 != null) {
				s1.push(root1);
				root1 = root1.left;
			}
			while (root2 != null) {
				s2.push(root2);
				root2 = root2.left;
			}

			if (s2.empty() || (!s1.empty() && (int) s1.peek().val < (int) s2.peek().val)) {
				root1 = s1.pop();
				list.add((int) root1.val);
				root1 = root1.right;
			} else {
				root2 = s2.pop();
				list.add((int) root2.val);
				root2 = root2.right;
			}

		}
		System.out.println(list);
		return list;

	}

	public static void main(String[] args) {

		SolutionGetAllElements sol = new SolutionGetAllElements();
		Tree tree1 = new Tree();
		Tree tree2 = new Tree();
		Object[] root1 = new Object[] { 2, 1, 4 };
		Object[] root2 = new Object[] { 1, 0, 3 };
		tree1.root = tree1.insertLevelOrder(root1, tree1.root, 0);
		tree2.root = tree2.insertLevelOrder(root2, tree2.root, 0);
		sol.getAllElements(tree1.root, tree2.root);
	}

}
