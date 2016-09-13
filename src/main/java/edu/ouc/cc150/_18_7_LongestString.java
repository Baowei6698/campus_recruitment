package edu.ouc.cc150;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ��Ŀ����
��һ�鵥�ʣ����дһ���������������ҳ����������ַ�����ɵ���Ĵ�A��
��A��������������ɵ�(���ظ�)��ĵ��ʡ�

����һ��string����str��ͬʱ��������Ĵ�Сn���뷵������ʵĳ��ȣ���֤��������������ʴ��ڡ�
����������

["a","b","c","ab","bc","abc"],6

���أ�3

 * @author wqx
 *
 */
public class _18_7_LongestString {

	/**
	 * ˼·���ҳ�A��A�������������ַ�ƴ�Ӷ��ɣ����ظ�����
	 * 1.���������ַ��������ȵݼ�����
	 * 2.����ÿ��Ԫ�أ����統ǰԪ��s����s��һ��Ԫ�ؿ�ʼ���ҵ�һ��str��ʹ��s.startWith(str) == true
	 * 3.�õ��ַ���sub,subΪs��ȥstr�ĺ�벿
	 * 4.��sub�ظ�2,3������
	 * 5.��subΪ���ַ���ʱ�������ɹ��ҵ�Ŀ��Ԫ���ˡ�
	 * 
	 * ��ʵ�����Ͼ���һ���ݹ���ҵĹ���
	 * 
	 * @param str
	 * @param n
	 * @return
	 */
	public int getLongest(String[] str, int n) {

		Arrays.sort(str,new Comparator<String>(){
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});
		for(int i = 0; i < n; i++){
			if(dfs(str,str[i],i,n-1)){
				return str[i].length();
			}
		}
		return -1;
	}
	public boolean dfs(String[] str,String s,int start, int end){
		if("".equals(s)){
			return true;
		}
		boolean res = false;
		for(int i = start+1; i <= end; i++){
			if(s.startsWith(str[i])){
				res = dfs(str,s.substring(str[i].length()),start,end);
				if(res)return true;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String[] str = {"rb","erb","rbe","e","g","mcxr"};
		int n = 6;
		System.out.println("res:" + new _18_7_LongestString().getLongest(str, n));
	}

}
