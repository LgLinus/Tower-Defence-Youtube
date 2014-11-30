package com.ligr.towerdefence;

import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;

public class Images {

	private ITextureRegion grassImage,
		roadImage;
	
	public void loadImages(BuildableBitmapTextureAtlas gameAtlas, SimpleBaseGameActivity activity){

		grassImage = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameAtlas, activity, "gfx/grassTile.png");
		roadImage = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameAtlas, activity, "gfx/roadTile.png");
	}

	public ITextureRegion getGrassTile() {
		return grassImage;
	}
	
	public ITextureRegion getRoadImage() {
		return roadImage;
	}
	
}
