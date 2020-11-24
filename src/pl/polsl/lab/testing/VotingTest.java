package pl.polsl.lab.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.polsl.lab.model.Voter;
import pl.polsl.lab.model.Voting;
import pl.polsl.lab.model.VotingPermission;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Voting test.
 * @author Lukasz Goleniec
 * @version 1.1
 */
class VotingTest {

    /**
     * The test Voting.
     */
    Voting voting;

    /**
     * Set up, initialize voting with empty voting object for each test
     */
    @BeforeEach
    public void SetUp(){
        voting = new Voting();
    }

    /**
     * Update voting with null value.
     */
    @Test
    public void updateVotingWithNullValue() {
        try {
            voting.updateVoting(null);
            fail(" Exception should be thrown when updating voting with null value");
        } catch (Exception e ){
        }
    }

    /**
     * Testing if same voter can vote for and against.
     */
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

    /**
     * Test setting negative voting id.
     */
    @Test
    void setNegativeVotingID() {
     voting.setVotingID(-5);
     assertFalse(voting.getVotingID() < 0,
             "Voting ID:" + voting.getVotingID() + ", can not be negative");
    }

    /**
     * Test setting date
     */
    @Test
    void setDate() {
        String input = "test";
        try {
            voting.setDate("test");
            Pattern p = Pattern.compile("^\\d\\d\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$");
            Matcher m = p.matcher(input);
            if(!m.matches()){
                fail("Date field should have dd/mm/yyyy format otherwise it should throw an exception");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /**
     * Tests if votes for can be negative
     */
    @Test
    void votesForBelowZero(){
        voting.setVotesFor(-5);
        assertFalse(voting.getVotesFor() < 0,
                "Votes for:" + voting.getVotesFor() + ", can not be negative");
    }

    /**
     * Tests if votes against can be negative
     */
    @Test
    void votesAgainstBelowZero(){
        voting.setVotesAgainst(-5);
        assertFalse(voting.getVotesAgainst() < 0,
                "Votes against:" + voting.getVotesAgainst() + ", can not be negative");
    }

    /**
     * Tests if it's possible for voter to vote without proper permission
     */
    @Test
    void votingWithTooLowPermission(){
        Voter testVoter = new Voter("Jan", "Kowalski");
        testVoter.setVotingPermission(VotingPermission.LOW);
        voting.addVoterFor(testVoter);
        if(voting.getVotersFor().get(0).getID().equals(testVoter.getID())){
            fail("Voter with low voting permission should not be able to vote in voting with medium voting permission");
        }
    }
}