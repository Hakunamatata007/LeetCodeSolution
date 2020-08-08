import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionLevelOrderBottom {

	static List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null)
			return new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> out;
		boolean flag = false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		out = new ArrayList<>();
		out.add((int) root.val);
		result.add(out);
		while (!queue.isEmpty() && queue.peek() != null) {
			out = new ArrayList<>();
			while (queue.peek() != null) {
				TreeNode temp = queue.poll();
				System.out.println("val " + temp.val);
				if (temp.left != null) {
					queue.add(temp.left);
					out.add((int) temp.left.val);
				}
				if (temp.right != null) {
					out.add((int) temp.right.val);
					queue.add(temp.right);
				}
			}
			queue.remove();
			queue.add(null);
			if (!out.isEmpty())
				result.add(out);
		}
		for (List<Integer> list : result) {
			System.out.println(Arrays.toString(list.toArray()));
		}
		Collections.reverse(result);
		return result;
	}

	// solution 2
	static List<List<Integer>> levelOrderBottom2(TreeNode root) {
		List<List<Integer>> resList = new ArrayList<>();
		if (root == null) {
			return resList;
		}

		dfs(root, 0, resList);
		return resList;
	}

	static void dfs(TreeNode root, int depth, List<List<Integer>> res) {
		if (root == null) {
			return;
		}

		if (depth == res.size()) {
			res.add(0, new ArrayList<Integer>());
		}

		res.get(res.size() - depth - 1).add((int) root.val);
		dfs(root.left, depth + 1, res);
		dfs(root.right, depth + 1, res);
	}

	public static void main(String[] args) {

		TreeNode left2 = new TreeNode(4);
		TreeNode right2 = new TreeNode(5);
		TreeNode left3 = new TreeNode(15);
		TreeNode right3 = new TreeNode(7);
		TreeNode right1 = new TreeNode(20, left3, right3);
		TreeNode left1 = new TreeNode(9);
		TreeNode tree = new TreeNode(3, left1, right1);

		SolutionLevelOrderBottom.levelOrderBottom2(tree);

	}

}
