package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

// Implementing combination pattern
import static combinatorpattern.StudentRegistrationValidator.*;

// Interface that extends Function class and have Student as input and ValidationResult as output
public interface StudentRegistrationValidator extends Function<Student, ValidationResult>{
	
	// If the email contains a '@', then it's validated
	static StudentRegistrationValidator isEmailValid () {
		return student -> student.getEmail().contains("@") ?
				ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
	}
	
	// If the phone number starts with '55', then it's validated
	static StudentRegistrationValidator isPhoneNumberValid () {
		return student -> student.getPhoneNumber().startsWith("55") ?
				ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
	}
	
	// If the student is over 18, then it's considered an adult, so it's validated
	static StudentRegistrationValidator isStudentAdult () {
		return student -> Period.between(student.getDob(), LocalDate.now()).getYears() > 18 ?
				ValidationResult.SUCCESS : ValidationResult.IS_NOT_AN_ADULT;
	}
	
	default StudentRegistrationValidator and (StudentRegistrationValidator other) {
		return student -> {
			ValidationResult result = this.apply(student);
			return result.equals(ValidationResult.SUCCESS) ? other.apply(student) : result;
		};
	}
	
	// Enum with the possibilities of validation result
	enum ValidationResult{
		SUCCESS,
		PHONE_NUMBER_NOT_VALID,
		EMAIL_NOT_VALID,
		IS_NOT_AN_ADULT
	}
}
