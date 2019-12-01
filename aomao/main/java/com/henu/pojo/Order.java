package com.henu.pojo;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private String oid;

    private Double oprice;

    private Integer ostate;

    private Date otime;

    private Integer oaddr;

    private String ouser;

    private static final long serialVersionUID = 1L;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Double getOprice() {
        return oprice;
    }

    public void setOprice(Double oprice) {
        this.oprice = oprice;
    }

    public Integer getOstate() {
        return ostate;
    }

    public void setOstate(Integer ostate) {
        this.ostate = ostate;
    }

    public Date getOtime() {
        return otime;
    }

    public void setOtime(Date otime) {
        this.otime = otime;
    }

    public Integer getOaddr() {
        return oaddr;
    }

    public void setOaddr(Integer oaddr) {
        this.oaddr = oaddr;
    }

    public String getOuser() {
        return ouser;
    }

    public void setOuser(String ouser) {
        this.ouser = ouser;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oid=").append(oid);
        sb.append(", oprice=").append(oprice);
        sb.append(", ostate=").append(ostate);
        sb.append(", otime=").append(otime);
        sb.append(", oaddr=").append(oaddr);
        sb.append(", ouser=").append(ouser);
        sb.append("]");
        return sb.toString();
    }
}