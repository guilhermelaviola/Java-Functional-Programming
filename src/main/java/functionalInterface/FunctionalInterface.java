package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

// Returning a number + itself (usual x functional way)
public class FunctionalInterface {
	public static void main(String[] args) {
		
		// Applying methods, Functions and BiFunctions that were implemented under this Main method block
		System.out.print("Adding number (usual way): ");
		int x = numberPlusItself(2);
		System.out.println(x);
		
		System.out.print("Adding number (functional way): ");
		int y = numberPlusItselfFunction.apply(2);
		System.out.println(y);
		
		System.out.print("Multiplying (usual way): ");
		int z = multiplyByItself(y);
		System.out.println(z);
		
		System.out.print("Multiplying (functional way): ");
		int w = addAndThenMultiply.apply(3);
		System.out.println(w);
		
		System.out.print("Incrementing and then multiplying (usual way): ");
		int a = incrementAndThenMultiply(2, 4);
		System.out.println(a);
		
		System.out.print("Incrementing and then multiplying (functional way - BiFunction): ");
		int b = incrementAndThenMultiplyBiFunction.apply(2, 3);
		System.out.println(b);
		
	}
	
	// Usual methods
	static int numberPlusItself(int x) {
		return x + x;
	}
	
	static int multiplyByItself(int x) {
		return x * x;
	}
	
	// Functional methods (Functions take 1 argument and return 1 result)
	static Function<Integer, Integer> numberPlusItselfFunction = x -> x + x;
	
	static Function<Integer, Integer> multiplyBy10Function = x -> x * 10;
	
	static Function<Integer, Integer> addAndThenMultiply = numberPlusItselfFunction.andThen(multiplyBy10Function);
	
	// BiFunction (they basically follow the same logic of the Function, but take 2 arguments and produce 1 result)
	static BiFunction<Integer, Integer, Integer> incrementAndThenMultiplyBiFunction =
			(numberToIncrement, numberToMultiplyBy) -> (numberToIncrement + 1) * numberToMultiplyBy;
	
	// Method with the same functionality presented in the BuFunction above		
	static int incrementAndThenMultiply (int num, int numToMultiplyBy) {
		return (num + 1) + numToMultiplyBy;
	}
}

