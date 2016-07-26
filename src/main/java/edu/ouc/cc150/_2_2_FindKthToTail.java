package edu.ouc.cc150;

import edu.ouc.offer.ListNode;


/**
 * 输入一个链表，输出该链表中倒数第k个结点。 
 *
 * @author hzwuqingxin
 */
public class _2_2_FindKthToTail {

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
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
