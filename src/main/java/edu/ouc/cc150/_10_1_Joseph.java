package edu.ouc.cc150;

import java.util.Arrays;

/**
 * 
��Ŀ����

Լɪ��������һ���ǳ�������Ȥ�⣬����n��������һȦ����˳ʱ����1��ʼ�����Ǳ�š�
Ȼ���ɵ�һ���˿�ʼ����������m���˳��֡�������Ҫ��������һ�����ֵ��˵ı�š�

��������int n��m��������Ϸ���������뷵�����һ�����ֵ��˵ı�š���֤n��mС�ڵ���1000��
����������

5 3

���أ�4



 * @author wqx
 *
 */
public class _10_1_Joseph {

    public static int getResult(int n, int m) {
    	int arr[] = new int[n];
    	int remain = n;
    	int step = 1, i = 0;
    	while(remain > 1){
    		if(step == m && arr[i] == 0){
    			arr[i] = 1;
    			step = 1;
    			remain--;
    		}else if(arr[i] == 0){
    			step++;
    		}
    		i = (i+1) % n;
    		System.out.println(Arrays.toString(arr));
    	}
    	for(i = 0; i < n; i++){
    		System.out.print(arr[i] + " ,");
    		if(arr[i] == 0)
    			return i+1;
    	}
    	return 0;
    }
    
	public static void main(String[] args) {
		int n = 5;
		int m = 3;
		System.out.println(getResult(n,m));
	}

}
