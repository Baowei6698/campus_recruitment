package edu.ouc.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 
��Ŀ����
����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��

 * @author wqx
 *
 */
public class MinKthNum {
	/**
	 * ����PriorityQueue����С���� 
	 * 
	 * @param input
	 * @param k
	 * @return
	 */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    	int len = input.length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(k > len || k <= 0)return result;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i = 0; i < len; i++){
        	queue.add(input[i]);
        }
        for(int i = 0; i < k; i++){
        	//System.out.print(queue.poll());
        	result.add(queue.poll());
        }
        return result;
    }
    public static void main(String[] args){
    	MinKthNum test = new MinKthNum();
    	int input[] = {4,5,1,6,2,7,3,8};
    	int k = 4;
    	test.GetLeastNumbers_Solution(input, k);
    }
}
