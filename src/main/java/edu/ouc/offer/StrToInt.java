package edu.ouc.offer;

import java.util.regex.Pattern;


/**
 * ��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� 
 * 
 * @author wqx
 *
 */
public class StrToInt {
	/**
	 * ͨ��������ʽƥ�����֣�ע����ܴ����ţ�+,-��
	 * 
	 * @param str
	 * @return
	 */
    public static int StrToInt(String str) {
    	if(str == null || "".equals(str.trim())) return 0;
    	if(str.matches("^[-|+]?\\d{1,}$")){
    		return Integer.parseInt(str);
    	}else{
    		return 0;
    	}
    }
    public static void main(String[] args){
    	String str = "-133";
    	System.out.println(StrToInt(str));
    }
}
