package pl.polsl.lab.model;

/**
 * Class representing voter, has name and lastname
 *
 * @author Lukasz Goleniec
 * @version 1.1
 */
public class Voter {
    private static Integer IDcounter = 0;
    private String name;
    private String lastname;
    private VotingPermission votingPermission;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getID() {
        return ID;
    }

    private Integer ID;

    /**
     * Instantiates a new Voter without parameters
     */
    public Voter(){
        votingPermission = VotingPermission.MEDIUM;
        this.ID = this.hashCode();
    };

    /**
     * Instantiates a new Voter.
     *
     * @param name     the name
     * @param lastname the lastname
     */
    public Voter(String name, String lastname) {
        this.ID = this.hashCode();
        this.name = name;
        this.lastname = lastname;
        votingPermission = VotingPermission.MEDIUM;
    }

    /**
     * Gets voters name.
     *
     * @return the voter name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets voters name.
     *
     * @param name new voters name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets voters lastname.
     *
     * @return the voters lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets voters lastname.
     *
     * @param lastname new lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets voting permission.
     *
     * @return the voting permission
     */
    public VotingPermission getVotingPermission() {
        return votingPermission;
    }

    /**
     * Sets voting permission.
     *
     * @param votingPermission the voting permission
     */
    public void setVotingPermission(VotingPermission votingPermission) {
        this.votingPermission = votingPermission;
    }
}
