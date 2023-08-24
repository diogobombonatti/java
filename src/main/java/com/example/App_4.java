package com.example;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App_4 extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Carregar o ícone da imagem
        Image icon = new Image(getClass()
                .getResourceAsStream("/com/example/central-de-ajuda.png"));

        // Definir o ícone da janela
        stage.getIcons().add(icon);

        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);

        stage.setFullScreen(true); // Definir tela cheia
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App_4.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
