package com.henu.pojo;

import java.io.Serializable;
import java.util.List;

public class Car implements Serializable {
    private Integer cargood;

    private Integer carnum;

    private String caruser;

    private String user;

    private List<Goods> carList;

    private static final long serialVersionUID = 1L;

    public Integer getCargood() {
        return cargood;
    }

    public void setCargood(Integer cargood) {
        this.cargood = cargood;
    }

    public Integer getCarnum() {
        return carnum;
    }

    public void setCarnum(Integer carnum) {
        this.carnum = carnum;
    }

    public String getCaruser() {
        return caruser;
    }

    public void setCaruser(String caruser) {
        this.caruser = caruser;
    }

    public List<Goods> getCarList() {
        return carList;
    }

    public void setCarList(List<Goods> carList) {
        this.carList = carList;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cargood=").append(cargood);
        sb.append(", carnum=").append(carnum);
        sb.append(", caruser=").append(caruser);
        sb.append("]");
        return sb.toString();
    }
}