package io.jxxchallenger.springinaction.spittr.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Spitter {

    private long id;
    
    @NotEmpty
    @Size(min = 2, max = 30, message = "{firstName.size}")
    private String firstName;
    
    @NotEmpty
    @Size(min = 2, max = 30, message = "{lastName.size}")
    private String lastName;
    
    @NotEmpty
    @Size(min = 5, max = 16, message = "{username.size}")
    private String username;
    
    @NotEmpty
    @Size(min = 5, max = 25, message = "{password.size}")
    private String password;
    
    @Email
    private String email;

    public Spitter() {
        super();
    }

    public Spitter(String firstName, String lastName, String username,
            String password, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Spitter(long id, String firstName, String lastName, String username,
            String password, String email) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
