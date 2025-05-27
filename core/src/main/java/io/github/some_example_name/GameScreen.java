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

;import static com.badlogic.gdx.Input.Keys.X;
import static com.badlogic.gdx.Input.Keys.Z;

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
    int scene = 0;
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
        if(Gdx.input.isKeyJustPressed(Z)){

            if(scene == 2){
                scene = 700;
            }
            else scene++;
        }
        if(Gdx.input.isKeyJustPressed(X)){
            scene = 69;
            if(scene == 702){
                scene = 666;
            }
        }
    }
    public void draw(){
        ScreenUtils.clear(0f,0f,0f,1f);
        game.batch.begin();
        game.batch.draw(backgroundTexture, 0, 0, worldWidth, worldHeight);
        shelly.draw(game.batch);
        textbox.draw(game.batch);
        texts(scene);
        System.out.println(textbox.getY());
        game.batch.end();
    }
    public void texts(int scene){
        if (this.scene == 0){
            font.draw(game.batch, "Heya! welcome to Boothill High", textbox.getX()*4f, textbox.getY()*5f);
            font.draw(game.batch, "I'll show you the ropes to this high school...", textbox.getX()*4f, textbox.getY()*4f);
            font.draw(game.batch, "Z to continue", textbox.getX()*4f, textbox.getY()*3f);
        }
        if (this.scene == 1){
            backgroundTexture = new Texture("homeroom.jpg");
            font.draw(game.batch, "Here is your homeroom, D-19, with Mr Colt", textbox.getX()*4f, textbox.getY()*5f);
            font.draw(game.batch, "", textbox.getX()*4f, textbox.getY()*4f);
        }
        if (this.scene == 2){
            backgroundTexture = new Texture("homeroom.jpg");
            font.draw(game.batch, "hey do u like me", textbox.getX()*4f, textbox.getY()*5f);
            font.draw(game.batch, "Z - yes, X - no", textbox.getX()*4f, textbox.getY()*4f);
        }
        if (this.scene == 700){
            backgroundTexture = new Texture("homeroom.jpg");
            shelSprite = new Texture("shelblush.png");
            shelly = new Sprite(shelSprite);
            shelly.setSize(worldWidth*0.35f,worldWidth*0.55f);
            shelly.setPosition(worldWidth*0.64f - shelly.getWidth()*0.5f, worldHeight*0.48f - shelly.getHeight()/2);
            font.draw(game.batch, "yes yes yes!!! i love u too", textbox.getX()*4f, textbox.getY()*5f);
            font.draw(game.batch, "Z - yes, X - no", textbox.getX()*4f, textbox.getY()*4f);
        }
        if (this.scene == 69){
            backgroundTexture = new Texture("homeroom.jpg");
            font.draw(game.batch, "i hate u vro", textbox.getX()*4f, textbox.getY()*5f);
            font.draw(game.batch, "Z - yes,", textbox.getX()*4f, textbox.getY()*4f);
        }
        if (this.scene == 70){
            backgroundTexture = new Texture("homeroom.jpg");
            font.draw(game.batch, "how could u do ts to me", textbox.getX()*4f, textbox.getY()*5f);
            font.draw(game.batch, "Z - yes, ", textbox.getX()*4f, textbox.getY()*4f);
        }
        if (this.scene == 71){
            backgroundTexture = new Texture("homeroom.jpg");
            font.draw(game.batch, "i thought we had smth", textbox.getX()*4f, textbox.getY()*5f);
            font.draw(game.batch, "Z - yes, ", textbox.getX()*4f, textbox.getY()*4f);
        }
        if (this.scene == 72){
            backgroundTexture = new Texture("homeroom.jpg");
            shelSprite = new Texture("img_2.png");
            shelly = new Sprite(shelSprite);
            shelly.setSize(worldWidth*0.35f,worldWidth*0.55f);
            shelly.setPosition(worldWidth*0.64f - shelly.getWidth()*0.5f, worldHeight*0.48f - shelly.getHeight()/2);
            font.draw(game.batch, "h-hey im collete", textbox.getX()*4f, textbox.getY()*5f);
            font.draw(game.batch, "Z - hi!, ", textbox.getX()*4f, textbox.getY()*4f);
        }
        if (this.scene == 73){
            backgroundTexture = new Texture("homeroom.jpg");
            font.draw(game.batch, "you have such nice biceps", textbox.getX()*4f, textbox.getY()*5f);
            font.draw(game.batch, "Z - i know, ", textbox.getX()*4f, textbox.getY()*4f);
        }
        if (this.scene == 701){
            backgroundTexture = new Texture("homeroom.jpg");
            font.draw(game.batch, "why dont we go on a date sweetie", textbox.getX()*4f, textbox.getY()*5f);
            font.draw(game.batch, "Z - yes", textbox.getX()*4f, textbox.getY()*4f);
        }
        if (this.scene == 702){
            shelSprite = new Texture("img.png");
            shelly = new Sprite(shelSprite);
            shelly.setSize(worldWidth*0.35f,worldWidth*0.55f);
            shelly.setPosition(worldWidth*0.64f - shelly.getWidth()*0.5f, worldHeight*0.48f - shelly.getHeight()/2);
            backgroundTexture = new Texture("park.png");
            font.draw(game.batch, "I love being here with u", textbox.getX()*4f, textbox.getY()*5f);
            font.draw(game.batch, "do you like my casualwear..?", textbox.getX()*4f, textbox.getY()*4f);
            font.draw(game.batch, "Z - i love u, X - let's break up", textbox.getX()*4f, textbox.getY()*3f);
        }
        if (this.scene == 703){
            backgroundTexture = new Texture("park.png");
            font.draw(game.batch, "ily too", textbox.getX()*4f, textbox.getY()*5f);
        }
        if (this.scene == 704){
            backgroundTexture = new Texture("park.png");
            font.draw(game.batch, "The END (shelly ending)", textbox.getX()*4f, textbox.getY()*5f);
        }
        if (this.scene == 666){
            backgroundTexture = new Texture("park.png");
            font.draw(game.batch, ":(", textbox.getX()*4f, textbox.getY()*5f);
            font.draw(game.batch, "", textbox.getX()*4f, textbox.getY()*4f);
        }
    }
}


