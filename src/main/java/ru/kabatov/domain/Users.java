package ru.kabatov.domain;

/**
 * Created by Кабатов on 24.08.2017.
 */
public class Users implements Organization{
    private int id;
    private String username;
    private Groups group;
    private Positions position;

    public Users() {
    }

    public Users(int id, String username, Groups group, Positions position) {
        this.id = id;
        this.username = username;
        this.group = group;
        this.position = position;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }
}
