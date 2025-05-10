package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ReceiveData extends Thread {

    private final DataExchange data;

    public ReceiveData(DataExchange data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Replace this IP with your laptop's actual IP address
                URL url = new URL("http://192.168.188.84:8080/LegoWebServices/api/robot/settings/latest");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine = in.readLine(); // assuming one-line JSON
                in.close();

                // Expected format: {"speed":100,"turnRate":0}
                String[] parts = inputLine.replaceAll("[{}\"]", "").split(",");

                int speed = 0, turnRate = 0;
                for (String part : parts) {
                    String[] keyValue = part.split(":");
                    if (keyValue[0].trim().equals("speed")) {
                        speed = Integer.parseInt(keyValue[1].trim());
                    } else if (keyValue[0].trim().equals("turnRate")) {
                        turnRate = Integer.parseInt(keyValue[1].trim());
                    }
                }

                data.setSpeed(speed);
                data.setTurnRate(turnRate);

                System.out.println("Received: speed=" + speed + ", turnRate=" + turnRate);

            } catch (Exception e) {
                System.out.println("Error receiving data.");
                e.printStackTrace();
            }

            try {
                Thread.sleep(2000); // poll every 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
