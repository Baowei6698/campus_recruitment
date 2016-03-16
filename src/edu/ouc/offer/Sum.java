package edu.ouc.offer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、
 * if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 
 *  
 * @author wqx
 *
 */
public class Sum {
	/**
	 * 啥循环不能用，只能递归实现了。。。
	 * 
	 * @param n
	 * @return
	 */
    public int Sum_Solution(int n) {
    	if(n == 0)return 0;
    	if(n == 1) return 1;
       return n + Sum_Solution(n-1);
    }
}
