package edu.ouc.offer;

/**

��Ŀ����
��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬
�ظ��Ľ�㲻��������������ͷָ�롣 
���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5

 * @author wqx
 *
 */
public class Remove_Duplicates_from_Sorted_List {
	/**
	 * ������֪�����������ԣ�ע���ͷ���
	 * @param pHead
	 * @return
	 */
    public ListNode deleteDuplicates(ListNode pHead) {
    	if(pHead == null || pHead.next == null) return pHead;
    	ListNode begin = new ListNode(0);
    	begin.next = null;
        ListNode tail = begin,p = pHead,t;
        while(p != null){
        	if(p.next == null){
        		tail.next = p;
        		p = p.next;
        	}else if(p.val != p.next.val){
        		t = p.next;
        		//β�巨
        		p.next = tail.next;
        		tail.next = p;
        		tail = p;
        		
        		p = t;		
        	}else{
        		//�ҵ���һ���ڵ�����:p.val != p.next.val
        		while(p.next != null && p.val == p.next.val){
        			p = p.next;
        		}
        		p = p.next;
        	}
        }
        return begin.next;
    }
}
