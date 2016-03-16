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
        		//尾插法
        		p.next = tail.next;
        		tail.next = p;
        		tail = p;
        		
        		p = t;		
        	}else{
        		//找到第一个节点满足:p.val != p.next.val
        		while(p.next != null && p.val == p.next.val){
        			p = p.next;
        		}
        		p = p.next;
        	}
        }
        return begin.next;
    }
}
