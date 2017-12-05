package tatai.start;

import tatai.Category;
import tatai.Difficulty;

/**
 * Created by olive on 6/12/2017.
 */
public class Start {

    private StartController controller;
    private Category category;
    private Difficulty difficulty;

    Start(StartController controller, Category category, Difficulty difficulty) {
        this.controller = controller;
        this.category = category;
        this.difficulty = difficulty;
    }

    Category getCategory() {
        return this.category;
    }

    Difficulty getDifficulty() {
        return this.difficulty;
    }
}
