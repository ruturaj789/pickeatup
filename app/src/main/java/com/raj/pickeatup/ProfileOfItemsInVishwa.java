package com.raj.pickeatup;

public class ProfileOfItemsInVishwa {

    private String title;
    private String type;
    private String mrp;
    private String peuprice;
    private String saving;
    private String profilePic;

    public ProfileOfItemsInVishwa() {
    }

    public ProfileOfItemsInVishwa(String title, String type, String mrp, String peuprice, String saving, String profilePic) {
        this.title = title;
        this.type = type;
        this.mrp = mrp;
        this.peuprice = peuprice;
        this.saving = saving;
        this.profilePic= profilePic;
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


    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }
}
