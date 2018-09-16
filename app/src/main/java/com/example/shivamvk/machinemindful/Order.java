package com.example.shivamvk.machinemindful;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String customer,date,remark,total;
    private ArrayList<LineItemOrder> lineItemOrderList;

    public Order(String customer, String date, String remark, String total, ArrayList<LineItemOrder> lineItemOrderList) {
        this.customer = customer;
        this.date = date;
        this.remark = remark;
        this.total = total;
        this.lineItemOrderList = lineItemOrderList;
    }

    public String getCustomer() {
        return customer;
    }

    public String getDate() {
        return date;
    }

    public String getRemark() {
        return remark;
    }

    public String getTotal() {
        return total;
    }

    public ArrayList<LineItemOrder> getLineItemOrderList() {
        return lineItemOrderList;
    }
}
