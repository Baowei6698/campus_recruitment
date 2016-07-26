package edu.ouc.offer;

import java.util.Arrays;

/**
 * 
题目描述
一个链表中包含环，请找出该链表的环的入口结点。


 * @author wqx
 *
 */
public class EntryNodeOfLoop {

	public static void main(String args[]){
		int arr[] = {1,2,3,4,5,6};
		int loopEntry = 3;
		
		ListNode head = ListNode.create(arr, loopEntry,false);
		
		ListNode node = EntryNodeOfLoop(head);
		System.out.println("node:" + node.val);
	}
	/**
	 * 1.确定环的节点数n
	 * 2.双指针p,q，q先走n步，然后p,q同步走，当p，q相遇时即环的入口节点
	 * 
	 * @param pHead
	 * @return
	 */
    public static ListNode EntryNodeOfLoop(ListNode pHead)
    {
    	int n = getNumOfNodeInLoop(pHead);
    	ListNode first,second;
    	first =  pHead;
    	second = first;
    	int step = 0;
    	while(first != null && second != null){
    		if(step < n){
    			second = second.next;
    			step++;
    		}else{
    			if(second == first){
    				return second;
    			}
    			second = second.next;
    			first = first.next;
    		}
    	}
    	return null;
    }
    public static  int getNumOfNodeInLoop(ListNode pHead){
    	ListNode first,second;
    	first =  pHead;
    	second = first.next;
    	int step = 1;
    	while(first != null && second != null){
    		if(first == second){
    			second = first.next;
    			while(first != second){
    				second = second.next;
    				step++;
    			}
    			break;
    		}
    		second = second.next;
    		first = first.next;
    		if(first != second){
    			second = second.next;
    		}
    	}
    	return step;
    }
}
