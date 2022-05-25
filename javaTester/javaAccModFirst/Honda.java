package javaAccModFirst;

// Class khác không được kế thừa Final class
public class Honda extends Car {
	// Nhưng vẫn được truy cập thông qua việc tạo mới đối tượng
	Car car = new Car();
}
