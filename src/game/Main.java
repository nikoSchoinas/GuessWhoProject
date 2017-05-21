package game;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Face> faceslist = new ArrayList<Face>();
		ArrayList<Question> questionlist = new ArrayList<Question>();

		Initialization.setFaces();//initialize faces of the game
		faceslist = Initialization.getFaceslist();//save faces into arraylist
		Initialization.setQuestion();
		questionlist = Initialization.getQuestionlist();//save questions into arraylist
		
		Enemy enemy = new Enemy(faceslist);
		enemy.selectFace();
		
		Face playerFace = faceslist.get(0);
		
		enemy.selectFace();
		while(faceslist.size()>1){
		int k = enemy.selectQuestionCode(1, playerFace, faceslist, questionlist);
		System.out.println(k);
		System.out.println(questionlist.get(k).getCharacteristic());
		questionlist.get(k).deleteFaces(faceslist);
		questionlist.remove(k);
		}
	}

}
