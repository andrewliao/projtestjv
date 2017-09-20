public class Book {
	protected int pages = 1500;
	public int x;
	public int y;

	

	public Book(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setPages(int numPages) {
		pages = numPages;
	}

	public int getPages(){
		return pages;
	}
}