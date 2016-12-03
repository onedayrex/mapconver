package com.git.onedayrex.mapconver.util;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2016/12/4.
 */
public class CatProd {
    private String catId;
    private String catName;
    private BigDecimal loanPmt;

    public BigDecimal getLoanPmt() {
        return loanPmt;
    }

    public void setLoanPmt(BigDecimal loanPmt) {
        this.loanPmt = loanPmt;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "CatProd{" +
                "catId='" + catId + '\'' +
                ", catName='" + catName + '\'' +
                ", loanPmt=" + loanPmt +
                '}';
    }
}
