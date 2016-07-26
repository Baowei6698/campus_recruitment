package edu.ouc.offer;

import java.util.Stack;

/**
 * 
��Ŀ����
����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣

 * @author wqx
 *
 */
public class NextTreeNode {
	/**
	 *
	 * 1.������Ϊ�գ��򷵻ؿգ�
	 * 
	 * 2.�ڵ��Һ��Ӵ��ڣ�������һ��ָ��Ӹýڵ���Һ��ӳ�����
	 * һֱ����ָ�����ӽ���ָ���ҵ���Ҷ�ӽڵ㼴Ϊ��һ���ڵ㣻
	 * 
	 * 3.�ڵ㲻�Ǹ��ڵ㡣����ýڵ����丸�ڵ�����ӣ��򷵻ظ��ڵ㣻
	 * ����������ϱ����丸�ڵ�ĸ��ڵ㣬�ظ�֮ǰ���жϣ����ؽ����
	 * 
	 * @param pNode
	 * @return
	 */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
    	if(pNode == null) return pNode;
    	if(pNode.right != null){
    		TreeLinkNode p = pNode.right;
    		while(p.left != null){
    			p = p.left;
    		}
    		return p;
    	}
    	while(pNode.next != null){
    		TreeLinkNode p = pNode.next;
    		if(p.left == pNode){
    			return p;
    		}
    		pNode = pNode.next;
    	}
    	return null;
    }
	/**
	 *
	 * ��Ŀ��Ϊǰ������������Ѱ�ҵ�ǰ�ڵ���һ���ڵ㡣
	 * 
	 * 1.������Ϊ�գ��򷵻ؿգ�
	 * 
	 * 2.�ڵ����Ӵ��ڣ��򷵻����ӣ�����鿴�к����Ƿ���ڣ��������򷵻��Һ���
	 * 
	 * 3.�ڵ㲻�Ǹ��ڵ㡣����ýڵ����丸�ڵ�����ӣ��򷵻ظ��ڵ���Һ��ӣ�
	 *   ����������ϱ����丸�ڵ�ĸ��ڵ㣬�ظ�֮ǰ���жϣ����ؽ����
	 * 
	 * @param pNode
	 * @return
	 */
   public TreeLinkNode GetNext2(TreeLinkNode pNode)
   {
   	if(pNode == null) return pNode;
   	if(pNode.left != null){
   		return pNode.left;
   	}
   	if(pNode.right != null){
   		return pNode.right;
   	}
   	
   	while(pNode.next != null){
   		TreeLinkNode p = pNode.next;
   		if(p.left == pNode && p.right != null){
   			return p.right;
   		}
   		pNode = pNode.next;
   	}
   	return null;
   }
}
