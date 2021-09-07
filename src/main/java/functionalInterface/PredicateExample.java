package functionalInterface;

import java.util.function.Predicate;

// A Predicate accepts an argument and returns a boolean
public class PredicateExample {
	
	public static void main(String[] args) {
		
		// Checking is password is valid (usual method)
		System.out.println("Usual method: ");
		System.out.println(isPasswordValid("weueusn21"));
		System.out.println(isPasswordValid("33u7wu"));
		System.out.println(isPasswordValid("98967656"));
		
		// Predicate
		System.out.println("Predicate method: ");
		System.out.println(isPasswordValidPredicate.test("weueusn21"));
		System.out.println(isPasswordValidPredicate.test("33u7wu"));
		System.out.println(isPasswordValidPredicate.test("98967656"));
		
		// Using multiple Predicates together
		System.out.println(
				"Is password valid and contains number 9? " + 
				isPasswordValidPredicate.and(containsNumber9Predicate).test("weueusn21")
				);
		
		System.out.println(
				"Is password valid and contains number 9? " + 
				isPasswordValidPredicate.and(containsNumber9Predicate).test("33u7wu")
				);
		
		System.out.println(
				"Is password valid and contains number 9? " + 
				isPasswordValidPredicate.and(containsNumber9Predicate).test("98967656")
				);
	}
	
	// Usual method
	static boolean isPasswordValid(String password) {
		return password.length() == 8;
	}
	
	// Predicates
	static Predicate<String> isPasswordValidPredicate = password ->
	password.length() == 8;
	
	static Predicate<String> containsNumber9Predicate = password ->
	password.contains("9");
}
