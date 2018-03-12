package com.task.tracker.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "task")
public class Task implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nameTask")
    private String nameTask;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @ManyToOne( fetch = FetchType.EAGER)
    Project project;

    @ManyToOne(fetch = FetchType.EAGER)
    User user;

    @OneToMany(mappedBy = "task", fetch = FetchType.EAGER)
    Set<Comment> comments;


    public Task() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", nameTask='" + nameTask + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", project=" + project +
                ", user=" + user +
                ", comments=" + comments +
                '}';
    }
}
