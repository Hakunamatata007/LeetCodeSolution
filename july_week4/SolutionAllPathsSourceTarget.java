package july_week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionAllPathsSourceTarget {

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

		int src = 0;
		int dest = graph.length - 1;
		boolean[] visited = new boolean[dest + 1];
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> nodeList = new ArrayList<>();
		nodeList.add(src);
		dfs(graph, visited, nodeList, src, dest, res);
		return res;
	}

	private void dfs(int[][] graph, boolean[] visited, List<Integer> nodeList, int dest, int finalDest,
			List<List<Integer>> res) {

		if (dest == finalDest) {
			res.add(new ArrayList<>(nodeList));
			return;
		}

		int[] list = graph[dest];
		for (int i = 0; i < list.length; i++) {
			dest = list[i];
			if (!visited[dest]) {
				visited[dest] = true;
				nodeList.add(dest);
				dfs(graph, visited, nodeList, dest, finalDest, res);
				nodeList.remove(new Integer(dest));
				visited[dest] = false;
			}
		}
	}

	public Map<Integer, List<int[]>> buildGraph(int[][] edges) {

		Map<Integer, List<int[]>> graph = new HashMap<>();
		int i = 0;
		for (int[] edge : edges) {
			for (int j = 0; j < edge.length; j++) {
				graph.putIfAbsent(i, new ArrayList<>());
				graph.get(i).add(new int[] { edge[j] });
			}
		}
		return graph;
	}

	public static void main(String[] args) {
		SolutionAllPathsSourceTarget sol = new SolutionAllPathsSourceTarget();
		sol.allPathsSourceTarget(new int[][] { { 1, 2 }, { 3 }, { 3 }, {} });
	}

}
