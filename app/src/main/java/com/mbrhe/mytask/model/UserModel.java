package com.mbrhe.mytask.model;

import android.text.TextUtils;
import android.util.Patterns;

import java.io.Serializable;


public class UserModel implements Serializable {

    private String eid;
    private String name;
    private String idbarahno;
    private String email;
    private String unifiednumber;
    private String mobileno;

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdbarahno() {
        return idbarahno;
    }

    public void setIdbarahno(String idbarah) {
        this.idbarahno = idbarah;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUnifiednumber() {
        return unifiednumber;
    }

    public void setUnifiednumber(String unifiednumber) {
        this.unifiednumber = unifiednumber;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }


    public boolean isValidEid() {
        if (this.eid != null && !TextUtils.isEmpty(eid) && this.eid.length() >= 6) {
            return true;
        }
        return false;
    }


    public boolean isValidName() {
        if (this.name != null && !TextUtils.isEmpty(name)) {
            return true;
        }
        return false;
    }

    public boolean isValidIdbarahno() {
        if (this.idbarahno != null && !TextUtils.isEmpty(idbarahno) && this.idbarahno.length() >= 7) {
            return true;
        }
        return false;
    }

    public boolean isValidEmail() {
        if (this.email != null && !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return true;
        }
        return false;
    }

    public boolean isValidUnifiedNo() {
        if (this.unifiednumber != null && this.unifiednumber.length() >= 3) {
            return true;
        }
        return false;
    }

    public boolean isValidMobile() {
        if (this.mobileno != null && this.mobileno.length() >= 12) {
            return true;
        }
        return false;
    }

    public String getWelcomeMessage() {
        return "Welcome\n" + this.getEmail();
    }
}