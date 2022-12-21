package com.raj.pickeatup;

public class AdressVishwaHelper {

    String  name, lastname, adress1, adress2, adress3, city, pincode, receiversnumber, email, latitude, longitude;

    public AdressVishwaHelper() {
    }

    public AdressVishwaHelper(String name, String lastname, String adress1, String adress2, String adress3, String city, String pincode, String receiversnumber, String email, String latitude, String longitude) {
        this.name = name;
        this.lastname = lastname;
        this.adress1 = adress1;
        this.adress2 = adress2;
        this.adress3 = adress3;
        this.city = city;
        this.pincode = pincode;
        this.receiversnumber = receiversnumber;
        this.email = email;
        this.latitude= latitude;
        this.longitude=longitude;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAdress1() {
        return adress1;
    }

    public void setAdress1(String adress1) {
        this.adress1 = adress1;
    }

    public String getAdress2() {
        return adress2;
    }

    public void setAdress2(String adress2) {
        this.adress2 = adress2;
    }

    public String getAdress3() {
        return adress3;
    }

    public void setAdress3(String adress3) {
        this.adress3 = adress3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getReceiversnumber() {
        return receiversnumber;
    }

    public void setReceiversnumber(String receiversnumber) {
        this.receiversnumber = receiversnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
