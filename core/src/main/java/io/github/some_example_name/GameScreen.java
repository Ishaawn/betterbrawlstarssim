package io.github.some_example_name;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.ScreenUtils;

;

public class GameScreen implements Screen {
    final Drop game;
    Texture backgroundTexture;
    private String background;
    Sprite shelly;
    Texture shelSprite;
    Sprite textbox;
    Texture boxtext;

    float worldWidth;
    float worldHeight;
    TextureRegion redTextBox;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    FreeTypeFontGenerator generator;
    BitmapFont font;
    public GameScreen (final Drop game, String gameBG){
        this.game = game;
        this.background = gameBG;
        generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        backgroundTexture = new Texture(gameBG);
        shelSprite = new Texture("shelly.png");
        boxtext = new Texture("textbox.png");

        shelly = new Sprite(shelSprite);
        redTextBox = new TextureRegion(boxtext, boxtext.getWidth(), (int) (boxtext.getHeight()*0.48f));
        textbox = new Sprite(redTextBox);


    }
    @Override
    public void show() {
        parameter.size = 180;
        font = generator.generateFont(parameter);
        font.getData().setScale(0.1f);
        worldWidth = game.viewport.getWorldWidth();
        worldHeight = game.viewport.getWorldHeight();
        System.out.println(worldWidth + " " + worldHeight);

        shelly.setSize(worldWidth*0.35f,worldWidth*0.55f);
        shelly.setPosition(worldWidth*0.64f - shelly.getWidth()*0.5f, worldHeight*0.48f - shelly.getHeight()/2);

        textbox.setSize(worldWidth*0.95f,worldHeight*0.8f);
        textbox.setPosition(worldWidth*0.5f - textbox.getWidth()*0.5f, worldHeight*0.06f);
        textbox.setAlpha(0.9f);
        //music
    }

    @Override
    public void render(float delta) {
        game.viewport.apply();
        game.batch.setProjectionMatrix(game.viewport.getCamera().combined);
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
        ScreenUtils.clear(0f,0f,0f,1f);
        game.batch.begin();
        game.batch.draw(backgroundTexture, 0, 0, worldWidth, worldHeight);
        shelly.draw(game.batch);
        textbox.draw(game.batch);
        font.draw(game.batch, "I-it's not like I like you or anything!!", textbox.getX()*4f, textbox.getY()*5f);
        //reminder to self: text space (line up down) is 1! 5f -> 4f
        font.draw(game.batch, "Dummy...", textbox.getX()*4f, textbox.getY()*4f);
        System.out.println(textbox.getY());
        game.batch.end();
    }
}


