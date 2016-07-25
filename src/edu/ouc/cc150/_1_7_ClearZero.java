package edu.ouc.cc150;

/**
 * 题目描述

请编写一个算法，若MxN矩阵中某个元素为0，则将其所在的行与列清零。

给定一个MxN的int[][]矩阵(C++中为vector>)mat和矩阵的阶数n，
请返回完成操作后的int[][]矩阵(C++中为vector>)，保证n小于等于300，矩阵中的元素为int范围内。
测试样例：

[[1,2,3],[0,1,2],[0,0,1]]

返回：[[0,0,3],[0,0,0],[0,0,0]]

 * @author wqx
 *
 */
public class _1_7_ClearZero {

    public int[][] clearZero(int[][] mat, int n) {
    	if(mat == null || mat.length == 0) return mat;
    	n = mat.length;
    	int m = mat[0].length;
        boolean row[] = new boolean[n];
        boolean col[] = new boolean[m];
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < m; j++){
        		if(mat[i][j] == 0){
        			row[i] = true;
        			col[j] = true;
        		}
        	}
        }
        
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < m; j++){
        		if(row[i] || col[j]){
        			mat[i][j] = 0;
        		}
        	}
        }
        return mat;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
