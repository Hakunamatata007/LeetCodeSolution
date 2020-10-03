import java.util.ArrayList;
import java.util.List;

public class SolutionfizzBuzz {

	public List<String> fizzBuzz(int n) {

		List<String> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int num = i + 1;
			String element = "";
			if (num % 3 == 0)
				element = "Fizz";
			if (num % 5 == 0)
				element += "Buzz";
			if (num % 3 != 0 && num % 5 != 0)
				element += num;
			list.add(element);
		}

		System.out.println(list);
		return list;

	}

	public static void main(String[] args) {
		SolutionfizzBuzz sol = new SolutionfizzBuzz();
		sol.fizzBuzz(15);
	}

}
