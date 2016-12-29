package com.biltmore.ieproject;

/**
 * Created by jaiks on 12/19/2016.
 */
public final class Passenger {
    private String firstName = "";
    private String lastName = "";
    private int checkedBags = 0;
    private int carryOns = 0;

    public Passenger (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Passenger (String firstName, String lastName, int checkedBags) {
        if (checkedBags >= 0) {
            new Passenger(firstName, lastName);
            this.checkedBags = checkedBags;
        }
    }

    public Passenger (String firstName, String lastName, int checkedBags, int carryOns) {
        if(carryOns >= 0) {
            new Passenger(firstName, lastName, checkedBags);
            this.carryOns = carryOns;
        }
    }

    public void setCarryOns(int carryOns) {
        this.carryOns += (carryOns > 0) ? carryOns : 0;
    }

    public void setCheckedBags(int checkedBags) {
        this.checkedBags += (checkedBags > 0) ? checkedBags : 0;
    }

    public int getCarryOns() {
        return carryOns;
    }

    public int getCheckedBags() {
        return checkedBags;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
