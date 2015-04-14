package com.tcg.spit.gamestates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.tcg.spit.Game;
import com.tcg.spit.managers.GameStateManager;

public class LevelSelectState extends GameState {

	private Rectangle itemBounds;
	
	private int currentItem;
	private final int numItems = 20;
	
	public LevelSelectState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	protected void init() {
		itemBounds = new Rectangle(20, 20, Game.SIZE.x - 40, Game.SIZE.y);

	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(SpriteBatch sb, ShapeRenderer sr, float dt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(Vector2 size) {
		itemBounds.set(20, 20, size.x - 40, size.y);

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
