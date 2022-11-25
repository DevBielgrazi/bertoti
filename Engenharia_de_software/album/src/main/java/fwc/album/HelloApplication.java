package fwc.album;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage stage;
    private static Scene login;
    private static Scene cadastro;
    private static Scene home;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        primaryStage.setTitle("+Emprego");

        Parent layout_login = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        login = new Scene(layout_login);

        primaryStage.setScene(login);
        primaryStage.show();
        primaryStage.setFullScreen(true);
    }

    public static void ChangeScene(String tela) throws IOException {
        switch (tela) {
            case "login":
                Parent layout_login = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
                login = new Scene(layout_login);
                stage.setScene(login);
                stage.setFullScreen(true);
                break;
            case "cadastro":
                Parent layout_cadastro = FXMLLoader.load(HelloApplication.class.getResource("hello-view2.fxml"));
                cadastro = new Scene(layout_cadastro);
                stage.setScene(cadastro);
                stage.setFullScreen(true);
                break;
            case "home":
                Parent layout_home = FXMLLoader.load(HelloApplication.class.getResource("hello-view3.fxml"));
                home = new Scene(layout_home);
                stage.setScene(home);
                stage.setFullScreen(true);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
