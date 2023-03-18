package binarytree;

public class BinaryTreeNode 
{
	private int data;
	private BinaryTreeNode right,left;

	//default constructore
	public BinaryTreeNode()
	{
		super();
	}
	//parameterized constructore
	public BinaryTreeNode(int data)
	{
		super();
		this.data = data;
		this.right = null;
		this.left = null;
	}

	//getter setter
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	//to string
	@Override
	public String toString() 
	{
		String str="";
		return str+=" "+data+" ";
	}


}
