package pl.polsl.lab.testing;

import org.junit.jupiter.api.Test;
import pl.polsl.lab.exceptions.VotingsListException;
import pl.polsl.lab.model.Voting;
import pl.polsl.lab.model.VotingsList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Votings list test.
 *
 * @author Lukasz Goleniec
 * @version 1.1
 */
class VotingsListTest {

    private VotingsList vList;

    /**
     * Initializes test vList with empty new VotingList
     */
    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        vList = new VotingsList();
    }

    /**
     * Test finding voting with negative id.
     */
    @org.junit.jupiter.api.Test
    public void testFindingWithNegativeID() {
        try{
            vList.findVotingByID(-5);
            fail("Exception should be thrown when searching with ID below zero");
        } catch (VotingsListException e) {
        }
    }

    /**
     * Test finding voting with bad id.
     */
    @org.junit.jupiter.api.Test
    public void testFindingWithBadID() {
        try{
            vList.findVotingByID(0);
            fail("Searching with non existing ID should be handled");
        } catch (Exception e){
        }
    }

    /**
     * Update voting with null.
     */
    @org.junit.jupiter.api.Test
    public void updateVotingWithNull() {
        try{
            vList.updateVoting(null);
            fail("Updating with null value should throw an exception");
        }catch (Exception e){
        }
    }

    /**
     * Add voting id test. Tests if IDs are set properly
     */
    @Test
    void addVotingIDTest() {
    VotingsList testList = new VotingsList();
    for(int i = 0; i<10; i++){
        testList.addVoting(new Voting("Voting: " + 1 , "12.12.12"));
    }
    assertEquals(testList.getVotings().get(testList.getVotings().size()-1).getVotingID(), 10, 0,
            "For 10 created votings last should have ID equal to 10");
    }
}