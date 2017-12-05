package tatai;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by olive on 28/11/2017.
 */
public abstract class Controller {


    protected static Pane showingPane; //The pane that is showing right now

    protected static Stage mainStage = new Stage();

    /**
     * Changes the colour of the buttons to reverse text and background when mouse hovers over it
     * @param event
     */
    public void changeColour(MouseEvent event) {
        Object obj = event.getSource();
        if (obj instanceof Button) {
            Button button = (Button) obj;
            ((Button) obj).setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 10, 10); -fx-background-color: white;");
            button.setTextFill(Color.ORANGE);

        }
    }

    /**
     * Changes the colour of the buttons back
     * when mouse leaves
     * @param event
     */
    public void changeColourBack(MouseEvent event) {
        Object obj = event.getSource();
        if (obj instanceof Button) {
            Button button = (Button) obj;
            button.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 10, 10); -fx-background-color: orange;");
            button.setTextFill(Color.WHITE);
        }
    }

    protected abstract void show();



}
