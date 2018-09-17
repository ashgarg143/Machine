package com.example.shivamvk.machinemindful;

import java.util.ArrayList;

public class Order {

    private String id, customerName,date,remark,total;
    private ArrayList<LineItemOrder> lineItemOrderList;

    public Order(String id, String customerName, String date, String remark, String total, ArrayList<LineItemOrder> lineItemOrderList) {
        this.id = id;
        this.customerName = customerName;
        this.date = date;
        this.remark = remark;
        this.total = total;
        this.lineItemOrderList = lineItemOrderList;
    }

   /* public Order(String customerName, String date, String remark, String total, ArrayList<LineItemOrder> lineItemOrderList) {
        this.customerName = customerName;
        this.date = date;
        this.remark = remark;
        this.total = total;
        this.lineItemOrderList = lineItemOrderList;
    }*/

    public String getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
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
