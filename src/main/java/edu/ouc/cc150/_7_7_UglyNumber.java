package edu.ouc.cc150;

/**
 * 
题目描述

有一些数的素因子只有3、5、7，请设计一个算法，找出其中的第k个数。

给定一个数int k，请返回第k个数。保证k小于等于100。
测试样例：

3

返回：7


 * @author wqx
 *
 */
public class _7_7_UglyNumber {

	/**
	 * 思路：
	 * 类似于丑数的算法，只是把因子由2,3,5换成3,5,7了。。。本质一样一样滴
	 * 
	 * 以求出前k个丑数，如何求第k+1个丑数？
	 * 
	 * 由于要求的数只包含3,5,7因子，那么第K+1个数一定是前K个数中的某一个的3,5或7倍，
	 * 我们要求的就是到底是哪一个数？以及到底是3,5还是7倍？
	 * 
	 * @param k
	 * @return
	 */
	public int findKth(int k){
		int num[] = new int[k+2];
		num[0] = 0;
		num[1] = 1;
		int three = 0,five = 0,seven = 0;//刚好大于现有最大丑数的三个
		
		for(int i = 1; i <= k; i++){//每次找出一个丑数
			
			for(int j = 1; j <= i ; j++)
				if((3*num[j-1] <= num[i]) && (3*num[j] > num[i])) three=num[j] * 3;
			
			for(int j = 1; j <= i ; j++)
				if((5*num[j-1] <= num[i]) && (5*num[j] > num[i])) five=num[j] * 5;
			
			for(int j = 1; j <= i ; j++)
				if((7*num[j-1] <= num[i]) && (7*num[j] > num[i])) seven=num[j] * 7;
			
			//比较出三个数中最小的
			System.out.println("three:" + three + ",five:" + five + "seven:" + seven);
			num[i+1] = Math.min(three, Math.min(five, seven));
		}
		return num[k+1];
	}
	public static void main(String[] args) {
		System.out.println(new _7_7_UglyNumber().findKth(3));
	}

}
