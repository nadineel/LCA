import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
    
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

}
