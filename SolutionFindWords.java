import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Trie {
	public Trie[] children;
	public Boolean isEndOfWord;

	public Trie() {
		children = new Trie[26];
		isEndOfWord = false;
	}

	public void insert(String word) {
		Trie curr = this;
		
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (curr.children[index] == null) {
				curr.children[index] = new Trie();
			}
			curr = curr.children[index];
		}
		curr.isEndOfWord = true;
	}
}

public class SolutionFindWords {

	private void isAdditional(char[][] board, int i, int j, Set<String> result, String word,
			Map<String, Boolean> wordMap) {

		char tempChar = '$';
		tempChar = board[i - 1][j];
		word = word + tempChar;
		if (wordMap.containsKey(word)) {
			wordMap.put(word, true);
		}
	}

	public void dfs(char[][] board, Trie root, int i, int j, Set<String> result, String word,
			Map<String, Boolean> wordMap) {
		char c = board[i][j];
		if (c == '$')
			return;
		Trie trie = root.children[c - 'a'];
		board[i][j] = '$';
		if (trie != null) {
			word += c;
			if (trie.isEndOfWord) {
				result.add(word);
				wordMap.put(word, true);
				if (i - 1 >= 0) {
					isAdditional(board, i - 1, j, result, word, wordMap);
				}
				if (i + 1 < board.length) {
					isAdditional(board, i + 1, j, result, word, wordMap);
				}
				if (j - 1 >= 0) {
					isAdditional(board, i, j - 1, result, word, wordMap);
				}
				if (j + 1 < board[0].length) {
					isAdditional(board, i, j + 1, result, word, wordMap);
				}
//				return;
			}
			if (i - 1 >= 0)
				dfs(board, trie, i - 1, j, result, word, wordMap);
			if (i + 1 < board.length)
				dfs(board, trie, i + 1, j, result, word, wordMap);
			if (j - 1 >= 0)
				dfs(board, trie, i, j - 1, result, word, wordMap);
			if (j + 1 < board[0].length)
				dfs(board, trie, i, j + 1, result, word, wordMap);
		}
		board[i][j] = c;
	}

	public List<String> findWords(char[][] board, String[] words) {

		Set<String> result = new HashSet<>();
		Map<String, Boolean> wordMap = new LinkedHashMap<>();
		Boolean flag = false;
		Trie root = new Trie();
		Collections.sort(Arrays.asList(words));
		for (String word : words) {
			root.insert(word);
			wordMap.put(word, false);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, root, i, j, result, "", wordMap);
				if (result.size() == words.length) {
					flag = true;
					break;
				}
			}
			if (flag)
				break;
		}

		return result.stream().collect(Collectors.toList());

	}

	public static void main(String[] args) {
		SolutionFindWords sol = new SolutionFindWords();
		char[][] board = new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' } };
		String[] words = new String[] { "eat", "oath", "eate" };
		sol.findWords(board, words);
	}

}
