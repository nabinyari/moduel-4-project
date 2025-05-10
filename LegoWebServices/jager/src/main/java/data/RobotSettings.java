package data;

import jakarta.persistence.*;

@Entity
public class RobotSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int speed;           // How fast the robot moves
    private int turnRate;        // How sharply it turns

    public RobotSettings() {}

    public RobotSettings(int speed, int turnRate) {
        this.speed = speed;
        this.turnRate = turnRate;
    }

    // Getters and Setters

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTurnRate() {
        return turnRate;
    }
    public void setTurnRate(int turnRate) {
        this.turnRate = turnRate;
    }
}

