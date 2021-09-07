package optionals;

import java.util.Optional;

// Optional is a container object used to contain not-null objects.
// Optional object is used to represent null with absent value.
// This class has various utility methods to facilitate code to handle values as 'available' or
// 'not available' instead of checking null values.
public class OptionalExample {
	public static void main(String[] args) {
		// Implementing an Optional. The message saying that the email is being sent will only be displayed if the email is not null
		Optional.ofNullable("email@email.com")
		.ifPresentOrElse(
				email -> System.out.println("Sending email to " + email),
				() -> System.out.println("It's not possible to send the email...")
				);
	}
}
