package july_week3;

import java.util.Arrays;

class Solution {
	int[] visited;
	int[] result;
	int[] courses;
	int[] next;
	int[] course;
	int index = 0;

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		visited = new int[numCourses]; // all 0s at first, 0: untouched
		result = new int[numCourses];
		courses = new int[numCourses];
		Arrays.fill(courses, -1);
		next = new int[prerequisites.length];
		course = new int[prerequisites.length];

		for (int i = 0; i < prerequisites.length; ++i) {
			next[i] = courses[prerequisites[i][0]];
			courses[prerequisites[i][0]] = i;
			course[i] = prerequisites[i][1];
		}

		for (int i = 0; i < numCourses; ++i) {
			if (cycle(i)) {
				return new int[0];// has cycle: return empty array
			}
		}

		return result;
	}

	private boolean cycle(int num) {
		if (visited[num] > 0)
			return visited[num] == 1;
		visited[num] = 1; // touched
		for (int i = courses[num]; i != -1; i = next[i]) {
			if (cycle(course[i])) {
				return true;// will have cycle
			}
		}
		visited[num] = 2; // checked
		result[index++] = num;
		return false; // will not form cycle
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.findOrder(10, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } });
	}
}