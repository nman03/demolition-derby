package derby;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
	private boolean hasHitch;
	
	public Truck(int sizeInTons, boolean hasHitch) {
		super();
		this.sizeInTons = sizeInTons;
		this.hasHitch = hasHitch;
		this.maneuverability = 0.35;
	}
	
	@Override
	public void attemptRunDown(Vehicle v) {
		System.out.println(toString() + " attempts to run down " + v.toString());
		
		if (r.nextDouble() > v.getManeuverability()) {
			if (hasHitch) {
				v.receiveCrashDamage((double)sizeInTons/v.getSizeInTons() + 0.05);
			} else {
				v.receiveCrashDamage((double)sizeInTons/v.getSizeInTons());
			}
		} else {
			System.out.println("Misses!");
		}	
	}
	
	public String toString() {
		DecimalFormat f = new DecimalFormat("##.00");

		if (hasHitch) {
			return "#" + id + " a truck weighing " + sizeInTons + " ton(s) "
					+ "with a hitch with maneuverability " + maneuverability + " and "
					+ "condition " + f.format(condition);
		}
		else {
			return "#" + id + " a truck weighing " + sizeInTons + " ton(s) "
					+ "with maneuverability " + maneuverability + " and "
					+ "condition " + f.format(condition);
		}
	}
}
