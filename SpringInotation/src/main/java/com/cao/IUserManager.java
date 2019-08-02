package com.cao;

public interface IUserManager {
    public void addUser(String username, String password);

    public void modifyUser(int id, String username, String password);
}
