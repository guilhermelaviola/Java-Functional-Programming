package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class StudentValidatorService {
	
	// If the email contains a '@', then it's validated
	private boolean isEmailValid (String email) {
		return email.contains("@");
	}
	
	// If the phone number starts with '55', then it's validated
	private boolean isPhoneNumberValid (String phoneNumber) {
		return phoneNumber.startsWith("55");
	}
	
	// If the student is over 18, then it's considered an adult, so it's validated
	public boolean isStudentAdult (LocalDate dob) {
		return Period.between(dob, LocalDate.now()).getYears() > 18;
	}
	
	// If all the previous validations are okay, then the student is validated
	public boolean isStudentValid (Student student) {
		return isEmailValid(student.getEmail()) &&
				isPhoneNumberValid(student.getPhoneNumber()) &&
				isStudentAdult(student.getDob());
	}
}
