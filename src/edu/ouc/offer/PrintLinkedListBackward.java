package edu.ouc.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
��Ŀ����
����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
��������:

����Ϊ����ı�ͷ

�������:

���Ϊ��Ҫ��ӡ�ġ��������ı�ͷ

 * @author Administrator
 *
 */
public class PrintLinkedListBackward {
	
	List<Integer> arrayList = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	printList(listNode);
    	return (ArrayList<Integer>) arrayList;
    }
    /**
     * �ݹ��������
     * @param listNode
     */
    public void printList(ListNode listNode){
    	if(listNode != null){
    		printList(listNode.next);
    		arrayList.add(listNode.val);
    	}
    }
}
