package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_08_For_ForEach_Exercises {
	Scanner scanner = new Scanner(System.in);

//	@Test
	public void Ex_01() {
		System.out.println("Nhập số lớn nhất trong chuỗi : ");
		int n = scanner.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

//	@Test
	public void Ex_02() {
		System.out.print("Nhập số đầu chuỗi : ");
		int a = scanner.nextInt();
		System.out.print("Nhập số cuối chuỗi : ");
		int b = scanner.nextInt();

		for (int i = a; i <= b; i++) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

//	@Test
	public void Ex_03() {
		for (int i = 0; i <= 10; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println("");
	}

//	@Test
	public void Ex_04() {
		System.out.print("a = ");
		int a = scanner.nextInt();
		System.out.print("b = ");
		int b = scanner.nextInt();

		for (int i = (a + 1); i <= b; i++) {
			a = a + i;
		}
		System.out.println(a);
	}

//	@Test
	public void Ex_05() {
		System.out.print("Nhập số nguyên : ");
		int a = scanner.nextInt();
		int b = a;
		for (int i = 0; i <= b; i++) {
			if (!(i % 2 == 0)) {
				System.out.println(i);
				a = i + a;
			}
		}
		System.out.println(a - b);

	}

//	@Test
	public void Ex_06() {
		System.out.print("a = ");
		int a = scanner.nextInt();
		System.out.print("b = ");
		int b = scanner.nextInt();

		for (int i = a; i <= b; i++) {
			if (i % 3 == 0) {
				System.out.print(i + " ");
			}

		}
	}

	@Test
	public void Ex_07() {
		System.out.print("n = ");
		long n = scanner.nextLong();
		long a = 1;
		for (int i = 1; i <= n; i++) {
			a = i * a;
		}
		System.out.println(a);
	}
}
