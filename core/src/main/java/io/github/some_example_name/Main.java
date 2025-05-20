package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/** {@link ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private GameScreen screen;
    private MainGame datingsim;
    @Override
    public void create() {
        batch = new SpriteBatch();
        datingsim = new MainGame();
        datingsim.create();
        screen = new GameScreen(datingsim);

    }
    @Override
    public void render() {
        datingsim.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
