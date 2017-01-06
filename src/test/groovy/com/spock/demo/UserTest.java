package com.spock.demo;

import org.junit.Test;

import static org.junit.Assert.*;


public class UserTest {

    @Test
    public void testGetDisplayNameForAdultMale() throws Exception {
        User user = new User();
        user.firstName = "First";
        user.lastName = "Last";
        user.gender = "Male";
        user.age = 20;

        String displayName = user.getDisplayName();
        assert (displayName.equals("Mr First Last1"));
    }

    public void testGetDisplayNameForAdultFemales() throws Exception {
        User user = new User();
        user.firstName = "First";
        user.lastName = "Last";
        user.gender = "Male";
        user.age = 20;

        String displayName = user.getDisplayName();
        assert (displayName.equals("Miss First Last"));
    }

    public void testGetDisplayNameForKidMale() throws Exception {
        User user = new User();
        user.firstName = "First";
        user.lastName = "Last";
        user.gender = "Male";
        user.age = 5;

        String displayName = user.getDisplayName();
        assert (displayName.equals("Master First Last"));
    }

    public void testGetDisplayNameForKidFemale() throws Exception {
        User user = new User();
        user.firstName = "First";
        user.lastName = "Last";
        user.gender = "Male";
        user.age = 5;

        String displayName = user.getDisplayName();
        assert (displayName.equals("Master First Last"));
    }
}