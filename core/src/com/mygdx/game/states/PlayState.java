package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.FlappyBird;
import com.mygdx.game.sprites.Bird;

public class PlayState extends State {
    private Bird bird;
    private Texture background;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bg.png");
        bird = new Bird(50,FlappyBird.HEIGHT/2);
        // установим камеру по середине игрового окна
        camera.setToOrtho(false, FlappyBird.WIDTH/2,
                                        FlappyBird.HEIGHT/2);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            bird.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        // делаем так, чтобы камера при постоянной отрисовки захватывала именно игровое поле
        // и в таком виде она и будет следить за птицей
        sb.setProjectionMatrix(camera.combined);

        sb.begin();
        sb.draw(background, 0, 0, FlappyBird.WIDTH, FlappyBird.HEIGHT);
        // создав getter'ы текстуры и птицы в классе Bird мы можеи получить их значения
        // даже учитывая, что они являются private. Данный подход является частью инкапсуляции
        // (т.е. безопасность данных)
        sb.draw(bird.getBird(), bird.getPosition().x, bird.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
