package main;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendData extends Thread {

    private final DataExchange data;

    public SendData(DataExchange data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            try {
               URL url = new URL("http://192.168.188.84:8080/jager/api/robot/stats"); // Replace with your laptop IP
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setDoOutput(true);

                // Example: robot sends same speed to both motors
                int speed = data.getSpeed();

                String json = String.format(
                    "{\"leftMotorSpeed\": %d, \"rightMotorSpeed\": %d}",
                    speed, speed
                );

                OutputStream os = conn.getOutputStream();
                os.write(json.getBytes());
                os.flush();
                os.close();

                System.out.println("Sent speed feedback to server: " + json);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(2000); // every 2 sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
