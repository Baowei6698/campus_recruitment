package edu.ouc.cc150;

import edu.ouc.offer.ListNode;


/**
 * ��Ŀ����

�������������ʾ��������ÿ��������һ����λ����Щ��λ�Ƿ����ŵģ�Ҳ���Ǹ�λ����������ײ���
��д������������������ͣ�����������ʽ���ؽ����

������������ListNode* A��ListNode* B���뷵��A+B�Ľ��(ListNode*)��
����������

{1,2,3},{3,2,1}

���أ�{4,4,4}
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
