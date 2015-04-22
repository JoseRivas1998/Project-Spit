package com.tcg.spit;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.tcg.spit.managers.*;

public class Game extends ApplicationAdapter {

	public static final String TITLE = "Project Spit";

	public static Vector2 SIZE, CENTER;

	public static float VOLUME;

	private int frames;
	private float fpstime;
	public static int fps;

	public static int SCORE, HIGHSCORE;

	private Save s;

	private GameStateManager gsm;

	public static Content res;
	
	public static int LEVEL, LEVELS_UNLOCKED;
	
	public final Save defaultS = new Save(0, 1);

	@Override
	public void create() {
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();

		SIZE = new Vector2();
		CENTER = new Vector2();
		SIZE.set(width, height);
		CENTER.set(width * .5f, height * .5f);

		if (Gdx.files.local(MyConstants.saveFile).exists()) {
			try {
				s = Save.load();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			s = defaultS;
			try {
				s.save(s);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Game.HIGHSCORE = s.getHighscore();
		Game.LEVELS_UNLOCKED = s.getLevels_unlocked();
		Game.SCORE = 0;

		res = new Content();

		res.loadBitmapFont("font", "GOTHIC.TTF", "main", 24, Color.WHITE);
		res.loadBitmapFont("font", "GOTHIC.TTF", "large", 56, Color.WHITE);
		res.loadBitmapFont("font", "GOTHIC.TTF", "mItems", 34, Color.WHITE);
		
		gsm = new GameStateManager();

		Gdx.input.setInputProcessor(new MyInputProcessor());
		Controllers.addListener(new MyControllerProcessor());
		Gdx.input.setCatchBackKey(true);
		Gdx.input.setCatchMenuKey(true);
		Gdx.input.setCursorCatched(Gdx.graphics.isFullscreen());

		fpstime = 0;
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		float dt = Gdx.graphics.getDeltaTime();

		gsm.handleInput();
		gsm.update(dt);
		gsm.draw(dt);

		frames++;
		fpstime += dt;
		if (fpstime >= 1) {
			fps = frames;
			frames = 0;
			fpstime = 0;
			Gdx.graphics.setTitle(Game.TITLE + " | " + Game.fps + " fps");
		}

		MyInput.update();
	}

	public static String getScore(int score) {
		if (score < 10) {
			return "000000" + score;
		} else if (score < 100) {
			return "00000" + score;
		} else if (score < 1000) {
			return "0000" + score;
		} else if (score < 10000) {
			return "000" + score;
		} else if (score < 100000) {
			return "00" + score;
		} else if (score < 1000000) {
			return "0" + score;
		} else {
			return "" + score;
		}
	}

	@Override
	public void resize(int width, int height) {
		SIZE.set(width, height);
		CENTER.set(width * .5f, height * .5f);
		gsm.resize(Game.SIZE);
	}

	public void dispose() {
		gsm.dispose();
		res.removeAll();
		s.setHighscore(Game.HIGHSCORE);
		s.setLevels_unlocked(Game.LEVELS_UNLOCKED);
		try {
			s.save(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
