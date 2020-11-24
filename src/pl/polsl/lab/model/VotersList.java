package pl.polsl.lab.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Voters list.
 *
 * @author Lukasz Goleniec
 * @version 1.1
 */
public class VotersList {
    /**
     * The voters list
     */
    List<Voter> voters;

    /**
     * Instantiates a new Voters list without parameters. Creates new empty ArrayList of type Voter
     */
    public VotersList(){
        voters = new ArrayList<Voter>();
    };

    /**
     * Instantiates a new Voters list with voters list parameter.
     *
     * @param voters Initial voters list
     */
    public VotersList(List<Voter> voters) {
        this.voters = voters;
    }

    /**
     * Gets voters.
     *
     * @return the voters
     */
    public List<Voter> getVoters() {
        return voters;
    }

    /**
     * Sets voters.
     *
     * @param voters new voters list to set
     */
    public void setVoters(List<Voter> voters) {
        this.voters = voters;
    }

    /**
     * Adds new voter to the list.
     *
     * @param voter the voter to be added
     */
    public void addVoter(Voter voter){
        this.voters.add(voter);
    }
}
