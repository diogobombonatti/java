package com.example;

import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {
    // ... (other @FXML fields)
    @FXML
    private TextField f1;

    @FXML
    private TextField f2;

    @FXML
    private TextArea lblResultado;

    private List<HelpDeskTicket> tickets = new ArrayList<>();

    // ... (other methods)

    public void confirmar() {
        String userName = f1.getText();
        String equipmentCode = f2.getText();
        String category = ""; // Get selected category from radio buttons
        String activity = ""; // Get selected activity from radio buttons

        HelpDeskTicket ticket = new HelpDeskTicket(userName, equipmentCode, category, activity);
        tickets.add(ticket);

        // Update the tickets in the TextArea
        updateTicketsTextArea();
    }

    public void remover() {
        if (!tickets.isEmpty()) {
            tickets.remove(tickets.size() - 1);
            updateTicketsTextArea();
        }
    }

    public void alterar() {
        // Implement ticket modification logic here
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

        lblResultado.setText("Adicionado");

    }
}
