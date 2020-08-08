package techgig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PlayerStats {
	List<Integer> runs;
	double average;

	public PlayerStats(List<Integer> runs, int average) {
		super();
		this.runs = runs;
		this.average = average;
	}

}

public class SolutionPlayerStatistics {

	Map<String, PlayerStats> players = new HashMap<>();

	public void putNewInnings(String name, int runs) {
		name = name.toLowerCase();
		players.putIfAbsent(name, new PlayerStats(new ArrayList<Integer>(), 0));
		PlayerStats player = players.get(name);
		player.runs.add(runs);
		player.average = averageCal(player.average, player.runs.size() - 1, runs);
		players.put(name, player);
	}

	public double getAverageRuns(String player) {
		return players.get(player.toLowerCase()).average;
	}

	public int getInnings(String player) {
		return players.get(player.toLowerCase()).runs.size();
	}

	private double averageCal(double average, int numberOfEntries, int newEntry) {
		double avg = 0;
		avg = (average * numberOfEntries) + newEntry;
		return avg / (numberOfEntries + 1);
	}

	public static void main(String[] args) {

		SolutionPlayerStatistics sol = new SolutionPlayerStatistics();
		sol.putNewInnings("Virat", 100);
		sol.putNewInnings("ViRat", 50);
		sol.putNewInnings("Gambhir", 50);
		sol.putNewInnings("Virat", 50);
		sol.putNewInnings("Gambhir", 50);
		sol.putNewInnings("Gambhir", 50);
		
		System.out.println(sol.getAverageRuns("Virat"));
		System.out.println(sol.getInnings("Virat"));

		System.out.println(sol.getAverageRuns("Gambhir"));
		System.out.println(sol.getInnings("Gambhir"));
	}

}
