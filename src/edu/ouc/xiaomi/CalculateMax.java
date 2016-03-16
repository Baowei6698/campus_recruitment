package edu.ouc.xiaomi;

import java.util.Arrays;

/**
 * 
��Ŀ����
���֮�£����ܷɡ������й�����ţ�У����ν����������ꡱ�� 
����һ���ع���ʷ�Ļ��ᣬ��֪һ֧��Ʊ����n��ļ۸����ƣ�
�Գ���Ϊn�����������ʾ�������е�i��Ԫ�أ�prices[i]������ù�Ʊ��i��Ĺɼۡ� 
������һ��ʼû�й�Ʊ������������������1�ɶ�������1�ɵĻ��ᣬ
��������ǰһ��Ҫ�ȱ�֤����û�й�Ʊ�������ν��׻��ᶼ����������Ϊ0�� 
����㷨���������ܻ�õ�������档 ������ֵ��Χ��2<=n<=100,0<=prices[i]<=100

��������:

3,8,5,1,7,8

�������:

12


 * @author wqx
 *
 */
public class CalculateMax {
    /**
     * �������ܻ�õ��������
     * left[i]:prices[0...i]֮���ܻ�õ��������
     * right[i]:prices[i...n-1]֮���ܻ�õ��������
     *  
     * @param prices Prices[i]����i��Ĺɼ�
     * @return ����
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
