package edu.ouc.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 
题目描述
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

 * @author wqx
 *
 */
public class MinKthNum {
	/**
	 * 利用PriorityQueue构造小顶堆 
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
