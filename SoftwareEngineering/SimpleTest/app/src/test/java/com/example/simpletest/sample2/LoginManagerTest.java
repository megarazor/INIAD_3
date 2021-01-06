package com.example.simpletest.sample2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginManagerTest {
    private LoginManager loginManager;

    @Before
    public void setUp() throws ValidateFailedException{
        loginManager= new LoginManager();
        loginManager.register("testuser1", "password");
    }

    @Test
    public void testLogin1() throws LoginFailedException{
        User user= loginManager.login("testuser1", "password");
    }

    @Test (expected = LoginFailedException.class)
    public void testLogin2() throws LoginFailedException{
        User user= loginManager.login("testuser1", "wrong password");
    }

    @Test (expected = LoginFailedException.class)
    public void testLogin3() throws LoginFailedException{
        User user= loginManager.login("non-existent user", "password");
    }

    //Optional assignment
    @Test (expected = ValidateFailedException.class)
    public void testRegisterInvalidUsername1() throws ValidateFailedException{
        loginManager.register("テストユーザ", "password");
    }

    @Test (expected = ValidateFailedException.class)
    public void testRegisterInvalidUsername2() throws ValidateFailedException{
        loginManager.register("abc", "password");
    }

    @Test (expected = ValidateFailedException.class)
    public void testRegisterInvalidPassword1() throws ValidateFailedException{
        loginManager.register("testuser2", "password!!");
    }

    @Test (expected = ValidateFailedException.class)
    public void testRegisterInvalidPassword2() throws ValidateFailedException{
        loginManager.register("testuser2", "1234");
    }

    @Test (expected = ValidateFailedException.class)
    public void testRegisterWithExistingUser() throws ValidateFailedException{
        loginManager.register("testuser1", "password");
    }
}