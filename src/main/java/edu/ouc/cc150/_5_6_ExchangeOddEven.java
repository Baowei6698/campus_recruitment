package edu.ouc.cc150;


/**
 * ��żλ����
 * 
��Ŀ����

���д���򽻻�һ�����Ķ����Ƶ�����λ��ż��λ����ʹ��Խ�ٵ�ָ��Խ�ã�

����һ��int x���뷵�ؽ��������int��
����������

10

���أ�5

 * @author wqx
 *
 */
public class _5_6_ExchangeOddEven {
	
    public static int exchangeOddEven(int x) {
        int evenVal = (x & 0xAAAAAAAA);
        int oddVal = (x & 0x55555555);
        return (oddVal << 1) + (evenVal >> 1)&0x7fffffff;
    }
    
    public static void main(String args[]){
    	System.out.println(exchangeOddEven(10));
    }
}
