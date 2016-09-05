package edu.ouc.algorithm.dp;

/**
 *  要想把字符串S1变成S2，可以经过若干次下列原子操作：

1.删除一个字符

2.增加一个字符

3.更改一个字符

字符串S1和S2的编辑距离定义为从S1变成S2所需要原子操作的最少次数。

 * @author wqx
 *
 */
public class StrEditLength {
	
	public void editLength(String s1, String s2){
		int n = s1.length(), m = s2.length();
		int dp[][] = new int[n+1][m+1];
		for(int i = 1; i <= n; i++){
			dp[i][0] = i;
		}
		for(int i = 1; i <= m; i++){
			dp[0][i] = i;
		}
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j++){
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = Math.min(1+dp[i-1][j-1], 1 + Math.min(dp[i-1][j], dp[i][j-1]));
				}
			}
		}
		System.out.println(dp[n][m]);
	}
	public static void main(String[] args) {
		String s1 = "cabcfe";
		String s2 = "abcef";
		new StrEditLength().editLength(s1, s2);
	}

}
