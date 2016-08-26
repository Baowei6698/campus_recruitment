package edu.ouc.cc150;

/**
 * 
题目描述

有数量不限的硬币，币值为25分、10分、5分和1分，请编写代码计算n分有几种表示法。

给定一个int n，请返回n分有几种表示法。保证n小于等于100000，为了防止溢出，请将答案Mod 1000000007。
测试样例：

6

返回：2

 * @author wqx
 *
 */
public class _9_8_Coins {

	/**
	 * dp[sum]:sum分的表示方法
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
