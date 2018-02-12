package datastructure;

import java.util.ArrayList;

public class PetRegistry<T extends Pet> {
	Pet[] pets = new Pet[10];
	private String[] owners = new String[10];
	
	public boolean addPet(String owner, T pet) {
		//index of the owner
		int indexOfOwner = -1;
		//finding the index to insert the owner
		for(int i = 0; i < owners.length; i++) {
			//finding the first empty index of the array
			if(owners[i] == null) {
				owners[i] = owner;
				pets[i] = pet;
				indexOfOwner = i;
				break;
			}
		}
		//add the pet at the index of the owner
		if(indexOfOwner == -1) {
			System.out.println("Sorry the registry is full!");
			return false;
		} else {
			return true;
		}
	}
	
	public boolean removePet(Pet pet) {
		//index of the pet
		int indexOfPet = -1;
		//finding the pet from the pet array
		for(int i = 0; i < pets.length; i++) {
			//if we reach a not full array
			if(pets[i] == null) {
				break;
			}
			//when we find the pet
			if(pets[i] == pet) {
				pets[i] = null;
				owners[i] = null;
				indexOfPet = i;
				break;
			}
		}
		
		if(indexOfPet == -1) {
			return false;
		} else {
			return true;
		}
	}
	
	public ArrayList<Pet> getPet(String owner) {
		ArrayList<Pet> petsOfOwner = new ArrayList<Pet>();
		for(int i = 0; i < pets.length; i++) {
			//if we run into a not full pets array
			if(owners[i] == null) {
				break;
			}
			//if we find the owner we add the pet at that index
			if(owners[i].compareTo(owner) == 0) {
				petsOfOwner.add(pets[i]);
			}
		}
		return petsOfOwner;
	}
	
	public String getOwner(Pet pet) {
		int indexOfPet = -1;
		//find the index of the pet
		for(int i = 0; i < pets.length; i++) {
			//if we run into a not full array
			if(pets[i] == null) {
				break;
			}
			//if we find the pet
			if(pets[i] == pet) {
				indexOfPet = i;
				break;
			}
		}
		
		if(indexOfPet == -1) {
			System.out.println("Pet is not found!");
			return "";
		} else {
			return owners[indexOfPet];
		}
	}
	
	 
	public static void main(String[] args) {
		PetRegistry<Dog> r1 = new PetRegistry<Dog>();
		PetRegistry<Cat> r2 = new PetRegistry<Cat>();
		
		Cat c1 = new Cat();
		Dog d1 = new Dog();
		
		//adding a cat to dog registry
		r1.addPet("o1", c1);
		
		//adding a dog to a cat registry
		r2.addPet("o2", d1);
	}
	
}
