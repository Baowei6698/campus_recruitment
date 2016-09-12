package edu.ouc.algorithm.dp;

import java.util.Scanner;

/**
 * 有编号分别为a,b,c,d,e的五件物品，
 * 它们的重量分别是2,2,6,5,4，
 * 它们的价值分别是6,3,5,4,6，
 * 现在给你个承重为10的背包，如何让背包里装入的物品具有最大的价值总和？
 * 
 * 01背包的状态转换方程 f[i,j] = Max{ f[i-1,j-Wi]+Pi( j >= Wi ),  f[i-1,j] }
 * 
 * @author wqx
 *
 */
public class _01Package {

	/**
	 * 
	 * @param n 物品个数
	 * @param w w[i]：第i个物品的重量
	 * @param v v[i]：第i个物品的价值
	 * @param x x[i]：第i个物品是否被选中
	 * @param C 背包最大承重
	 * @return
	 */
	public static int getResult(int n,int w[],int v[],int x[],int C){

		int dp[][] = new int[n+1][C+1];

		int i,j;
		
		for(i = 1;i <= n; i++){
			for(j = 0; j <= C; j++){
				if(j < w[i-1])
					dp[i][j]=dp[i-1][j];
				else
					dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w[i-1]]+v[i-1]);
			}
		}
		for(i = 1;i <= n; i++){
			for(j = 0; j <= C; j++){
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		j=C;
		for(i = n; i > 0; i--)
		{
			if(dp[i][j] > dp[i-1][j])//第i个物品被选中
			{
				x[i]=1;
				j=j-w[i-1];
			}
			else
				x[i]=0;
		}
		for(i = 0; i < n; i++){
			if(x[i] == 1){
				System.out.print("(" + i + "," + v[i-1] + ") ");
			}
		}
		return dp[n-1][C];
	}
	public static void main(String[] args) {
		int n = 6;
		int w[] = {2,3,1,4,6,5};
		int v[] = {5,6,5,1,19,7};
		int C = 10;
		int x[] = new int[n+1];
		getResult(n,w,v,x,C);
	}
}
