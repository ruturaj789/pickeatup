package com.raj.pickeatup;

import java.text.SimpleDateFormat;

public class CartListVishwaAdapterHelper {

    String totalpeu,totalsaving,phoneno,currentDate,currentTime;

    public CartListVishwaAdapterHelper(String totalpeu, String totalsaving, String phoneno, SimpleDateFormat currentDate, SimpleDateFormat currentTime) {
    }


    public CartListVishwaAdapterHelper(String totalpeu, String totalsaving, String phoneno, String currentDate, String currentTime) {
        this.totalpeu = totalpeu;
        this.totalsaving = totalsaving;
        this.phoneno = phoneno;
        this.currentDate = currentDate;
        this.currentTime = currentTime;
    }

    public String getTotalpeu() {
        return totalpeu;
    }

    public void setTotalpeu(String totalpeu) {
        this.totalpeu = totalpeu;
    }

    public String getTotalsaving() {
        return totalsaving;
    }

    public void setTotalsaving(String totalsaving) {
        this.totalsaving = totalsaving;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
}
