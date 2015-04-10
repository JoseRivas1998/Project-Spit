package com.tcg.spit.gamestates;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.tcg.spit.MyConstants;
import com.tcg.spit.managers.GameStateManager;
import com.tcg.spit.managers.MyInput;

public class SplashState extends GameState {

	public SplashState(GameStateManager gsm) {
		super(gsm);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		for(int i = 0; i < MyConstants.NUM_TOUCHES; i++) {
			if(MyInput.tapped(i)) {
				System.out.println("Pointer: " + i + " Screen: " + MyInput.touchScreenPos(i).toString());
			}
		}
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
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
