package edu.ouc.offer;

public class ListNode {
	public int val;
	public ListNode next;
	
	public ListNode(int x){
		this.val = x;
	}
	public static ListNode create(int[] arr,boolean hasHead){
		ListNode head = new ListNode(0);
		if(arr == null || arr.length == 0) return head;
		ListNode tail = head;
		
		for(int i = 0; i < arr.length; i++){
			ListNode node = new ListNode(arr[i]);
			node.next = tail.next;
			tail.next = node;
			tail = node;
		}
		if(hasHead)
			return head;
		else
			return head.next;
	}
	public static ListNode create(int[] arr,int loopEntry){
		ListNode head = create(arr,true);
		ListNode tail = head,p = head;
		while(tail.next != null){
			tail = tail.next;
		}
		int step = 0;
		while(step < loopEntry){
			p = p.next;
		}
		tail.next = p;
		return head;
	}
	public static ListNode create(int[] arr,int loopEntry,boolean hasHead){
		ListNode head = create(arr,hasHead);
		ListNode tail = head,p = head;
		while(tail.next != null){
			tail = tail.next;
		}
		System.out.println("tail:" + tail.val);
		int step = 1;
		while(step < loopEntry){
			p = p.next;
			step++;
		}
		System.out.println("p:" + p.val);
		tail.next = p;
		return head;
	}
	public static void print(ListNode node){
		while(node != null){
			System.out.print(node.val + ",");
			node = node.next;
		}
	}
}
