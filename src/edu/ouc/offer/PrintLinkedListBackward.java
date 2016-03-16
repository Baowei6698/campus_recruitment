package edu.ouc.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
题目描述
输入一个链表，从尾到头打印链表每个节点的值。
输入描述:

输入为链表的表头

输出描述:

输出为需要打印的“新链表”的表头

 * @author Administrator
 *
 */
public class PrintLinkedListBackward {
	
	List<Integer> arrayList = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	printList(listNode);
    	return (ArrayList<Integer>) arrayList;
    }
    /**
     * 递归遍历链表
     * @param listNode
     */
    public void printList(ListNode listNode){
    	if(listNode != null){
    		printList(listNode.next);
    		arrayList.add(listNode.val);
    	}
    }
}
