package main;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class ObstacleDetector extends Thread {

    private final DataExchange data;

    public ObstacleDetector(DataExchange data) {
        this.data = data;
    }

    @Override
    public void run() {
        EV3UltrasonicSensor ultrasonicSensor = new EV3UltrasonicSensor(SensorPort.S1);
        SampleProvider distanceProvider = ultrasonicSensor.getDistanceMode();
        float[] sample = new float[distanceProvider.sampleSize()];

        while (true) {
            distanceProvider.fetchSample(sample, 0);
            float distanceInMeters = sample[0];

            // If object is within 15 cm, stop robot
            if (distanceInMeters < 0.15) {
                data.setSpeed(0);
                System.out.println("Obstacle detected! Stopping...");
            }

            try {
                Thread.sleep(500); // Check every half second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
