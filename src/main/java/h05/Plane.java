package h05;

public abstract class Plane implements Flying{
    private final String aircraftRegistration;
    private final int baseWeight;
    private final FuelType fuelType;
    private final double fuelCapacity;
    private double currentFuelLevel;
    private static final double CONSUMPTION_PER_KM_KG = 1.1494e-3;

    public Plane(String aircraftRegistration, int baseWeight, FuelType fuelType, double fuelCapacity){
        this.aircraftRegistration = aircraftRegistration;
        this.baseWeight = baseWeight;
        this.fuelType = fuelType;
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLevel = 0.0;
    }

    @Override
    public String getIdentifier(){
        return aircraftRegistration;
    }

    public FuelType getFuelType(){
        return fuelType;
    }

    public double getFuelCapacity(){ return fuelCapacity; }

    public double getCurrentFuelLevel(){
        return currentFuelLevel;
    }

    public double getBaseWeight(){ return baseWeight;}

    public void refuel(double amount){
        currentFuelLevel += amount;
        if(currentFuelLevel > fuelCapacity){
            System.out.print("The tank of Plane " + aircraftRegistration + " has overflowed!");
            currentFuelLevel = fuelCapacity;
        }
    }

    protected abstract double mass();

    protected double getFuelConsumptionPerKilometer(){
        return mass() * CONSUMPTION_PER_KM_KG * fuelType.getConsumptionMultiplicator();
    }

    public void fly(double distance){
        double requiredFuel = getFuelConsumptionPerKilometer() * distance;
        if (currentFuelLevel < requiredFuel){
            System.out.println("Plane " + aircraftRegistration + " does not have enough fuel to fly " + distance + " km.");
        } else {
            currentFuelLevel -= requiredFuel;
            System.out.println("Plane " + aircraftRegistration + " flew " + distance + " km and has " + currentFuelLevel + " liters of fuel left.");
        }
    }

    public void takeOff(){
        Airspace.get().register(this);
    }

    public void land(){
        Airspace.get().deregister(this);
    }
}
