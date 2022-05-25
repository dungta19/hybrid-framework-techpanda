package javaBasic;

public class Topic_04_Operator {

	public static void main(String[] args) {
		// Assign (Gán)
		int time = 10;
		String name = "Fullstack Automation";
		boolean value = false;
		System.out.println("Time = " + time);
		System.out.println("Name = " + name);
		System.out.println("Value = " + value);

		// Math
		int a, b = 15, c = 5;

		a = b + c;
		System.out.println("Tổng = " + a);

		a = b - c;
		System.out.println("Hiệu = " + a);

		a = b * c;
		System.out.println("Tích = " + a);

		a = b / c;
		System.out.println("Thương (lấy nguyên) = " + a);

		a = b % c;
		System.out.println("Thương (lấy Dư) = " + a);

		b++;
		System.out.println("Tăng 1 đơn vị = " + b);

		c--;
		System.out.println("Giảm 1 đơn vị = " + c);

		// Các lưu ý về ++ trước và sau biến
		System.out.println(b++); // in giá trị b = 16 trước sau đó tăng thêm 1 đơn vị cho b, kết quả = 17
		System.out.println(++b); // tăng giá trị b (17+1) trước, sau đó in ra console

		int firstVariable = 5, secondVariable = 7;
		int result;
		result = firstVariable++ + ++secondVariable - 8;
		System.out.println("Postfix variable =" + firstVariable);
		System.out.println("Prefix variable =" + secondVariable);
		// Result = Prefix - 8 + firstVariable
		System.out.println("Result = " + result);

		// ++ còn được sử dụng ở các hàm for
		for (int i = 0; i < 3; i++) {
			System.out.println(i);
		}

		// Relation
		// Compare 2 values
		int ten = 10;
		int twenty = 20;
		int thirty = 30;

		System.out.println("1. Lớn hơn = " + (ten > twenty));
		System.out.println("2. Lớn hơn hoặc bằng = " + (ten >= twenty));
		System.out.println("3. Nhỏ hơn = " + (thirty < twenty));
		System.out.println("4. Nhỏ hơn hoặc bằng = " + (thirty <= twenty));
		System.out.println("5. Bằng nhau = " + (thirty == twenty + ten));
		System.out.println("6. Khác Bằng = " + (thirty != twenty + ten));

		// Sử dụng cho hàm If
		String address = "Hồ Chí Minh";

		if (address != "Hà Nội") {
			System.out.println("Không phải Thủ Đô nước Việt Nam");
		} else {
			System.out.println("Thủ Đô nước Việt Nam");
		}

		// Logic
		boolean value_01 = true;
		boolean value_02 = false;

		System.out.println("Cả 2 đều đúng = " + (value_01 && value_02));
		System.out.println("Một trong 2 đúng = " + (value_01 || value_02));
		System.out.println("Phủ định của đúng = " + (!value_01));
		System.out.println("Phủ định của sai = " + (!value_02));

		// Condition
		int first = 10;
		int second = 20;
		int third = 30;
		boolean bValue;
		int iValue;

		bValue = (third == first + second) ? true : false;
		System.out.println("Giá trị = " + bValue);

		iValue = (third == second + first) ? 50 : 100;
		System.out.println("Ket qua = " + iValue);

		iValue = (!(third == second + first)) ? 50 : 100;
		System.out.println("Phủ định Ket qua = " + iValue);
	}

}
