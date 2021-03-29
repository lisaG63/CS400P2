import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;

// TODO: Add tests to test if a Red-Black tree 
// extension of BST is correct.  Mostly check node color and position

//@SuppressWarnings("rawtypes")
public class TestRBT  {

    protected RBT<Integer,String> rbt;

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
         rbt = new RBT<Integer,String>();
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterEach
    void tearDown() throws Exception {
    }

    /** 
     * CASE 123 Insert three values in sorted order and then check 
     * the root, left, and right keys to see if RBT rebalancing 
     * occurred.
     * 
     */
    @Test
    void testRBT_001_insert_sorted_order_simple() {
        try {
            rbt.insert(10, "10");
            Assert.assertTrue(rbt.rootIsBlack());
            
            rbt.insert(20, "20");
            Assert.assertTrue(rbt.getKeyOfRightChildOf(10).equals(20)) ;
            Assert.assertEquals(rbt.colorOf(20),RBT.RED);
            
            rbt.insert(30, "30");  // SHOULD CAUSE REBALANCING
            Assert.assertTrue(rbt.getKeyOfRightChildOf(20).equals(30));
            
            // IF rebalancing is working,
            // the tree should have 20 at the root
            // and 10 as its left child and 30 as its right child
            Assert.assertEquals(rbt.getKeyAtRoot(), Integer.valueOf(20));
            Assert.assertEquals(rbt.getKeyOfLeftChildOf(20), Integer.valueOf(10));
            Assert.assertEquals(rbt.getKeyOfRightChildOf(20), Integer.valueOf(30));

            System.out.println("001: insert 10, 20, 30 \n");
            rbt.print();
            System.out.println();
            
        } catch (Exception e) {
            //e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }

    /** 
     * CASE 321 Insert three values in reverse sorted order and then check 
     * the root, left, and right keys to see if rebalancing 
     * occurred in the other direction.
     */
    @Test
    void testRBT_002_insert_reversed_sorted_order_simple() {
        try {
            rbt.insert(30, "30");
            Assert.assertTrue(rbt.rootIsBlack());
            
            rbt.insert(20, "20");
            Assert.assertTrue(rbt.getKeyOfLeftChildOf(30).equals(20)) ;
            Assert.assertEquals(rbt.colorOf(20),RBT.RED);
            
            rbt.insert(10, "10");  // SHOULD CAUSE REBALANCING
            Assert.assertTrue(rbt.getKeyOfLeftChildOf(20).equals(10));
            
            // IF rebalancing is working,
            // the tree should have 20 at the root
            // and 10 as its left child and 30 as its right child
            Assert.assertEquals(rbt.getKeyAtRoot(), Integer.valueOf(20));
            Assert.assertEquals(rbt.getKeyOfLeftChildOf(20), Integer.valueOf(10));
            Assert.assertEquals(rbt.getKeyOfRightChildOf(20), Integer.valueOf(30));

            System.out.println("002: insert 30, 20, 10 \n");
            rbt.print();
            System.out.println();
            
        } catch (Exception e) {
            //e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
        
    }

    /** 
     * CASE 132 Insert three values so that rebalancing requires new key 
     * to be the "new" root of the rebalanced tree.
     * 
     * Then check the root, left, and right keys to see if rebalancing 
     * occurred correctly.
     */
    @Test
    void testRBT_003_insert_smallest_largest_middle_order_simple() {
        
        try {
            rbt.insert(10, "10");
            Assert.assertTrue(rbt.rootIsBlack());
            
            rbt.insert(30, "30");
            Assert.assertTrue(rbt.getKeyOfRightChildOf(10).equals(30)) ;
            Assert.assertEquals(rbt.colorOf(30),RBT.RED);
            
            rbt.insert(20, "20");  // SHOULD CAUSE REBALANCING
            
            // IF rebalancing is working,
            // the tree should have 20 at the root
            // and 10 as its left child and 30 as its right child
            Assert.assertEquals(rbt.getKeyAtRoot(), Integer.valueOf(20));
            Assert.assertEquals(rbt.getKeyOfLeftChildOf(20), Integer.valueOf(10));
            Assert.assertEquals(rbt.getKeyOfRightChildOf(20), Integer.valueOf(30));

            System.out.println("003: insert 10, 30, 20\n ");
            rbt.print();
            System.out.println();
            
        } catch (Exception e) {
            e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
            
        }
        
    }

    /** 
     * CASE 312 Insert three values so that rebalancing requires new key 
     * to be the "new" root of the rebalanced tree.
     * 
     * Then check the root, left, and right keys to see if rebalancing 
     * occurred correctly.
     */
    @Test
    void testRBT_004_insert_largest_smallest_middle_order_simple() {
        
    	try {
            rbt.insert(30, "30");
            Assert.assertTrue(rbt.rootIsBlack());
            
            rbt.insert(10, "10");
            Assert.assertTrue(rbt.getKeyOfLeftChildOf(30).equals(10)) ;
            Assert.assertEquals(rbt.colorOf(10),RBT.RED);
            
            rbt.insert(20, "20");  // SHOULD CAUSE REBALANCING
            
            // IF rebalancing is working,
            // the tree should have 20 at the root
            // and 10 as its left child and 30 as its right child
            Assert.assertEquals(rbt.getKeyAtRoot(), Integer.valueOf(20));
            Assert.assertEquals(rbt.getKeyOfLeftChildOf(20), Integer.valueOf(10));
            Assert.assertEquals(rbt.getKeyOfRightChildOf(20), Integer.valueOf(30));

            System.out.println("004: insert 30, 10, 20 \n");
            rbt.print();
            System.out.println();
            
        } catch (Exception e) {
            e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
            
        }
        
    }
    
    /** 
     * Insert 40, 20, 30, 10, 35, 50 and 60 so that it requires two recoloring processes.
     * 
     * Then check the root, left key, right key and grandchild to see if recoloring 
     * occurred correctly.
     */
    @Test
    void testRBT_005_insert_recoloring() {
        
    	try {
            rbt.insert(40, "40");
            Assert.assertTrue(rbt.rootIsBlack());
            
            rbt.insert(20, "20");
            Assert.assertTrue(rbt.getKeyOfLeftChildOf(40).equals(20)) ;
            Assert.assertEquals(rbt.colorOf(20),RBT.RED);
            
            rbt.insert(30, "30");  // SHOULD CAUSE REBALANCING
            
            // IF rebalancing is working,
            // the tree should have 20 at the root
            // and 10 as its left child and 30 as its right child
            Assert.assertEquals(rbt.getKeyAtRoot(), Integer.valueOf(30));
            Assert.assertEquals(rbt.getKeyOfLeftChildOf(30), Integer.valueOf(20));
            Assert.assertEquals(rbt.getKeyOfRightChildOf(30), Integer.valueOf(40));
            
            rbt.insert(10, "10");//should cause recoloring
            Assert.assertEquals(rbt.colorOf(30), RBT.BLACK);
            Assert.assertEquals(rbt.colorOf(20), RBT.BLACK);
            Assert.assertEquals(rbt.colorOf(40), RBT.BLACK);
            Assert.assertEquals(rbt.colorOf(10), RBT.RED);
            
            rbt.insert(35, "35");
            rbt.insert(50, "50");
            //these two steps won't cause rebalancing or recoloring

            rbt.insert(60, "60");//should cause recoloring
            Assert.assertEquals(rbt.colorOf(40), RBT.RED);

            Assert.assertEquals(rbt.colorOf(35), RBT.BLACK);
            Assert.assertEquals(rbt.colorOf(50), RBT.BLACK);
            Assert.assertEquals(rbt.colorOf(60), RBT.RED);

            System.out.println("005: insert 40, 20, 30, 10, 35, 50 and 60\n");
            rbt.print();
            System.out.println();
            
        } catch (Exception e) {
            e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
            
        }
        
    }
    
    /** 
     * Insert 66, 32, 35, 30, 46, 59. After rebalancing, the inorder traversal should produce a list
     * containing 30, 32, 35, 46, 59 and 66.
     * 
     */
    @Test
    void testRBT_006_getInOrderTraversal() {
    	try {
            rbt.insert(66, "66"); 
            rbt.insert(32, "32");
            rbt.insert(35, "35");
            rbt.insert(30, "30");
            rbt.insert(46, "46");
            rbt.insert(59, "59");
            Assert.assertTrue(rbt.getInOrderTraversal().get(0) == 30);
            Assert.assertTrue(rbt.getInOrderTraversal().get(1) == 32);
            Assert.assertTrue(rbt.getInOrderTraversal().get(2) == 35);
            Assert.assertTrue(rbt.getInOrderTraversal().get(3) == 46);
            Assert.assertTrue(rbt.getInOrderTraversal().get(4) == 59);
            Assert.assertTrue(rbt.getInOrderTraversal().get(5) == 66);
            
            System.out.println("006: insert 66, 32, 35, 30, 46, 59\n");
            rbt.print();
            System.out.println();
            
        } catch (Exception e) {
            //e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }
    
    /** 
     * Insert 66, 32, 35, 30, 46, 59. After rebalancing, the preorder traversal should produce a 
     * list containing 35, 32, 30, 59, 46 and 66.
     * 
     */
    @Test
    void testRBT_007_getPreOrderTraversal() {
    	try {
            rbt.insert(66, "66"); 
            rbt.insert(32, "32");
            rbt.insert(35, "35");
            rbt.insert(30, "30");
            rbt.insert(46, "46");
            rbt.insert(59, "59");
            Assert.assertTrue(rbt.getPreOrderTraversal().get(0) == 35);
            Assert.assertTrue(rbt.getPreOrderTraversal().get(1) == 32);
            Assert.assertTrue(rbt.getPreOrderTraversal().get(2) == 30);
            Assert.assertTrue(rbt.getPreOrderTraversal().get(3) == 59);
            Assert.assertTrue(rbt.getPreOrderTraversal().get(4) == 46);
            Assert.assertTrue(rbt.getPreOrderTraversal().get(5) == 66);
            
        } catch (Exception e) {
            //e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }
    
    /** 
     * Insert 66, 32, 35, 30, 46, 59. After rebalancing, the postorder traversal should produce a 
     * list containing 30, 32, 46, 66, 59 and 35.
     * 
     */
    @Test
    void testRBT_008_getPostOrderTraversal() {
    	try {
            rbt.insert(66, "66"); 
            rbt.insert(32, "32");
            rbt.insert(35, "35");
            rbt.insert(30, "30");
            rbt.insert(46, "46");
            rbt.insert(59, "59");
            Assert.assertTrue(rbt.getPostOrderTraversal().get(0) == 30);
            Assert.assertTrue(rbt.getPostOrderTraversal().get(1) == 32);
            Assert.assertTrue(rbt.getPostOrderTraversal().get(2) == 46);
            Assert.assertTrue(rbt.getPostOrderTraversal().get(3) == 66);
            Assert.assertTrue(rbt.getPostOrderTraversal().get(4) == 59);
            Assert.assertTrue(rbt.getPostOrderTraversal().get(5) == 35);
            
        } catch (Exception e) {
            //e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }
    
    /** 
     * Insert 66, 32, 35, 30, 46, 59. After rebalancing, the level order traversal should produce a 
     * list containing 35, 32, 59, 30, 46 and 66.
     * 
     */
    @Test
    void testRBT_009_getLevelOrderTraversal() {
    	try {
            rbt.insert(66, "66"); 
            rbt.insert(32, "32");
            rbt.insert(35, "35");
            rbt.insert(30, "30");
            rbt.insert(46, "46");
            rbt.insert(59, "59");
            Assert.assertTrue(rbt.getLevelOrderTraversal().get(0) == 35);
            Assert.assertTrue(rbt.getLevelOrderTraversal().get(1) == 32);
            Assert.assertTrue(rbt.getLevelOrderTraversal().get(2) == 59);
            Assert.assertTrue(rbt.getLevelOrderTraversal().get(3) == 30);
            Assert.assertTrue(rbt.getLevelOrderTraversal().get(4) == 46);
            Assert.assertTrue(rbt.getLevelOrderTraversal().get(5) == 66);
            
        } catch (Exception e) {
            //e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }
    
    /** 
     * Insert 66, 32, 35, 30, 46, 59. Check the height of root after each insertion.
     * 
     */
    @Test
    void testRBT_010_getHeight() {
    	try {
            rbt.insert(66, "66"); 
            Assert.assertEquals(rbt.getHeight(), 1);
            rbt.insert(32, "32");
            Assert.assertEquals(rbt.getHeight(), 2);
            rbt.insert(35, "35");
            Assert.assertEquals(rbt.getHeight(), 2);
            rbt.insert(30, "30");
            Assert.assertEquals(rbt.getHeight(), 3);
            rbt.insert(46, "46");
            Assert.assertEquals(rbt.getHeight(), 3);
            rbt.insert(59, "59");
            Assert.assertEquals(rbt.getHeight(), 3);
            
        } catch (Exception e) {
            //e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }
    
    
    /** 
     * Insert 66, 32, 35, 30, 46, 59. Check the size of rbt after each insertion.
     * 
     */
    @Test
    void testRBT_011_numKeys() {
    	try {
            rbt.insert(66, "66"); 
            Assert.assertEquals(rbt.numKeys(), 1);
            rbt.insert(32, "32");
            Assert.assertEquals(rbt.numKeys(), 2);
            rbt.insert(35, "35");
            Assert.assertEquals(rbt.numKeys(), 3);
            rbt.insert(30, "30");
            Assert.assertEquals(rbt.numKeys(), 4);
            rbt.insert(46, "46");
            Assert.assertEquals(rbt.numKeys(), 5);
            rbt.insert(59, "59");
            Assert.assertEquals(rbt.numKeys(), 6);
            
        } catch (Exception e) {
            //e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }

    
    /** 
     * Insert 66, 32, 35, 30, 46, 59. Get each key's value.
     * 
     */
    @Test
    void testRBT_012_get() {
    	try {
            rbt.insert(66, "66"); 
            rbt.insert(32, "32");
            rbt.insert(35, "35");
            rbt.insert(30, "30");
            rbt.insert(46, "46");
            rbt.insert(59, "59");
            Assert.assertEquals(rbt.get(66), "66");
            Assert.assertEquals(rbt.get(32), "32");
            Assert.assertEquals(rbt.get(35), "35");
            Assert.assertEquals(rbt.get(30), "30");
            Assert.assertEquals(rbt.get(46), "46");
            Assert.assertEquals(rbt.get(59), "59");
            
        } catch (Exception e) {
            //e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }
    
    /** 
     * Insert 66, 32, 35, 30, 46, 59. Check if rbt contains these keys. Also check if a non-exist 
     * key is contained in the rbt.
     */
    @Test
    void testRBT_013_contains() {
    	try {
            rbt.insert(66, "66"); 
            rbt.insert(32, "32");
            rbt.insert(35, "35");
            rbt.insert(30, "30");
            rbt.insert(46, "46");
            rbt.insert(59, "59");
            Assert.assertTrue(rbt.contains(66));
            Assert.assertTrue(rbt.contains(32));
            Assert.assertTrue(rbt.contains(35));
            Assert.assertTrue(rbt.contains(30));
            Assert.assertTrue(rbt.contains(46));
            Assert.assertTrue(rbt.contains(59));
            Assert.assertFalse(rbt.contains(83));
            
        } catch (Exception e) {
            //e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }
    

    void testRBT_014_delete() {
    	try {
    		rbt.insert(66, "66");
    		rbt.remove(66);
    		fail("No exception thrown");
    	} catch (Exception e) {
    		Assert.assertTrue(e instanceof  UnsupportedOperationException);
    	}
    }
    
    
    
    // TODO: Add your own tests
    
    // Add tests to make sure that rebalancing occurs even if the 
    // tree is larger.   Does it maintain it's balance?
    // Does the height of the tree reflect it's actual height
    // Use the traversal orders to check.
    
    // Can you insert many and still "get" them back out?
    
    // Does delete work?  Does the tree maintain balance when a key is deleted?
    // If delete is not implemented, does calling it throw an UnsupportedOperationException

} // copyright Deb Deppeler, all rights reserved, DO NOT SHARE
