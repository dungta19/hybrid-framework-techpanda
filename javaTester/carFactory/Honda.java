package carFactory;

public class Honda implements Car {

	@Override
	public void viewCar() {
		System.out.println("Viewing Honda car");
	}

	@Override
	public void driveCar() {
		System.out.println("Driving Honda car");
		
	}

	@Override
	public void testCar() {
		System.out.println("Testing Honda car");
		
	}

}
