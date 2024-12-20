package h05;

public class TankerPlane extends Plane implements Refueling{
    private final double[] availableAmount;

    public TankerPlane(String aircraftRegistration, int baseWeight, FuelType fuelType, double fuelCapacity){
        super(aircraftRegistration, baseWeight, fuelType, fuelCapacity);
        this.availableAmount = new double[FuelType.values().length];
    }

    public void loadFuel(FuelType fuelType, double amount){
        availableAmount[fuelType.ordinal()] += amount;
    }

    @Override
    protected double mass(){
        double totalFuelWeight = 0;
        for (double fuel : availableAmount){
            totalFuelWeight += fuel;
        }
        return getBaseWeight() + totalFuelWeight;
    }

    @Override
    public void refuelPlane(Plane plane){
        FuelType planeFuelType = plane.getFuelType();
        double requiredFuel = plane.getFuelCapacity() - plane.getCurrentFuelLevel();
        double availableFuel = availableAmount[planeFuelType.ordinal()];

        double fuelToTransfer = Math.min(requiredFuel, availableFuel);
        plane.refuel(fuelToTransfer);
        availableAmount[planeFuelType.ordinal()] -= fuelToTransfer;
    }
}
