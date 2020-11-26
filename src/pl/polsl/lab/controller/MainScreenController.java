package pl.polsl.lab.controller;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.polsl.lab.model.Voting;
import pl.polsl.lab.model.VotingsList;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    public TableView votingsTab;
    public TableColumn votingTopicCol;
    public TableColumn votingDateCol;
    public TableColumn votesForCol;
    public TableColumn votesAgainstCol;
    public Button addVotingBtn;
    public ListView<String> votingsListView;
    private VotingsList votingsList;

    /*public MainScreenController(String pathToVoters, String pathToVotings){
        pathToVoters = "";
        pathToVotings ="";
        VotingSystemController systemController = new VotingSystemController(pathToVoters, pathToVotings);
        systemController.runVotingSystemApp();
    }*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initData(VotingsList votingsList){
        this.votingsList = votingsList;
    }

    public void simulateVoting(ActionEvent actionEvent) {

    }
}
