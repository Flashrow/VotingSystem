package pl.polsl.lab;

import pl.polsl.lab.controller.VotingSystemController;

import javax.swing.*;

/**
 * The type Main.
 *
 * @author Lukasz Goleniec
 * @version 1.1
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments, available arguments for user are:
     *             -voters path_to_textfile
     *             -votings path_to_textfile
     *             (example: -voters C:\Docs\test.txt)
     *             order of arguments does not matter
     */
    public static void main(String[] args) {
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
                    System.out.println("Dodaje głosowanie z pliku: " + args[i+1]);

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
