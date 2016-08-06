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

	/**
	 * 做异或操作得到res， 统计res中1的个数
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
    public static int calcCost(int A, int B) {
    	int res = A ^ B;
    	int num = 0;
    	do{
    		if((res & 1) != 0){
    			num++;
    		}
    		res >>>= 1;
    	}while(res != 0);
    	return num;
    }
    
	public static void main(String[] args) {
		int A = 10,B = 5;
		System.out.println(calcCost(A,B));
	}

}
