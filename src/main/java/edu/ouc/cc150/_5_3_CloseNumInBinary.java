package edu.ouc.cc150;

/**
 * 最接近的数
 * 
题目描述

有一个正整数，请找出其二进制表示中1的个数相同、且大小最接近的那两个数。(一个略大，一个略小)

给定正整数int x，请返回一个vector，代表所求的两个数（小的在前）。保证答案存在。
测试样例：

2

返回：[1,4]


 * @author wqx
 *
 */
public class _5_3_CloseNumInBinary {

	/**
	 * 思路：对于给定数字n，
	 * 
	 * c0:最右侧拖尾连续0的个数
	 * c1::最右侧0的左边连续1的个数
	 * p：最右侧，非拖尾的0的位置
	 * 
	 * 比如n=10,二进制：1010
	 * c0=1,c1=1,p=2;
	 * 
	 * 
	 * @param c
	 * @return
	 */
    public int[] getCloseNumber(int x) {
    	int[] res = new int[2];
    	res[0] = getNextMin(x);
    	res[1] = getNextMax(x);
    	return res;
    }
    public int getNextMax(int x){
    	int c0 = 0,c1 = 0,p = 0;
    	int c = x;
    	while((c & 1) == 0 && c != 0){
    		c0++;
    		c >>= 1;
    	}
    	while((c & 1) == 1){
    		c1++;
    		c >>=1;
    	}
    	p = c0 + c1;
    	//p位置置为1
    	x |= (1 << p);
    	//p右边全部置为0
    	x &= ~((1 << p) - 1);
    	//p右方插入c1-1个1
    	x |= (1 << (c1-1)) - 1;
    	return x;
    }
    public int getNextMin(int x){
    	int c0 = 0,c1 = 0,p = 0;
    	int c = x;
    	//c1：拖尾1的个数
    	while((c & 1) == 1 && c != 0){
    		c1++;
    		c >>= 1;
    	}
    	//c0：紧邻拖尾1的左侧连续0的个数
    	while((c & 1) == 0){
    		c0++;
    		c >>=1;
    	}
    	
    	p = c0 + c1;
    	//p位置以及右边全部置为0
    	x &= (~0) << (p + 1);
    	
    	//p后插入c1+1个1
    	x |= ((1 << (c1 + 1)) - 1) << (c0 - 1);
    	
    	return x;
    }
	public static void main(String[] args) {
		int[] arr = new _5_3_CloseNumInBinary().getCloseNumber(2);
		System.out.println(arr[0] + "," + arr[1]);
	}

}
