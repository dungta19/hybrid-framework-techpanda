package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_06_Condition_Statement_Exercise {
	WebDriver driver;
	Scanner scanner = new Scanner(System.in);

	@Test
	public void Ex_01() {
		System.out.println("Nhập vào 1 số bất kỳ:");
		int n = scanner.nextInt();

		if ((n % 2) == 0) {
			System.out.println(n + " là số chẵn");
		} else {
			System.out.println(n + " là số lẻ");
		}
	}

	@Test
	public void Ex_02() {
		System.out.println("Nhập vào n số bất kỳ:");
		int n = scanner.nextInt();
		System.out.println("Nhập vào m số bất kỳ:");
		int m = scanner.nextInt();

		if (n > m) {
			System.out.println(n + " > " + m);
		} else if (n < m) {
			System.out.println(n + " < " + m);
		} else {
			System.out.println(n + " = " + m);
		}
	}

	@Test
	public void Ex_03() {
		System.out.println("Nhập vào tên của người 1:");
		String a = scanner.nextLine();
		System.out.println("Nhập vào tên của người 2:");
		String b = scanner.nextLine();

		if (a.equals(b)) {
			System.out.println("Tên 2 người giống nhau");
		} else {
			System.out.println("Tên 2 người khác nhau");
		}
	}

	@Test
	public void Ex_04() {
		System.out.print(" a = ");
		int a = scanner.nextInt();
		System.out.print(" b = ");
		int b = scanner.nextInt();
		System.out.print(" c = ");
		int c = scanner.nextInt();

		if (a > b && a > c) {
			System.out.println("max(a,b,c) = " + a);
		} else if (b > a && b > c) {
			System.out.println("max(a,b,c) = " + b);
		} else {
			System.out.println("max(a,b,c) = " + c);
		}
	}

	@Test
	public void Ex_05() {
		System.out.print(" a = ");
		int a = scanner.nextInt();

		if (10 <= a && a <= 100) {
			System.out.println(a + " in sequence [10,100]");
		} else {
			System.out.println(a + " not in sequence [10,100]");
		}
	}

	@Test
	public void Ex_06() {
		System.out.print(" score = ");
		float a = scanner.nextInt();

		if (0 <= a && a <= 5) {
			System.out.println("Điểm D");
		} else if (5 < a && a <= 7.5) {
			System.out.println("Điểm C");
		} else if (7.5 < a && a <= 8.5) {
			System.out.println("Điểm B");
		} else if (8.5 < a && a <= 10) {
			System.out.println("Điểm A");
		} else {
			System.out.println("Error, vui lòng nhập lại số điểm!");
		}
	}

	@Test
	public void Ex_07() {
		System.out.print(" Month = ");
		float a = scanner.nextInt();
		System.out.print("Năm Nhuần không? true/false: ");
		boolean year = scanner.nextBoolean();

		if (a == 1 || a == 3 || a == 5 || a == 7 || a == 8 || a == 10 || a == 12) {
			System.out.println("Tháng " + a + " 31 ngày");
		} else if (a == 2 && year) {
			System.out.println("Tháng " + a + " 29 ngày");
		} else if (a == 2 && !year) {
			System.out.println("Tháng " + a + " 28 ngày");
		} else if (a == 4 || a == 6 || a == 9 || a == 11) {
			System.out.println("Tháng " + a + " 30 ngày");
		} else {
			System.out.println("Error, vui lòng nhập số tháng!");
		}
	}
}