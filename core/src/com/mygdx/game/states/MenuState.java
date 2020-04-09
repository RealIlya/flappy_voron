package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.FlappyBird;
import com.mygdx.game.tamplate.GameConstants;

public class MenuState extends State {
    private Texture playBtn;
    private Texture background;
    private Skin mySkin;
    private Stage stage;


    public MenuState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, FlappyBird.WIDTH / 2,
                                        FlappyBird.HEIGHT / 2);
        background = new Texture("bg.png");
        playBtn = new Texture("skin/playbtn.png");
//        mySkin = new Skin(Gdx.files.internal(GameConstants.skin));
//        stage = new Stage(FlappyBird.screenPort);

//        Button playBtn = new Button(mySkin, "small");
//        playBtn.setSize(GameConstants.col_width*2, GameConstants.row_height);
//        playBtn.setPosition(GameConstants.centerX, GameConstants.centerY);

//        stage.addActor(playBtn);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(playBtn, camera.position.x - playBtn.getWidth() / 2, camera.position.y);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        System.out.println("MenuState Disposed");
    }
}
