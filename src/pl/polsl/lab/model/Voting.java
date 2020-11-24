package pl.polsl.lab.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Voting.
 *   @author Lukasz Goleniec
 *   @version 1.0
 */
public class Voting {
    private int votingID;
    private String topic;
    private String date;
    private int votesFor;
    private int votesAgainst;
    private List<Voter> votersFor;
    private List<Voter> votersAgainst;
    private VotingPermission votingPermission;

    /**
     * Instantiates a new Voting. Creates new ArrayLists for voters for and against
     */
    public Voting(){
        votersFor = new ArrayList<>();
        votersAgainst = new ArrayList<>();
        votingPermission = VotingPermission.MEDIUM;
    };

    /**
     * Instantiates a new Voting.
     *
     * @param topic Voting topic
     * @param date  Voting date
     */
    public Voting(String topic, String date) {
        this.topic = topic;
        this.date = date;
        votersFor = new ArrayList<>();
        votersAgainst = new ArrayList<>();
        votingPermission = VotingPermission.MEDIUM;
    }

    /**
     * Gets voters for.
     *
     * @return Voters which has voted for
     */
    public List<Voter> getVotersFor() {
        return votersFor;
    }

    /**
     * Sets voters for.
     *
     * @param votersFor List of voters voting for
     */
    public void setVotersFor(List<Voter> votersFor) {
        this.votersFor = votersFor;
    }

    /**
     * Gets voters against.
     *
     * @return the voters that has voted against
     */
    public List<Voter> getVotersAgainst() {
        return votersAgainst;
    }

    /**
     * Sets voters against.
     *
     * @param votersAgainst List of voters voting against
     */
    public void setVotersAgainst(List<Voter> votersAgainst) {
        this.votersAgainst = votersAgainst;
    }

    /**
     * Gets voting id.
     *
     * @return the voting id
     */
    public int getVotingID() {
        return votingID;
    }

    /**
     * Sets voting id.
     *
     * @param votingID the voting id
     */
    public void setVotingID(int votingID) {
        this.votingID = votingID;
    }

    /**
     * Gets date.
     *
     * @return the voting date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the voting date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets votes for.
     *
     * @return List of voters that had voted for
     */
    public int getVotesFor() {
        return votesFor;
    }

    /**
     * Sets votes for.
     *
     * @param votesFor List of voters that had voted for
     */
    public void setVotesFor(int votesFor) {
        this.votesFor = votesFor;
    }

    /**
     * Gets votes against.
     *
     * @return Number of votes against
     */
    public int getVotesAgainst() {
        return votesAgainst;
    }

    /**
     * Sets votes against.
     *
     * @param votesAgainst the votes against
     */
    public void setVotesAgainst(int votesAgainst) {
        this.votesAgainst = votesAgainst;
    }

    /**
     * Gets topic.
     *
     * @return the topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Sets topic.
     *
     * @param topic the topic
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * Updates voting by cloning parameters from another voting
     *
     * @param newVoting Voting from which fields will be copied
     */
    public void updateVoting(Voting newVoting){
        this.setTopic(newVoting.getTopic());
        this.setDate(newVoting.getDate());
        this.setVotersAgainst(newVoting.getVotersAgainst());
        this.setVotersFor(newVoting.getVotersFor());
        this.setVotersFor(newVoting.getVotersFor());
        this.setVotersAgainst(newVoting.getVotersAgainst());
    }

    /**
     *  Adds one to voters for counter
     */
    private void bumpVotersFor(){
        this.votesFor++;
    }

    /**
     *  Adds one to voters against counter
     */
    private void bumpVotesAgainst(){
        this.votesAgainst++;
    }

    /**
     * Adds voter for to votersFor list
     *
     * @param voterFor the voter whom voted for
     */
    public void addVoterFor(Voter voterFor){
        this.votersFor.add(voterFor);
        this.bumpVotersFor();
    }

    /**
     * Adds voter against to votersAgainst list
     *
     * @param voterAgainst the voter whom voted against
     */
    public void addVoterAgainst(Voter voterAgainst){
        this.votersAgainst.add(voterAgainst);
        this.bumpVotesAgainst();
    }
}