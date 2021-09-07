package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

// A Consumer represents an operation that accepts a single input argument and returns no result
public class ConsumerExample {

	public static void main(String[] args) {
		// Creating the User object
		User derek = new User("Derek", "pass", "999182819172");

		// Usual method
		System.out.println("Usual method:");
		greetUser(derek);

		// Consumer
		System.out.println("Consumer method:");
		greetUserConsumer.accept(derek);

		// BiConsumer
		System.out.println("BiConsumer method:");
		showPassword.accept(derek, false);
	}

	// The Consumer takes 1 argument and doesn't return anything. It works as a void() method
	static Consumer<User> greetUserConsumer = user ->
	System.out.println("Hello " + user.username + "! Thank you for being a part of us! " + "We just sent you a verification code to the number " + user.phoneNumber + ".");

	// The BiConsumer takes 2 arguments and doesn't return anything, just like Consumer
	static BiConsumer<User, Boolean> showPassword = (user, showPass) ->
	System.out.println("Hello " + user.username + "! Your password is " + (showPass ? user.password : "********"));

	static void greetUser(User user) {
		System.out.println("Hello " + user.username + "! Thank you for being a part of us! " + "We just sent you a verification code to the number " + user.phoneNumber + ".");
	}

	// User class
	static class User{
		private String username;
		private String password;
		private String phoneNumber;

		// Constructor
		public User(String username, String password, String phoneNumber) {
			this.username = username;
			this.password = password;
			this.phoneNumber = phoneNumber;
		}
	}
}
