package io.github.some_example_name;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Drop extends Game{

    public SpriteBatch batch;
    public BitmapFont font;
    public FitViewport viewport;
    public void create(){
        Graphics.DisplayMode displayMode = Gdx.graphics.getDisplayMode();
        Gdx.graphics.setFullscreenMode(displayMode);
        batch = new SpriteBatch();
        font = new BitmapFont();
        viewport = new FitViewport((640),(360));
        font.setUseIntegerPositions(false);
        font.getData().setScale(viewport.getWorldHeight()/ Gdx.graphics.getHeight());
        this.setScreen(new MainMenu(this));
    }
    public void render(){
        super.render();
    }
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
