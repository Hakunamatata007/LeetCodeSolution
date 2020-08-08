
public class SolutionAngleClock {

	static double angleClock(int hour, int minutes) {

		hour = hour * 5;
		double extraHour = (double) minutes / 12;
		double totalHour = (double) hour + extraHour;
		double required = Math.abs(minutes - totalHour) * 6;
		return Math.min(required, Math.abs(360 - required));
	}

	public static void main(String[] args) {

		double out = SolutionAngleClock.angleClock(3, 30);
		System.out.println(out);
	}

}
