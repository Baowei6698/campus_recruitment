package edu.ouc.offer;

/**
 * 
题目描述
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

 * @author wqx
 *
 */
public class MergeTwoSortedList {
	
    public ListNode Merge(ListNode list1,ListNode list2) {
    	ListNode head = new ListNode(0),t,p;
    	head.next = null;
    	p = head;
    	while(list1 != null && list2 != null){
    		if(list1.val < list2.val){
    			t = list1.next;
    			list1.next = p.next;
    			p.next = list1;
    			p = list1;
    			list1 = t;
    		}else{
    			t = list2.next;
    			list2.next = p.next;
    			p.next = list2;
    			p = list2;
    			list2 = t;
    		}
    	}
    	if(list1 != null){
    		p.next = list1;
    	}
    	if(list2 != null){
    		p.next = list2;
    	}
    	return head.next;
    }
}
