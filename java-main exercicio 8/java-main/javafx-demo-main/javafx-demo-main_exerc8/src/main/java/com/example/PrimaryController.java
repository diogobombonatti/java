package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimaryController {
    @FXML TextField n1;
    @FXML TextField n2;
    @FXML TextField n3;  
    @FXML Label lblResultado;  

    public void calcular(){
        int numero1 = Integer.parseInt(n1.getText());
        int numero2 = Integer.parseInt(n2.getText());
        int numero3 = Integer.parseInt(n3.getText());
        
        List<Integer> numeros = new ArrayList<>();
        numeros.add(numero1);
        numeros.add(numero2);
        numeros.add(numero3);

        Collections.sort(numeros);

        StringBuilder resultado = new StringBuilder("Números em ordem crescente: ");
        for (int numero : numeros) {
            resultado.append(numero).append(" ");
        }

        lblResultado.setText(resultado.toString());
    }
}
