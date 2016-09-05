package edu.ouc.algorithm.dp;

/**
 * 1. 最长公共子串
 * 找两个字符串的最长公共子串，这个子串要求在原字符串中是连续的。
 * 
 * 2. 最长公共子序列
 * 找两个字符串的最长公共子序列，这个子序列要求在原字符串中不一定连续。
 * 
 * @author wqx
 *
 */
public class LCS {

	/**
	 * 最长公共子串（连续的）
	 * 
	 * @param arr
	 * @param n
	 */
	public void LCSI(String s1,String s2){
		int n = s1.length(), m = s2.length();
		int[][] dp = new int[n][m];
		int maxLen = 0, pos = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(s1.charAt(i) == s2.charAt(j)){
					if(i > 0 && j > 0){
						dp[i][j] = dp[i-1][j-1] + 1;
					}else{
						dp[i][j] = 1;
					}
					if(maxLen < dp[i][j]){
						maxLen = dp[i][j];
						pos = i;
					}
				}else{
					dp[i][j] = 0;
				}
			}
		}
		StringBuilder sb = new StringBuilder(0);
		int i = maxLen;
		while(i > 0){
			sb.append(s1.charAt(pos));
			pos--;i--;
		}
		System.out.println("maxLen:" + maxLen + ",res:" + sb.toString());
	}
	
	/**
	 * 最长公共子序列
	 * 
	 * @param s1
	 * @param s2
	 */
	public void LCSII(String s1,String s2){
		int n = s1.length(), m = s2.length();
		int[][] dp = new int[n+1][m+1];
		int maxLen = 0;
		
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j ++){
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + 1;
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println("maxLen:" + dp[s1.length()][s2.length()]);
		//输出LCS
		StringBuilder sb = new StringBuilder(0);
		int pos1 = s1.length(), pos2 = s2.length();
		while(pos1 > 0 && pos2 > 0){
			if(s1.charAt(pos1-1) == s2.charAt(pos2-1)){
				sb.append(s1.charAt(pos1-1));
				pos2--;pos1--;
			}else if(dp[pos1][pos2-1] >= dp[pos1-1][pos2]){
				pos2--;
			}else{
				pos1--;
			}
		}
		System.out.println("lcs:" + sb.reverse().toString());
	}
	public static void main(String[] args) {
		String s1 = "babdcac";
		String s2 = "cabffdfda";
		new LCS().LCSII(s1, s2);
	}

}
