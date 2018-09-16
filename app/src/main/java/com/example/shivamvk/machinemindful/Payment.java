package com.example.shivamvk.machinemindful;

public class Payment {
    String customer,date,status,total;

    public Payment(String customer, String date, String status, String total) {
        this.customer = customer;
        this.date = date;
        this.status = status;
        this.total = total;
    }

    public String getCustomer() {
        return customer;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getTotal() {
        return total;
    }
}
