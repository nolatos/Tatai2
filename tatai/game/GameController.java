package tatai.game;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import tatai.Category;
import tatai.Controller;
import tatai.Difficulty;
import tatai.start.StartController;

import java.io.IOException;
import java.net.URL;

/**
 * Created by olive on 6/12/2017.
 */
public class GameController extends Controller{

    private Game model;
    private GameView view;
    private StartController startController;
    private Scene gameScene;

    /**
     * Constructor sets everything up, including the model and the FXML
     * @param difficulty
     * @param category
     */
    public GameController(Difficulty difficulty, Category category, StartController startController) {

        this.startController = startController;

        try {
            //Loading fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("play.fxml"));
            Pane pane = loader.load();
            this.gameScene = new Scene(pane);

            //Setting up view
            view = loader.getController();
            view.setController(this);

        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }

        //Setting up the model
        switch (category) {
            case ARITHMETIC:
                this.model = new ArithmeticGame(difficulty, this);
                break;
            default:
                this.model = new ArithmeticGame(difficulty, this);
        }

        view.setModel(model);


    }

    @Override
    public void show() {
        mainStage.setScene(gameScene);
        showingPane = view.getMainPane();
    }

    /**
     * Displays the startController
     */
    void back() {
        this.startController.show();
    }

    void displayQuestion(String string) {
        view.displayQuestion(string);
    }

    void displayQuestion(URL url) {
        view.displayQuestion(url);
    }

}
