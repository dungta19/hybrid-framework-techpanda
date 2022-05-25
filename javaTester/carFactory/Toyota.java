package carFactory;

public class Toyota implements Car {

	@Override
	public void viewCar() {
		System.out.println("Viewing Toyota car");
	}

	@Override
	public void driveCar() {
		System.out.println("Driving Toyota car");
		
	}

	@Override
	public void testCar() {
		System.out.println("Testing Toyota car");
		
	}

}
