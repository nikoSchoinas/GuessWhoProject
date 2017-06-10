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

		/*
		 * Open a txt file named "statistics.txt"  which contains our profile history
		 * (users ,points , etc )
		 */
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

	/*
	 * Search if there is a player with a given name. If does then return his position
	 * in our ArrayList, otherwise return -1
	 */
	public int searchEditor(String name) {

		for (int i = 0; i < rankFile.size(); i++) {
			if (rankFile.get(i).getName().equals(name))
				return i;
		}
		return -1;
	}

	/*
	 * Create a GamerProfile . Return null if the given name there is already
	 * or return an item GamerProfile 
	 */
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

	/*
	 * Sort ArrayList's items in descending order
	 */
	public void sortList() {

		Collections.sort(rankFile);
		Collections.reverse(rankFile);

	}

	/*
	 * Update our file 
	 * "output" is the name of our txt file
	 */
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

	/*
	 * Calculate player's points and update his history (points, wins and loses at easy level etc)
	 */
	public void calculatePoints(String username, boolean level, boolean result) {

		/*
		 * level : false for easy; true for hard result : false for lose; true
		 * for win
		 */
		int i = this.searchEditor(username);
		if (i != -1) {
			if (level) {
				rankFile.get(i).setNumberOfHard(rankFile.get(i).getNumberOfHard() +1);
				if (result) {
					int sumPoints = rankFile.get(i).getPoints() + 8;
					rankFile.get(i).setPoints(sumPoints);
					rankFile.get(i).setWinsHard(rankFile.get(i).getWinsHard()+1);
				} else {
					int sumPoints = rankFile.get(i).getPoints() - 2;
					rankFile.get(i).setPoints(sumPoints);
					rankFile.get(i).setLosesHard(rankFile.get(i).getLosesHard()+1);
				}
			} else {
				rankFile.get(i).setNumberOfEasy(rankFile.get(i).getNumberOfEasy() +1 );
				if (result) {
					int sumPoints = rankFile.get(i).getPoints() + 4;
					rankFile.get(i).setPoints(sumPoints);
					rankFile.get(i).setWinsEasy(rankFile.get(i).getWinsEasy() +1 );
				} else {
					int sumPoints = rankFile.get(i).getPoints() - 3;
					rankFile.get(i).setPoints(sumPoints);
					rankFile.get(i).setLosesEasy(rankFile.get(i).getLosesEasy() +1);
				}
			}
		}
	}

}
