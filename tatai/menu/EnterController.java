package tatai.menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EnterController {

    private Stage enterStage;

    @FXML
    private TextField name;

    @FXML
    private Button enterBtn;

    @FXML
    void enter(ActionEvent event) {
        WelcomeController welcomeController = new WelcomeController(this);
        welcomeController.start();
    }


    public void setEnterStage(Stage stage) {
        this.enterStage = stage;
    }

    /**
     * Shows the enter scene
     * @param stage
     */
    public void show(Stage stage) {
        stage.close();
        this.enterStage.show();
    }

}

