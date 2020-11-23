package pl.polsl.lab.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.polsl.lab.model.Voter;
import pl.polsl.lab.model.VotersList;

import static org.junit.jupiter.api.Assertions.*;

class VoterTest {
    Voter voter;

    @BeforeEach
    void setUp() {
        voter = new Voter();
    }


    @Test
    void setEmptyName() {
        voter.setName("");
        assertNotEquals(voter.getName(), "" , "Voter can not have empty name");
    }

    @Test
    void setEmptyLastname() {
        fail("Not yet implemented");
    }
}