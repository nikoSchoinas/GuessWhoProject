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
	   Sets codeFace = -1 at faces that need to be excluded.*/
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
	
	/*public void clearDeletedFacesList(){
		for(int i=0;i<deletedFaces.size();i++)
			deletedFaces.remove(i);
	}*/

}
