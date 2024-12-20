package h05;

/**
 * Main entry point in executing the program.
 */
public class Main {
    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {
        // TODO: H5.6
        // Scannen Sie einmal zu Beginn den Luftraum mittels scanAirspace()
        Airspace.get().scanAirspace();

        // Erstellen Sie zwei Runway-Objekte mit den Längen 2000 und 4000 Metern.
        Runway runway01 = new Runway(2000);
        Runway runway02 = new Runway(4000);

        // Erstellen und starten Sie einen WeatherBalloon mit der balloonNumber 99.
        WeatherBalloon weatherBalloon = new WeatherBalloon(99);
        weatherBalloon.start();

        // Erstellen Sie zwei Tank-Objekte mit den Treibstoffen FuelType.JetA und FuelType.JetB.
        Tank jetATank = new Tank(FuelType.JetA);
        Tank jetBTank = new Tank(FuelType.JetB);

        /* Erstellen Sie ein TankerPlane-Objekt mit dem Identifier "D-ABCD", einem baseWeight von 10000 kg, dem
        Treibstoff FuelType.JetA und einer Kapazität Füllstand von 1000 Litern. Laden Sie die Treibstoffe AvGas und
        Biokerosin jeweils mit 100000 Litern. */
        TankerPlane tankerPlane = new TankerPlane("D-ABCD", 10000, FuelType.JetA, 1000);
        tankerPlane.loadFuel(FuelType.AvGas, 100000);
        tankerPlane.loadFuel(FuelType.Biokerosin, 100000);

        /*  Erstellen Sie ein PassengerPlane-Objekt mit dem Identifier "GAG-67", einem baseWeight von 10000 kg,
        dem Treibstoff FuelType.JetA, einer Kapazität von 1700 Litern und 5 Crewmitgliedern. Betanken Sie dieses
        Flugzeug mit jetATank, lassen Sie 100 Passagiere einsteigen und starten Sie das Flugzeug. */
        PassengerPlane passengerPlane = new PassengerPlane("GAG-67", 10000, FuelType.JetA, 1700, 5);
        jetATank.refuelPlane(passengerPlane);
        passengerPlane.board(100);
        passengerPlane.takeOff();

        // Scannen Sie den Luftraum jetzt erneut.
        Airspace.get().scanAirspace();

        /* Erstellen Sie ein CargoPlane-Objekt mit dem Identifier "D-AFFF", einem baseWeight von 8000 kg, dem
        Treibstoff FuelType.JetBundeinerKapazität von 1500Litern. LadenSieeinenContainermit 1000Kilogramm
        und betanken Sie das Flugzeug mit dem entsprechenden Tank. */
        CargoPlane cargoPlane = new CargoPlane("D-AFFF", 8000, FuelType.JetB, 1500);
        cargoPlane.loadContainer(1000);
        jetBTank.refuelPlane(cargoPlane);

        // Lassen Sie die Passagiere aus dem PassengerPlane aussteigen.
        passengerPlane.disembark();

        // Scannen Sie den Luftraum jetzt nochmal
        Airspace.get().scanAirspace();

        // Starten Sie das CargoPlane und lassen Sie es 1000 Kilometer fliegen.
        cargoPlane.takeOff();
        cargoPlane.fly(1000);

        // Scannen Sie jetzt den Luftraum wieder
        Airspace.get().scanAirspace();

        /* Erstellen Sie ein CombinedPlane-Objekt mit dem Identifier "D-ABBB", einem baseWeight von 9000 kg, dem
        Treibstoff FuelType.AvGas, einer Kapazität von 10700 Litern und 5 Crewmitgliedern. Betanken Sie dieses
        Flugzeug mit tankerPlane. */
        CombinedPlane combinedPlane = new CombinedPlane("D-AFFF", 9000, FuelType.AvGas, 10700, 5);
        tankerPlane.refuelPlane(combinedPlane);

        /* Lassen Sie 30 Passagiere in das CombinedPlane einsteigen, laden Sie einen Container mit 400 Kilogramm und
        starten Sie das Flugzeug. Lassen Sie es 3000 Kilometer fliegen */
        combinedPlane.board(30);
        combinedPlane.loadContainer(400);
        combinedPlane.takeOff();
        combinedPlane.fly(3000);

        // Scannen Sie den Luftraum jetzt nochmal
        Airspace.get().scanAirspace();

        // Lassen Sie das CombinedPlane auf runway01 und das CargoPlane auf runway02 landen.
        runway01.land(combinedPlane);
        runway02.land(cargoPlane);

        // Scannen Sie den Luftraum jetzt nochmal
        Airspace.get().scanAirspace();

        // Lassen Sie den WeatherBalloon platzen und scannen Sie erneut den Luftraum
        weatherBalloon.pop();
        Airspace.get().scanAirspace();

        // Und zuletzt scannen Sie den Luftraum jetzt nochmal
        Airspace.get().scanAirspace();
    }
}
