package main;

import lejos.hardware.motor.Motor;
import lejos.hardware.lcd.LCD;

public class Motors extends Thread {

    private final DataExchange data;

    public Motors(DataExchange data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            int speed = data.getSpeed();
            int turnRate = data.getTurnRate();

            LCD.clear();
            LCD.drawString("Speed: " + speed, 0, 0);
            LCD.drawString("Turn: " + turnRate, 0, 1);

            Motor.A.setSpeed(speed);
            Motor.B.setSpeed(speed);

            if (turnRate > 0) {
                Motor.A.forward();
                Motor.B.backward();
            } else if (turnRate < 0) {
                Motor.A.backward();
                Motor.B.forward();
            } else {
                Motor.A.forward();
                Motor.B.forward();
            }

            try {
                Thread.sleep(1000);  // update every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
