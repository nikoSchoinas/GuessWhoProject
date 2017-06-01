package game;

public class GamerProfile implements Comparable<GamerProfile>{
			
			//Variables' declarations
			private String name;
			private int points;
			private int	winsEasy;
			private int losesEasy;
			private int	winsHard;
			private int losesHard;
			private int numberOfEasy;
			private int numberOfHard;
			
			//Creating a new profile constructor
			public GamerProfile(String name, int points, int winsEasy, int losesEasy, int winsHard, int losesHard,
					int numberOfEasy, int numberOfHard) {
				this.name = name;
				this.points = points;
				this.winsEasy = winsEasy;
				this.losesEasy = losesEasy;
				this.winsHard = winsHard;
				this.losesHard = losesHard;
				this.numberOfEasy = numberOfEasy;
				this.numberOfHard = numberOfHard;
			}

			//Setters and getters
			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public int getPoints() {
				return points;
			}

			public void setPoints(int points) {
				this.points = points;
			}

			public int getWinsEasy() {
				return winsEasy;
			}

			public void setWinsEasy(int winsEasy) {
				this.winsEasy = winsEasy;
			}

			public int getLosesEasy() {
				return losesEasy;
			}

			public void setLosesEasy(int losesEasy) {
				this.losesEasy = losesEasy;
			}

			public int getWinsHard() {
				return winsHard;
			}

			public void setWinsHard(int winsHard) {
				this.winsHard = winsHard;
			}

			public int getLosesHard() {
				return losesHard;
			}

			public void setLosesHard(int losesHard) {
				this.losesHard = losesHard;
			}
			
			public int getNumberOfEasy() {
				return numberOfEasy;
			}

			public void setNumberOfEasy(int numberOfEasy) {
				this.numberOfEasy = numberOfEasy;
			}

			public int getNumberOfHard() {
				return numberOfHard;
			}

			public void setNumberOfHard(int numberOfHard) {
				this.numberOfHard = numberOfHard;
			}
			

			//Compare user's points in order to create the rank
			public int compareTo(GamerProfile o) {
				
				return new Integer(this.points).compareTo(o.getPoints());
			}
			
}
