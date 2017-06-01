package game;

public class Face {

		//Variables' declarations
		private boolean blackHair;
		private boolean blondHair;
		private boolean whiteHair;
		private boolean brownHair;
		private boolean blueEyes;
		private boolean brownEyes;
		private boolean greenEyes;
		private boolean blackSkin;
		private boolean glasses;
		private boolean hat;
		private boolean faceHair;
		private boolean sex;
		private int codeFace;
		
		//Constructor
		public Face(boolean blackHair, boolean blondHair, boolean whiteHair, boolean brownHair, boolean blueEyes,
				boolean brownEyes,boolean greenEyes, boolean blackSkin, boolean glasses, boolean hat,
				boolean faceHair,boolean sex, int code) {
			
			this.blackHair = blackHair;
			this.blondHair = blondHair;
			this.whiteHair = whiteHair;
			this.brownHair = brownHair;
			this.blueEyes = blueEyes;
			this.brownEyes = brownEyes;
			this.blackSkin = blackSkin;
			this.glasses = glasses;
			this.hat = hat;
			this.faceHair = faceHair;
			this.sex = sex;
			this.codeFace= code;
		}
		
		//Setters,getters, etc.
		public int getCodeFace() {
			return codeFace;
		}

		public boolean isSex() {
			return sex;
		}

		public void setSex(boolean sex) {
			this.sex = sex;
		}

		public void setCodeFace(int codeFace) {
			this.codeFace = codeFace;
		}

		public boolean isBlackHair() {
			return blackHair;
		}

		public void setBlackHair(boolean blackHair) {
			this.blackHair = blackHair;
		}

		public boolean isBlondHair() {
			return blondHair;
		}

		public void setBlondHair(boolean blondHair) {
			this.blondHair = blondHair;
		}

		public boolean isWhiteHair() {
			return whiteHair;
		}

		public void setWhiteHair(boolean whiteHair) {
			this.whiteHair = whiteHair;
		}

		public boolean isBrownHair() {
			return brownHair;
		}

		public void setBrownHair(boolean brownHair) {
			this.brownHair = brownHair;
		}

		public boolean isBlueEyes() {
			return blueEyes;
		}

		public void setBlueEyes(boolean blueEyes) {
			this.blueEyes = blueEyes;
		}

		public boolean isBrownEyes() {
			return brownEyes;
		}

		public void setBrownEyes(boolean brownEyes) {
			this.brownEyes = brownEyes;
		}
		
		public boolean isGreenEyes(){
			return greenEyes;
		}
		
		public void setGreenEyes(boolean greenEyes){
			this.greenEyes = greenEyes;
		}

		public boolean isBlackSkin() {
			return blackSkin;
		}

		public void setBlackSkin(boolean blackSkin) {
			this.blackSkin = blackSkin;
		}

		public boolean isGlasses() {
			return glasses;
		}

		public void setGlasses(boolean glasses) {
			this.glasses = glasses;
		}

		public boolean isHat() {
			return hat;
		}

		public void setHat(boolean hat) {
			this.hat = hat;
		}

		public boolean isFaceHair() {
			return faceHair;
		}

		public void setFaceHair(boolean faceHair) {
			this.faceHair = faceHair;
		}		
}
