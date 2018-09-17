package com.example.shivamvk.machinemindful;

public class Logs {
    String id,message,customer,date;

    public Logs(String id, String message, String customer, String date) {
        this.id = id;
        this.message = message;
        this.customer = customer;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getCustomer() {
        return customer;
    }

    public String getDate() {
        return date;
    }
}
