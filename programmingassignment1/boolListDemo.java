package programmingassignment1;


public class boolListDemo {
	
	public static void main(String[] args) throws Exception {
		// creating a boolAraryList and testing its boolToSigned
		boolArrayList l1 = new boolArrayList();
		l1.insert(0, true);
		l1.insert(0, true);
		l1.insert(0, true);
		l1.insert(0, false);
		System.out.println(l1.lookup(0));
		System.out.println(l1.lookup(1));
		System.out.println(l1.lookup(2));
		System.out.println(l1.lookup(3));
		System.out.println(boolToSigned(l1));
		
		// creating a boolLinkedList and testing its boolToSigned
		boolLinkedList l2 = new boolLinkedList();
		l2.insert(0, false);
		l2.insert(0, true);
		l2.insert(0, true);
		System.out.println(boolToSigned(l2));
		
		
	}
	
	// This method creates a two's complement binary number from a boolList and returns the decimal equivalent
	//the worst running time for this method is O(n)
	public static int boolToSigned(boolList lst) {
		//the variable to store the two's complement of the boolean list
		String signedNumber = "";
		//we need to iterate and add 0 or 1 for each element depending on its value
		for(int i = lst.size() - 1; i > -1; i--) {
			if(lst.lookup(i) == false) {
				signedNumber += "0";
			} else {
				signedNumber += "1";
			}
		}
		
		//this stores the decimal value of the two's complement
		int value = 0;
		//this variable is what the power of two we are currently on
		int pow = 0;
		//a positive number where it starts with 0
		if(signedNumber.charAt(0) == '0') {
			//we iterate the entire string and add 2 to the power of the index starting from 0
			for(int i = signedNumber.length() - 1; i  > 0; i--) {
				if(signedNumber.charAt(i) == '1') {
					value += (int)Math.pow(2, pow);
				}
				pow++;
			}
		} else { //negative number where it starts with 1
			//we iterate the entire string and add 2 to the power of the index starting from 0
			//for the starting value of 1 we need to multiply its magnitude with -1
			for(int i = signedNumber.length() - 1; i  > 0; i--) {
				if(signedNumber.charAt(i) == '1') {
					value += (int)Math.pow(2, pow);
				}
				pow++;
			}
			value += (-1 * (int)Math.pow(2, pow));
		}
		return value;
	}
	


}
