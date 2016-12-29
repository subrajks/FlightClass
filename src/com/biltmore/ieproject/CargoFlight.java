package com.biltmore.ieproject;

/**
 * Created by jaiks on 12/20/2016.
 */
public class CargoFlight extends Flight {
    private double maxCargoSpace;
    private double currentCargoSpace = 0.0d;

    @Override
    public int getSeats() { return 2; }

    public CargoFlight(int flightNumber) {
        super(flightNumber);
        this.maxCargoSpace = 1000.0d;
    }

    public CargoFlight(int flightNumber, double maxCargoSpace) {
        this(flightNumber);
        this.maxCargoSpace = maxCargoSpace;
    }

    public final void add1Package (float l, float w, float d) {
        double cargoSpace = l * w * d;
        if (hasCargoSpace(cargoSpace))
            currentCargoSpace += cargoSpace;
        else
            handleTooMany();
    }
    private boolean hasCargoSpace(double cargoSpace) {
        return ((currentCargoSpace + cargoSpace <= maxCargoSpace) ? true : false);
    }

    public double getCurrentCargoSpace() { return currentCargoSpace; }
    private void handleTooMany() {
        System.out.println("Too much cargo!");
    }
}
