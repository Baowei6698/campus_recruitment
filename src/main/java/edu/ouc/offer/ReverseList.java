package edu.ouc.offer;

/**
 * 
��Ŀ����
����һ��������ת�����������������Ԫ�ء�

 * @author wqx
 *
 */
public class ReverseList {
	/**
	 * ����ͷ���begin������㣬��������ͷ�巨
	 * @param head
	 * @return
	 */
    public ListNode ReverseList(ListNode head) {
    	ListNode begin = new ListNode(0);
    	begin.next = null;
    	ListNode q;
    	while(head != null){
    		q = head.next;
    		head.next = begin.next;
    		begin.next = head;
    		head = q;
    	}
    	return begin.next;
    }
}
