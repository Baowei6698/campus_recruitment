package edu.ouc.cc150;

import java.util.Arrays;

/**
 * 题目描述

叠罗汉是一个著名的游戏，游戏中一个人要站在另一个人的肩膀上。同时我们应该让下面的人比上面的人更高一点。
已知参加游戏的每个人的身高，请编写代码计算通过选择参与游戏的人，我们多能叠多少个人。
注意这里的人都是先后到的，意味着参加游戏的人的先后顺序与原序列中的顺序应该一致。

给定一个int数组men，代表依次来的每个人的身高。同时给定总人数n，请返回最多能叠的人数。保证n小于等于500。
测试样例：

[1,6,2,5,3,4],6

返回：4

 * @author wqx
 *
 */
public class _11_7_LIS {
	
	/**
	 * 思路：LIS，最大递增子序列
	 * 
	 * @param men
	 * @param n
	 * @return
	 */
    public int getHeight(int[] men, int n) {
    	int[] f = new int[n];
    	f[0] = 1;//f[i] = j:以men[i]元素结尾的最长递增子序列
    	int max = f[0];
    	for(int i = 1; i < n; i++){
    		f[i] = 1;
    		for(int j = 0; j < i; j++){
    			if(men[j] < men[i] && f[j] + 1 > f[i]){
    				f[i] = f[j] + 1;
    				if(f[i] > max){
    					max = f[i];
    				}
    			}
    		}
    	}
    	return max;
    }
	public void LIS(int[] L)
	{
		int n = L.length;
		int[] f = new int[n];//用于存放f(i)值；
		f[0]=1;//以第a1为末元素的最长递增子序列长度为1；
		for(int i = 1; i < n; i++)//循环n-1次
		{
			f[i] = 1;//f[i]的最小值为1；
			for(int j = 0; j < i; j++)//循环i次
			{
				if(L[j] < L[i] && f[j] + 1 > f[i])
					f[i]=f[j]+1;//更新f[i]的值。
			}
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,6,2,5,3,2};
		System.out.println(new _11_7_LIS().getHeight(arr, 6));
	}

}
