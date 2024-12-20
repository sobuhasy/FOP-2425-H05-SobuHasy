package h05;

public class WeatherBalloon implements Flying{
    private final int balloonnumber;

    public WeatherBalloon(int balloonnumber){
        this.balloonnumber = balloonnumber;
    }

    @Override
    public String getIdentifier() {
        return  "WeatherBalloon " + balloonnumber;
    }

    public void start(){
        Airspace.get().register(this);
    }

    public void pop(){
        Airspace.get().deregister(this);
    }
}
