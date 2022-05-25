package javaAccModSecond;

import javaAccModFirst.Dog;

public class Fish {
	// class Cat không cho phép truy cập ngoài package
	Cat cat = new Cat();

	// class Dog được truy cập mọi nơi.
	Dog dog = new Dog();

}
