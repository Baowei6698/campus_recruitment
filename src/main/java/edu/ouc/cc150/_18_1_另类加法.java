package edu.ouc.cc150;

/**
 * 
题目描述

请编写一个函数，将两个数字相加。不得使用+或其他算数运算符。

给定两个int A和B。请返回A＋B的值
测试样例：

1,2

返回：3


 * @author wqx
 *
 */
public class _18_1_另类加法 {

	/**
	 * 思路：首先想到是使用位运算，怎么整呢？？？
	 * 令C=A+B,从二进制的角度来看，
	 * 第一步，A和B某位上不相等（肯定一个0一个1），这种情况最好办，结果C的对应位置上肯定就是1（暂不考虑后面进位的情况）。
	 * A^B得到的就是A和B的不同位。
	 * 第二步：A和B某位都为1，那么结果C对应位上应该是0，并且要向前进位了。那么怎么知道哪些位置会产生进位呢？
	 * A&B得到的不就是吗？
	 * 
	 * 然后呢。。。哎。。。不知道了！！！！
	 * 
	 * 再想想。。。
	 * 
	 * (A&B)<<1:进位后,
	 * 那么A+B = (A&B)<<1 + A^B 
	 * 
	 * 0 + 0 = 0    0 ^ 0 = 0   
     * 1 + 0 = 1    1 ^ 0 = 1
     * 0 + 1 = 1    0 ^ 1 = 1 
     * 1 + 1 = 0    1 ^ 1 = 0
     * 全部成立。但是如果有多位参与运算，就必须要考虑进位问题了。
     * 1 + 1 :产生进位  1 ^ 1 = 0(没进位，所以需要对这种情况进行处理)
     * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int addAB(int A, int B) {
		int tmp = 0;
		do{
			tmp = A&B;
			A = A^B;
			B = tmp<<1;
		}
		while(B != 0 && A != 0);
		return A == 0 ? B : A;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new _18_1_另类加法().addAB(1, 2));
	}

}
