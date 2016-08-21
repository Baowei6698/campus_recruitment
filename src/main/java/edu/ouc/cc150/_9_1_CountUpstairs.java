package edu.ouc.cc150;

/**
 * 题目描述

有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。请实现一个方法，计算小孩有多少种上楼的方式。
为了防止溢出，请将结果Mod 1000000007

给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
测试样例：

1

返回：1

 * @author wqx
 *
 */
public class _9_1_CountUpstairs {
	/**
	 * 迭代
	 * f(n) = f(n-1) + f(n-2) + f(n-3)
	 * 
	 * 空间限制 32M
	 * 
	 * @param n
	 * @return
	 */
    public static int countWays(int n) {
    	if(n <= 0) return 0;
    	int f1,f2,f3;
    	if(n == 1) 
    		return 1;
    	if(n == 2) 
    		return 2;
    	if(n == 3) 
    		return 4;
    	f1 = 1;f2 = 2; f3 = 4;
    	int res = 0;    	
    	for(int i = 4; i <= n; i ++){
    		res = (((f1 + f2) % 1000000007) + f3)%1000000007;
    		f1 = f2;
    		f2 = f3;
    		f3 = res;
    	}
    	return res;
    }
    
	/**
	 * 递归算法    StackOverflowError
	 * 
	 * @param n
	 * @return
	 */
    public static int countWays2(int n) {
    	if(n <= 0) return 0;
    	if(n == 1) return 1;
    	return (countWays2(n-1) % 1000000007 + countWays2(n-2) % 1000000007  + countWays2(n-3) % 1000000007) % 1000000007;
    }
    
	public static void main(String[] args) {
		System.out.println(countWays(122333));
	}

}
