package com.biltmore.ieproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;

/**
 * Created by jaiks on 12/19/2016.
 */
public class Flight implements Comparable {
    private int passengers;
    private int totalCheckedBags;
    private int maxCarryOns, totalCarryOns;
    private int flightNumber;
    private int flightTime; //minutes past midnight

    public Flight() {
        this.passengers = 0;
        this.flightNumber = 0;
        this.maxCarryOns = getSeats() * 2;
    }

    public Flight(int flightNumber) {
        this();
        this.flightNumber = flightNumber;
    }

    public Flight(int flightNumber, int flightTime){
        this(flightNumber);
        this.flightTime = flightTime;
    }

    int getSeats() { return 3; }

    public int compareTo(Object o) {
        Flight flight = (Flight) o;
        return flightTime - flight.flightTime;
    }

    public void addPassengers(String fileName) throws IOException{
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = null;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                passengers += Integer.valueOf(parts[0]);
            }
        } finally {
            if(reader != null)
                reader.close();
        }
    }

    public void addPassengers(Passenger ... listPassengers) {
        if (listPassengers.length < 0) {
            System.out.println("invalid no of passengers!");
            return;
        }

        if (hasRoom(listPassengers.length)) {
            for (Passenger passenger : listPassengers) {
                if (hasCarryOnSpace(passenger.getCarryOns())) {
                    totalCarryOns += passenger.getCarryOns();
                    totalCheckedBags += passenger.getCheckedBags();
                    passengers++;
                }
                else
                    System.out.println(passenger.getFullName() + " has too many carry-on bags!");
            }
        }
        else
            handleTooMany();
    }

    private boolean hasRoom(int noOfPassengers) {
        return passengers + noOfPassengers <= getSeats();
    }

    private boolean hasCarryOnSpace(int carryOns) {
        return totalCarryOns + carryOns <= maxCarryOns;
    }

    private void handleTooMany() {
        System.out.println("Too many passengers!");
    }

    public int getPassengers() {
        return passengers;
    }

    public String toString() {
        return ((flightNumber > 0) ? "Flight #" + flightNumber : "0");
    }
    /*
    public boolean hasRoom(Flight f2) {
        return passengers + f2.passengers <= seats;

    }


    public Flight createNewWithBoth(Flight f2) {
        Flight newFlight = new Flight();

        newFlight.seats = seats;
        newFlight.passengers = this.passengers + f2.passengers;
        return newFlight;
    }
*/
}
