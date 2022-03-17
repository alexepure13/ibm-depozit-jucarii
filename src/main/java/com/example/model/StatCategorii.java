package com.example.model;

public class StatCategorii {
    private int intrariTotal;
    private int cantitateTotal;

    public StatCategorii(){

    }

    public StatCategorii(int intrariTotal, int cantitateTotal){
        this.intrariTotal = intrariTotal;
        this.cantitateTotal = cantitateTotal;
    }

    public int getIntrariTotal() {
        return intrariTotal;
    }

    public void setIntrariTotal(int intrariTotal) {
        this.intrariTotal = intrariTotal;
    }

    public int getCantitateTotal() {
        return cantitateTotal;
    }

    public void setCantitateTotal(int cantitateTotal) {
        this.cantitateTotal = cantitateTotal;
    }
}
