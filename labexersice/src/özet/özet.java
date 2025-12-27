package özet;

public class özet {
	
	
	
	
	
	
	
	
	public class DenemeException extends Exception{
		public DenemeException(String message) {
			super(message);
		}
	}

	
	try {
		if(5 > 8) {
			throw new DenemeException("error");
		}
		
	}catch(DenemeException e) {
		System.out.println(e.getMessage());
	}
	
	public int hashCode() {
		return Integer.hashCode(id);
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Student student) {
			return this.id == student.id;
		}
		
		return false;
	}
	
	if(animal instanceof Dog) {
		Dog dog = (Dog) animal;
		dog.fetcBall();
	}
	
	public int compareTo(Student student) {
		if(this.id > student.id) {
			return 1;
		}else if(this.id < student.id) {
			return -1;
		}else {
			return 0;
		}
	}
	package exerciseTwo;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Locale;
	import java.util.Set;
	import java.util.stream.Collectors;

	public class AppTest {

		public static void main(String[] args) {
			Locale.setDefault(Locale.ENGLISH);
			
			List<String> names = new ArrayList<>();
			names.add("Alex");
			names.add("Kevin");
			names.add("Alex");
			names.add("Alice");
			names.add("Sarah");
			names.add("Daniel");
			names.add("Samantha");
			
			// display the names that starts with A
			System.out.println("Names that starts with A: ");
			names.stream()
		     .filter(name -> name.startsWith("A"))
		     .forEach(System.out::println);
			
			// convert the names to uppercase letters and store them in a new Set
			System.out.println("\nSet with uppercase letters: ");
			Set<String> upperCaseNames = names.stream()
	                .map(String::toUpperCase)
	                .collect(Collectors.toSet());

			System.out.println(upperCaseNames);
			
			// display the first three unique names
			System.out.println("\nFirst three unique names: ");
			names.stream()
		     .distinct()
		     .limit(3)
		     .forEach(System.out::println);
			
			// convert the names longer than 6 characters to lowercase and store them in a new List
			System.out.println("\nLowercase names longer than 6 characters: ");
			List<String> longNames = names.stream()
	                .filter(name -> name.length() > 6)
	                .map(String::toLowerCase)
	                .collect(Collectors.toList());

			System.out.println(longNames);
		}

	}
	
	
	
	
	
	

}
