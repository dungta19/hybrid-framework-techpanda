package javaBasic;

public class Topic_05_Casting_Type {
	public static void main(String[] args) {
		// Ép kiểu ngầm định (không mất dữ liệu)
		System.out.println("<---------------------------------Ép kiểu ngầm định--------------------------------->");
		byte bNumber = 126;
		System.out.println(bNumber);

		short sNmuber = bNumber;
		System.out.println(sNmuber);

		int iNumber = sNmuber;
		System.out.println(iNumber);

		long lNumber = iNumber;
		System.out.println(lNumber);

		float fNumber = lNumber;
		System.out.println(fNumber);

		double dNumber = fNumber;
		System.out.println(dNumber);

		// Ép kiểu tường minh
		System.out.println("<---------------------------------Ép kiểu tường minh--------------------------------->");
		double dValue = 654321759;
		System.out.println(dValue);

		float fValue = (float) dValue;
		System.out.println(fValue);

		long lValue = (long) fValue;
		System.out.println(lValue);

		int iValue = (int) lValue;
		System.out.println(iValue);

		System.out.println("<---------------------------------Ép kiểu tham chiếu--------------------------------->");
		Topic_05_Casting_Type firstStudent = new Topic_05_Casting_Type();
		Topic_05_Casting_Type secondStudent = new Topic_05_Casting_Type();
		
		firstStudent.setStudentName("Bui Minh Tuan");
		secondStudent.setStudentName("Le Trung Tin");
		
		// Ép kiểu tham chiếu
		firstStudent = secondStudent;
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();
		
		secondStudent.setStudentName("Nguyen Minh Hau");
		
		firstStudent.showStudentName();
		secondStudent.showStudentName();

	}
	public String studentName;
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void showStudentName() {
		System.out.println("Student name = " + studentName);
	}
	
}
