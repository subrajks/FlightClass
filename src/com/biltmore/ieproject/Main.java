package com.biltmore.ieproject;

public class Main {
    public static void main(String[] args) {

        Flight[] squadron = new Flight[2];
        CargoFlight cFlight = new CargoFlight(246, 10.0d);

        squadron[0] = new Flight(123);
        squadron[1] = new CargoFlight(357, 50.0d);

        Passenger janet = new Passenger("Janet", "Smith");
        Passenger rob = new Passenger("Rob", "Smith");
        Passenger fred = new Passenger("Fred", "Hayes");

        janet.setCarryOns(2);
        janet.setCheckedBags(2);
        rob.setCarryOns(4);
        rob.setCheckedBags(3);
        fred.setCarryOns(1);
        fred.setCheckedBags(2);

        System.out.println("Adding to squadron #1");
        squadron[0].addPassengers(janet, rob, fred);
        System.out.println("Adding to squadron #2");
        squadron[1].addPassengers(janet, rob, fred);

        System.out.println("Adding to cargo flight");
        cFlight.addPassengers(janet, rob);
        cFlight.add1Package(1.0f, 5.0f, 3.0f);


        for (Flight flightList: squadron
             ) {
            StringBuilder sb = new StringBuilder(40);
            String location = "Florida";
            int time = 9;

            sb.append("I flew to ");
            sb.append(location);
            sb.append(" on ");
            sb.append(flightList);

            int pos = sb.length() - " on ".length() - flightList.toString().length();

            sb.insert(pos, " at ");
            sb.insert(pos + 4, time);

            sb.append( " and had ");
            sb.append(flightList.getPassengers());
            sb.append(" passengers!");
            System.out.println(sb.toString());
        }

        System.out.println("# of passengers: " + cFlight.getPassengers() + " cargo: " + cFlight.getCurrentCargoSpace());
    }
}
