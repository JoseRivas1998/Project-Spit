package com.tcg.spit.gamestates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.tcg.spit.managers.GameStateManager;

public abstract class GameState {

	protected GameStateManager gsm;
	
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
	}

	protected abstract void init();
	public abstract void handleInput();
	public abstract void update(float dt);
	public abstract void draw(SpriteBatch sb, ShapeRenderer sr, float dt);
	public abstract void resize(Vector2 size);
	public abstract void dispose();
	
}
