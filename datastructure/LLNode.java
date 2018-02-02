package datastructure;

public class LLNode<T> {
	private T element;
	private LLNode<T> next;
	
	public T getElement() {
		return element;
	}
	public void setElement(T element) {
		this.element = element;
	}
	public LLNode<T> getNext() {
		return next;
	}
	public void setNext(LLNode<T> next) {
		this.next = next;
	}
	
	
}
