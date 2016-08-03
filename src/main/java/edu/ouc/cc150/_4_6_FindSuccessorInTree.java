package edu.ouc.cc150;

import java.util.Stack;

import edu.ouc.offer.TreeNode;

/**
 * 
��Ŀ����

�����һ���㷨��Ѱ�Ҷ�������ָ��������һ����㣨����������ĺ�̣���

�������ĸ����ָ��TreeNode* root�ͽ���ֵint p���뷵��ֵΪp�Ľ��ĺ�̽���ֵ��
��֤����ֵ���ڵ�����С�ڵ���100000��û���ظ�ֵ���������ں�̷���-1��


 * @author wqx
 *
 */
public class _4_6_FindSuccessorInTree {
	
	/**
	 * ˼·:
	 * �ǵݹ������������¼����p�ı�־
	 * 
	 * @param root
	 * @param p
	 * @return
	 */
    public int findSucc(TreeNode root, int p) {
    	TreeNode q = root;
    	Stack<TreeNode> s = new Stack<TreeNode>();
    	boolean flag = false;
    	
    	while(q != null || !s.isEmpty()){
    		
    		while(q != null){
    			s.push(q);
    			q = q.left;
    		}
    		if(flag){
    			return s.peek().val;
    		}
    		if( p == s.peek().val){
    			flag = true;
    		}
    		q = s.pop().right;
    	}
    	return -1;
    }
	public static void main(String[] args) {
		
	}

}
