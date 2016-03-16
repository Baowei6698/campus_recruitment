package edu.ouc.offer;


/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。 
 * 
 * @author wqx
 *
 */
public class AddWithoutNormalOperator {
	/**
	 * 不能用加减乘除，用位运算
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
    public int Add(int num1,int num2) {
        int a,b;
        a = num1^num2;//a代表num1和num2异或的结果
        b = (num1&num2)<<1;//
        while((a&b) != 0){
        	num1 = a;
        	num2 = b;
            a = num1^num2;
            b = (num1&num2)<<1;//
        }
        return a|b;
    }
}
