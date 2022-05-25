package carNonFactory;

public class Client {
	public static void main(String[] args) {
		Honda honda = new Honda();
		honda.viewCar();
		honda.driveCar();
		honda.testCar();
		
		Huyndai huyndai = new Huyndai();
		huyndai.viewCar();
		huyndai.driveCar();
		huyndai.testCar();
		
		Toyota toyota = new Toyota();
		toyota.viewCar();
		toyota.driveCar();
		toyota.testCar();
		
	}
}
