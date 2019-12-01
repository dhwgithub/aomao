package com.henu.pojo;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private String uid;

    private String uname;

    private String upwd;

    private String uemail;

    private String utel;

    private String uimg;

    private String ugender;

    private Integer uscore;

    private Integer urank;

    private Integer ustate;

    private static final long serialVersionUID = 1L;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel;
    }

    public String getUimg() {
        return uimg;
    }

    public void setUimg(String uimg) {
        this.uimg = uimg;
    }

    public String getUgender() {
        return ugender;
    }

    public void setUgender(String ugender) {
        this.ugender = ugender;
    }

    public Integer getUscore() {
        return uscore;
    }

    public void setUscore(Integer uscore) {
        this.uscore = uscore;
    }

    public Integer getUrank() {
        return urank;
    }

    public void setUrank(Integer urank) {
        this.urank = urank;
    }

    public Integer getUstate() {
        return ustate;
    }

    public void setUstate(Integer ustate) {
        this.ustate = ustate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", uname=").append(uname);
        sb.append(", upwd=").append(upwd);
        sb.append(", uemail=").append(uemail);
        sb.append(", utel=").append(utel);
        sb.append(", uimg=").append(uimg);
        sb.append(", ugender=").append(ugender);
        sb.append(", uscore=").append(uscore);
        sb.append(", urank=").append(urank);
        sb.append(", ustate=").append(ustate);
        sb.append("]");
        return sb.toString();
    }
}