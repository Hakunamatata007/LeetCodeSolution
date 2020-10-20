package october.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionRepeatedDNASequence {

	public List<String> findRepeatedDnaSequences(String s) {

		Map<String, Integer> fmap = new HashMap<>();
		for (int i = 0; i + 10 <= s.length(); i++) {
			CharSequence subSequence = s.subSequence(i, i + 10);
			fmap.put(subSequence.toString(), fmap.getOrDefault(subSequence, 0) + 1);
		}
		List<String> out = new ArrayList<>();
		fmap.entrySet().forEach(entry -> {
			if (entry.getValue() > 1)
				out.add(entry.getKey());
		});
		return out;
	}

	public static void main(String[] args) {
		SolutionRepeatedDNASequence sol = new SolutionRepeatedDNASequence();
		System.out.println(sol.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));

	}

}
