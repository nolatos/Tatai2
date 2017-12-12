package tatai.game;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import tatai.Difficulty;

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

    @FXML
    private Button skip;


    private GameController controller;
    private Game model;
    private boolean canCheck; //To see if we can check answer
    private boolean retried = false;

    void setController(GameController controller) {
        this.controller = controller;
    }

    void setModel(Game model) {
        this.model = model;
    }

    @FXML
    void back(ActionEvent event) {
        controller.back();
    }

    @FXML
    void skip(ActionEvent event) {
        retried = true;
        numberLabel.setVisible(false);
        questionImage.setVisible(false);
        answerField.setVisible(false);
        check.setVisible(false);
        skip.setVisible(false);
        displayIncorrectScreen();
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
        if (canCheck) { //Only do something if we can check it
            model.setRecognised(Integer.parseInt(answerField.getText()));
            numberLabel.setVisible(false);
            questionImage.setVisible(false);
            answerField.setVisible(false);
            check.setVisible(false);
            skip.setVisible(false);
            if (model.checkCorrect()) {
                displayCorrectScreen();
            }
            else {
                displayIncorrectScreen();
            }

        }
    }

    @FXML
    void next(ActionEvent event) {
        model.advance();
        progress.setProgress((double)model.progress / 10);
        revertToOriginal();
    }

    @FXML
    void retry(ActionEvent event) {
        revertToOriginal();
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

    /**
     * Displays the "correct"
     */
    private void displayCorrectScreen() {
        numberLabel.setVisible(false);
        questionImage.setVisible(false);
        correct.setVisible(true);
        next.setVisible(true);

    }

    private void displayIncorrectScreen() {
        //Getting rid of the number Label
        numberLabel.setVisible(false);
        questionImage.setVisible(false);

        //Depending on whether we have retried it, we decide what to display
        if (retried) {
            sorry.setVisible(true);
            next.setVisible(true);
            answerWas.setVisible(true);
            ones.setVisible(true);
            ones.setText("" + model.getAnswer());
            retried = false;
        }
        else {
            retry.setVisible(true);
            tryAgain.setVisible(true);
            retried = true;
        }



    }

    public void initialize() {
        answerField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                textChanged();
            }
        });
    }

    private void textChanged() {
        //If the chars are all numbers then we enable the button
        char[] chars = answerField.getText().toCharArray();
        boolean containsOnlyNumbers = true;
        if (chars.length == 0) {
            containsOnlyNumbers = false;
        }
        else {
            for (char c : chars) {
                if (Character.isDigit(c) == false) {
                    containsOnlyNumbers = false;
                    break;
                }
            }
        }
        if (containsOnlyNumbers) {
            check.setDisable(false);
            this.canCheck = true;
        }
        else {
            check.setDisable(true);
            this.canCheck = false;
        }

    }

    /**
     * Reverts everything back to what it was
     */
    private void revertToOriginal() {
        if (model instanceof ArithmeticGame) {
            numberLabel.setVisible(true);
        }
        else {
            questionImage.setVisible(true);
        }
        answerField.setVisible(true);
        answerField.setText("");
        check.setVisible(true);
        check.setDisable(true);
        skip.setVisible(true);
        sorry.setVisible(false);
        next.setVisible(false);
        answerWas.setVisible(false);
        ones.setVisible(false);
        tryAgain.setVisible(false);
        retry.setVisible(false);
        correct.setVisible(false);
    }
}



class GameException extends RuntimeException {


}