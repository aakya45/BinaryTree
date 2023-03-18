package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree 
{
	private BinaryTreeNode root;
	//constructor
	public BinaryTree() 
	{
		this.root = null;
	}

	//1.ADDING NODE IN TREE
	public void insertBTNode(int data)
	{
		root=insertNode(root,data);
	}
	private BinaryTreeNode insertNode(BinaryTreeNode root,int data)
	{
		if(root==null)
		{
			BinaryTreeNode temp=new BinaryTreeNode(data);
			return temp;
		}
		else
		{
			if(data<root.getData())
			{
				root.setLeft(insertNode(root.getLeft(),data));
			}
			else if(data>root.getData())
			{
				root.setRight(insertNode(root.getRight(),data));
			}
		}
		return root;
	}

	//2.DETETING NODE IN TREE
	public void Delete(int value)
	{
		root=Deletenode(root,value);
	}
	private BinaryTreeNode Deletenode(BinaryTreeNode root,int value)
	{
		//empty root
		if(root==null)
		{
			System.out.println("empty binary tree");
			return root;
		}
		if(value<root.getData())
		{
			root.setLeft(Deletenode(root.getLeft(),value));
		}
		else if(value>root.getData())
		{
			root.setRight(Deletenode(root.getRight(),value));
		}
		else 
		{
			//if(root.left!=null && root.right==null)
			if(root.getRight()==null)
			{
				BinaryTreeNode temp=root.getLeft();
				root.setLeft(null);
				return temp;

			}
			//if(root.left==null && root.right!=null)
			else if(root.getLeft()==null)
			{
				BinaryTreeNode temp=root.getRight();
				root.setRight(null);
				return temp;

			}
			else
			{
				int minvalue=getminvalue(root.getRight());
				root.setData(minvalue);
				root.setRight(Deletenode(root.getRight(),minvalue));      
			}
		}
		return root;
	}
	//Minvalue function
	private int getminvalue(BinaryTreeNode root) 
	{
		while(root.getLeft()!=null)
		{
			root=root.getLeft();
		}
		return root.getData();
	}

	//getting min value
	public int getminvalue()
	{
		if(root==null)
			return -1;
		BinaryTreeNode it=root;
		while(it.getLeft()!=null)
		{
			it=it.getLeft();
		}
		return it.getData();
	}

	//getting Max value
	public int getmaxvalue()
	{
		if(root==null)
			return -1;
		BinaryTreeNode it=root;
		while(it.getRight()!=null)
		{
			it=it.getRight();
		}
		return it.getData();
	}

	//sorting of tree 
	//3.inorder
	public void Inorder()
	{
		PrintInorder(root);
	}
	private void PrintInorder(BinaryTreeNode root)
	{
		if(root!=null)
		{
			PrintInorder(root.getLeft());
			System.out.print(" "+root.getData()+"-->");
			PrintInorder(root.getRight());
		}
	}

	//4.preorder
	public void Preorder()
	{
		Printpreorder(root);
	}
	private void Printpreorder(BinaryTreeNode root)
	{
		if(root!=null)
		{
			System.out.print(" "+root.getData()+"-->");
			Printpreorder(root.getLeft());
			Printpreorder(root.getRight());
		}
	}

	//5.postorder
	public void Postorder()
	{
		Printpostorder(root);
	}
	private void Printpostorder(BinaryTreeNode root)
	{
		if(root!=null)
		{
			Printpostorder(root.getLeft());
			Printpostorder(root.getRight());
			System.out.print(" "+root.getData()+"-->");
		}
	}
	//to string
	public String toString()
	{
		String str="";
		return str;
	}

	//6.level wise traversal BFS
	public void levelWiseTravel()
	{
		BinaryTreeNode it=root;
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();

		if(root==null) 
			return;
		q.add(it);
		while(!q.isEmpty())
		{
			it=q.remove();
			System.out.print(it.getData()+" --> ");

			if(it.getLeft()!=null)
			{
				q.add(it.getLeft());
			}

			if(it.getRight()!=null)
			{
				q.add(it.getRight());
			}
		}
	}

	//7.insert level wise 
	public void insertNodeLevelWise(int data)
	{
		BinaryTreeNode temp=new BinaryTreeNode(data);
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();

		if(root==null)
		{
			root=temp;
			return;
		}
		BinaryTreeNode it=root;
		q.add(it);
		while(!q.isEmpty())
		{
			it=q.remove();
			//for left node 
			if(it.getLeft()==null)
			{
				it.setLeft(temp);
				return;
			}
			else
				q.add(it.getLeft());

			//for right node 
			if(it.getRight()==null)
			{
				it.setRight(temp);
				return;
			}
			else
				q.add(it.getRight());
		}
	}

	//8. leaf node printing or find out leaf nodes
	public void leafNodePrinting()
	{
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();

		if(root==null)
			System.out.print("empty binary tree");

		BinaryTreeNode it=root;
		q.add(it);
		while(!q.isEmpty())
		{
			it=q.remove();

			if(it.getLeft()==null && it.getRight()==null)
				System.out.print(it.getData()+" --> ");

			if(it.getLeft()!=null)
				q.add(it.getLeft());

			if(it.getRight()!=null)
				q.add(it.getRight());
		}
	}

	//9.finding height of tree
	public int heightOfBinaryTree()
	{
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		if(root==null)
		{
			System.out.println("binary tree is empty");  
			return 0;
		}

		BinaryTreeNode dummy=new BinaryTreeNode(-999);
		BinaryTreeNode it=root;
		q.add(it);
		q.add(dummy);
		int count=1;
		while(!q.isEmpty())
		{
			it=q.remove();
			if(it.getData()== -999)
			{
				++count;
				q.add(dummy);
				continue;
			}
			if(it.getLeft()!=null)
			{
				q.add(it.getLeft());
			}
			if(it.getRight()!=null)
			{
				q.add(it.getRight());
			}
		}
		return count;
	}

	//10.swap function for binary tree for mirror image
	private void swapBinaryTreeNode(BinaryTreeNode it)
	{
		BinaryTreeNode temp;
		temp=it.getLeft();
		it.setLeft(it.getRight());
		it.setRight(temp);
	}

	//11.mirror image
	public void mirrorImage()
	{
		BinaryTreeNode it=root;
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();

		if(it==null) return;
		q.add(it);

		while(!q.isEmpty())
		{
			it=q.remove();
			swapBinaryTreeNode(it);

			if(it.getLeft()!=null)
				q.add(it.getLeft());

			if(it.getRight()!=null)
				q.add(it.getRight());
		}
	}

	//12.two tress identical or not
	public static boolean isIdentical(BinaryTree bt1,BinaryTree bt2)
	{
		BinaryTreeNode it1=bt1.root;
		BinaryTreeNode it2=bt2.root;

		Queue<BinaryTreeNode> q1=new LinkedList<BinaryTreeNode>();
		Queue<BinaryTreeNode> q2=new LinkedList<BinaryTreeNode>();

		if(it1==null && it2==null) return true;
		if(it1==null && it2!=null) return false;
		if(it1!=null && it2==null) return false;
		
		q1.add(it1);
		q2.add(it2);

		while(!q1.isEmpty() && !q2.isEmpty())
		{
			it1=q1.remove();
			it2=q2.remove();

			if(it1.getData()!=it2.getData()) return false;

			if(it1.getLeft()!=null)
				q1.add(it1.getLeft());

			if(it1.getRight()!=null)
				q1.add(it1.getRight());

			if(it2.getLeft()!=null)
				q2.add(it2.getLeft());

			if(it2.getRight()!=null)
				q2.add(it2.getRight());
		}
		if(q1.isEmpty() && q2.isEmpty())
			return true;
		else
			return false;
	}
}
