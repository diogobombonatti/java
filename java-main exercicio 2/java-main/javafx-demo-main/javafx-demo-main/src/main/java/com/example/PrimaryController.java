package com.example;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML TextField txtChute;  
    @FXML Label lblResultado;  

    public void aleatorio(){
        Random random = new Random();

        int numeroSort = (random.nextInt(10));
        int chute = Integer.parseInt(txtChute.getText());
        lblResultado.setText(String.valueOf(numeroSort));
        
        if(chute ==numeroSort){
            lblResultado.setText(String.valueOf("Parabens"));

        } else {
            lblResultado.setText(String.valueOf("Errou "+ (numeroSort)));

        }

    }


    }

