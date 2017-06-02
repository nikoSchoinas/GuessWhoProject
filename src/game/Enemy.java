package game;

import java.util.ArrayList;
import java.util.Random;

public class Enemy {

	//Declarations
	private ArrayList<Face> faceslist = new ArrayList<Face>(); ;
	private Face selectedEnemyFace;
	
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
	
		//How enemy choose his question at easy level
		if(levelSelection==0){
			Random r = new Random();
			int Low = 0;
			int High = questions.size()-1;
			selectedQuestionIndex = r.nextInt(High-Low) + Low;
		
		//How enemy choose his question at hard level	
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
