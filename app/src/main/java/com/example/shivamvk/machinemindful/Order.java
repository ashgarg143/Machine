package com.example.shivamvk.machinemindful;

public class Order {

    private String id,date,remark,quantity,price,discount,tax,total,product,customer,salesmen;

    public Order(String id, String date, String remark, String quantity, String price
            , String discount, String tax, String total, String product
            , String customer, String salesmen) {
        this.id = id;
        this.date = date;
        this.remark = remark;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.tax = tax;
        this.total = total;
        this.product = product;
        this.customer = customer;
        this.salesmen = salesmen;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getRemark() {
        return remark;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }

    public String getDiscount() {
        return discount;
    }

    public String getTax() {
        return tax;
    }

    public String getTotal() {
        return total;
    }

    public String getProduct() {
        return product;
    }

    public String getCustomer() {
        return customer;
    }

    public String getSalesmen() {
        return salesmen;
    }
}
