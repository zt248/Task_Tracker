package com.task.tracker.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "textComment")
    private String textComment;

    @ManyToOne(fetch = FetchType.EAGER)
    User user;

    @ManyToOne(fetch = FetchType.EAGER)
    Task task;

    public Comment() {
    }

    public Comment(String textComment, User user, Task task) {
        this.textComment = textComment;
        this.user = user;
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", textComment='" + textComment + '\'' +
                ", user=" + user +
                ", task=" + task +
                '}';
    }
}
