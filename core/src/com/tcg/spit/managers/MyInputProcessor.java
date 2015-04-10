package com.tcg.spit.managers;

import com.badlogic.gdx.InputAdapter;

public class MyInputProcessor extends InputAdapter {

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		MyInput.setTouch(pointer, screenX, screenY, true);
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		MyInput.setTouch(pointer, screenX, screenY, false);
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		MyInput.setTouch(pointer, screenX, screenY, true);
		return true;
	}
	
}
