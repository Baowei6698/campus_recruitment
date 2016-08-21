package edu.ouc.cc150;

/**
 * 题目描述

有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。
请设计一个算法，计算机器人有多少种走法。

给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
测试样例：

2,2

返回：2

 * @author wqx
 *
 */
public class _9_2_Robot {
	
	/**
	 * 排列组合
	 * 
	 * 空间复杂度 O(n*m)
	 * 
	 * 运行时间：28ms
	 * 占用内存：646k
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
    public int countWays(int x, int y) {
    	if(x == 1 || y == 1) return 1;
    	
    	int [][] res = new int[x][y];
    	res[0][0] = 0;
    	for(int i = 0; i < x; i++){
    		res[i][0] = 1;
    	}
    	
    	for(int i = 0; i < y; i++){
    		res[0][i] = 1;
    	}
    	
    	for(int i = 1; i < x; i++){
    		for(int j = 1; j < y; j++){
    			res[i][j] = res[i-1][j] + res[i][j-1];
    		}
    	}
    	return res[x-1][y-1];
    }
	/**
	 * 排列组合
	 * 
	 * 空间复杂度:O(min(n,m))
	 * 
	 * 可做适当优化，求res[i][j] 只需要res[i-1][j]和res[i][j-1]两个数据，
	 * 也就是说我们只需要i,i-1两行数据就行，此时空间复杂度可优化为O(min(n,m))
	 * 
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
    public static int countWaysOpt(int x, int y) {
    	if(x == 1 || y == 1) return 1;
    	
    	int [][] res = new int[2][y];
    	res[0][0] = 0;
    	for(int i = 0; i < 2; i++){
    		res[i][0] = 1;
    	}
    	
    	for(int i = 0; i < y; i++){
    		res[0][i] = 1;
    	}
    	
    	for(int i = 1; i < x; i++){
    		int posX = (i % 2 == 1 ? 0 : 1);
    		for(int j = 1; j < y; j++){
    			res[i%2][j] = res[posX][j] + res[i%2][j-1];
    		}
    	}
    	return res[(x-1)%2][y-1];
    }
	public static void main(String[] args) {
		System.out.println("res:" + countWaysOpt(3,3));
	}

}
