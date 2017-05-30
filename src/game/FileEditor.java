package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * eykolo +4 -3
 * dyskolo +8 - 2
 */
public class FileEditor {

	private ArrayList<GamerProfile> rankFile;

	public FileEditor() {

		File inputFile = new File("statistics.txt");

		try {
			rankFile = new ArrayList<GamerProfile>();
			Scanner fScaner = new Scanner(inputFile);
			while (fScaner.hasNext()) {
				GamerProfile gamer = new GamerProfile(fScaner.next(), fScaner.nextInt(), fScaner.nextInt(),
						fScaner.nextInt(), fScaner.nextInt(), fScaner.nextInt(), fScaner.nextInt(), fScaner.nextInt());
				rankFile.add(gamer);
			}
			fScaner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<GamerProfile> getRankFile() {
		return rankFile;
	}

	public void setRankFile(ArrayList<GamerProfile> rankFile) {
		this.rankFile = rankFile;
	}

	public int searchEditor(String name) {

		for (int i = 0; i < rankFile.size(); i++) {
			if (rankFile.get(i).getName().equals(name))
				return i;
		}
		return -1;
	}

	public GamerProfile createProfile(String name) {

		GamerProfile gamer = null;
		if (this.searchEditor(name) != -1) {
			System.out.println("This username exists already. Please try another one");
		} else {
			gamer = new GamerProfile(name, 0, 0, 0, 0, 0, 0, 0);
			rankFile.add(gamer);
			return gamer;
		}
		return gamer;
	}

	public void showPlayerStatistics(GamerProfile gamer) {

		for (int i = 0; i < rankFile.size(); i++) {
			if (rankFile.get(i).getName().equals(gamer.getName())) {
				System.out.println(gamer.getName() + gamer.getPoints() + gamer.getWinsEasy() + gamer.getLosesEasy()
						+ gamer.getWinsHard() + gamer.getLosesHard() + gamer.getNumberOfEasy()
						+ gamer.getNumberOfHard());
			}
		}
	}

	public void showTable() {
		this.sortList();
		for (GamerProfile gamer : rankFile) {
			System.out.println(gamer.getName() + " " + gamer.getPoints() + " " + gamer.getWinsEasy() + " "
					+ gamer.getLosesEasy() + " " + gamer.getWinsHard() + " " + gamer.getLosesHard() + " "
					+ gamer.getNumberOfEasy() + " " + gamer.getNumberOfHard());
		}
	}

	public void sortList() {

		Collections.sort(rankFile);
		// αντιστρεφη την λιστα επειδη η sort τα βαζει σε αυξουσα σε σειρα και
		// οχι σε φθηνουσα
		Collections.reverse(rankFile);

		for (int i = 0; i < rankFile.size(); i++) {
			System.out.println(rankFile.get(i).getName());
		}
	}

	public void writeFile(String output) {

		this.sortList();
		try {
			PrintWriter writer = new PrintWriter(output);
			for (int i = 0; i < rankFile.size(); i++) {
				writer.println(rankFile.get(i).getName() + " " + rankFile.get(i).getPoints() + " "
						+ rankFile.get(i).getWinsEasy() + " " + rankFile.get(i).getLosesEasy() + " "
						+ rankFile.get(i).getWinsHard() + " " + rankFile.get(i).getLosesHard() + " "
						+ rankFile.get(i).getNumberOfEasy() + " " + rankFile.get(i).getNumberOfHard());
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void calculatePoints(String username, boolean level, boolean result) {

		/*
		 * level : false for easy; true for hard result : false for lose; true
		 * for win
		 */
		int i;
		if ((i = this.searchEditor(username)) != -1) {
			if (level) {
				if (result) {
					int sumPoints = rankFile.get(i).getPoints() + 8;
					rankFile.get(i).setPoints(sumPoints);
				} else {
					int sumPoints = rankFile.get(i).getPoints() - 2;
					rankFile.get(i).setPoints(sumPoints);
				}
			} else {
				if (result) {
					int sumPoints = rankFile.get(i).getPoints() + 4;
					rankFile.get(i).setPoints(sumPoints);
				} else {
					int sumPoints = rankFile.get(i).getPoints() - 3;
					rankFile.get(i).setPoints(sumPoints);
				}
			}
		}
	}

}
