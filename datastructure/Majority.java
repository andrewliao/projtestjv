package datastructure;

import java.util.ArrayList;
import java.util.HashMap;

public class Majority {
	
	public static void main(String[] args) {
		int[] array1 = {};
		System.out.println(findMajorityCandidate(array1));
	}
	
	//returns the majority element	
	public static int findMajorityCandidate(int[] array) {
		//store the candidate value
		int candidate = findCandidate(array);
		//returns -1 if there is no majority candidate or if the candidate
		//is not the majority element, otherwise we return the majority candidate
		if(candidate == -1) {
			return candidate;
		} else {
			if(isCandidateMajority(array, candidate)) {
				return candidate;
			} else {
				return -1;
			}
		}
	}
	
 
	//helper method to do the recursion and find the majority element candidate
	public static int findCandidate(int[] array) {
		//base case if length is one
		if(array.length == 1) {
			return array[0];
		} else if(array.length == 0) {//base case if length is 0
			return -1;
		} else {
			//counting the number of possible candidates
			int count = 0;
			for(int i = 0; i < array.length - 1; i+=2) {
				if(array[i] == array[i + 1]) {
					count++;
				}
			}
			
			//no candidate majority check even and odd
			if(count == 0 && array.length % 2 == 1) { //odd case, we return the last element
				return array[array.length - 1];
			} else if(count == 0) { //even case we return -1
				return -1;
			}
			
			//if we have found at least 2 majority candidates we need to create next array
			int[] nextArr = new int[count]; 
			int incrementOfNextArr = 0;
			//adding the candidates to the next array to test
			for(int i = 0; i < array.length - 1; i += 2) {
				if(array[i] == array[i+1]) {
					nextArr[incrementOfNextArr] = array[i];
					incrementOfNextArr++;
				}
			}
			//recursive case to find the majority element
			return findCandidate(nextArr);
		}
	}
	
	//helper method to test if the candidate is actually the majority element
	public static boolean isCandidateMajority(int[] array, int element) {
		//size of half of the array
		int sizeOfMajority = array.length / 2;
		//the number of times the element appears in the array
		int count = 0;
		//count the number of times the element appears in the array
		for(int i = 0; i < array.length; i++) {
			if(array[i] == element) {
				count++;
			}
		}
		
		if(count > sizeOfMajority) {
			return true;
		} else {
			return false;
		}
	}
	

	
	
	
	
	
	
	 //Non recursive
	 public static int majorityElement(int[] nums) {
		 	//creating a hashmap to store all integers
		 	HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		 	//majority will return -1 if there is no majority
			int majorityElement = -1;
			
			for(int i = 0; i < nums.length; i++) {
				//if the element is not seen before we add it to the hashmap
				if(!myMap.containsKey(nums[i])) {
					myMap.put(nums[i], 1);
				} else { //if it is seen before we increment it by one
					myMap.put(nums[i], myMap.get(nums[i]) + 1);
				}
				//we test after each iteration to see if the element at i is the majority element
				//if it is we change the majority element to the element at i and return that value
				//and break out of the loop.
				if(myMap.get(nums[i]) > nums.length / 2) {
					majorityElement = nums[i];
					break;
				}
			}
			
			return majorityElement;
		}
	 
