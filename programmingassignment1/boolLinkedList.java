package programmingassignment1;

public class boolLinkedList {
	private boolLinkedListNode head;
	private int size = 0;
	
	public int size() {
		return this.size;
	}
	
	public void insert(int i, boolean value) {
		if(size() < i + 1) {
			boolLinkedListNode temp = head.getNext();
			for(i = 0; i < size(); i++) {
				temp = temp.getNext();
			}
			temp = new boolLinkedListNode(value);
		} else {
			boolLinkedListNode temp = head;
			for(int j = 0; j < i; i++) {
				temp = temp.getNext();
			}
			boolLinkedListNode temp2 = temp.getNext();
			
			
		}
	}
	
	public void remove(int i) throws Exception {
		if(size() < i + 1) {
			return;
		} else {
			for(int j = i; j < size(); j++) {
				list[j] = list[j + 1];
				size--;
			}
		}
	}
	
	public boolean lookup(int i) throws Exception {
		if(size() < (i + 1)) {
			throw new Exception();
		} else {
			return list[i + 1];
		}
	}
	
	public void negateAll() throws Exception {
		if(size() == 0) {
			throw new Exception();
		} else {
			for(int i = 0; i < size() / 2; i++) {
				list[i] = !list[i];
			}
		}
	}
}
