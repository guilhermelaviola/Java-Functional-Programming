package streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// A stream is a sequence of objects that supports various methods which can be pipelined to produce the desired result.
// The features of Java stream are – A stream is not a data structure instead it takes input from the Collections,
// Arrays or I/O channels
public class StreamExample {
	public static void main(String[] args) {
		// Creating a list of mammals
		List<Animal> mammals = List.of(
				new Animal("Cow", Gender.MALE),
				new Animal("Goat", Gender.FEMALE),
				new Animal("Hog", Gender.FEMALE),
				new Animal("Horse", Gender.MALE)
				);
		
		System.out.println("Printing the animal's genders:");
		mammals.stream()
		// Mapping animals by gender
		.map(animal -> animal.gender)
		.collect(Collectors.toSet())
		// Printing the animal's genders
		.forEach(gender -> System.out.println(gender));
		
		
		// Checking whether mammals list contains ONLY females
		System.out.println("Checking whether mammals list contains ONLY females:");
		Predicate<Animal> animalPredicate = animal -> Gender.FEMALE.equals(animal.gender); 
		
		boolean containsOnlyFemales = mammals.stream()
				.noneMatch(animalPredicate);
		
		System.out.println(containsOnlyFemales);
	}
	//Animal class, constructor and toString method
	static class Animal {
		private final String name;
		final Gender gender;

		public Animal(String name, Gender gender) {
			this.name = name;
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Animal [name=" + name + ", gender=" + gender + "]";
		}
	}

	// Enum to create gender possibilities
	enum Gender{
		MALE, FEMALE 
	}
}
