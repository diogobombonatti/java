package com.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
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

    @FXML
    private ListView<HelpDeskTicket> chamadosListView;

    private ObservableList<HelpDeskTicket> tickets = FXCollections.observableArrayList();

    private ToggleGroup categoriaToggleGroup = new ToggleGroup();
    private ToggleGroup atividadeToggleGroup = new ToggleGroup();

    public void initialize() {
        rbCategoriaComputador.setToggleGroup(categoriaToggleGroup);
        rbCategoriaImpressora.setToggleGroup(categoriaToggleGroup);
        rbCategoriaRede.setToggleGroup(categoriaToggleGroup);

        rbAtividadePrimeiroContato.setToggleGroup(atividadeToggleGroup);
        rbAtividadeAtendido.setToggleGroup(atividadeToggleGroup);
        rbAtividadeEncerrado.setToggleGroup(atividadeToggleGroup);

        chamadosListView.setItems(tickets);
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
        HelpDeskTicket selectedTicket = chamadosListView.getSelectionModel().getSelectedItem();
        if (selectedTicket != null) {
            tickets.remove(selectedTicket);
            updateTicketsTextArea();
        }
    }

    public void selecionar() {
        HelpDeskTicket selectedTicket = chamadosListView.getSelectionModel().getSelectedItem();
        if (selectedTicket != null) {
            f1.setText(selectedTicket.getUserName());
            f2.setText(selectedTicket.getEquipmentCode());

            switch (selectedTicket.getCategory()) {
                case "Computador":
                    rbCategoriaComputador.setSelected(true);
                    break;
                case "Impressora":
                    rbCategoriaImpressora.setSelected(true);
                    break;
                case "Rede":
                    rbCategoriaRede.setSelected(true);
                    break;
            }

            switch (selectedTicket.getActivity()) {
                case "Primeiro Contato":
                    rbAtividadePrimeiroContato.setSelected(true);
                    break;
                case "Atendido":
                    rbAtividadeAtendido.setSelected(true);
                    break;
                case "Encerrado":
                    rbAtividadeEncerrado.setSelected(true);
                    break;
            }
        }
    }

    private void refreshListView() {
        chamadosListView.getItems().clear();
        chamadosListView.getItems().addAll(tickets);
    }

    public void alterar() {
        if (!tickets.isEmpty()) {
            int selectedIndex = chamadosListView.getSelectionModel().getSelectedIndex();

            if (selectedIndex >= 0) {
                HelpDeskTicket selectedTicket = tickets.get(selectedIndex);

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

                // Atualiza as informações do chamado selecionado
                selectedTicket.setUserName(f1.getText());
                selectedTicket.setEquipmentCode(f2.getText());
                selectedTicket.setCategory(newCategory);
                selectedTicket.setActivity(newActivity);

                // Atualiza a exibição do chamado na ListView
                chamadosListView.getItems().set(selectedIndex, selectedTicket);

                // Limpa os campos e desmarca os RadioButtons
                clearFieldsAndRadioButtons();
            }
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

    }

    private void clearFieldsAndRadioButtons() {
        f1.clear();
        f2.clear();

        categoriaToggleGroup.selectToggle(null);
        atividadeToggleGroup.selectToggle(null);
    }
}
