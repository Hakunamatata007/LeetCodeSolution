package july_week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionZigzagLevelOrder {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		int level = 1;
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty() && queue.peek() != null) {
			List<Integer> tempList = new ArrayList<>();
			while (queue.peek() != null && queue.peek().val != null) {
				TreeNode temp = queue.poll();
				tempList.add((Integer) temp.val);
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
			queue.add(null);
			queue.poll();
			if (level % 2 == 0)
				Collections.reverse(tempList);
			if (tempList.size() > 0)
				list.add(tempList);
			level++;
		}

		return list;

	}

	public static void main(String[] args) {

		SolutionZigzagLevelOrder sol = new SolutionZigzagLevelOrder();
		Object arr[] = { };
		Tree p = new Tree();

		p.root = p.insertLevelOrder(arr, p.root, 0);

		sol.zigzagLevelOrder(p.root);
	}

}
