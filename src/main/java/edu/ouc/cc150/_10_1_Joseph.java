package edu.ouc.cc150;

import java.util.Arrays;

/**
 * 
题目描述

约瑟夫问题是一个非常著名的趣题，即由n个人坐成一圈，按顺时针由1开始给他们编号。
然后由第一个人开始报数，数到m的人出局。现在需要求的是最后一个出局的人的编号。

给定两个int n和m，代表游戏的人数。请返回最后一个出局的人的编号。保证n和m小于等于1000。
测试样例：

5 3

返回：4



 * @author wqx
 *
 */
public class _10_1_Joseph {

    public static int getResult(int n, int m) {
    	int arr[] = new int[n];
    	int remain = n;
    	int step = 1, i = 0;
    	while(remain > 1){
    		if(step == m && arr[i] == 0){
    			arr[i] = 1;
    			step = 1;
    			remain--;
    		}else if(arr[i] == 0){
    			step++;
    		}
    		i = (i+1) % n;
    		System.out.println(Arrays.toString(arr));
    	}
    	for(i = 0; i < n; i++){
    		System.out.print(arr[i] + " ,");
    		if(arr[i] == 0)
    			return i+1;
    	}
    	return 0;
    }
    
	public static void main(String[] args) {
		int n = 5;
		int m = 3;
		System.out.println(getResult(n,m));
	}

}
