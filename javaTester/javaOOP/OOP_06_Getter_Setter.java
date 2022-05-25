package javaOOP;

public class OOP_06_Getter_Setter {
	private String personName;
	private int personAge;
	private int personPhone;
	private float personBankAccountAmount;

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		if (personName == null | personName.isEmpty()) {
			throw new IllegalArgumentException("Tên nhập vào không được bỏ trống!");
		} else {
			this.personName = personName;
		}
	}

	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		if (personAge > 0 && personAge < 120) {
			throw new IllegalArgumentException("Tuổi không hợp lệ!");
		} else {
			this.personAge = personAge;
		}
	}

	public int getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(int personPhone) {
		if (!String.valueOf(personPhone).startsWith("0")) {
			throw new IllegalArgumentException("Số điện thoại không đúng!");
		} else if (personPhone < 10 || personPhone > 11) {
			throw new IllegalArgumentException("Số điện thoại phải có 10 số!");
		} else {
			this.personPhone = personPhone;
		}
	}

	public float getPersonBankAccountAmount() {
		return personBankAccountAmount;
	}

	public void setPersonBankAccountAmount(float personBankAccountAmount) {
		this.personBankAccountAmount = personBankAccountAmount;
	}

}
