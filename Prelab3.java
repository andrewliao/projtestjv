import javax.swing.JFrame;

public class Prelab3 extends JFrame {

	//a method to multiply
	public double multiply(double x, double y) {
		return x * y;
	}
	
	public static void main(String[] args) {
		Prelab3 m1 = new Prelab3();
		m1.setVisible(true);
		m1.setSize(500, 500);
		System.out.println(m1.multiply(10, 20));
		JFrame f = m1;
		f.setTitle("My window");
		System.out.println(((Prelab3)f).multiply(30, 5));


	}
}