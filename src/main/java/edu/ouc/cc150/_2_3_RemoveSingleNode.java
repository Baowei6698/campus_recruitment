package edu.ouc.cc150;

import edu.ouc.offer.ListNode;

/**
 * 
��Ŀ����

ʵ��һ���㷨��ɾ�����������м��ĳ����㣬�ٶ���ֻ�ܷ��ʸý�㡣

������ɾ���Ľڵ㣬��ִ��ɾ�����������ýڵ�Ϊβ�ڵ㣬����false�����򷵻�true
 *
 * @author hzwuqingxin
 */
public class _2_3_RemoveSingleNode {

    public boolean removeNode(ListNode pNode) {
        if(pNode == null || pNode.next == null) return false;
        
        ListNode node = pNode;
        while(node.next.next != null){
            node.val = node.next.val;
            node = node.next;
        }
        node.next = null;
        return true;
    }

}
