package july_week3;

import java.util.HashSet;
import java.util.Set;

class Trie {
	public Trie[] children;
	public Boolean isEndOfWord;

	Trie() {
		children = new Trie[26];
		isEndOfWord = false;
	}

	public void insertWord(String word) {
		Trie curr = this;
		for (int i = 0; i < word.length(); i++) {
			int index = word.toLowerCase().charAt(i) - 'a';
			System.out.println(index);
			if (curr.children[index] == null) {
				curr.children[index] = new Trie();
			}
			curr = curr.children[index];
		}
		curr.isEndOfWord = true;
	}
}

public class SolutionWordSearch {

	public boolean dfs(char[][] board, int i, int j, String str, String word) {
		char ch = board[i][j];
		if (ch == '$')
			return false;
		board[i][j] = '$';
		String temp = str;
		str += ch;

		if (word.startsWith(str)) {
			if (str.equals(word))
				return true;

			if (i - 1 >= 0)
				if (dfs(board, i - 1, j, str, word))
					return true;
			if (i + 1 < board.length)
				if (dfs(board, i + 1, j, str, word))
					return true;
			if (j - 1 >= 0)
				if (dfs(board, i, j - 1, str, word))
					return true;
			if (j + 1 < board[0].length)
				if (dfs(board, i, j + 1, str, word))
					return true;
		} else {
			str = temp;
		}
		board[i][j] = ch;
		return false;

	}

	public boolean exist(char[][] board, String word) {

		Boolean flag = false;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				flag = dfs(board, i, j, "", word);
				if (flag) {
					flag = true;
					break;
				}
			}
			if (flag)
				break;
		}
		System.out.println(flag);
		return flag;
	}

	public static void main(String[] args) {
		SolutionWordSearch sol = new SolutionWordSearch();
		char[][] board = new char[][]  
			{{'C','A','A'},
			 {'A','A','A'},
			 {'B','C','D'} };
		sol.exist(board, "AAB");
	}

}
