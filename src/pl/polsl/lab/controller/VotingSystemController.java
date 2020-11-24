package pl.polsl.lab.controller;

import pl.polsl.lab.exceptions.MenuInputException;
import pl.polsl.lab.exceptions.VotingsListException;
import pl.polsl.lab.model.Voter;
import pl.polsl.lab.model.VotersList;
import pl.polsl.lab.model.Voting;
import pl.polsl.lab.model.VotingsList;
import pl.polsl.lab.view.ConsoleView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * The type Voting system controller. Managing all the system
 *
 * @author Lukasz Goleniec
 * @version 1.1
 */
public class VotingSystemController {
    private VotingsList votingsList;
    private ConsoleView consoleView;
    private VotersList votersList;
    private Boolean exit = false;
    private String path_to_voters ="";
    private String path_to_votings ="";


    /**
     * Instantiates a new Voting system controller.
     */
    public VotingSystemController(){};

    /**
     * Instantiates a new Voting system controller.
     *
     * @param path_to_voters  the path to voters textfile
     * @param path_to_votings the path to votings textfile
     */
    public VotingSystemController(String path_to_voters, String path_to_votings){
        if(!path_to_voters.equals("")){
            this.path_to_voters = path_to_voters;
        }
        if(!path_to_votings.equals("")){
            this.path_to_votings = path_to_votings;
        }
        if(!this.path_to_votings.equals("") && !this.path_to_voters.equals("")){
            initFromFiles();
        }
    }

    /**
     * Initializes voting and voters lists with passed textfiles if exists, parsing is safe.
     */
    private void initFromFiles(){
        List<String> votingsRecords = new ArrayList<String>();
        List<String> votersRecords = new ArrayList<String>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path_to_votings));
            String line;
            while((line = reader.readLine())!=null){
                votingsRecords.add(line);
            }
            reader.close();
        }catch(Exception e){
            System.out.println("Nie udało się odczytać pliku z głosowaniami");
        }

        try{
            BufferedReader reader = new BufferedReader(new FileReader(path_to_voters));
            String line;
            while((line = reader.readLine())!=null){
                votersRecords.add(line);
            }
            reader.close();
        }catch(Exception e){
            System.out.println("Nie udało się odczytać pliku z głosującymi");
        }

        if(votingsRecords.size()>1){
            for(int i = 0; i<votingsRecords.size(); i+=2){
                votingsList.addVoting(new Voting(votingsRecords.get(i),votingsRecords.get(i+1)));
            }
        }

        if(votersRecords.size()>1){
            for(int i = 0; i<votersRecords.size(); i+=2){
                votersList.addVoter(new Voter(votersRecords.get(i), votersRecords.get(i+1)));
            }
        }
    }

    /**
     * Run voting system app. Contains main while loop.
     */
    public void runVotingSystemApp(){
        consoleView = new ConsoleView();
        votingsList = new VotingsList();
        votersList = new VotersList();

        consoleView.welcomeMessage();
        while(!exit){
            consoleView.printMenu();

            int menuOption = 0;
            while(menuOption == 0){
                try {
                    menuOption = getMenuOption();
                } catch (MenuInputException e) {
                    e.printStackTrace();
                }
            }

            switch(menuOption){
                case 1: showVotings(); break;
                case 2: showVoters(); break;
                case 3: addNewVoting(); break;
                case 4: addNewVoter(); break;
                case 5: simulateVoting(); break;
                case 9: exit = true;
                default:;
            }
        }
    }

    /**
     *
     * @return Returns integer value representing menu option chosen by user
     * @throws MenuInputException
     */

    private int getMenuOption() throws MenuInputException {
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
            if(!((option<6 && option > 0)||option==9)){
                throw new MenuInputException("Nieprawidłowy numer opcji");
        }
            return option;
    }

    /**
     *  Simulates voting process on chosen voting with random number generator, adds voters to suitable list
     */
    private void simulateVoting() {
        int votingID;
        Voting voting = null;
        consoleView.simulateVotingMessage();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer(ID) głosowania: ");
        votingID = scanner.nextInt();

        try {
            voting = votingsList.findVotingByID(votingID);
        } catch (VotingsListException e) {
            e.printStackTrace();
        }

        Random generator = new Random();
        for (Voter voter : votersList.getVoters()) {
            if(generator.nextBoolean()){
                System.out.println(voter.getName() + " " + voter.getLastname() + " glosuje za");
                voting.addVoterFor(voter);
            }else{
                System.out.println(voter.getName() + " " + voter.getLastname() + " glosuje przeciw");
                voting.addVoterAgainst(voter);
            }
        }
    }

    /**
     *  Adds new voting to VotingList, user sets voting title and date
     */
    private void addNewVoting() {
        String topic;
        String date;
        consoleView.addNewVotingMessage();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Temat głosowania: ");
        topic = scanner.nextLine();
        System.out.println("Data głosowania: ");
        date = scanner.nextLine();
        Voting newVoting = new Voting(topic, date);
        System.out.println("Dodawane głosowanie: \"" + newVoting.getTopic() + "\"\ndata głosowania: " + newVoting.getDate());
        votingsList.addVoting(newVoting);
    }

    /**
     *  Adds new voter to VotersList, user sets voters name and last name
     */
    private void addNewVoter() {
        String name;
        String lastName;
        consoleView.addNewVoterMessage();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Imię głosującego: ");
        name = scanner.nextLine();
        System.out.println("Nazwisko głosującego: ");
        lastName = scanner.nextLine();
        Voter newVoter = new Voter(name, lastName);
        System.out.println("Dodawany(a): " + newVoter.getName() + " " + newVoter.getLastname());
        if(!(name.isEmpty() || lastName.isEmpty()))
        votersList.addVoter(newVoter);
    }

    /**
     *  Calls view class to show all voters
     */
    private void showVoters() {
        consoleView.printVotersList(votersList.getVoters());
    }

    /**
     *  Calls view class to show all votings
     */
    private void showVotings(){
        consoleView.printVotingList(votingsList.getVotings());
    }

}
