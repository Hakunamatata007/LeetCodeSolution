package techgig;

import java.util.Arrays;

public class SolutionMinParkingSpots {

	static int minParkingSpaces(int[][] parkingStartEndTimes) {

		int[] startTimeArray = new int[parkingStartEndTimes.length];
		int[] departureTimeArray = new int[parkingStartEndTimes.length];
		int numberOfTrains = parkingStartEndTimes.length;

		for (int i = 0; i < numberOfTrains; i++) {
			startTimeArray[i] = parkingStartEndTimes[i][0];
			departureTimeArray[i] = parkingStartEndTimes[i][1];
		}
		Arrays.sort(startTimeArray);
		Arrays.sort(departureTimeArray);
		int platformNeeded = 1, result = 1;
		int i = 1, j = 0;

		while (i < numberOfTrains && j < numberOfTrains) {

			if (startTimeArray[i] <= departureTimeArray[j]) {
				platformNeeded++;
				i++;
			} else if (startTimeArray[i] > departureTimeArray[j]) {
				platformNeeded--;
				j++;
			}
			if (platformNeeded > result)
				result = platformNeeded;
		}

		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {

		int[][] parkingStartEndTimes = new int[][] { { 5, 10 }, { 10, 20 }, { 25, 40 }, { 35, 45 } };
		SolutionMinParkingSpots.minParkingSpaces(parkingStartEndTimes);

	}

}
