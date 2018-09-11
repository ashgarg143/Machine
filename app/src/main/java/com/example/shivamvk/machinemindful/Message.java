package com.example.shivamvk.machinemindful;

public class Message {

    private String id, slug, timestamp, message, user;


    public Message(String id, String slug, String timestamp, String message, String user) {
        this.id = id;
        this.slug = slug;
        this.timestamp = timestamp;
        this.message = message;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getUser() {
        return user;
    }

}