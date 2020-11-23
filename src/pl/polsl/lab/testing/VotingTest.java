package pl.polsl.lab.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.polsl.lab.model.Voter;
import pl.polsl.lab.model.Voting;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class VotingTest {

    Voting voting;
    @BeforeEach
    public void SetUp(){
        voting = new Voting();
    }

    @Test
    public void updateVotingWithNullValue() {
        try {
            voting.updateVoting(null);
            fail(" Exception should be thrown when updating voting with null value");
        } catch (Exception e ){
        }
    }

    @Test
    public void testingSameVoterForAndAgainst() {
        Voter testVoter = new Voter("Jan", "Kowalski");
        voting.addVoterAgainst(testVoter);
        voting.addVoterFor(testVoter);
        for (Voter voter1 : voting.getVotersAgainst())
        {
            for(Voter voter2 : voting.getVotersFor()){
                if(voter1.equals(voter2)){
                    fail("Voter can not vote for and against");
                }
            }
        }
    }

    @Test
    void setNegativeVotingID() {
     voting.setVotingID(-5);
     assertFalse(voting.getVotingID() < 0,
             "Voting ID:" + voting.getVotingID() + ", can not be negative");
    }

    @Test
    void setDate() {
        voting.setDate("test");
        Pattern p = Pattern.compile("^\\d\\d\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$");
        Matcher m = p.matcher(voting.getDate());
        if(!m.matches()){
            fail("Date field should have yyyy/mm/dd format");
        }
    }

    @Test
    void votesForBelowZero(){
        voting.setVotesFor(-5);
        assertFalse(voting.getVotesFor() < 0,
                "Votes for:" + voting.getVotesFor() + ", can not be negative");
    }

    @Test
    void votesAgainstBelowZero(){
        voting.setVotesAgainst(-5);
        assertFalse(voting.getVotesAgainst() < 0,
                "Votes against:" + voting.getVotesAgainst() + ", can not be negative");
    }
}