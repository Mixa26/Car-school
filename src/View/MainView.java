package View;

import Controller.ObracunController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import Module.Pohadjac;
import Module.TipAkcije;

public class MainView extends VBox {
    private static MainView instance;

    static
    {
        instance = new MainView();
    }

    private MainView()
    {
        initElements();
        setElementProperties();
        initListeners();
    }

    public static MainView getInstance()
    {
        return instance;
    }

    public Scene makeScene()
    {
        return new Scene(this, 900, 600);
    }

    //up
    private HBox gore;
    private VBox levo;
    private Label polaznici;
    private ListView<String> lista;

    private VBox desno;
    private Label filterPolaznika;
    private HBox prvi;
    private Label deoImena;
    private TextField inputImena;
    private Label ubaciSamo;
    private HBox vBoxovi;
    private VBox jedan;
    private ComboBox<String> veceManjeJednako;
    private Button resetuj;
    private Button obracun;
    private VBox dva;
    private TextField brojAkcija;
    private Button filtriraj;
    private VBox tri;
    private ComboBox<TipAkcije> tipAkcije;
    private Button pregled;

    //down
    private VBox dole;
    private Label Akcije;
    private TableView<Pohadjac> tabela;

    private void initElements()
    {
        gore = new HBox();
        levo = new VBox();
        polaznici = new Label("Polaznici");
        lista = new ListView<>();

        //add
        levo.getChildren().addAll(polaznici, lista);

        desno = new VBox();
        filterPolaznika = new Label("Filter polaznika");
        prvi = new HBox();
        deoImena = new Label("Deo imena:");
        inputImena = new TextField();
        ubaciSamo = new Label("Ubaci samo one koje imaju:");
        vBoxovi = new HBox();
        jedan = new VBox();
        veceManjeJednako = new ComboBox<>();
        resetuj = new Button("Resetuj");
        obracun = new Button("Obracun");
        dva = new VBox();
        brojAkcija = new TextField();
        filtriraj = new Button("Filtriraj");
        tri = new VBox();
        tipAkcije = new ComboBox<>();
        pregled = new Button("Pregled");

        veceManjeJednako.getItems().add(">");
        veceManjeJednako.getItems().add("<");
        veceManjeJednako.getItems().add("=");
        veceManjeJednako.getSelectionModel().selectFirst();

        for (TipAkcije tipAkcije1 : TipAkcije.values())
            tipAkcije.getItems().add(tipAkcije1);
        tipAkcije.getSelectionModel().selectFirst();

        //add
        vBoxovi.getChildren().addAll(jedan, dva, tri);
        jedan.getChildren().addAll(veceManjeJednako, resetuj, obracun);
        dva.getChildren().addAll(brojAkcija, filtriraj);
        tri.getChildren().addAll(tipAkcije, pregled);
        prvi.getChildren().addAll(deoImena, inputImena);
        desno.getChildren().addAll(filterPolaznika, prvi, ubaciSamo, vBoxovi);

        dole = new VBox();
        Akcije = new Label("Akcije");
        tabela = new TableView<>();

        //add
        dole.getChildren().addAll(Akcije, tabela);
        gore.getChildren().addAll(levo, desno);

        this.getChildren().addAll(gore, dole);
    }

    private void setElementProperties()
    {
        this.setPadding(new Insets(10));

        gore.setSpacing(10);

        levo.setSpacing(10);

        desno.setSpacing(10);

        prvi.setSpacing(10);

        vBoxovi.setSpacing(10);

        jedan.setSpacing(10);

        dva.setSpacing(10);

        tri.setSpacing(10);
    }

    private void initListeners()
    {
        obracun.setOnAction(new ObracunController());
    }
}