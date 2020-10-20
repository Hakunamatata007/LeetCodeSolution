package october.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

public class SolutionCloneGraph {

	public Node cloneGraph(Node node) {

		List<Node> list = new ArrayList<>();
		Map<Integer, Boolean> visited = new HashMap<>();

		return node;
	}

	private Node cloning(Node node, Map<Integer, Boolean> visited) {

		if (!visited.get(node.val))
			return;
		List<Node> neighbors = node.neighbors;
		Node clonedNode = new Node(node.val);
		List<Node> clonedNeighbors = new ArrayList<>();

		for (int i = 0; i < neighbors.size(); i++) {
			visited.put(neighbors.get(i).val, true);
			Node cloning = cloning(neighbors.get(i), visited);
			clonedNeighbors.add(cloning);
		}
		clonedNode.neighbors = clonedNeighbors;
		return clonedNode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
