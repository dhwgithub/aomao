package com.henu.pojo;

import java.io.Serializable;

public class Tcollection implements Serializable {
    private Integer cogood;

    private String couser;

    private static final long serialVersionUID = 1L;

    public Integer getCogood() {
        return cogood;
    }

    public void setCogood(Integer cogood) {
        this.cogood = cogood;
    }

    public String getCouser() {
        return couser;
    }

    public void setCouser(String couser) {
        this.couser = couser;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cogood=").append(cogood);
        sb.append(", couser=").append(couser);
        sb.append("]");
        return sb.toString();
    }
}