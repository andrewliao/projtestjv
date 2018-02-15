package programmingassignment1;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class boolListDemo {
	public static void main(String[] args) throws Exception {
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
		
		
		boolLinkedList l2 = new boolLinkedList();
		l2.insert(0, false);
		l2.insert(0, true);
		l2.insert(0, true);
		System.out.println(boolToSigned(l2));
		
		
	}
	
	public static int boolToSigned(boolList lst) {
		String signedNumber = "";
		for(int i = lst.size() - 1; i > -1; i--) {
			if(lst.lookup(i) == false) {
				signedNumber += "0";
			} else {
				signedNumber += "1";
			}
		}
		
		int value = 0;
		int pow = 0;
		//a positive number
		if(signedNumber.charAt(0) == '0') {
			for(int i = signedNumber.length() - 1; i  > 0; i--) {
				if(signedNumber.charAt(i) == '1') {
					value += (int)Math.pow(2, pow);
				}
				pow++;
			}
		} else { //negative number
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
