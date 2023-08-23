package com.example;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class PrimaryController {

    @FXML
    private TextField f1;

    @FXML
    private TextField f2;

    @FXML
    private TextArea lblResultado;

    @FXML
    private RadioButton rbCategoriaComputador;

    @FXML
    private RadioButton rbCategoriaImpressora;

    @FXML
    private RadioButton rbCategoriaRede;

    @FXML
    private RadioButton rbAtividadePrimeiroContato;

    @FXML
    private RadioButton rbAtividadeAtendido;

    @FXML
    private RadioButton rbAtividadeEncerrado;

    private List<HelpDeskTicket> tickets = new ArrayList<>();

    private ToggleGroup categoriaToggleGroup = new ToggleGroup();
    private ToggleGroup atividadeToggleGroup = new ToggleGroup();

    public void initialize() {
        rbCategoriaComputador.setToggleGroup(categoriaToggleGroup);
        rbCategoriaImpressora.setToggleGroup(categoriaToggleGroup);
        rbCategoriaRede.setToggleGroup(categoriaToggleGroup);

        rbAtividadePrimeiroContato.setToggleGroup(atividadeToggleGroup);
        rbAtividadeAtendido.setToggleGroup(atividadeToggleGroup);
        rbAtividadeEncerrado.setToggleGroup(atividadeToggleGroup);
    }

    public void confirmar() {
        String userName = f1.getText();
        String equipmentCode = f2.getText();
        String category = "";
        if (rbCategoriaComputador.isSelected()) {
            category = "Computador";
        } else if (rbCategoriaImpressora.isSelected()) {
            category = "Impressora";
        } else if (rbCategoriaRede.isSelected()) {
            category = "Rede";
        }

        String activity = "";
        if (rbAtividadePrimeiroContato.isSelected()) {
            activity = "Primeiro Contato";
        } else if (rbAtividadeAtendido.isSelected()) {
            activity = "Atendido";
        } else if (rbAtividadeEncerrado.isSelected()) {
            activity = "Encerrado";
        }

        HelpDeskTicket ticket = new HelpDeskTicket(userName, equipmentCode, category, activity);
        tickets.add(ticket);

        updateTicketsTextArea();

        // Limpar campos e desselecionar RadioButtons
        clearFieldsAndRadioButtons();
    }

    public void remover() {
        if (!tickets.isEmpty()) {
            tickets.remove(tickets.size() - 1);
            updateTicketsTextArea();
        }
    }

    public void alterar() {
        // Implement ticket modification logic here
        if (!tickets.isEmpty()) {
            HelpDeskTicket selectedTicket = tickets.get(tickets.size() - 1);
            String newCategory = "";
            String newActivity = "";

            if (rbCategoriaComputador.isSelected()) {
                newCategory = "Computador";
            } else if (rbCategoriaImpressora.isSelected()) {
                newCategory = "Impressora";
            } else if (rbCategoriaRede.isSelected()) {
                newCategory = "Rede";
            }

            if (rbAtividadePrimeiroContato.isSelected()) {
                newActivity = "Primeiro Contato";
            } else if (rbAtividadeAtendido.isSelected()) {
                newActivity = "Atendido";
            } else if (rbAtividadeEncerrado.isSelected()) {
                newActivity = "Encerrado";
            }

            selectedTicket.setCategory(newCategory);
            selectedTicket.setActivity(newActivity);

            updateTicketsTextArea();
        }
    }

    private void updateTicketsTextArea() {
        StringBuilder sb = new StringBuilder();

        for (HelpDeskTicket ticket : tickets) {
            sb.append("Usuário: ").append(ticket.getUserName())
                    .append(", Equipamento: ").append(ticket.getEquipmentCode())
                    .append(", Categoria: ").append(ticket.getCategory())
                    .append(", Atividade: ").append(ticket.getActivity())
                    .append("\n");
        }

        lblResultado.setText(sb.toString());

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Atenção");
        alert.setHeaderText(null);
        alert.setContentText("Chamado Alterado");
        alert.showAndWait();
    }

    private void clearFieldsAndRadioButtons() {
        f1.clear();
        f2.clear();

        categoriaToggleGroup.selectToggle(null);
        atividadeToggleGroup.selectToggle(null);
    }
}
