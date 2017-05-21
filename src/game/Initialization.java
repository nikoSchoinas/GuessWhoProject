package game;

import java.util.ArrayList;

public final class Initialization {

	private static ArrayList<Face> faceslist;
	private static ArrayList<Question> questionlist;


	static{//εδω αρχικοποιει σαν κατασκευαστης
		
		faceslist = new ArrayList<Face>();		
		questionlist = new ArrayList<Question>();	
		
	}



	public static void setFaces(){

		//boolean blackHair 1, boolean blondeHair 2, boolean whiteHair 3, boolean brownHair 4, boolean blueEyes 5,
		//boolean brownEyes 6, boolean greenEyes 7, boolean blackSkin 8, boolean whiteSkin 9, boolean glasses 10, boolean hat 11,
		//boolean faceHair 12, boolean sex 13,  int code 14

		Face fac1 = new Face(true,false,false,false,false,true,false,false,true,false,false,false,false,1); //Αγαθή - 1
		Face fac2 = new Face(false,true,false,false,true,false,false,false,true,false,false,false,false,2); //Αγνή - 2
		Face fac3 = new Face(true,false,false,false,false,true,false,true,false,false,false,true,true,3); //Ανδριανός - 3
		Face fac4 = new Face(true,false,false,false,false,true,false,true,false,false,true,false,true,4); //Αυγουστίνος - 4
		Face fac5 = new Face(true,false,false,false,false,true,false,false,true,true,false,true,true,5); //Βαρθολομαίος - 5
		Face fac6 = new Face(false,false,false,true,false,true,false,false,true,false,false,true,true,6); //Βίκτωρ - 6
		Face fac7 = new Face(false,false,true,false,false,true,false,false,true,true,false,true,true,7); //Γεώργιος - 7 //Πιο εμφανή γυαλιά
		Face fac8 = new Face(false,true,false,false,true,false,false,false,true,false,false,false,true,8); //Γρηγόριος - 8 //->Κλειστό στόμα
		Face fac9 = new Face(false,false,true,false,false,true,false,false,true,false,false,false,true,9); //Δαμιανός - 9
		Face fac10 = new Face(false,false,false,true,false,true,false,true,false,false,false,true,true,10); //Δημήτριος - 10
		Face fac11 = new Face(false,true,false,false,false,true,false,false,true,false,false,false,false,11); //Ελισάβετ - 11 //Να γινουν ξανθα μαλλια
		Face fac12 = new Face(false,true,false,false,false,true,false,false,true,false,false,true,true,12); //Εμμανουήλ - 12
		Face fac13 = new Face(false,true,false,false,true,false,false,false,true,true,false,true,true,13); //Ευγένιος - 13
		Face fac14 = new Face(false,false,true,false,false,true,false,true,false,false,false,true,true,14); //Ηλίας - 14
		Face fac15 = new Face(false,true,false,false,false,true,false,false,true,false,true,false,true,15); //Θωμάς - 15
		Face fac16 = new Face(false,false,true,false,false,true,false,true,false,false,false,false,true,16); //Ιάσων - 16 //Να αλλαξουμε το στομα -> κλειστό
		Face fac17 = new Face(false,false,false,true,false,true,false,false,true,false,true,false,true,17); //Ιορδάνης - 17
		Face fac18 = new Face(true,false,false,false,false,true,false,false,true,false,false,true,true,18); //Ιωακείμ - 18
		Face fac19 = new Face(true,false,false,false,false,true,false,false,true,true,false,false,false,19); //Λύδια - 19
		Face fac20 = new Face(false,true,false,false,false,true,false,false,true,true,false,false,false,20); //Μαγδαληνή - 20
		Face fac21 = new Face(false,false,false,true,true,false,false,false,true,true,false,true,true,21); //Μάξιμος - 21
		Face fac22 = new Face(false,true,false,false,true,false,false,false,true,false,false,true,true,22); //Μιχαήλ - 22
		Face fac23 = new Face(false,false,false,true,false,true,false,true,false,false,true,false,false,23); //Ρεβέκκα - 23
		Face fac24 = new Face(true,false,false,false,false,true,false,true,false,false,false,false,false,24); //Τατιανή - 24
		
		
		faceslist.add(fac1);
		faceslist.add(fac2);
		faceslist.add(fac3);
		faceslist.add(fac4);
		faceslist.add(fac5);
		faceslist.add(fac6);
		faceslist.add(fac7);
		faceslist.add(fac8);
		faceslist.add(fac9);
		faceslist.add(fac10);
		faceslist.add(fac11);
		faceslist.add(fac12);
		faceslist.add(fac13);
		faceslist.add(fac14);
		faceslist.add(fac15);
		faceslist.add(fac16);
		faceslist.add(fac17);
		faceslist.add(fac18);
		faceslist.add(fac19);
		faceslist.add(fac20);
		faceslist.add(fac21);
		faceslist.add(fac22);
		faceslist.add(fac23);
		faceslist.add(fac24);
	}
	
	public static void setQuestion(){
		Question Q1 = new Question(0,"black hair");
		Question Q2 = new Question(1,"blonde hair");
		Question Q3 = new Question(2,"white hair");
		Question Q4 = new Question(3,"brown hair");
		Question Q5 = new Question(4,"blue eyes");
		Question Q6 = new Question(5,"brown eyes");
		Question Q7 = new Question(6,"green eyes");
		Question Q8 = new Question(7,"black skin");
		Question Q9 = new Question(8,"glasses");
		Question Q10 = new Question(9,"hat");
		Question Q11 = new Question(10,"beard or moustache");
		Question Q12 = new Question(11,"boy");
		
		questionlist.add(Q1);
		questionlist.add(Q2);
		questionlist.add(Q3);
		questionlist.add(Q4);
		questionlist.add(Q5);
		questionlist.add(Q6);
		questionlist.add(Q7);
		questionlist.add(Q8);
		questionlist.add(Q9);
		questionlist.add(Q10);
		questionlist.add(Q11);
		questionlist.add(Q12);
		
	}
	
	public static ArrayList<Face> getFaceslist() {
		return faceslist;
	}

	public static ArrayList<Question> getQuestionlist() {
		return questionlist;
	}
	
	


}
