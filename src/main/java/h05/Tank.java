package h05;

public class Tank implements Refueling {
    private final FuelType fuelType;

    public Tank(FuelType fuelType){
        this.fuelType = fuelType;
    }

    @Override
    public void refuelPlane(Plane plane){
        if (plane.getFuelType() == fuelType){
            double requiredFuel = plane.getFuelCapacity() - plane.getCurrentFuelLevel();
            plane.refuel(requiredFuel);
        } else {
            System.out.println("Refueling failed: The tank contains " + fuelType + " which is not compatible with the plane's fuel type.");
        }
    }
}
