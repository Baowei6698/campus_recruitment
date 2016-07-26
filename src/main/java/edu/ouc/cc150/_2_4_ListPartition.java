package edu.ouc.cc150;

import edu.ouc.offer.ListNode;


/**
 * 
题目描述

链表分割

编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前

给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。


 *
 * @author hzwuqingxin
 */
public class _2_4_ListPartition {

    public ListNode partition(ListNode pHead, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        
        ListNode leftTail = left,rightTail = right;
        
        if(pHead == null) return pHead;
        ListNode p = pHead;
        while(p != null){
            ListNode q = p.next;
            if(p.val < x){
                //尾插法构造新链表
                leftTail.next = p;
                leftTail = p;
            }else{
                rightTail.next = p;
                rightTail = p;
            }
            p = q;
        }
        //首尾相连
        leftTail.next = right.next;
        rightTail.next = null;
        return left.next;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
