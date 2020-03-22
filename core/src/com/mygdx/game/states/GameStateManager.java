package com.mygdx.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {

    // стэк это структура хранения данных(по сути массив), и через этот
    // стэк мы будем следить за состоянием игровых окон
    // (т.е. Меню, Сама игра, GameOver)
    private Stack<State> states;

    // создаём конструктор класса
    public GameStateManager() {
        states = new Stack<State>();
    }

    // метод push будет добавлять окно/состояние в конец стэка
    public void push(State state) {
        states.push(state); // как только будет вызван метод push с переданным окном, то
        // это окно будет помещено в конец стэка
    }

    // при вызове метода pop будет удаляться последний элемент стэка и удалить из памяти
    // методом libgdx - dispose()
    public void pop() {
        states.pop().dispose();
    }

    // реализует механизм последний вошёл -> первый вышел
    public void set(State state) {
        states.pop().dispose();
        states.push(state);
    }

    public void update(float dt) {
        // peek() - метод, который просматривает верхний элемент
        // (т.е. активное окно, но не удаляет его)
        // update - libgdx метод, который обновляет окно раз в дельтатайм
        states.peek().update(dt);
    }

    // отрисовка активного, т.е. последнего в стэке окна
    public void render(SpriteBatch sb) {
        states.peek().render(sb);
    }

}