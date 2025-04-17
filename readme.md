# Description of Applied Application Project 

In this course we learn bit more object-oriented-programming where in first two week are pretty much used for familiarizing ourselves with the topics that are then needed for the practice work. The practice work is about making a line follower Lego robot together with team. Then at the end of the course there are review sessions which are compulsory. 

We will run the lego robot with doing some changes which detect obstacles and tackle them with the help of sensors. And, we have divided the parts according to the sensors. 

## There are totally three part :

1. Ultrasonic Sensor part (Harsh Chahal)
2. Light Sensor part (Tuo Yan)
3. Line Follower part (Nabin Yari)


## Light Sensor part (Tuo Yan)

In this Light Sensor component of the project, I am enabling the robot to detect and respond to ambient light levels using a light sensor. This functionality allows the robot to adapt its behavior dynamically based on environmental lighting conditions, such as navigating through dark or bright areas. The sensor measures reflected or ambient light intensity, which is processed in real time to control the robot’s movement. Similar to the line-following logic, I am using Java to program the robot’s behavior and compiling it into an executable JAR file.

#### Source code 
public class LightSensor implements Runnable{
    public void run()
    {
        EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S4);

        SampleProvider ambientSample = colorSensor.getAmbientMode(); // using the getAmbientMode() too measures ambient light level 
        // Create an array to hold the sensor data
        float[] ambientSample1 = new float[ambientSample.sampleSize()];

        SampleProvider colorId = colorSensor.getColorIDMode(); // using the getColorIDMode() for detection of basic color as ID
        float[] colorSample2 = new float[colorId.sampleSize()];

        while (!Button.ESCAPE.isDown()) // Exit if the ESCAPE button is pressed
        {
            // Get the current light intensity reading from the sensor
            ambientSample.fetchSample(ambientSample1, 0);

            // Get the current color Id reading from the sensor
            colorId.fetchSample(colorSample2, 0);
            int colorDetector = (int)colorSample2[0]; // convert the 0 index float value to integer
            synchronized(LCD.class)
            {
            LCD.clear(); // Clear the LCD screen
            LCD.drawString("Light Intensity: " + (int)(ambientSample1[0] * 100) + "%", 0, 0); // Display the light intensity value on the LCD screen as percentage
            String colorName = getcolorName(colorDetector);
            LCD.drawString("Color name: " + colorName, 0, 1);
        }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        colorSensor.close();
    }

    public static String getcolorName(int cD)  // passind the colorDetector value in cD variable
    {
        switch(cD) // switch the Cd values
        {
            case 0:
                    return "Red";
            case 1: 
                    return "Green";
            case 2:
                    return "Blue";
            case 3: 
                    return "Yellow";
            case 4: 
                    return "Magenta";
            case 5: 
                    return "Orange";
            case 6: 
                    return "White";
            case 7: 
                    return "Black";
            default:
                    return "This id color is not mentioned.";
  }
}

}
