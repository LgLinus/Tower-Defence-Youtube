package com.ligr.towerdefence;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.color.Color;

import android.util.Log;

public class Main extends SimpleBaseGameActivity {
	 
	// Defines the width of the screen
	public static final int CAMERA_WIDTH = 1280;
	// Defines the height of the screen
	public static final int CAMERA_HEIGHT = 720; 
	// Set the FPS to 60
	public static final int FPS_LIMIT = 60;
	// The camera 
	private Camera camera;
	
	private BuildableBitmapTextureAtlas gameAtlas;
	
	private Scene mScene;;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		// Creates our camera, with the position x = 0 and y = 0 and the
		// width/height of CAMERA_WIDTH/CAMERA_HEIGHT
		camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);

		// Creates some options for our app.
		// For example, we want the phone to only use the orientation LANDSCAPE
		// And we want the resolution to be locked at 
		// new FillResolutionPolicy(), camera);
		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_SENSOR,
				new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);
	}

	@Override
	protected void onCreateResources() {
		// TODO Auto-generated method stub

		gameAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(),
				4096, 4096);

		// mEngine.getTextureManager().loadTexture(GameAtlas);
		try {
			gameAtlas
					.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(
							0, 1, 1));
			gameAtlas.load();
		} catch (TextureAtlasBuilderException e) {
			Log.e("", "" + e);
		}
		//this.mEngine.getTextureManager().loadTexture(gameAtlas);
	}

	@Override
	protected Scene onCreateScene() {
		mScene = new Scene();
		mScene.setBackground(new Background(Color.WHITE));
		return mScene;
	}

}
