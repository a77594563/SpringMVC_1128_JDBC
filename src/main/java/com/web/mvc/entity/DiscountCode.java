package com.web.mvc.entity;

public class DiscountCode {
    private String discountCode;
    private double rate;

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    
    public String getLabel() { // 提供給下拉選單使用
        return discountCode + " : " + rate;
    }

    @Override
    public String toString() {
        return "DiscountCode{" + "discountCode=" + discountCode + ", rate=" + rate + '}';
    }
    
}
