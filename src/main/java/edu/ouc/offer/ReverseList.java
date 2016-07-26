package edu.ouc.offer;

/**
 * 
题目描述
输入一个链表，反转链表后，输出链表的所有元素。

 * @author wqx
 *
 */
public class ReverseList {
	/**
	 * 增加头结点begin方便计算，利用链表头插法
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
