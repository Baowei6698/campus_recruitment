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
	 * @param head
	 * @return
	 */
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null || head.next == null) return head;
    	ListNode begin = new ListNode(0);
    	begin.next = head;
        ListNode tail = begin,p = head;
        while(p != null){
        	if(p.val == p.next.val){
        		p = p.next;
        	}else{
        		p = q;
        		q = q.next;
        	}
        }
        return head;
    }
}
