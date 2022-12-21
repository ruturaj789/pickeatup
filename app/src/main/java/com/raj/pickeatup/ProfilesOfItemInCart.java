package com.raj.pickeatup;

public class ProfilesOfItemInCart {


    private String title;
    private String type;
    private String peuprice;
    private String saving;
    private String quantity;

    public ProfilesOfItemInCart() {
    }

    public ProfilesOfItemInCart(String title, String type, String peuprice, String saving, String quantity) {
        this.title = title;
        this.type = type;
        this.peuprice = peuprice;
        this.saving = saving;
        this.quantity = quantity;
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
}
