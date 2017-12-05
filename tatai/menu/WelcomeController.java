package tatai.menu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import tatai.Controller;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by olive on 28/11/2017.
 */
public class WelcomeController extends Controller {

    private WelcomeView view;

    private Scene welcomeScene;

    private EnterController enterController;



    /**
     * Constructor loads the fxml, then plays the welcome animation
     * @param enterController
     */
    public WelcomeController(EnterController enterController) {

        this.enterController = enterController;

        try {
            //Loading FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("welcome.fxml"));
            Pane pane = loader.load();
            this.welcomeScene  = new Scene(pane);
            this.view = loader.getController();
            this.view.setController(this);

            //Setting up the stage
            mainStage.setResizable(false);
            mainStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    try {
                        event.consume();

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Confirm Exit");
                        alert.setHeaderText("Are you sure you want to exit?");
                        alert.setContentText("Any unsaved progress may be lost");
                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK) {
                            closeApplication();
                        }
                    }
                    catch (Exception ex) {
                        System.exit(0);
                    }
                }
            });
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }


    }

    @Override
    /**
     * Shows the welcome scene
     */
    public void show() {
        showingPane = view.getMainPane();
        mainStage.setScene(this.welcomeScene);
    }

    /**
     * Used to play the start animation
     */
    void start() {
        this.show();
        mainStage.sizeToScene();
        mainStage.show();
        this.view.playStartAnimation();
    }

    private void closeApplication() {
        try {
            view.playFadeTransition(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.exit(0);
                }
            }, 1300, showingPane);
        }
        catch (Exception ex) {
            System.exit(0);
        }
    }
}
