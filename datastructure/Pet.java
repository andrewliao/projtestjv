package datastructure;

public class Pet<T, K>{
	private T name;
	private K gender;
	
	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}

	public K getGender() {
		return gender;
	}

	public void setGender(K gender) {
		this.gender = gender;
	}
	
	
}
