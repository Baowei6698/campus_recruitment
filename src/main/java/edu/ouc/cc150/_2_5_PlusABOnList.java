package edu.ouc.cc150;

import edu.ouc.offer.ListNode;


/**
 * 题目描述

有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。
编写函数对这两个整数求和，并用链表形式返回结果。

给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
测试样例：

{1,2,3},{3,2,1}

返回：{4,4,4}
 *
 * @author hzwuqingxin
 */
public class _2_5_PlusABOnList {

    public static ListNode plusAB(ListNode a, ListNode b) {

        ListNode begin = new ListNode(0);

        ListNode p = a, q = b, tail = begin;
        int c = 0;
        while(p != null && q != null){
            int sum = (p.val + q.val + c);
            c = sum/10;
            p.val = sum%10;
            tail.next = p;
            tail = p;
            p = p.next;
            q = q.next;
        }
        if(p == null){
            while(q != null){
                q.val = (q.val + c)%10;
                c = (q.val + c)/10;
                tail.next = q;
                tail = q;
                q = q.next;
            }
        }
        if(q == null){
            while(p != null){
                p.val = (p.val + c)%10;
                c = (p.val + c)/10;
                tail.next = p;
                tail = p;
                p = p.next;
            }
        }
        
        if( c != 0 ){
            ListNode n = new ListNode(c);
            n.next = null;
            tail.next = n;
        }
        return begin.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,9};
        int[] arr2 = {3,2,1};
        ListNode a = ListNode.create(arr1, false);
        ListNode b = ListNode.create(arr2, false);
        
        ListNode node = plusAB(a,b);
        
        ListNode.print(node);
    }

}
