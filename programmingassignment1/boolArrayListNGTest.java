/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmingassignment1;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Rich
 */
public class boolArrayListNGTest {
    
    /*
     *  Set up a few Objects for use in test fixture
     */
    int nBits = 4;
    
    /*
    *  Initialize input sequences:
    */
    Boolean[] seq0; 
    Boolean[] seq1;
    Boolean[] seq2;
    Boolean[] seq3;
    
    public boolArrayListNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        /*
         *  Set up test fixture...
         */
        
        /*
         *  Initialize input sequences:
         *      seq0 = (0010)_2 = (2)_10
         *      seq1 = (0110)_2 = (6)_10
         *      seq2 = (1110)_2 = (-2)_10
         *      seq3 = (1010)_2 = (-6)_10
         */
        seq0 = new Boolean[] {false, false, true, false};
        seq1 = new Boolean[] {false, true, true, false}; 
        seq2 = new Boolean[] {true, true, true, false};
        seq3 = new Boolean[] {true, false, true, false};
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of size method, of class boolArrayList.
     */
    @Test
    public void testSize() throws Exception {
        System.out.println("size");
        boolArrayList instance = new boolArrayList();
        //boolArrayList instance = new boolArrayList(10);  
        
        /*
         *  Query empty object
         */
        int expResult = 0;
        int result = instance.size();
        assertEquals(result, expResult);
        
        /*
         *  Add some elements to instance
         */
        for (int i=0; i < nBits; i++) {
            instance.insert(i, seq0[i]);
        }
        
        /*
         *  Query size
        */
        expResult = nBits;
        result = instance.size();
        assertEquals(result, expResult);
    }

    /**
     * Test of insert method, of class boolArrayList.
     */
    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        boolArrayList instance0 = new boolArrayList();
        boolArrayList instance1 = new boolArrayList();
        //boolArrayList instance0 = new boolArrayList(10);
        //boolArrayList instance1 = new boolArrayList(10);
        
        /*
         *  Add some elements to instance
         */
        for (int i = 0; i < nBits; i++) {
            instance0.insert(i, seq0[i]);
        }
        
        /*
         *  Test encapsulation:
         *     Next line shoule be illegal...
         *     comment out as needed.
         *     N.B. Didn't specify names of object fields so this is not nearly
         *          general enough to use with everybody's code
         */
        //boolean temp = instance0.array[0];

        /*
         *  Query individual elements
         */
        boolean expResult;
        boolean result;
        for (int i = 0; i < nBits; i++) {
            result = (boolean) instance0.lookup(i);
            expResult = seq0[i];
            assertEquals(result, expResult);
        }
        
        /*
         *  Check corner case - add element beyond last current element
         */
        int offset = 4;
        for (int i = 0; i < nBits; i++) {
            instance1.insert(i+offset, seq0[i]);
        }
        
