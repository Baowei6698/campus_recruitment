package edu.ouc.cc150;

/**
 * 题目描述

有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，在不占用额外内存空间的情况下
(即不使用缓存矩阵)，将图像顺时针旋转90度。

给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。
测试样例：

[[1,2,3],[4,5,6],[7,8,9]],3

返回：[[7,4,1],[8,5,2],[9,6,3]]

 * @author wqx
 *
 */
public class _1_6_TransformImage {

	/**
	 * 不占用额外空间
	 * 以对角线为轴进行对换，再按列对换（1<->4,2<->3）
	 * 
	 * @param mat
	 * @param n
	 * @return
	 */
    public static int[][] transformImage(int[][] mat, int n) {
    	
        for(int i = 0; i < n; i++){
        	for(int j = i; j < n; j++){
        		int t = mat[i][j];
        		mat[i][j] = mat[j][i];
        		mat[j][i] = t;
        	}
        }
        for(int i = 0; i < n/2; i++){
        	swapColumn(mat,i,n-i-1);
        }
        return mat;
    }
    public static void swapColumn(int[][] mat,int col1,int col2){
    	for(int i = 0; i < mat.length; i++){
    		int tmp = mat[i][col1];
    		mat[i][col1] = mat[i][col2];
    		mat[i][col2] = tmp;
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] a = {{1,2,3},{4,5,6},{7,8,9}};
		
		transformImage(a,3);
	}

}
