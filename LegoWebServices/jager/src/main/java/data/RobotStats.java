package data;

import jakarta.persistence.*;

@Entity
public class RobotStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int leftMotorSpeed;     // Speed of left motor
    private int rightMotorSpeed;    // Speed of right motor

    public RobotStats() {}

    public RobotStats(int leftMotorSpeed, int rightMotorSpeed) {
        this.leftMotorSpeed = leftMotorSpeed;
        this.rightMotorSpeed = rightMotorSpeed;
    }

    // Getters and Setters

    public int getLeftMotorSpeed() {
        return leftMotorSpeed;
    }
    public void setLeftMotorSpeed(int leftMotorSpeed) {
        this.leftMotorSpeed = leftMotorSpeed;
    }

    public int getRightMotorSpeed() {
        return rightMotorSpeed;
    }
    public void setRightMotorSpeed(int rightMotorSpeed) {
        this.rightMotorSpeed = rightMotorSpeed;
    }
}
