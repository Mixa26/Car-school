package Main;

import javafx.application.Application;
import javafx.stage.Stage;

import View.MainView;

public class Main extends Application {
    public static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Auto skola");
        stage.setScene(MainView.getInstance().makeScene());
        stage.show();
    }
}
