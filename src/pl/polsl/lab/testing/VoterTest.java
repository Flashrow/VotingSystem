package pl.polsl.lab.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.polsl.lab.model.Voter;
import pl.polsl.lab.model.VotersList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Voter test.
 *
 * @author Lukasz Goleniec
 * @version 1.1
 */
class VoterTest {
    /**
     * The test voter.
     */
    Voter voter;

    /**
     * Sets up, initializes test voter with empty voter object before each test
     */
    @BeforeEach
    void setUp() {
        voter = new Voter();
    }


    /**
     * Test setting empty voter name.
     */
    @Test
    void setEmptyName() {
        voter.setName("");
        assertNotEquals(voter.getName(), "" , "Voter can not have empty name");
    }

    /**
     * Test setting empty voter lastname.
     */
    @Test
    void setEmptyLastname() {
        voter.setLastname("");
        assertNotEquals(voter.getLastname(), "" , "Voter can not have empty lastname");
    }
}