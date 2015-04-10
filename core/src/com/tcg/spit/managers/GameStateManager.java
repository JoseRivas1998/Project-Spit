package com.tcg.spit.managers;

import com.tcg.spit.MyConstants.*;
import com.tcg.spit.gamestates.*;

public class GameStateManager {

	private GameState gamestate;
	
	public GameStateManager() {
		
	}
	
	public void setState(States state) {
		if(gamestate != null) gamestate.dispose();
		if(state == States.SPLASH) {
			
		}
		if(state == States.TITLE) {
			
		}
		if(state == States.PLAY) {
			
		}
	}
	
}
