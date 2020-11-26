package pl.polsl.lab.model;

public class SystemModel {
    private VotingsList votings;
    private VotersList voters;

    public VotingsList getVotings() {
        return votings;
    }

    public void setVotings(VotingsList votings) {
        this.votings = votings;
    }

    public VotersList getVoters() {
        return voters;
    }

    public void setVoters(VotersList voters) {
        this.voters = voters;
    }
}
