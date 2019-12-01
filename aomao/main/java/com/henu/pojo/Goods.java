package com.henu.pojo;

import java.io.Serializable;

public class Goods implements Serializable {
    private Integer gid;

    private String gname;

    private String gclass;

    private Double gprice;

    private String gtext;

    private Integer gsum;

    private Integer gnum;

    private Double gprice2;

    private Double gwei;

    private Double gduty;

    private String gpic;

    private static final long serialVersionUID = 1L;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGclass() {
        return gclass;
    }

    public void setGclass(String gclass) {
        this.gclass = gclass;
    }

    public Double getGprice() {
        return gprice;
    }

    public void setGprice(Double gprice) {
        this.gprice = gprice;
    }

    public String getGtext() {
        return gtext;
    }

    public void setGtext(String gtext) {
        this.gtext = gtext;
    }

    public Integer getGsum() {
        return gsum;
    }

    public void setGsum(Integer gsum) {
        this.gsum = gsum;
    }

    public Integer getGnum() {
        return gnum;
    }

    public void setGnum(Integer gnum) {
        this.gnum = gnum;
    }

    public Double getGprice2() {
        return gprice2;
    }

    public void setGprice2(Double gprice2) {
        this.gprice2 = gprice2;
    }

    public Double getGwei() {
        return gwei;
    }

    public void setGwei(Double gwei) {
        this.gwei = gwei;
    }

    public Double getGduty() {
        return gduty;
    }

    public void setGduty(Double gduty) {
        this.gduty = gduty;
    }

    public String getGpic() {
        return gpic;
    }

    public void setGpic(String gpic) {
        this.gpic = gpic;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gid=").append(gid);
        sb.append(", gname=").append(gname);
        sb.append(", gclass=").append(gclass);
        sb.append(", gprice=").append(gprice);
        sb.append(", gtext=").append(gtext);
        sb.append(", gsum=").append(gsum);
        sb.append(", gnum=").append(gnum);
        sb.append(", gprice2=").append(gprice2);
        sb.append(", gwei=").append(gwei);
        sb.append(", gduty=").append(gduty);
        sb.append(", gpic=").append(gpic);
        sb.append("]");
        return sb.toString();
    }
}