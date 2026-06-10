package com.shrii.journalApp.Entity;


import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "journal_entries")
public class JournalEntry {
    @Id
    private String id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String username;

    public String getContent() {return content;}
    public void setContent(String content) {
        this.content = content;
    }


    public String getTitle() {return title;}
    public void setTitle(String title) {
        this.title = title;
    }


    public String getId() {return id;}
    public void setId(String id) {
        this.id = id;
    }


    public LocalDateTime getCreatedAt() {return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }

    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}
}
