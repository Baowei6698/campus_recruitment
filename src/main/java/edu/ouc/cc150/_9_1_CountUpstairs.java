package edu.ouc.cc150;

/**
 * ��Ŀ����

�и�С��������¥�ݣ�¥����n��̨�ף�С��һ�ο�����1�ס�2�ס�3�ס���ʵ��һ������������С���ж�������¥�ķ�ʽ��
Ϊ�˷�ֹ������뽫���Mod 1000000007

����һ��������int n���뷵��һ������������¥�ķ�ʽ������֤nС�ڵ���100000��
����������

1

���أ�1

 * @author wqx
 *
 */
public class _9_1_CountUpstairs {
	/**
	 * ����
	 * f(n) = f(n-1) + f(n-2) + f(n-3)
	 * 
	 * �ռ����� 32M
	 * 
	 * @param n
	 * @return
	 */
    public static int countWays(int n) {
    	if(n <= 0) return 0;
    	int f1,f2,f3;
    	if(n == 1) 
    		return 1;
    	if(n == 2) 
    		return 2;
    	if(n == 3) 
    		return 4;
    	f1 = 1;f2 = 2; f3 = 4;
    	int res = 0;    	
    	for(int i = 4; i <= n; i ++){
    		res = (((f1 + f2) % 1000000007) + f3)%1000000007;
    		f1 = f2;
    		f2 = f3;
    		f3 = res;
    	}
    	return res;
    }
    
	/**
	 * �ݹ��㷨    StackOverflowError
	 * 
	 * @param n
	 * @return
	 */
    public static int countWays2(int n) {
    	if(n <= 0) return 0;
    	if(n == 1) return 1;
    	return (countWays2(n-1) % 1000000007 + countWays2(n-2) % 1000000007  + countWays2(n-3) % 1000000007) % 1000000007;
    }
    
	public static void main(String[] args) {
		System.out.println(countWays(122333));
	}

}
