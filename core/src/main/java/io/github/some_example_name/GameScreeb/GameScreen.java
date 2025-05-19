package io.github.some_example_name.GameScreeb;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.some_example_name.Drop;


public class GameScreen {
    float worldwidth;
    float worldheight;
    Drop game;
    public GameScreen (final Drop game){
        this.game = game;
    }
    private void text(){
        ScreenUtils.clear(0f, 0f, 0f, 0f);

        game.viewport.apply();

    }





    private void screensize(){
         worldwidth = Gdx.graphics.getWidth();
         worldheight = Gdx.graphics.getHeight();
    }
    public float worldWidth(){
        return worldwidth;
    }
    public float worldHeight(){
        return worldheight;
    }

}


