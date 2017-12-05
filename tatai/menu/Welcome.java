package tatai.menu;

import tatai.Category;
import tatai.Difficulty;

/**
 * Created by olive on 6/12/2017.
 */
public class Welcome {

    Category category;
    Difficulty difficulty;
    private WelcomeController controller;

    public Welcome(WelcomeController controller) {
        this.controller = controller;
    }

}
