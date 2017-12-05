package tatai.game;

import tatai.Difficulty;

/**
 * Created by olive on 4/12/2017.
 */
public abstract class Game {

    private Difficulty difficulty;
    private GameController controller;

    Game(Difficulty difficulty, GameController controller) {
        this.difficulty = difficulty;
        this.controller = controller;
    }
}
