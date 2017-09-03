package ru.kabatov.storage;

import org.junit.Ignore;
import org.junit.Test;
import ru.kabatov.domain.Users;


import java.util.ArrayList;

import static org.junit.Assert.*;


public class UsersStorageTest {
    @Test
    @Ignore
    public void getTest(){
        UsersStorage usersStorage = new UsersStorage();
        ArrayList<Users> users = new ArrayList<>(usersStorage.values());
        for (Users user:users)
            System.out.println(user.getId() + " "+user.getUsername()+" "+user.getGroup().getTitle()+" "+user.getPosition().getTitle());
    }

}
