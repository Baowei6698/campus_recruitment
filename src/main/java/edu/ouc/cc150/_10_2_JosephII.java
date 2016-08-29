package edu.ouc.cc150;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * 
题目描述

约瑟夫问题是一个著名的趣题。这里我们稍稍修改一下规则。有n个人站成一列。并从头到尾给他们编号，
第一个人编号为1。然后从头开始报数，第一轮依次报1，2，1，2...然后报到2的人出局。
接着第二轮再从上一轮最后一个报数的人开始依次报1，2，3，1，2，3...报到2，3的人出局。
以此类推直到剩下以后一个人。现在需要求的即是这个人的编号。

给定一个int n，代表游戏的人数。请返回最后一个人的编号
测试样例：

5

返回：5

 * @author wqx
 *
 */
public class _10_2_JosephII {

	/**
	 * 思路一：
	 * 基于数组实现，按照JosephI的办法，m是可变的。
	 * 1. 每次都从上一轮最后一个开始报数，所以要记录上一轮最后一个报数的人的位置，记为last（初始值为0）
	 * 2. 每轮结束的标志（）
	 * 
	 * @param n
	 * @return
	 */
	
	public static int getResult(int n) {
		int arr[] = new int[n];
		int remain = n;
		int step = 1, i = 0;
		int gap = 2;
		int stopPos = 0 , last = 0;
		while(remain > 1){
			i = last;
			step = 1;
			do{
				if(arr[i] == 0 && step == gap){
					arr[i] = 1;
					step = 1;
				}else if(arr[i] == 0){
					if(step != 1){
						arr[i] = 1;
					}else{
						last = i;//记录最后一个报数的人
					}
					step++;
				}
				i = nextStep(i,n);
			}while(i != stopPos);//一轮报数是否结束
			stopPos = lastStep(last,n);//下一轮停止位置，上一轮最后一个报数的人的前一个位置
			remain = clearVisited(arr);
			gap++;
		}

		for(i = 0; i < n; i++){
			if(arr[i] == 0)
				return i+1;
		}
		return 0;
	}
	/**
	 * 清除报过数的人,返回剩余人数
	 */
	public static int clearVisited(int arr[]){
		int remain = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == 1){
				arr[i] = -1;
			}else if(arr[i] == 0){
				remain++;
			}
		}
		return remain;
	}
	public static int nextStep(int i, int n){
		return (i+1) % n;
	}
	public static int lastStep(int i, int n){
		return (i+n-1) % n;
	}
	public static void main(String[] args) {
		int n = 5;
		System.out.println(getResult(n));
	}

}
