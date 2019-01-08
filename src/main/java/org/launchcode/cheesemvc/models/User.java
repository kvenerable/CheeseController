package org.launchcode.cheesemvc.models;

import org.hibernate.validator.constraints.Email;

import javax.print.DocFlavor;
import javax.validation.constraints.Size;

public class User {

    @Size(min=5, max=15)
    private String username;
    @Email
    private String email;
    @Size(min=6,message ="Please enter valid password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {

    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
