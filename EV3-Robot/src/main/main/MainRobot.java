package main;

public class MainRobot {

    public static void main(String[] args) {
        DataExchange data = new DataExchange();

        // Start all essential threads
        ReceiveData receiver = new ReceiveData(data);
        Motors motors = new Motors(data);
        SendData sender = new SendData(data);
        ObstacleDetector detector = new ObstacleDetector(data);

        // Start threads
        // Robot will wait for values (speed > 0) before acting
        receiver.start();
        motors.start();
        sender.start();
        detector.start();

        System.out.println("Robot is running and waiting for parameters...");
    }
}
