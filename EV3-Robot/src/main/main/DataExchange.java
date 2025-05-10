package main;

public class DataExchange {

    private int speed;
    private int turnRate;

    public synchronized int getSpeed() {
        return speed;
    }

    public synchronized void setSpeed(int speed) {
        this.speed = speed;
    }

    public synchronized int getTurnRate() {
        return turnRate;
    }

    public synchronized void setTurnRate(int turnRate) {
        this.turnRate = turnRate;
    }
}
