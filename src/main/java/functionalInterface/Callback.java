package functionalInterface;

import java.util.function.Consumer;

public class Callback {
	
	public static void main(String[] args) {
		
		// invoking displayConsumer()
		System.out.println("Invoking displayConsumer():");
		displayConsumer("Eden", null, value -> {
			System.out.println("Last name not provided for " + value);
		});

		// invoking displayRunnable()
		System.out.println("Invoking displayRunnable():");
		displayRunnable("Eden", null, () -> {
			System.out.println("Last name not provided.");
		});
	}

	// implementing display() with Consumer
	static void displayConsumer(String firstName, String lastName, Consumer<String> callback) {
		System.out.println(firstName);
		if(lastName != null) {
			System.out.println(lastName);
		}else {
			callback.accept(firstName);
		}
	}

	// implementing display() with Runnable
	static void displayRunnable(String firstName, String lastName, Runnable callback) {
		System.out.println(firstName);
		if(lastName != null) {
			System.out.println(lastName);
		}else {
			callback.run();
		}
	}
}

