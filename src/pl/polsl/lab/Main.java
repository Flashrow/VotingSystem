package pl.polsl.lab;

import pl.polsl.lab.controller.MainScreenController;
import pl.polsl.lab.controller.VotingSystemController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.polsl.lab.model.VotersList;
import pl.polsl.lab.model.VotingsList;

import java.io.IOException;


/**
 * The type Main.
 *
 * @author Lukasz Goleniec
 * @version 2.0
 */
public class Main extends Application{
    private MainScreenController mainScreenController;
    private VotingSystemController systemController;
    private VotingsList votingsList;
    private VotersList votersList;
    private String pathToVoters ="";
    private String pathToVotings ="";

    /**
     * The entry point of application.
     *
     * @param args the input arguments, available arguments for user are:             -voters path_to_textfile             -votings path_to_textfile             (example: -voters C:\Docs\test.txt)             order of arguments does not matter
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        String pathToVoters = "";
        String pathToVotings = "";

        for(int i = 0; i < args.length; i++){
            if(args[i].equals("-voters")){
                try{
                    pathToVoters = args[i+1];
                    i++;
                }catch(Exception e){
                    System.out.println("Nieprawidłowy argument");
                }
            }
            if(args[i].equals("-votings")){
                try{
                    pathToVotings = args[i+1];
                    i++;
                }catch(Exception e){
                    System.out.println("Nieprawidłowy argument");
                }
            }
        }

        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainScreen.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("System Głosowania");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();

        votingsList = new VotingsList();
        votersList = new VotersList();

        mainScreenController = (MainScreenController) loader.getController();
        mainScreenController.setVotersList(votersList);
        mainScreenController.setVotingsList(votingsList);

        mainScreenController.runView();

        systemController = new VotingSystemController(pathToVoters, pathToVotings, votingsList, votersList);
        //systemController.runVotingSystemApp();
    }
}
