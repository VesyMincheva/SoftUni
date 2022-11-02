package trafficLights;

public class TrafficLight {
    private Color signal;

    public TrafficLight(Color signal) {
        this.signal = signal;
    }

    public Color getSignal() {
        return signal;
    }

    public void updateSignals (){
        if (signal == Color.RED){
            signal = Color.GREEN;
        } else if (signal == Color.GREEN) {
            signal = Color.YELLOW;
        } else if (signal == Color.YELLOW) {
            signal = Color.RED;
        }
    }
}
