package september.week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SolutionWordPattern {

	public boolean wordPattern(String pattern, String str) {

		char[] charArr = pattern.toCharArray();
		String[] strArray = str.split("\\s");
		if (charArr.length != strArray.length)
			return false;

		Map<Character, String> map = new HashMap<>();
		Map<String, Character> map1 = new HashMap<>();
		for (int i = 0; i < strArray.length; i++) {

			if ((map1.containsKey(strArray[i]) && !map1.get(strArray[i]).equals(charArr[i]))
					|| (map.containsKey(charArr[i]) && !map.get(charArr[i]).equals(strArray[i])))
				return false;
			map.put(charArr[i], strArray[i]);
			map1.put(strArray[i], charArr[i]);
		}
		return true;
	}

	public static void main(String[] args) {
		SolutionWordPattern sol = new SolutionWordPattern();
		System.out.println(sol.wordPattern("aa", "dog fish"));
	}

}
