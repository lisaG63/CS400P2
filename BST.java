import java.util.ArrayList;
import java.util.List;

/**
 * BST created by Weihang Guo on MacBook in p2 project
 * 
 * Author: Weihang Guo(wguo63@wisc.edu)
 * Date:   @2.26
 * 
 * Course: CS400
 * Semester: Spring 2020
 * Lecture: 002
 * 
 * IDE: Eclipse IDE for Java Developers
 * Version: 2019-12(4.14.0)
 * Build id: 20191212-1212
 * 
 * Device: LisaG's MACBOOK
 * OS: macOS Mojave
 * Version: 10.14.4
 * OS Build: 1.8 GHz Intel Core i5
 * 
 * List Collaborators: None
 * 
 * Other Credits: None
 * 
 * Known Bugs: None
 */

/**
 * Defines the operations required of student's BST class.
 *
 * @author Deb Deppeler (deppeler@cs.wisc.edu), Weihang Guo (wguo63@wisc.edu)
 * @param <K> A Comparable type to be used as a key to an associated value.
 * @param <V> A value associated with the given key.
 */
public class BST<K extends Comparable<K>, V> implements STADT<K, V> {

	private Node root;
	private int size;
	//lists containing the elements of the binary search tree in different orders.
	private List<K> inOrder;
	private List<K> preOrder;
	private List<K> postOrder;
	private List<K> levelOrder;

	/**
	 * Node - the node in a binary search tree
	 * @author Weihang Guo
	 * 
	 */
	private class Node {

		private K key;
		private V value;
		private Node leftChild;
		private Node rightChild;

		/**
		 * The constructor of class node
		 * @param key the key of the node
		 * @param value the value of the node
		 */
		private Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * Get key of the node.
		 * @return key of the node.
		 */
		private K getKey() {
			return key;
		}

		/**
		 * Get value of the node.
		 * @return value of the node.
		 */
		private V getValue() {
			return value;
		}

		/**
		 * Get the left child of the node.
		 * @return the left child of the node
		 */
		private Node left() {
			return leftChild;
		}

		/**
		 * Get the right child of the node.
		 * @return the rightt child of the node
		 */
		private Node right() {
			return rightChild;
		}

		/**
		 * Set the left child to node
		 * @param node the node to be the left child
		 */
		private void setLeft(Node node) {
			leftChild = node;
		}
		
		/**
		 * Set the right child to node
		 * @param node the node to be the right child
		 */
		private void setRight(Node node) {
			rightChild = node;
		}

		/**
		 * Set key of the node
		 * @param key the key of the node
		 */
		private void setKey(K key) {
			this.key = key;
		}

		/**
		 * Set value of the node
		 * @param key the value of the node
		 */
		private void setValue(V value) {
			this.value = value;
		}

	}

	/**
	 * Constructor of BST class.
	 */
	public BST() {
		size = 0;
		inOrder = new ArrayList<K>();
		preOrder = new ArrayList<K>();
		postOrder = new ArrayList<K>();
		levelOrder = new ArrayList<K>();
	}

	/**
	 * Returns the key that is in the root node of this ST. If root is null, returns
	 * null.
	 * 
	 * @return key found at root node, or null
	 */
	public K getKeyAtRoot() {
		return root.getKey();
	}

	/**
	 * Tries to find a node with a key that matches the specified key. If a matching
	 * node is found, it returns the returns the key that is in the left child. If
	 * the left child of the found node is null, returns null.
	 * 
	 * @param key A key to search for
	 * @return The key that is in the left child of the found key
	 * 
	 * @throws IllegalNullKeyException if key argument is null
	 * @throws KeyNotFoundException    if key is not found in this BST
	 */
	public K getKeyOfLeftChildOf(K key) throws IllegalNullKeyException, KeyNotFoundException {
		if (key == null) //throws IllegalNullKeyException if key argument is null
			throw new IllegalNullKeyException();
		if (!contains(key)) //throws KeyNotFoundException if key is not found in this BST
			throw new KeyNotFoundException();
		if (getNodeWith(key, root).left() == null) 
			return null;//If the left child of the found node is null, returns null.
		return getNodeWith(key, root).left().getKey();
		//If a matching node is found, it returns the returns the key that is in the left child.
	}

