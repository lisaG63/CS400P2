/**
 * CompareDS - compares the performance of RBT against BST
 * @author Weihang Guo
 * 
 */
public class CompareDS {

	  /**
	   * Compare the performance of RBT and BST, and print out the result.
	   * @param testNumber the number of work to do
	   */
	  private void compare(int testNumber) {
	    //create a RBT and a BST
	    RBT<Integer, String> rbt = new RBT<Integer, String>();
	    BST<Integer, String> bst = new BST<Integer, String>();
	    //compute the time it takes using RBT
	    long startTime1 = System.nanoTime();
	    try { 
	    	for (int i = 0; i < testNumber; i ++) {
	    		rbt.insert(i + 10, String.valueOf(i + 10));
	    		rbt.get(i + 10);
	    	}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    	
	    long endTime1 = System.nanoTime();
	    long rbtTime = endTime1 - startTime1;
	    //compute the time it takes using BST
	    long startTime2 = System.nanoTime();
	    try {
	    	for (int i = 0; i < testNumber; i ++) {
	    		bst.insert(i + 10, String.valueOf(i + 10));
	    		bst.get(i + 10);
		    	}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    long endTime2 = System.nanoTime();
	    long bstTime = endTime2 - startTime2;
	    //display the compare result
	    System.out.println("CompareDS.main Compares work time for: RBT and BST\n"
	        + "Description: insert and retrieve " + testNumber + 
	            " items\n\nRBT is doing work for " + testNumber + " values\nIt took " + rbtTime + 
	                " ns to process " + testNumber + " items\nBST is doing work for " + testNumber + 
	                    " values\nIt took " + bstTime + " ns to process " + testNumber + " items");
	    
	  }
	  
	  
	/**
	 * Main method of the program
	 * 
	 * @param args the string arguments from the command line
	 */
	public static void main(String[] args) {
		CompareDS test = new CompareDS();
		test.compare(10);
	    test.compare(100);
	}

}
