package edu.ouc.cc150;

import java.util.HashMap;
import java.util.Map;

/**
 * ��Ŀ����

��ʵ��һ���㷨��ȷ��һ���ַ����������ַ��Ƿ�ȫ����ͬ����������Ҫ������ʹ�ö���Ĵ洢�ṹ��

����һ��string iniString���뷵��һ��boolֵ,True���������ַ�ȫ����ͬ��False���������ͬ���ַ���
��֤�ַ����е��ַ�ΪASCII�ַ����ַ����ĳ���С�ڵ���3000��
����������

"aeiou"

���أ�True

"BarackObama"

���أ�False

 * @author wqx
 *
 */
public class _1_1_CheckDifferentChar {
	
	/**
	 * ����HashMap
	 * 
	 * @param iniString
	 * @return
	 */
    public boolean checkDifferent(String iniString) {
    	Map<Character,Integer> map = new HashMap<>();
    	for(int i = 0; i < iniString.length(); i++){
    		if(map.get(iniString.charAt(i)) != null){
    			return false;
    		}else{
    			map.put(iniString.charAt(i), 1);
    		}
    	}
    	return true;
    }
    
    /**
     * ����������ʽ
     * 
     * @param iniString
     * @return
     */
    public static boolean checkDifferent2(String iniString){
    	return !iniString.matches(".*(.)(.*\\1).*");
    }
	public static void main(String[] args) {
		System.out.println("result:" + checkDifferent2("nihnao"));
	}

}
