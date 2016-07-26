package edu.ouc.xiaomi;

/**
 * 
��Ŀ����
��������2���ˣ�һ�ֶ������ƣ�һ�ֲ�������ô��֪������int32����m��n�Ķ����Ʊ�
�ж��ٸ�λ(bit)��ͬô��

��������:
1999 2299

�������:
7

 * @author wqx
 *
 */
public class CountBitDiff {
    /**
     * ����������ζ����Ʊ��λ����ͬ������
     * 
     * ˼·��
     * ѭ�����ƣ��÷���λ���ж�
     * 
     * ���˿��ǿ���Ϊ0�����������
     * �����һ����Ϊ0����ֱ�Ӽ�����һ�����Ķ����Ʊ�ʾ�ж��ٸ�1�Ϳ��ԡ�
     * 
     * @param m ����m
     * @param n ����n
     * @return ����
     */
    public static int countBitDiff(int m, int n) {
    	
    	if(m == 0)
    		return getBit(n);
    	if(n == 0)
    		return getBit(m);
    	int count = 0;
    	for(int i = 1; i <= 32; i++){
    		/*
    		 * ѭ������iλ
    		 */
    		int t_m = (m>>i|m<<(32-i));
    		int t_n = (n>>i|n<<(32-i));
    		
    		if((t_m > 0 && t_n < 0) || (t_m < 0 && t_n > 0)){
    			count++;
    			//System.out.println("m:" + t_m + ",n:" + t_n);
    		}
    	}
    	return count;
    }
    /**
     * n�Ķ����Ʊ�ʾ�ж��ٸ�1
     * @param n
     * @return
     */
    public static int getBit(int n){
    	int count = 0;
    	while(n!=0){
    		n &= (n-1);
    		count++;
    	}
    	return count;
    }
    public static void main(String []args){
    	int m = 0,n = 2299;
    	
    	System.out.println(countBitDiff(m,n));
    }
}
