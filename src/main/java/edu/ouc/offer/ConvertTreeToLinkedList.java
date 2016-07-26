package edu.ouc.offer;

import java.util.Stack;

/**
 * 
��Ŀ����
����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��

 * @author wqx
 *
 */
public class ConvertTreeToLinkedList {
	/**
	 * �������ķǵݹ����������ͬʱ����˫������
	 * 
	 * @param pRootOfTree
	 * @return
	 */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        
        TreeNode head = null,tail = null;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(pRootOfTree);
        TreeNode p = pRootOfTree;
        while(p != null || !stack.isEmpty()){
        	while(p != null){
        		stack.push(p);
        		p = p.left;
        	}
        	
        	p = stack.pop();
        	TreeNode tmp = p.right;
        	if(tail == null){
        		p.right = tail;
        		tail = p;
        		head = p;
        	}else{
        		p.right = tail.right;
        		tail.right = p;
        		p.left = tail;
        		tail = p;
        	}
        	//System.out.println(p.val);
        	p = tmp;
        }
        head.left = tail;
        tail.right = head;
        return head;
    }
}
