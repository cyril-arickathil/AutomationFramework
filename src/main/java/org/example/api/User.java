package org.example.api;

public class User
{
    private int id;
    private String name;
    private String job;
    private String email;
    private String password;
    public User() {}
//used for POST request -creating user
    public User(int id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }
//used for login user
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
