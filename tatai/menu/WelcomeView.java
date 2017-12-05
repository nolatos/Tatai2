package tatai.menu;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import tatai.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by olive on 28/11/2017.
 */
public class WelcomeView  {

    private WelcomeController controller;
    private int state = 0;

    @FXML
    private Pane mainPane;

    @FXML
    private Button play;

    @FXML
    private Button practice;

    @FXML
    private Button stats;

    @FXML
    private Pane levelPane;

    @FXML
    private Button arithmetic;

    @FXML
    private Button algebra;

    @FXML
    private Button calculus;

    @FXML
    private Button custom;

    @FXML
    private Button trig;

    @FXML
    private Button equations;

    @FXML
    private Button word;

    @FXML
    private ImageView levels;

    @FXML
    private Button instructions;

    @FXML
    private Button about;

    @FXML
    private Button back;

    @FXML
    private Pane buttonPane;

    @FXML
    private Button logOut;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Pane difficultyPane;

    @FXML
    private Button easy;

    @FXML
    private Button medium;

    @FXML
    private Button hard;

    @FXML
    void aboutPressed(ActionEvent event) {

    }

    @FXML
    void backToMenu(ActionEvent event) {
        switch (state) {
            case 1:
                this.levelPane.setVisible(false);
                this.back.setVisible(false);
                this.buttonPane.setVisible(true);
                this.difficultyPane.setVisible(false);
                state = 0;
                break;
            case 2:
                this.levelPane.setVisible(true);
                this.buttonPane.setVisible(false);
                this.difficultyPane.setVisible(false);
                state = 1;
                break;
            default:
        }

    }

    @FXML
    void changeColour(MouseEvent event) {
        this.controller.changeColour(event);
    }

    @FXML
    void changeColourBack(MouseEvent event) {
        this.controller.changeColourBack(event);
    }

    @FXML
    void instructionsPressed(ActionEvent event) {

    }

    @FXML
    void levelPressed(ActionEvent event) {
        state = 2;
        this.levelPane.setVisible(false);
        this.buttonPane.setVisible(false);
        this.difficultyPane.setVisible(true);
    }

    @FXML
    void logOut(ActionEvent event) {

    }

    @FXML
    /**
     * Displays the levels
     */
    void playPressed(ActionEvent event) {
        state = 1;
        this.levelPane.setVisible(true);
        this.back.setVisible(true);
        this.buttonPane.setVisible(false);
        this.difficultyPane.setVisible(false);
    }

    @FXML
    void practicePressed(ActionEvent event) {

    }

    @FXML
    void difficultyPressed(ActionEvent event) {

    }

    @FXML
    void statsPressed(ActionEvent event) {

    }

    void playFadeTransition(EventHandler<ActionEvent> handler, int milliSeconds, Node node) {
        FadeTransition ft = new FadeTransition(Duration.millis(milliSeconds), node);

        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setOnFinished(handler);

        ft.play();

    }

    void setController(WelcomeController controller) {
        this.controller = controller;
    }

    void playStartAnimation() {
        //Fading in the welcome label
        FadeTransition ft = new FadeTransition(Duration.millis(1000), welcomeLabel);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setOnFinished(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {

                //Fade out the label
                FadeTransition ft = new FadeTransition(Duration.millis(1600), welcomeLabel);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        //Setting up the menu
                        welcomeLabel.setVisible(false);

                        //Fade in the main pane
                        FadeTransition ft = new FadeTransition(Duration.millis(100), mainPane);
                        ft.setFromValue(0);
                        ft.setToValue(1);
                        ft.setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                logOut.setVisible(true);
                            }
                        });
                        ft.play();
                    }
                });
                ft.play();
            }
        });
        ft.play();
    }



    Pane getMainPane() {
        return mainPane;
    }
}
