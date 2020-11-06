package october.week3;

import java.util.Arrays;
import java.util.Stack;

public class SolutionAsteroidCollision {

	public int[] asteroidCollision(int[] asteroids) {
		boolean flag = false;
		Stack<Integer> stack = new Stack<>();
		// -2,-1,1,-2
		// [-2,-1,-2]
		for (int el : asteroids) {
			if (!flag && el < 0) {
				stack.push(el);
				continue;
			} else {
				flag = true;
			}
			if (flag && !stack.isEmpty()) {
				int num = stack.peek();
				if (num > 0 && el < 0) {// oppoite sign
					while (num > 0 && el < 0 && !stack.isEmpty() && Math.abs(el) >= Math.abs(num)) {
						stack.pop();
						num = !stack.isEmpty() ? stack.peek() : num;
					}
					if (Math.abs(el) >= Math.abs(num))
						stack.push(el);
					if (Math.abs(el) == Math.abs(num))
						stack.pop();
				} else {
					stack.push(el);
				}
			} else {
				stack.push(el);
			}
		}
		int[] b = new int[stack.size()];
		Object[] array = stack.toArray();
		for (int i = 0; i < array.length; i++) {
			b[i] = (int) array[i];
		}
		return b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionAsteroidCollision sol = new SolutionAsteroidCollision();
		System.out.println(Arrays.toString(sol.asteroidCollision(new int[] { -2, -2, 2, -2 })));
	}

}
