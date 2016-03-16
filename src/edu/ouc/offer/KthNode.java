package edu.ouc.offer;

/**
 * 
题目描述
输入一个链表，输出该链表中倒数第k个结点。

 * @author wqx
 *
 */
public class KthNode {
	/**
	 * 双指针
	 * 需要考虑k为非正整数或K大于list.size的情况。
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
    public ListNode FindKthToTail(ListNode head,int k) {
    	if(head == null)return null;
    	if(k <= 0) return null;
    	ListNode begin = new ListNode(0);
    	begin.next = head;
    	int step = 1;
    	ListNode p,q;
    	p = begin;
    	q = begin.next;
    	while(q != null){
    		if(step < k){
    			step++;
    			q = q.next;
    		}else{
    			q = q.next;
    			p = p.next;
    		}
    	}
    	
    	return p != begin ? p : null;
    }
}
