package pl.polsl.lab.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import pl.polsl.lab.exceptions.VotingsListException;
import pl.polsl.lab.model.Voter;
import pl.polsl.lab.model.VotersList;
import pl.polsl.lab.model.Voting;
import pl.polsl.lab.model.VotingsList;
import pl.polsl.lab.view.AddNewVotingDialog;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

/**
 * Main screen view controller
 *
 * @author Lukasz Goleniec
 * @version 2.0
 */
public class MainScreenController {

    /**
     * The Stage.
     */
    public Stage stage;
    /**
     * The Add voting btn.
     */
    public Button addVotingBtn;
    /**
     * The Simulate btn.
     */
    public Button simulateBtn;
    /**
     * The Votings table view.
     */
    public TableView<Voting> votingsTableView;
    /**
     * The Votings table topic.
     */
    public TableColumn <Voting, String> votingsTableTopic;
    /**
     * The Votings table date.
     */
    public TableColumn <Voting, Date> votingsTableDate;
    /**
     * The Votings table for.
     */
    public TableColumn <Voting, Integer> votingsTableFor;
    /**
     * The Votings table against.
     */
    public TableColumn <Voting, Integer> votingsTableAgainst;
    /**
     * The Delete voting btn.
     */
    public Button deleteVotingBtn;
    /**
     * The Show details btn.
     */
    public Button showDetailsBtn;
    /**
     * The Voters number label.
     */
    public Label votersNumberLabel;

    private ObservableList<Voting> votingsObservableList;
    private VotingsList votingsList;
    private VotersList votersList;

    /**
     * Main method to show screen
     */
    public void runView(){
        votingsList.addVoting(new Voting("temat1", new Date()));
        votingsList.addVoting(new Voting("temat2", new Date()));
        votersList.addVoter(new Voter("Jan", "Kowalski"));
        votersList.addVoter(new Voter("Marian", "Nowak"));
        votersList.addVoter(new Voter("Janusz", "Jan"));

        votersNumberLabel.setText(Integer.toString(votersList.getVoters().size()));

        showTable();
    }

    /**
     *  Updated observable list with voting list
     */
    private void updateObservableList(){
        if(votingsObservableList!= null && votingsObservableList.size()>0)
        votingsObservableList.removeAll(votingsObservableList);

        this.votingsObservableList = FXCollections.observableArrayList(votingsList.getVotings());
    }

    /**
     *  Prepares voting table view
     */
    private void prepareTable(){
        updateObservableList();
        votingsTableTopic.setCellValueFactory(new PropertyValueFactory<>("topic"));
        votingsTableDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        votingsTableFor.setCellValueFactory(new PropertyValueFactory<>("votesFor"));
        votingsTableAgainst.setCellValueFactory(new PropertyValueFactory<>("votesAgainst"));
    }

    /**
     *  Shows table view
     */
    private void showTable(){
        prepareTable();
        votingsTableView.getItems().clear();
        for (var voting : votingsObservableList){
            votingsTableView.getItems().add(voting);
        }
    }

    /**
     * Deletes voting from votings list.
     */
    public void deleteVoting(){
        System.out.println("List size: " + votingsList.getVotings().size());

        int selectedIndex = votingsTableView.getSelectionModel().getSelectedIndex();
        votingsList.deleteVoting(votingsList.getVotings().get(selectedIndex));

        showTable();
        System.out.println("List size: " + votingsList.getVotings().size());
    }

    /**
     * Adds voting to voting list.
     *
     * @param event the click event
     */
    public void addVoting(ActionEvent event){
        AddNewVotingDialog dialog = new AddNewVotingDialog();
        votingsList.addVoting(dialog.showAddVotingDialog());
        showTable();
    }

    /**
     * Simulate voting.
     *
     * @param actionEvent the action event
     */
    public void simulateVoting(ActionEvent actionEvent) {
        Voting voting = null;
        int index = votingsTableView.getSelectionModel().getSelectedIndex();

        try {
            voting = votingsList.findVotingByID(votingsObservableList.get(index).getVotingID());
        } catch (VotingsListException e) {
            e.printStackTrace();
        }

        Random generator = new Random();
        for (Voter voter : votersList.getVoters()) {
            if(generator.nextBoolean()){
                voting.addVoterFor(voter);
            }else{
                voting.addVoterAgainst(voter);
            }
        }

        showTable();
    }

    /**
     * Gets votings list.
     *
     * @return the votings list
     */
    public VotingsList getVotingsList() {
        return votingsList;
    }

    /**
     * Sets votings list.
     *
     * @param votingsList the votings list
     */
    public void setVotingsList(VotingsList votingsList) {
        this.votingsList = votingsList;
    }

    /**
     * Gets voters list.
     *
     * @return the voters list
     */
    public VotersList getVotersList() {
        return votersList;
    }

    /**
     * Sets voters list.
     *
     * @param votersList the voters list
     */
    public void setVotersList(VotersList votersList) {
        this.votersList = votersList;
    }



}
