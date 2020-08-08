import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SolutionFindCheapestPrice {

	static ArrayList<Integer> costList = new ArrayList<>();
	static int minPathCost;

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

		Map<Integer, List<int[]>> graph = buildGraph(flights);
		minPathCost = Integer.MAX_VALUE;
		Queue<int[]> q = new LinkedList<>(); // hold int pair which include total cost to reach to that city fro source
		int stop = 0;
		q.add(new int[] { src, 0 });
		Map<Integer, Integer> visitedNode = new HashMap<>();
		if (!graph.containsKey(src))
			return -1;
		// first - using recursion
		dfs(graph, visitedNode, 0, src, K, dst);

		// second method - optimal
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentStop = q.poll();
				if (currentStop[0] == dst) {
					minPathCost = Math.min(minPathCost, currentStop[1]);
				}
				if (!graph.containsKey(currentStop[0])) {
					continue;
				}
				for (int[] f : graph.get(currentStop[0])) {
					if (currentStop[1] + f[1] > minPathCost) {
						continue;
					}
					q.add(new int[] { f[0], f[1] + currentStop[1] });
				}
			}
			if (stop++ > K) {
				break;
			}
		}
		System.out.println(minPathCost);
		return minPathCost == Integer.MAX_VALUE ? -1 : minPathCost;
	}

	static void dfs(Map<Integer, List<int[]>> graph, Map<Integer, Integer> visitedNode, int cost, int dest, int stops,
			int finalDest) {

		if (stops >= -1 && dest == finalDest) {
			minPathCost = Math.min(minPathCost, cost);
			return;
		}

		if (stops == -1) {
			return;
		}

		List<int[]> list = graph.get(dest);
		if (list == null)
			return;

		for (int i = 0; i < list.size(); i++) {
			int[] destAndCost = list.get(i);
			if (!visitedNode.containsKey(destAndCost[0]) && cost + destAndCost[1] < minPathCost) {
				visitedNode.put(destAndCost[0], destAndCost[1]);
				dfs(graph, visitedNode, cost + destAndCost[1], destAndCost[0], stops - 1, finalDest);
				visitedNode.remove(destAndCost[0]);
			}
		}
	}

	static Map<Integer, List<int[]>> buildGraph(int[][] flights) {

		Map<Integer, List<int[]>> graph = new HashMap<>();
		for (int[] flight : flights) {
			graph.putIfAbsent(flight[0], new ArrayList<>());
			graph.get(flight[0]).add(new int[] { flight[1], flight[2] });
		}
		return graph;
	}

	public static void main(String[] args) {

		int[][] test = new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 }
				// { 3, 4, 4 }, { 2, 5, 6 }, { 4, 7, 10 }, { 9, 6, 5 }, { 7, 4, 4 }, { 6, 2, 10
				// }, //
				// { 6, 8, 6 }, { 7, 9, 4 }
				// { 1, 5, 4 }, //
				// { 1, 0, 4 }, //
				// { 9, 7, 3 }, // 3
				// { 7, 0, 5 }, // 4
				// { 6, 5, 8 }, // 1
				// { 1, 7, 6 }, //
				// { 4, 0, 9 }, //
				// { 5, 9, 1 }, // 2
				// { 8, 7, 3 }, //
				// { 1, 2, 6 }, //
				// { 4, 1, 5 }, //
				// { 5, 2, 4 }, //
				// { 1, 9, 1 }, //
				// { 7, 8, 10 }, //
				// { 0, 4, 2 }, //
				// { 7, 2, 8 }

		};
		SolutionFindCheapestPrice.findCheapestPrice(3, test, 0, 2, 1);

		// 14
	}

}
