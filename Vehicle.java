package derby;

import java.util.Random;

public abstract class Vehicle {

	protected Random r = new Random();
	protected boolean running = true;
	protected int id;
	protected int sizeInTons; // 1 to 10
	protected double maneuverability; // 0 to 1
	protected double condition = 10; // 0 to 10

	private static int numVehicles = 0;

	public Vehicle() {
		numVehicles++;
		id = numVehicles;
	}

	public boolean isRunning() {
		return running;
	}

	public int getId() {
		return id;
	}

	public int getSizeInTons() {
		return sizeInTons;
	}

	public double getManeuverability() {
		return maneuverability;
	}

	public void receiveCrashDamage(double damageDone) {
		System.out.printf("Crash! Vehicle %d is hit and ", id);
		if (damageDone < condition) {
			condition -= damageDone;
			System.out.printf("receives %.2f damage; current condition %.2f\n", damageDone, condition);
		} else {
			condition = 0;
			running = false;
			System.out.println("is wrecked!");
		}
	}

	public abstract void attemptRunDown(Vehicle v);

}
