package edu.ouc.cc150;

/**
 * 题目描述

有一个介于0和1之间的实数，类型为double，返回它的二进制表示。如果该数字无法精确地用32位以内的二进制表示，
返回“Error”。

给定一个double num，表示0到1的实数，请返回一个string，代表该数的二进制表示或者“Error”。
测试样例：

0.625

返回：0.101

 * @author wqx
 *
 */
public class _5_2_DoubleToBinary {

	/**
	 * double*2,取整
	 * 
	 * @param num
	 * @return
	 */
	public static String printBin(double num) {
		StringBuilder sb = new StringBuilder("");
		do{
			if(sb.length() == 32){
				return "Error";
			}
			double tmp = num * 2;
			sb.append((int)tmp);
			num = tmp - (int)tmp;
		}while(num != 0);
		
		return "0." + sb.toString();
	}
	public static void main(String[] args) {
		double num = 0.03125;
		System.out.println("res:" + printBin(num));
		
	}
	public void intToBinary(int a){
		char[] buf = new char[32];
		int pos = 32;
		int radix = 2;
		do{
			buf[--pos] = (char) ('0' + a % radix);
			a /= radix;
		}while(a != 0);
		String res = new String(buf,pos,(32-pos));
		System.out.println("a:" + res);
	}
}
