package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.FlappyBird;

public class Bird {
    private Vector3 velocity;
    private Vector3 position;
    private Texture texture;
    private Animation birdAnimation;
    private Rectangle bounds;
    private Sound flap;

    public static final int GRAVITY = -25;
    public static final int MOVEMENT = 100;

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getBird() {
        return birdAnimation.getFrame();
    }


    public Bird(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        texture = new Texture("birdanimation.png");
        birdAnimation = new Animation(new TextureRegion(texture), 3, 0.5f);
        bounds = new Rectangle(x, y, texture.getWidth() / 3, texture.getHeight());
        flap = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
    }

    public void update(float dt) {
        birdAnimation.update(dt);
        velocity.add(0, GRAVITY, 0);
        velocity.scl(dt);
        position.add(MOVEMENT * dt, velocity.y, 0);

        // коэффициент скорости падения
        velocity.scl(1 / dt);

        // устанавливаем движение коллайдера "птица" за текстурой птицы
        bounds.setPosition(position.x, position.y);
    }

    public void jump() {
        velocity.y = 250;
        flap.play();
    }

    public Rectangle getBounds() {
        // при вызове метода вернём в точку вызова коллайдера
        return bounds;
    }

    public void dispose() {
        texture.dispose();
    }
}



