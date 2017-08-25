package ru.kabatov.domain;

/**
 * Created by Кабатов on 24.08.2017.
 */
public class Groups {
    private int id;
    private String title;

    public Groups(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Groups() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
