package carFactory;

public class CarFactory {
	public static Car getCarType(CarType carType) {
		switch (carType) {
		case HONDA:
			return new Honda();
		case HUYNDAI:
			return new Huyndai();
		case TOYOTA:
			return new Toyota();
		default:
			throw new IllegalArgumentException("This car type is not available");
		}
	}
}