        /*
         *  Query individual elements
         */
        for (int i = 0; i < nBits; i++) {
            result = (boolean) instance1.lookup(i);
            expResult = seq0[i];
            assertEquals(result, expResult);
        }
    }
    
    /**
     * Test of exception for insert method, of class boolArrayList.
     *   N.B.  For some reason, the "expected" parameter is not being
     *         recognized.  Receiving error:
     *                 cannot find symbol
     *                   symbol: method expected()
     *                   location: @interface Test
     * 
     * Commenting out use of @Test annotation and implementing try/catch
     * idiom....  In any case, may have different types of exceptions selected
     * (not specified in handout).
     * 
     * Note also, an exception not specified for the remove method in handout
     * (though I should have specified one...).  This is just for style points.
     */
    //@Test(expected = IndexOutOfBoundsException.class)
    @Test
    public void testInsertException() throws Exception {
        System.out.println("insert exception");
        boolArrayList instance = new boolArrayList();
        //boolArrayList instance = new boolArrayList(10);
        
        /* 
         * Try inserting elements before nonexistent
         */
        int target = -1;
        boolean toInsert = true;
        
        boolean result;
        try {
            instance.insert(target,toInsert);
            result = false;
        } catch (IndexOutOfBoundsException e) {
            //  Not going to test message or the like...
            result = true;
        }
        assertTrue(result);
        
        /* 
         * Try removing elements a nonexistent element from the list...
         */
        target = -1;
        
        try {
            instance.insert(target,toInsert);
            result = false;
        } catch (IndexOutOfBoundsException e) {
            //  Not going to test message or the like...
            result = true;
        }
        assertTrue(result);
    }

    /**
     * Test of remove method, of class boolArrayList.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        
        boolArrayList instance0 = new boolArrayList();
        boolArrayList instance1 = new boolArrayList();
        boolArrayList instance2 = new boolArrayList();
        boolArrayList instance3 = new boolArrayList();

        //boolArrayList instance0 = new boolArrayList(10);
        //boolArrayList instance1 = new boolArrayList(10);
        //boolArrayList instance2 = new boolArrayList(10);
        //boolArrayList instance3 = new boolArrayList(10);
        
        /*
         *  Add some elements to instances
         */
        for (int i = 0; i < nBits; i++) {
            instance0.insert(i, seq0[i]);
            instance1.insert(i, seq1[i]);
            instance2.insert(i, seq2[i]);
            instance3.insert(i, seq3[i]);
        }
        
        /*
         *  Remove leading (first) element
         */
        int toRemove = 0;
        instance0.remove(toRemove);
        
        /*
         *  Make sure bookeeping done properly...
         */
        int expIntResult;
        int intResult;
        intResult = instance0.size();
        expIntResult = nBits - 1;
        assertEquals(intResult, expIntResult);
        
        /*
         *  Query individual elements
         */
        boolean expResult;
        boolean result;
        for (int i = 0; i < nBits - 2; i++) {
            result = (boolean) instance0.lookup(i);
            expResult = seq0[i+1];
            assertEquals(result, expResult);
        }
        
        /*
         *  Remove trailing (last) element
         */
        toRemove = nBits - 1;
        instance1.remove(toRemove);
        
        /*
         *  Make sure bookeeping done properly...
         */
        intResult = instance1.size();
        expIntResult = nBits - 1;
        assertEquals(intResult, expIntResult);
        
        /*
         *  Query individual elements
         */
        for (int i = 0; i < nBits - 1; i++) {
            result = (boolean) instance1.lookup(i);
            expResult = seq1[i];
            assertEquals(result, expResult);
        }
        
        /*
         *  Remove an arbitrary element
         */
        toRemove = 2;
        instance2.remove(toRemove);
        
        /*
         *  Make sure bookeeping done properly...
         */
        intResult = instance2.size();
        expIntResult = nBits - 1;
        assertEquals(intResult, expIntResult);
        
        /*
         *  Query individual elements
         */
        
        // Elements preceeding removed item
        for (int i = 0; i < toRemove; i++) {
            result = (boolean) instance2.lookup(i);
            expResult = seq2[i];
            assertEquals(result, expResult);
        }
        
        // Elements following removed item
        for (int i = toRemove; i < nBits - 1; i++) {
            result = (boolean) instance2.lookup(i);
            expResult = seq2[i+1];
            assertEquals(result, expResult);
        }
        
        /*
         *  Remove non-existent element
         */
        toRemove = 6;
        instance3.remove(toRemove);
        
        /*
         *  Make sure bookeeping done properly...
         */
        intResult = instance3.size();
        expIntResult = nBits;
        assertEquals(intResult, expIntResult);
        
        /*
         *  Query individual elements
         */
        for (int i = 0; i < nBits; i++) {
            result = (boolean) instance3.lookup(i);
            expResult = seq3[i];
            assertEquals(result, expResult);
        }
    }
    
    /**
     * Test of exception for remove method, of class boolArrayList.
     *   N.B.  For some reason, the "expected" parameter is not being
     *         recognized.  See above comment for testRemoveException.
     * 
     * Commenting out use of @Test annotation and implementing try/catch
     * idiom....  In any case, may have different types of exceptions selected
     * (not specified in handout).
     * 
     * Note also, an exception not specified for the remove method in handout
     * (though I should have specified one...).  This is just for style points.
     */
    //@Test(expected = IndexOutOfBoundsException.class)
    //@Test
    //public void testRemoveException() throws Exception {
    //    System.out.println("remove exception");
    //    boolArrayList instance = new boolArrayList();
        //boolArrayList instance = new boolArrayList(10);
        
        /* 
         * Try removing elements from an empty list...
         */
    //    int toRemove = 0;
        
    //    boolean result;
    //    try {
    //        instance.remove(toRemove);
    //        result = false;
    //    } catch (IndexOutOfBoundsException e) {
            //  Not going to test message or the like...
    //        result = true;
    //    }
    //    assertTrue(result);
        
        /*
         *  Add some elements to instances
         */
    //    for (int i = 0; i < nBits; i++) {
    //        instance.insert(i, seq0[i]);
    //    }
        
        /*
         *  Add some elements to instances
         */
    //    for (int i = 0; i < nBits; i++) {
    //        instance.insert(i, seq0[i]);;
    //    }
        
        /* 
         * Try removing elements a nonexistent element from the list...
         */
    //    toRemove = -1;
        
    //    try {
    //        instance.remove(toRemove);
    //        result = true;
    //    } catch (IndexOutOfBoundsException e) {
            //  Not going to test message or the like...
    //        result = false;
    //    }
    //    assertTrue(result);
        
        /*
         * Try removing an (actual) element then removing an element that
         * no longer "exists," i.e., the last element, which has moved from the 
         * kth to the (k-1)th entry as the overall length of the array has been 
         * decremented.
         */
    //    toRemove = 2;                 // Remove arbitrary entry
    //    instance.remove(toRemove);
        
    //    toRemove = nBits - 1;         // Remove entry at original end of array
    //    try {
    //        instance.remove(toRemove);
    //        result = false;
    //    } catch (IndexOutOfBoundsException e) {
            //  Not going to test message or the like...
    //        result = true;
    //    }
    //    assertTrue(result);
    //}

    /**
     * Test of lookup method, of class boolArrayList.
     */
    @Test
    public void testLookup() throws Exception {
        System.out.println("lookup");
        boolArrayList instance = new boolArrayList();
        //boolArrayList instance = new boolArrayList(10);
        
        /*
         *  Add some elements to instances
         */
        for (int i = 0; i < nBits; i++) {
            instance.insert(i, seq0[i]);
        }
        
        /*
         *  Query individual elements
         */
        boolean expResult;
        boolean result;
        for (int i = 0; i < nBits; i++) {
            result = (boolean) instance.lookup(i);
            expResult = seq0[i];
            assertEquals(result, expResult);
        }
    }
    
    /**
     * Test of exception for lookup method, of class boolArrayList.
     *   N.B.  For some reason, the "expected" parameter is not being
     *         recognized.  See above comment for testRemoveException.
     * 
     * Commenting out use of @Test annotation and implementing try/catch
     * idiom....  In any case, may have different types of exceptions selected
     * (not specified in handout).
     */
    //@Test(expected = IndexOutOfBoundsException.class)
    @Test
    public void testLookupException() throws Exception {
        System.out.println("lookup exception");
        boolArrayList instance = new boolArrayList();
        //boolArrayList instance = new boolArrayList(10);
        
        /* 
         * Try looking up elements from an empty list...
         */
        int toLookup = 0;
        
        boolean result;
        try {
            instance.lookup(toLookup);
            result = false;
        } catch (IndexOutOfBoundsException e) {
            //  Not going to test message or the like...
            result = true;
        }
        assertTrue(result);
        
        /*
         *  Add some elements to instance
         */
        for (int i = 0; i < nBits; i++) {
            instance.insert(i, seq0[i]);
        }
        
        /* 
         * Try looking up elements beyond existing list...
         */
        toLookup = -1;
        try {
            instance.lookup(toLookup);
            result = false;
        } catch (IndexOutOfBoundsException e) {
            //  Not going to test message or the like...
            result = true;
        }
        assertTrue(result);
        
        toLookup = nBits;
        try {
            instance.lookup(toLookup);
            result = false;
        } catch (IndexOutOfBoundsException e) {
            //  Not going to test message or the like...
            result = true;
        }
        assertTrue(result);
    }

    /**
     * Test of negateAll method, of class boolArrayList.
     */
    @Test
    public void testNegateAll() throws Exception {
        System.out.println("negateAll");
        boolArrayList instance = new boolArrayList();
        //boolArrayList instance = new boolArrayList(10);
        
         /*
         *  Add some elements to instances
         */
        for (int i = 0; i < nBits; i++) {
            instance.insert(i, seq0[i]);
        }
        
        /*
         *  Negate elements
         */
        boolean expFlagResult;
        boolean flagResult;
        expFlagResult = true;
        //flagResult = instance.negateAll();
        instance.negateAll();
        
        
        /*
         *  Test output
         */
        //assertEquals(flagResult,expFlagResult);
        
        /*
         *  Query individual elements
         */
        boolean expResult;
        boolean result;
        for (int i = 0; i < nBits; i++) {
            result = (boolean) instance.lookup(i); 
            expResult = !seq0[i];              // Negation of stored result
            assertEquals(result, expResult);
        }
    }
    
    /**
     * Test of exception for negateAll method, of class boolArrayList.
     *   N.B.  For some reason, the "expected" parameter is not being
     *         recognized.  See above comment for testRemoveException.
     * 
     * Commenting out use of @Test annotation and implementing try/catch
     * idiom....  In any case, may have different types of exceptions selected
     * (not specified in handout).
     * 
     * Also set up to return a flag for successful completion, not necessarily 
     * going to have code that tosses an exception.
     */
    //@Test(expected = IllegalArgumentException.class)
    @Test
    public void testNegateAllException() throws Exception {
        System.out.println("negateAll exception");
        boolArrayList instance = new boolArrayList();
        //boolArrayList instance = new boolArrayList(10);
        
        /* 
         * Try negating elements from an empty list...
         */
        boolean result;
        boolean flagResult;
        try {
            //flagResult = instance.negateAll();
            instance.negateAll();
            //result = !flagResult;
            result = false;
        } catch (IllegalArgumentException e) {
            //  Not going to test message or the like...
            result = true;
        }
        assertTrue(result);
    }
    
}
