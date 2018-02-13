package programmingassignment1;

public class boolArrayList {
	//this stores the default boolean array which can hold 10 elements
	private boolean[] list = new boolean[10];
	//the array starts with a size of 0
	private int size = 0;
	
	//this method returns the size of this boolArrayList
	public int size() {
		return this.size;
	}
	
	//this method inserts a boolean value into the boolArrayList
	public void insert(int i, boolean value) {
		/** We will double the size of the array if i is 
		 *  greater than the last element of the array or if 
		 *  we are inserting at the last element of a full array
		 */
		if(size() == list.length || i > list.length - 1) {
			boolean[] temp = new boolean[list.length * 2];
			for(int j = 0; j < size(); j++) {
				temp[j] = list[i];
			}
			list = temp;
		}
		// if the size of the sequence than i + 1 elements, we insert it at the last element in the sequence
		if(size() < i + 1) {
			list[size] = value;
		} else {
			//we shift everything to the right by one index from the point we insert the new boolean at index i
			boolean temp = list[i];
			for(int j = i; i < size(); i++) {
				list[j + 1] = list[j];
			}
			list[i] = temp;
		}
		//we increment the size of the boolArrayList by one
		size++;
	}
	
	//this removes the boolean value at index i
	public void remove(int i) {
		//if there does not exist an element at index i we do nothing
		if(size() < i + 1) {
			return;
		} else {
			//we to shift all elements back one index from the point where we removed the element
			if(i != size() - 1) {
				for(int j = i; j < size(); j++) {
					list[j] = list[j + 1];
				}
			} else {
				//this is the case when we are removing the last element of the array
				list[i] = false;
			}
			//after this we decrement the size of the boolArrayList by one
			size--;
		}
	}
	
	//this method looks up the boolean at index i
	public boolean lookup(int i) throws Exception {
		if(size() < (i + 1)) {
			throw new Exception();
		} else {
			return list[i + 1];
		}
	}
	
	//this method will flip the values of the booleans elements in the boolArrayList
	public void negateAll() throws Exception {
		if(size() == 0) {
			throw new Exception();
		} else {
			for(int i = 0; i < size(); i++) {
				list[i] = !list[i];
			}
		}
	}
}
