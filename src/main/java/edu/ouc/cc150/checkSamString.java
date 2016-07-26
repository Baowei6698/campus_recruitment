package edu.ouc.cc150;

import java.util.Arrays;

/**
 * ��Ŀ����

���������ַ��������д����ȷ������һ���ַ������ַ��������к��ܷ�����һ���ַ���������涨��СдΪ��ͬ�ַ����ҿ����ַ����ص�ո�

����һ��string stringA��һ��string stringB���뷵��һ��bool�����������Ƿ��������к����ͬ����֤�����ĳ��ȶ�С�ڵ���5000��
����������

"This is nowcoder","is This nowcoder"

���أ�true

"Here you are","Are you here"

���أ�false

 * @author wqx
 *
 */
public class checkSamString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * ����һ�������ַ���תΪ�ֽ����飬�����������Ƿ����
	 * 
	 * ʱ�临�Ӷ�O(nlogn)
	 * 
	 * @param stringA
	 * @param stringB
	 * @return
	 */
    public boolean checkSam(String stringA, String stringB) {
        
        int lenA = stringA.length();
        int lenB = stringB.length();
        if(lenA != lenB) return false;
        
        byte[] byteA = stringA.getBytes();
        byte[] byteB = stringB.getBytes();
        
        Arrays.sort(byteA);
        Arrays.sort(byteB);
        
        for(int i = 0; i < lenA; i++){
        	if(byteA[i] != byteB[i]){
        		return false;
        	}
        }
        return true;
    }
    
    /**
     * ���������Ƚ����ַ�����ÿ���ַ����ֵĴ������������ͬ����һ������������õ��Է���
     * ʱ�临�Ӷ�O(n)
     * �ռ临�Ӷ�O(1)
     * 
     * @param stringA
     * @param stringB
     * @return
     */
    public boolean checkSam2(String stringA, String stringB) {
        int lenA = stringA.length();
        int lenB = stringB.length();
        if(lenA != lenB) return false;
        
        int[] a = new int[256];
        int[] b = new int[256];
        
        for(int i = 0; i < lenA; i++){
        	a[stringA.charAt(i)]++;
        }
        for(int i = 0; i < lenB; i++){
        	b[stringB.charAt(i)]++;
        }
        for(int i = 0; i < 256; i++){
        	if(b[i] != a[i]){
        		return false;
        	}
        }
        return true;
    }
}
