import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BSTTest {

	BSTree tree1;
	BSTree tree2;
	BSTree tree3;
	BSTree tree4;
	Integer a;
	Integer b;
	Integer c;
	Integer d;
	Integer e;
	
	
	@BeforeEach 
	void setUp() throws Exception {
		tree1 = new BSTree();
		tree2 = new BSTree();
		tree3 = new BSTree();
		tree4 = new BSTree();
		a = new Integer(5);
		b = new Integer(1);
		c = new Integer(10);
		d = new Integer(11);
		e = new Integer(3);
	}
	
	@Test
	void treeTest() {
		//Testing BSTree methods
		assertTrue(tree1.isEmpty());
		assertEquals(0, tree1.getSize());
		
		//Insert Test
		tree1.insert(a);
		//isEmpty test
		assertFalse(tree1.isEmpty());
		//Retrieve test
		
		assertEquals(5, tree1.retrieve(a).intValue());
		assertNull(tree1.retrieve(14));
		
		//Dead code???
		assertEquals(1, tree1.getSize());
		
		tree1.insert(b);
		
		assertEquals(2, tree1.getSize());
		tree1.insert(c);
		
		//Testing size and depth
		assertEquals(3, tree1.getSize());
		assertEquals(0, tree1.retrieveDepth(a));
		assertEquals(2, tree1.retrieveDepth(d));
		assertEquals(2, tree1.retrieveDepth(new Integer(0)));
		assertEquals(2, tree1.retrieveDepth(e));
		assertEquals(2, tree1.retrieveDepth(new Integer(7)));
		
		//Testing largest()
		assertEquals(10, tree1.largest().intValue());
		tree1.insert(d);
		assertEquals(11, tree1.largest().intValue());
		
		tree1.insert(e);
		assertEquals(11, tree1.largest().intValue());
		
		
		//Testing toList
		List<Integer> templist = tree1.toList();
		assertEquals(1, templist.get(0).intValue());
		assertEquals(3, templist.get(1).intValue());
		assertEquals(5, templist.get(2).intValue());
		assertEquals(10, templist.get(3).intValue());
		assertEquals(11, templist.get(4).intValue());
		
		
		assertEquals(30, tree1.sum());
		
		//Tree 1: 5,1,10,11,3
		//Tree 2: 
		//Tree 3:
		
		//Full to empty, empty to full
		assertFalse(tree1.myEquals(tree2));
		assertFalse(tree2.myEquals(tree1));
		//Empty to empty
		assertTrue(tree2.myEquals(tree3));
		assertTrue(tree3.myEquals(tree2));
		
		tree2.insert(a);
		tree2.insert(b);
		tree2.insert(c);
		tree2.insert(d);
		tree2.insert(e);
		//Tree 2: 5,1,10,11,3
		
		//Original Tree to Copy Tree, copy tree to original tree
		assertTrue(tree1.myEquals(tree2));
		assertTrue(tree2.myEquals(tree1));
		
		tree3.insert(b);
		tree3.insert(a);
		tree3.insert(c);
		tree3.insert(e);
		tree3.insert(d);
		//Tree 3: 1, 5, 10, 3, 11
		
		//Orig Tree to New tree, new tree to orig tree
		assertFalse(tree1.myEquals(tree3));
		assertFalse(tree3.myEquals(tree1));
		
		tree4.insert(20);
		tree4.insert(10);
		tree4.insert(4);
		tree4.insert(55);
		tree4.insert(30);
		tree4.insert(99);
		tree4.insert(24);
		
		assertFalse(tree4.myEquals(tree1));
		assertFalse(tree1.myEquals(tree4));
		
		assertFalse(tree4.myEquals(tree3));
		assertFalse(tree3.myEquals(tree4));
		
		
		assertEquals(11, tree2.largest().intValue());
		assertEquals(11, tree3.largest().intValue());
		assertEquals(99, tree4.largest().intValue());
		assertEquals(242, tree4.sum());
		
		BSTree removedleft = new BSTree();
		BSTree addleft = new BSTree();
		BSTree removedright = new BSTree();
		BSTree addright = new BSTree();
		
		removedleft.insert(a);
		removedleft.insert(b);
		removedleft.insert(c);
		removedleft.insert(d);
		
		addleft.insert(a);
		addleft.insert(b);
		addleft.insert(c);
		addleft.insert(d);
		addleft.insert(e);
		addleft.insert(0);
		
		removedright.insert(a);
		removedright.insert(b);
		removedright.insert(c);
		removedright.insert(e);
		
		addright.insert(a);
		addright.insert(b);
		addright.insert(c);
		addright.insert(d);
		addright.insert(e);
		addright.insert(7);
		
		assertFalse(tree1.myEquals(removedleft));
		assertFalse(removedleft.myEquals(tree1));
		
		assertFalse(tree1.myEquals(addleft));
		assertFalse(addleft.myEquals(tree1));
		
		assertFalse(tree1.myEquals(removedright));
		assertFalse(removedright.myEquals(tree1));
		
		assertFalse(tree1.myEquals(addright));
		assertFalse(addright.myEquals(tree1));
		
		
	}
	
	@Test
	void nodeTest() {
		
	}
}


