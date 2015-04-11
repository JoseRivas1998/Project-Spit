package com.tcg.spit.managers;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

public class MyInputProcessor extends InputAdapter {

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.UP || keycode == Keys.W) {
			MyInput.setKey(MyInput.UP, true);
		}
		if(keycode == Keys.DOWN || keycode == Keys.S) {
			MyInput.setKey(MyInput.DOWN, true);
		}
		if(keycode == Keys.LEFT || keycode == Keys.A) {
			MyInput.setKey(MyInput.LEFT, true);
		}
		if(keycode == Keys.RIGHT || keycode == Keys.D) {
			MyInput.setKey(MyInput.RIGHT, true);
		}
		if(keycode == Keys.ENTER) {
			MyInput.setKey(MyInput.START, true);
		}
		if(keycode == Keys.SPACE) {
			MyInput.setKey(MyInput.JUMP, true);
		}
		if(keycode == Keys.ESCAPE || keycode == Keys.BACK) {
			MyInput.setKey(MyInput.BACK, true);
		}
		if(keycode == Keys.F11) {
			MyInput.setKey(MyInput.FULLSCREEN, true);
		}
		MyInput.setKey(MyInput.ANY, true);
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.UP || keycode == Keys.W) {
			MyInput.setKey(MyInput.UP, false);
		}
		if(keycode == Keys.DOWN || keycode == Keys.S) {
			MyInput.setKey(MyInput.DOWN, false);
		}
		if(keycode == Keys.LEFT || keycode == Keys.A) {
			MyInput.setKey(MyInput.LEFT, false);
		}
		if(keycode == Keys.RIGHT || keycode == Keys.D) {
			MyInput.setKey(MyInput.RIGHT, false);
		}
		if(keycode == Keys.ENTER) {
			MyInput.setKey(MyInput.START, false);
		}
		if(keycode == Keys.SPACE) {
			MyInput.setKey(MyInput.JUMP, false);
		}
		if(keycode == Keys.ESCAPE || keycode == Keys.BACK) {
			MyInput.setKey(MyInput.BACK, false);
		}
		if(keycode == Keys.F11) {
			MyInput.setKey(MyInput.FULLSCREEN, false);
		}
		MyInput.setKey(MyInput.ANY, false);
		return true;
	}

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
