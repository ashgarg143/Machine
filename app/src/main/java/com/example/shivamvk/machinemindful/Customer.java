package com.example.shivamvk.machinemindful;

public class Customer {
    String id,name,slug1,customercode,salemanager,status,address,pincode,country,city,state,area,latitude,longitude,email,mobile,team;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug1() {
        return slug1;
    }

    public String getCustomercode() {
        return customercode;
    }

    public String getSalemanager() {
        return salemanager;
    }

    public String getStatus() {
        return status;
    }

    public String getAddress() {
        return address;
    }

    public String getPincode() {
        return pincode;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getArea() {
        return area;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getTeam() {
        return team;
    }

    public Customer(String id, String name, String slug1, String customercode, String salemanager, String status, String address, String pincode, String country, String city, String state, String area, String latitude, String longitude, String email, String mobile, String team) {
        this.id = id;
        this.name = name;
        this.slug1 = slug1;
        this.customercode = customercode;
        this.salemanager = salemanager;
        this.status = status;
        this.address = address;
        this.pincode = pincode;
        this.country = country;
        this.city = city;
        this.state = state;
        this.area = area;
        this.latitude = latitude;
        this.longitude = longitude;
        this.email = email;
        this.mobile = mobile;
        this.team = team;
    }


}
