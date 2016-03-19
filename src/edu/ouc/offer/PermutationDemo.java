package edu.ouc.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * ��Ŀ����
����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С����������ַ���abc,
���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba�� 
����밴��ĸ˳�������

��������:

����һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ��

 * @author wqx
 *
 */
public class PermutationDemo {
    public ArrayList<String> Permutation(String str) {
    	if(str == null || "".equals(str)) return new ArrayList<String>(0);
        Set<String> result = new TreeSet<String>();
        nextPermutation(result,str.toCharArray(),0);
        return new ArrayList<String>(result);
    }
    public void nextPermutation(Set<String> result,char[] str,int cur){
    	if(cur == str.length){
    		result.add(new String(str));
    		return ;
    	}
    	for(int i = cur; i < str.length; i++){
    		swap(str,i,cur);
    		nextPermutation(result,str,cur+1);
    		swap(str,i,cur);	
    	}
    }
    public void swap(char[]str,int i,int j){
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }
}
