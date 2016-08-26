package edu.ouc.cc150;

/**
 * 题目描述

请设计一种算法，解决著名的n皇后问题。这里的n皇后问题指在一个nxn的棋盘上放置n个棋子，
使得每行每列和每条对角线上都只有一个棋子，求其摆放的方法数。

给定一个int n，请返回方法数，保证n小于等于10
测试样例：

1

返回：1

 * @author wqx
 *
 */
public class _9_9_Queen {
	
	private static int count = 0;
	/**
	 * 方法一：dfs，空间复杂度O(n*n)
	 * 
	 * @param n
	 * @return
	 */
    public int nQueens(int n) {
    	int[][] map = new int[n][n];
    	dfs(map,0,n);
		return count;
    }
    public void dfs(int[][]map, int row, int n){
    	if(row == n){
    		count++;
    	}else{
    		for(int i = 0; i < n; i++){
    			if(illegal(map,row,i,n)){
    				map[row][i] = 1;
    				dfs(map,row+1,n);
    				map[row][i] = 0;
    			}
    		}
    	}
    }
    public boolean illegal(int[][] map, int row, int col, int n){
    	int i = row , j = col;
    	while(i >= 0){
    		if(map[i--][j] == 1)
    			return false;
    	}
    	i = row ; j = col;
    	//检查左上对角线
    	while(i >= 0 && j >= 0){
    		if(map[i--][j--] == 1)
    			return false;
    	}
    	i = row ; j = col;
    	//检查由上对角线
    	while(i >= 0 && j < n){
    		if(map[i--][j++] == 1)
    			return false;
    	}
    	return true;
    }
	/**
	 * 方法二：改进dfs，降低空间复杂度到O(n)
	 * 
	 * @param n
	 * @return
	 */
    public int nQueens_Opt(int n) {
    	//a[i]=j 表示第i行的第j列已经放置皇后
    	int[] a = new int[n+1];
    	dfs2(a,1,n);
		return count;
    }
    public void dfs2(int a[] ,int i, int n){
    	if(i > n){
    		count++;
    	}else{
    		for(int j = 1; j <= n; j++){
    			a[i] = j;
    			//判断第i行第j列是否合法
    			if(illegal2(a,i)){
    				dfs2(a,i+1,n);
    			}
    		}
    	}
    }
    public boolean illegal2(int[] a, int i){
    	for(int k = 1; k < i; k++){
    		if(a[i] == a[k] || ((a[i]-a[k])==(i-k)) || ((a[i]-a[k])==(k - i))){
    			return false;
    		}
    	}
    	return true;
    }
	public static void main(String[] args) {
		int n = 4;
		System.out.println("result:" + new _9_9_Queen().nQueens_Opt(n));
	}

}
