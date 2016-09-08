package edu.ouc.cc150;

/**
 * 阶乘尾零
 * 
题目描述

请设计一个算法，计算n的阶乘有多少个尾随零。

给定一个int n，请返回n的阶乘的尾零个数。保证n为正整数。
测试样例：

5

返回：1

 * @author wqx
 *
 */
public class _17_3_Factor {

	/**
	 * 能得0的结果只有2*5，计算5的个数即可
	 * 
	 * @param n
	 * @return
	 */
    public int getFactorSuffixZero(int n) {
    	
    	int count = 0;
    	for(int i = 5; n/i > 0; i *= 5)
    		count += n/i;
    	return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
