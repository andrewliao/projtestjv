package programmingassignment1;


public class boolLinkedList implements boolList{
	//this holds the first boolLinkedListNode in the boolLinkedList
	private boolLinkedListNode head;
	//this is the default size of the boolLinkedList
	private int size = 0;
	
	//this returns the size of the boolLinkedList
	//its worst running time is 0(1)
	public int size() {
		return this.size;
	}
	
	//this method inserts a new node to be the ith node of the list
	//its worst running time is O(n)
	public void insert(int i, boolean value) throws IndexOutOfBoundsException {
		//if we try to insert at a negative number
		if(i < 0) {
			throw new IndexOutOfBoundsException();
		}
		//if this is the first node of the boolLinkedList
		if(size() == 0) {
			head = new boolLinkedListNode(value);
		}
		else if(size() < i + 1) { //if sequence has fewer than i + 1 elements
			boolLinkedListNode temp = head;
			//iterate until one before the ith element of the list
			for(int j = 0; j < size() - 1; j++) {
				temp = temp.getNext();
			}
			//need to set the next and the previous node for the new inserted node
			temp.setNext(new boolLinkedListNode(value));
			temp.getNext().setPrev(temp);
		} 
		else {
			//need to iterate and find the starting point for our new node
			boolLinkedListNode temp = head;
			for(int j = 0; j < i - 1; j++) {
				temp = temp.getNext();
			}
			//check if we are in the front and if it is we set the new node as the head
			if(temp == head) {
				boolLinkedListNode insertNode = new boolLinkedListNode(value);
				insertNode.setNext(temp);
				temp.setPrev(insertNode);
				head = insertNode;
			} else {
				//we just set make sure that our 
				boolLinkedListNode insertNode = new boolLinkedListNode(value);
				insertNode.setNext(temp);
				insertNode.setPrev(temp.getPrev());
				temp.getPrev().setNext(insertNode);
				temp.setPrev(insertNode);
			}
		}
		//we increment the size by one 
		size++;
	}
	
	//this method removes the ith node of the list
	public void remove(int i) {
		//if we try to remove an element that is more than the size of the linkedlist or if the number a negative index
		if(size() < i + 1 || i < 0) {
			return;
		} else {
			//if we want to remove the first element
			if(i == 0) {
				head = head.getNext();
			} else {
				//we nned to find which node to remove
				boolLinkedListNode temp = head;
				for(int j = 0; j < i - 1; j++) {
					temp = temp.getNext();
				}
				//we need to check if the remove node has a next node or not
				if(temp.getNext().getNext() == null) {
					temp.setNext(null);
				} else {
					//if it does have one we want to set our temp to be the deleted nodes next node
					temp.setNext(temp.getNext().getNext());
					temp.getNext().setPrev(temp);
				}
			}
		}
		//decrement the size by one
		size--;
	}
	
	//this returns the value of the boolean stored in ith boolLinkedListNode
	//the worst running time is O(n)
	public boolean lookup(int i) throws IndexOutOfBoundsException {
		//if the i element is greater than the size of the array we must throw an exception as it is not possible to remove the element
		if(size() <= i || i < 0) {
			throw new IndexOutOfBoundsException();
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
	//the worst running time is O(n)
	public void negateAll() throws IllegalArgumentException {
		//we check to make sure that there is at least one boolLinkedListNode in the boolLinkedList
		if(size() == 0) {
			throw new IllegalArgumentException();
		} else {
			//we must iterate through the entire boolLinkedList and flip the value of the boolean
			boolLinkedListNode temp = head;
			for(int i = 0; i < size(); i++) {
				temp.setValue(!temp.getValue());
				temp = temp.getNext();
			}
		}
	}

	

	
}
