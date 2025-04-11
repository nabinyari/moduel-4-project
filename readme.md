# Description of Applied Application Project 

In this course we learn bit more object-oriented-programming where in first two week are pretty much used for familiarizing ourselves with the topics that are then needed for the practice work. The practice work is about making a line follower Lego robot together with team. Then at the end of the course there are review sessions which are compulsory. 

We will run the lego robot with doing some changes which detect obstacles and tackle them with the help of sensors. And, we have divided the parts according to the sensors. 

## There are totally three part :

1. Ultrasonic Sensor part (Harsh Chahal)
2. Light Sensor part (Tuo Yan)
3. Line Follower part (Nabin Yari)

## Line Follower part (Nabin Yari)

In this linefollwer part, I am making the robot to follow a line which is on the white surface with the help of light sensor. It is commonly used in robotics to enable a robot to detect and follow a path. It operates by emitting infrared (IR) light and measuring the amount of light reflected back from the surface beneath it. I am using the java code to write code and convert it to jar file which helps to run the robot according I haved planed. 

I am getAmbientMode which helps to give me the light intensity and I am using the sample variable to store it. And then, I am seting the speed of motors and giving command to motors move forware. Then, I am using while loop which is run until the ESCAPE button is pressed. In loop I have written the code which fetch the data on 0 index which was store in float data type sample variable. And then, I am displaying the intensity value in screen and using some if else conditions to run the robot with in proper guidence.

#### Source code 

        SampleProvider light = colorSensor.getRedMode();

        float[] sample = new float[light.sampleSize()];

        Motor.A.setSpeed(300);
        Motor.B.setSpeed(300);

        Motor.A.forward();
        Motor.B.forward();
        while (!Button.ESCAPE.isDown()) {
            // Get the current red light intensity reading from the sensor
            light.fetchSample(sample, 0); 
            
            LCD.clear();
            LCD.drawString("Red Light Intensity: " + (int)(sample[0] * 100) + "%", 0, 0);
            
            float threshold = 0.2f;  // Adjusted threshold value for the black line detection

            // If the light intensity is low (black line), the robot is on the line
            if (sample[0] < threshold)
            { 
                Motor.A.setSpeed(300);
                Motor.B.setSpeed(300);
                Motor.A.forward();
                Motor.B.forward();
            }
            else                        // Off the black line, adjust to turn towards the line
            {
                // Work on these logics. they are just for illustration purposes.
                // The turns defined below can be inverted turns. So test yourselves and rectify accordingly
                if (sample[0] > 0.6)
                {
                    // If it's very bright (white surface), turn left
                    Motor.A.setSpeed(300);
                    Motor.B.setSpeed(150);
                }
                else
                {
                    // If it's somewhat bright (near the edge of the line), turn right
                    Motor.A.setSpeed(150);
                    Motor.B.setSpeed(300);
                }
                Motor.A.forward();
                Motor.B.forward();
            }
