package programmingassignment1;

public class boolLinkedList {
	//this holds the first boolLinkedListNode in the boolLinkedList
	private boolLinkedListNode head;
	//this is the default size of the boolLinkedList
	private int size = 0;
	
	//this returns the size of the boolLinkedList
	public int size() {
		return this.size;
	}
	
	//
	public void insert(int i, boolean value) {
		//if this is the first element we are inserting we need to create a head
		if(size() == 0) {
			head = new boolLinkedListNode(value);
		} else if(size() < i + 1) { //if the sequence has fewer than i than i + 1 elements we add the new boolLinkedListNode to the end of the list
			boolLinkedListNode temp = head.getNext();
			for(i = 0; i < size(); i++) {
				temp = temp.getNext();
			}
			temp.setNext(new boolLinkedListNode(value));
		} else {
			boolLinkedListNode temp = head;
			for(int j = 0; j < i; i++) {
				temp = temp.getNext();
			}
			if(temp.getNext() != null) {
				temp.getNext().setPrev(new boolLinkedListNode(value));
				temp.setNext(temp.getNext().getPrev());
			} else {
				temp.setNext(new boolLinkedListNode(value));
			}
		}
		size++;
	}
	
	public void remove(int i) throws Exception {
		if(size() < i + 1) {
			return;
		} else {
			boolLinkedListNode temp = head;
			if(i != size() - 1) {
				for(int j = i; j < size(); j++) {
					temp = temp.getNext();
				}
				temp.setNext(temp.getNext().getNext());
				temp.getNext().setPrev(temp);
			} else {
				temp.setNext(null);
			}
			size--;
		}
	}
	
	//this returns the value of the boolean stored in ith boolLinkedListNode
	public boolean lookup(int i) throws Exception {
		//if the i element is greater than the size of the array we must throw an exception as it is not possible to remove the element
		if(size() < (i + 1)) {
			throw new Exception();
		} else {
			//this sets the starting point
			boolLinkedListNode temp = head;
			//we must iterate until we reach the index of i
			for(int j = 0; j < i; j++) {
				temp = temp.getNext();
			}
			//we return the value of the ith boolLinkedListNode
			return temp.getValue();
		}
	}
	
	//this reverses the value boolean elements of the boolLinkedListNodes in the boolLinkedList 
	public void negateAll() throws Exception {
		//we check to make sure that there is at least one boolLinkedListNode in the boolLinkedList
		if(size() == 0) {
			throw new Exception();
		} else {
			//we must iterate through the entire boolLinkedList and flip the value of the boolean
			boolLinkedListNode temp = head;
			for(int i = 0; i < size(); i++) {
				temp = temp.getNext();
				temp.setValue(!temp.getValue());
			}
		}
	}
}
