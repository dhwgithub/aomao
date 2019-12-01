package com.henu.pojo;

import java.io.Serializable;

public class Item implements Serializable {
    private String iid;

    private Integer inum;

    private Double iprice;

    private Integer italk;

    private Integer igood;

    private String iorder;

    private static final long serialVersionUID = 1L;

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public Integer getInum() {
        return inum;
    }

    public void setInum(Integer inum) {
        this.inum = inum;
    }

    public Double getIprice() {
        return iprice;
    }

    public void setIprice(Double iprice) {
        this.iprice = iprice;
    }

    public Integer getItalk() {
        return italk;
    }

    public void setItalk(Integer italk) {
        this.italk = italk;
    }

    public Integer getIgood() {
        return igood;
    }

    public void setIgood(Integer igood) {
        this.igood = igood;
    }

    public String getIorder() {
        return iorder;
    }

    public void setIorder(String iorder) {
        this.iorder = iorder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", iid=").append(iid);
        sb.append(", inum=").append(inum);
        sb.append(", iprice=").append(iprice);
        sb.append(", italk=").append(italk);
        sb.append(", igood=").append(igood);
        sb.append(", iorder=").append(iorder);
        sb.append("]");
        return sb.toString();
    }
}