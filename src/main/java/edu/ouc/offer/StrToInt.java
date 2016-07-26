package edu.ouc.offer;

import java.util.regex.Pattern;


/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 
 * 
 * @author wqx
 *
 */
public class StrToInt {
	/**
	 * 通过正则表达式匹配数字，注意可能带符号（+,-）
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
