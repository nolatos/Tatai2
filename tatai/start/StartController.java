package tatai.start;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import tatai.Category;
import tatai.Controller;
import tatai.Difficulty;
import tatai.game.GameController;
import tatai.menu.WelcomeController;

import java.io.IOException;

/**
 * Created by olive on 6/12/2017.
 */
public class StartController extends Controller {

    private StartView view;
    private Start model;
    private Scene startScene;
    private WelcomeController welcomeController;

    /**
     * Constructor sets everything up including fxml
     * @param category
     * @param difficulty
     */
    public StartController(Category category, Difficulty difficulty, WelcomeController welcomeController) {

        //Setting up model
        model = new Start(this, category, difficulty);

        //Setting up welcomeController
        this.welcomeController = welcomeController;

        try {
            //Loading FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("start.fxml"));
            Pane pane = loader.load();
            this.startScene = new Scene(pane);
            view = loader.getController();
            view.setControllerAndModel(this, model);
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }

    @Override
    /**
     * Shows the Start scene
     */
    public void show() {
        mainStage.setScene(startScene);
        showingPane = view.getMainPane();
    }

    void backToMenu() {
        this.welcomeController.show();
    }

    void startGame() {
        GameController gameController = new GameController(model.getDifficulty(), model.getCategory(), this);
        gameController.show();
    }
}
