package com.henu.pojo;

import java.io.Serializable;

public class PageElement implements Serializable {
    private Integer currPage;

    private Integer perPageSize;

    private String key;

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public Integer getPerPageSize() {
        return perPageSize;
    }

    public void setPerPageSize(Integer perPageSize) {
        this.perPageSize = perPageSize;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "PageElement{" +
                "currPage=" + currPage +
                ", perPageSize=" + perPageSize +
                ", key='" + key + '\'' +
                '}';
    }
}
