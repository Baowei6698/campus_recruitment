package edu.ouc.xiaomi;

/**
 * 
题目描述
世界上有2种人，一种懂二进制，一种不懂。那么你知道两个int32整数m和n的二进制表达，
有多少个位(bit)不同么？

输入例子:
1999 2299

输出例子:
7

 * @author wqx
 *
 */
public class CountBitDiff {
    /**
     * 获得两个整形二进制表达位数不同的数量
     * 
     * 思路：
     * 循环右移，用符号位来判断
     * 
     * 忘了考虑可能为0的情况！！！
     * 如果有一个数为0，则直接计算另一个数的二进制表示有多少个1就可以。
     * 
     * @param m 整数m
     * @param n 整数n
     * @return 整型
     */
    public static int countBitDiff(int m, int n) {
    	
    	if(m == 0)
    		return getBit(n);
    	if(n == 0)
    		return getBit(m);
    	int count = 0;
    	for(int i = 1; i <= 32; i++){
    		/*
    		 * 循环右移i位
    		 */
    		int t_m = (m>>i|m<<(32-i));
    		int t_n = (n>>i|n<<(32-i));
    		
    		if((t_m > 0 && t_n < 0) || (t_m < 0 && t_n > 0)){
    			count++;
    			//System.out.println("m:" + t_m + ",n:" + t_n);
    		}
    	}
    	return count;
    }
    /**
     * n的二进制表示有多少个1
     * @param n
     * @return
     */
    public static int getBit(int n){
    	int count = 0;
    	while(n!=0){
    		n &= (n-1);
    		count++;
    	}
    	return count;
    }
    public static void main(String []args){
    	int m = 0,n = 2299;
    	
    	System.out.println(countBitDiff(m,n));
    }
}
