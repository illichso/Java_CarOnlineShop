package com.sergii.caronlineshop;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "users")
public class Users {
    private List<User> users;
    public Users() {
    }
    @XmlElement(name="user")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public void printUsers(){
        for(User us: users){
            System.out.println("Login: " + us.getLogin()+"; password: "+us.getPassword());
        }
    }
}
