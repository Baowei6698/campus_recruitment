package edu.ouc.netease;

import java.util.Scanner;

public class NetEaseDemo1 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		String str1,str2;
		while(in.hasNext()){
			str1 = in.next();
			str2 = in.next();
			LCS(str1,str2);
		}
	}
	static void LCS(String str1, String str2)  
	{
		
	    int len1,len2,posX,posY;
	    len1 = str1.length();
	    len2 = str2.length();
	    //结果集，str1.substring(result[0][0],result[0][1];
	    int[][] result = new int[len1+len2][2];
	    int count = 0;//结果个数
	    
	    int [][]dp = new int[len1+1][len2+1];  
	    for(int i = 0; i < len1+1; i++)  
	        dp[i][0]=0;
	    for(int j = 0; j < len2+1; j++)
	        dp[0][j]=0;
	    int maxLen = -1;
	    for(int i = 1; i < len1+1; i++)  
	    {
	        for(int j = 1; j < len2+1; j++)
	        {  
	            if(str1.charAt(i-1) == str2.charAt(j-1))  
	                dp[i][j] = dp[i-1][j-1]+1;
	            else  
	                dp[i][j]=0;
	            if(dp[i][j] > maxLen)
	            {
	                maxLen=dp[i][j];
	                result[0][0] = i;
	                result[0][1] = j;
	                count = 1;//更新最值，count=1
	            }else  if(dp[i][j] == maxLen && maxLen != 0){
	            	result[count][0] = i;
	            	result[count][1] = j;
	            	count++;
	            }
	        }
	    }
	    for(int i = 0; i < count; i++){
	    	System.out.println(str1.substring(result[i][0]-maxLen,result[i][0]));
	    }
	}  
}
