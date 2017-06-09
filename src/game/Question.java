/*Class Question. Every question is an object of this class. There are 12 questions in the game. See Initialization class
Question objects are been added to ArrayLists.*/
package game;

import java.util.ArrayList;

public class Question {

	/*ArrayList deletedFaces. This ArrayList includes faces that need to be deleted from ArrayList faces */
	private ArrayList<Face> deletedFaces;
	/*Every question has a unique identification code. codeQuestion å (1,number of questions) */
	private int codeQuestion;
	/**/
	private String characteristic;

	public Question(int codeQuestion, String characteristic) {
		this.codeQuestion = codeQuestion;
		this.characteristic = characteristic;
	}

	/*This method takes two parameters. The ArrayList of faces and player's selected face.
	   According to the selected face, fills the ArrayList faces with the faces that need to be deleted.
	This method returns the size of ArrayList deletedFaces that creates. Enemy uses that method.*/
	public int facesForDelete(ArrayList<Face> faces,Face selectedFace){

		deletedFaces = new ArrayList<Face>();
		switch (codeQuestion) {
		case 0:
			for (Face face : faces) {
				if (!face.isBlackHair() == selectedFace.isBlackHair())
					deletedFaces.add(face);
			}
			break;
		case 1:
			for (Face face : faces) {
				if (!face.isBlondHair() == selectedFace.isBlondHair())
					deletedFaces.add(face);
			}
			break;
		case 2:
			for (Face face : faces) {
				if (!face.isWhiteHair() == selectedFace.isWhiteHair())
					deletedFaces.add(face);
			}
			break;
		case 3:
			for (Face face : faces) {
				if (!face.isBrownHair() == selectedFace.isBrownHair())
					deletedFaces.add(face);
			}
			break;
		case 4:
			for (Face face : faces) {
				if (!face.isBlueEyes() == selectedFace.isBlueEyes())
					deletedFaces.add(face);
			}
			break;
		case 5:
			for (Face face : faces) {
				if (!face.isBrownEyes() == selectedFace.isBrownEyes())
					deletedFaces.add(face);
			}
			break;
		case 6:
			for (Face face : faces) {
				if (!face.isGreenEyes() == selectedFace.isGreenEyes())
					deletedFaces.add(face);
			}
			break;
		case 7:
			for (Face face : faces) {
				if (!face.isBlackSkin() == selectedFace.isBlackSkin())
					deletedFaces.add(face);
			}
			break;
		case 8:
			for (Face face : faces) {
				if (!face.isGlasses() == selectedFace.isGlasses())
					deletedFaces.add(face);
			}
			break;
		case 9:
			for (Face face : faces) {
				if (!face.isHat() == selectedFace.isHat())
					deletedFaces.add(face);
			}
			break;
		case 10:
			for (Face face : faces) {
				if (!face.isFaceHair() == selectedFace.isFaceHair())
					deletedFaces.add(face);
			}
			break;
		case 11:
			for (Face face : faces) {
				if (!face.isSex() == selectedFace.isSex())
					deletedFaces.add(face);
			}
			break;
		default: System.out.println("Question 's code out of bounds ");
		break;

		}

		return deletedFaces.size();


	}

	public String getCharacteristic() {
		return characteristic;
	}

	public int getCodeQuestion() {
		return codeQuestion;
	}

	//Delete faces from Arraylist depending the answer of the opponent. Enemy, so Wizard, use this method. 
	public void deleteFaces(ArrayList<Face> faces){
		for(Face deletedFace : deletedFaces){
			for(Face face : faces){
				if(deletedFace.getCodeFace() == face.getCodeFace()){
					faces.remove(face);
					break;
				}

			}
		}
	}
	
	/*Every time gamer sets a question to Enemy, the last one calls that method.
	Method returns true or false if enemyFace has or not the characteristic.  */ 
	public boolean questionResponse(Face enemyFace){

		switch (codeQuestion) {
		case 0:
			if (enemyFace.isBlackHair())
				return true;
			break;
		case 1:
			if (enemyFace.isBlondHair())
				return true;
			break;
		case 2:
			if (enemyFace.isWhiteHair())
				return true;
			break;
		case 3:
			if (enemyFace.isBrownHair())
				return true;
			break;
		case 4:
			if (enemyFace.isBlueEyes())
				return true;
			break;
		case 5:
			if (enemyFace.isBrownEyes())
				return true;
			break;
		case 6:
			if (enemyFace.isGreenEyes())
				return true;
			break;
		case 7:
			if (enemyFace.isBlackSkin())
				return true;
			break;
		case 8:
			if (enemyFace.isGlasses())
				return true;
			break;
		case 9:
			if (enemyFace.isHat())
				return true;
			break;
		case 10:
			if (enemyFace.isFaceHair())
				return true;
			break;
		case 11:
			if (enemyFace.isSex())
				return true;
			break;
		default: System.out.println("Question 's code out of bounds ");
		break;

		}

		return false;
	}
	
		//Checks the correctness of user's answer. This block was made to prevent cheating
		public boolean checkQuestion(Face selectedFace, boolean playerResponse){

		switch (codeQuestion) {
		case 0:
			if (selectedFace.isBlackHair() == playerResponse )
				return true;
			break;
		case 1:
			if (selectedFace.isBlondHair() == playerResponse)
				return true;
			break;
		case 2:
			if (selectedFace.isWhiteHair() == playerResponse)
				return true;
			break;
		case 3:
			if (selectedFace.isBrownHair() == playerResponse)
				return true;
			break;
		case 4:
			if (selectedFace.isBlueEyes() == playerResponse)
				return true;
			break;
		case 5:
			if (selectedFace.isBrownEyes() == playerResponse)
				return true;
			break;
		case 6:
			if (selectedFace.isGreenEyes() == playerResponse)
				return true;
			break;
		case 7:
			if (selectedFace.isBlackSkin() == playerResponse)
				return true;
			break;
		case 8:
			if (selectedFace.isGlasses() == playerResponse)
				return true;
			break;
		case 9:
			if (selectedFace.isHat() == playerResponse)
				return true;
			break;
		case 10:
			if (selectedFace.isFaceHair() == playerResponse)
				return true;
			break;
		case 11:
			if (selectedFace.isSex() == playerResponse)
				return true;
			break;
		default: System.out.println("Question 's code out of bounds ");
		break;

		}

		return false;
	}

}
