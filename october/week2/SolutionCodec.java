package october.week2;

import java.util.ArrayList;
import java.util.LinkedList;

class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		ArrayList<String> list = new ArrayList<>();
		LinkedList<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			System.out.println(temp);
			if (temp == null || temp.val == null)
				list.add("#");
			else {
				list.add("" + temp.val);
				q.add(temp.left);
				q.add(temp.right);
			}
		}
		return String.join(",", list);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {

		String[] arr = data.split(",");
		LinkedList<TreeNode> q = new LinkedList<>();
		if (arr[0] == "#")
			return null;
		TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
		q.offer(root);
		int i = 1;
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			if (temp != null) {
				TreeNode left = null;
				if (!arr[i].equals("#")) {
					left = new TreeNode(Integer.parseInt(arr[i]));
				}
				temp.left = left;
				q.offer(left);
				i++;
				TreeNode right = null;
				if (!arr[i].equals("#")) {
					right = new TreeNode(Integer.parseInt(arr[i]));
				}
				temp.right = right;
				q.offer(right);
				i++;
			}
		}
		return root;
	}
}

public class SolutionCodec {

	public static void main(String[] args) {
		Codec sol = new Codec();
		Tree tree = new Tree();
		Object[] arr = new Object[] { 1, null, 2 };
		tree.root = tree.insertLevelOrder(arr, tree.root, 0);
		String ou = sol.serialize(tree.root);
		System.out.println(ou);
		System.out.println(sol.deserialize(ou));
	}

}
