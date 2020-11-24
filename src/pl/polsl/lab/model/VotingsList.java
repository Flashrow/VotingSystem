package pl.polsl.lab.model;

import pl.polsl.lab.exceptions.VotingsListException;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Votings list.
 *
 * @author Lukasz Goleniec
 * @version 1.1
 */
public class VotingsList {
    private List<Voting> votings;

    /**
     * Instantiates a new Votings list without parameters, creates new ArrayList of type Voting
     */
    public VotingsList(){
        votings = new ArrayList<Voting>();
    };

    /**
     * Instantiates a new Votings list.
     *
     * @param list Initial voting list
     */
    public VotingsList(List<Voting> list){
        this.votings = list;
    }

    /**
     * Gets votings list
     *
     * @return Votings list
     */
    public List<Voting> getVotings() {
        return votings;
    }

    /**
     * Sets votings list.
     *
     * @param votings Votings list
     */
    public void setVotings(List<Voting> votings) {
        this.votings = votings;
    }

    /**
     * Adds voting and sets its ID to current votings list size
     *
     * @param voting the voting
     */
    public void addVoting(Voting voting){
        voting.setVotingID(this.votings.size()+1);
        votings.add(voting);
    }

    /**
     * Find voting by voting id.
     *
     * @param votingID the voting id
     * @return the voting
     * @throws VotingsListException the votings list exception
     */
    public Voting findVotingByID(int votingID) throws VotingsListException {
        if(votingID < 0){
            throw new VotingsListException("Can not search with negative ID");
        }
        if(votingID-1 > votings.size()){
            return new Voting();
        }else{
            return votings.get(votingID-1);
        }
    }

    /**
     * Clones voting
     * @param votingID from which will be new voting cloned
     * @return New cloned Voting object
     */
    private Voting cloneVoting(int votingID){
        Voting voting = new Voting();
        voting.updateVoting(votings.get(votingID-1));
        return voting;
    }

    /**
     * Finds given voting in votings list by voting ID, then updates other fields
     *
     * @param updatedVoting the updated voting
     * @return boolean value telling if updating process succeeded
     */
    public boolean updateVoting(Voting updatedVoting){
        if(updatedVoting.getVotingID()-1 <= votings.size()){
            Voting votingToEdit = votings.get(updatedVoting.getVotingID());
            votingToEdit.updateVoting(updatedVoting);
            return true;
        }else{
            return false;
        }
    }
}
