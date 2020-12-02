package pl.polsl.lab.model;

public class VotingSystem {
    private VotingsList votingsList;
    private VotersList votersList;

    public VotingSystem(){
        votingsList = new VotingsList();
        votersList = new VotersList();
    }

    public VotingsList getVotingsList() {
        return votingsList;
    }

    public void setVotingsList(VotingsList votingsList) {
        this.votingsList = votingsList;
    }

    public VotersList getVotersList() {
        return votersList;
    }

    public void setVotersList(VotersList votersList) {
        this.votersList = votersList;
    }
}
