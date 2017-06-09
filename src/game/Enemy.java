/*Enemy class is gamer's opponent (computer). One Enemy Object declared at MainGamePanel*/
package game;

import java.util.ArrayList;
import java.util.Random;

public class Enemy {

	//Declarations
	private ArrayList<Face> faceslist = new ArrayList<Face>(); /* this ArrayList supposed to be gamer's faces list*/
	private Face selectedEnemyFace; /*The face that enemy (computer) selects*/
	
	//Constructors
	public Enemy(ArrayList<Face> faceslist){
		this.faceslist = faceslist;
		selectedEnemyFace = this.selectFace();
	}
	
	public Face getSelectedEnemyFace() {
		return selectedEnemyFace;
	}

	public int selectQuestionCode(int levelSelection, Face playerFace, ArrayList<Face> faceslist,ArrayList<Question> questions){//difficulty level
		
		int maxDeletedFaces= -1;
		int selectedQuestionIndex= -1;
		int numOfDeletedFaces= -1;
	
		/* Easy Level. Enemy chooses randomly an index from ArrayList<Question> questions. 
		This index indicates the question from arraylist that will be set to the player.*/
		if(levelSelection==0){
			Random r = new Random();
			int Low = 0;
			int High = questions.size()-1;
			selectedQuestionIndex = r.nextInt(High-Low) + Low;
		
		/*Hard Level. Enemy calls method facesForDelete for every question in ArrayList questions
		Enemy chooses the index of question that return the maximum number of deletedFaces.*/	
		}else{
			for(int i=0;i<questions.size();i++){
				numOfDeletedFaces = questions.get(i).facesForDelete(faceslist, playerFace);
				if(numOfDeletedFaces > maxDeletedFaces){
					maxDeletedFaces = numOfDeletedFaces;
					selectedQuestionIndex = i;
				}
			}
			
		}

		return selectedQuestionIndex;
		
	}
	
	//Computer's random selection of player
	public Face selectFace(){
		Random r = new Random();
		int Low = 1;
		int High = 24;
		int rand = r.nextInt(High-Low) + Low;
		return  faceslist.get(rand);
	}
	


}
