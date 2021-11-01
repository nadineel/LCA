import static org.junit.Assert.assertEquals;
import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;

//@RunWith(JUnit4.class)
    
public class lcaTest {
    @Test 
    public void testLCA(){
        lca tree =new lca();
        tree.root=new Node(1);
        tree.root.left=new Node(2);
        tree.root.right=new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);
        tree.root.right.left=new Node(6);
        tree.root.right.right=new Node(7);

        assertEquals("LCA (5,7) = 1",1, tree.findLCA(5,7));
    }

    @Test
	public void testEmptyTree() {
		lca tree =new lca();
	
		assertEquals("LCA (1,2) = -1",-1, tree.findLCA(1,2));
	}

    @Test
	public void testEmptyNode() {
		lca tree =new lca();
        tree.root=new Node(1);
        tree.root.left=new Node(2);
        tree.root.right=new Node(3);
		
		assertEquals("LCA of (1,4) = -1 ",-1, tree.findLCA(1,5));
		
	}


    @Test
	public void testLeftLeaningTree() {
		lca tree =new lca();
        tree.root=new Node(1);
        tree.root.left=new Node(2);
        tree.root.right=new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.left.left = new Node(5);
		tree.root.left.left.left.left = new Node(6);
		tree.root.left.left.left.left.left = new Node(7);
		assertEquals("LCA of (1,2) = 1",1, tree.findLCA(1,2));
		assertEquals("LCA of (3,4) = 1",1, tree.findLCA(3,4));
		assertEquals("LCA of (6,7) = 6",6, tree.findLCA(6,7));
			
	}

    @Test
	public void testRightLeaningTree() {
		lca tree =new lca();
        tree.root=new Node(1);
        tree.root.left=new Node(2);
        tree.root.right=new Node(3);
		tree.root.right.right = new Node(4);
		tree.root.right.right.right = new Node (5);
		tree.root.right.right.right.right = new Node(6);
		tree.root.right.right.right.right.right = new Node (7);
		
		assertEquals("LCA (1,2) = 1",1, tree.findLCA(1,2));
		assertEquals("LCA (2,4) = 1",1, tree.findLCA(2,4));
		assertEquals("LCA (4,5) = 4",4, tree.findLCA(4,5));

	}

	////////DAG Tests
	@Test
	public void testDAGwithOldLCA() {
//NOT WORKING
/*
			1
		/		\
		2		3
	/		\
	4	--	5
				\
				6
	
			expects that lca for 4,5 is 4 NOT 2	


*/

		lca tree =new lca();
        tree.root=new Node(1);
        tree.root.left=new Node(2);
        tree.root.right=new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node (5);
		tree.root.left.left.right=new Node(5);
		tree.root.left.right.right = new Node (6);
	
		assertEquals("LCA (4,6) = 5",5, tree.findLCA(4,6));

		//expected 5 but actually 2 for this test.

	}
//replaces the previous test
	@Test
	public void testDAGNew(){
		DAG tree=new DAG(6);

/*
			0
		/		\
		1		2
	/		\
	3	--	4
				\
				5
*/		
		tree.addEdge(0, 1);
		tree.addEdge(0, 2);
		tree.addEdge(1, 3);
		tree.addEdge(1, 4);
		tree.addEdge(3, 4);
		tree.addEdge(4, 5);
		
		assertEquals("LCA (3,4) = 3",3, tree.findLCA(0,3,4));
		assertEquals("LCA (3,5) = 3",3, tree.findLCA(0,3,5));
/*
				1
			/	|	
			2--	4----3
				\	  |
				  5	  6

*/

		DAG tree2=new DAG(6);
		tree2.addEdge(1,2);
		tree2.addEdge(1,4);
		tree2.addEdge(2,4);
		tree2.addEdge(3,4);
		tree2.addEdge(4,5);
		tree2.addEdge(3,6);

		assertEquals(4,tree2.findLCA(1, 3, 4));
		assertEquals(1,tree2.findLCA(1, 1, 6));
        assertEquals(2,tree2.findLCA(1, 2, 5));
		assertEquals(2,tree2.findLCA(1, 2, 4));

		assertEquals(-1,tree2.findLCA(0, 2, 5));		//non-existent root
		assertEquals(-1,tree2.findLCA(1, 2, 7));		//non-existent node 2

		assertEquals(-1, tree2.findLCA(6, 1, 2));		//non-existent root
	}


}