	/**
	 * Get the node with the given key
	 * @param key the key of the node to be found
	 * @param node the current node
	 * @return the node with the given key
	 */
	private Node getNodeWith(K key, Node node) {
		if (key == node.getKey()) {
			return node;//if the node is found, return the node
		} else if (key.compareTo(node.getKey()) > 0) {
			return getNodeWith(key, node.right());//recur down the right subtree
		}
		return getNodeWith(key, node.left());//recur down the left subtree

	}

	/**
	 * Tries to find a node with a key that matches the specified key. If a matching
	 * node is found, it returns the returns the key that is in the right child. If
	 * the right child of the found node is null, returns null.
	 * 
	 * @param key A key to search for
	 * @return The key that is in the right child of the found key
	 * 
	 * @throws IllegalNullKeyException if key is null
	 * @throws KeyNotFoundException    if key is not found in this BST
	 */
	public K getKeyOfRightChildOf(K key) throws IllegalNullKeyException, KeyNotFoundException {
		if (key == null) //throws llegalNullKeyException if key is null
			throw new IllegalNullKeyException();
		if (!contains(key)) //throws KeyNotFoundException if key is not found in this BST
			throw new KeyNotFoundException();
		if (getNodeWith(key, root).right() == null) 
			return null;//If the right child of the found node is null, returns null.
		return getNodeWith(key, root).right().getKey();
		//If a matching node is found, it returns the returns the key that is in the right child.
	}

	/**
	 * Returns the height of this BST. H is defined as the number of levels in the
	 * tree.
	 * 
	 * If root is null, return 0 If root is a leaf, return 1 Else return 1 + max(
	 * height(root.left), height(root.right) )
	 * 
	 * Examples: A BST with no keys, has a height of zero (0). A BST with one key,
	 * has a height of one (1). A BST with two keys, has a height of two (2). A BST
	 * with three keys, can be balanced with a height of two(2) or it may be linear
	 * with a height of three (3) ... and so on for tree with other heights
	 * 
	 * @return the number of levels that contain keys in this BINARY SEARCH TREE
	 */
	public int getHeight() {
		// If root is null, return 0
		if (root == null) 
			return 0;
		// If root is a leaf, return 1
		else if (root.left() == null && root.right() == null) 
			return 1;
		// Else return 1 + max( height(root.left), height(root.right) )
		return 1 + Math.max(getHeight(root.left()), getHeight(root.right()));
	}

	/**
	 * the helper method of getHeight()
	 * @param node the node of which the height is being calculated
	 * @return the height of the node
	 */
	private int getHeight(Node node) {
		// If node is null, return 0
		if (node == null) 
			return 0;
		// If node is a leaf, return 1
		else if (node.left() == null && node.right() == null) 
			return 1;
		// Else return 1 + max( height(node.left), height(node.right) )
		return 1 + Math.max(getHeight(node.left()), getHeight(node.right()));
	}

	/**
	 * Returns the keys of the data structure in sorted order. In the case of binary
	 * search trees, the visit order is: L V R
	 * 
	 * If the SearchTree is empty, an empty list is returned.
	 * 
	 * @return List of Keys in-order
	 */
	public List<K> getInOrderTraversal() {
		// If the SearchTree is empty, an empty list is returned.
		if (root == null) {
			return new ArrayList<K>();
		}
		inOrder.clear();//clear the list every time this method is being called
		return inOrder(root);

	}


	/**
	 * Get a list of elements in preOrder.
	 * @param current the current node
	 * @return a list of elements
	 */
	private List<K> preOrder(Node current) {
		preOrder.add(current.getKey());// add the current root
		if (current.left() != null)
			preOrder(current.left());// recur down the left subtree
		if (current.right() != null)
			preOrder(current.right());// recur down the right subtree
		return preOrder;
	}

