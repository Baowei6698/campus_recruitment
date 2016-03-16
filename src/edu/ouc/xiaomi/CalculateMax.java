package edu.ouc.xiaomi;

import java.util.Arrays;

/**
 * 
题目描述
风口之下，猪都能飞。当今中国股市牛市，真可谓“错过等七年”。 
给你一个回顾历史的机会，已知一支股票连续n天的价格走势，
以长度为n的整数数组表示，数组中第i个元素（prices[i]）代表该股票第i天的股价。 
假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，
并且买入前一定要先保证手上没有股票。若两次交易机会都放弃，收益为0。 
设计算法，计算你能获得的最大收益。 输入数值范围：2<=n<=100,0<=prices[i]<=100

输入例子:

3,8,5,1,7,8

输出例子:

12


 * @author wqx
 *
 */
public class CalculateMax {
    /**
     * 计算你能获得的最大收益
     * left[i]:prices[0...i]之间能获得的最大收益
     * right[i]:prices[i...n-1]之间能获得的最大收益
     *  
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    public static int calculateMax(int[] prices) {
    	int minPrice,maxProfit;
    	int len = prices.length;
    		
    	minPrice = 0;maxProfit = 0;
    	int [] left = new int[len];
    	int [] right = new int[len];
    	for(int i = 1; i < len; i++){
    		if(prices[i] < prices[minPrice]){
    			left[i] = maxProfit;
    			minPrice = i;
    		}else{
    			maxProfit = Math.max(maxProfit, prices[i]-prices[minPrice]);
    			left[i] = maxProfit;
    		}
    	}
    	int maxPrice = len-1;
    	maxProfit = 0;
    	for(int i = len-2; i >= 0; i--){
    		if(prices[i] > prices[maxPrice]){
    			right[i] = maxProfit;
    			maxPrice = i;
    		}else{
    			maxProfit = Math.max(maxProfit, prices[maxPrice]-prices[i]);
    			right[i] = maxProfit;
    		}
    	}
    	int max = 0;
    	for(int i = 0; i < len-1 ; i++){
    		if(max < (left[i] + right[i])){
    			max = left[i] + right[i];
    		}
    	}
    	System.out.println(Arrays.toString(left));
    	System.out.println(Arrays.toString(right));
    	return max;
    }
    
    public static void main(String args[]){
    	int [] arr2 = {3,8,5,1,7,8};
    	int [] arr = {31,41};
    	System.out.println(calculateMax(arr2));
    }
}
