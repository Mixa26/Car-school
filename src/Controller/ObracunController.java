package Controller;

import View.ObracunView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import Main.Main;
import javafx.stage.Stage;

public class ObracunController implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Stage stage = new Stage();
        stage.setTitle("Obracun");
        if (ObracunView.getIsntance().getScene() == null)
        {
            stage.setScene(ObracunView.getIsntance().makeScene());
        }
        else
        {
            stage.setScene(ObracunView.getIsntance().getScene());
        }
        stage.show();
    }
}
