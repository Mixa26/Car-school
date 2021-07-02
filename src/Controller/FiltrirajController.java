package Controller;

import Main.Main;
import View.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import Module.Akcija;
import Module.Database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FiltrirajController implements EventHandler<ActionEvent> {
    List<Akcija> current = new ArrayList<>();
    List<Akcija> checked = new ArrayList<>();
    boolean contains;
    int akcijaBR;

    @Override
    public void handle(ActionEvent event) {
        contains = false;
        akcijaBR = 0;
        current.clear();
        checked.clear();

        if(!MainView.getInstance().getInputImena().getText().isEmpty())
        {
            if (!MainView.getInstance().getBrojAkcija().getText().isEmpty())
            {
                for (Akcija akcija : Database.getInstance().getAkcije())
                {
                    for (Akcija akcija1 : checked)
                    {
                        if (akcija.getIme().equals(akcija1.getIme()) && akcija.getPrezime().equals(akcija1.getPrezime()))
                        {
                            contains = true;
                            break;
                        }
                    }

                    if (!contains)
                    {
                        for (int i = Database.getInstance().getAkcije().indexOf(akcija); i < Database.getInstance().getAkcije().size(); i++)
                        {
                            if ((Database.getInstance().getAkcije().get(i).getIme().equals(akcija.getIme()) && Database.getInstance().getAkcije().get(i).getPrezime().equals(akcija.getPrezime())) && Database.getInstance().getAkcije().get(i).getTipAkcije() == MainView.getInstance().getTipAkcije().getSelectionModel().getSelectedItem())
                            {
                                akcijaBR++;
                            }
                        }


                        switch (MainView.getInstance().getVeceManjeJednako().getSelectionModel().getSelectedItem())
                        {
                            case "<": {
                                if ((akcijaBR < Integer.parseInt(MainView.getInstance().getBrojAkcija().getText()) && akcija.getIme().toLowerCase().contains(MainView.getInstance().getInputImena().getText().toLowerCase()) || akcija.getPrezime().toLowerCase().contains(MainView.getInstance().getInputImena().getText().toLowerCase())))
                                {
                                    current.add(akcija);
                                }
                                break;
                            }
                            case ">": {
                                if ((akcijaBR > Integer.parseInt(MainView.getInstance().getBrojAkcija().getText()) && akcija.getIme().toLowerCase().contains(MainView.getInstance().getInputImena().getText().toLowerCase()) || akcija.getPrezime().toLowerCase().contains(MainView.getInstance().getInputImena().getText().toLowerCase())))
                                {
                                    current.add(akcija);
                                }
                                break;
                            }
                            case "=":{
                                if ((akcijaBR == Integer.parseInt(MainView.getInstance().getBrojAkcija().getText()) && akcija.getIme().toLowerCase().contains(MainView.getInstance().getInputImena().getText().toLowerCase()) || akcija.getPrezime().toLowerCase().contains(MainView.getInstance().getInputImena().getText().toLowerCase())))
                                {
                                    current.add(akcija);
                                }
                                break;
                            }
                        }
                    }
                    checked.add(akcija);
                    contains = false;
                    akcijaBR = 0;
                }
            }
            else
            {
                for (Akcija akcija : Database.getInstance().getPohadjaci())
                {
                    if (akcija.getIme().toLowerCase().contains(MainView.getInstance().getInputImena().getText().toLowerCase()) || akcija.getPrezime().toLowerCase().contains(MainView.getInstance().getInputImena().getText().toLowerCase()))
                    {
                        current.add(akcija);
                    }
                }
            }

            MainView.getInstance().getLista().getItems().clear();
            MainView.getInstance().getLista().getItems().addAll(current);
            MainView.getInstance().getLista().refresh();
        }
    }
}
