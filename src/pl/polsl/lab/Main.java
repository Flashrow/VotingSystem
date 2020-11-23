package pl.polsl.lab;

import pl.polsl.lab.controller.VotingSystemController;

import javax.swing.*;

/**
 * The type Main.
 * @author Lukasz Goleniec
 * @version 1.0
 */
public class Main {
    /**
     * The entry point of application.
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String pathToVoters = "";
        String pathToVotings = "";

        for(int i = 0; i < args.length; i++){
            if(args[i] == "voters"){
                try{
                    pathToVoters = args[i+1];
                    i++;
                }catch(Exception e){
                    System.out.println("Nieprawidłowy argument");
                }
            }
            if(args[i] == "votings"){
                try{
                    pathToVotings = args[i+1];
                    i++;
                }catch(Exception e){
                    System.out.println("Nieprawidłowy argument");
                }
            }
        }

        VotingSystemController systemController = new VotingSystemController(pathToVoters, pathToVotings);
        systemController.runVotingSystemApp();
    }
}
