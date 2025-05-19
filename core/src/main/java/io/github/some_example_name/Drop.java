package io.github.some_example_name;



import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;


    public class Drop extends Game {

        public SpriteBatch batch;
        public BitmapFont font;
        public BitmapFont font2;
        public FitViewport viewport;


        public void create() {
            batch = new SpriteBatch();
            // use libGDX's default font
            font = new BitmapFont();
            font2 = new BitmapFont();
            viewport = new FitViewport(8, 5);

            //font has 15pt, but we need to scale it to our viewport by ratio of viewport height to screen height
            font.setUseIntegerPositions(false);
            font.getData().setScale(viewport.getWorldHeight() / Gdx.graphics.getHeight());

            font2.setUseIntegerPositions(false);
            font.getData().setScale(viewport.getWorldHeight() / Gdx.graphics.getHeight());

        }

        public void render() {
            super.render(); // important!
        }

        public void dispose() {
            batch.dispose();
            font.dispose();
        }

    }