	/**
	 * Get a list of elements in postOrder.
	 * @param current the current node
	 * @return a list of elements
	 */
	private List<K> postOrder(Node current) {
		if (current.left() != null)
			postOrder(current.left());// recur down the left subtree
		if (current.right() != null)
			postOrder(current.right());// recur down the right subtree

		postOrder.add(current.getKey());// add the parent node
		return postOrder;
	}

	/**
	 * Get a list of elements in inOrder.
	 * @param current the current node
	 * @return a list of elements
	 */
	private List<K> inOrder(Node current) {
		if (current.left() != null)
			inOrder(current.left());// recur down the left subtree

		inOrder.add(current.getKey());// add the parent node

		if (current.right() != null)
			inOrder(current.right());// recur down the right subtree

		return inOrder;
	}

	/**
	 * Returns the keys of the data structure in pre-order traversal order. In the
	 * case of binary search trees, the order is: V L R
	 * 
	 * If the SearchTree is empty, an empty list is returned.
	 * 
	 * @return List of Keys in pre-order
	 */
	public List<K> getPreOrderTraversal() {
		// If the SearchTree is empty, an empty list is returned.
		if (root == null) {
			return new ArrayList<K>();
		}
		preOrder.clear();//clear the list every time this method is being called
		return preOrder(root);
	}

	/**
	 * Returns the keys of the data structure in post-order traversal order. In the
	 * case of binary search trees, the order is: L R V
	 * 
	 * If the SearchTree is empty, an empty list is returned.
	 * 
	 * @return List of Keys in post-order
	 */
	public List<K> getPostOrderTraversal() {
		// If the SearchTree is empty, an empty list is returned.
		if (root == null) {
			return new ArrayList<K>();
		}
		postOrder.clear();//clear the list every time this method is being called
		return postOrder(root);
	}

	/**
	 * Returns the keys of the data structure in level-order traversal order.
	 * 
	 * The root is first in the list, then the keys found in the next level down,
	 * and so on.
	 * 
	 * If the SearchTree is empty, an empty list is returned.
	 * 
	 * @return List of Keys in level-order
	 */
	public List<K> getLevelOrderTraversal() {
		// If the SearchTree is empty, an empty list is returned.
		if (root == null) {
			return new ArrayList<K>();
		}
		levelOrder.clear();//clear the list every time this method is being called
		levelOrder.add(root.getKey());
		List<Node> helpList = new ArrayList<Node>();
		//create a helper list which contains elements of the current level
		helpList.add(root);//add the root to the helplist.
		return levelOrder(helpList);

	}

	/**
	 * the helper method to get level order traversal.
	 * @param helpList a list of elments in current level
	 * @return List of Keys in level-order
	 */
	private List<K> levelOrder(List<Node> helpList) {
		List<Node> nextList = new ArrayList<Node>();
		//create a list to contain the elements in next level
		int maxHeight = getHeight(helpList.get(0));
		//calculate the max height in this level
		for (int i = 1; i < helpList.size(); i++) {
			if (getHeight(helpList.get(i)) > maxHeight) {
				maxHeight = getHeight(helpList.get(i));
			}
		}
		// base case: if all the nodes are leaf nodes
		if (maxHeight == 1) {
			return levelOrder;
		}
		//updates the levelOrder list and the nextList with current level's children
		for (int i = 0; i < helpList.size(); i++) {
			if (helpList.get(i).left() != null) {
				levelOrder.add(helpList.get(i).left().getKey());
				nextList.add(helpList.get(i).left());
			}
			if (helpList.get(i).right() != null) {
				levelOrder.add(helpList.get(i).right().getKey());
				nextList.add(helpList.get(i).right());
			}
		}
		levelOrder(nextList);// recur down the next level
		return levelOrder;
	}

