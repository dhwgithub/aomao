package com.henu.pojo;

import java.io.Serializable;

public class Admin implements Serializable {
    private Integer admid;

    private String admuser;

    private String admpwd;

    private String admname;

    private static final long serialVersionUID = 1L;

    public Integer getAdmid() {
        return admid;
    }

    public void setAdmid(Integer admid) {
        this.admid = admid;
    }

    public String getAdmuser() {
        return admuser;
    }

    public void setAdmuser(String admuser) {
        this.admuser = admuser;
    }

    public String getAdmpwd() {
        return admpwd;
    }

    public void setAdmpwd(String admpwd) {
        this.admpwd = admpwd;
    }

    public String getAdmname() {
        return admname;
    }

    public void setAdmname(String admname) {
        this.admname = admname;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", admid=").append(admid);
        sb.append(", admuser=").append(admuser);
        sb.append(", admpwd=").append(admpwd);
        sb.append(", admname=").append(admname);
        sb.append("]");
        return sb.toString();
    }
}