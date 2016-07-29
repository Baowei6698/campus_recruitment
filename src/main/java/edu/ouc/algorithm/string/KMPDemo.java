package edu.ouc.algorithm.string;

import java.util.Arrays;

public class KMPDemo {

	public static void kmp(String str,String substr){
		int [] next = new int[substr.getBytes().length];
		next = getNext(substr);
		System.out.println("next:" + Arrays.toString(next));
		int m = substr.length();
		int len = str.length();
		for(int i = 0,q = 0; i < len; i++){
			while(q > 0 && str.charAt(i) != substr.charAt(q)){
				q = next[q-1];
			}
			if(str.charAt(i) == substr.charAt(q))
				q++;
			if(q == m){
				System.out.println("�ɹ�ƥ�䣡 ��һ��ƥ��λ�ã�" + (i-m+1));
			}
		}
	}
	public static int[] getNext(String b)  
    {  
        int len=b.length();  
        int i = 1,j=0;  
        int next[]=new int[len+1];//next��ʾ����Ϊi���ַ���ǰ׺�ͺ�׺����������֣���1��ʼ
        next[0]= 0;
        
        while(i < len)
        {  
            if(j == 0 || b.charAt(i) == b.charAt(j)){
            	next[i] = j;
            	j++;i++;
            }else{
            	j = next[j];
            }
        }
        return next;
    }
	public static void getNext1(String str,int next[]){
		int len = str.length();
		
		int q,k;//q��str�±꣬kΪ���ǰ��׺����
		next[0] = 0;
		for(q = 1,k = 0;q < len; q++){
			while(k > 0 && str.charAt(q) != str.charAt(k)){
				k = next[k-1];
			}
			if(str.charAt(q) == str.charAt(k)){
				k++;
			}
			next[q] = k;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "ABAABAB";
		String substr = "abaabc";
		kmp(str,substr);
	}
}
