import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeTreeTest {
	
	MorseCodeTree tree = new MorseCodeTree();

	@Before
	public void setUp() throws Exception {
		
		
	}

	@After
	public void tearDown() throws Exception {
		
		tree = null;
	}


	/**
	 * Method that test's the insert method, due to the recursive nature
	 * of this method it will add 1 as a new level in the binary tree
	 */
	@Test
	public void testInsert() 
	{

		tree.insert(".---", "1");
		String letterFetched = tree.fetch(".---");
		assertEquals("1", letterFetched);
	}

	/**
	 * Method that check's to see if the root was sent
	 */
	@Test
	public void testGetRoot() {
		
		String root;
    	root = tree.getRoot().getData();
		assertEquals("", root);
		
	}

	
	/**
	 * Method that check's to see if the setRoot method works
	 */
	@Test
	public void testSetRoot() {
				
		String newRoot;
		assertEquals("", tree.getRoot().getData());
		TreeNode<String> name = new TreeNode <String> ("STUDENT");
		tree.setRoot(name);
		newRoot = tree.getRoot().getData();
		assertEquals("STUDENT", newRoot);
	}

	/**
	 * Method that checks to see if a specific Morse letter matches
	 * the English letter that it corresponds to
	 */
	@Test
	public void testFetch() {
		
		String letterFetched;
		letterFetched = tree.fetch("-..-");
		assertEquals("x", letterFetched);
	    String letterFetched2;
		letterFetched2 = tree.fetch(".--.");
		assertEquals("p", letterFetched2);

	}


	/**
	 * Method that checks to see if the ArrayList of items in the LinkedList is
	 * arranged in order 
	 */
	@Test
	public void testToArrayList() {
				
		ArrayList<String> list = new  ArrayList<String>();
		list = tree.toArrayList();
		
		assertEquals("h", list.get(0));
		assertEquals("s", list.get(1));
		assertEquals("v", list.get(2));
		assertEquals("i", list.get(3));
		assertEquals("f", list.get(4));
		assertEquals("u", list.get(5));
		assertEquals("e", list.get(6));
		assertEquals("l", list.get(7));
		assertEquals("r", list.get(8));
		assertEquals("a", list.get(9));
		assertEquals("p", list.get(10));
		assertEquals("w", list.get(11));
		assertEquals("j", list.get(12));
		assertEquals("", list.get(13));
		assertEquals("b", list.get(14));
		assertEquals("d", list.get(15));
		assertEquals("x", list.get(16));
		assertEquals("n", list.get(17));
		assertEquals("c", list.get(18));
		assertEquals("k", list.get(19));
		assertEquals("y", list.get(20));
		assertEquals("t", list.get(21));
		assertEquals("z", list.get(22));
		assertEquals("g", list.get(23));
		assertEquals("q", list.get(24));
		assertEquals("m", list.get(25));
		assertEquals("o", list.get(26));

	}
}
  