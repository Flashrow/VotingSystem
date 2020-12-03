package pl.polsl.lab.view;

import pl.polsl.lab.model.Voter;
import pl.polsl.lab.model.Voting;

import java.util.List;

/**
 * The type Console view.
 *
 * @author Lukasz Goleniec
 * @version 2.0
 */
public class ConsoleView {
    /**
     * Prints welcome message.
     */
    public void welcomeMessage(){
        System.out.println("Witaj w systemie zarządzania głosowaniem");
    }

    /**
     * Prints menu.
     */
    public void printMenu(){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Proszę wybrać opcję menu:");
        System.out.println("1 - pokaż listę głosowań");
        System.out.println("2 - pokaż listę głosujących");
        System.out.println("3 - dodaj głosowanie");
        System.out.println("4 - dodaj głosującego");
        System.out.println("5 - symuluj głosowanie");
        System.out.println("9 - wyjście");
    }

    /**
     * Prints voting list.
     *
     * @param votings the votings to be printed
     */
    public void printVotingList(List<Voting> votings){
        System.out.println("Lista głosowań:");
        for (Voting v : votings) {
            System.out.println();System.out.println();
            System.out.println("Głosowanie nr: " + v.getVotingID());
            System.out.println("Temat głosowania: " + v.getTopic());
            System.out.println("Data głosowania: " + v.getDate().toString());
            System.out.println("Głosy za: " + v.getVotesFor());
            System.out.println("Głosy przeciw: " + v.getVotesAgainst());
        }
    }

    /**
     * Prints voters list.
     *
     * @param voters the voters to be printed
     */
    public void printVotersList(List<Voter> voters){
        System.out.println("Lista głosujących:");
        for (Voter v: voters) {
            System.out.println(v.getName() + " " + v.getLastname());
        }
    }

    /**
     * Print add new voter message.
     */
    public void addNewVoterMessage(){
        System.out.println();
        System.out.println();
        System.out.println("Dodawanie nowego głosującego");
    }

    /**
     * Print add new voting message.
     */
    public void addNewVotingMessage(){
        System.out.println();
        System.out.println();
        System.out.println("Dodawanie nowego głosowania");
    }

    /**
     * Print simulate voting message.
     */
    public void simulateVotingMessage(){
        System.out.println();
        System.out.println();
        System.out.println("Symulacja glosowania");
    }

    /**
     * Voted out message.
     */
    public void votedOutMessage(){
        System.out.println();
        System.out.println();
        System.out.println("Głosowania, które zdobyły większość głosów za: ");
    }
}
