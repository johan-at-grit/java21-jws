package com.grit.demo;

public class presenter {
	public static String showResult(gameBean theGame) {
		String dummy = showPlayer(theGame.p1);
		
		String pattern = "Spel = %s \r\n Spelare 1: %s får %s poäng.  \\r\\n Spelare 2: %s får %s poäng.";
		return String.format(pattern, theGame.Id, theGame.p1.name, theGame.p1.score, theGame.p2.name, theGame.p2.score);

	}
	
	public static String showPlayer(playerBean p) {
		return p.name + p.score;
	}
}
