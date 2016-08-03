package edu.ouc.cc150;

import java.util.Stack;

import edu.ouc.algorithm.tree.TreeNode;


/**
 * ����Ƿ�ΪBST
��Ŀ����

��ʵ��һ�����������һ�ö������Ƿ�Ϊ�����������

�������ĸ����ָ��TreeNode* root���뷵��һ��bool����������Ƿ�Ϊ�����������


 * @author wqx
 *
 */
public class _4_5_CheckBST {
	
	/**
	 * ���������˳���
	 * 
	 * @param root
	 * @return
	 */
	public boolean checkBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode p = root , pre = null;
		
		while(p != null || !stack.empty())  
		{  
			while(p != null)  
			{  
				stack.push(p);
				pre = p;
				p = p.left;  
			}
			p = stack.peek();
			//preΪnull˵���ǵ�һ��Ԫ��
			if(pre != null && pre.val > p.val){
				return false;
			}else{
				pre = p;
			}
			stack.pop();  
			p = p.right;  
		} 
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}

}
