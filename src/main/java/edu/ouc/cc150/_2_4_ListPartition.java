package edu.ouc.cc150;

import edu.ouc.offer.ListNode;


/**
 * 
��Ŀ����

����ָ�

��д���룬�Ը���ֵxΪ��׼������ָ�������֣�����С��x�Ľ�����ڴ��ڻ����x�Ľ��֮ǰ

����һ�������ͷָ�� ListNode* pHead���뷵���������к�������ͷָ�롣ע�⣺�ָ��Ժ󱣳�ԭ��������˳�򲻱䡣


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
                //β�巨����������
                leftTail.next = p;
                leftTail = p;
            }else{
                rightTail.next = p;
                rightTail = p;
            }
            p = q;
        }
        //��β����
        leftTail.next = right.next;
        rightTail.next = null;
        return left.next;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
