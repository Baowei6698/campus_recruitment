package edu.ouc.offer;

/**
 * �����������һ����λָ�����ѭ�����ƣ�ROL����
 * �����и��򵥵����� * �������ַ���ģ�����ָ�����������
 * ����һ���������ַ�����S���������ѭ������Kλ������������
 * �� * �磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ����
 * ����XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨���� 
 * 
 * @author wqx
 *
 */
public class RotateString {
	public String LeftRotateString(String str,int n) {
		if(str == null || str.length() == 0)return "";
		if(n > str.length()){
			n %= str.length();
		}
		return reverse(reverse(str.substring(0,n))+reverse(str.substring(n)));
	}
	public String reverse(String str){
		return new StringBuilder(str).reverse().toString();
	}
}
