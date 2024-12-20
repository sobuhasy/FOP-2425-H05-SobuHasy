package h05;

public class PassengerPlane extends Plane implements CarriesPassengers {
    private int passengerCount = 0;
    private final int crewCount;

    protected static final double AVERAGE_PEOPLE_WEIGHT = 100.0;
    protected static final double AVERAGE_LUGGAGE_WEIGHT = 15.0;

    public PassengerPlane(String aircraftRegistration, int baseWeight, FuelType fuelType, double fuelCapacity, int crewCount){
        super(aircraftRegistration, baseWeight, fuelType, fuelCapacity);
        this.crewCount = crewCount;
    }

    @Override
    public void board(int peopleCount) {
        passengerCount += peopleCount;
    }

    @Override
    public void disembark() {
        passengerCount = 0;
    }

    @Override
    public int getPassengerCount(){
        return passengerCount;
    }

    @Override
    protected double mass(){
        return getBaseWeight() + (crewCount + passengerCount) * AVERAGE_PEOPLE_WEIGHT + passengerCount * AVERAGE_LUGGAGE_WEIGHT;
    }
}
