package datastructure;

public class PetRegistry<T extends Pet> {
	
	private T[] pets = new T[10];
	private String[] owners = new String[10];
	
	public T getPet(String owner) {
		
	}
	
	public String getOwner(Pet pet) {
		
	}
	
	public void addPet(String ownerName, Pet pet) {
		
	}
	
	public void remove() {
		
	}
	
	
	public static void main(String[] args) {
		Pet<String> x = new Pet<String>("Ad", "sd");
		System.out.println(x.getName());
		System.out.println(x.getGender());
		
		Dog y = new Dog("What the hell", "sdfds");
		System.out.println(y.getName());
		System.out.println(y.getGender());
		
	}
}
