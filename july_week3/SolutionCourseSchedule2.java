package july_week3;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

//class Node {
//	int value;
//	boolean isVisited = false;
//
//	public Node(int value, boolean isVisited) {
//		super();
//		this.value = value;
//		this.isVisited = isVisited;
//	}
//
//}

public class SolutionCourseSchedule2 {

	static Boolean isCycle = false;

	static int[] findOrder(int numCourses, int[][] prerequisites) {

		List<Integer> res = new ArrayList<>();

		Map<Integer, List<Integer>> graph = new HashMap<>();
		Map<Integer, Integer> visitedNodes = new HashMap<>();
		// graph = Arrays.stream(prerequisites).collect(
		// Collectors.toMap(x -> x[0], x -> Arrays.asList(x[1]),
		// (x1, x2) -> Arrays.asList(x1.get(0), x2.get(0))));

		graph = Arrays.stream(prerequisites)
				.map(prereq -> new SimpleEntry<Integer, Integer>(prereq[0], prereq[1]))
				.collect(Collectors.groupingBy(Map.Entry::getKey,
						Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

		for (int i = 0; i < numCourses; i++) {
			visitedNodes.put(i, 0);
		}

		Iterator<Entry<Integer, List<Integer>>> iterator = graph.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Integer, List<Integer>> entry = iterator.next();
			dfs(graph, entry.getKey(), visitedNodes, res);
			if (isCycle)
				return new int[] {};
			visitedNodes = visitedNodes.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> {
				return e.getValue() == 2 ? 0 : e.getValue();
			}));
		}

		for (int i = 0; i < numCourses; i++) {
			if (visitedNodes.get(i) == 0) {
				res.add(i);
			}
		}
		return res.stream().mapToInt(Integer::intValue).toArray();
	}

	static void dfs(Map<Integer, List<Integer>> graph, int key, Map<Integer, Integer> visitedNodes, List<Integer> res) {

		List<Integer> list = graph.get(key);
		if (visitedNodes.get(key) == 1) {
			return;
		} else if (list == null) {
			visitedNodes.put(key, 1);
			res.add(key);
			return;
		}
		list.forEach(element -> {
			if (visitedNodes.get(element) != 1) {
				if (visitedNodes.get(element) != 2) {
					visitedNodes.put(element, 2);
					dfs(graph, element, visitedNodes, res);
				} else {
					isCycle = true;
					return;
				}
			}

		});
		if (isCycle)
			return;
		visitedNodes.put(key, 1);
		res.add(key);
		return;
	}

	public static void main(String[] args) {
		SolutionCourseSchedule2.findOrder(10, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } });
		// { { 5, 6 }, { 0, 2 }, { 1, 7 }, { 5, 9 }, { 1, 8 }, { 3, 4 },
		// { 0, 6 }, { 0, 7 }, { 0, 3 }, { 8, 9 } });
	}

}
// [9,8,7,6,5,4,3,2,1,0]