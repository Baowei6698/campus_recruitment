package edu.ouc.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 
��Ŀ����
�������������ҳ����ǵĵ�һ��������㡣

 * @author wqx
 *
 */
public class FirstCommonNode {
	/**
	 * ��һ�������ڵ����������ڵ���ͬ
	 * 
	 * �ҳ��϶̵������ȳ��ȱ���
	 * 
	 * @param pHead1
	 * @param pHead2
	 * @return
	 */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	if(pHead1 == null || pHead2 == null)return null;
    	int len1 = 0,len2 = 0;
    	ListNode p = pHead1,q;
    	while(p != null){
    		p = p.next;
    		len1++;
    	}
    	p = pHead2;
    	while(p != null){
    		p = p.next;
    		len2++;
    	}
    	p = pHead1;q = pHead2;
    	if(len1 > len2){
    		while(p != null && q != null){
    			if(len1 > len2){
    				p = p.next;
    				len1--;
    			}else{
    				if(p == q){
    					return p;
    				}
    				p = p.next;
    				q = q.next;
    			}
    		}
    	}else{
    		while(p != null && q != null){
    			if(len1 < len2){
    				q = q.next;
    				len2--;
    			}else{
    				if(p == q){
    					return p;
    				}
    				p = p.next;
    				q = q.next;
    			}
    		}
    	}
    	return null;
    }
	/**
	 * ��һ�������ڵ����������ڵ���ͬ
	 * 
	 * HashMap�ⷨ
	 * 
	 * @param pHead1
	 * @param pHead2
	 * @return
	 */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
    	Map<ListNode,Integer> map = new HashMap<ListNode,Integer>();
    	ListNode p = pHead1;
    	while(p != null){
    		map.put(p, 1);
    		p = p.next;
    	}
    	p = pHead2;
    	while(p != null){
    		if(map.get(p) == 1){
    			return p;
    		}
    		p = p.next;
    	}
    	return null;
    }
}
