package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Aneesh", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_github_Id() {
        assertEquals("gargAneesh", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team team = Developer.getTeam();
        assertEquals("f24-10", team.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team team = Developer.getTeam();
        assertEquals(6, team.getMembers().size());
        assertTrue(team.getMembers().contains("Ajay"));
        assertTrue(team.getMembers().contains("Aneesh"));
        assertTrue(team.getMembers().contains("Derrick"));
        assertTrue(team.getMembers().contains("Peter"));
        assertTrue(team.getMembers().contains("Rajvir"));
        assertTrue(team.getMembers().contains("Justin"));
    }
}
