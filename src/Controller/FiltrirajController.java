package Controller;

import View.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import Module.Akcija;

public class FiltrirajController implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        for (Akcija akcija : MainView.getInstance().getLista().getItems())
        {
            if (!akcija.getIme().toLowerCase().contains(MainView.getInstance().getInputImena().getText().toLowerCase()))
            {
                MainView.getInstance().getLista().getItems().remove(akcija);
            }
        }
    }
}
