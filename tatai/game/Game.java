package tatai.game;

import tatai.Difficulty;
import tatai.math.Question;

import java.util.List;

/**
 * Created by olive on 4/12/2017.
 */
public abstract class Game {

    private Difficulty difficulty;
    protected GameController controller;
    protected int progress = 0;
    protected List<Question> questionList;

    Game(Difficulty difficulty, GameController controller) {
        this.difficulty = difficulty;
        this.controller = controller;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    abstract void nextQuestion();

}
