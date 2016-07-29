package edu.ouc.algorithm.tree;

import java.util.Stack;

public class TraverseTree {
//	void CreateTreeNode(TreeNode T)//建树，按先序顺序输入节点  
//	{  
//	    char ch;  
//	    if(ch==' ')  
//	    {  
//	        T=NULL;  
//	        return;  
//	    }  
//	    else  
//	    {  
//	        T=(TreeNode)malloc(sizeof(BiTNode));  
//	        if(!T)  
//	            exit(1);  
//	        T.val=ch;  
//	        CreateTreeNode(T.left);  
//	        CreateTreeNode(T.right);  
//	    }  
//	}  
	static void InOrderTraverse(TreeNode T)//非递归中序遍历  
	{  
	      
	    Stack<TreeNode> stack = new Stack<TreeNode>();  
	    if(T == null)  
	    {  
	        System.out.println("空树！\n");  
	        return;  
	    }  
	      
	    while(T != null || !stack.empty())  
	    {  
	        while(T != null)  
	        {  
	            stack.push(T);  
	            T=T.left;  
	        }  
	        T=stack.peek();
	        stack.pop();  
	        //System.out.println("%c",T.val);  
	        T=T.right;  
	    }                                                                                                                                     
	}  
	  
	  
	  
	static void PreOrderTraverse(TreeNode T)//非递归先序遍历  
	{  
	      
	    Stack<TreeNode> Stack = new Stack<TreeNode>();  
	    if(T == null)  
	    {  
	        System.out.println("空树！\n");  
	        return;  
	    }  
	    while(T != null|| !Stack.isEmpty())  
	    {  
	        while(T != null)  
	        {  
	            Stack.push(T);  
	            //System.out.println("%c",T.val);  
	            T=T.left;  
	        }  
	        T=Stack.peek();  
	        Stack.pop();          
	             T=T.right;          
	    }                                                                                                                                     
	}  
	  
	  
	static void PostOrderTraverse(TreeNode T)//非递归后序遍历,用一个标记标记右子树是否访问过  
	{  
	    int flag[] = null;  
	    Stack<TreeNode> Stack = new Stack<TreeNode>();  
	    if(T == null)  
	    {  
	        System.out.println("空树！\n");  
	        return;  
	    }  
	    while(T != null)  
	    {  
	        Stack.push(T);  
	        flag[Stack.size()]=0;  
	        T=T.left;  
	    }  
	    while(!Stack.empty())  
	    {  
	        T=Stack.peek();            
	        while(T.right != null && flag[Stack.size()]==0)  
	        {  
	            flag[Stack.size()]=1;  
	            T=T.right;  
	            while(T != null)  
	            {  
	                Stack.push(T);  
	                flag[Stack.size()]=0;  
	                T=T.left;  
	            }  
	        }  
	        T= Stack.peek();  
	        //System.out.println("%c",T.val);  
	        Stack.pop();  
	    }                                                                                                                                     
	}  
	public static void main(String args[])  
	{  
	    
	    TreeNode T = new TreeNode(1);  
	    CreateTreeNode(T);
	    PreOrderTraverse(T);
	    System.out.println("\n");
	    InOrderTraverse(T);  
	    System.out.println("\n");  
	    PostOrderTraverse(T);  
	    System.out.println("\n");  
	}



	private static void CreateTreeNode(TreeNode t) {
		// TODO Auto-generated method stub
		
	}
}