	/**
	 * Add the key,value pair to the data structure and increase the number of keys.
	 * If key is null, throw IllegalNullKeyException; If key is already in data
	 * structure, throw DuplicateKeyException(); Do not increase the num of keys in
	 * the structure, if key,value pair is not added.
	 * @param key the key of the node to be inserted
	 * @param value the value of the node to be inserted
	 * @throws IllegalNullKeyException if key is null
	 * @throws DuplicateKeyException if key is already in data structure
	 * 
	 */
	public void insert(K key, V value) throws IllegalNullKeyException, DuplicateKeyException {
		if (contains(key))
			throw new DuplicateKeyException();
		root = insertHelper(root, key, value);
		size++;//updates the size
	}
	

	/**
	 * The helper method of insert
	 * @param current the current node
	 * @param key the key of the node to be inserted
	 * @param value the value of the node to be inserted
	 * @return the current node
	 * @throws IllegalNullKeyException if key is null
	 * @throws DuplicateKeyException if key is already in data structure
	 */
	private Node insertHelper(Node current, K key, V value) throws IllegalNullKeyException, 
		DuplicateKeyException {
		if (current == null) {// if the current node is null, insert the new node with no child
			current = new Node(key, value);
		} else if (current.getKey().compareTo(key) < 0) {
			// if the key of the new node is larger than the current node' key
			current.setRight(insertHelper(current.right(), key, value));
			// insert the new node in the right subtree
		} else if (current.getKey().compareTo(key) > 0) {
			// if the key of the new node is smaller than the current node's key
			current.setLeft(insertHelper(current.left(), key, value));
			// insert the new node in the left subtree
		} else {
			throw new DuplicateKeyException();
		}
		return current;
	}
	

	/**
	 * If key is found, remove the key,value pair from the data structure and
	 * decrease num keys, and return true. If key is not found, do not decrease the
	 * number of keys in the data structure, return false. If key is null, throw
	 * IllegalNullKeyException
	 * @param key the key of the node to be removed
	 * @return true if the node is found and deleted, false if the key is not found
	 * @throws IllegalNullKeyException if key is null
	 */
	public boolean remove(K key) throws IllegalNullKeyException {
		if (key == null)//throws IllegalNullKeyException if key is null
			throw new IllegalNullKeyException();
		if (!contains(key))
			return false;//return false if the key is not found
		root = removeHelper(root, key);
		size--;//updates the size
		return true;
	}
	
	

	/**
	 * a helper method of remove
	 * @param current the current node
	 * @param key the key of the node to be deleted
	 * @return the current node
	 */
	private Node removeHelper(Node current, K key) {
		if (current.getKey().compareTo(key) == 0) {// if the key is found at the current root
			if (current.left() == null) {
				// if the current root has one right node child or no children
				return current.right();// replace the current root with the right child
			} else if (current.right() == null) {// if the current root has only the left child
				return current.left();// replace the current root with the left child
			} else {
				// if the current root has both children
				Node leftmost = leftmost(current.right());
				current.setKey(leftmost.getKey());
				current.setValue(leftmost.getValue());
				// replace the current root with the leftmost node in the right subtree
				current.setRight(removeHelper(current.right(), leftmost.getKey()));
				// remove the leftmost node
			}
		} else if (current.getKey().compareTo(key) < 0) {// if the key is larger than the current root
			current.setRight(removeHelper(current.right(), key));// recur down the right subtree
		} else {
			// if the key is smaller than the current root
			current.setLeft(removeHelper(current.left(), key));// recur down the left subtree
		}
		return current;
	}
	

	/**
	 * The helper method to find the leftmost node
	 * 
	 * @param current the root of the current subtree
	 * @return the leftmost node
	 */
	private Node leftmost(Node current) {
		if (current.left() == null) {
			return current;
			// the base case: when the current node has no left child, return the current
			// node
		}
		// when the current node has a left child, recur down
		return leftmost(current.left());
	}
	

