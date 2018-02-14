package programmingassignment1;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class boolListDemo {
	public static void main(String[] args) throws Exception {
		System.out.println("insert");
		 Boolean[] seq0 = new Boolean[] {false, false, true, false}; 
        boolLinkedList instance0 = new boolLinkedList();
        boolLinkedList instance1 = new boolLinkedList();
        
        /*
         *  Add some elements to instance
         */
        for (int i = 0; i < 4; i++) {
            instance0.insert(i, seq0[i]);
        }

        /*
         *  Query individual elements
         */
        boolean expResult;
        boolean result;
        for (int i = 0; i < 4; i++) {
            result = (boolean) instance0.lookup(i);
            expResult = seq0[i];
            System.out.println(result == expResult);
        }
		
	}
	

	


}
