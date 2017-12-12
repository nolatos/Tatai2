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

    Difficulty getDifficulty() {
        return difficulty;
    }

    void advance() {
        progress++;
    }

    abstract void nextQuestion();

    abstract boolean checkCorrect();

    int getAnswer() {
        return questionList.get(progress).getAnswer();
    }

    /**
     * Sets the recognised value
     * @param i
     */
    void setRecognised(int i) {
        questionList.get(progress).setRecognised(i);
    }

}
