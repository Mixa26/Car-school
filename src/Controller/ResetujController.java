package Controller;

import View.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import Module.Database;

public class ResetujController implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        MainView.getInstance().getLista().getItems().clear();
        MainView.getInstance().getLista().getItems().addAll(Database.getInstance().getPohadjaci());
        MainView.getInstance().getLista().refresh();
    }
}
