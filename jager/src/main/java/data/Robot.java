
package data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="robot")
public class Robot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float speed;
	
	public Robot() {
		super();
	}
	public Robot(float speed) {
		super();
		this.speed = speed;
	}
	public Robot(int id, float speed) {
		super();
		this.id = id;
		this.speed = speed;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public String toString() {
		return id+": "+speed;
	}
}