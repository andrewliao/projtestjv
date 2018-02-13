package programmingassignment1;

public class boolLinkedList{
	//this holds the first boolLinkedListNode in the boolLinkedList
	private boolLinkedListNode head;
	//this is the default size of the boolLinkedList
	private int size = 0;
	
	//this returns the size of the boolLinkedList
	public int size() {
		return this.size;
	}
	
	//this method inserts a new node to be the ith node of the list
	public void insert(int i, boolean value) {
		//if this is the first node of the boolLinkedList
		if(size() == 0) {
			head = new boolLinkedListNode(value);
		} else if(size() < i + 1) { //if sequence has fewer than i + 1 elements
			boolLinkedListNode temp = head;
			//iterate until one before the ith element of the list
			for(int j = 0; j < size() - 1; j++) {
				temp = temp.getNext();
			}
			temp.setNext(new boolLinkedListNode(value));
			temp.getNext().setPrev(temp);
		} else {
			boolLinkedListNode temp = head;
			for(int j = 0; j < i - 1; j++) {
				temp = temp.getNext();
			}
			//check if we are in the front
			if(temp == head) {
				boolLinkedListNode insertNode = new boolLinkedListNode(value);
				insertNode.setNext(temp);
				temp.setPrev(insertNode);
				head = insertNode;
			} else {
				boolLinkedListNode insertNode = new boolLinkedListNode(value);
				insertNode.setNext(temp);
				insertNode.setPrev(temp.getPrev());
				temp.getPrev().setNext(insertNode);
				temp.setPrev(insertNode);
			}
		}
		size++;
	}
	
	//this method removes the ith node of the list
	public void remove(int i) throws Exception {
		//if we try to remove an element that is more than the size of the linkedlist
		if(size() < i + 1) {
			return;
		} else {
			//if we want to remove the first element
			if(i == 0) {
				head = head.getNext();
			} else {
				boolLinkedListNode temp = head;
				for(int j = 0; j < i - 1; j++) {
					temp = temp.getNext();
				}
				if(temp.getNext().getNext() == null) {
					temp.setNext(null);
				} else {
					temp.setNext(temp.getNext().getNext());
					temp.getNext().setPrev(temp);
				}
			}
		}
		size--;
	}
	
	//this returns the value of the boolean stored in ith boolLinkedListNode
	public boolean lookup(int i) throws Exception {
		//if the i element is greater than the size of the array we must throw an exception as it is not possible to remove the element
		if(size() < i) {
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
				temp.setValue(!temp.getValue());
				temp = temp.getNext();
			}
		}
	}
	

	
}
