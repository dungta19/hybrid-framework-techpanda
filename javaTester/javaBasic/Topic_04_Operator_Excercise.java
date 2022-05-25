package javaBasic;

public class Topic_04_Operator_Excercise {

	public static void main(String[] args) {
		System.out.println("<---------------------------------Exercise 01--------------------------------->");

		String name = "Tuan";
		int currentAge = 23;
		int yearsPast = 15;

		int afterAge = currentAge + yearsPast;
		System.out.println("After " + yearsPast + " years, " + name + " will be " + afterAge + " years old");

		System.out.println("<---------------------------------Exercise 02--------------------------------->");

		int a, b;
		a = 3;
		b = 4;
		System.out.println("a = " + a);
		System.out.println("b = " + b);

		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a = " + a);
		System.out.println("b = " + b);

		System.out.println("<---------------------------------Exercise 03--------------------------------->");

		int x, y;
		x = 5;
		y = 4;

		if (x > y) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

		x = 7;
		y = 8;

		if (x > y) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

	}

}
