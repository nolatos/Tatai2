package tatai.game;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;

/**
 * Created by olive on 6/12/2017.
 */
public class GameView {


    @FXML
    private Button menu;

    @FXML
    private Pane mainPane;

    @FXML
    private Pane gamePane;

    @FXML
    private ProgressBar progress;

    @FXML
    private ImageView questionImage;

    @FXML
    private Label numberLabel;

    @FXML
    private Button retry;

    @FXML
    private Button check;

    @FXML
    private Label correct;

    @FXML
    private Label tryAgain;

    @FXML
    private Button next;

    @FXML
    private Label sorry;

    @FXML
    private Label ones;

    @FXML
    private Label answerWas;

    @FXML
    private Button working;

    @FXML
    private TextField answerField;

    @FXML
    private Pane workingPane;

    @FXML
    private ImageView workingImage;

    @FXML
    private Button ok;

    private GameController controller;

    void setController(GameController controller) {
        this.controller = controller;
    }

    @FXML
    void back(ActionEvent event) {

    }

    @FXML
    void changeColour(MouseEvent event) {
        controller.changeColour(event);
    }

    @FXML
    void changeColourBack(MouseEvent event) {
        controller.changeColourBack(event);
    }

    @FXML
    void checkAns(ActionEvent event) {

    }

    @FXML
    void next(ActionEvent event) {

    }

    @FXML
    void retry(ActionEvent event) {

    }

    @FXML
    void showWorking(ActionEvent event) {

    }

    @FXML
    void workingSeen(ActionEvent event) {

    }

    Pane getMainPane() {
        return mainPane;
    }


    void displayQuestion(String string) {
        numberLabel.setText(string);
        numberLabel.setVisible(true);
        questionImage.setVisible(false);
    }

    void displayQuestion(URL url) {
        questionImage.setImage(new Image(url.toString()));
        questionImage.setVisible(true);
        numberLabel.setVisible(false);
    }
}
