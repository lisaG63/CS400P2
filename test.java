import java.util.List;

public class test {
	private test parent;
	private test child;
	private String value;
	public test(String value) {
		this.value = value;
	}
	public void setChild(test other) {
		child = other;
		child.setParent(this);
	}
	
	public void setParent(test other) {
		parent = other;
	}
	
	public test getParent() {
		return parent;
	}
	
	public void print() {
		System.out.println(value);
	}

  public static void main(String[] args) {
	  int a = 1;
	  int b = 3;
	  double c = (double)a/(double)b;
	  System.out.println(c);
	  Integer d = 3;
	  System.out.println(d + "'s hashCode is " + d.hashCode());
      BST<Integer, String> bst = new BST<Integer, String>();
      try {
    	  bst.insert(66, "66");
    	  System.out.println(bst.getLevelOrderTraversal());
          bst.insert(32, "32");
          System.out.println(bst.getLevelOrderTraversal());
          bst.insert(35, "35");
          System.out.println(bst.getLevelOrderTraversal());
          bst.insert(30, "30");
          System.out.println(bst.getLevelOrderTraversal());
          bst.insert(46, "46");
          System.out.println(bst.getLevelOrderTraversal());
          bst.insert(59, "59");
          System.out.println(bst.getLevelOrderTraversal());
//        newTree.insert(20, "AA");
//        newTree.insert(15, "AA");
//        newTree.insert(12, "AA");
//        newTree.insert(10, "AA");
//        newTree.insert(13, "AA");
//        newTree.insert(17, "AA");
//        newTree.insert(30, "AA");
//        newTree.print();
//        newTree.remove(15);
//        newTree.print();
      } catch (IllegalNullKeyException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (DuplicateKeyException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
//      List<Integer> inOrder = newTree.getInOrderTraversal();
//      List<Integer> PreOrder = newTree.getPreOrderTraversal();
//      List<Integer> PostOrder = newTree.getPostOrderTraversal();
//      List<Integer> LevelOrder = newTree.getLevelOrderTraversal();
//      System.out.println(LevelOrder);
//      newTree.print();
	  
//	  RBT<Integer, String> newTree = new RBT<Integer, String>();
//	    try {
//	    newTree.insert(10, "AA");
//	    System.out.println(newTree.contains(10));
//
//	    newTree.insert(30, "AA");
//	    System.out.println(newTree.getKeyOfRightChildOf(10).equals(30));
//	    System.out.println(newTree.colorOf(30));
//	    newTree.insert(20, "AA");
//	    System.out.println(newTree.getKeyOfLeftChildOf(30));
//	    System.out.println("root: " + newTree.getKeyAtRoot());
//	    System.out.println(newTree.contains(20));
//	    System.out.println(newTree.getKeyOfLeftChildOf(20));
//	    System.out.println(newTree.getKeyOfRightChildOf(20));
////	    newTree.insert(76, "AA");
////	    newTree.insert(13, "AA");
////	    newTree.insert(25, "AA");
////	    newTree.insert(45, "AA");
////	    newTree.insert(52, "AA");
//	    } catch (IllegalNullKeyException e) {
//	    	// TODO Auto-generated catch block
//	    	e.printStackTrace();
//	    } catch (DuplicateKeyException e) {
//	    	// TODO Auto-generated catch block
//	    	e.printStackTrace();
//	    } catch (KeyNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	  
//	  test newTest = new test("1");
//	  test test2 = new test("2");
//	  newTest.setChild(test2);
//	  test2.getParent().print();
	  
	  
	  
	  
  }

}
