package com.inqoo.TavelOfficeWeb.Model;

import com.inqoo.TavelOfficeWeb.Model.Trip;

public class DomesticTrip extends Trip {
    private double ownArrivalDiscount;

    @Override
    public String toString() {
        return "DomesticTrip{" +
                "ownArrivalDiscount=" + ownArrivalDiscount +
                '}';
    }

    public double getPrice() {
        return super.getPriceEur() - ownArrivalDiscount;
    }

    public void setOwnArrivalDiscount(double ownArrivalDiscount) {
        this.ownArrivalDiscount = ownArrivalDiscount;
    }
}