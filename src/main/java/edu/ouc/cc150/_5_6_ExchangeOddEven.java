package edu.ouc.cc150;


/**
 * 奇偶位交换
 * 
题目描述

请编写程序交换一个数的二进制的奇数位和偶数位。（使用越少的指令越好）

给定一个int x，请返回交换后的数int。
测试样例：

10

返回：5

 * @author wqx
 *
 */
public class _5_6_ExchangeOddEven {
	
    public static int exchangeOddEven(int x) {
        int evenVal = (x & 0xAAAAAAAA);
        int oddVal = (x & 0x55555555);
        return (oddVal << 1) + (evenVal >> 1)&0x7fffffff;
    }
    
    public static void main(String args[]){
    	System.out.println(exchangeOddEven(10));
    }
}
