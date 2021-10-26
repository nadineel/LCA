from unittest import TestCase
from LCA import Node, findLCA


class LCATest(TestCase):
    def find_lca(self):
        root = Node(1)
        root.left = Node(2)
        root.right = Node(3)
        root.left.left = Node(4)
        root.left.right = Node(5)
        root.right.left = Node(6)
        root.right.right = Node(7)
        self.assertEqual(findLCA(root,2,3),1,"LCA (2,3) = 1")
        self.assertEqual(findLCA(root, 4, 6), 1, "LCA (4,6) = 1")
        self.assertEqual(findLCA(root, 4, 5), 2, "LCA (4,5) = 2")
        

    def test_empty_node(self):
        root = Node(1)
        root.left = Node(2)
        root.right = Node(3)
        self.assertEqual(findLCA(root, 1,4), -1, "LCA (1,4)=-1")

    def test_leftLeaningTree(self):
        root = Node(1)
        root.left = Node(2)
        root.right = Node(3)
        root.left.left = Node(4)
        root.left.left.left = Node(5)
        root.left.left.left.left = Node(6)
        self.assertEqual(findLCA(root, 1,6),1, "LCA (1,6)=1")
        self.assertEqual(findLCA(root, 4,5),4, "LCA (4,5)=4")

    def test_rightLeaningTree(self):
        root = Node(1)
        root.left = Node(2)
        root.right = Node(3)
        root.right.right = Node(4)
        root.right.right.right = Node(5)
        root.right.right.right.right = Node(6)
        self.assertEqual(findLCA(root, 1,5),1, "LCA (1,5)=1")
        self.assertEqual(findLCA(root, 2,3),1, "LCA (2,3)=2")