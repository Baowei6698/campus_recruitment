package edu.ouc.offer;

/**
 * 
��Ŀ����
��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ�
�������鳤�ȵ�һ�룬������2����������������0��

 * @author wqx
 *
 */
public class MoreThenHalfNumInArray {
    public int MoreThanHalfNum_Solution(int [] array) {
        int k = 0,j = 0;
        for(int i = 0; i < array.length; i++){
        	if(j == 0){
        		k = array[i];
        	}
        	if(array[i] == k){
        		j++;
        	}else{
        		j--;
        	}
        }
        int counts = 0;
        for(int i = 0; i < array.length; i++){
        	if(k == array[i]){
        		counts++;
        	}
        }
        if(counts > array.length/2){
        	return k;
        }else{
        	return 0;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
