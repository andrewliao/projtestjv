package datastructure;

public class PetRegistry<T extends Pet<V, K>> {
	
	private T[] pets;
	private String[] owners = new String[10];
	
	public PetRegistry(T typeOfPet) {
		this.pets = new T[10];
	}
	
	
	public T[] getPets() {
		return pets;
	}


	public void setPets(T[] pets) {
		this.pets = pets;
	}


	public String[] getOwners() {
		return owners;
	}


	public void setOwners(String[] owners) {
		this.owners = owners;
	}


	public T getPet(String owner) {
		
	}
	
	public String getOwner(T pet) {
		
	}
	
	public void addPet(String ownerName,T pet) {
		
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
