package edu.ouc.offer;

/**

题目描述
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
重复的结点不保留，返回链表头指针。 
例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

 * @author wqx
 *
 */
public class Remove_Duplicates_from_Sorted_List {
	/**
	 * 利用已知链表有序特性，注意加头结点
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
