package edu.ouc.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
��Ŀ����
��ֻ��������2��3��5��������������Ugly Number��������6��8���ǳ�������14���ǣ���Ϊ����������7��
 ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������

 * @author wqx
 *
 */
public class UglyNumber {
    final int d[] = { 2, 3, 5 };
    public int GetUglyNumber_Solution(int index) {
    	Queue<Integer> q2 = new LinkedList<Integer>();
    	Queue<Integer> q3 = new LinkedList<Integer>();
    	Queue<Integer> q5 = new LinkedList<Integer>();
    	int minVal = 0;
    	q2.offer(1);
    	for(int i = 0; i < index; i++){
    		int val2 = q2.isEmpty() ? Integer.MAX_VALUE : q2.peek();
    		int val3 = q3.isEmpty() ? Integer.MAX_VALUE : q3.peek();
    		int val5 = q5.isEmpty() ? Integer.MAX_VALUE : q5.peek();
    		minVal = Math.min(val2,Math.min(val3, val5));
    		if(minVal == val2){
    			q2.poll();
    			q2.offer(minVal*2);
    			q3.offer(minVal*3);
    		}else if(minVal == val3){
    			q3.poll();
    			q3.offer(minVal*3);
    		}else{
    			q5.poll();
    		}
    		q5.offer(minVal*5);
    	}
    	return minVal;
    }
}
