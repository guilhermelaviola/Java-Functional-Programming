package imperativeVSdeclarative;

//Animal class, its constructor and toString method
public class Animal {
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

