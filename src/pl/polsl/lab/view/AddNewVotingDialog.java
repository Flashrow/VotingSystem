package pl.polsl.lab.view;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import pl.polsl.lab.model.Voting;

import java.util.Date;
import java.util.Optional;

/**
 * The type Add new voting dialog.
 */
public class AddNewVotingDialog {

    /**
     * Show add voting dialog voting.
     *
     * @return new voting
     */
    public Voting showAddVotingDialog(){
        // Create the custom dialog.
        Dialog<Voting> dialog = new Dialog<>();
        dialog.setTitle("Dodawanie nowego głosowanie");
        dialog.setHeaderText("Wypełnij informacje o głosowaniu:");

        // Set the button types.
        ButtonType saveButton = new ButtonType("Zapisz", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButton, ButtonType.CANCEL);

        // Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField topic = new TextField();
        topic.setPromptText("Temat");
        TextField date = new TextField();
        date.setPromptText("dd/mm/rrrr");

        grid.add(new Label("Temat:"), 0, 0);
        grid.add(topic, 1, 0);
        grid.add(new Label("Data:"), 0, 1);
        grid.add(date, 1, 1);

        // Enable/Disable login button depending on whether a username was entered.
        Node saveBtn = dialog.getDialogPane().lookupButton(saveButton);
        saveBtn.setDisable(true);

        // Do some validation (using the Java 8 lambda syntax).
        topic.textProperty().addListener((observable, oldValue, newValue) -> {
            saveBtn.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

        // Request focus on the username field by default.
        Platform.runLater(() -> topic.requestFocus());

        // Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == saveButton) {
                if(date.getText().toString() == ""){
                    return new Voting(topic.getText().toString(), new Date());
                } else{
                    return new Voting(topic.getText().toString(), date.getText().toString());
                }
            }
            return null;
        });

        if(date.getText().toString() == ""){
            return new Voting(topic.getText().toString(), new Date());
        } else{
            return new Voting(topic.getText().toString(), date.getText().toString());
        }
    }
}
