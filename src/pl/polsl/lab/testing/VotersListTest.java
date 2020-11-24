package pl.polsl.lab.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.polsl.lab.model.Voter;
import pl.polsl.lab.model.VotersList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Voters list test.
 */
class VotersListTest {
    /**
     * The V list.
     */
    VotersList vList;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
    vList = new VotersList();
    }

    /**
     * Test voters with same id.
     */
    @Test
    void testVotersWithSameID() {
        Integer number = 100;
        for(int i = 0; i<number; i++){
            vList.addVoter(new Voter("Voter"+i, ""));
        }

        for(int i = 0; i<number; i++){
            for(int j = i+1; j<number; j++){
                if(vList.getVoters().get(i).getID() == vList.getVoters().get(j).getID()){
                    fail("There should not be voters with same ID, " +
                            vList.getVoters().get(i).getName() + ": " + vList.getVoters().get(i).getID() + " " +
                            vList.getVoters().get(j).getName() + ": " + vList.getVoters().get(j).getID());
                }
            }
        }
    }

    /**
     * Test adding null voters.
     */
    @Test
    void testAddingNullVoters(){
        try{
            vList.addVoter(null);
            fail("Adding null voter should throw an exception");
        }catch(Exception e){

        }
    }
}