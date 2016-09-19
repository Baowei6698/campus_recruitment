package edu.ouc.cc150;

/**
 * 
题目描述

有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
注意这次的网格中有些障碍点是不能走的。

给定一个int[][] map(C++ 中为vector >),表示网格图，若map[i][j]为1则说明该点不是障碍点，否则则为障碍。
另外给定int x,int y，表示网格的大小。
请返回机器人从(0,0)走到(x - 1,y - 1)的走法数，为了防止溢出，请将结果Mod 1000000007。保证x和y均小于等于50

 * @author wqx
 *
 */
public class _9_2_1_RobotII {

	/**
	 * 思路：总的走法-路过障碍点的走法
	 * 
	 * 求路过障碍点的走法时，对有些走法重复计算的情况需要特别分析
	 * 
	 * @param map
	 * @param x
	 * @param y
	 * @return
	 */
    public int countWays(int[][] map, int x, int y) {
    	int result = 0;
    	
//    	int total = countWaysOpt(x,y);
    	
    	for(int i = 0; i < x; i++){
    		for(int j = 0; j < y; j++){
    			if(map[i][j] == 1){
    				
    			}
    		}
    	}
    	
    	return result;
    }
    private static int count = 0;
    
    /**
     * 果然还是 TLE ！！！！哎！！！
     * 
     * @param map
     * @param x
     * @param y
     */
    public static void dfs(int[][] map,int x,int y){
    	//越界检查
    	if(x < 0 || x >= map.length || y < 0 || y >= map[0].length) return ;
    	//障碍点
    	if(map[x][y] == 0) return;
    	
    	if(x == map.length-1 && y == map[0].length-1){
    		count++;
    		count %= 1000000007;
    		return ;
    	}
    	dfs(map,x+1,y);
    	dfs(map,x,y+1);
    }
    public static void main(String[] args) {
    	//int[][] map = {{0,1,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    	int[][] map = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,0,1,1},{0,1,1,1},{1,1,1,1},{1,1,1,1}};
    	
    	dfs(map,0,0);
    	System.out.println("count:" + count);
    }
    public static int countWaysWithNoBarrier(int x, int y) {
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

}
