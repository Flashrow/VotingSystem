package pl.polsl.lab.testing;

import org.junit.jupiter.api.Test;
import pl.polsl.lab.exceptions.VotingsListException;
import pl.polsl.lab.model.Voting;
import pl.polsl.lab.model.VotingsList;

import static org.junit.jupiter.api.Assertions.*;

class VotingsListTest {

    private VotingsList vList;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        vList = new VotingsList();
    }

    @org.junit.jupiter.api.Test
    public void testFindingWithNegativeID() {
        try{
            vList.findVotingByID(-5);
            fail("Exception should be thrown when searching with ID below zero");
        } catch (VotingsListException e) {
        }
    }

    @org.junit.jupiter.api.Test
    public void testFindingWithBadID() {
        try{
            vList.findVotingByID(0);
            fail("Searching with non existing ID should be handled");
        } catch (Exception e){
        }
    }

    @org.junit.jupiter.api.Test
    public void updateVotingWithNull() {
        try{
            vList.updateVoting(null);
            fail("Updating with null value should throw an exception");
        }catch (Exception e){
        }
    }

    @Test
    public void updateVotingWithBadFields(){
        fail("not yet implemented");
    }

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