package derby;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Derby {
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	private Random rand = new Random();
	
	public void drive() {
		Car car1 = new Car(rand.nextInt(2) + 1);
		Car car2 = new Car(rand.nextInt(2) + 1);
		Car car3 = new Car(rand.nextInt(2) + 1);
		Car car4 = new Car(rand.nextInt(2) + 1);
		Car car5 = new Car(rand.nextInt(2) + 1);
		Truck truck1 = new Truck(rand.nextInt(4) + 2, rand.nextBoolean());
		Truck truck2 = new Truck(rand.nextInt(4) + 2, rand.nextBoolean());
		Truck truck3 = new Truck(rand.nextInt(4) + 2, rand.nextBoolean());
		
		vehicles.add(car1);
		vehicles.add(car2);
		vehicles.add(car3);
		vehicles.add(car4);
		vehicles.add(car5);
		vehicles.add(truck1);
		vehicles.add(truck2);
		vehicles.add(truck3);
		
		while (vehicles.size() > 1) {
			Vehicle v1 = vehicles.get(rand.nextInt(vehicles.size()));
			Vehicle v2 = vehicles.get(rand.nextInt(vehicles.size()));
			
			while (v1.getId() == v2.getId()) {
				v1 = vehicles.get(rand.nextInt(vehicles.size()));
				v2 = vehicles.get(rand.nextInt(vehicles.size()));
			}
			
			v1.attemptRunDown(v2);
			
			if (!v2.running) {
				vehicles.remove(v2);
			}
		}
		
		if (vehicles.size() == 1) {
			System.out.println("The victor is " + vehicles.get(0).toString());
		}
	}
	
	public static void main(String[] args) {
		Derby derby = new Derby();
		derby.drive();
	}
}
