import static org.junit.Assert.fail;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//@SuppressWarnings("rawtypes")
public class TestBST {

    protected STADT<Integer,String> bst;

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
         bst = new BST<Integer,String>();
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterEach
    void tearDown() throws Exception {
    }

    /** 
     * CASE 123 Insert three values in sorted order and then check 
     * the root, left, and right keys to see if insert worked 
     * correctly.
     */
    @Test
    void testBST_001_insert_sorted_order_simple() {
        try {
            bst.insert(10, "10");
            if (!bst.getKeyAtRoot().equals(10))
                fail("insert at root does not work");
            
            bst.insert(20, "20");
            if (!bst.getKeyOfRightChildOf(10).equals(20)) 
                fail("insert to right child of root does not work");
            
            bst.insert(30, "30");
            if (!bst.getKeyAtRoot().equals(10)) 
                fail("inserting 30 changed root");

            if (!bst.getKeyOfRightChildOf(20).equals(30)) 
                fail("inserting 30 as right child of 20");

            // IF rebalancing is working,
            // the tree should have 20 at the root
            // and 10 as its left child and 30 as its right child

            Assert.assertEquals(bst.getKeyAtRoot(), Integer.valueOf(10));
            Assert.assertEquals(bst.getKeyOfRightChildOf(10), Integer.valueOf(20));
            Assert.assertEquals(bst.getKeyOfRightChildOf(20), Integer.valueOf(30));

            System.out.println("001: insert 10, 20, 30 \n");
            bst.print();
            System.out.println();
            
        } catch (Exception e) {
            e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }

    /** 
     * CASE 321 Insert three values in reverse sorted order and then check 
     * the root, left, and right keys to see if insert 
     * worked in the other direction.
     */
    @Test
    void testBST_002_insert_reversed_sorted_order_simple() {
        try {
            bst.insert(30, "30");
            if (!bst.getKeyAtRoot().equals(30))
                fail("insert at root does not work");
            
            bst.insert(20, "20");
            if (!bst.getKeyOfLeftChildOf(30).equals(20)) 
                fail("insert to left child of root does not work");
            
            bst.insert(10, "10");
            if (!bst.getKeyAtRoot().equals(30)) 
                fail("inserting 10 changed root");

            if (!bst.getKeyOfLeftChildOf(20).equals(10)) 
                fail("inserting 10 as left child of 20");

            // IF rebalancing is working,
            // the tree should have 20 at the root
            // and 10 as its left child and 30 as its right child

            Assert.assertEquals(bst.getKeyAtRoot(), Integer.valueOf(30));
            Assert.assertEquals(bst.getKeyOfLeftChildOf(30), Integer.valueOf(20));
            Assert.assertEquals(bst.getKeyOfLeftChildOf(20), Integer.valueOf(10));
            
            System.out.println("002: insert 30, 20, 10\n");
            bst.print();
            System.out.println();
            
        } catch (Exception e) {
            e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }

    /** 
     * CASE 132 Insert three values so that rebalancing requires new key 
     * to be the "new" root of the rebalanced tree.
     * 
     * Then check the root, left, and right keys to see if insert 
     * occurred correctly.
     */
    @Test
    void testBST_003_insert_smallest_largest_middle_order_simple() {
        try {
            bst.insert(10, "10");
            if (!bst.getKeyAtRoot().equals(10))
                fail("insert at root does not work");
            
            bst.insert(30, "30");
            if (!bst.getKeyOfRightChildOf(10).equals(30)) 
                fail("insert to right child of root does not work");
            Assert.assertEquals(bst.getKeyOfRightChildOf(10),Integer.valueOf(30));
            
            bst.insert(20, "20");
            if (!bst.getKeyAtRoot().equals(10)) 
                fail("inserting 20 changed root");

            if (!bst.getKeyOfLeftChildOf(30).equals(20)) 
                fail("inserting 20 as left child of 30");

            // IF rebalancing is working,
            // the tree should have 20 at the root
            // and 10 as its left child and 30 as its right child

            Assert.assertEquals(bst.getKeyAtRoot(), Integer.valueOf(10));
            Assert.assertEquals(bst.getKeyOfRightChildOf(10), Integer.valueOf(30));
            Assert.assertEquals(bst.getKeyOfLeftChildOf(30), Integer.valueOf(20));
            
            System.out.println("003: insert 10, 30, 20\n");
            bst.print();
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
     * Then check the root, left, and right keys to see if insert 
     * occurred correctly.
     */
    @Test
    void testBST_004_insert_largest_smallest_middle_order_simple() {
        try {
            bst.insert(30, "30");
            if (!bst.getKeyAtRoot().equals(30))
                fail("insert at root does not work");
            
            bst.insert(10, "10");
            if (!bst.getKeyOfLeftChildOf(30).equals(10)) 
                fail("insert to left child of root does not work");
            
            bst.insert(20, "20");
            if (!bst.getKeyAtRoot().equals(30)) 
                fail("inserting 10 changed root");

            if (!bst.getKeyOfRightChildOf(10).equals(20)) 
                fail("inserting 20 as right child of 10");

            // the tree should have 30 at the root
            // and 10 as its left child and 20 as 10's right child

            Assert.assertEquals(bst.getKeyAtRoot(), Integer.valueOf(30));
            Assert.assertEquals(bst.getKeyOfLeftChildOf(30), Integer.valueOf(10));
            Assert.assertEquals(bst.getKeyOfRightChildOf(10), Integer.valueOf(20));

            System.out.println("004: insert 30, 10, 20\n ");
            bst.print();
            System.out.println();
            
        } catch (Exception e) {
            e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }
    
    /** 
     * Insert 30, 10, 20, then delete 20.
     * 
     * Then check the root, left, size, and if bst contains 20 to see if delete
     * occurred correctly.
     */
    @Test
    void testBST_005_delete_leaf() {
        try {
            bst.insert(30, "30");
            if (!bst.getKeyAtRoot().equals(30))
                fail("insert at root does not work");
            
            bst.insert(10, "10");
            if (!bst.getKeyOfLeftChildOf(30).equals(10)) 
                fail("insert to left child of root does not work");
            
            bst.insert(20, "20");
            if (!bst.getKeyAtRoot().equals(30)) 
                fail("inserting 10 changed root");

            if (!bst.getKeyOfRightChildOf(10).equals(20)) 
                fail("inserting 20 as right child of 10");

            bst.remove(20);
            Assert.assertEquals(bst.getKeyAtRoot(), Integer.valueOf(30));
            Assert.assertEquals(bst.getKeyOfLeftChildOf(30), Integer.valueOf(10));
            Assert.assertFalse(bst.contains(20));
            Assert.assertEquals(bst.numKeys(), 2);

            System.out.println("005: insert 30, 10, 20, then delete 20 \n");
            bst.print();
            System.out.println();
            
        } catch (Exception e) {
            e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }
    
    /** 
     * Insert 30, 10, 20, then delete 30.
     * 
     * Then check the root, left, size, and if bst contains 30 to see if delete
     * occurred correctly.
     */
    @Test
    void testBST_006_delete_root() {
        try {
            bst.insert(30, "30");
            if (!bst.getKeyAtRoot().equals(30))
                fail("insert at root does not work");
            
            bst.insert(10, "10");
            if (!bst.getKeyOfLeftChildOf(30).equals(10)) 
                fail("insert to left child of root does not work");
            
            bst.insert(20, "20");
            if (!bst.getKeyAtRoot().equals(30)) 
                fail("inserting 10 changed root");

            if (!bst.getKeyOfRightChildOf(10).equals(20)) 
                fail("inserting 20 as right child of 10");


            bst.remove(30);
            Assert.assertEquals(bst.getKeyAtRoot(), Integer.valueOf(10));
            Assert.assertEquals(bst.getKeyOfRightChildOf(10), Integer.valueOf(20));
            Assert.assertFalse(bst.contains(30));
            Assert.assertEquals(bst.numKeys(), 2);

            System.out.println("006: insert 30, 10, 20, then delete 30 \n");
            bst.print();
            System.out.println();
            
        } catch (Exception e) {
            e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }
    
    
    /** 
     * Insert 20, 15, 12, 17, 16, 18, 30, then delete 15.
     * 
     * Then check the root, left, size, and if bst contains 15 to see if delete
     * occurred correctly.
     */
    @Test
    void testBST_007_delete_interior_node() {
        try {
            bst.insert(20, "20");
            if (!bst.getKeyAtRoot().equals(20))
                fail("insert at root does not work");
            
            bst.insert(15, "15");
            if (!bst.getKeyOfLeftChildOf(20).equals(15)) 
                fail("insert to left child of root does not work");
            
            bst.insert(12, "12");
            if (!bst.getKeyAtRoot().equals(20)) 
                fail("inserting 10 changed root");

            bst.insert(17, "17");
            bst.insert(16, "10");
            bst.insert(18, "13");
            bst.insert(30, "30");
            bst.remove(15);
  
            Assert.assertEquals(bst.getKeyAtRoot(), Integer.valueOf(20));
            Assert.assertEquals(bst.getKeyOfLeftChildOf(20), Integer.valueOf(16));
            Assert.assertEquals(bst.getKeyOfRightChildOf(16), Integer.valueOf(17));
            Assert.assertEquals(bst.getKeyOfLeftChildOf(16), Integer.valueOf(12));
            Assert.assertFalse(bst.contains(15));
            Assert.assertEquals(bst.numKeys(), 6);

            System.out.println("007: Insert 20, 15, 12, 17, 16, 18, 30, then delete 15\n ");
            bst.print();
            System.out.println();
            
        } catch (Exception e) {
            e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }
    
    /** 
     * Insert 30, 10, 20, then delete 40.
     * 
     * Then check the root, left, size, and if the remove method returns false to see if delete
     * occurred correctly.
     */
    @Test
    void testBST_008_delete_nonexist_node() {
        try {
            bst.insert(30, "30");
            if (!bst.getKeyAtRoot().equals(30))
                fail("insert at root does not work");
            
            bst.insert(10, "10");
            if (!bst.getKeyOfLeftChildOf(30).equals(10)) 
                fail("insert to left child of root does not work");
            
            bst.insert(20, "20");
            if (!bst.getKeyAtRoot().equals(30)) 
                fail("inserting 10 changed root");

            if (!bst.getKeyOfRightChildOf(10).equals(20)) 
                fail("inserting 20 as right child of 10");


            Assert.assertEquals(bst.remove(40), false);
            Assert.assertEquals(bst.getKeyAtRoot(), Integer.valueOf(30));
            Assert.assertEquals(bst.numKeys(), 3);

            System.out.println("008: insert 30, 10, 20, then delete 40 \n");
            bst.print();
            System.out.println();
            
        } catch (Exception e) {
            e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }
    
    /** 
     * Insert 66, 32, 35, 30, 46, 59. The inorder traversal should produce a list
     * containing 30, 32, 35, 46, 59 and 66.
     * 
     */
    @Test
    void testBST_009_getInOrderTraversal() {
    	try {
            bst.insert(66, "66"); 
            bst.insert(32, "32");
            bst.insert(35, "35");
            bst.insert(30, "30");
            bst.insert(46, "46");
            bst.insert(59, "59");
            Assert.assertTrue(bst.getInOrderTraversal().get(0) == 30);
            Assert.assertTrue(bst.getInOrderTraversal().get(1) == 32);
            Assert.assertTrue(bst.getInOrderTraversal().get(2) == 35);
            Assert.assertTrue(bst.getInOrderTraversal().get(3) == 46);
            Assert.assertTrue(bst.getInOrderTraversal().get(4) == 59);
            Assert.assertTrue(bst.getInOrderTraversal().get(5) == 66);
            
            System.out.println("009: insert 66, 32, 35, 30, 46, 59\n");
            bst.print();
            System.out.println();
            
        } catch (Exception e) {
            //e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }
    
    /** 
     * Insert 66, 32, 35, 30, 46, 59. The preorder traversal should produce a 
     * list containing 66, 32, 30, 35, 46 and 59.
     * 
     */
    @Test
    void testBST_010_getPreOrderTraversal() {
    	try {
            bst.insert(66, "66"); 
            bst.insert(32, "32");
            bst.insert(35, "35");
            bst.insert(30, "30");
            bst.insert(46, "46");
            bst.insert(59, "59");
            Assert.assertTrue(bst.getPreOrderTraversal().get(0) == 66);
            Assert.assertTrue(bst.getPreOrderTraversal().get(1) == 32);
            Assert.assertTrue(bst.getPreOrderTraversal().get(2) == 30);
            Assert.assertTrue(bst.getPreOrderTraversal().get(3) == 35);
            Assert.assertTrue(bst.getPreOrderTraversal().get(4) == 46);
            Assert.assertTrue(bst.getPreOrderTraversal().get(5) == 59);
            
        } catch (Exception e) {
            //e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }
    
    /** 
     * Insert 66, 32, 35, 30, 46, 59. The postorder traversal should produce a 
     * list containing 30, 59, 46, 35, 32 and 66.
     * 
     */
    @Test
    void testBST_011_getPostOrderTraversal() {
    	try {
            bst.insert(66, "66"); 
            bst.insert(32, "32");
            bst.insert(35, "35");
            bst.insert(30, "30");
            bst.insert(46, "46");
            bst.insert(59, "59");
            Assert.assertTrue(bst.getPostOrderTraversal().get(0) == 30);
            Assert.assertTrue(bst.getPostOrderTraversal().get(1) == 59);
            Assert.assertTrue(bst.getPostOrderTraversal().get(2) == 46);
            Assert.assertTrue(bst.getPostOrderTraversal().get(3) == 35);
            Assert.assertTrue(bst.getPostOrderTraversal().get(4) == 32);
            Assert.assertTrue(bst.getPostOrderTraversal().get(5) == 66);
            
        } catch (Exception e) {
            //e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }
    
    /** 
     * Insert 66, 32, 35, 30, 46, 59. The level order traversal should produce a 
     * list containing 66, 32, 30, 35, 46 and 59.
     * 
     */
    @Test
    void testBST_012_getLevelOrderTraversal() {
    	try {
            bst.insert(66, "66"); 
            bst.insert(32, "32");
            bst.insert(35, "35");
            bst.insert(30, "30");
            bst.insert(46, "46");
            bst.insert(59, "59");
            Assert.assertTrue(bst.getLevelOrderTraversal().get(0) == 66);
            Assert.assertTrue(bst.getLevelOrderTraversal().get(1) == 32);
            Assert.assertTrue(bst.getLevelOrderTraversal().get(2) == 30);
            Assert.assertTrue(bst.getLevelOrderTraversal().get(3) == 35);
            Assert.assertTrue(bst.getLevelOrderTraversal().get(4) == 46);
            Assert.assertTrue(bst.getLevelOrderTraversal().get(5) == 59);
            
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
    void testBST_013_getHeight() {
    	try {
            bst.insert(66, "66"); 
            Assert.assertEquals(bst.getHeight(), 1);
            bst.insert(32, "32");
            Assert.assertEquals(bst.getHeight(), 2);
            bst.insert(35, "35");
            Assert.assertEquals(bst.getHeight(), 3);
            bst.insert(30, "30");
            Assert.assertEquals(bst.getHeight(), 3);
            bst.insert(46, "46");
            Assert.assertEquals(bst.getHeight(), 4);
            bst.insert(59, "59");
            Assert.assertEquals(bst.getHeight(), 5);
            
        } catch (Exception e) {
            //e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }
    
    
    /** 
     * Insert 66, 32, 35, 30, 46, 59. Check the size of bst after each insertion.
     * 
     */
    @Test
    void testBST_014_numKeys() {
    	try {
            bst.insert(66, "66"); 
            Assert.assertEquals(bst.numKeys(), 1);
            bst.insert(32, "32");
            Assert.assertEquals(bst.numKeys(), 2);
            bst.insert(35, "35");
            Assert.assertEquals(bst.numKeys(), 3);
            bst.insert(30, "30");
            Assert.assertEquals(bst.numKeys(), 4);
            bst.insert(46, "46");
            Assert.assertEquals(bst.numKeys(), 5);
            bst.insert(59, "59");
            Assert.assertEquals(bst.numKeys(), 6);
            
        } catch (Exception e) {
            //e.printStackTrace();
            fail( "Unexpected exception: "+e.getMessage() );
        }
    }


}
