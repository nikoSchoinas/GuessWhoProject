package game;

import java.util.ArrayList;
import java.util.Random;

public class Enemy {

	private ArrayList<Face> faceslist = new ArrayList<Face>(); ;
	private Face selectedEnemyFace;
	
	public Enemy(ArrayList<Face> faceslist){
		this.faceslist = faceslist;
		selectedEnemyFace = this.selectFace();
	}
	
	public Face getSelectedEnemyFace() {
		return selectedEnemyFace;
	}

	public int selectQuestionCode(int levelSelection, Face playerFace, ArrayList<Face> faceslist,ArrayList<Question> questions){//επιπεδο δυσκολιας
		
		int maxDeletedFaces= -1;
		int selectedQuestionCode= -1;
		int numOfDeletedFaces= -1;
		
		if(levelSelection==0){//easy level
			Random r = new Random();
			int Low = 0;
			int High = questions.size()-1;
			selectedQuestionCode = r.nextInt(High-Low) + Low;
			
		}else{//difficult level
			for(int i=0;i<questions.size();i++){
				numOfDeletedFaces = questions.get(i).facesForDelete(faceslist, playerFace);
				System.out.println(numOfDeletedFaces+"tic");
				if(numOfDeletedFaces > maxDeletedFaces){
					maxDeletedFaces = numOfDeletedFaces;
					selectedQuestionCode = i;
				}
			}
			/*for(Question question : questions){
				numOfDeletedFaces = question.facesForDelete(faceslist, playerFace);
				if(numOfDeletedFaces > maxDeletedFaces){
					maxDeletedFaces = numOfDeletedFaces;
					selectedQuestionCode = question.getCodeQuestion();
					System.out.println(maxDeletedFaces+"tic");
				}
				
			}*/
			
		}

		return selectedQuestionCode;
		
	}
	
	
	public Face selectFace(){//computer's random selection of player
		Random r = new Random();
		int Low = 1;
		int High = 24;
		int rand = r.nextInt(High-Low) + Low;
		return  faceslist.get(rand);
	}
	


}