	/**
	 * Returns the value associated with the specified key.
	 *
	 * Does not remove key or decrease number of keys If key is null, throw
	 * IllegalNullKeyException If key is not found, throw KeyNotFoundException().
	 * 
	 * @param key the key of the node whose value is to be get
	 * @return the value of the node with the given key
	 * @throws IllegalNullKeyException if key is null
	 * @throws KeyNotFoundException if key is not found
	 */
	public V get(K key) throws IllegalNullKeyException, KeyNotFoundException {
		if (key == null)
			throw new IllegalNullKeyException();
		if (!contains(key))
			throw new KeyNotFoundException();
		return getNodeWith(key, root).getValue();
	}
	

	/**
	 * Returns true if the key is in the data structure If key is null, throw
	 * IllegalNullKeyException Returns false if key is not null and is not present
	 * 
	 * @param key the key of the node to be determined if it is in the tree
	 * @return true if the key is in the data structure, false if key is not null and is not present
	 * @throws IllegalNullKeyException if key is null
	 */
	public boolean contains(K key) throws IllegalNullKeyException {
		if (key == null)
			throw new IllegalNullKeyException();
		return containsHelper(key, root);
	}
	

	/**
	 * a helper method of contains
	 * @param key the key of the node to be determined if it is in the tree
	 * @param current the current node
	 * @return true if the key is in the data structure, false if key is not null and is not present
	 */
	private boolean containsHelper(K key, Node current) {
		if (current == null) 
			return false;
		if (key == current.getKey()) 
			return true;
		if (key.compareTo(current.getKey()) > 0) 
			return containsHelper(key, current.right());//recur down the right subtree
		return containsHelper(key, current.left());//recur down the left subtree
	}
	

	/**
	 * Returns the number of key,value pairs in the data structure
	 * @return the number of key,value pairs in the data structure
	 */
	public int numKeys() {

		return size;
	}
	



	/**
	 * create an array to store every character of the elements in the tree
	 * @param current the current node
	 * @param row the row in the array
	 * @param start the beginning column of current subtree
	 * @param end the ending column of current subtree
	 * @param keys the array which stores every character of the element in the tree
	 */
	private void arrange(Node current, int row, int start, int end, String[][] keys) {
		if (current == null)//if there is no element in the tree
			return;
		String keyString = String.valueOf(current.getKey());//convert the key into string
		char[] cr = keyString.toCharArray();//store every character in the string
		//split the two characters
		int col = (start + end) / 2;//the col of the first character
		int left = (start + col -1) / 2 + 1;//the last character of its left child
		int right = (col + 2 + end) / 2;//the first character of its right child
		int leftMiddle = (col + left) / 2;
		//the middle point between the current node and the left child
		int rightMiddle = (col + 1 + right) / 2;
		//the middle point between the current node and the left child
		//assign the two characters of this element
		keys[row][col] = String.valueOf(cr[0]);
		keys[row][col + 1] = String.valueOf(cr[1]);
		//assign the lines connecting parent node with child nodes
		if (current.left() != null) {
			keys[row +1][leftMiddle] = "/";
			arrange(current.left(), row + 2, start, col - 1, keys);
		} 
		if (current.right() != null) {
			keys[row + 1][rightMiddle] = "\\";
			arrange(current.right(), row + 2, col + 2, end, keys);
		}

		
	}
	
	/**
	 * Print the tree.
	 *
	 */

	public void print() {
		int height = getHeight();
		//compute number of rows and columns according to the height of tree
		int row = 2 * height - 1;
		int col = (int) (Math.pow(2, height + 1) - 2);
		String[][] keys = new String[row][col];//create an array to store the elements
		arrange(root, 0, 0, col - 1, keys);
		//fill the other positions in the array with spaces
		for (int i = 0; i < keys.length; i++) {
			for (int j = 0; j < keys[i].length; j++) {
				if (keys[i][j] == null)
					keys[i][j] = " ";
			}
		}
		//print out the array
		for (int i = 0; i < keys.length; i++) {
			for (int j = 0; j < keys[i].length; j++) {
				System.out.print(keys[i][j]);
			}
			System.out.println();
		}
	}

} // copyrighted material, students do not have permission to post on public sites

//  deppeler@cs.wisc.edu
