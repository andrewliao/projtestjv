import javax.swing.JFrame;

public class GeometricFrame extends JFrame {

	//field to remember window title
	private String savedTitle;

	//transpose the window return no value
	public void transpose() {
		int h = this.getHeight();
		int w = this.getWidth();
		this.setSize(h, w);
	}

	//scale the size of the window
	public void scale(double factor) {
		this.setSize((int)(factor * this.getWidth()), 
			(int)(factor * this.getHeight()));
	}

	//override the setTitle method so that it remembers the title set in the field savedTitle
	public void setTitle(String title) {
		this.savedTitle = title;
		//set the title by calling the parent class version of the method
		super.setTitle(title);
	}


	public void addDimensionToTitle(boolean addToTitle) {
		if (addToTitle) {
			int h = this.getHeight();
			int w = this.getWidth();
			super.setTitle(this.savedTitle + "(" + w + "x" + h + ")");
		} else {
			super.setTitle(this.savedTitle);
		}
	}
}