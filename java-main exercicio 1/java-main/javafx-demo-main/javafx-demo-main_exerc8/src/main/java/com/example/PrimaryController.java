package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class PrimaryController {
    @FXML
    TextField f1;
    @FXML
    TextField f2;
    @FXML
    TextField f3;
    @FXML
    TextField f4;
    @FXML
    TextArea meusFavoritos;
    @FXML
    TextArea lblResultado;

    private List<String> favoritos = new ArrayList<>(); // Declaração da lista de favoritos

    public void favoritar1() {
        favoritos.add("Agente Stone"); // Adicionar favorito à lista
        listaFavoritos();
    }

    public void favoritar2() {
        favoritos.add("Barbie");
        listaFavoritos();

    }


    public void favoritar3() {
        favoritos.add("Homem Aranha");
        listaFavoritos();
    }

    public void favoritar4() {
        favoritos.add("Oppenheimer");
        listaFavoritos();
    }

    public void listaFavoritos() {
        StringBuilder sb = new StringBuilder();

        for (String favorito : favoritos) {
            sb.append(favorito).append("\n"); // Adiciona cada favorito seguido de uma quebra de linha
        }

        meusFavoritos.setText(sb.toString()); // Atualiza o texto do TextArea com a lista de favoritos
        lblResultado.setText("Favoritos atualizados!"); // Atualiza o texto do Label lblResultado
    }
}
