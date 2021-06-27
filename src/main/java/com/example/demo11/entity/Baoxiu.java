package com.example.demo11.entity;

import javax.persistence.*;

@Table(name = "baoxiu")
@Entity
public class Baoxiu {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id = -1;

    String name = "";
    String content = "";
    String location = "";
    String feedback = "";
    Integer userId = -1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
