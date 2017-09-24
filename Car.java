package derby;

import java.text.DecimalFormat;

public class Car extends Vehicle {

	public Car(int sizeInTons) {
		super();
		this.sizeInTons = sizeInTons;
		this.maneuverability = 0.8;
	}
	
	@Override
	public void attemptRunDown(Vehicle v) {
		System.out.println(toString() + " attempts to run down " + v.toString());
		
		if (r.nextDouble() > v.getManeuverability()) {
			v.receiveCrashDamage((double)sizeInTons/v.getSizeInTons());
		} else {
			System.out.println("Misses!");
		}
	}
	
	public String toString() {
		DecimalFormat f = new DecimalFormat("##.00");

		return "#" + id + " a car weighing " + sizeInTons + " ton(s) "
				+ "with maneuverability " + maneuverability + " and "
				+ "condition " + f.format(condition);
	}
}
