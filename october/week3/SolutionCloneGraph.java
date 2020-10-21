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
		if (node == null)
			return null;
		Map<Node, Node> visited = new HashMap<>();
		return cloning(node, visited);
	}

	private Node cloning(Node node, Map<Node, Node> visited) {

		visited.put(node, new Node(node.val, new ArrayList<>()));

		for (Node neighbor : node.neighbors) {
			if (visited.containsKey(neighbor))
				visited.get(node).neighbors.add(visited.get(neighbor));
			else
				visited.get(node).neighbors.add(cloneGraph(neighbor));
		}
		return visited.get(node);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
