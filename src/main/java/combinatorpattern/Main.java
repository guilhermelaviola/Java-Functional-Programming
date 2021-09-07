package combinatorpattern;

import java.time.LocalDate;
import combinatorpattern.StudentRegistrationValidator.ValidationResult;

public class Main {
	public static void main(String[] args) {
		
		// Creating Student object
		Student student = new Student(
				"Amanda Smith",
				"amandasmith06@gmail.com",
				"559283786363",
				LocalDate.of(2006, 02, 01)
				);
		// Validating student (usual method)
		System.out.println("Validating student (usual method):");
		System.out.println(new StudentValidatorService().isStudentValid(student));

		// Validating student implementing combination pattern (functional method)
		System.out.println("Validating student (with combinator pattern):");
		
		// Applying the 3 necessary verifications on the student in order ti validate it
		ValidationResult result = StudentRegistrationValidator.isEmailValid()
				.and(StudentRegistrationValidator.isPhoneNumberValid())
				.and(StudentRegistrationValidator.isStudentAdult())
				.apply(student);
		
		System.out.println(result);
		
		// If the student can't be validated, then an exception will be thrown
		if (result != ValidationResult.SUCCESS) {
			throw new IllegalStateException(result.name());
		}
	}
}
