package edu.ouc.algorithm.dp;

/**
 * 1. ������Ӵ�
 * �������ַ�����������Ӵ�������Ӵ�Ҫ����ԭ�ַ������������ġ�
 * 
 * 2. �����������
 * �������ַ���������������У����������Ҫ����ԭ�ַ����в�һ��������
 * 
 * @author wqx
 *
 */
public class LCS {

	/**
	 * ������Ӵ��������ģ�
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
	public static void main(String[] args) {
		String s1 = "babac";
		String s2 = "cabadfd";
		new LCS().LCSI(s1, s2);
	}

}
