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
			this.greenEyes = greenEyes;
			this.blackSkin = blackSkin;
			this.glasses = glasses;
			this.hat = hat;
			this.faceHair = faceHair;
			this.sex = sex;
			this.codeFace= code;
		}
		
		//getters
		public int getCodeFace() {
			return codeFace;
		}

		public boolean isSex() {
			return sex;
		}

		public boolean isBlackHair() {
			return blackHair;
		}

		public boolean isBlondHair() {
			return blondHair;
		}
		
		public boolean isWhiteHair() {
			return whiteHair;
		}

		public boolean isBrownHair() {
			return brownHair;
		}
		
		public boolean isBlueEyes() {
			return blueEyes;
		}

		public boolean isBrownEyes() {
			return brownEyes;
		}

		public boolean isGreenEyes(){
			return greenEyes;
		}
		
		public boolean isBlackSkin() {
			return blackSkin;
		}
		
		public boolean isGlasses() {
			return glasses;
		}

		public boolean isHat() {
			return hat;
		}

		public boolean isFaceHair() {
			return faceHair;
		}
}
