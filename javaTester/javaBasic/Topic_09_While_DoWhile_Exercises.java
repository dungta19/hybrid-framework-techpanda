package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_While_DoWhile_Exercises {
	Scanner scanner = new Scanner(System.in);

//	@Test
	public void Ex_01() {
		System.out.println("Nhập số lớn nhất trong chuỗi : ");
		int n = scanner.nextInt();

		while (n <= 100) {
			if (n % 2 == 0) {
				System.out.print(n + " ");
			}
			n++;
		}
	}

//	@Test
	public void Ex_02() {
		System.out.println("Nhập số nhỏ nhất trong chuỗi : ");
		int a = scanner.nextInt();
		System.out.println("Nhập số lớn nhất trong chuỗi : ");
		int b = scanner.nextInt();
		int i = a;

		while (a <= i && i <= b) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.print(i + " ");
			}
			i++;
		}
	}

//	@Test
	public void Ex_03() {
		System.out.println("Chương trình tính tổng các số lẻ từ 0 đến n");
		System.out.println("--> Nhập 1 số tự nhiên n bất kỳ : ");
		int n = scanner.nextInt();

		int i = 0;

		while (i <= n) {
			if (n % 2 != 0) {
				i += n;
			}
			n++;
		}
		System.out.println(i);

	}

//	@Test
	public void Ex_04() {
		System.out.println("Chương trình tính tổng các số chia hết cho 3 trong chuỗi từ a đến b");
		System.out.print("--> Nhập 1 số tự nhiên a bất kỳ : ");
		int a = scanner.nextInt();
		System.out.print("--> Nhập 1 số tự nhiên b bất kỳ : ");
		int b = scanner.nextInt();
		int i = a;

		while (a <= i && i <= b) {
			if (i % 3 == 0) {
				System.out.print(i + " ");
			}
			i++;
		}

	}

//	@Test
	public void Ex_05() {
		System.out.println("Chương trình tính giai thừa của 1 số bất kì");
		System.out.print("--> Nhập 1 số tự nhiên n bất kỳ : ");
		int n = scanner.nextInt();
		int i = 1;

		while (1 <= n) {
			i *= n;
			n--;
		}
		System.out.println("n!= " + i);
	}

	@Test
	public void Ex_06() {
		System.out.println("Chương trình tính tổng các số chẵn từ 1 tới n");
		System.out.print("--> Nhập 1 số tự nhiên n bất kỳ : ");
		int n = scanner.nextInt();
		int i = 0;

		while (n > 0) {
			if (n % 2 == 0) {
				System.out.println(n);
				i += n;
			}
			n--;
		}
		System.out.println("tổng các số chẵn từ 1 tới số đã cho là " + i);
	}

}
