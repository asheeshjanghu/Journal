package com.memory.Journal.model;
// Memory model using MongoDB

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class MemoryModelNoSql {

    @Id
    String id;

    String title;

    String dayMemory;

    @Indexed
    Date memoryDate;

    Date updatedAt = new Date();

    Date createdAt = new Date();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDayMemory() {
        return dayMemory;
    }

    public void setDayMemory(String dayMemory) {
        this.dayMemory = dayMemory;
    }

    public Date getMemoryDate() {
        return memoryDate;
    }

    public void setMemoryDate(Date memoryDate) {
        this.memoryDate = memoryDate;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = new Date();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
