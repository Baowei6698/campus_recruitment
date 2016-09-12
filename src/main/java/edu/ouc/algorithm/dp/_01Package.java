package edu.ouc.algorithm.dp;

import java.util.Scanner;

/**
 * �б�ŷֱ�Ϊa,b,c,d,e�������Ʒ��
 * ���ǵ������ֱ���2,2,6,5,4��
 * ���ǵļ�ֵ�ֱ���6,3,5,4,6��
 * ���ڸ��������Ϊ10�ı���������ñ�����װ�����Ʒ�������ļ�ֵ�ܺͣ�
 * 
 * 01������״̬ת������ f[i,j] = Max{ f[i-1,j-Wi]+Pi( j >= Wi ),  f[i-1,j] }
 * 
 * @author wqx
 *
 */
public class _01Package {

	/**
	 * 
	 * @param n ��Ʒ����
	 * @param w w[i]����i����Ʒ������
	 * @param v v[i]����i����Ʒ�ļ�ֵ
	 * @param x x[i]����i����Ʒ�Ƿ�ѡ��
	 * @param C ����������
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
			if(dp[i][j] > dp[i-1][j])//��i����Ʒ��ѡ��
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
