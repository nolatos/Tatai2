package tatai;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tatai.menu.EnterController;

import java.io.IOException;

public class Main extends Application {



    public static void main(String[] args) {
        launch(Main.class, args);
    }

    @Override
    public void start(Stage stage) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu/enter.fxml"));
            Pane pane = (Pane) loader.load();
            EnterController controller = loader.getController();
            controller.setEnterStage(stage);

            stage.setScene(new Scene(pane));
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }


    }

}