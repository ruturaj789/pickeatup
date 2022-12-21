package com.raj.pickeatup;

public class CartHelper {

    String title,type, mrp, peuprice,saving,quantity,systemphoneno;

    public CartHelper() {
    }

    public CartHelper(String title, String type, String mrp, String peuprice, String saving, String quantity, String systemphoneno) {
        this.title = title;
        this.type = type;
        this.mrp = mrp;
        this.peuprice = peuprice;
        this.saving = saving;
        this.quantity = quantity;
        this.systemphoneno = systemphoneno;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getPeuprice() {
        return peuprice;
    }

    public void setPeuprice(String peuprice) {
        this.peuprice = peuprice;
    }

    public String getSaving() {
        return saving;
    }

    public void setSaving(String saving) {
        this.saving = saving;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSystemphoneno() {
        return systemphoneno;
    }

    public void setSystemphoneno(String systemphoneno) {
        this.systemphoneno = systemphoneno;
    }
}
