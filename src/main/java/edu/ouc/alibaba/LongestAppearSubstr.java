package edu.ouc.alibaba;

import java.util.Scanner;

/**
 * ��Ŀ����
����һ�� query ��һ�� text,����Сд��ĸ��ɡ�Ҫ���� text ���ҳ���ͬ����˳���� �������� query �е��������ĸ���еĳ��ȡ�
����, query Ϊ��acbac��,text Ϊ ��acaccbabb��,��ô text �еġ�cba��Ϊ������������� query �е���ĸ����,
���, ���ؽ��Ӧ��Ϊ�䳤�� 3����ע�����Ч�ʡ�

 * @author wqx
 * 
 */
public class LongestAppearSubstr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String query,text;
		while(in.hasNext()){
			query = in.next();
			text = in.next();
			System.out.println("maxLength:" + maxLength(query,text));
		}
	}
	public static int maxLength(String query,String text){
		int maxLen = 0;
		boolean flag;
		
		for(int i = 0; i < query.length(); i++){
			flag = false;
			for(int j = query.length(); j > i; j--){
				String sub = query.substring(i,j);
				if(text.contains(sub)){//��һ���ҵ����ض�����query[i]��ͷ���ַ���������Ӵ�
					flag = true;
					maxLen = maxLen > sub.length() ? maxLen : sub.length();
				}
				if(flag){
					break;
				}
			}
		}
		return maxLen;
	}
}
