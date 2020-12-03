package pl.polsl.lab.model;

/**
 * The type Voting system.
 *
 * @author Lukasz Goleniec
 * @version 2.0
 */
public class VotingSystem {
    private VotingsList votingsList;
    private VotersList votersList;

    /**
     * Instantiates a new Voting system.
     */
    public VotingSystem(){
        votingsList = new VotingsList();
        votersList = new VotersList();
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
