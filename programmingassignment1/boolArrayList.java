package programmingassignment1;


public class boolArrayList implements boolList{
	//this stores the default boolean array which can hold 10 elements
	private boolean[] list = new boolean[10];
	//the array starts with a size of 0
	private int size = 0;
	
	//this method returns the size of this boolArrayList
	//its worst case run time is O(1)
	public int size() {
		return this.size;
	}
	
	//this method inserts a boolean value into the boolArrayList
	//its worst case run time is O(n)
	public void insert(int i, boolean value) {
		/** We will double the size of the array if i is 
		 *  greater than the last element of the array or if 
		 *  we are inserting at the last element of a full array
		 */
		if(size() == list.length) {
			boolean[] temp = new boolean[list.length * 2];
			for(int j = 0; j < size(); j++) {
				temp[j] = list[i];
			}
			list = temp;
		}
		//if we are inserting at an index greater than the size of the array
		if(size() < i + 1) { 
			list[size()] = value;
		} else if(i == 0) {
			boolean[] temp = new boolean[list.length];
			for(int j = 1; j < size() + 1; j ++) {
				temp[j] = list[j - 1];
			}
			temp[0] = value;
			list = temp;
		}
		else {
			//we iterate from index i to the end of the filled array and shift the elements to the right
			for(int j = i; j < size(); j++) {
				list[j + 1] = list[j];
			}
			list[i] = value;
		}
		//we increment the array by a size of 1
		size++;
	}
	
	//this removes the boolean value at index i
	//its worst case run time is O(n)
	public void remove(int i) {
		//if there does not exist an element at index i we do nothing
		if(size() < i + 1) {
			return;
		} else {
			//we to shift all elements back one index from the point where we removed the element
			if(i == size()) {
				//this is the case when we are removing the last element of the array
				list[i] = false;
			} else {
				//we need to loop through and shift each element to the left
				for(int j = i; j < size(); j++) {
					if(j + 1 < size()) {
						list[j] = list[j + 1];
					} else {
						//if we need an element at an index after the array
						list[j] = false;
					}
				}
			}
			//after this we decrement the size of the boolArrayList by one
			size--;
		}
	}
	
	//this method looks up the boolean at index i
	//its worst case run time is O(1)
	public boolean lookup(int i) throws IndexOutOfBoundsException {
		//if we are trying to find an index larger than the size of the array
		if(size() < i + 1) {
			throw new IndexOutOfBoundsException();
		} else {
			return list[i];
		}
	}
	
	//this method will flip the values of the booleans elements in the boolArrayList
	//its worst case run time is O(n)
	public void negateAll() throws IllegalArgumentException {
		//if the size of the boolArrayList is 0
		if(size() == 0) {
			throw new IllegalArgumentException();
		} else {
			//we iterate through the boolArrayList and flip all the values 
			for(int i = 0; i < size(); i++) {
				list[i] = !list[i];
			}
		}
	}

	
}
