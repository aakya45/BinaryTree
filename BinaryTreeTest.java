package binarytree;

public class BinaryTreeTest {

	public static void main(String[] args) 
	{
		//  levelwise insert and traversal
		BinaryTree bt=new BinaryTree();
		bt.insertNodeLevelWise(10);
		bt.insertNodeLevelWise(20);
		bt.insertNodeLevelWise(30);
		bt.insertNodeLevelWise(40);
		
		BinaryTree bt1=new BinaryTree();
		bt1.insertNodeLevelWise(10);
		bt1.insertNodeLevelWise(20);
		bt1.insertNodeLevelWise(30);
		bt1.insertNodeLevelWise(40);
		
		
		bt.Inorder();
		System.out.println();
		bt1.Inorder();
		System.out.println();
		
		boolean b=BinaryTree.isIdentical(bt, bt1);
		if(b)
			System.out.println("both trees are identical");
		else
			System.out.println("not identical");
	}
}
