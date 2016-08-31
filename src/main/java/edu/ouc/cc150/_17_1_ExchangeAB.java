package edu.ouc.cc150;

/**
 * 
题目描述

请编写一个函数，函数内不使用任何临时变量，直接交换两个数的值。

给定一个int数组AB，其第零个元素和第一个元素为待交换的值，请返回交换后的数组。
测试样例：

[1,2]

返回：[2,1]


 * @author wqx
 *
 */
public class _17_1_ExchangeAB {
	
	/**
	 * 思路：异或操作交换
	 * 
	 * @param AB
	 * @return
	 */
    public int[] exchangeAB(int[] AB) {
    	AB[0] = AB[0] ^ AB[1];
    	AB[1] = AB[0] ^ AB[1];
    	AB[0] = AB[0] ^ AB[1];
    	return AB;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
