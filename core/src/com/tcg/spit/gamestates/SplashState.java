package com.tcg.spit.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.tcg.spit.Game;
import com.tcg.spit.MyCamera;
import com.tcg.spit.managers.GameStateManager;
import com.tcg.spit.managers.MyInput;

public class SplashState extends GameState {
	
	private Texture temp;
	
	private TextureRegion[] frames;
	
	private Animation anim;

	private TextureRegion currentFrame;
	
	private float stateTime;
	
	private float texx, texy, texw;
	
	private String text;
	
	private float textX, textY;
	
	private MyCamera cam;
	
	private float time, timer;
	
	public SplashState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	protected void init() {
		frames = new TextureRegion[16];
		
		for(int i = 0; i < frames.length; i++) {
			String path = "splash/0";
			String png = ".png";
			if(i < 10) {
				path = path + "0";
			}
			temp = new Texture(path + i + png );
			frames[i] = new TextureRegion(temp);
		}
		
		anim = new Animation(.15f, frames);
		
		stateTime = 0;
		currentFrame = frames[0];
		
		cam = new MyCamera(Game.SIZE, true);
		
		time = 0;
		timer = anim.getAnimationDuration() * (2 + (1f / 16f));
	}

	@Override
	public void handleInput() {
		if(MyInput.keyPressed(MyInput.ANY)) {
			toNextState();
		}
	}

	@Override
	public void update(float dt) {
		
		time += dt;
		
		text = "Tiny Country Games Presents";
		texw = currentFrame.getRegionWidth();
		texx = Game.CENTER.x - (texw * .5f);
		texy = Game.CENTER.y + 25;

		textX = 10;
		textY = texy - 50;
		
		if(time > timer) {
			toNextState();
		}
	}

	@Override
	public void draw(SpriteBatch sb, ShapeRenderer sr, float dt) {
		stateTime += dt;
		currentFrame = anim.getKeyFrame(stateTime, true);
		
		sb.begin();
		sb.setProjectionMatrix(cam.combined);
		sb.draw(currentFrame, texx, texy);
		Game.res.getFont("large").drawWrapped(sb, text, textX, textY, Game.SIZE.x - 20, HAlignment.CENTER);
		sb.end();

	}

	private void toNextState() {
		Gdx.app.exit();
	}

	@Override
	public void resize(Vector2 size) {
		cam.resize(size, true);
	}
	
	@Override
	public void dispose() {
		temp.dispose();
	}

}
