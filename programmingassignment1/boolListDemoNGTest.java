package programmingassignment1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
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
public class boolListDemoNGTest {
    
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
    
    /*
     *  Initialize corresponding test values
     */
    private Integer test0;
    private Integer test1;
    private Integer test2;
    private Integer test3;
    
    public boolListDemoNGTest() {
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
        
        /*
         *  Initialize test values
         */
        test0 = 2;
        test1 = 6;
        test2 = -2;
        test3 = -6;
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of boolToSigned method, of class boolListDemo.
     */
    @Test
    //public void testBoolToSigned() throws IOException {
    public void testBoolToSigned() throws Exception {

        System.out.println("boolToSigned");
        
        /*
         *  With boolList interface
        */
        // Using array lists...
        boolList instance0 = new boolArrayList();
        boolList instance1 = new boolArrayList();
        boolList instance2 = new boolArrayList();
        boolList instance3 = new boolArrayList();
        
        // Using mis-cased class name
        //boolList instance0 = new BoolArrayList();
        //boolList instance1 = new BoolArrayList();
        //boolList instance2 = new BoolArrayList();
        //boolList instance3 = new BoolArrayList();
        
        // Using arbitrary constructor (for missing default constructor)
        //boolList instance0 = new boolArrayList(10);
        //boolList instance1 = new boolArrayList(10);
        //boolList instance2 = new boolArrayList(10);
        //boolList instance3 = new boolArrayList(10);
        
        // and using linked lists.
        boolList instance4 = new boolLinkedList();
        boolList instance5 = new boolLinkedList();
        boolList instance6 = new boolLinkedList();
        boolList instance7 = new boolLinkedList();
        
        // Using mis-cased class name and arbitrary constructor
        //boolean temp = false;
        //boolList instance4 = new BoolLinkedList(temp);
        //boolList instance5 = new BoolLinkedList(temp);
        //boolList instance6 = new BoolLinkedList(temp);
        //boolList instance7 = new BoolLinkedList(temp);
        
        /*
         *  Without interface
        */
        // Using array lists...
        //boolArrayList instance0 = new boolArrayList();
        //boolArrayList instance1 = new boolArrayList();
        //boolArrayList instance2 = new boolArrayList();
        //boolArrayList instance3 = new boolArrayList();
        
        
        // and using linked lists.
        //boolList instance4 = new boolLinkedList();
        //boolList instance5 = new boolLinkedList();
        //boolList instance6 = new boolLinkedList();
        //boolList instance7 = new boolLinkedList();
        
        
        /*
         *  Add some elements to instances
         *  N.B. Storing elements in reverse order so that rightmost element
         *       of storage array (e.g. seq0,...) corresponds to LSB, which 
         *       should be indexed as 0 in the boolList objects.
         */
        
        /* This code won't work if can't insert entries before 0th element */
        for (int i = 0; i < nBits; i++) {
            instance0.insert(0, seq0[i]);
            instance1.insert(0, seq1[i]);
            instance2.insert(0, seq2[i]);
            instance3.insert(0, seq3[i]);
            //
            instance4.insert(0, seq0[i]);
            instance5.insert(0, seq1[i]);
            instance6.insert(0, seq2[i]);
            instance7.insert(0, seq3[i]);
        }
        /* This code won't work if we can't specify the position of the entry */
        /*int k;
        for (int i = 0; i < nBits; i++) {
            k = (nBits - 1) - i;
            instance0.insert(i, seq0[k]);
            instance1.insert(i, seq1[k]);
            instance2.insert(i, seq2[k]);
            instance3.insert(i, seq3[k]);
            //
            instance4.insert(i, seq0[k]);
            instance5.insert(i, seq1[k]);
            instance6.insert(i, seq2[k]);
            instance7.insert(i, seq3[k]);
        }*/
        
        /*
         *  Check computation of signed integers...
         */
        int result;
        int expResult;
        
        /*
         *  seq0 = (0010)_2 = (2)_10
         */
        expResult = 2;
        // Array list
        result = boolListDemo.boolToSigned(instance0);
        //result = BoolListDemo.boolToSigned(instance0);
        //result = Demo.boolToSigned(instance0);
        //assertEquals(result,expResult);
        // Linked list
        result = boolListDemo.boolToSigned(instance4);
        //result = BoolListDemo.boolToSigned(instance4);
        //result = Demo.boolToSigned(instance4);
        //assertEquals(result,expResult);
        
        //  seq1 = (0110)_2 = (6)_10
        expResult = 6;
        // Array list
        result = boolListDemo.boolToSigned(instance1);
        //result = BoolListDemo.boolToSigned(instance1);
        //result = Demo.boolToSigned(instance1);
        assertEquals(result,expResult);
        // Linked list
        result = boolListDemo.boolToSigned(instance5);
        //result = BoolListDemo.boolToSigned(instance5);
        //result = Demo.boolToSigned(instance5);
        assertEquals(result,expResult);
        
        //  seq2 = (1110)_2 = (-2)_10
        expResult = -2;
        // Array list
        result = boolListDemo.boolToSigned(instance2);
        //result = BoolListDemo.boolToSigned(instance2);
        //result = Demo.boolToSigned(instance2);
        assertEquals(result,expResult);
        // Linked list
        result = boolListDemo.boolToSigned(instance6);
        //result = BoolListDemo.boolToSigned(instance6);
        //result = Demo.boolToSigned(instance6);
        assertEquals(result,expResult);
        
        //  seq3 = (1010)_2 = (-6)_10
        expResult = -6;
        // Array list
        result = boolListDemo.boolToSigned(instance3);
        //result = BoolListDemo.boolToSigned(instance3);
        //result = Demo.boolToSigned(instance3);
        assertEquals(result,expResult);
        // Linked list
        result = boolListDemo.boolToSigned(instance7);
        //result = BoolListDemo.boolToSigned(instance7);
        //result = Demo.boolToSigned(instance7);
        assertEquals(result,expResult);
    }
    
}
