package com.tcg.spit.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.tcg.spit.Game;

public class AndroidLauncher extends AndroidApplication {
	
	Game g;
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(g = new Game(), config);
	}

	@Override
	protected void onDestroy() {
		g.dispose();
		super.onDestroy();
	}
}
