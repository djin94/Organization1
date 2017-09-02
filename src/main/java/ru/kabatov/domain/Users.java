package ru.kabatov.domain;

/**
 * Created by Кабатов on 24.08.2017.
 */
public class Users implements Organization{
    private int id;
    private String username;
    private int groupId;
    private int positionId;

    public Users() {
    }

    public Users(int id, String username, int groupId, int positionId) {
        this.id = id;
        this.username = username;
        this.groupId = groupId;
        this.positionId = positionId;
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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }
}
