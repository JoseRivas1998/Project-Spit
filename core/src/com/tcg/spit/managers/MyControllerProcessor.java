package com.tcg.spit.managers;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerAdapter;
import com.badlogic.gdx.controllers.PovDirection;
import com.tcg.spit.MyConstants;

public class MyControllerProcessor extends ControllerAdapter {

	@Override
	public boolean buttonDown(Controller controller, int buttonIndex) {
		if(buttonIndex == MyConstants.A) {
			MyInput.setKey(MyInput.UP, true);
		}
		if(buttonIndex == MyConstants.START) {
			MyInput.setKey(MyInput.START, true);
		}
		if(buttonIndex == MyConstants.BACK) {
			MyInput.setKey(MyInput.BACK, true);
		}
		MyInput.setKey(MyInput.ANY, true);
		return true;
	}

	@Override
	public boolean buttonUp(Controller controller, int buttonIndex) {
		if(buttonIndex == MyConstants.A) {
			MyInput.setKey(MyInput.UP, false);
		}
		if(buttonIndex == MyConstants.START) {
			MyInput.setKey(MyInput.START, false);
		}
		if(buttonIndex == MyConstants.BACK) {
			MyInput.setKey(MyInput.BACK, false);
		}
		MyInput.setKey(MyInput.ANY, false);
		return true;
	}

	@Override
	public boolean povMoved(Controller controller, int povIndex,
			PovDirection value) {
		if(value == PovDirection.north || value == PovDirection.northEast || value == PovDirection.northWest) {
			MyInput.setKey(MyInput.UP, true);
		} else {
			MyInput.setKey(MyInput.UP, false);
		}
		if(value == PovDirection.south || value == PovDirection.southEast || value == PovDirection.southWest) {
			MyInput.setKey(MyInput.DOWN, true);
		} else {
			MyInput.setKey(MyInput.DOWN, false);
		}
		if(value == PovDirection.east || value == PovDirection.northEast || value == PovDirection.southEast) {
			MyInput.setKey(MyInput.RIGHT, true);
		} else {
			MyInput.setKey(MyInput.RIGHT, false);
		}
		if(value == PovDirection.west || value == PovDirection.northWest || value == PovDirection.southWest) {
			MyInput.setKey(MyInput.LEFT, true);
		} else {
			MyInput.setKey(MyInput.LEFT, false);
		}
		return true;
	}

	@Override
	public boolean axisMoved(Controller controller, int axisIndex, float value) {
		if(axisIndex == 0) {
			if(value > .3f) {
				MyInput.setKey(MyInput.DOWN, true);
			} else {
				MyInput.setKey(MyInput.DOWN, false);
			}
			if(value < -.3f) {
				MyInput.setKey(MyInput.UP, true);
			} else {
				MyInput.setKey(MyInput.UP, false);
			}
		}
		if(axisIndex == 1) {
			if(value > .3f) {
				MyInput.setKey(MyInput.RIGHT, true);
			} else {
				MyInput.setKey(MyInput.RIGHT, false);
			}
			if(value < -.3f) {
				MyInput.setKey(MyInput.LEFT, true);
			} else {
				MyInput.setKey(MyInput.LEFT, false);
			}
		}
		return true;
	}

}