	 public static void main(String[] args) {
			PetRegistry<Dog> r1 = new PetRegistry<Dog>();
			PetRegistry<Cat> r2 = new PetRegistry<Cat>();
			
			String o1 = "Mason";
			String o2 = "Stuart";
			
			Dog d1 = new Dog();
			d1.setName("Fluffy");
			d1.setGender("male-1");
			
			Dog d2 = new Dog();
			d2.setName("Fluffy");
			d2.setGender("male-2");
			
			Dog d3 = new Dog();
			d3.setName("Fluffy");
			d3.setGender("male-3");
			
			Dog d4 = new Dog();
			d4.setName("Fluffy");
			d4.setGender("male-4");
			
			Dog d5 = new Dog();
			d5.setName("Duke");
			d5.setGender("female");		
			
			//adding some dogs into the dog pet registry
			r1.addPet(o1, d1); //owner 1 has dogs with non unique names, with a gender string with a unique number
			r1.addPet(o2, d2); //owner 2 will have dogs with unique names
			r1.addPet(o1, d3);
			r1.addPet(o2, d5);
			
			//look up of a dog present in the registry, so we have to find the owner, for example use
			//of the input of d2 should produce o2 which is Stuart
			System.out.println(r1.getOwner(d2));
			
			//look up of a dog not present in the registry. for example we will use d4 which is not added
			//this will print out Pet is not found!
			System.out.println(r1.getOwner(d4));
			
			//look up of a dog in a cat registry; this should produce the same result as a lookup of a dog
			//not present in the registry. It will print out Pet is not found!
			System.out.println(r2.getOwner(d1));
			
			//owner with multiple dogs
			//getting a pet arraylist of Owner 2 which should have d2, d4
			//when we print it out it should have the name Fluffy, male-2,
			//Duke, female in that order
			ArrayList<Pet> l1 = r1.getPet(o2);
			//iterate through the array
			for(int i = 0; i < l1.size(); i++) {
				//printing out the name of the dog
				System.out.println(l1.get(i).getName());
				//printing out the gender which is unique to each pet, acts like an id
				System.out.println(l1.get(i).getGender());
			}
			
			System.out.println();
			
			
			//owner with multiple dogs with non unique names
			//getting a pet arraylist of Owner 1 which should have d1, d3
			//when we print it out it should have the name Fluffy, male-1,
			//Fluffy, male-3 in that order
			ArrayList<Pet> l2 = r1.getPet(o1);
			//iterate through the array
			for(int i = 0; i < l2.size(); i++) {
				//printing out the name of the dog
				System.out.println(l2.get(i).getName());
				//printing out the gender which is unique to each pet, acts like an id
				System.out.println(l2.get(i).getGender());
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
			
			Cat c1 = new Cat();
			c1.setName("Garfield");
			c1.setGender("male-11");
			
			Cat c2 = new Cat();
			c2.setName("Garfield");
			c2.setGender("male-12");
			
			Cat c3 = new Cat();
			c3.setName("Garfield");
			c3.setGender("male-13");
			
			Cat c4 = new Cat();
			c4.setName("Garfield");
			c4.setGender("male-14");
			
			Cat c5 = new Cat();
			c5.setName("Moon");
			c5.setGender("female");
			
			String o3 = "Yibin";
			String o4 = "Jon";
			
			//adding cats to the cat registry
			r2.addPet(o3, c1); //owner 3 has cats with non unique names, with a gender string with a unique number
			r2.addPet(o4, c2); //owner 4 will have cats with unique names
			r2.addPet(o3, c3);
			r2.addPet(o4, c5);
			
			//look up of a cat present in the registry, so we have to find the owner, for example use
			//of the input of c2 should produce o4 which is Jon
			System.out.println(r2.getOwner(c2));
					
			//look up of a cat not present in the registry. for example we will use c4 which is not added
			//this will print out Pet is not found!
			System.out.println(r2.getOwner(c4));
					
			//look up of a cat in a dog registry; this should produce the same result as a lookup of a dog
			//not present in the registry. It will print out Pet is not found!
			System.out.println(r1.getOwner(c1));
			
			//owner with multiple cats 
			//getting a pet arraylist of Owner 4 which should have c2, c5
			//when we print it out it should have the name Garfield, male-2,
			//Moon, female in that order
			ArrayList<Pet> l3 = r2.getPet(o4);
			//iterate through the array
			for(int i = 0; i < l3.size(); i++) {
				//printing out the name of the dog
				System.out.println(l3.get(i).getName());
				//printing out the gender which is unique to each pet, acts like an id
				System.out.println(l3.get(i).getGender());
			}
			System.out.println();
					
			//owner with multiple cats with the same name
			//getting a pet arraylist of Owner 3 which should have d1, d3
			//when we print it out it should have the name Garfield, male-1,
			//Garfield, male-3 in that order
			ArrayList<Pet> l4 = r2.getPet(o3);
			//iterate through the array
			for(int i = 0; i < l4.size(); i++) {
				//printing out the name of the dog
				System.out.println(l4.get(i).getName());
				//printing out the gender which is unique to each pet, acts like an id
				System.out.println(l4.get(i).getGender());
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
