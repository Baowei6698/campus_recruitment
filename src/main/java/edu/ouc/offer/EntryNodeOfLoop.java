package edu.ouc.offer;

import java.util.Arrays;

/**
 * 
��Ŀ����
һ�������а����������ҳ�������Ļ�����ڽ�㡣


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
	 * 1.ȷ�����Ľڵ���n
	 * 2.˫ָ��p,q��q����n����Ȼ��p,qͬ���ߣ���p��q����ʱ��������ڽڵ�
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
