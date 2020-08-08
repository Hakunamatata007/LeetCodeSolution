import java.util.LinkedList;

class NodeInfo {
	TreeNode node;
	Integer pos;

	public NodeInfo(TreeNode node, Integer pos) {
		this.node = node;
		this.pos = pos;
	}

	public TreeNode getNode() {
		return node;
	}

	public Integer getPos() {
		return pos;
	}

}

public class SolutionWidthOfBinaryTree {

	static int widthOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int maxWidth = 0;
		LinkedList<NodeInfo> qu = new LinkedList<>();
		qu.offer(new NodeInfo(root, 0));
		while (!qu.isEmpty()) {
			int len = qu.size();
			maxWidth = Math.max(maxWidth, qu.peekLast().getPos() - qu.peekFirst().getPos() + 1);
			for (int i = 0; i < len; i++) {
				NodeInfo temp = qu.poll();
				if (temp.getNode().left != null)
					qu.add(new NodeInfo(temp.getNode().left, temp.getPos() * 2));
				if (temp.getNode().right != null)
					qu.add(new NodeInfo(temp.getNode().right, temp.getPos() * 2 + 1));
			}
		}
		return maxWidth;
	}

	public static void main(String[] args) {
		Object arr[] = { 1, 2, 3, 4, null, null, 5, 6, null, null, 7 };
		Tree p = new Tree();
		p.root = p.insertLevelOrder(arr, p.root, 0);
		SolutionWidthOfBinaryTree.widthOfBinaryTree(p.root);
		p.printLevelOrder();

	}

}
