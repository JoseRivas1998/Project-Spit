package com.tcg.spit.managers;

import com.badlogic.gdx.math.Vector2;
import com.tcg.spit.Game;
import com.tcg.spit.MyConstants;

public class MyInput {
	
	private static Vector2[] screenPositions;
	private static Vector2[] gamePositions;
	
	private static boolean touch;
	private static boolean ptouch;
	
	private static boolean[] pointertouch;
	private static boolean[] pPointertouch;
	
	private static boolean[] key;
	private static boolean[] pkey;
	
	public static final int NUM_KEYS = 9;
	
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	public static final int START = 4;
	public static final int JUMP = 5;
	public static final int BACK = 6;
	public static final int FULLSCREEN = 7;
	public static final int ANY = 8;
	
	static {
		key = new boolean[NUM_KEYS];
		pkey = new boolean[NUM_KEYS];
		screenPositions = new Vector2[MyConstants.NUM_TOUCHES];
		gamePositions = new Vector2[MyConstants.NUM_TOUCHES];
		pointertouch = new boolean[MyConstants.NUM_TOUCHES];
		pPointertouch = new boolean[MyConstants.NUM_TOUCHES];
	}
	
	public static void update() {
		ptouch = touch;
		for(int i = 0; i < MyConstants.NUM_TOUCHES; i++) {
			pPointertouch[i] = pointertouch[i];
		}
		for(int i = 0; i < NUM_KEYS; i++){
			pkey[i] = key[i];
		}
	}
	
	public static void setKey(int keycode, boolean b) {
		key[keycode] = b;
	}
	
	public static boolean keyDown(int keycode) {
		return key[keycode];
	}
	
	public static boolean keyPressed(int keycode) {
		return key[keycode] && !pkey[keycode];
	}
	
	public static void setTouch(int pointer, int x, int y, boolean b) {
		if(pointer < MyConstants.NUM_TOUCHES) {
			if(screenPositions[pointer] == null) {
				screenPositions[pointer] = new Vector2(x, y);
			} else {
				screenPositions[pointer].set(x, y);
			}
			if(gamePositions[pointer] == null) {
				gamePositions[pointer] = new Vector2(x, Game.SIZE.y - y);
			} else {
				gamePositions[pointer].set(x, Game.SIZE.y - y);
			}
			pointertouch[pointer] = b;
		}
		touch = b;
	}

	public static boolean touchDown() {
		return touch;
	}
	
	public static boolean tapped() {
		return touch && !ptouch;
	}
	
	public static boolean touchDown(int pointer) {
		if(pointer < MyConstants.NUM_TOUCHES) {
			return pointertouch[pointer];
		} else {
			return false;
		}
	}
	
	public static boolean tapped(int pointer) {
		if(pointer < MyConstants.NUM_TOUCHES) {
			return pointertouch[pointer] && !pPointertouch[pointer];
		} else {
			return false;
		}
	}
	
	public static Vector2 touchScreenPos(int pointer) {
		if(pointer < MyConstants.NUM_TOUCHES) {
			return screenPositions[pointer];
		} else {
			return new Vector2(-1000, -1000);
		}
	}
	
	public static Vector2 touchGamePos(int pointer) {
		if(pointer < MyConstants.NUM_TOUCHES) {
			return gamePositions[pointer];
		} else {
			return new Vector2(-1000, -1000);
		}
	}
	
}
