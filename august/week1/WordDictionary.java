package august.week1;

class Trie {

	Trie[] children;
	char ch;
	boolean isEndOfWord;

	public Trie() {
		children = new Trie[26];
		isEndOfWord = false;
	}

	public void insertWord(String word, Trie root) {
		Trie temp = root;
		for (char cha : word.toCharArray()) {
			if (temp.children[cha - 'a'] == null) {
				temp.children[cha - 'a'] = new Trie();
				temp.ch = cha;
			}
			temp = temp.children[cha - 'a'];
		}
		temp.isEndOfWord = true;
	}

	public boolean search(String word, Trie trie, int index) {

		if (word.length() == index)
			return trie.isEndOfWord;

		char ch = word.charAt(index);
		if (ch == '.') {
			for (Trie tr : trie.children) {
				if (tr != null && search(word, tr, index + 1))
					return true;
			}
			return false;
		}

		Trie temp = trie;
		temp = temp.children[ch - 'a'];
		if (temp != null) {
			return search(word, temp, index + 1);
		} else
			return false;

	}

}

public class WordDictionary {

	Trie root;

	public WordDictionary() {
		root = new Trie();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		root.insertWord(word, root);
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		return root.search(word, root, 0);
	}

	public static void main(String[] args) {
		WordDictionary sol = new WordDictionary();
		String[] words = new String[] { "addword" };
		// { "addword", "addword", "addword", "search", "search", "search", "search" };

		for (String string : words) {
			sol.addWord(string);
		}

		System.out.println(sol.search(".ddword"));
	}

}
