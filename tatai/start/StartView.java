package tatai.start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class StartView {

    private StartController controller;
    private Start model;

    @FXML
    private Button menu;

    @FXML
    private Button instructions;

    @FXML
    private Pane mainPane;

    @FXML
    private ListView<String> progressList;

    @FXML
    private Label levelLabel;

    @FXML
    private Button start;

    @FXML
    void backToMenu(ActionEvent event) {
        this.controller.backToMenu();
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
    void showInstructions(ActionEvent event) {

    }

    @FXML
    void startGame(ActionEvent event) {

    }

    /**
     * Sets the controller and Model and sets the label
     * @param controller
     * @param model
     */
    void setControllerAndModel(StartController controller, Start model) {
        this.controller = controller;
        this.model = model;

        this.levelLabel.setText(this.model.getCategory().toString());
    }

    Pane getMainPane() {
        return mainPane;
    }

}
