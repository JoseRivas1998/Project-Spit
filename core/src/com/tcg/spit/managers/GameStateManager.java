package com.tcg.spit.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.tcg.spit.MyConstants.*;
import com.tcg.spit.gamestates.*;

public class GameStateManager {

	private GameState gamestate;
	private SpriteBatch sb;
	private ShapeRenderer sr;
	
	public GameStateManager() {
		sr = new ShapeRenderer();
		sb = new SpriteBatch();
		setState(States.SPLASH);
	}
	
	public void setState(States state) {
		if(gamestate != null) gamestate.dispose();
		if(state == States.SPLASH) {
			gamestate = new SplashState(this);
		}
		if(state == States.TITLE) {
			gamestate = new TitleState(this);
		}
		if(state == States.PLAY) {
			gamestate = new PlayState(this);
		}
		if(state == States.LEVELSELECT) {
			gamestate = new LevelSelectState(this);
		}
	}
	
	public void handleInput() {
		if(MyInput.keyPressed(MyInput.FULLSCREEN)) {
			if(!Gdx.graphics.isFullscreen()) {
				int width1 = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
				int height1 = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
				Gdx.graphics.setDisplayMode(width1, height1, true);
			} else {
				Gdx.graphics.setDisplayMode(800, 600, false);
			}
			Gdx.input.setCursorCatched(Gdx.graphics.isFullscreen());
		}
		gamestate.handleInput();
	}
	
	public void update(float dt) {
		gamestate.update(dt);
	}
	
	public void draw(float dt) {
		gamestate.draw(sb, sr, dt);
	}
	
	public void resize(Vector2 size) {
		gamestate.resize(size);
	}
	
	public void dispose() {
		sb.dispose();
		sr.dispose();
	}
}
