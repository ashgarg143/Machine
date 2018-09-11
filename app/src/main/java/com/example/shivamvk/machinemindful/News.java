package com.example.shivamvk.machinemindful;

class News {

    private String id,date,slug,title,body,expiry_date;

    News(String id, String date, String slug, String title, String body, String expiry_date) {
        this.id = id;
        this.date = date;
        this.slug = slug;
        this.title = title;
        this.body = body;
        this.expiry_date = expiry_date;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getSlug() {
        return slug;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getExpiry_date() {
        return expiry_date;
    }
}
