package io.github.some_example_name;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;


public class GameScreen implements Screen {
    Texture backgroundTexture;
    float worldwidth;
    private SpriteBatch batch;
    float worldheight;
    MainGame game;
    public GameScreen (final MainGame game){
        this.game = game;
        backgroundTexture = new Texture("background.jpg");
    }
    private void screensize(){
        game.viewport.apply();
        game.batch.setProjectionMatrix(game.viewport.getCamera().combined);
        worldwidth = Gdx.graphics.getWidth();
        worldheight = Gdx.graphics.getHeight();
    }

    public void render(){
        ScreenUtils.clear(0f, 0f, 0f, 0f);
        game.batch.begin();
        game.batch.draw(backgroundTexture, 0, 0, worldwidth, worldheight);
        game.font.draw(game.batch, "THIS IS A TEST", 0, worldheight);
        game.batch.end();
    }

    public float worldWidth(){
        return worldwidth;
    }
    public float worldHeight(){
        return worldheight;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}


