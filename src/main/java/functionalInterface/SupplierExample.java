package functionalInterface;

import java.util.List;
import java.util.function.Supplier;

// A Supplier represents an operation that takes no argument and returns a result
public class SupplierExample {
	public static void main(String[] args) {
		// Usual method
		System.out.println("Usual method: ");
		System.out.println(getDBConnectionUrl());

		// With supplier
		System.out.println("With Supplier: ");
		System.out.println(getDBConnectionUrlSupplier.get());

		// Returning a List of databases with Supplier
		System.out.println("Returning a List of databases with Supplier: ");
		System.out.println(getDBConnectionUrlsSupplier.get());
	}

	// Usual method
	static String getDBConnectionUrl() {
		return "jdbc:mysql://myhost1:3306,myhost2:3307/human-resources";
	}

	// With Supplier
	static Supplier<String> getDBConnectionUrlSupplier = ()
			-> "jdbc:mysql://myhost1:3306,myhost2:3307/human-resources";	

			// Returning a list of URLs with Supplier
			static Supplier<List<String>> getDBConnectionUrlsSupplier = ()
					-> List.of(
							"jdbc:mysql://myhost1:3306,myhost2:3307/human-resources",
							"jdbc:mysql://myhost1:3306,myhost2:3307/sales",
							"jdbc:mysql://myhost1:3306,myhost2:3307/quality"
							);
}
