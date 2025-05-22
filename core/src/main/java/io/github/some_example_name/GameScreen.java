package io.github.some_example_name;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class GameScreen implements Screen {
    final Drop game;

    Texture backgroundTexture;
    float worldwidth;
    float worldheight;
    private String background;
    Sprite shelly;
    Texture shelSprite;
    Sprite textbox;
    Texture boxtext;
    BitmapFont font;
    public GameScreen (final Drop game, String gameBG){
        this.game = game;
        this.background = gameBG;
        font = new BitmapFont(false);
        font.setColor(0f,0f,0f,1f);
        font.getData().setScale(0.05f);
        backgroundTexture = new Texture(gameBG);
        shelSprite = new Texture("shelly.png");
        shelly = new Sprite(shelSprite);
        shelly.setSize(2,3);
        shelly.setPosition(3,0.5f);
        boxtext = new Texture("textbox.png");
        textbox = new Sprite(boxtext);
        textbox.setPosition(1.5f,0.1f);
        textbox.setSize(5,1.5f);
    }
    @Override
    public void show() {
        //music
    }

    @Override
    public void render(float delta) {
        input();
        draw();
    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height, true);
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
        backgroundTexture.dispose();
    }
    public void input(){
        //For changign textboxes <3
    }
    public void draw(){
        ScreenUtils.clear(0f,0f,0f,0f);
        game.viewport.apply();
        game.batch.setProjectionMatrix(game.viewport.getCamera().combined);
        game.batch.begin();

        float worldWidth = game.viewport.getWorldWidth();
        float worldHeight = game.viewport.getWorldHeight();

        game.batch.draw(backgroundTexture, 0, 0, worldWidth, worldHeight);
        shelly.draw(game.batch);
        textbox.draw(game.batch);
        font.draw(game.batch, "Test", 1.5f, 1f);
        game.batch.end();
    }
    public float worldWidth(){
        return worldwidth;
    }
    public float worldHeight(){
        return worldheight;
    }

}


