package javaBasic;

public class Topic_03_Compare {
	int number = 8;

	public static void main(String[] args) {
		System.out.println("--------------- Value type---------------");
		// 1 vùng nhớ cho biến x
		int x = 5;

		// 1 vùng nhớ cho biến y
		int y = x;

		System.out.println("x = " + x);
		System.out.println("y = " + y);

		y = 10;

		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
		//Reference type - Condition 1
		System.out.println("---------------Reference type - Condition 1---------------");
		
		Topic_03_Compare firstVariable = new Topic_03_Compare();
		Topic_03_Compare secondVariable = firstVariable;

		System.out.println("Before = " + firstVariable.number);
		System.out.println("Before = " + secondVariable.number);
		
		secondVariable.number = 15;
		
		System.out.println("After = " + firstVariable.number);
		System.out.println("After = " + secondVariable.number);
		
		//Reference type - Condition 2
		System.out.println("---------------Reference type - Condition 2---------------");
		
		Topic_03_Compare thirdVariable = new Topic_03_Compare();
		Topic_03_Compare fourthVariable = new Topic_03_Compare();

		System.out.println("Before = " + thirdVariable.number);
		System.out.println("Before = " + fourthVariable.number);
		
		fourthVariable.number = 14;
		
		System.out.println("After = " + thirdVariable.number);
		System.out.println("After = " + fourthVariable.number);
	}
}
 