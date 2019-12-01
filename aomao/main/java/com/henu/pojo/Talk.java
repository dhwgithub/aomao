package com.henu.pojo;

import java.io.Serializable;
import java.util.Date;

public class Talk implements Serializable {
    private Integer tid;

    private String tcomm;

    private Date ttime;

    private Integer tgood;

    private String tuser;

    private static final long serialVersionUID = 1L;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTcomm() {
        return tcomm;
    }

    public void setTcomm(String tcomm) {
        this.tcomm = tcomm;
    }

    public Date getTtime() {
        return ttime;
    }

    public void setTtime(Date ttime) {
        this.ttime = ttime;
    }

    public Integer getTgood() {
        return tgood;
    }

    public void setTgood(Integer tgood) {
        this.tgood = tgood;
    }

    public String getTuser() {
        return tuser;
    }

    public void setTuser(String tuser) {
        this.tuser = tuser;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tid=").append(tid);
        sb.append(", tcomm=").append(tcomm);
        sb.append(", ttime=").append(ttime);
        sb.append(", tgood=").append(tgood);
        sb.append(", tuser=").append(tuser);
        sb.append("]");
        return sb.toString();
    }
}