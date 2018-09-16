package com.example.shivamvk.machinemindful;

public class LineItemOrder {
    String id,quantity,price,total,order,product;

    public LineItemOrder(String id, String quantity, String price, String total, String order, String product) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.order = order;
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }

    public String getTotal() {
        return total;
    }

    public String getOrder() {
        return order;
    }

    public String getProduct() {
        return product;
    }
}
