package september.week3;

public class SolutionRobotBoundedInCircle {

	public boolean isRobotBounded(String str) {

		char[] path = str.toCharArray();
		int x = 0, y = 0;
		int dir = 0;

		for (int i = 0; i < path.length; i++) {
			char move = path[i];

			if (move == 'R')
				dir = (dir + 1) % 4;
			else if (move == 'L')
				dir = (4 + dir - 1) % 4;

			else {
				if (dir == 0)
					y++;
				else if (dir == 1)
					x++;
				else if (dir == 2)
					y--;
				else // dir == 3
					x--;
			}
		}

		return (x == 0 && y == 0);
	}

	public static void main(String[] args) {
		SolutionRobotBoundedInCircle sol = new SolutionRobotBoundedInCircle();
		sol.isRobotBounded("GGLLGG");
	}

}
