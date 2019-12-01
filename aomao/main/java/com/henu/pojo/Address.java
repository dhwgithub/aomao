package com.henu.pojo;

import java.io.Serializable;

public class Address implements Serializable {
    private Integer addid;

    private String address1;

    private String address2;

    private String addrtel;

    private String addrtel2;

    private String addrget;

    private String addrcard;

    private String addruser;

    private static final long serialVersionUID = 1L;

    public Integer getAddid() {
        return addid;
    }

    public void setAddid(Integer addid) {
        this.addid = addid;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddrtel() {
        return addrtel;
    }

    public void setAddrtel(String addrtel) {
        this.addrtel = addrtel;
    }

    public String getAddrtel2() {
        return addrtel2;
    }

    public void setAddrtel2(String addrtel2) {
        this.addrtel2 = addrtel2;
    }

    public String getAddrget() {
        return addrget;
    }

    public void setAddrget(String addrget) {
        this.addrget = addrget;
    }

    public String getAddrcard() {
        return addrcard;
    }

    public void setAddrcard(String addrcard) {
        this.addrcard = addrcard;
    }

    public String getAddruser() {
        return addruser;
    }

    public void setAddruser(String addruser) {
        this.addruser = addruser;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", addid=").append(addid);
        sb.append(", address1=").append(address1);
        sb.append(", address2=").append(address2);
        sb.append(", addrtel=").append(addrtel);
        sb.append(", addrtel2=").append(addrtel2);
        sb.append(", addrget=").append(addrget);
        sb.append(", addrcard=").append(addrcard);
        sb.append(", addruser=").append(addruser);
        sb.append("]");
        return sb.toString();
    }
}