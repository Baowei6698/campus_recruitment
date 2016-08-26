package edu.ouc.cc150;

/**
 * 
��Ŀ����

���������޵�Ӳ�ң���ֵΪ25�֡�10�֡�5�ֺ�1�֣����д�������n���м��ֱ�ʾ����

����һ��int n���뷵��n���м��ֱ�ʾ������֤nС�ڵ���100000��Ϊ�˷�ֹ������뽫��Mod 1000000007��
����������

6

���أ�2

 * @author wqx
 *
 */
public class _9_8_Coins {

	/**
	 * dp[sum]:sum�ֵı�ʾ����
	 * 
	 * @param n
	 * @return
	 */
	public static int countWays(int n) {
		int coins[] = {1,5,10,25};
		int dp[] = new int[100001];
		dp[0] = 1;
		for(int k = 0; k < coins.length; k++){
			for(int i = coins[k]; i <= n; i++){
				dp[i] = (dp[i] + dp[i - coins[k]])% 1000000007;
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 6;
		System.out.println(countWays(n));
	}

}
