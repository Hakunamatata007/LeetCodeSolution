package july_week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Trie {
	Map<Character, Trie> children;
	boolean isEndOfWord;
	// char ch;

	public Trie() {
		children = new HashMap<>();
		isEndOfWord = false;
		// ch = '#';
	}

	public void insertWord(Trie trie, String word) {
		Trie temp = trie;
		for (char c : word.toCharArray()) {
			if (!temp.children.containsKey(c)) {
				Trie node = new Trie();
				// node.ch = c;
				temp.children.put(c, node);
			}
			temp = temp.children.get(c);
		}
		temp.isEndOfWord = true;
	}

}

public class SolutionWordBreak2 {

	public void dfs(List<String> wordDict, List<String> result) {

	}

	public List<String> wordBreak(String s, List<String> wordDict) {

		Map<Integer, Set<String>> presentWords = new TreeMap<>();
		Trie root = new Trie();
		for (String string : wordDict) {
			root.insertWord(root, string);
		}
		Trie secondary = root;
		Map<Character, Integer> charMap = new HashMap<>();
		System.out.println(root.children);
		String str = "";
		boolean flag = true;
		for (int j = 0; j < s.length(); j++) {
			int i = j;
			while (i != s.length()) {
				char ch = s.charAt(i);
				if (root.children.containsKey(ch) && flag) {
					charMap.put(ch, i);
				}
				if (secondary.children.containsKey(ch)) {
					str += ch;
					if (secondary.children.get(ch).isEndOfWord) {
						presentWords.putIfAbsent(s.indexOf(str), new HashSet<>());
						presentWords.get(s.indexOf(str)).add(str);
					}
					secondary = secondary.children.get(ch);
				} else {
					str = "";
					secondary = root;
				}
				i++;
			}
		}
		System.out.println(presentWords);
		List<String> result = new ArrayList<>();
		List<String> output = new ArrayList<>();
		Integer[] keys = presentWords.keySet().toArray(new Integer[0]);
		String[] firstWords = presentWords.get(keys[0]).toArray(new String[0]); // first
		for (int i = 0; i < firstWords.length; i++) {

			sentenceUtil(presentWords, 0, i, output, result, firstWords.length, firstWords.length, keys);

		}

		return wordDict;

	}

	public void sentenceUtil(Map<Integer, Set<String>> presentWords, int m, int n, List<String> output,
			List<String> result, int C, int R, Integer[] keys) {

		String[] arr = presentWords.get(keys[m]).toArray(new String[0]);
		result.add(arr[n] + " ");

		// If this is last word of current output sentence, then print
		// the output sentence
		if (m == R - 1) {
			for (int i = 0; i < R; i++)
				output.add(result.toString());
			return;
		}

		// Recur for next row
		for (int i = 0; i < C; i++)
			// if (arr[m + 1][i] != "")
			sentenceUtil(presentWords, m + 1, i, output, result, C, R, keys);
	}

	public static void main(String[] args) {
		SolutionWordBreak2 sol = new SolutionWordBreak2();
		List<String> wordDict = new ArrayList<>();
		String s = "catsandog";
		wordDict.addAll(Arrays.asList("cat", "cats", "and", "sand", "dog"));
		sol.wordBreak(s, wordDict);

	}

}
