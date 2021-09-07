package combinatorpattern;

import java.time.LocalDate;

// Student class with its constructor and getters
public class Student {
	private String name;
	private String email;
	private String phoneNumber;
	private LocalDate dob;

	public Student(String name, String email, String phoneNumber, LocalDate dob) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public LocalDate getDob() {
		return dob;
	}
}
