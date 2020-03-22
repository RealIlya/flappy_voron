package com.mygdx.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {
    protected OrthographicCamera camera;
    protected Vector3 mouse;
    protected GameStateManager gsm;

    // создание конструктора класса State.
    // конструктор класса необходим для получения значений
    // из других классов
    public State (GameStateManager gsm) {
        // this - контекст это то, в пределах чего мы работаем. т.е в данном
        // коде this.gsm означает, что мы работаем с поле нашего класса (State)
        this.gsm = gsm;
        camera = new OrthographicCamera();
        mouse = new Vector3();
    }

    protected abstract void handleInput(); // обработчик нажатия
    public abstract void update(float dt); // обновление объектов, каждый дельтатайм
    public abstract void render(SpriteBatch sb); // отрисовка объектов на экране
    public abstract void dispose(); // удаление объектов

}
