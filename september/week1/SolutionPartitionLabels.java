package september.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SolutionPartitionLabels {

	public List<Integer> partitionLabels(String S) {

		int[] lastIndex = new int[26];
		for (int i = 0; i < S.length(); i++) {
			lastIndex[S.charAt(i) - 'a'] = i;
		}
		int max = 0;
		int end = 0;
		System.out.println(Arrays.toString(lastIndex));
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < S.length(); i++) {
			max = Math.max(lastIndex[S.charAt(i) - 'a'], max);
			if (i == max) {
				list.add(i - end + 1);
				end = i + 1;
			}
		}

		System.out.println(list);
		return list;

	}

	public static void main(String[] args) {
		SolutionPartitionLabels sol = new SolutionPartitionLabels();
		sol.partitionLabels("ababcbacadefegdehijhklij");
	}

}
