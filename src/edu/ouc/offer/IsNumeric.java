package edu.ouc.offer;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。 
 * 
 * @author wqx
 *
 */
public class IsNumeric {
    public static boolean isNumeric(char[] str) {
        if(str == null ) return false;
        String s = new String(str);
        if(s.matches("^[-|+]?\\d{1,}$") || s.matches("^([-|+]?\\d{1,}|[-|+]?\\d{1,}\\.\\d{1,})[e|E][+|-]?\\d{1,}$") || s.matches("(^[-|+]?\\d{1,}\\.\\d*$|^[-|+]?\\d*\\.\\d{1,}$)")){
        	return true;
        }else {
        	return false;
        }
    }
    public static void main(String[] args){
    	String[] str1 = {"+100","5e2","-123","3.1416","-1E-16"};
    	String[] str2 = {"12e","1a3.14","1.2.3","+-5","12e+4.3"};
    	
    	System.out.println(str1[0].matches("^[-|+]?\\d$"));
    			
    	for(int i = 0; i < str1.length; i++){
    		System.out.println(str1[i] + ":" + isNumeric(str1[i].toCharArray()));
    	}
    	System.out.println();
    	for(int i = 0; i < str2.length; i++){
    		System.out.println(str2[i] + ":" + isNumeric(str2[i].toCharArray()));
    	}
    }
}
