package edu.ouc.QH360;

import java.util.Scanner;

/**
 * Problem Description:
小B最近迷上了字符串处理技术，他设计了各种处理方式，并计算字符串的属性。这次也不例外，他定义了一种新的字符置换方式。
小B研究的字符串由ASCII码字母和“.”构成，这次的研究对象是“.”。他关心的对象是字符串中出现的连续两个“.”。
若每次操作把其中最开始的连续两个“.”以一个“.”替代，则可以将函数f(s) 定义为使得串中不出现连续两个“.”的最小置换次数。
现考虑m个字符替换操作，每次将指定位置的字符替换为给定的字符，求替换后函数f(s)的值。

输入
输入有若干组，每组的第一行为两个整数n和m，1<= n,m<=300000，表示字符串的长度和字符替换操作的次数。
第二行为所给的字符串，随后紧跟m行操作，每行由一个正整数x和一个字母c构成，表示将字符串中位置m处的字符置换为字母c。
输出
对每组输入的每个置换操作，在单独的行中输出函数f(s)的结果

样例输入
10 3
.b..bz....
1 h
3 c
9 f
4 4
.cc.
2 .
3 .
2 a
1 a
样例输出
4
3
1
1
3
1
1

 * @author Administrator
 *
 */
public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str;
		while(in.hasNext()){
			int n = in.nextInt();
			int m = in.nextInt();
			
			str = in.next();
			int i = 0;
			
			while(i < m){
				int x = in.nextInt();
				String c = in.next();
				str = str.substring(0,x-1) + c + str.substring(x);
				System.out.println(f(str));
				i++;
			}
		}
	}
	public static int f(String str){
		int result = 0;
		int i = 0,len = str.length();
		while(i < len){
			if('.' == str.charAt(i)){
				int tmp = i+1;
				while(tmp < len && str.charAt(tmp) == '.')tmp++;
				result += (tmp - i -1);
				if(tmp == len)break;
				i = tmp;
			}else{
				i++;
			}
		}
		return result;
	}
}
