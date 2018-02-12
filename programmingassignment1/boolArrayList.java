package programmingassignment1;

public class boolArrayList {
	
	private boolean[] list = new boolean[10];
	private int size = 0;
	
	
	public int size() {
		return this.size;
	}
	
	public void insert(int i, boolean value) {
		if(size() < i + 1) {
			list[size] = value;
		} else {
			boolean temp = list[i];
			for(int j = i; i < size(); i++) {
				list[j + 1] = list[j];
			}
			list[i] = temp;
			size++;
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
