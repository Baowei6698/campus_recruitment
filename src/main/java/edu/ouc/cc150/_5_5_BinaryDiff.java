package edu.ouc.cc150;

/**
 * 整数转化
 * 
题目描述

编写一个函数，确定需要改变几个位，才能将整数A转变成整数B。

给定两个整数int A，int B。请返回需要改变的数位个数。
测试样例：

10,5

返回：4


 * @author wqx
 *
 */
public class _5_5_BinaryDiff {

    public static int calcCost(int A, int B) {
    	int res = 0;
    	do{
    		System.out.println("A:" + A + ",B:" + B);
    		if(A % 2 != B % 2)
    			res++;
    		if( A != 0)
    			A /= 2; 
    		if(B != 0)
    			B /= 2;
    	}while(A != 0 || B != 0);
    	
    	return res;
    }
    
	public static void main(String[] args) {
		int A = 10,B = 5;
		System.out.println(calcCost(A,B));
	}

}
