package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("f24-10");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("f24-10"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        team.setName("f24-10");
        team.addMember("Ajay");
        team.addMember("Aneesh");
        team.addMember("Derrick");
        team.addMember("Peter");
        team.addMember("Rajvir");
        team.addMember("Justin");
        assertEquals("Team(name=f24-10, members=[Ajay, Aneesh, Derrick, Peter, Rajvir, Justin])", team.toString());
    }

    @Test
    public void equals_returns_true_for_same_team() {
        // Same object (pointers two both objects are same)
        assertEquals(team.equals(team), true);

        // Other object isn't instance of this class
        assertEquals(team.equals(1), false);

        // Compare fields
        // TRUE TRUE case
        Team other = new Team("f24-10");
        Team twin = new Team("f24-10");
        assertEquals(true, twin.equals(other));

        // FALSE TRUE
        Team other2 = new Team("f24-10");
        other2.addMember("teehee");
        assertEquals(team.equals(other2), false);

        // TRUE FALSE
        Team other3 = new Team("wrong name");
        other3.addMember("Ajay");
        other3.addMember("Aneesh");
        other3.addMember("Derrick");
        other3.addMember("Peter");
        other3.addMember("Rajvir");
        other3.addMember("Justin");
        assertEquals(team.equals(other3), false);
    }

    @Test
    public void hashCode_check_hashCode_value() {
        assertEquals(team.hashCode(), -1327023899);
    }
}
