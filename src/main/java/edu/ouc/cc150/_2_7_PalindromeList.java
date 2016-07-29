package edu.ouc.cc150;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.ouc.offer.ListNode;

public class _2_7_PalindromeList {

	/**
	 * ArrayList实现方案
	 * 
	 * @param pHead
	 * @return
	 */
    public boolean isPalindrome(ListNode pHead) {
    	if(pHead == null) return true;
    	
    	ListNode node = pHead;
    	
    	int len = 1;
    	List<Integer> list = new ArrayList<Integer>(0);
    	list.add(pHead.val);
    	while((node = node.next) != null){ len++;list.add(node.val);}
    	
    	for(int i = 0; i <= len/2; i++){
    		if(list.get(i) != list.get(len-i-1))
    			return false;
    	}
    	return true;
    }
    
    /**
     * stack实现方案
     * 
     * @param pHead
     * @return
     */
    public static boolean isPalindrome2(ListNode pHead) {
    	if(pHead == null) return true;
    	
    	Stack<Integer> stack = new Stack<>();
    	
    	ListNode p = pHead, q = pHead;
    	stack.push(p.val);
    	while(q.next != null && q.next.next != null){
    		p = p.next;
    		stack.push(p.val);
    		q = q.next.next;
    	}
    	
    	if(q.next == null)
    		stack.pop();
    	p = p.next;
    	
    	while(!stack.isEmpty()){
    		if(stack.pop() != p.val)
    			return false;
    		p = p.next;
    	}
    	if(stack.isEmpty())
    		return true;
    	return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4,7,1,6,1,4,2,6,9,6,3,8,7,5,2,8,1,7,8,5,6,8,9,6,3,3,5,1,7,8,5,6,5,7,1,4,8,3,9,3,3,7,7,7,3,1,3,8,3,4,1,8,8,2,8,4,6,0,2,1,3,1,2,0,6,4,8,2,8,8,1,4,3,8,3,1,3,7,7,7,3,3,9,3,8,4,1,7,5,6,5,8,7,1,5,3,3,6,9,8,6,5,8,7,1,8,2,5,7,8,3,6,9,6,2,4,1,6,1,7,4};
		int arr2[] = {2,3,2};
		ListNode node = ListNode.create(arr, false);
		System.out.println(isPalindrome2(node));
	}

}
