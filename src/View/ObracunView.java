package View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ObracunView extends HBox {
    private static ObracunView instance;

    static
    {
        instance = new ObracunView();
    }

    private ObracunView()
    {
        initElements();
        setElementProperties();
    }

    public static ObracunView getIsntance()
    {
        return instance;
    }

    public Scene makeScene()
    {
        return new Scene(this, 300, 100);
    }

    private VBox prvi;
    private Label uplaceniIznos;
    private Label intIznos;
    private VBox drugi;
    private Label dugCasove;
    private Label intCasove;
    private Label pretplacenih;
    private Label intPretplacenih;

    public void initElements()
    {
        prvi = new VBox();
        uplaceniIznos = new Label("Ukupan uplaceni iznos:");
        intIznos = new Label();
        drugi = new VBox();
        dugCasove = new Label("Ukupan dug za casove");
        intCasove = new Label();
        pretplacenih = new Label("Broj pretplacenih polaznika");
        intPretplacenih = new Label();

        //add
        prvi.getChildren().addAll(uplaceniIznos, dugCasove, pretplacenih);
        drugi.getChildren().addAll(intIznos, intCasove, intPretplacenih);

        this.getChildren().addAll(prvi, drugi);
    }

    public void setElementProperties()
    {
        this.setPadding(new Insets(10));
        prvi.setSpacing(10);
        drugi.setSpacing(10);
    }
}
