package edu.ouc.QH360;

import java.util.Scanner;

/**
 * Problem Description:
СB����������ַ�����������������˸��ִ���ʽ���������ַ��������ԡ����Ҳ�����⣬��������һ���µ��ַ��û���ʽ��
СB�о����ַ�����ASCII����ĸ�͡�.�����ɣ���ε��о������ǡ�.���������ĵĶ������ַ����г��ֵ�����������.����
��ÿ�β����������ʼ������������.����һ����.�����������Խ�����f(s) ����Ϊʹ�ô��в���������������.������С�û�������
�ֿ���m���ַ��滻������ÿ�ν�ָ��λ�õ��ַ��滻Ϊ�������ַ������滻����f(s)��ֵ��

����
�����������飬ÿ��ĵ�һ��Ϊ��������n��m��1<= n,m<=300000����ʾ�ַ����ĳ��Ⱥ��ַ��滻�����Ĵ�����
�ڶ���Ϊ�������ַ�����������m�в�����ÿ����һ��������x��һ����ĸc���ɣ���ʾ���ַ�����λ��m�����ַ��û�Ϊ��ĸc��
���
��ÿ�������ÿ���û��������ڵ����������������f(s)�Ľ��

��������
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
�������
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
