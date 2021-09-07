package imperativeVSdeclarative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// With an imperative approach, a developer writes code that specifies the steps that the computer must take
// to accomplish the goal. This is sometimes referred to as algorithmic programming.
// On the other hand, the functional approach involves composing the problem as a set of functions to be executed.

public class ImperativeVsDeclarative {
	public static void main(String[] args) {

		// Creating a list of mammals
		List<Animal> mammals = List.of(
				new Animal("Cow", Gender.MALE),
				new Animal("Goat", Gender.FEMALE),
				new Animal("Hog", Gender.FEMALE),
				new Animal("Horse", Gender.MALE)
				);

		// Imperative approach
		System.out.println("IMPERATIVE APPROACH:");
		
		// Creating and printing list of females only
		List<Animal> femalesI = new ArrayList<>();

		for(Animal animal : mammals) {
			if(Gender.FEMALE.equals(animal.gender)) {
				femalesI.add(animal);
			}
		}		
		for(Animal female : femalesI) {
			System.out.println(female);
		}

		// Declarative approach for the same functionality implemented above
		System.out.println("DECLARATIVE APPROACH:");
		List<Animal> femalesD = mammals.stream()
				.filter(animal -> Gender.FEMALE.equals(animal.gender))
				.collect(Collectors.toList());
		femalesD.forEach(System.out::println);
	}
}
