package pl.polsl.lab.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.polsl.lab.model.Voter;
import pl.polsl.lab.model.VotersList;

import static org.junit.jupiter.api.Assertions.*;

class VotersListTest {
    VotersList vList;

    @BeforeEach
    void setUp() {
    vList = new VotersList();
    }

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

    @Test
    void testSettingEmptyVoters(){
        fail("Not yet implemented");
    }
}