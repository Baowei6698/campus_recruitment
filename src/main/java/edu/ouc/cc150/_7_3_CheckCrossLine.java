package edu.ouc.cc150;

import java.math.BigDecimal;

/**
 * 判断直线相交
 * 
题目描述

给定直角坐标系上的两条直线，确定这两条直线会不会相交。

线段以斜率和截距的形式给出，即double s1，double s2，double y1，double y2，
分别代表直线1和2的斜率(即s1,s2)和截距(即y1,y2)，请返回一个bool，代表给定的两条直线是否相交。这里两直线重合也认为相交。
测试样例：

3.14,1,3.14,2

返回：false



 * @author wqx
 *
 */
public class _7_3_CheckCrossLine {
	
	/**
	 * y = kx + c
	 * 
	 * @param s1
	 * @param s2
	 * @param y1
	 * @param y2
	 * @return
	 */
    public boolean checkCrossLine(double s1, double s2, double y1, double y2) {
        if(s1 == s2 && Math.abs(y1-y2) <= 0.00000001){
        	return false;
        }
        return true;
    }
	public static void main(String[] args) {
		BigDecimal dec = null;
	}

}
