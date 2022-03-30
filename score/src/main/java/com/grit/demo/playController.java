package com.grit.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class playController {

	gameBean theGame = new gameBean();
	
	@RequestMapping(
			value = "/addPlayers",
			method = RequestMethod.GET)
	public String addPlayers(String name1, String name2) {
		playerBean firstPlayer = new playerBean();
		playerBean secondPlayer = new playerBean();

		firstPlayer.name = name1;
		firstPlayer.score = 0;
		
		secondPlayer.name = name2;
		secondPlayer.score = 0;
		
		theGame.Id = "Round 1";
		theGame.p1 = firstPlayer;
		theGame.p2 = secondPlayer;
		
		return "Players added";
	}

	@RequestMapping(
			value = "/addP1Win",
			method = RequestMethod.GET)
	public String addP1Win() {
		theGame.p1.score++;
		return "P1 wins!";
	}
	
	@RequestMapping(
			value = "/showResult",
			method = RequestMethod.GET)
	public String showResult() {
//		presenter pr = new presenter();
//		return pr.showResult(theGame);
		
		return presenter.showResult(theGame);
	}
}
