package View;

import Controller.FiltrirajController;
import Controller.ObracunController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import Module.Database;
import Module.Akcija;
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
        addElementsToScreen();
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
    private ListView<Akcija> lista;

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
    private TableView<Akcija> tabela;

    private TableColumn<Akcija, String> tcDatum;
    private TableColumn<Akcija, String> tcIme;
    private TableColumn<Akcija, String> tcPrezime;
    private TableColumn<Akcija, String> tcAkcija;
    private TableColumn<Akcija, Double> tcIznos;

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
        brojAkcija.setPromptText("Unesite broj akcija");
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

        tcDatum = new TableColumn<>("Datum");
        tcDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));
        tcIme = new TableColumn<>("Ime");
        tcIme.setCellValueFactory(new PropertyValueFactory<>("ime"));
        tcPrezime = new TableColumn<>("Prezime");
        tcPrezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        tcAkcija = new TableColumn<>("Akcija");
        tcAkcija.setCellValueFactory(new PropertyValueFactory<>("tipAkcije"));
        tcIznos = new TableColumn<>("Iznos");
        tcIznos.setCellValueFactory(new PropertyValueFactory<>("cena"));

        //add
        tabela.getColumns().addAll(tcDatum, tcIme, tcPrezime, tcAkcija, tcIznos);
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
        filtriraj.setOnAction(new FiltrirajController());
        obracun.setOnAction(new ObracunController());
    }

    private void addElementsToScreen()
    {
        lista.getItems().addAll(Database.getInstance().getPohadjaci());
        tabela.getItems().addAll(Database.getInstance().getAkcije());
    }

    public ListView<Akcija> getLista() {
        return lista;
    }

    public TextField getInputImena() {
        return inputImena;
    }

    public ComboBox<String> getVeceManjeJednako() {
        return veceManjeJednako;
    }

    public TextField getBrojAkcija() {
        return brojAkcija;
    }
}
